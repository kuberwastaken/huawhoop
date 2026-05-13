# Huawei Band 10 Recovery Dashboard

Use the daemon/dashboard runner for normal use:

```powershell
python run_dashboard.py
```

This keeps one authenticated BLE session open and serves the dashboard at:

```text
http://127.0.0.1:8765/dashboard/
```

Deployment, bridge, and source-truth audit notes live in `DEPLOYMENT.md`,
`BRIDGE.md`, and `AUDIT.md`.

`connect.py` is a diagnostic one-shot and disconnects when it exits, so the band may
show disconnected after those runs. `run_dashboard.py` is the default workflow for
timely syncs without repeated pairing/connect churn.

Useful knobs:

```powershell
$env:BAND10_SCAN_TIMEOUT_SECONDS = "30"
$env:BAND10_CONNECT_TIMEOUT_SECONDS = "30"
$env:BAND10_DIRECT_CONNECT_FALLBACK = "1"   # try stored Windows BLE address if scan misses a paired band
$env:BAND10_SYNC_INTERVAL_SECONDS = "300"   # minimum 60
$env:BAND10_FULL_SYNC_EVERY = "6"
$env:BAND10_INITIAL_FULL_SYNC = "1"
$env:BAND10_KEEPALIVE_SECONDS = "60"
$env:BAND10_KEEPALIVE_MODE = "battery"      # connect_status is init-only on this band
$env:BAND10_ENABLE_PASSIVE_SETTINGS = "1"   # part of the stable connected-state recipe
```

`BAND10_PAIR_BEFORE_CONNECT=1` is available as a last-resort Windows Bluetooth
debug knob. Leave it off for normal daemon use because stored-key reconnects should
not trigger pairing prompts or vibrations.

For a bounded connection verification run:

```powershell
$env:BAND10_DAEMON_MAX_SECONDS = "120"
$env:BAND10_INITIAL_FULL_SYNC = "0"
python band_daemon.py
```

Bounded daemon runs now exit even if the band is not visible or Windows times out
while opening GATT services, which keeps verification loops from hanging forever.

To keep the bridge running after Windows login, install the startup entry:

```powershell
powershell -ExecutionPolicy Bypass -File scripts\install_windows_bridge_task.ps1
Start-ScheduledTask -TaskName "Huawhoop Bridge"
```

It runs `python run_dashboard.py` in the repo root, writes logs to
`logs/bridge-task.log`, and keeps `http://127.0.0.1:8765/dashboard/` available.
If Windows denies Scheduled Task registration without elevation, the installer
falls back to a per-user Startup shortcut. Remove either route with
`scripts\uninstall_windows_bridge_task.ps1`.

Local secrets and live artifacts are intentionally ignored: `band.ini`, `data/`,
the decompiled Huawei Health tree, Gadgetbridge, and external research clones stay
on disk but out of commits. Use `dashboard/sample-data/` for sanitized hosted
fixtures.

Weather is live-tested through the daemon command queue. The successful Band 10
chain is Gadgetbridge-shaped: start, unit, support, extended support, sun/moon
support, current weather, GPS/time, and forecast. Forecast rows must include today
at the current observation timestamp, then future days at `timestamp + 86400 * n`;
midnight forecast timestamps are rejected by the band.

HRV now comes from the sleep-sequence dictionary file (`sequence_data/SLEEP_DETAILS`)
downloaded during full sync. This is the same route Gadgetbridge uses for TruSleep
dictionary data and includes `avgHrv`, HRV baselines, sleep score, SpO2 and breath
rate summaries. The dashboard adds an Open Wearables-style HRV variability score
from distinct sleep sessions, plus a recovery heatmap for trend review.

Live RRI HRV/stress calibration is also verified after the factory reset and
stored reconnect. The daemon captured a 62-second RRI window, computed RMSSD and
Huawei stress features, and enabled automatic stress from that live seed.

Repeated full syncs may return `00023281` for stress/sleep files when there is no
fresh file to download; the daemon preserves the last good artifact and continues
using sleep-sequence HRV instead of dropping back to "unavailable".

Live RRI/HRV probing is still cadence-limited because it is an active measurement
window and should not run in the tight sync loop:

```powershell
$env:BAND10_LIVE_HRV_EVERY = "12"
$env:BAND10_LIVE_HRV_SECONDS = "62"
python run_dashboard.py
```

For a focused one-shot HRV transport probe:

```powershell
$env:BAND10_ONLY_LIVE_HRV = "1"
$env:BAND10_LIVE_HRV = "1"
$env:BAND10_LIVE_HRV_SECONDS = "35"
python connect.py
```

The dashboard marks live HRV as experimental and shows the latest transport status
from `data/latest_live_hrv.json`.

Focused protocol one-shots are available for live testing without running the full
diagnostic script:

```powershell
# Weather from Open-Meteo. Set location only once in your shell profile if useful.
$env:BAND10_ONLY_WEATHER = "1"
$env:BAND10_WEATHER_LAT = "12.9716"
$env:BAND10_WEATHER_LON = "77.5946"
$env:BAND10_WEATHER_LOCATION = "Bengaluru"
python connect.py

# Watchface inventory.
$env:BAND10_ONLY_WATCHFACES = "1"
python connect.py

# Activate an already-installed watchface returned by inventory.
$env:BAND10_ONLY_WATCHFACE_ACTIVATE = "1"
$env:BAND10_WATCHFACE_FILE = "example.hwt"
python connect.py

# Automatic stress enable, or calibration + enable if RRI samples arrive.
$env:BAND10_ONLY_STRESS = "1"
$env:BAND10_STRESS_CALIBRATE = "1"
$env:BAND10_LIVE_HRV_SECONDS = "62"
python connect.py
```
