# Huawei Band 10 BLE Reverse Engineering — Findings & Context

_Last updated: 2026-05-14_

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
| Connected-state init | Mostly aligned | Product, time, battery, supported services/commands, expand capabilities, Gadgetbridge-style extended account, setting related, accept agreements, reverse capabilities, setup device status, wear status, one-shot connect status, feature config ACK all complete. |
| Fitness history | Working | Latest 24h: 6019 steps, 159 sleep minutes, 472 HR samples, 74 SpO2 samples. |
| P2P service ping | Working | `hw.watch.health.filesync` replies `cmd=0x03 code=0xca` to service ping. |
| P2P dictionary probe classification | Working | Probe distinguishes `ack_no_data` from `0x000186a4` auth/unsupported errors. |
| Huawei Health dictionary mapping | Confirmed | Decompiled APK confirms `SLEEP_DETAILS=700013` includes `avgHrv`, HRV baseline, sleep score, SpO2 and breath-rate fields. |
| Sleep sequence HRV | Working | `sequence_data/SLEEP_DETAILS` now downloads via service `0x2C`; latest 48h pull produced 4 sessions, 2 valid HRV summaries, latest full-sleep `avgHrv=48 ms` with baseline range `28-51`. |
| Live RRI HRV route | Working after reset | 2026-05-14 daemon stress calibration captured 81 RRI samples, 48 clean intervals, RMSSD `53.7 ms`, SQI-100 count 72, Huawei stress score 54/level 2, then enabled automatic stress via `svc=0x20/cmd=0x09`. |
| Persistent connected mode | Working in bounded soak | `band_daemon.py` kept an authenticated session open for 120s, ran two sync cycles and battery keepalives, and exited with `soak_complete`. `run_dashboard.py` is now the normal workflow: it serves the web dashboard and runs the daemon in one process. One-shot `connect.py` still disconnects by design. |
| Weather push | Working | Live daemon command on 2026-05-14 returned `0x000186a0` for start, unit, current weather, GPS/time, and forecast. Forecast only succeeded after matching Gadgetbridge's timing: include today's row at the current observation timestamp, then future rows at `timestamp + 86400 * n`. |

Open constraints:

| Area | Current result | Interpretation |
|---|---|---|
| `0x1A/0x0A` country code | Capability bit says yes, command bitmap does not advertise it; direct send times out | Skipped unless the command appears in the runtime bitmap. This restored reliable fitness and P2P ping. |
| Connect status | Returns TLV `0x7F=000186a0` | Treat as OK (`100000`), not an auth error. |
| Repeated connect-status keepalive | Later returns `0x000186a4` | Gadgetbridge sends connect status during init, not as a periodic heartbeat. The daemon now uses battery as the default keepalive and only repeats connect status when `BAND10_KEEPALIVE_MODE=connect_status`. |
| Standalone HRV dictionary `500044` | Capability `hrv=false`; P2P route returns `0x000186a4` | Standalone HRV is not exposed on this firmware. |
| Live RRI `0x19/0x05` | Working after factory reset/stored reconnect | Earlier runs returned `0x0001ec38`; latest `type=0x03` calibration emitted RRI/SQI samples and closed cleanly with `0x000186a0`. Keep the transport status visible because firmware/session state can still gate this route. |
| PermissionCheck `0x01/0x38` | Band asks for permission `1`; reply status frame is `0x000186a4` | Gadgetbridge treats permission ACK as fire-and-forget. Python now replies and records status-only frames instead of treating them as fatal auth rejects. Permission 1 appears SMS/call-related, not the RRI gate. |
| P2P dictionary classes | `skin_temperature=ack_no_data`; emotion/sleep_apnea/etc return `0x000186a4` | P2P module is alive, but these classes are either gated or unsupported for host pull. |
| Sequence sleep file `sequence_data/SLEEP_DETAILS` | Working | File init may include both `0x7F=000186a0` and metadata tags. Treating any `0x7F` as status-only was wrong; after fixing that, file-info and block download complete normally. |
| P2P ping after failed file-sync attempts | Can fail later in the same session | A fresh session pings cleanly. The dashboard uses the latest successful P2P probe artifact and marks file-sync routes separately. |
| Empty quick fitness pulls | Can happen during lightweight daemon sync | The daemon/connect runner now records the empty pull in sync status but does not overwrite the last good dashboard fitness/recovery artifacts. |

