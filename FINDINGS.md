# Huawei Band 10 BLE Reverse Engineering — Findings & Context

_Last updated: 2026-05-13_

---

## 1. Goal

Build a **WHOOP-like experience** for the Huawei Band 10 without flashing the device
(flashing erases months of historical data). The official Huawei Health app only exports
data in batch / Google-Takeout style — no real-time API exists.

### Chosen approach

Directly speak the **Huawei LPv2 proprietary BLE protocol** from a Python script over
Bluetooth LE using [bleak](https://github.com/hbldh/bleak). Reference implementation:
[Gadgetbridge](https://codeberg.org/Freeyourgadget/Gadgetbridge) (Java/Android).

---

## 1.1 Current Status (2026-05-13)

HiChain3 is no longer the active blocker. First-auth succeeded earlier and `band.ini`
now contains both the persistent HiChain `auth_key` and reconnect transaction
`secret_key`. Reconnect auth (`operationCode=0x02`) is stable and does not require a
band prompt.

Latest verified reconnect/init run: `data/run_live_hrv_mode_matrix.log`.
Latest full data refresh: `data/run_full_data_refresh.log`.
Local dashboard: `dashboard/index.html` served from the repo root, verified at
`http://127.0.0.1:8765/dashboard/`.

What works:

| Area | Status | Notes |
|---|---|---|
| HiChain3 reconnect | Working | Four-step reconnect completes; new session transaction key is saved each run. |
| Connected-state init | Mostly aligned | Product, time, supported services, supported commands, expand capabilities, setting related, accept agreements, reverse capabilities, setup device status, wear status, connect status, feature config ACK all complete. |
| Fitness history | Working | Latest 24h: 6019 steps, 159 sleep minutes, 472 HR samples, 74 SpO2 samples. |
| P2P service ping | Working | `hw.watch.health.filesync` replies `cmd=0x03 code=0xca` to service ping. |
| P2P dictionary probe classification | Working | Probe distinguishes `ack_no_data` from `0x000186a4` auth/unsupported errors. |
| Huawei Health dictionary mapping | Confirmed | Decompiled APK confirms `SLEEP_DETAILS=700013` includes `avgHrv`, HRV baseline, sleep score, SpO2 and breath-rate fields. |
| Live RRI HRV route | Transport verified, samples blocked | `svc=0x19/cmd=0x01 type=0x03` is accepted with `0x000186a0`; band immediately sends `svc=0x19/cmd=0x05 status=0x0001ec38` and no RRI/SQI containers. Added transport diagnostics and Huawei-app-shaped `vol_status` probing. |
| Persistent connected mode | Working in bounded soak | `band_daemon.py` kept a reconnect session open, ran keepalives and sync cycles, and wrote `data/connection_status.json`. This is the path for "band remains connected"; one-shot `connect.py` still disconnects by design. |

Open constraints:

| Area | Current result | Interpretation |
|---|---|---|
| `0x1A/0x0A` country code | Capability bit says yes, command bitmap does not advertise it; direct send times out | Skipped unless the command appears in the runtime bitmap. This restored reliable fitness and P2P ping. |
| Connect status | Returns TLV `0x7F=000186a0` | Treat as OK (`100000`), not an auth error. |
| Standalone HRV dictionary `500044` | Capability `hrv=false`; P2P route returns `0x000186a4` | Standalone HRV is not exposed on this firmware. |
| Live RRI `0x19/0x05` | Returns `0x0001ec38` immediately after successful open | Gadgetbridge confirms the command shape, but Huawei Health's `serviceId_25.json` says `cmd=0x01` has optional tag `0x02=vol_status`; testing `type=0x03,vol_status=1` still returns `0x0001ec38`. |
| PermissionCheck `0x01/0x38` | Band asks for permission `1`; reply status frame is `0x000186a4` | Gadgetbridge treats permission ACK as fire-and-forget. Python now replies and records status-only frames instead of treating them as fatal auth rejects. Permission 1 appears SMS/call-related, not the RRI gate. |
| P2P dictionary classes | `skin_temperature=ack_no_data`; emotion/sleep_apnea/etc return `0x000186a4` | P2P module is alive, but these classes are either gated or unsupported for host pull. |
| Sequence sleep file `sequence_data/SLEEP_DETAILS` | Parser implemented, file-init route still returns status-only/no metadata | Sleep HRV may still exist in device data, but this pull trigger is incomplete or firmware-gated. |
| P2P ping after failed file-sync attempts | Can fail later in the same session | A fresh session pings cleanly. The dashboard uses the latest successful P2P probe artifact and marks file-sync routes separately. |

### HRV Source Audit (Gadgetbridge + Huawei Health APK)

There are three distinct HRV-looking paths, and they are not equivalent:

1. **Live RRI stream / stress calibration**: Gadgetbridge class
   `HuaweiStressCalibration` starts `HrRriTest` (`svc=0x19/cmd=0x01`) with
   type `0x03`, listens for RRI/SQI notifications on `cmd=0x05`, then stops with
   type `0x04`. `HuaweiStressHRVCalculation` computes RMSSD-like and
   frequency-domain HRV features from 50-70 seconds of high-quality SQI data.
   This is the strongest route for "make HRV work" today because the Band 10
   advertises service `0x19/cmd=0x01`. As of the latest probe, the open request
   succeeds but sample emission is blocked by status `0x0001ec38`; the working
   code now records request type, optional `vol_status`, and all transport status
   frames into `data/latest_live_hrv.json`.
2. **Sleep sequence HRV**: Gadgetbridge `downloadDictTrueSleepData()` requests
   `sequence_data` with dictionary class `700013`. The decompiled APK confirms
   fields `avgHrv=700013878`, `minHrvBaseline=700013305`,
   `maxHrvBaseline=700013355`, and `hrvDayToBaseline=700013824`. Our parser is
   aligned, but this band currently returns success-without-metadata for the file
   init, so no payload is available yet.
3. **Standalone P2P HRV dictionary**: APK class `500044` /
   `heartRateVariabilityRMSSD=500044831` exists, but the Band 10 reports
   `hrv=false` in expanded capabilities and returns `0x000186a4` for host pull.
   Keep it as a diagnostic route, not the primary HRV path.

New local analytics code writes `data/latest_insights.json` and combines live RRI
or sleep-sequence HRV, resting HR, sleep amount, SpO2, HR-load strain, and
short/long training load into a dashboard-ready readiness model. The recovery score
is intentionally labeled as a local model, not a WHOOP clone.

### Gadgetbridge vs Current Implementation

Gadgetbridge dynamic init flow after auth:

1. Product, time, battery, supported services.
2. Supported commands and expanded capabilities.
3. Register DataSync handlers early.
4. Extended account, setting related, accept agreements, reverse capabilities.
5. Setup device status and wear status only if `supportsMultiDevice()`.
6. Connect status.
7. A long queue of optional features gated by command/capability checks.

Current Python implementation now matches the critical pieces:

- Uses command bitmap for service support.
- Uses expanded capability bits for `multi_device`, `dict_sleep_sync`,
  `device_command_dict_data`, `emotion`, `sleep_apnea`, `reverse_capabilities`.
- Sends accept-agreement TLV exactly like Gadgetbridge.
- Sends reverse capabilities `FD F7 73 7A` like Gadgetbridge.
- Sends setup-device-status and wear-status only when `multi_device=true`.
- Skips the unsupported `0x1A/0x0A` country-code command even though the capability
  bit is set, because the actual command bitmap omits it and empirical runs show a
  timeout harms subsequent operations.

### Decompiled Huawei Health Comparison

The decompiled app does not expose the low-level BLE transport directly; most device
I/O is delegated through Huawei services/WearEngine. It is still useful for data
dictionary identity and field validation:

- `resources/assets/dict_config.txt` contains `SLEEP_DETAILS` class `700013`.
- `resources/assets/arkui-x/arkuix/resources/rawfile/serviceId_25.json` maps
  service `25` (`0x19`) command `1` to `hr_type` plus optional `vol_status`, and
  command `3` to a real-time HR list. This appears to be Huawei's newer realtime
  HR surface; it is related to, but not identical to, Gadgetbridge's RRI parser on
  `cmd=0x05`.
- `DicDataTypeUtil.java` confirms `SLEEP_DETAILS_AVG_HRV`,
  `SLEEP_DETAILS_HRV_DAY_TO_BASELINE`, `SLEEP_DETAILS_AVG_BREATHRATE`,
  `SLEEP_DETAILS_AVG_OXYGEN_SATURATION`, `SLEEP_DETAILS_SLEEP_SCORE`, etc.
- `WearEngineModule.DATA_DICTIONARY_SYNC_MODULE("datadictionarysync")` confirms the
  P2P module naming used by Gadgetbridge and this script.

### Execution Plan

1. Run `band_daemon.py` for normal use; one-shot scripts are diagnostic only and
   leave the band disconnected when they exit.
2. Keep the stable reconnect/init path; do not return to first-auth unless
   `band.ini` is intentionally cleared.
3. Treat fitness minute history as the reliable base data source for the first web UI:
   steps, HR, resting HR, SpO2, calories, sleep segments, strain proxy.
4. Keep RRI/stress and sleep-sequence routes as experimental panels with clear
   status/error reporting.
5. Avoid unsupported commands that empirically destabilize the session (`0x1A/0x0A`).
6. Continue HRV work through two precise routes: solve `0x19/0x05=0x0001ec38`
   for live RRI, and solve the `sequence_data/SLEEP_DETAILS` trigger for sleep HRV.
7. Build a local web dashboard over the JSON artifacts in `data/`, then continue
   adding panels as more routes become available. First dashboard is implemented in
   `dashboard/` and uses the reliable fitness artifacts plus explicit experimental
   route statuses.

## 2. Device Info

| Field | Value |
|---|---|
| Device name | `HUAWEI Band 10-44F` |
| Bluetooth address | `88:8E:68:A2:E4:4F` |
| Connection type | BLE only |
| Protocol | Huawei LPv2 |
| Auth scheme | HiChain3 (deviceSupportType=4, authType=0x05) |
| Auth version | 1 (negotiated from link params, tag 0x05 byte[1]) |
| enc_method | 0x00 (AES-CBC for PIN decryption) |

---

## 3. Protocol: Huawei LPv2

### 3.1 GATT characteristics

| Role | UUID |
|---|---|
| Write (host → band) | `0000fe01-0000-1000-8000-00805f9b34fb` |
| Read/Notify (band → host) | `0000fe02-0000-1000-8000-00805f9b34fb` |

### 3.2 Packet frame format (unsliced)

```
[0x5A]  magic byte
[LL HH]  length = len(svcId + cmdId + TLV) + 1  (big-endian, 2 bytes)
[0x00]   null "slice" byte for unsliced packets
[svcId]  service ID (1 byte)
[cmdId]  command ID (1 byte)
[TLV…]   payload (variable)
[CK HI][CK LO]  CRC16-HQXQ of everything above (2 bytes, big-endian)
```

`crc16 = binascii.crc_hqx(header_plus_body, 0)` — matches Gadgetbridge's
`CheckSums.getCRC16(data, 0x0000)`.

### 3.3 Sliced packets (large payloads > ~237 bytes)

When a payload is too large for a single BLE MTU, it is split:

| slice byte (offset 3) | meaning |
|---|---|
| `0x01` | first frame (contains svcId + cmdId immediately after) |
| `0x02` | middle frame |
| `0x03` | last frame |

Byte at offset 4 is a **flag counter** (0–255, wraps) shared across all frames of one message.

Frame header for sliced packets: `[0x5A][len+2 big-endian][slice_byte][flag][payload][CRC16]`

On receive, first buffer BLE-level fragments until a complete LPv2 frame is
available (`frame_len = length_field + 5`). Then reassemble Huawei slices:
sliced frame content begins at byte offset 5 (`magic,len,slice,flag` come first).
Concatenate the first slice's `svc/cmd + TLV` and following slices' TLV bytes,
then reconstruct as a synthetic unsliced frame so `parse_frame` can process it
uniformly.

### 3.4 TLV encoding

```
[tag: 1 byte][length: Huawei VarInt][value: N bytes]
```

Huawei's TLV length is a big-endian 7-bit VarInt with the high bit indicating
continuation. It is **not** `0x7F + uint16`.

Examples:
```
len=126 -> 7E
len=127 -> 7F
len=128 -> 81 00
len=671 -> 85 1F
```

---

## 4. Handshake Sequence

All steps are request→response on **service 0x01**.

```
Step  Cmd    Name
  1   0x01   Link Params          — negotiate slice size, get auth version + serverNonce
  2   0x33   Security Negotiation — send authMode + androidId, receive authType
  3   0x2C   PIN Code             — band returns AES-CBC encrypted PIN, shows confirmation screen
  4   0x28   HiChain3 (4 rounds)  — mutual auth HMAC/HKDF/AES-GCM, yields authToken
```

Step 3 is **first-auth only**. On reconnect (stored `secret_key` in `band.ini`), skip step 3
and run HiChain3 with `op_code=0x02` instead of `0x01`.

### 4.1 Link Params (cmd=0x01)

Send TLVs: tags 0x01, 0x02, 0x03, 0x04 (empty, just querying).

Key response fields:

| Tag | Field |
|---|---|
| 0x05 | serverNonce blob: `[unknown][authVersion][16-byte nonce][...]` |
| 0x02 | max slice size (2 bytes big-endian) |
| 0x07 | deviceSupportType (1 byte) |
| 0x08 | authAlgo (1 byte) |
| 0x09 | bondState (1 byte) |
| 0x0C | encryptMethod (0=AES-CBC, 1=AES-GCM) |

Band 10 returns `deviceSupportType=4`.

### 4.2 Security Negotiation (cmd=0x33)

Send:
- Tag 0x01: authMode (= deviceSupportType = 4 for Band 10)
- Tag 0x02: `\x01` (when authMode ∈ {2, 4})
- Tag 0x05: androidId as ASCII bytes. Gadgetbridge stores this as a 32-character uppercase hex string
  (`StringUtils.bytesToHex(HuaweiCrypto.generateNonce())`) and sends `androidID.getBytes(UTF_8)`.
- Tag 0x03: `\x01`, Tag 0x04: `\x00`
- Tag 0x06: empty tag and Tag 0x07: phone model when authMode=4
- Tag 0x0D: `\x01` (if encMethod=GCM)

Response parsing for authType:
- Tag 0x01 value=0x01 → authType = 0x0186A0 (Normal auth)
- Tag 0x01 value=0x04 → pw = 4
- Tag 0x02 value=N → authType = N ^ pw
- Tag 0x7F → direct authType

Band 10 result: `authType = 0x05` (because tag 0x01 returns 0x04 → pw=4, tag 0x02 returns 0x01 → 1^4=5).

`is_hichain3(authType)` = `(authType ^ 0x01) == 0x04` → True for 0x05.

### 4.3 PIN Code (cmd=0x2C)

Send: `tlv_enc(0x01)` (empty tag 0x01).

Band response:
- Tag 0x01: encrypted PIN bytes
- Tag 0x02: IV

Decryption: `aes_cbc_dec(msg, DIGEST_SECRETS[auth_version], iv[:16])`

The band shows a **pairing confirmation screen** — user must confirm on device.
PIN is 6 decimal digits (e.g. `325533`), returned as UTF-8 hex bytes.

Timeout for this step: 30 seconds (user needs time to confirm).

### 4.4 HiChain3 (cmd=0x28, 4 rounds)

All messages are JSON encoded in TLV tag 0x01, with op_code in tag 0x02, request_id in tag 0x03.

#### PSK derivation (first-auth, op=0x01)
```python
pin_hex_utf8 = pin_code.hex().encode("utf-8")   # e.g. b"333235353333"
key          = sha256(pin_hex_utf8)
psk          = hmac_sha256(key, seed)            # seed = 32 random bytes sent in step 1
```

#### PSK derivation (reconnect, op=0x02)
```python
psk = hmac_sha256(self.secret_key, seed)
```

#### Session key derivation
```python
salt        = rand_self + rand_peer
session_key = HKDF(psk, salt=salt, info=b"hichain_iso_session_key", length=32)
```

#### Round 1 — send
```json
{
  "isoSalt": "<rand_self uppercase hex>",
  "peerAuthId": "<uppercase hex of android_id ASCII bytes>",
  "operationCode": 1,
  "seed": "<seed uppercase hex>",
  "peerUserType": 0,
  "version": {"minVersion":"1.0.0","currentVersion":"2.0.16"},
  "authForm": 0,
  "message": 1,
  "requestId": "<current epoch millis>",
  "groupId": "7B0BC0CBCE474F6C238D9661C63400B797B166EA7849B3A370FC73A9A236E989",
  "groupName": "health_group_name",
  "groupOp": 2,
  "groupType": 256,
  "peerDeviceId": "<uppercase android_id string>",
  "connDeviceId": "<uppercase android_id string>",
  "appId": "com.huawei.health",
  "ownerName": "",
  "groupAndModuleVersion": "2.0.1"
}
```

#### Round 1 — receive
```json
{"isoSalt": "<rand_peer hex>", "peerAuthId": "<band_id hex>", "token": "<HMAC hex>"}
```

The JSON TLV value may contain a trailing NUL byte; strip `\x00` before
`json.loads`.

Verify: `HMAC(psk, rand_peer + rand_self + auth_id_self + auth_id_peer) == token`

#### Round 2 — send
```json
{"peerAuthId": "<uppercase hex of android_id ASCII bytes>", "token": "<uppercase HMAC hex>"}
```
token = `HMAC(psk, rand_self + rand_peer + auth_id_peer + auth_id_self)`

#### Round 2 — receive
```json
{"returnCodeMac": "<HMAC hex>"}
```
Verify: `HMAC(psk, b"\x00\x00\x00\x00") == returnCodeMac`

#### Round 3 — send (first-auth only)
```json
{"nonce": "<12-byte nonce hex>", "encData": "<AES-GCM(challenge, session_key, nonce, 'hichain_iso_exchange') hex>"}
```
`challenge` = 16 random bytes.

#### Round 3 — receive (first-auth only)
```json
{"nonce": "<nonce hex>", "encAuthToken": "<encrypted hex>"}
```
Decrypt: `AES-GCM(enc_auth_tok, session_key, nonce3, aad=challenge)` → authToken (32 bytes).
**Save this as `secret_key` in `band.ini` for future reconnects.**

#### Round 4 — send
```json
{"nonce": "<12-byte nonce hex>", "encResult": "<AES-GCM(b'\\x00\\x00\\x00\\x00', session_key, nonce, 'hichain_iso_result') hex>", "operationCode": 1}
```

#### Round 4 — receive
```json
{"message": 20}   # or similar final ack
```

The final ACK may also be TLV format rather than JSON:
- tag 0x01: `com.huawei.health`
- tag 0x04: response type (nonzero; observed `0x01` for first-auth final ACK and `0x02` for bind final ACK)
- tag 0x05: status (`0x00`)

Treat this as `step=4` success. After first-auth (`op=0x01`) succeeds,
Gadgetbridge immediately starts a second HiChain pass with `op=0x02`; that bind
pass derives the final `hichain_return_key`.

---

## 5. Crypto Constants

These are hardcoded in both Gadgetbridge and `huawei-lpv2`. Do NOT change them.

### DIGEST_SECRETS (for PIN decryption)

| Version | Key (hex) |
|---|---|
| 1 | `70FB6C24035FDB552F38898AEEDE3F69` |
| 2 | `93ACDEF76ACB09857DBFE5261AABCD78` |
| 3 | `9C2763A9CCE134766DE3FF611820055` |

### GROUP_ID
```
7B0BC0CBCE474F6C238D9661C63400B797B166EA7849B3A370FC73A9A236E989
```

### Client MAC format
Use a fake MAC like `FF:FF:FF:XX:XX:XX` (Gadgetbridge style), not the real laptop BT MAC.

---

## 6. Bugs Fixed

### 6.1 Wrong packet frame format (vs huawei-lpv2 library)
The `huawei-lpv2` library had three bugs:
1. Length field was `len(body)` → must be `len(body) + 1`
2. Missing `\x00` byte between length and svc/cmd
3. 1-byte XOR checksum → must be 2-byte CRC16-HQXQ

Fix: completely rewrote `frame_packet` / `_make_unsliced` / `_make_sliced`.

Verified against known-good packet: `5a000b0001010100020003000400f13b`

### 6.2 asyncio event loop in BLE callback
Under `asyncio.run()`, calling `asyncio.get_event_loop()` inside a bleak notify callback
returns the wrong/closed loop.

Fix: capture `self._loop = asyncio.get_running_loop()` in `Band.connect()`, then use
`self._loop.call_soon_threadsafe(self._event.set)` in `_on_notify`.

### 6.3 Missing SecurityNegotiation step
The original `huawei-lpv2` library skipped cmd=0x33 (Security Negotiation) entirely for
BLE devices with `deviceSupportType != 0`. Without it, the band ignores the auth request.

Fix: always run `security_negotiation()` when `dev_support_type != 0`.

### 6.4 Wrong HMAC nonce order in HiChain3
Gadgetbridge order (correct):
- Peer token check: `HMAC(psk, rand_peer + rand_self + authIdSelf + authIdPeer)`
- Self token send: `HMAC(psk, rand_self + rand_peer + authIdPeer + authIdSelf)`

The huawei-lpv2 library had these reversed.

### 6.5 _recv aborting on unsolicited notifications
The band sends an async notification on `svc=0x25, cmd=0x03` while waiting for the
HiChain step 1 response on `svc=0x01, cmd=0x28`. The old single-shot `_recv` would
raise `ValueError` immediately on the first non-matching packet.

Fix: `_recv` now loops with a deadline, skipping non-matching packets:
```python
async def _recv(self, exp_svc, exp_cmd, timeout=15.0):
    deadline = asyncio.get_running_loop().time() + timeout
    while True:
        remaining = deadline - asyncio.get_running_loop().time()
        if remaining <= 0:
            raise asyncio.TimeoutError(...)
        await asyncio.wait_for(self._event.wait(), timeout=remaining)
        self._event.clear()
        svc, cmd, tlvs = parse_frame(self._rx_raw)
        if (svc, cmd) == (exp_svc, exp_cmd):
            return tlvs
        logger.debug(f"  Skipping unsolicited packet svc={svc:#x} cmd={cmd:#x}")
```

### 6.6 Duplicate DIGEST_SECRETS definition
Had two `DIGEST_SECRETS = {` blocks; the first had a malformed hex string causing
`ValueError: non-hexadecimal number found`. Fixed by removing the duplicate block.

---

## 7. Known Unsolicited Packets

| svc  | cmd  | Description |
|------|------|-------------|
| 0x25 | 0x03 | `MusicControl.Control` — band sends playback control events as background updates. Encrypted with `secretKey` (which is null during first auth). Gadgetbridge skips it entirely during first auth (returns early when secretKey==null). Do NOT send any ACK — sending wrong-key ACKs triggers band error responses and may confuse band state. |
| 0x37 | 0x01 | `DataSync.ConfigCommand` — encrypted data sync config push. Log and ignore during first auth. |
| 0x01 | 0x3D | Encrypted dev packet. Log and ignore during first auth. |

---

## 8. Current State (as of 2026-05-11)

| Step | Status |
|---|---|
| BLE connection | ✅ Working |
| Link params | ✅ Working (all 6 fields parsed) |
| Security negotiation | ✅ Working (correctly identifies HiChain3) |
| PIN code retrieval | ✅ Working (band shows screen, PIN received and decrypted) |
| HiChain3 step 1 send | ✅ Packet sliced and sent correctly |
| Band shows pairing confirmation | ✅ Confirmed visible on device |
| HiChain3 step 1 response | ⚠️ cmd=0x28 never received — fixes applied: (1) queue-based notifications so rapid-arrival packets don't overwrite each other, (2) peerDeviceId corrected to our android_id, (3) android_id changed to Gadgetbridge's 32-char ASCII format, (4) outbound HiChain hex now uppercase like Gadgetbridge. Needs re-test. |
| HiChain3 steps 2-4 | ⚠️ Not yet tested |
| authToken stored in band.ini | ⚠️ Not yet completed |
| Data retrieval (HR, HRV, sleep, SpO2) | ❌ Not started |
| WHOOP-like analytics | ❌ Not started |

---

## 9. Files

| File | Purpose |
|---|---|
| `connect.py` | Main BLE connector (~650 lines). Full HiChain3 auth implementation. |
| `scan.py` | BLE scanner. Highlights Huawei/Honor devices. |
| `band.ini` | Config: device MAC, client MAC, androidId, secret, secret_key. Auto-created. |

### band.ini format
```ini
[band10]
device_mac  = 88:8E:68:A2:E4:4F
client_mac  = FF:FF:FF:A9:F0:23
secret      = <16 bytes hex>
android_id  = <32-char Gadgetbridge-style uppercase hex string>
secret_key  =   ; filled after first successful HiChain3 auth
```

---

## 10. Next Steps

1. **Run `python connect.py`** — confirm pairing on band screen when prompted → complete HiChain3 → get `secret_key` into `band.ini`.
2. **Implement data retrieval** — after auth succeeds, query:
   - Heart rate history: service TBD, likely periodic HR log
   - Sleep stages: deep/light/REM/awake segments
   - HRV: RMSSD or raw RR intervals
   - SpO2: blood oxygen readings
   - Activity/step counts
3. **WHOOP-like analytics** — compute:
   - Recovery score: weighted(RHR trend, sleep HRV, sleep stage ratios, SpO2)
   - Strain score: heart rate zone time during activity
   - Sleep score: duration, efficiency, stage composition
4. **Dashboard / visualization** — terminal or web UI, polling every N minutes.

---

## 11. Reference

- Gadgetbridge source: `freeyourgadget/Gadgetbridge` on Codeberg
  - Key path: `app/src/main/java/nodomain/freeyourgadget/gadgetbridge/service/devices/huawei/`
  - Auth: `requests/` directory, `HuaweiCrypto.java`, `HuaweiSupportProvider.java`
- Python BLE: [bleak](https://github.com/hbldh/bleak) — callback signature is `(BleakGATTCharacteristic, bytearray)` in v3.x
- `huawei-lpv2` Python library: used as initial reference only; has auth bugs, was NOT used for implementation
