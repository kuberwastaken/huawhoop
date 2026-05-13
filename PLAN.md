# Huawhoop End-to-End Plan

## Product Goal

Build a Huawei Band 10 data platform that keeps the band connected, syncs passively, enriches the data beyond Huawei Health, and presents it in a WHOOP-like PWA at `huawhoop.kuber.studio`.

The band is the source of truth for raw physiological data. Gadgetbridge and the decompiled Huawei Health APK are the protocol references. The web app is the analysis and presentation layer.

## Non-Negotiables

- Preserve the working HiChain pairing path and never require factory resets during normal use.
- Keep one long-lived BLE bridge near the band instead of repeatedly running one-off scripts.
- Use stored keys from `band.ini` locally, but never commit secrets or live personal data.
- Sync with battery-aware cadence: cheap keepalives often, file downloads rarely, weather only when stale or changed.
- Make HRV, sleep, recovery, strain, stress, and weather explainable from raw data and documented algorithms.
- Keep every protocol discovery in `FINDINGS.md` and every product/engineering decision here.
- Commit implementation slices regularly.

## Current Proven Core

- HiChain3 first auth and stored-key reconnect work after factory reset.
- Passive health settings can be applied after reconnect.
- Battery reads are a safe keepalive; `connect_status` can return `0x000186a4` and should not be used as the heartbeat.
- Sleep sequence download works through service `0x2C`; HRV can be extracted from sleep sequence artifacts.
- Latest valid HRV observed from sleep sequence: 48 ms, baseline 28-51 ms.
- The dashboard can read local JSON artifacts, but it is not yet a complete PWA or WHOOP-grade interface.
- `AUDIT.md` is the current source-truth comparison across Gadgetbridge, Huawei Health APK, and Huawhoop implementation status.

## Architecture

### BLE Reality

A hosted PWA cannot reliably keep a Huawei Band 10 connected across every device by itself:

- Desktop Chrome/Edge Web Bluetooth could pair in theory, but this protocol needs custom binary auth, stored secrets, background sync, and long-lived BLE behavior.
- Android Chrome has Web Bluetooth, but background behavior is limited and iOS Safari does not support Web Bluetooth for this use case.
- The reliable route is a local bridge process that owns BLE and exposes an HTTP API. The PWA consumes that API locally or remotely.

### Target Shape

- `band_daemon.py`: owns one persistent BLE connection and periodic sync loop.
- `run_dashboard.py`: serves the PWA and local bridge API.
- `dashboard/`: installable WHOOP-like PWA.
- `data/`: runtime artifacts, ignored or selectively committed only when explicitly made sample fixtures.
- Future: an Android companion can run the bridge on the phone, while laptop/hosted PWA views the same synced dataset.

### Cross-Device Strategy

- Phase 1: laptop/local bridge at `http://127.0.0.1:8765`, PWA served locally.
- Phase 2: hosted PWA at `huawhoop.kuber.studio` can point to a configured bridge URL.
- Phase 3: optional cloud relay for encrypted summaries, not raw secrets.
- Phase 4: Android companion or Termux bridge for phone-near-band sync.

## Sync Policy

### Cheap Loop

- Keep BLE session alive.
- Read battery or another proven benign command every 3-5 minutes.
- Refresh connection status JSON every loop.

### Light Sync

- Pull live/status metrics every 5-15 minutes when the band is connected.
- Avoid vibration or pairing prompts.
- Never request PIN/auth paths while a stored key reconnect succeeds.

### Full Sync

- Download sleep sequence, daily fitness previews, and related files at most every 3-6 hours.
- Trigger full sync after wake/sleep windows, on explicit user request, and once after reconnect.
- Preserve previous artifacts when the band returns `0x00023281` for no fresh file.

### Weather

- Push weather every 30-60 minutes, on location/weather change, or when the band requests it.
- Weather is the first device-push feature to complete.

### LLM Analysis

- No LLM calls in the tight sync loop.
- Default: one thorough analysis after a new sleep/full-sync dataset, max once per day.
- On-demand analysis can be user-triggered from the PWA.
- Send compact derived summaries, not raw binary files, secrets, or full logs.
- If using Copilot OAuth, adapt the auth model from `X:\Bigger-Projects\Claurst\src-rust` and document exact model, prompt, rate, and payload shape before enabling.

## Milestone 1: Persistent Bridge

- [x] Add local bridge API endpoints for status, insights, artifacts, and command queue.
- [x] Add daemon command queue handling for sync and weather commands.
- [x] Add CORS/bridge URL support for hosted PWA access.
- [x] Add clear status states: scanning, not_found, connected, degraded, reconnecting, stale/error via status artifact.
- [ ] Add Windows startup/service notes after the bridge is stable.

## Milestone 2: Weather Push

- [x] Audit Gadgetbridge weather packet classes and request flow.
- [x] Compare against Huawei Health APK weather classes where available.
- [x] Implement current weather payload push.
- [x] Implement forecast payload push if supported by Band 10.
- [x] Mirror Gadgetbridge's optional current GPS/time push after current weather.
- [x] Guard weather re-push requests so the bridge cannot start nested weather chains.
- [x] Add PWA weather card and manual/API-backed push control.
- [x] Record packet tags, units, and cadence in `FINDINGS.md`.
- [ ] Live-test weather rendering on Band 10 after stable reconnect.

## Milestone 3: WHOOP-Like PWA

- [x] Redesign dashboard as a mobile-first dark PWA.
- [x] Add install manifest and service worker.
- [x] Add animated recovery, sleep, strain, stress, HRV, and battery cards.
- [x] Add weekly trends, sleep detail, stress zones, and weather views.
- [x] Add command controls for sync/weather without exposing raw protocol.
- [x] Verify responsive layout by browser smoke check with local artifacts.