### HRV Source Audit (Gadgetbridge + Huawei Health APK)

There are three distinct HRV-looking paths, and they are not equivalent:

1. **Live RRI stream / stress calibration**: Gadgetbridge class
   `HuaweiStressCalibration` starts `HrRriTest` (`svc=0x19/cmd=0x01`) with
   type `0x03`, listens for RRI/SQI notifications on `cmd=0x05`, then stops with
   type `0x04`. `HuaweiStressHRVCalculation` computes RMSSD-like and
   frequency-domain HRV features from 50-70 seconds of high-quality SQI data.
   This route is now live-proven after the factory reset and stored reconnect:
   the daemon stress calibration captured 81 RRI samples over 65 seconds, 48
   clean intervals, RMSSD `53.7 ms`, and Huawei stress score `54`/level `2`.
   The same command enabled automatic stress using that live seed. The code still
   records request type, optional `vol_status`, and all transport status frames
   into `data/latest_live_hrv.json` because earlier bonded-state runs returned
   `0x0001ec38` without samples.
2. **Sleep sequence HRV**: Gadgetbridge `downloadDictTrueSleepData()` requests
   `sequence_data` with dictionary class `700013`. The decompiled APK confirms
   fields `avgHrv=700013878`, `minHrvBaseline=700013305`,
   `maxHrvBaseline=700013355`, and `hrvDayToBaseline=700013824`. This is now the
   primary HRV source. A verified 48-hour pull downloaded a 2184-byte
   `sequence_data` file and parsed `avgHrv=19 ms` for the prior main sleep plus
   `avgHrv=48 ms` for the latest main sleep. Short nap-like stage-5 sessions can
   carry zero HRV and are ignored by analytics.
3. **Standalone P2P HRV dictionary**: APK class `500044` /
   `heartRateVariabilityRMSSD=500044831` exists, but the Band 10 reports
   `hrv=false` in expanded capabilities and returns `0x000186a4` for host pull.
   Keep it as a diagnostic route, not the primary HRV path.

New local analytics code writes `data/latest_insights.json` and combines
sleep-sequence HRV, live RRI HRV/stress when available, resting HR, sleep amount, SpO2, HR-load strain, and
short/long training load into a dashboard-ready readiness model. The recovery score
is intentionally labeled as a local model, not a WHOOP clone. The training load
model now uses an EWMA-style acute/chronic load calculation (7-day / 42-day time
constants), reports load ratio, balance, monotony, and guidance, and records the
latest live-HRV transport state/status in both `latest_insights.json` and the web
dashboard. This keeps HRV failure modes visible while still making the reliable
fitness, sleep, HR and SpO2 data useful. After reviewing Open Wearables'
MIT-licensed health-score algorithms, sleep scoring now uses the same style of
components that can be computed from our Band 10 artifacts: sigmoid duration
scoring, bedtime consistency when history contains window timestamps, and
fragmentation from sleep segment gaps. The dashboard also exposes an
Open-Wearables-style HRV resilience model based on coefficient of variation across
distinct sleep-sequence HRV sessions, so repeated syncs of the same night do not
inflate the stability score.
SpO2 analysis now reports minute-level low-duration summaries from Huawei fitness
history samples: average, minimum, minutes below 95%, and minutes below 92%. The
latest local build saw 30 SpO2 samples, average `97.2%`, minimum `94%`, `1` minute
below 95%, and `0` minutes below 92%.

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
- Sends `AccountRelated.SendExtendedAccountToDevice` when the band advertises both
  account judgment (`0x1A/0x05`) and account switch (`0x1A/0x06`).
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
  `cmd=0x05`. Python now records both `cmd=0x05` RRI/SQI packets and `cmd=0x03`
  realtime HR packets during live probes. Empirical result: `hr_type=1` opens a
  realtime HR stream on `cmd=0x03` using extended TLV tags `0x81/0x82`; `hr_type=3`
  is still the Gadgetbridge RRI/stress route and remains blocked by `0x0001ec38`.
- `DicDataTypeUtil.java` confirms `SLEEP_DETAILS_AVG_HRV`,
  `SLEEP_DETAILS_HRV_DAY_TO_BASELINE`, `SLEEP_DETAILS_AVG_BREATHRATE`,
  `SLEEP_DETAILS_AVG_OXYGEN_SATURATION`, `SLEEP_DETAILS_SLEEP_SCORE`, etc.
