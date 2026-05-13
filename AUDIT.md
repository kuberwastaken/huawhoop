# Source-Truth Audit

This is the working comparison between Huawhoop, Gadgetbridge, and the
decompiled Huawei Health APK. The goal is to keep implementation work precise:
copy protocol behavior where source exists, then live-test only the smallest
remaining uncertainty.

## Priority Matrix

| Area | Gadgetbridge Source | Huawei Health APK Source | Huawhoop Status | Next Precision Step |
| --- | --- | --- | --- | --- |
| Stored reconnect | `GetHiChainRequest`, `HuaweiCrypto`, `HuaweiPacket` | HiChain payload structure appears consistent but obfuscated | Working after reset with stored `secret_key`; one long-lived daemon owns BLE | Keep using daemon, avoid PIN/auth paths when stored reconnect works |
| Connection discovery | Gadgetbridge scans and owns an active BLE session | App manages phone OS Bluetooth state | Shared `discover_band_device()` now scans by address/name and updates local `band.ini` if reset changes address | Retest when band is advertising; inspect `latest_ble_scan.json` when not found |
| Weather | `packets/Weather.java`, `HuaweiWeatherManager` | `defpackage/koq.java`, `WeatherForecastHour.java`, `mbd.java` | Current, forecast, support bitmaps, unit, GPS/time, async request ACK implemented | Live-test `BAND10_ONLY_WEATHER=1`; if accepted but not visible, compare exact support bitmaps |
| HRV | P2P dictionary sync + sleep sequence dictionaries | `DicDataTypeUtil.SLEEP_DETAILS_AVG_HRV`, `ggx.sleep_avghrv` | Sleep-sequence HRV works and is primary source | Keep sleep-sequence as HRV truth; live RRI remains diagnostic |
| Live RRI | `HrRriTest.java`, `HuaweiStressCalibration.java` | `PeriodRriEntity`, stress/RRI model classes | Open/close and parser implemented; Band 10 has produced HR-only streams so far | Retest exact type `3`/`4` after stable visible connection |
| Automatic stress | `Stress.java`, `SetStressRequest.java`, `HuaweiStressParser`, score/HRV calculators | Stress capability/model classes in `hwstressmgr` and datatype packages | `svc=0x20/cmd=0x09` implemented with 12-feature seed | Live-test one-shot stress; if RRI still blocked, use latest stress file seed once populated |
| Watchface inventory | `Watchface.java`, `GetWatchfaceParams`, `GetWatchfacesList`, `GetWatchfacesNames` | App has watchface packaging and UI, but APK names are obfuscated | Read-only inventory and installed-face activation implemented | Live-test inventory; activation only for non-current installed faces |
| Watchface upload | `HuaweiFwHelper`, `HuaweiUploadManager`, `FileUpload.java`, async `WatchfaceConfirm` | Package contains `description.xml`, `com.huawei.watchface`/`com.honor.watchface`, nested `watchface.bin`, preview cover | Not implemented by design; upload/delete remain risky | Build a validator before any upload: parse package, dimensions, file type, random device file name |
| Custom apps | `HuaweiUploadManager`, `FileUpload.Filetype.app = 7` | Huawei app ecosystem is present but signing/compatibility risk is high | Not implemented | Treat as lab after watchface upload validator |
| ECG | Gadgetbridge has file type `0x18` as `ecg_analysis`, no Band 10 proof yet | `EcgMetaData`, `HiEcgMetaData`, ECG strings/routes exist in APK | Unsupported until the band advertises/downloads ECG files | Probe file type `0x18` only after core sync is stable |
| Algorithms | Gadgetbridge stores raw-ish samples; Open Wearables gives clear sleep/HRV primitives | Huawei app displays sleep HRV/stress fields, exact scoring is mostly app-side/obfuscated | Recovery, sleep, HRV resilience, stress zones, and strain proxy implemented | Refine strain from activities/workouts and keep formulas documented |

## Exact Implemented Protocol Deltas

- Weather now follows Gadgetbridge ordering: start, unit, support, extended
  support, sun/moon support, current, GPS/time, forecast.
- Weather payload shape mirrors Huawei APK fields: current temperature, high/low,
  icon, location, unit, AQI/PM2.5, observation/update time, wind, source, UV,
  humidity, wind speed value, feels-like/somatosensory temperature, hourly
  precipitation, and day forecast.
- Stress calibration follows Gadgetbridge: open RRI type `3`, collect
  `svc=0x19/cmd=0x05` outer `0x82` / repeated `0x83`, close type `4`, compute
  ten features, append two zero features, then enable automatic stress.
- Watchface activation uses the safe installed-face operation path; upload and
  delete are intentionally gated.
- Hosted PWA is static and safe by default; live BLE and health artifacts stay in
  the local bridge.

## Known Gaps

- The band was not advertising in the latest 45-second scan, so weather was not
  protocol-tested after the new discovery fallback.
- Live RRI has historically returned HR-only streams or no RRI samples. Sleep
  sequence HRV is therefore the reliable HRV source.
- Stress file currently has no usable records after reset; automatic stress may
  need one successful calibration or a fresh stress file from the device.
- Watchface upload requires a package validator before any write path is safe.
- Cross-device use needs either same-LAN bridge access or a private tunnel; a
  hosted PWA cannot own long-lived Huawei BLE by itself.

## Source Files To Revisit Before Each Risky Feature

- Weather: `gadgetbridge-src/.../devices/huawei/packets/Weather.java`,
  `gadgetbridge-src/.../service/devices/huawei/HuaweiWeatherManager.java`,
  `Huawei-Health-Decompiled/sources/defpackage/koq.java`,
  `Huawei-Health-Decompiled/sources/com/huawei/hwcloudmodel/model/push/WeatherForecastHour.java`.
- Stress/RRI: `HrRriTest.java`, `HuaweiStressCalibration.java`, `Stress.java`,
  `SetStressRequest.java`, `HuaweiStressParser.java`,
  `HuaweiStressHRVCalculation.java`, `HuaweiStressScoreCalculation.java`,
  `PeriodRriEntity.java`.
- Watchfaces/apps: `Watchface.java`, `HuaweiWatchfaceManager.java`,
  `HuaweiFwHelper.java`, `HuaweiUploadManager.java`, `FileUpload.java`,
  `AsynchronousResponse.handleWatchface`.
- ECG: Gadgetbridge file type `0x18`, Huawei `EcgMetaData` and
  `HiEcgMetaData`.