## Milestone 4: Algorithms

- [x] Lock HRV extraction and baseline logic from sleep sequence data.
- [x] Implement recovery score from HRV, resting HR, sleep performance, strain load, and recent trend.
- [ ] Implement strain score from heart-rate zones and activity duration.
- [x] Implement sleep performance from duration, regularity, stages, and awake interruptions.
- [x] Implement stress summaries by low/medium/high duration where data exists.
- [ ] Keep equations readable and cite/source each heuristic in `FINDINGS.md`.
- [x] Evaluate open-source wearable/WHOOP-like analytics repos before inventing complex formulas.

## Milestone 5: Watchfaces

- [x] Audit Gadgetbridge watchface upload/confirm operation.
- [x] Compare Huawei Health APK watchface packaging and device models.
- [x] Implement read-only installed/current watchface metadata route.
- [x] Add safe installed-watchface activation command path.
- [ ] Live-test installed/current watchface metadata when the band is visible.
- [ ] Live-test activation on an already installed non-current watchface.
- [ ] Upload a known-compatible watchface file.
- [ ] Document custom watchface/app risk before writing to device.

## Milestone 6: Custom Watchfaces And Apps

- [ ] Identify package format, manifest, preview, checksum/signature, and install command.
- [ ] Build a local validation tool before any upload.
- [ ] Add a sandboxed watchface/app lab UI only after upload safety is understood.

## Milestone 7: Deployment

- [x] Choose Vercel or GitHub Pages for `huawhoop.kuber.studio`.
- [x] Make hosted PWA work with static sample data and configurable bridge URL.
- [x] Document local bridge setup separately from hosted UI deployment.
- [ ] Add production-safe defaults for no bridge, stale bridge, and offline mode.

## Milestone 8: LLM Analysis Guardrails

- [x] Write strict LLM policy before adding any model calls.
- [x] Audit `X:\Bigger-Projects\Claurst\src-rust` for Copilot/OAuth patterns.
- [x] Decide that BLE/weather/watchface/connection loops never trigger LLM calls.
- [ ] Implement an opt-in analysis endpoint after deterministic analytics are stable.
- [ ] Cache LLM output by compact dataset hash and expose model/usage metadata.
- [ ] Add a PWA manual analysis control with payload preview and cadence warnings.

## Immediate TODO

- [x] Commit this plan.
- [x] Audit Gadgetbridge weather and watchface source.
- [x] Audit APK for matching weather/watchface primitives.
- [x] Add bridge API and command queue.
- [x] Rebuild dashboard as PWA shell.
- [x] Add automatic stress enable/calibration command path.
- [x] Add focused one-shot modes for weather, watchfaces, watchface activation, and stress.
- [x] Align one-shot connection setup with daemon scan-before-connect behavior.
- [x] Add shared BLE discovery fallback by advertised band name after factory reset.
- [x] Restore repo hygiene: ignore and untrack local keys, live data, decompiled APK, Gadgetbridge, and external research clones.
- [x] Add configurable Bleak connect timeout/pairing debug knobs and bounded daemon retry exits.
- [x] Add a single-owner daemon lock so dashboard and diagnostic runs cannot race the band.
- [ ] Live-test weather push through the daemon.
- [ ] Live-test automatic stress calibration and `svc=0x20/cmd=0x09`.
- [ ] Live-test watchface inventory after the reset/stored reconnect.

## Research TODO

- [x] Search for open-source recovery/strain/sleep algorithms.
- [x] Inspect `open-wearables-*` for reusable data models or algorithms.
- [ ] Investigate ECG availability on Huawei Band 10 and related Huawei devices.
- [x] Inspect Gadgetbridge data parsers for HRV, stress, SpO2, sleep stage, and activity semantics.

## Device Push TODO

- [x] Weather start/support/unit/current/forecast command chain.
- [x] Weather request ACK/re-push handler for `0x000186AA`.
- [x] Weather one-shot live-test mode with Open-Meteo payload builder.
- [x] Read-only watchface params/list/names.
- [x] Watchface inventory and activation one-shot modes.
- [x] Automatic stress enable/disable route using Gadgetbridge's 12-feature seed format.
- [x] Automatic stress one-shot enable/calibration mode.
- [ ] Weather live verification on the Band 10 UI.
- [ ] Stress auto live verification and confirmation that future `rrisqi_data.bin` fills without manual measurement.
- [ ] Watchface install validation before any write/delete/activate operation.

## Analytics TODO

- [x] Sleep-sequence HRV extraction.
- [x] Huawei RRI stress feature port.
- [x] Stress zone summaries for the PWA.
- [ ] Strain refinement from activities/workouts rather than passive HR only.
- [ ] SpO2 low-duration summaries.
- [ ] ECG parser route if Band 10 exposes ECG analysis files; otherwise document unsupported status.

## Interface TODO

- [x] Installable mobile PWA shell.
- [x] Local bridge command buttons for sync/weather/watchfaces/stress.
- [ ] Hosted static build with configurable bridge URL for `huawhoop.kuber.studio`.
- [x] Sanitized hosted sample-data fallback.
- [ ] Browser visual regression screenshots after every major layout pass.
- [ ] API redaction pass before any hosted/cloud relay.

## Backlog

- [ ] Android companion bridge.
- [ ] Cloud summary relay.
- [ ] Copilot OAuth analysis layer after Milestone 8 endpoint and payload preview.
- [ ] Watchface builder.
- [ ] Custom app deployment lab.