- `WearEngineModule.DATA_DICTIONARY_SYNC_MODULE("datadictionarysync")` confirms the
  P2P module naming used by Gadgetbridge and this script.

### Execution Plan

1. Run `python run_dashboard.py` for normal use; it serves
   `http://127.0.0.1:8765/dashboard/` and keeps one authenticated BLE session open.
   One-shot scripts are diagnostic only and leave the band disconnected when they
   exit.
2. Keep the stable reconnect/init path; do not return to first-auth unless
   `band.ini` is intentionally cleared.
3. Treat fitness minute history as the reliable base data source for the first web UI:
   steps, HR, resting HR, SpO2, calories, sleep segments, strain proxy.
4. Keep RRI/stress and sleep-sequence routes as experimental panels with clear
   status/error reporting. Live RRI probes are opt-in for daemon use
   (`BAND10_LIVE_HRV_EVERY`) until `0x19/0x05` emits samples reliably, so normal
   dashboard syncs do not repeatedly trigger the failing HRV path.
5. Avoid unsupported commands that empirically destabilize the session (`0x1A/0x0A`).
6. Continue HRV work through two precise routes: solve `0x19/0x05=0x0001ec38`
   for live RRI, and solve the `sequence_data/SLEEP_DETAILS` trigger for sleep HRV.
7. Build a local web dashboard over the JSON artifacts in `data/`, then continue
   adding panels as more routes become available. First dashboard is implemented in
   `dashboard/` and uses the reliable fitness artifacts plus explicit experimental
   route statuses, including the exact live-HRV open/data status codes from the
   latest probe.

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

---

## 12. 2026-05-13 Audit Update

### Connection

- Stored-key reconnect is now confirmed. Follow-up daemon runs return `authType=0x6`, use HiChain op=0x02, verify peer/self tokens, and complete without a pairing prompt.
- Gadgetbridge-style post-auth init is required for a stable connected state: product/time/battery, supported services/commands, expand capabilities, extended account (`svc=0x1a/cmd=0x05`), settings, agreements, reverse capabilities, setup status, wear status, connect status, and feature config upload.
- Passive health settings should remain enabled in normal daemon mode. A short run with `BAND10_ENABLE_PASSIVE_SETTINGS=0` dropped during fitness preview; the same bounded run with passive settings enabled stayed connected through battery keepalives.
- Battery reads are the safe daemon keepalive. Repeating `connect_status` after init can return `000186a4` on this firmware.

### HRV and Sleep

- HRV is working through the dictionary sleep sequence file: `sequence_data/SLEEP_DETAILS` (`dict_id=700013`).
- Latest valid artifact: `avgHrv=48 ms`, baseline `28-51 ms`, `sleepScore=70`, 278 sleep minutes, efficiency 92%, latency 18m, average HR 70, SpO2 98%, breath rate 14.
- Gadgetbridge and Huawei Health decompile agree on the key fields: `avgHrv`, `minHrvBaseline`, `maxHrvBaseline`, `hrvDayToBaseline`, `sleepScore`, `sleepEfficiency`, `avgHeartRate`, `avgOxygenSaturation`, and `avgBreathrate` under sleep details.
- Live RRI is not reliable on this Band 10 firmware: the open command succeeds and realtime HR packets arrive, but no RRI samples have been emitted. It remains an opt-in diagnostic route.
- Repeated stress/sleep file syncs can return `00023281`; the daemon now treats this as "no fresh file" and preserves the last good artifact.

### Analytics and UI

- `analytics.py` now promotes sleep-sequence data to the primary overnight physiology source when older fitness sleep segments are empty.
- Recovery now uses sleep-sequence HRV, sequence-derived sleep minutes/score, overnight average HR, SpO2, breath rate, and stage distribution.
- The dashboard now shows HRV baseline/resilience, sleep sequence vitals, stage bars, recovery heatmap, route status, and connection status.
- Open Wearables informed the resilience model: recent sleep HRV coefficient of variation maps to a provisional/stable/variable/unstable status.

---

## 13. 2026-05-13 Weather, Watchface, and Algorithm Audit

### Weather

