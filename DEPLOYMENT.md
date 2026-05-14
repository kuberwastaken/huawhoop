# Huawhoop Deployment

`huawhoop.kuber.studio` can be hosted as a static Vercel site.

## Vercel

Project settings:

- Framework preset: Other
- Build command: empty
- Output directory: `dashboard`
- Domain: `huawhoop.kuber.studio`

`vercel.json` publishes the static PWA from `dashboard/`. The app serves sanitized
demo data when no bridge URL is configured.

## Privacy Boundary

`.vercelignore` excludes:

- `band.ini`
- `data/`
- `Huawei-Health-Decompiled/`
- `gadgetbridge-src/`
- `open-wearables-*`

The deployed site should never contain live health artifacts or auth material.

## Bridge URL

On the hosted app, set the bridge URL in the PWA settings panel:

```text
http://127.0.0.1:8765
```

For phone access, run the bridge on the private network and use the printed LAN
URL:

```powershell
$env:BAND10_DASHBOARD_HOST = "0.0.0.0"
python run_dashboard.py
```

Then use a private network URL:

```text
http://<laptop-lan-ip>:8765
```

Browsers may block plain HTTP from HTTPS pages depending on platform. If that
happens, put the bridge behind a private HTTPS tunnel with authentication.

The bridge exposes `GET /api/bridge-info` so the local PWA can show local/LAN
URLs, and `GET /api/export` returns redacted data by default for future cloud
relay work.
