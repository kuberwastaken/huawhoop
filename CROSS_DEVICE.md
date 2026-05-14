# Huawhoop Cross-Device Runbook

Huawhoop's reliable cross-device shape is:

1. One local bridge process stays near the band and owns BLE.
2. Any browser on the same trusted network opens the PWA.
3. The PWA talks to the bridge API for live commands and artifacts.

The bridge is the only component that reads `band.ini`, keeps the HiChain session
alive, pushes weather, scans watchfaces, and downloads health files.

## Best Daily Setup

On the machine near the band:

```powershell
python run_dashboard.py
```

Open:

```text
http://127.0.0.1:8765/dashboard/
```

This is the most stable mode for laptop use. It avoids repeated pairing prompts
because one daemon owns the authenticated BLE connection.

## Phone Or Tablet On The Same Wi-Fi

Start the bridge on all local interfaces:

```powershell
powershell -ExecutionPolicy Bypass -File scripts\start_lan_bridge.ps1
```

Open the printed LAN dashboard URL on the phone, for example:

```text
http://192.168.1.42:8765/dashboard/
```

Then use the browser's install/add-to-home-screen option. In this mode the phone
does not pair with the band directly; it is a remote control and viewer for the
bridge near the band.

Optional command protection:

```powershell
$env:BAND10_BRIDGE_TOKEN = "<long-random-token>"
powershell -ExecutionPolicy Bypass -File scripts\start_lan_bridge.ps1
```

Enter the same token in Settings -> Bridge URL on the PWA before queueing sync,
weather, stress, or watchface actions.

## Hosted PWA

`huawhoop.kuber.studio` can be hosted as a static PWA. It should not contain
secrets or live health artifacts.

For hosted use, set Settings -> Bridge URL to a reachable bridge:

```text
http://<private-bridge-ip>:8765
```

Some browsers block HTTPS pages from calling plain HTTP private-network APIs. If
that happens, use one of these modes:

- Open the LAN dashboard URL served by the bridge instead of the hosted PWA.
- Put the bridge behind a private HTTPS tunnel with authentication.
- Use the redacted export button for read-only handoff.

## Redacted Export

Settings -> Network Access -> Export downloads a redacted JSON bundle. It removes
MAC details, command logs, local secrets, and raw files. Use it for sharing a
snapshot between devices or for future cloud summary relay experiments.

## Why Not Direct Browser BLE

Web Bluetooth is not enough for this project:

- The Band 10 needs HiChain keys and custom binary protocol handling.
- Background BLE is unreliable in mobile browsers.
- iOS Safari cannot own this BLE workflow.
- Repeated one-shot pairing drains patience and can vibrate/prompt the band.

The local bridge is therefore the production path. An Android native bridge is
possible later, but it should use Android BLE APIs, secure local key storage, and
foreground/background service handling rather than a hosted web page.

## Deferred Platform Work

- Android companion bridge: needs a native Android BLE service, key storage, and
  background policy work.
- Cloud summary relay: should carry only encrypted/redacted summaries, not raw
  `band.ini`, BLE keys, or binary health files.
- Copilot OAuth analysis: can plug into the manual analysis endpoint only after
  payload previews and rate limits are explicit.
- Watchface builder/custom app lab: must stay validation-only until a known-good
  package and rollback path exist.