Gadgetbridge has a complete Huawei weather implementation. The Band 10 route should be copied from:

- `devices/huawei/packets/Weather.java`
- `service/devices/huawei/HuaweiWeatherManager.java`
- `requests/SendWeatherStartRequest.java`
- `requests/SendWeatherSupportRequest.java`
- `requests/SendWeatherExtendedSupportRequest.java`
- `requests/SendWeatherSunMoonSupportRequest.java`
- `requests/SendWeatherCurrentRequest.java`
- `requests/SendWeatherForecastRequest.java`
- `requests/SendWeatherUnitRequest.java`

Protocol shape:

| Service | Command | Meaning |
|---|---:|---|
| `0x0f` | `0x09` | Weather start, TLV `0x01=0x03`, encrypted. Success is `0x000186a0` or `0x000186a3` in tag `0x7f`. |
| `0x0f` | `0x05` | Weather unit, TLV `0x01=0` Celsius or `1` Fahrenheit, encrypted. |
| `0x0f` | `0x02` | Basic support bitmap request, TLV `0x01`, encrypted. Response tag `0x01` bits: weather, wind, PM2.5, temp range, location, current temp, unit, AQI. |
| `0x0f` | `0x06` | Extended support bitmap request, TLV `0x01`, encrypted. Response tag `0x01` bits: time, source, weather icon. |
| `0x0f` | `0x0a` | Sun/moon support bitmap request, TLV `0x01`, encrypted. Response tag `0x01` bits: sunrise/sunset, moon phase. |
| `0x0f` | `0x01` | Current weather payload, encrypted. |
| `0x0f` | `0x08` | Hourly/daily forecast payload, encrypted and sliced. |
| `0x0f` | `0x04` | Device weather request/response. Band can ask for weather with status `0x000186aa`; otherwise reply OK. |
| `0x0f` | `0x07`/`0x0c` | Simple/extended weather error. |

Current weather TLVs:

- Container `0x81`: `0x02` Huawei weather icon, `0x03` wind direction/speed bit-packed as `(direction << 8) | Beaufort`.
- Container `0x85`: `0x06` low temperature Celsius, `0x07` high temperature Celsius.
- Scalar tags: `0x04` PM2.5, `0x08` location name, `0x09` current temp Celsius, `0x0a` unit, `0x0b` AQI, `0x0c` observation time epoch seconds, `0x0e` source, `0x0f` UV index, `0x10` humidity, `0x11` wind speed value, `0x12` feels-like temp.

Forecast TLVs:

- Hourly: outer `0x81`, repeated `0x82` entries with `0x03` timestamp, `0x04` icon, `0x05` temp, optional `0x06` precipitation and `0x07` UV index.
- Daily: outer `0x90`, repeated `0x91` entries with `0x12` timestamp, `0x13` icon, `0x14` high, `0x15` low, optional `0x16` sunrise, `0x17` sunset, `0x1a` moonrise, `0x1b` moonset, `0x1e` moon phase.

Weather-adjacent GPS/time:

- `HuaweiWeatherManager` optionally sends GPS/time after current weather and before forecast.
- Gadgetbridge gates this on supported command `0x18/0x06`, but the packet class sends `GpsAndTime.CurrentGPSRequest` on `svc=0x18/cmd=0x07`.
- Tags are `0x01` epoch seconds, `0x02` latitude as little-endian Java `Double`, and `0x03` longitude as little-endian Java `Double`.
- Gadgetbridge deliberately uses a timestamp about one day old so weather location does not override fresher workout GPS location. `connect.py` mirrors that and keeps GPS/time failure non-fatal for weather.

Huawei Health APK comparison:

- `defpackage/koq.java` is the decompiled `DataWeather` model. It has the same fields Gadgetbridge sends: weather, PM2.5, low/high/current temp, location, unit, AQI, observation/update time, wind direction/speed, source, forecast days/hours, UV index, humidity, windSpeedValue, and somatosensory/feels-like temperature.
- `WeatherForecastHour.java` includes time, temperature, weather icon, CN weather icon, precipitation, UV index, and somatosensory temperature.
- `WeatherForecastDay.java` includes time, icon, high/low temperature, CN icon, and future sun/moon data.
- `mbd.java` parses capability bundle keys matching Gadgetbridge support bits: `weather_support`, `wind_support`, `pm2_5_support`, `temperature_support`, `location_name_support`, `temperature_current_support`, `unit_support`, `aqi_support`, `time_support`, `source_support`, `cn_weather_icon_support`, and `weather_icon_expand_support`.

