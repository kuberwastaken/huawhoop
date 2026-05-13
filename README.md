# Huawei Band 10 Recovery Dashboard

Use the daemon/dashboard runner for normal use:

```powershell
python run_dashboard.py
```

This keeps one authenticated BLE session open and serves the dashboard at:

```text
http://127.0.0.1:8765/dashboard/
```

`connect.py` is a diagnostic one-shot and disconnects when it exits, so the band may
show disconnected after those runs. `run_dashboard.py` is the default workflow for
timely syncs without repeated pairing/connect churn.

Useful knobs:

```powershell
$env:BAND10_SYNC_INTERVAL_SECONDS = "300"   # minimum 60
$env:BAND10_FULL_SYNC_EVERY = "6"
$env:BAND10_KEEPALIVE_SECONDS = "60"
$env:BAND10_ENABLE_PASSIVE_SETTINGS = "1"
```

Live RRI/HRV probing is intentionally opt-in until the Band 10 emits samples reliably:

```powershell
$env:BAND10_LIVE_HRV_EVERY = "12"
$env:BAND10_LIVE_HRV_SECONDS = "62"
python run_dashboard.py
```

The dashboard marks live HRV as experimental and shows the latest transport status
from `data/latest_live_hrv.json`.
