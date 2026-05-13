# Huawhoop Deployment

`huawhoop.kuber.studio` can be hosted as a static Vercel site.

## Vercel

Project settings:

- Framework preset: Other
- Build command: empty
- Output directory: project root
- Domain: `huawhoop.kuber.studio`

`vercel.json` rewrites `/` and `/dashboard` to the PWA entrypoint. The app serves
sanitized demo data when no bridge URL is configured.

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

For phone access, use a private network URL such as Tailscale:

```text
http://<tailscale-device-name>:8765
```

Browsers may block plain HTTP from HTTPS pages depending on platform. If that
happens, put the bridge behind a private HTTPS tunnel with authentication.