Implementation choice: start with Gadgetbridge's support negotiation plus current weather/forecast/GPS-time. Keep weather async device requests guarded so a `0x000186aa` request cannot recursively start a second weather chain while one is already running.

### Watchfaces

Gadgetbridge has a usable watchface route, but it is riskier than weather because it writes files to the device.

Key files:

- `devices/huawei/packets/Watchface.java`
- `service/devices/huawei/HuaweiWatchfaceManager.java`
- `service/devices/huawei/HuaweiFwHelper.java`
- `requests/GetWatchfaceParams.java`
- `requests/GetWatchfacesList.java`
- `requests/GetWatchfacesNames.java`
- `requests/SendWatchfaceConfirm.java`
- `requests/SendWatchfaceOperation.java`
- file upload service `0x28`

Protocol shape:

| Service | Command | Meaning |
|---|---:|---|
| `0x27` | `0x01` | Watchface params: max version, width, height, supported file type, sort, other versions. |
| `0x27` | `0x02` | Installed watchface list. Request tags `0x01` and `0x06=0x03` for overseas non-test. Response has outer `0x81`, repeated `0x82` entries. |
| `0x27` | `0x03` | Operation: activate `1` or delete `2`; tags `0x01` name, `0x02` version, `0x03` operation. |
| `0x27` | `0x05` | Confirm uploaded watchface; tags name/version plus `0x7f=0x000186a0`. |
| `0x27` | `0x06` | Resolve watchface display names for installed file IDs. |

Packaging:

- Gadgetbridge reads `description.xml`, preview `preview/cover.jpg`, and either `com.huawei.watchface` or `com.honor.watchface`.
- That nested file may itself be a zip containing `watchface.bin`; older packages can already contain the bin.
- File upload type is `1` for watchface. File name format is `<random9digits>_1.0.0`.
- APK comparison confirms Huawei's model fields through `WatchFaceInfo.java` and `WatchFaceOperateInfo.java`: max version, width, height, support file type, current/preset/non-preset lists, watchface ID, version, operation, dimensions, sync type, and error code.

Implementation choice: first add read-only params/list/name support. Activating an already installed face is now available because it is a small metadata operation. Upload/delete/custom faces remain gated until a known-compatible package has been deliberately selected and tested.

Implementation status: `connect.py` now has watchface inventory calls for params (`0x27/0x01`), installed list (`0x27/0x02`), names (`0x27/0x06`), and safe installed-face activation (`0x27/0x03`, operation `1`). `band_daemon.py` and the PWA expose scan and activation commands. No upload/delete path is implemented yet.

Live status on 2026-05-14:

- Inventory succeeded through the daemon: Band 10 reports max watchface version `2.4`, display `194x368`, file type `1`, and 8 installed faces.
- Current face before the write test was `Activity rings` (`2180325453`, `2.4.3`).
- Activation of installed non-current `SuperWatch` (`2180307753`, `2.4.2`) succeeded with response tag `0x04=00`, and inventory showed it as current.
- Activation back to `Activity rings` also succeeded with response tag `0x04=00`. No upload/delete path has been attempted.
- `watchface_tool.py` validates `.hwt` packages locally before any future upload attempt. It mirrors Gadgetbridge's parser: `description.xml`, root `HwTheme`/`HnTheme`, `preview/cover.jpg`, `com.huawei.watchface` or `com.honor.watchface`, nested `watchface.bin` fallback to raw payload, and Band 10 resolution `368*194` (`HWHD07`/`HNHD02`).
- `POST /api/watchface/validate` now exposes that validator to the PWA. It saves a redacted `latest_watchface_validation.json` report with file name, metadata, payload size, target dimensions, errors, and warnings. It never queues a file upload and returns `upload_enabled=false`.
- The dashboard Watchface Lab is validation-only. It can prove a package is structurally plausible for Band 10, but the custom upload/write path remains disabled until a known-compatible `.hwt` is intentionally tested.

### Algorithm Sources

