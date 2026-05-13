# Huawhoop LLM Policy

Huawhoop can eventually use an LLM as a health-data reasoning layer, but the
band sync loop must stay deterministic, cheap, and private by default.

## Default Rules

- No LLM calls from the BLE daemon's tight sync loop.
- No LLM calls while the band is connecting, authenticating, downloading files,
  pushing weather, or handling watchface commands.
- No raw BLE logs, `band.ini`, HiChain secrets, tokens, binary files, or full raw
  health archives are sent to an LLM.
- Automatic analysis is capped to one run per day after a materially new sleep or
  full-sync dataset.
- Manual analysis from the PWA is allowed, but must show the payload category and
  model before the command is queued.
- Results are cached by a hash of the compact insight payload, so re-opening the
  app does not spend another call.

## Payload Shape

The LLM input should be a compact JSON summary, not raw streams:

- Date/time window and data freshness.
- Recovery score, HRV source/value/baseline/resilience.
- Resting HR, sleep duration/efficiency/stages/awake interruptions.
- SpO2, breath rate, stress zone minutes, strain/load balance.
- Data quality notes and missing routes.
- Recent 7-30 day trend aggregates only.

The output must be structured JSON:

- `summary`: one short plain-language interpretation.
- `drivers`: ranked positive and negative drivers.
- `recommendations`: practical actions with confidence.
- `risks`: overtraining, sleep debt, abnormal vitals, or data-quality caveats.
- `questions`: optional user prompts for journal/context.
- `confidence`: `low`, `medium`, or `high`.

## Copilot OAuth Direction

If this project uses Copilot-backed model access, adapt the auth structure from
`X:\Bigger-Projects\Claurst\src-rust` rather than improvising:

- `crates\cli\src\codex_oauth_flow.rs`: browser + localhost callback + PKCE
  verifier/challenge/state pattern.
- `crates\mcp\src\oauth.rs`: reusable OAuth session/callback/token-exchange
  shape.
- `crates\api\src\auth.rs`: provider abstraction for credential retrieval and
  refresh.

Implementation requirements:

- Tokens are stored outside the repo and never logged.
- The PWA only queues analysis; the local bridge performs token use.
- Model choice is explicit in config and recorded in each analysis artifact.
- Routine daily summaries use the smallest capable model; deeper reasoning is
  manual-only.
- Token/input/output usage is recorded per call in an allowlisted artifact.

## Cadence

- Sleep/full-sync analysis: at most once per day, after fresh overnight data.
- Weather, watchface, and connection events: no LLM.
- Live HRV/stress probes: no LLM until a completed insight payload exists.
- User-triggered "explain this week": allowed, using 7-30 day aggregates.
