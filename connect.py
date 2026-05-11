"""
Huawei Band 10 BLE connector — Gadgetbridge-aligned handshake (HiChain3).

Handshake flow for Band 10 (deviceSupportType=4, authType=5):
  1. Link Params
  2. Security Negotiation  → discovers authType=HiChain3
  3. PIN Code              → band returns encrypted PIN (user confirms on device)
  4. HiChain3 auth (4 steps, JSON over sliced BLE, HMAC/HKDF/AES-GCM)
  5. Device is now authenticated; subsequent runs skip steps 3-4

HiChain3 step summary:
  Step 1  →  send {seed, randSelf, peerAuthId=ourId}
  Step 1  ←  get  {isoSalt=randPeer, peerAuthId=bandId, token=HMAC(psk,…)}
  Step 2  →  send {token=HMAC(psk,…)}
  Step 2  ←  get  {returnCodeMac=HMAC(psk, 0x00000000)}
  Step 3  →  send {nonce, encData=AES-GCM(challenge, sessionKey, nonce, aad)}   [first-auth only]
  Step 3  ←  get  {nonce, encAuthToken} → decrypt → secretKey for future use
  Step 4  →  send {nonce, encResult=AES-GCM(0x00000000, sessionKey, nonce, aad)}
  Step 4  ←  OK
"""
import asyncio
import binascii
from collections import deque
import hashlib
import hmac as _hmac
import json
import logging
import secrets
import struct
import time
from configparser import ConfigParser
from pathlib import Path

from bleak import BleakClient
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding as _padding
from cryptography.hazmat.primitives.ciphers.aead import AESGCM
from cryptography.hazmat.primitives.kdf.hkdf import HKDF
from cryptography.hazmat.primitives import hashes

logging.basicConfig(level=logging.DEBUG,
                    format="%(asctime)s [%(levelname)s] %(name)s: %(message)s")
logger = logging.getLogger("band10")

# ── BLE UUIDs & constants ─────────────────────────────────────────────────────
DEVICE_MAC  = "88:8E:68:A2:E4:4F"
CLIENT_MAC  = "FF:FF:FF:A9:F0:23"   # random fake MAC (like Gadgetbridge)
CONFIG_FILE = Path("band.ini")

GATT_WRITE  = "0000fe01-0000-1000-8000-00805f9b34fb"
GATT_READ   = "0000fe02-0000-1000-8000-00805f9b34fb"
MAGIC       = 0x5A

# Service / command IDs
SVC_DEV     = 0x01
SVC_FITNESS = 0x07
CMD_LINK    = 0x01
CMD_AUTH    = 0x13
CMD_BOND    = 0x0E
CMD_BPARAMS = 0x0F
CMD_SECNEGO = 0x33
CMD_PINCODE = 0x2C
CMD_HICHAIN = 0x28

# Crypto constants (same across all Gadgetbridge / huawei-lpv2 builds)
DIGEST_SECRETS = {
    1: bytes([0x70,0xFB,0x6C,0x24,0x03,0x5F,0xDB,0x55,0x2F,0x38,0x89,0x8A,0xEE,0xDE,0x3F,0x69]),
    2: bytes([0x93,0xAC,0xDE,0xF7,0x6A,0xCB,0x09,0x85,0x7D,0xBF,0xE5,0x26,0x1A,0xAB,0xCD,0x78]),
    3: bytes([0x9C,0x27,0x63,0xA9,0xCC,0xE1,0x34,0x76,0x6D,0xE3,0xFF,0x61,0x18,0x20,0x05,0x53]),
}
SECRET_KEY_1 = {
    1: bytes([0x6F,0x75,0x6A,0x79,0x6D,0x77,0x71,0x34,0x63,0x6C,0x76,0x39,0x33,0x37,0x38,0x79]),
    2: bytes([0x55,0x53,0x86,0xFC,0x63,0x20,0x07,0xAA,0x86,0x49,0x35,0x22,0xB8,0x6A,0xE2,0x5C]),
    3: bytes([0x55,0x53,0x86,0xFC,0x63,0x20,0x07,0xAA,0x86,0x49,0x35,0x22,0xB8,0x6A,0xE2,0x5C]),
}
SECRET_KEY_2 = {
    1: bytes([0x62,0x31,0x30,0x6A,0x67,0x66,0x64,0x39,0x79,0x37,0x76,0x73,0x75,0x64,0x61,0x39]),
    2: bytes([0x33,0x07,0x9B,0xC5,0x7A,0x88,0x6D,0x3C,0xF5,0x61,0x37,0x09,0x6F,0x22,0x80,0x00]),
    3: bytes([0x33,0x07,0x9B,0xC5,0x7A,0x88,0x6D,0x3C,0xF5,0x61,0x37,0x09,0x6F,0x22,0x80,0x00]),
}
GROUP_ID = "7B0BC0CBCE474F6C238D9661C63400B797B166EA7849B3A370FC73A9A236E989"

# ── Packet framing ────────────────────────────────────────────────────────────

def tlv_enc(tag: int, value: bytes = b"") -> bytes:
    return bytes([tag]) + varint_enc(len(value)) + value

def varint_enc(value: int) -> bytes:
    """Huawei TLV length VarInt: big-endian 7-bit groups, high bit continues."""
    if value < 0:
        raise ValueError("negative TLV length")
    groups = [value & 0x7F]
    value >>= 7
    while value:
        groups.append((value & 0x7F) | 0x80)
        value >>= 7
    return bytes(reversed(groups))

def varint_dec(data: bytes, offset: int) -> tuple[int, int]:
    result = 0
    i = offset
    while True:
        if i >= len(data):
            raise ValueError("truncated TLV VarInt")
        b = data[i]
        i += 1
        result += b & 0x7F
        if (b & 0x80) == 0:
            return result, i
        result <<= 7

def tlv_dec(data: bytes) -> dict:
    out, i = {}, 0
    while i < len(data):
        tag = data[i]; i += 1
        if i >= len(data) and tag == 0:
            break
        ln, i = varint_dec(data, i)
        if i + ln > len(data):
            raise ValueError(f"TLV length {ln} exceeds remaining {len(data) - i}")
        out[tag] = data[i:i+ln]; i += ln
    return out

def tlv_items(data: bytes) -> list[tuple[int, bytes]]:
    """Decode TLVs while preserving duplicate tags such as repeated containers."""
    out, i = [], 0
    while i < len(data):
        tag = data[i]; i += 1
        if i >= len(data) and tag == 0:
            break
        ln, i = varint_dec(data, i)
        if i + ln > len(data):
            raise ValueError(f"TLV length {ln} exceeds remaining {len(data) - i}")
        out.append((tag, data[i:i+ln]))
        i += ln
    return out