- Open Wearables is the best open-source algorithm baseline found so far. It has explicit sleep scoring primitives, duration/stage/consistency/interruption scoring, and HRV resilience helpers.
- WHOOP's public docs confirm high-level behavior, not exact formulas: recovery is driven mainly by HRV, resting HR, respiratory rate, sleep, skin temp, and SpO2; strain is cardiovascular load on a logarithmic 0-21 scale.
- Huawhoop recovery remains deterministic and source-visible: HRV, resting HR, sleep performance, SpO2, and recent load trend are scored as separate components before a weighted recovery blend.
- Sleep scoring uses the local Open Wearables reference shape from `open-wearables-full/backend/app/algorithms/sleep.py`: duration, stage quality, consistency, and awake/interruption penalties. Huawei's own sleep score is blended in when the sequence dictionary exposes it.
- Strain now uses a transparent Banister-style HR reserve/TRIMP core plus conservative active-minute and step load. Inputs are Huawei minute samples: HR zones, active minutes, vigorous minutes, and detected step total. The output remains a WHOOP-like logarithmic 0-21 scale and records `trimp`, `activity_load`, `combined_load`, `zone_minutes`, `active_minutes`, and `method` in `latest_insights.json`.
- Sleep sequence is now preferred over older fitness-history sleep fragments. Huawei sequence stages are mapped through Gadgetbridge semantics: `1=light`, `2=REM`, `3=deep`, `4=awake`, `5=nap/light`.
- Sleep scoring now uses Open Wearables-inspired pillars: duration sigmoid, deep/REM stage target score, bedtime consistency when enough history exists, and awake-interruption penalty. Latest local artifact changed sleep minutes from the misleading 17-minute fitness fragment to the 278-minute sequence session.

### Bridge API

- `run_dashboard.py` now exposes a local bridge API while serving the static dashboard:
  - `GET /api/status`: bridge, connection, latest sync, insights, and recent command results.
  - `GET /api/bridge-info`: loopback/LAN URLs, CORS allowlist, token requirement, and bind status for phone/hosted PWA setup.
  - `GET /api/insights`: latest analytics artifact.
  - `GET /api/export`: compact combined export for PWA/cloud handoff. Redacted by default; `?private=1` requires `BAND10_BRIDGE_TOKEN` if configured.
  - `GET /api/artifacts/<allowlisted-file>`: selected runtime artifacts only.
  - `POST /api/commands/sync`: queues a daemon sync without starting a second BLE script.
  - `POST /api/commands/weather`: queues a weather push command for the active daemon session.
  - `POST /api/commands/watchfaces`: queues read-only watchface inventory.
  - `POST /api/commands/watchface_activate`: queues activation of an installed watchface.
  - `POST /api/watchface/validate`: validates a local `.hwt` package and writes a redacted validation report without touching the band.
  - `POST /api/commands/stress`: queues automatic stress enable/calibration.
- `band_daemon.py` polls `data/bridge_commands.jsonl` from inside the one authenticated BLE session and writes results to `data/bridge_command_results.jsonl`.
- This is the first cross-device bridge: hosted PWA can point at a configured local bridge URL, while the bridge remains the only process touching BLE/auth secrets. Same-LAN use is supported by starting with `BAND10_DASHBOARD_HOST=0.0.0.0`; the PWA shows the LAN API URL in Settings.
- The daemon now explicitly scans before connecting and writes `scanning`/`not_found` states when Windows cannot see the band. This makes "connection failed" distinguishable from protocol/auth failure.

### PWA Shell

