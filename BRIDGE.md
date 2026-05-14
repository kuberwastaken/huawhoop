# Huawhoop Bridge

The web app is a client. BLE, HiChain keys, weather pushes, watchface commands,
and file sync stay in the local bridge process near the band.

## Normal Run

```powershell
python run_dashboard.py
```

Open:

```text
http://127.0.0.1:8765/dashboard/
```

The daemon keeps one authenticated BLE session open, polls lightweight battery
keepalives, and processes dashboard commands from `data/bridge_commands.jsonl`.
It also writes `data/bridge.lock` so accidental second daemon/test runs do not
fight the active BLE owner.

## Phone Or Cross-Device Use

The hosted PWA can run from `https://huawhoop.kuber.studio`, but it still needs a
bridge URL. Good options:

- Laptop bridge on the same LAN: `http://<laptop-ip>:8765`.
- Tailscale/ZeroTier private URL: recommended for phone-to-laptop access.
- Cloudflare Tunnel/ngrok only if you add authentication in front of it.

Do not expose the bridge publicly without an auth layer. It can queue device
commands and reads personal health artifacts.

For same-LAN phone use, start the bridge on all interfaces:

```powershell
$env:BAND10_DASHBOARD_HOST = "0.0.0.0"
python run_dashboard.py
```

Open the LAN dashboard URL printed at startup, or copy the LAN API URL from the
PWA settings screen and paste it into the hosted app's Bridge URL field.

Optional command protection:

```powershell
$env:BAND10_BRIDGE_TOKEN = "<long-random-token>"
```

When set, dashboard command POSTs must send the same token from the settings
screen. Status reads remain available for lightweight device checks.

## Windows Startup

After live sync is stable, create a scheduled task that starts in this repo:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -Command "cd X:\Bigger-Projects\band10-whoop; python run_dashboard.py"
```

Recommended environment:

```powershell
$env:BAND10_SYNC_INTERVAL_SECONDS = "300"
$env:BAND10_FULL_SYNC_EVERY = "6"
$env:BAND10_KEEPALIVE_SECONDS = "60"
$env:BAND10_KEEPALIVE_MODE = "battery"
$env:BAND10_SCAN_TIMEOUT_SECONDS = "30"
$env:BAND10_CONNECT_TIMEOUT_SECONDS = "30"
$env:BAND10_DIRECT_CONNECT_FALLBACK = "1"
```

For one-off Windows Bluetooth debugging only, `BAND10_PAIR_BEFORE_CONNECT=1` passes
Bleak's pairing hint before opening the GATT session. It should stay disabled for
normal stored-key reconnects.

The direct-connect fallback exists because a paired Band 10 may be connectable
through Windows even when it is not actively advertising during a scan. Disable it
with `BAND10_DIRECT_CONNECT_FALLBACK=0` when diagnosing address/name changes after
a reset.

## Weather

Use the dashboard weather card for normal pushes. For CLI live testing:

```powershell
$env:BAND10_ONLY_WEATHER = "1"
$env:BAND10_WEATHER_LAT = "12.9716"
$env:BAND10_WEATHER_LON = "77.5946"
$env:BAND10_WEATHER_LOCATION = "Bengaluru"
python connect.py
```

## Watchface Lab

The dashboard can scan installed watchfaces, activate an already-installed face,
and validate a local `.hwt` package. Validation is local-only:

- `POST /api/watchface/validate` checks package structure, metadata, payload, and
  Band 10 dimensions.
- The saved report is `data/latest_watchface_validation.json`.
- No upload/delete/custom write command is exposed by the bridge yet.

## Safety

- `band.ini`, `data/`, the decompiled APK, and external source snapshots are
  ignored by Git and excluded from Vercel deployment.
- The hosted PWA falls back to sanitized sample artifacts when no bridge is set.
- `/api/export` is redacted by default; `?private=1` requires
  `BAND10_BRIDGE_TOKEN` when a token is configured.
- Watchface validation reports are redacted to file name and metadata only; full
  local paths are not published through the artifact endpoint.
- LLM analysis is intentionally disabled until the deterministic bridge and
  analytics are stable.