def crc16(data: bytes) -> int:
    return binascii.crc_hqx(data, 0)

def _make_unsliced(svc: int, cmd: int, tlv: bytes) -> bytes:
    """Standard single-frame packet."""
    body   = bytes([svc, cmd]) + tlv
    hdr    = bytes([MAGIC]) + struct.pack(">H", len(body) + 1) + b"\x00" + body
    return hdr + struct.pack(">H", crc16(hdr))

def _make_sliced(svc: int, cmd: int, tlv: bytes, slice_size: int = 244) -> list[bytes]:
    """Split a large TLV payload into sliced BLE frames."""
    HEADER = 5   # magic + length(2) + slice + flag
    FOOTER = 2   # CRC16
    MAX    = slice_size - HEADER - FOOTER   # usable per frame

    # First slice needs sID + cID
    chunks = []
    pos    = 0
    first  = True
    total  = len(tlv)

    while pos < total or first:
        if first:
            avail = MAX - 2   # reserve 2 for sID+cID
        else:
            avail = MAX

        chunk = tlv[pos:pos + avail]
        pos  += len(chunk)
        last  = (pos >= total)
        first = False
        chunks.append((chunk, last))

    frames  = []
    flag    = 0
    for i, (chunk, last) in enumerate(chunks):
        is_first = (i == 0)
        slice_b  = 0x01 if is_first else (0x03 if last else 0x02)

        if is_first:
            payload = bytes([svc, cmd]) + chunk
        else:
            payload = chunk

        body_len = len(payload)
        hdr = bytes([MAGIC]) + struct.pack(">H", body_len + FOOTER) + bytes([slice_b, flag])
        frame = hdr + payload
        frame += struct.pack(">H", crc16(frame))
        frames.append(frame)
        flag = (flag + 1) & 0xFF

    return frames

def parse_frame(data: bytes):
    """Return (svc, cmd, tlv_dict). Handles only complete reassembled data."""
    slice_b = data[3]
    if slice_b == 0x00:
        payload = data[4:-2]
    else:
        # Already reassembled — payload starts after magic+len+slice+flag
        payload = data[4:-2]
    svc = payload[0]
    cmd = payload[1]
    return svc, cmd, tlv_dec(payload[2:])

# ── Crypto ────────────────────────────────────────────────────────────────────

def hmac_sha256(key: bytes, msg: bytes) -> bytes:
    return _hmac.new(key, msg=msg, digestmod=hashlib.sha256).digest()

def sha256(data: bytes) -> bytes:
    return hashlib.sha256(data).digest()

def hexu(data: bytes) -> str:
    """Gadgetbridge's StringUtils.bytesToHex emits uppercase hex."""
    return data.hex().upper()

def hkdf_sha256(key: bytes, salt: bytes, info: bytes, length: int) -> bytes:
    return HKDF(algorithm=hashes.SHA256(), length=length,
                salt=salt, info=info).derive(key)

def aes_cbc_enc(plain: bytes, key: bytes, iv: bytes) -> bytes:
    pad = _padding.PKCS7(128).padder()
    p   = pad.update(plain) + pad.finalize()
    enc = Cipher(algorithms.AES(key), modes.CBC(iv)).encryptor()
    return enc.update(p) + enc.finalize()

def aes_cbc_dec(ciph: bytes, key: bytes, iv: bytes) -> bytes:
    dec = Cipher(algorithms.AES(key), modes.CBC(iv)).decryptor()
    p   = dec.update(ciph) + dec.finalize()
    unp = _padding.PKCS7(128).unpadder()
    return unp.update(p) + unp.finalize()

def aes_gcm_enc(plain: bytes, key: bytes, nonce: bytes, aad: bytes = None) -> bytes:
    return AESGCM(key).encrypt(nonce, plain, aad)

def aes_gcm_dec(ciph: bytes, key: bytes, nonce: bytes, aad: bytes = None) -> bytes:
    return AESGCM(key).decrypt(nonce, ciph, aad)

def decrypt_pin_code(enc_method: int, auth_version: int, msg: bytes, iv: bytes) -> bytes:
    key = DIGEST_SECRETS.get(auth_version, DIGEST_SECRETS[1])
    if enc_method == 0x01:
        return aes_gcm_dec(msg, key, iv[:12])
    return aes_cbc_dec(msg, key, iv[:16])

def create_secret_key(auth_version: int, mac: str) -> bytes:
    k1 = SECRET_KEY_1.get(auth_version, SECRET_KEY_1[1])
    k2 = SECRET_KEY_2.get(auth_version, SECRET_KEY_2[1])
    mac_key = (mac.replace(":", "") + "0000").encode()[:16]
    mixed   = bytes([(((k1[i] & 0xFF) << 4) ^ (k2[i] & 0xFF)) & 0xFF for i in range(16)])
    mhash   = sha256(mixed)
    final   = bytes([(((mhash[i] & 0xFF) >> 6) ^ mac_key[i]) & 0xFF for i in range(16)])
    return sha256(final)[:16]

# ── Config ────────────────────────────────────────────────────────────────────

def load_or_create_config() -> dict:
    cfg = ConfigParser()
    if CONFIG_FILE.exists():
        cfg.read(CONFIG_FILE)
        c = dict(cfg["band10"])
        secret_key = bytes.fromhex(c["secret_key"]) if c.get("secret_key") else None
        auth_key = bytes.fromhex(c["auth_key"]) if c.get("auth_key") else None
        stored_android_id = c.get("android_id", "")
        android_id = stored_android_id.upper()
        if (not secret_key) and (len(android_id) != 32 or any(ch not in "0123456789abcdefABCDEF" for ch in android_id)):
            android_id = hexu(secrets.token_bytes(16))
            cfg["band10"]["android_id"] = android_id
            with open(CONFIG_FILE, "w") as f:
                cfg.write(f)
            logger.info("Regenerated Gadgetbridge-style 32-char android_id in band.ini.")
        elif stored_android_id != android_id:
            cfg["band10"]["android_id"] = android_id
            with open(CONFIG_FILE, "w") as f:
                cfg.write(f)
        c["secret"]     = bytes.fromhex(c["secret"])
        c["android_id"] = android_id
        c["secret_key"] = secret_key
        c["auth_key"]   = auth_key
        return c

    secret     = secrets.token_bytes(16)
    android_id = hexu(secrets.token_bytes(16))
    cfg["band10"] = {
        "device_mac":  DEVICE_MAC,
        "client_mac":  CLIENT_MAC,
        "secret":      secret.hex(),
        "android_id":  android_id,
        "auth_key":    "",    # persistent HiChain authToken for reconnect
        "secret_key":  "",    # filled after first HiChain auth
    }
    with open(CONFIG_FILE, "w") as f:
        cfg.write(f)
    logger.info("Created band.ini with fresh keys.")
    return {"device_mac": DEVICE_MAC, "client_mac": CLIENT_MAC,
            "secret": secret, "android_id": android_id,
            "auth_key": None, "secret_key": None}