- The dashboard is now a mobile-first PWA shell rather than a static artifact viewer. It reads bridge API artifacts when served by `run_dashboard.py`, falls back to local `data/*.json` artifacts for static review, and exposes sync/weather commands without showing protocol internals.
- The dashboard now adds interactive derived charts from current artifacts: signal mini-sparklines, stress/strain stacked bars, sleep-stage architecture ribbons, watchface controls, a sandboxed Watchface Lab validator, weather controls, bridge network state, bridge command timeline, and token-aware command posting.
- The PWA now has a manual Coach Analysis control backed by `POST /api/analysis`. It uses a compact derived dataset hash, writes `latest_analysis.json`, exposes `model`, `llm_used`, and usage metadata, and currently runs deterministic local rules only (`llm_used=false`, zero calls). No BLE/weather/watchface loop can trigger analysis.
- Browser smoke check against local artifacts showed connected status, recovery, sleep, stress, weather, and HRV (`48 ms` from sleep sequence) without console errors.
- Browser DOM smoke check on 2026-05-14 confirmed the Settings view exposes Network Access, Bridge Timeline, Watchface Lab, and validation controls without visible `undefined`/`NaN` text. Screenshot capture through the local browser runtime timed out, so current automated visual QA is DOM/API based until screenshot capture is reliable.
- The hosted version should remain a client. The BLE owner stays local because it needs stored HiChain keys, a long-lived connection, and battery-aware sync behavior near the band.
- Vercel is the selected static host for `huawhoop.kuber.studio`. `.vercelignore` excludes `band.ini`, `data/`, the decompiled APK, Gadgetbridge, and open-wearables source snapshots. Hosted PWA fallback data now comes from sanitized `dashboard/sample-data/*` artifacts unless the user configures a bridge URL.
- `AUDIT.md` now tracks the Gadgetbridge/APK/Huawhoop comparison matrix so risky protocol work starts from exact source files rather than trial-and-error.

### Weather Implementation Status

- `connect.py` now implements the Gadgetbridge weather chain: start (`0x0f/0x09`), unit (`0x0f/0x05`), basic support (`0x0f/0x02`), extended support (`0x0f/0x06`), sun/moon support (`0x0f/0x0a`), current weather (`0x0f/0x01`), and optional forecast (`0x0f/0x08`).
- Weather now also mirrors Gadgetbridge's optional current GPS/time push (`0x18/0x07`) and filters bad sun/moon timestamps before sending forecast because Gadgetbridge notes those can make the watch reject all weather display.
- `connect.py` has a focused `BAND10_ONLY_WEATHER=1` live-test mode. Payload priority is `BAND10_WEATHER_JSON`, `BAND10_WEATHER_FILE`, `data/weather_payload.json`, then Open-Meteo from `BAND10_WEATHER_LAT/LON`; if no coordinates are set it sends a tiny sample payload.
- Live daemon weather push on 2026-05-14 succeeded through the full chain: start, unit, current weather, GPS/time, and forecast all returned `0x000186a0`. The bridge remained connected with battery keepalive after the push.
- Forecast initially returned `0x0001c139` until the day list matched Gadgetbridge exactly: row 0 is "today" at the current observation timestamp, and future rows use `observationTimestamp + 86400 * n`. Midnight daily timestamps from Open-Meteo are rejected by the Band 10 forecast command.
- Automatic weather refresh is verified. A manual PWA/API weather push saves `data/weather_payload.json`; the daemon detects the saved payload and refreshes it on `BAND10_WEATHER_INTERVAL_SECONDS` (default 3600 seconds). A 60-second test interval produced `auto-weather-*` with all weather steps returning `0x000186a0`.

### Stress And HRV Implementation Status

Gadgetbridge source of truth:

- `HrRriTest` service `0x19` opens/closes measurement with `cmd=0x01`, tag `0x01=type`.
- Gadgetbridge stress calibration opens type `3`, collects `svc=0x19/cmd=0x05` RRI/SQI data for 60 seconds, then closes with type `4`.
- RRI notifications use outer TLV `0x82`, repeated `0x83`; each child uses `0x04` RRI and `0x05` SQI.
- Huawei's stress model filters SQI `100`, keeps RRI in `400..1400 ms`, computes ten HRV/frequency-domain features, then maps them through fixed normalization and coefficients.
- Automatic stress is enabled through `svc=0x20/cmd=0x09`: tag `0x01=1`, tag `0x02=score`, tag `0x03=12 float32 features`, tag `0x04=endTimeSeconds`. Disable uses tag `0x01=2`.

Project implementation:

- `analytics.py` contains the Huawei/Gadgetbridge stress feature and score calculation port.
- `connect.py` now has `set_automatic_stress()` and `calibrate_and_enable_stress()` for `svc=0x20/cmd=0x09`.
- The stress seed can come from the latest downloaded `rrisqi_data.bin` parse or a successful live 60-second RRI measurement. The two final feature slots are padded with `0.0`, matching Gadgetbridge.
- `run_dashboard.py` and `band_daemon.py` now expose a `stress` bridge command. The PWA has buttons for calibration and enabling automatic stress.
- `BAND10_ONLY_STRESS=1` is available for focused enable/calibration checks without a full data sync. Add `BAND10_STRESS_CALIBRATE=1` to run the 60-second Gadgetbridge-style RRI calibration first.
- `analytics.py` now emits a day-level `stress` summary with low/medium/high minutes, average score, max score, gauge value `0..3`, and recent high-stress windows.
- Automatic RRI/stress file fill is confirmed after enabling auto stress: `latest_stress_preview.json` contains parsed `rrisqi_data.bin` stress records with scores `44` and `50`, algorithm `8021`, and 12-feature vectors. Future sync can therefore use the file route without requiring a manual 60-second live calibration every time.