def save_auth_key(key: bytes):
    cfg = ConfigParser()
    cfg.read(CONFIG_FILE)
    cfg["band10"]["auth_key"] = key.hex()
    with open(CONFIG_FILE, "w") as f:
        cfg.write(f)
    logger.info("Saved HiChain auth key to band.ini.")

def save_secret_key(key: bytes):
    cfg = ConfigParser()
    cfg.read(CONFIG_FILE)
    cfg["band10"]["secret_key"] = key.hex()
    with open(CONFIG_FILE, "w") as f:
        cfg.write(f)
    logger.info("Saved HiChain transaction key to band.ini.")

# ── Band class ────────────────────────────────────────────────────────────────

class Band:
    def __init__(self, client: BleakClient, cfg: dict):
        self.client     = client
        self.device_mac = cfg["device_mac"]
        self.client_mac = cfg["client_mac"]
        self.android_id = cfg["android_id"]          # Gadgetbridge-style 32-char hex string
        self.auth_key   = cfg.get("auth_key")        # Persistent HiChain authToken
        self.secret_key = cfg.get("secret_key")      # Per-session hichain_return_key

        self.client_serial = self.client_mac.replace(":", "")[-6:].encode()

        # Filled during handshake
        self.auth_version     = 1
        self.server_nonce     = b""
        self.dev_support_type = 0
        self.auth_algo        = 0
        self.bond_state       = 0
        self.enc_method       = 0
        self.auth_mode        = 0
        self.slice_size       = 244
        self.enc_counter      = 0
        self.first_key        = b""
        self.band_device_id   = ""   # set from security negotiation tag=0x05

        self._loop    = None
        self._event   = asyncio.Event()
        self._rx_queue = deque()   # queue of complete reassembled frames
        self._rx_buf  = None       # reassembly buffer for sliced packets
        self._rx_partial = b""     # BLE-level fragments of one LPv2 frame
        self._rx_svc  = 0
        self._rx_cmd  = 0

    # ── BLE low-level ─────────────────────────────────────────────────────────

    async def connect(self):
        self._loop = asyncio.get_running_loop()
        await self.client.start_notify(GATT_READ, self._on_notify)
        logger.info("Subscribed to notifications.")

    def _on_notify(self, _char, data: bytearray):
        raw = bytes(data)
        logger.debug(f"← {raw.hex()}")

        buf = self._rx_partial + raw
        self._rx_partial = b""

        while buf:
            if len(buf) < 4:
                self._rx_partial = buf
                return
            if buf[0] != MAGIC:
                logger.warning(f"Dropping non-Huawei partial bytes: {buf.hex()}")
                return

            expected = struct.unpack(">H", buf[1:3])[0]
            frame_len = expected + 5
            if len(buf) < frame_len:
                self._rx_partial = buf
                return

            frame = buf[:frame_len]
            buf = buf[frame_len:]
            self._handle_complete_frame(frame)

    def _handle_complete_frame(self, raw: bytes):
        slice_b = raw[3]

        if slice_b == 0x00:
            # Complete unsliced packet — push to queue
            self._rx_queue.append(raw)
            self._loop.call_soon_threadsafe(self._event.set)

        elif slice_b == 0x01:
            # First slice — extract sID+cID then start buffer
            payload      = raw[5:-2]   # after magic,len,slice,flag; before CRC
            self._rx_svc = payload[0]
            self._rx_cmd = payload[1]
            self._rx_buf = payload[2:]

        elif slice_b == 0x02:
            # Middle slice
            if self._rx_buf is not None:
                self._rx_buf += raw[5:-2]

        elif slice_b == 0x03:
            # Last slice — complete reassembly, push to queue
            if self._rx_buf is not None:
                self._rx_buf += raw[5:-2]
                # Reconstruct as a fake unsliced frame so parse_frame works
                body  = bytes([self._rx_svc, self._rx_cmd]) + self._rx_buf
                hdr   = bytes([MAGIC]) + struct.pack(">H", len(body)+1) + b"\x00" + body
                self._rx_queue.append(hdr + struct.pack(">H", crc16(hdr)))
                self._rx_buf = None
                self._loop.call_soon_threadsafe(self._event.set)

    async def _send(self, svc: int, cmd: int, tlv: bytes):
        frames = _make_sliced(svc, cmd, tlv, self.slice_size)
        if len(frames) == 1 and frames[0][3] == 0x01:
            # Would be sliced but only one frame — use unsliced format instead
            frames = [_make_unsliced(svc, cmd, tlv)]
        for f in frames:
            logger.debug(f"→ {f.hex()}")
            await self.client.write_gatt_char(GATT_WRITE, bytearray(f))
            if len(frames) > 1:
                await asyncio.sleep(0.02)   # small gap between slices

    def _decrypt_and_log(self, tlvs: dict, label: str,
                          pin_code: bytes = b"", rand_self: bytes = b"", seed: bytes = b"") -> tuple:
        """Try to decrypt a CryptoTag-wrapped notification.
        Returns (True, key, nonce, aad) on success, (False, None, None, None) otherwise."""
        nonce      = tlvs.get(0x7D, b"")
        ciphertext = tlvs.get(0x7E, b"")
        logger.debug(f"  [{label}] nonce={nonce.hex()} ciphertext({len(ciphertext)}B)={ciphertext.hex()}")

        # Build candidate keys from all known pre-shared material
        candidates = []
        for k in DIGEST_SECRETS.values():
            candidates.append(("DIGEST_SECRET", k))
        if self.secret_key:
            candidates.append(("secret_key", self.secret_key))
        if pin_code:
            pin_hex = pin_code.hex().encode("utf-8")
            pin_key = sha256(pin_hex)
            candidates.append(("sha256(pin_hex)", pin_key))
            candidates.append(("sha256(pin_hex)[:16]", pin_key[:16]))
            for ds in DIGEST_SECRETS.values():
                candidates.append(("hmac(digest,pin_hex)", hmac_sha256(ds, pin_hex)))
            if seed:
                # PSK — the key both sides can compute from PIN + seed we sent in step 1
                psk = hmac_sha256(pin_key, seed)
                candidates.append(("PSK=hmac(sha256(pin),seed)", psk))
                candidates.append(("PSK[:16]", psk[:16]))
                # Reversed HMAC order — some implementations swap key/msg
                psk_rev = hmac_sha256(seed, pin_key)
                candidates.append(("PSK_rev=hmac(seed,sha256(pin))", psk_rev))
                candidates.append(("PSK_rev[:16]", psk_rev[:16]))
            if self.server_nonce:
                candidates.append(("hmac(pin_key,serverNonce)", hmac_sha256(pin_key, self.server_nonce)))
        if rand_self:
            for ds in DIGEST_SECRETS.values():
                candidates.append(("hmac(digest,rand_self)", hmac_sha256(ds, rand_self)))
        if seed:
            for ds in DIGEST_SECRETS.values():
                candidates.append(("hmac(digest,seed)", hmac_sha256(ds, seed)))
        if self.server_nonce:
            # server_nonce is 16 bytes — valid AES-128 key; it's also static across runs
            candidates.append(("server_nonce", self.server_nonce))
            candidates.append(("sha256(serverNonce)", sha256(self.server_nonce)))
            candidates.append(("sha256(serverNonce)[:16]", sha256(self.server_nonce)[:16]))
            for ds in DIGEST_SECRETS.values():
                candidates.append(("hmac(digest,serverNonce)", hmac_sha256(ds, self.server_nonce)))
        # android_id derived keys
        if self.android_id:
            android_id_bytes = self.android_id.encode("utf-8")
            candidates.append(("sha256(androidId)", sha256(android_id_bytes)))
            candidates.append(("sha256(androidId)[:16]", sha256(android_id_bytes)[:16]))
            for ds in DIGEST_SECRETS.values():
                candidates.append(("hmac(digest,androidId)", hmac_sha256(ds, android_id_bytes)))
        # band_device_id derived keys
        if self.band_device_id:
            try:
                bid = bytes.fromhex(self.band_device_id)
                candidates.append(("sha256(bandDevId)", sha256(bid)))
                candidates.append(("sha256(bandDevId)[:16]", sha256(bid)[:16]))
                candidates.append(("bandDevId[:16]", bid[:16]))
                candidates.append(("bandDevId[16:32]", bid[16:32]))
                for ds in DIGEST_SECRETS.values():
                    candidates.append(("hmac(digest,bandDevId)", hmac_sha256(ds, bid)))
            except Exception:
                pass
        # Key derived from band MAC (Gadgetbridge create_secret_key style)
        try:
            mac_key = create_secret_key(self.auth_version, self.device_mac)
            candidates.append(("create_secret_key(bandMAC)", mac_key))
            # Also try with client_mac (Gadgetbridge uses phone's MAC, not band's MAC)
            mac_key2 = create_secret_key(self.auth_version, self.client_mac)
            candidates.append(("create_secret_key(clientMAC)", mac_key2))
            # Gadgetbridge may use lowercase MAC internally
            mac_key3 = create_secret_key(self.auth_version, self.device_mac.lower())
            candidates.append(("create_secret_key(bandMAC_lower)", mac_key3))
            mac_key4 = create_secret_key(self.auth_version, self.client_mac.lower())
            candidates.append(("create_secret_key(clientMAC_lower)", mac_key4))
            # Try auth_version=0 and 2 variants as well
            for av in (0, 2, 3):
                try:
                    candidates.append((f"create_secret_key(v{av},bandMAC)",
                                       create_secret_key(av, self.device_mac)))
                    candidates.append((f"create_secret_key(v{av},clientMAC)",
                                       create_secret_key(av, self.client_mac)))
                except Exception:
                    pass
        except Exception:
            pass

        # Session key hypothesis: band sends nonce = rand_peer (its isoSalt).
        # Both sides can compute session_key = HKDF(PSK, rand_self + nonce, info, 32).
        # This lets the band encrypt svc=0x37 with session_key without needing a prior exchange.
        if pin_code and seed and rand_self and len(nonce) >= 16:
            try:
                pin_hex_sk = pin_code.hex().encode("utf-8")
                psk_sk     = hmac_sha256(sha256(pin_hex_sk), seed)
                rand_peer_cand = nonce[:16]
                for sk_info in (b"hichain_iso_session_key", b"hichain_session_key",
                                b"hichain_iso_notification_key", b"hichain_return_key"):
                    sk = hkdf_sha256(psk_sk, rand_self + rand_peer_cand, sk_info, 32)
                    candidates.append((f"sessionKey(nonce_as_randPeer,info={sk_info})", sk))
                    candidates.append((f"sessionKey[:16](nonce_as_randPeer,info={sk_info})", sk[:16]))
            except Exception:
                pass

        # Additional direct combinations
        if pin_code and seed:
            pin_hex2 = pin_code.hex().encode("utf-8")
            candidates.append(("hmac(pin_code,seed)", hmac_sha256(pin_code, seed)))
            candidates.append(("sha256(seed+pin_hex)", sha256(seed + pin_hex2)))
            candidates.append(("sha256(pin_hex+seed)", sha256(pin_hex2 + seed)))
        if rand_self and seed:
            candidates.append(("sha256(rand_self+seed)", sha256(rand_self + seed)))
            candidates.append(("sha256(seed+rand_self)", sha256(seed + rand_self)))
        if self.server_nonce and seed:
            candidates.append(("sha256(serverNonce+seed)", sha256(self.server_nonce + seed)))
        if pin_code and seed and self.server_nonce:
            pin_hex3 = pin_code.hex().encode("utf-8")
            psk3 = hmac_sha256(sha256(pin_hex3), seed)
            for sk_info in (b"hichain_iso_session_key", b"hichain_iso_notification_key"):
                sk = hkdf_sha256(psk3, self.server_nonce, sk_info, 32)
                candidates.append((f"HKDF(psk,serverNonce,{sk_info})", sk))

        # Try each candidate with 12-byte and 16-byte nonce variants, plus a set of AADs.
        # svc=0x37 and svc=0x01/cmd=0x3D AADs added — Huawei may use [svc, cmd] as AAD.
        aad_candidates = [
            None,
            bytes([0x25, 0x03]),
            bytes([0x01, 0x38]),
            bytes([0x37, 0x01]),
            bytes([0x01, 0x3D]),
            bytes([0x01, 0x28]),
        ]
        for name, key in candidates:
            if len(key) not in (16, 24, 32):
                continue
            for n in (nonce[:12], nonce):
                if len(n) == 0:
                    continue
                for aad in aad_candidates:
                    try:
                        plain = aes_gcm_dec(ciphertext, key, n, aad)
                        logger.info(f"  [{label}] DECRYPTED key={name}({key.hex()[:8]}…) "
                                    f"nonce_len={len(n)} aad={aad!r} → {plain.hex()} {plain!r}")
                        return True, key, n, aad
                    except Exception:
                        pass
        logger.debug(f"  [{label}] Could not decrypt with any known key")
        return False, None, None, None

    async def _recv(self, exp_svc: int, exp_cmd: int, timeout: float = 15.0,
                    pin_code: bytes = b"", rand_self: bytes = b"", seed: bytes = b"") -> dict:
        """Wait for a specific svc/cmd packet, silently skipping unrelated notifications.

        Uses a queue so rapid bursts of notifications are never overwritten.
        Gadgetbridge ignores svc=0x25 (MusicControl) and svc=0x37 (DataSync) during
        first auth (secretKey==None → handleResponse returns early). We do the same.
        """
        deadline = asyncio.get_running_loop().time() + timeout
        while True:
            # Drain any buffered notifications before waiting
            while self._rx_queue:
                raw = self._rx_queue.popleft()
                svc, cmd, tlvs = parse_frame(raw)
                if (svc, cmd) == (exp_svc, exp_cmd):
                    return tlvs
                self._log_unsolicited(svc, cmd, tlvs, pin_code, rand_self, seed)

            remaining = deadline - asyncio.get_running_loop().time()
            if remaining <= 0:
                raise asyncio.TimeoutError(f"Timed out waiting for {exp_svc:#x}/{exp_cmd:#x}")

            # Clear event THEN re-check queue to avoid missing a notification
            # that arrived between the drain loop and this clear.
            self._event.clear()
            if self._rx_queue:
                continue
            await asyncio.wait_for(self._event.wait(), timeout=remaining)

    def _log_unsolicited(self, svc: int, cmd: int, tlvs: dict,
                         pin_code: bytes, rand_self: bytes, seed: bytes):
        """Log an unsolicited packet without sending any response (Gadgetbridge-style)."""
        if svc == SVC_DEV and cmd == 0x38:
            logger.warning(f"  Band auth rejection (svc=0x01/cmd=0x38): {tlvs}")
        elif svc == 0x25 and cmd == 0x03:
            # MusicControl.Control — band sends this as a background update.
            # Gadgetbridge ignores it entirely during first auth (secretKey==None).
            logger.debug(f"  svc=0x25/cmd=0x03 (MusicControl) — skipping, "
                         f"tlvs={ {hex(k): v.hex() for k,v in tlvs.items()} }")
        elif svc == 0x37 or (svc == SVC_DEV and cmd == 0x3D):
            # DataSync or encrypted dev packet — log but don't respond
            logger.info(f"  svc={svc:#x}/cmd={cmd:#x} raw tlvs: { {hex(k): v.hex() for k,v in tlvs.items()} }")
            self._decrypt_and_log(tlvs, f"svc={svc:#x}/cmd={cmd:#x}", pin_code, rand_self, seed)
        else:
            logger.debug(f"  Skipping unsolicited packet svc={svc:#x} cmd={cmd:#x}")

    async def _respond_to_notification(self, svc: int, cmd: int, key: bytes):
        """Send an encrypted ACK to a band notification using the given key."""
        nonce_out = secrets.token_bytes(12)
        enc = aes_gcm_enc(b"", key, nonce_out, None)
        resp_tlv = tlv_enc(0x7C, b"\x01") + tlv_enc(0x7D, nonce_out) + tlv_enc(0x7E, enc)
        logger.debug(f"  → ACK svc={svc:#x}/cmd={cmd:#x} key={key.hex()[:8]}…")
        await self._send(svc, cmd, resp_tlv)

    async def _transact(self, svc: int, cmd: int, tlv: bytes,
                        timeout: float = 15.0,
                        pin_code: bytes = b"", rand_self: bytes = b"", seed: bytes = b"") -> dict:
        await self._send(svc, cmd, tlv)
        return await self._recv(svc, cmd, timeout, pin_code=pin_code, rand_self=rand_self, seed=seed)

    def _uses_gcm(self) -> bool:
        # Gadgetbridge uses GCM for encryptMethod=1, and always for deviceSupportType=4.
        return self.enc_method == 0x01 or self.dev_support_type == 0x04

    def _next_crypto_iv(self) -> bytes:
        if self.dev_support_type == 0x04:
            return secrets.token_bytes(16)
        self.enc_counter = 1 if self.enc_counter == 0xFFFFFFFF else self.enc_counter + 1
        return secrets.token_bytes(12) + struct.pack(">I", self.enc_counter)

    def _encrypt_transaction_tlv(self, plain_tlv: bytes) -> bytes:
        if not self.secret_key:
            raise RuntimeError("Cannot encrypt transaction before HiChain secret key is available")

        iv = self._next_crypto_iv()
        if self._uses_gcm():
            cipher = aes_gcm_enc(plain_tlv, self.secret_key, iv, None)
        else:
            cipher = aes_cbc_enc(plain_tlv, self.secret_key, iv)

        logger.debug(f"  encrypt tx iv={iv.hex()} plain={plain_tlv.hex()} cipher={cipher.hex()}")
        return tlv_enc(0x7C, b"\x01") + tlv_enc(0x7D, iv) + tlv_enc(0x7E, cipher)

    def _decrypt_transaction_tlvs(self, tlvs: dict) -> dict:
        if not (self.secret_key and 0x7C in tlvs and 0x7D in tlvs and 0x7E in tlvs):
            return tlvs

        iv = tlvs[0x7D]
        cipher = tlvs[0x7E]
        if self._uses_gcm():
            plain = aes_gcm_dec(cipher, self.secret_key, iv, None)
        else:
            plain = aes_cbc_dec(cipher, self.secret_key, iv)

        decrypted = tlv_dec(plain)
        logger.debug(f"  decrypt rx iv={iv.hex()} plain={plain.hex()} "
                     f"tlvs={ {hex(k): v.hex() for k, v in decrypted.items()} }")
        return decrypted

    async def _transact_encrypted(self, svc: int, cmd: int, tlv: bytes,
                                  timeout: float = 15.0) -> dict:
        wrapped = self._encrypt_transaction_tlv(tlv)
        response = await self._transact(svc, cmd, wrapped, timeout=timeout)
        return self._decrypt_transaction_tlvs(response)

    # ── Handshake steps ───────────────────────────────────────────────────────

    async def get_link_params(self):
        logger.info("Step 1: Link params...")
        tlv  = tlv_enc(0x01) + tlv_enc(0x02) + tlv_enc(0x03) + tlv_enc(0x04)
        tlvs = await self._transact(SVC_DEV, CMD_LINK, tlv)

        nf = tlvs.get(0x05, b"\x00\x01" + b"\x00"*16)
        self.auth_version     = nf[1]
        self.server_nonce     = nf[2:18]
        self.dev_support_type = tlvs[0x07][0] if 0x07 in tlvs else 0
        self.auth_algo        = tlvs[0x08][0] if 0x08 in tlvs else 0
        self.bond_state       = tlvs[0x09][0] if 0x09 in tlvs else 0
        self.enc_method       = tlvs[0x0C][0] if 0x0C in tlvs else 0
        if 0x02 in tlvs:
            self.slice_size   = struct.unpack(">H", tlvs[0x02])[0]

        logger.info(f"  auth_version={self.auth_version} dev_support={self.dev_support_type} "
                    f"auth_algo={self.auth_algo} bond_state={self.bond_state} "
                    f"enc_method={self.enc_method} slice_size={self.slice_size}")
        logger.info(f"  serverNonce={self.server_nonce.hex()}")

    async def security_negotiation(self) -> int:
        logger.info("Step 2: Security negotiation...")
        self.auth_mode = 4 if self.dev_support_type == 4 else 2

        tlv  = tlv_enc(0x01, bytes([self.auth_mode]))
        if self.auth_mode in (0x02, 0x04):
            tlv += tlv_enc(0x02, b"\x01")
        tlv += tlv_enc(0x05, self.android_id.encode("utf-8"))
        tlv += tlv_enc(0x03, b"\x01") + tlv_enc(0x04, b"\x00")
        if self.auth_mode == 0x04:
            # Gadgetbridge adds these for authMode=4
            tlv += tlv_enc(0x06)                          # empty tag 0x06
            tlv += tlv_enc(0x07, b"Python")               # phone model (tag 0x07)
        if self.enc_method == 0x01:
            tlv += tlv_enc(0x0D, b"\x01")

        tlvs = await self._transact(SVC_DEV, CMD_SECNEGO, tlv)

        auth_type, pw = -1, -1
        if 0x01 in tlvs:
            v = tlvs[0x01][0]
            if v == 0x01: auth_type = 0x0186A0
            elif v == 0x04: pw = 4
        if 0x02 in tlvs:
            auth_type = tlvs[0x02][0]
            if pw != -1: auth_type ^= pw
        if 0x7F in tlvs:
            auth_type = tlvs[0x7F][0]

        if 0x05 in tlvs:
            self.band_device_id = tlvs[0x05].decode("ascii", errors="replace").lower()
            logger.info(f"  bandDeviceId={self.band_device_id}")
        if 0x09 in tlvs:
            band_mac = tlvs[0x09].rstrip(b"\x00").decode("ascii", errors="replace")
            logger.info(f"  bandMac={band_mac}")

        logger.info(f"  authType={auth_type:#x}")
        return auth_type

    async def get_pin_code(self) -> bytes:
        logger.info("Step 3: PIN code (watch for confirmation prompt on band)...")
        tlvs = await self._transact(SVC_DEV, CMD_PINCODE, tlv_enc(0x01), timeout=30.0)
        msg  = tlvs.get(0x01, b"")
        iv   = tlvs.get(0x02, b"")
        pin  = decrypt_pin_code(self.enc_method, self.auth_version, msg, iv)
        logger.info(f"  Received PIN: {pin.hex()}")
        return pin

    # ── HiChain3 ──────────────────────────────────────────────────────────────

    def _hichain_json(self, step: int, payload_extra: dict,
                      op_code: int, request_id: int,
                      value_extra: dict = None) -> bytes:
        """Build the JSON TLV blob for a HiChain step packet."""
        android_id_hex = self.android_id
        message_id     = step if op_code == 0x01 else (step | 0x10)

        version_obj = {"minVersion": "1.0.0", "currentVersion": "2.0.16"}
        payload_obj = {"version": version_obj, **payload_extra}

        value_obj = {
            "authForm": 0,
            "payload": payload_obj,
            "groupAndModuleVersion": "2.0.1",
            "message": message_id,
        }
        if op_code == 0x01:
            # peerDeviceId and connDeviceId = our own android_id as hex string.
            # Gadgetbridge: new String(getAndroidId(), UTF_8) = the hex string itself.
            value_obj.update({
                "requestId":    str(request_id),
                "groupId":      GROUP_ID,
                "groupName":    "health_group_name",
                "groupOp":      2,
                "groupType":    256,
                "peerDeviceId": android_id_hex,
                "connDeviceId": android_id_hex,
                "appId":        "com.huawei.health",
                "ownerName":    "",
            })
        else:
            value_obj["isDeviceLevel"] = False

        if value_extra:
            value_obj.update(value_extra)

        json_str = json.dumps(value_obj, separators=(",", ":")).encode("utf-8")
        tlv  = tlv_enc(0x01, json_str)
        tlv += tlv_enc(0x02, bytes([op_code]))
        tlv += tlv_enc(0x03, struct.pack(">q", request_id))
        return tlv

    def _parse_hichain_response(self, tlvs: dict) -> dict:
        """Parse HiChain JSON response, return (step, payload_dict)."""
        json_bytes = tlvs.get(0x01, b"{}")
        # Band sends TLV-format (non-JSON) error responses when it rejects auth.
        # tag=0x01 will contain the appId string ("com.huawei.health") not a JSON object.
        if not json_bytes.startswith(b"{"):
            app_id     = json_bytes.decode("utf-8", errors="replace")
            resp_type  = tlvs.get(0x04, b"\x00")[0] if 0x04 in tlvs else 0
            status     = tlvs.get(0x05, b"\x00")[0] if 0x05 in tlvs else 0
            if app_id == "com.huawei.health" and resp_type != 0 and status == 0:
                logger.debug(f"  HiChain final TLV ACK: appId={app_id!r} type={resp_type} status={status}")
                return 4, {"appId": app_id, "type": resp_type, "status": status}
            logger.warning(f"  HiChain TLV-format (non-JSON) response: appId={app_id!r} "
                           f"type={resp_type} status={status} all_tags={ {hex(k): v.hex() for k,v in tlvs.items()} }")
            raise ValueError(f"HiChain TLV response type={resp_type} status={status} (appId={app_id!r})")
        obj     = json.loads(json_bytes.rstrip(b"\x00").decode("utf-8"))
        step    = obj.get("message", 0) & 0x0F   # mask reconnect bit
        payload = obj.get("payload", {})
        error   = obj.get("errorCode", 0)
        if error != 0:
            raise ValueError(f"HiChain errorCode={error}")
        return step, payload

    async def hichain_authenticate(self, pin_code: bytes, op_code: int = 0x01):
        """Execute the 4-step HiChain3 mutual authentication."""
        logger.info(f"Step 4: HiChain3 auth (op={op_code:#x})...")
        request_id  = int(time.time() * 1000)
        seed        = secrets.token_bytes(32)
        rand_self   = secrets.token_bytes(16)
        auth_id_self = self.android_id.encode("utf-8")
        session_key  = None
        challenge    = None

        # ── Step 1 ────────────────────────────────────────────────────────────
        step1_payload = {
            "isoSalt":       hexu(rand_self),
            "peerAuthId":    hexu(auth_id_self),
            "operationCode": op_code,
            "seed":          hexu(seed),
            "peerUserType":  0,
        }
        if op_code == 0x02:
            step1_payload.update({
                "pkgName":     "com.huawei.devicegroupmanage",
                "serviceType": GROUP_ID,
                "keyLength":   32,
            })

        logger.info("  HiChain step 1...")
        tlv      = self._hichain_json(1, step1_payload, op_code, request_id)
        step1_json_str = tlv_dec(tlv).get(0x01, b"{}").decode("utf-8", errors="replace")
        logger.info(f"  Step 1 JSON: {step1_json_str}")
        if op_code == 0x01:
            print("\n" + "="*60)
            print("ACTION REQUIRED: Check your band screen NOW.")
            print("The band will show a second pairing/bond confirmation.")
            print("You have 90 seconds to accept it on the band.")
            print("="*60 + "\n")
        resp_tlvs = await self._transact(SVC_DEV, CMD_HICHAIN, tlv, timeout=90.0,
                                         pin_code=pin_code, rand_self=rand_self, seed=seed)
        step, p1 = self._parse_hichain_response(resp_tlvs)
        logger.debug(f"  Step 1 response: step={step} payload={p1}")

        rand_peer    = bytes.fromhex(p1["isoSalt"])
        auth_id_peer = bytes.fromhex(p1["peerAuthId"])
        peer_token   = bytes.fromhex(p1["token"])

        # Derive PSK
        if op_code == 0x01:
            pin_hex_utf8 = hexu(pin_code).encode("utf-8")
            key          = sha256(pin_hex_utf8)
        else:
            key = self.auth_key
            if not key:
                raise RuntimeError("Cannot reconnect HiChain without stored auth_key")

        psk = hmac_sha256(key, seed)

        # Verify peer token: HMAC(psk, randPeer+randSelf+authIdSelf+authIdPeer)
        token_check = hmac_sha256(psk,
                                  rand_peer + rand_self + auth_id_self + auth_id_peer)
        if token_check != peer_token:
            logger.warning(f"  Peer token mismatch! expected={token_check.hex()} got={peer_token.hex()}")
        else:
            logger.info("  Peer token verified OK.")

        # ── Step 2 ────────────────────────────────────────────────────────────
        self_token = hmac_sha256(psk,
                                 rand_self + rand_peer + auth_id_peer + auth_id_self)
        step2_payload = {
            "peerAuthId": hexu(auth_id_self),
            "token":      hexu(self_token),
        }
        logger.info("  HiChain step 2...")
        tlv      = self._hichain_json(2, step2_payload, op_code, request_id,
                                       value_extra={"isDeviceLevel": False} if op_code == 0x02 else None)
        resp_tlvs = await self._transact(SVC_DEV, CMD_HICHAIN, tlv)
        step, p2 = self._parse_hichain_response(resp_tlvs)
        logger.debug(f"  Step 2 response: step={step} payload={p2}")

        ret_code_mac       = bytes.fromhex(p2["returnCodeMac"])
        ret_code_mac_check = hmac_sha256(psk, b"\x00\x00\x00\x00")
        if ret_code_mac_check != ret_code_mac:
            logger.warning(f"  returnCodeMac mismatch! expected={ret_code_mac_check.hex()}")
        else:
            logger.info("  returnCodeMac verified OK.")

        # ── Step 3 (first-auth only) ──────────────────────────────────────────
        salt        = rand_self + rand_peer
        session_key = hkdf_sha256(psk, salt, b"hichain_iso_session_key", 32)
        logger.debug(f"  sessionKey={session_key.hex()}")

        if op_code == 0x01:
            nonce     = secrets.token_bytes(12)
            challenge = secrets.token_bytes(16)
            aad       = b"hichain_iso_exchange"
            enc_data  = aes_gcm_enc(challenge, session_key, nonce, aad)

            step3_payload = {
                "nonce":   hexu(nonce),
                "encData": hexu(enc_data),
            }
            logger.info("  HiChain step 3 (first-auth)...")
            tlv      = self._hichain_json(3, step3_payload, op_code, request_id)
            resp_tlvs = await self._transact(SVC_DEV, CMD_HICHAIN, tlv, timeout=30.0)
            step, p3 = self._parse_hichain_response(resp_tlvs)
            logger.debug(f"  Step 3 response: step={step} payload={p3}")

            nonce3       = bytes.fromhex(p3["nonce"])
            enc_auth_tok = bytes.fromhex(p3["encAuthToken"])
            auth_token   = aes_gcm_dec(enc_auth_tok, session_key, nonce3, challenge)
            self.auth_key = auth_token
            save_auth_key(auth_token)
            logger.info(f"  authToken stored: {auth_token.hex()}")
        else:
            logger.info("  Step 3 skipped (reconnect mode).")

        # ── Step 4 ────────────────────────────────────────────────────────────
        nonce4    = secrets.token_bytes(12)
        aad4      = b"hichain_iso_result"
        enc_res   = aes_gcm_enc(b"\x00\x00\x00\x00", session_key, nonce4, aad4)
        step4_payload = {
            "nonce":         hexu(nonce4),
            "encResult":     hexu(enc_res),
            "operationCode": op_code,
        }
        step4_num = 4 if op_code == 0x01 else 3
        logger.info("  HiChain step 4...")
        tlv      = self._hichain_json(step4_num, step4_payload, op_code, request_id)
        resp_tlvs = await self._transact(SVC_DEV, CMD_HICHAIN, tlv)
        step, _  = self._parse_hichain_response(resp_tlvs)
        logger.info(f"  HiChain complete (final step={step}).")

        if op_code == 0x01:
            logger.info("  First-auth finished; starting HiChain bind pass (op=0x02)...")
            await self.hichain_authenticate(pin_code=b"", op_code=0x02)
            return

        # For reconnect: derive final session key
        if op_code == 0x02:
            final_key = hkdf_sha256(session_key, salt, b"hichain_return_key", 32)
            self.secret_key = final_key
            save_secret_key(final_key)
            logger.info(f"  Session transaction key stored: {final_key.hex()}")

    # ── Full handshake ────────────────────────────────────────────────────────

    async def handshake(self):
        await self.get_link_params()

        auth_type = 0
        if self.dev_support_type != 0:
            auth_type = await self.security_negotiation()

        def is_hichain3(at):
            return (at ^ 0x01) == 0x04 or (at ^ 0x02) == 0x04

        def is_hichainlite(at):
            return at in (0x01, 0x02)

        if auth_type == 0x0186A0 or is_hichain3(auth_type):
            logger.info("  Mode: HiChain3")
            if self.auth_key:
                logger.info("  Stored auth key found → reconnect (op=0x02)")
                await self.hichain_authenticate(pin_code=b"", op_code=0x02)
            else:
                logger.info("  No stored key → first-auth (op=0x01), fetching PIN...")
                pin = await self.get_pin_code()
                await self.hichain_authenticate(pin_code=pin, op_code=0x01)

        elif is_hichainlite(auth_type) or self.dev_support_type == 0x02:
            logger.info("  Mode: HiChainLite (not yet implemented)")

        else:
            logger.info("  Mode: Normal (not yet implemented)")

        logger.info("Handshake complete!")

    # ── Data queries ─────────────────────────────────────────────────────────

    async def get_battery(self) -> int:
        tlvs = await self._transact_encrypted(SVC_DEV, 0x08, tlv_enc(0x01))
        if 0x01 in tlvs:
            return tlvs[0x01][0]
        if 0x02 in tlvs:
            return tlvs[0x02][0]
        return -1

    async def get_fitness_message_count(self, label: str, cmd: int,
                                        start_ts: int, end_ts: int) -> int:
        # Gadgetbridge FitnessData.MessageCount.Request:
        # tag 0x81 empty, tag 0x03 start epoch, tag 0x04 end epoch.
        tlv = (
            tlv_enc(0x81) +
            tlv_enc(0x03, struct.pack(">I", start_ts)) +
            tlv_enc(0x04, struct.pack(">I", end_ts))
        )
        tlvs = await self._transact_encrypted(SVC_FITNESS, cmd, tlv, timeout=20.0)
        logger.debug(f"  {label} count tlvs={ {hex(k): v.hex() for k, v in tlvs.items()} }")

        if 0x81 in tlvs:
            container = tlv_dec(tlvs[0x81])
            if 0x02 in container:
                return struct.unpack(">H", container[0x02])[0]
        if 0x02 in tlvs:
            return struct.unpack(">H", tlvs[0x02]) [0]
        return -1

    async def get_recent_fitness_counts(self, hours: int = 24) -> dict:
        end_ts = int(time.time())
        start_ts = end_ts - hours * 3600
        return {
            "steps": await self.get_fitness_message_count("steps", 0x0A, start_ts, end_ts),
            "sleep": await self.get_fitness_message_count("sleep", 0x0C, start_ts, end_ts),
        }

    @staticmethod
    def _parse_step_features(data: bytes) -> dict:
        if not data:
            return {"error": "missing feature bitmap"}

        i = 0
        bitmap1 = data[i]
        i += 1
        bitmap2 = 0
        if bitmap1 & 0x80:
            if i >= len(data):
                return {"error": "missing second feature bitmap"}
            bitmap2 = data[i]
            i += 1

        parsed = {}
        for bit in (0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40):
            if not (bitmap1 & bit):
                continue
            width = 1 if bit in (0x20, 0x40) else 2
            if i + width > len(data):
                return {**parsed, "error": "feature payload too short"}
            if width == 1:
                value = data[i]
                i += 1
            else:
                value = struct.unpack(">H", data[i:i + 2])[0]
                i += 2
            if bit == 0x02:
                parsed["steps"] = value
            elif bit == 0x04:
                parsed["calories"] = value
            elif bit == 0x08:
                parsed["distance"] = value
            elif bit == 0x40:
                parsed["heart_rate"] = value
            else:
                parsed[f"bitmap1_{bit:#04x}"] = value

        for bit in (0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80):
            if not (bitmap2 & bit):
                continue
            if i >= len(data):
                return {**parsed, "error": "second bitmap payload too short"}
            value = data[i]
            i += 1
            if bit == 0x01:
                parsed["spo2"] = value
            elif bit == 0x02:
                parsed["resting_heart_rate"] = value
            else:
                parsed[f"bitmap2_{bit:#04x}"] = value
        return parsed

    async def get_step_data_record(self, index: int) -> list[dict]:
        tlv = tlv_enc(0x81, tlv_enc(0x02, struct.pack(">H", index)))
        tlvs = await self._transact_encrypted(SVC_FITNESS, 0x0B, tlv, timeout=20.0)
        container = tlv_dec(tlvs[0x81])
        items = tlv_items(tlvs[0x81])
        base_ts = struct.unpack(">I", container[0x03])[0]

        records = []
        for tag, value in items:
            if tag != 0x84:
                continue
            sub = tlv_dec(value)
            offset = sub.get(0x05, b"\x00")[0]
            raw_data = sub.get(0x06, b"")
            records.append({
                "record": index,
                "timestamp": base_ts + 60 * offset,
                "raw": raw_data.hex(),
                **self._parse_step_features(raw_data),
            })
        return records

    async def get_sleep_data_record(self, index: int) -> list[dict]:
        tlv = tlv_enc(0x81, tlv_enc(0x02, struct.pack(">H", index)))
        tlvs = await self._transact_encrypted(SVC_FITNESS, 0x0D, tlv, timeout=20.0)
        items = tlv_items(tlvs[0x81])

        records = []
        for tag, value in items:
            if tag != 0x83:
                continue
            sub = tlv_dec(value)
            stamp = sub.get(0x05, b"\x00" * 6)
            start = struct.unpack(">I", stamp[:4])[0]
            duration = struct.unpack(">H", stamp[4:6])[0] * 60
            records.append({
                "record": index,
                "start": start,
                "end": start + duration,
                "duration_sec": duration,
                "stage": sub.get(0x04, b"\x00")[0],
            })
        return records

    async def get_recent_fitness_preview(self, hours: int = 24,
                                         max_step_records: int = 5) -> dict:
        counts = await self.get_recent_fitness_counts(hours=hours)
        steps, sleep = [], []
        for index in range(min(max(counts.get("steps", 0), 0), max_step_records)):
            steps.extend(await self.get_step_data_record(index))
        for index in range(max(counts.get("sleep", 0), 0)):
            sleep.extend(await self.get_sleep_data_record(index))
        return {"counts": counts, "steps": steps, "sleep": sleep}

    async def disconnect(self):
        await asyncio.sleep(0.3)
        await self.client.stop_notify(GATT_READ)


# ── Main ──────────────────────────────────────────────────────────────────────

async def run():
    cfg = load_or_create_config()
    logger.info(f"Connecting to {cfg['device_mac']}...")

    async with BleakClient(cfg["device_mac"]) as client:
        band = Band(client=client, cfg=cfg)
        await band.connect()
        await band.handshake()

        try:
            bat = await band.get_battery()
            logger.info(f"Battery: {bat}%")
        except Exception as e:
            logger.warning(f"Battery query failed (expected until fully initialised): {e}")

        try:
            preview = await band.get_recent_fitness_preview(hours=24)
            logger.info(f"Recent fitness preview (24h): {json.dumps(preview, indent=2)}")
        except Exception as e:
            logger.warning(f"Fitness preview query failed: {e}")

        await band.disconnect()


if __name__ == "__main__":
    asyncio.run(run())