### ECG Availability Status

Gadgetbridge has a generic Huawei ECG route, but current Band 10 evidence says it is not exposed on this device/firmware:

- Gadgetbridge ECG primitives: service `0x23/cmd=0x10` (`ECG.SetECGOpen`), DataSync package `hw.watch.health.ecganalysis`, config IDs `900300005` and `900300006`, file download type `0x18` as `ecg_analysis_data.bin`, and parser `HuaweiEcgFileParser.java`.
- Gadgetbridge gates ECG on expand capability bits `106` (ECG), `27` (ECG open), and `138` (ECG notification). Arrhythmia is gated separately on bits `113`, `168`, and `255`.
- Live Band 10 capabilities do not advertise service `0x23`; `connect.py` now records the ECG and arrhythmia expand bits explicitly for future syncs.
- Huawei Health APK/decompile contains generic ECG models/routes, but that is not proof that Band 10 exposes ECG. Implementation stance: no ECG UI/parser route is enabled until the band advertises service `0x23`, one of the ECG expand bits, or a successful file type `0x18` response.

### Focused Live-Test Modes

`connect.py` remains a diagnostic one-shot, but now has narrow modes for precision testing after the factory reset:

- One-shots and the daemon now use a shared scan-before-connect strategy, writing `connection_status.json` with `scanning`/`not_found` instead of failing immediately on a direct Windows BLE address lookup.
- Discovery matches the stored address first, then `BAND10_DEVICE_NAME` (default `HUAWEI Band 10`). If Windows reports a different BLE address after reset, the bridge updates `band.ini` locally and writes `latest_ble_scan.json` for diagnosis.
- The one-shot runner and daemon now pass a shared Bleak options bundle. `BAND10_CONNECT_TIMEOUT_SECONDS` controls GATT connect timeout, and `BAND10_PAIR_BEFORE_CONNECT=1` exists only for Windows pairing diagnostics. Normal runs should use stored-key reconnect without forcing pairing.
- Scan-only connect was too strict after reset/paired-state changes. If the scan does not see the band, the bridge now falls back to direct Windows BLE connect with the stored address by default (`BAND10_DIRECT_CONNECT_FALLBACK=1`), bounded by the connect timeout.
- Bounded daemon verification (`BAND10_DAEMON_MAX_SECONDS`) now exits even if discovery/connect fails repeatedly, so live-test loops cannot run past the requested window.
- The daemon now has a single-owner lock at `data/bridge.lock`. A second daemon/test run exits with `state=blocked` instead of racing the active dashboard bridge, which previously caused alternating `connected` and `not_found` states.
- Repo hygiene fix: `band.ini`, `data/`, `Huawei-Health-Decompiled/`, `gadgetbridge-src/`, `open-wearables-*`, and local scratch helpers are ignored. The previously tracked runtime artifacts were removed from the index but left on disk.
- `BAND10_ONLY_WEATHER=1`: authenticate, push weather, save `latest_weather_push.json`, disconnect.
- `BAND10_ONLY_WATCHFACES=1`: authenticate, read installed/current watchface metadata, save `latest_watchfaces.json`, disconnect.
- `BAND10_ONLY_WATCHFACE_ACTIVATE=1`: activate an already-installed file name from inventory, save `latest_watchface_operation.json`, disconnect.
- `BAND10_ONLY_STRESS=1`: enable automatic stress, or with `BAND10_STRESS_CALIBRATE=1` run the 60-second RRI calibration first.

Current live caveat:

- ECG remains unsupported unless a future firmware/capability update exposes the service/bit/file route above.
- Live RRI calibration is still useful as a manual quality check, but normal HRV/stress should prefer sleep-sequence HRV plus the automatic `rrisqi_data.bin` stress file when present.
