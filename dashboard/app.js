const artifactFiles = {
  connection: "connection_status.json",
  sync: "latest_sync_status.json",
  insights: "latest_insights.json",
  summary: "latest_recovery_summary.json",
  fitness: "latest_fitness_preview.json",
  capabilities: "latest_capabilities.json",
  sequence: "latest_sleep_sequence_preview.json",
  trusleep: "latest_trusleep_preview.json",
  stress: "latest_stress_preview.json",
  stressSettings: "latest_stress_settings.json",
  liveHrv: "latest_live_hrv.json",
  watchfaces: "latest_watchfaces.json",
  watchfaceOperation: "latest_watchface_operation.json",
  analysis: "latest_analysis.json",
  recoveryHistory: "recovery_history.jsonl",
  insightsHistory: "insights_history.jsonl"
};

function loadJsonSetting(key, fallback = {}) {
  try {
    return JSON.parse(localStorage.getItem(key)) || fallback;
  } catch (_) {
    return fallback;
  }
}

const state = {
  data: {},
  weather: null,
  weatherConfig: loadJsonSetting("huawhoop.weatherConfig", {}),
  bridgeBase: localStorage.getItem("huawhoop.bridgeBase") || "",
  bridgeToken: localStorage.getItem("huawhoop.bridgeToken") || ""
};

const fmt = new Intl.NumberFormat(undefined, { maximumFractionDigits: 1 });
const pctFmt = new Intl.NumberFormat(undefined, { maximumFractionDigits: 0 });

const $ = (selector) => document.querySelector(selector);
const $$ = (selector) => Array.from(document.querySelectorAll(selector));

function clamp(value, min, max) {
  return Math.max(min, Math.min(max, Number.isFinite(value) ? value : min));
}

function number(value, fallback = 0) {
  return Number.isFinite(Number(value)) ? Number(value) : fallback;
}

function esc(value) {
  return String(value ?? "").replace(/[&<>"']/g, (char) => ({
    "&": "&amp;",
    "<": "&lt;",
    ">": "&gt;",
    "\"": "&quot;",
    "'": "&#39;"
  })[char]);
}

function bridgePath(path) {
  const base = state.bridgeBase.replace(/\/$/, "");
  return `${base}${path}`;
}

function isLocalHost() {
  return ["", "localhost", "127.0.0.1", "::1"].includes(window.location.hostname);
}

function isPrivateHost() {
  const host = window.location.hostname;
  return /^192\.168\./.test(host) || /^10\./.test(host) || /^172\.(1[6-9]|2\d|3[0-1])\./.test(host);
}

function hasBridge() {
  return !!state.bridgeBase || isLocalHost() || isPrivateHost() || window.location.port === "8765";
}

function artifactPath(key) {
  const root = (!state.bridgeBase && !isLocalHost()) ? "./sample-data/" : "../data/";
  return `${root}${artifactFiles[key]}`;
}

async function fetchJson(path, fallback = {}) {
  try {
    const response = await fetch(path, { cache: "no-store" });
    if (!response.ok) return fallback;
    return await response.json();
  } catch {
    return fallback;
  }
}

async function fetchText(path, fallback = "") {
  try {
    const response = await fetch(path, { cache: "no-store" });
    if (!response.ok) return fallback;
    return await response.text();
  } catch {
    return fallback;
  }
}

function parseJsonl(text) {
  return text.split(/\r?\n/)
    .map((line) => line.trim())
    .filter(Boolean)
    .map((line) => {
      try {
        return JSON.parse(line);
      } catch {
        return null;
      }
    })
    .filter(Boolean);
}

async function loadData() {
  const api = hasBridge() ? await fetchJson(bridgePath("/api/status"), null) : null;
  if (api && (api.connection || api.insights || api.bridge)) {
    const bridgeInfo = await fetchJson(bridgePath("/api/bridge-info"), {});
    const historyText = await fetchText(bridgePath("/api/artifacts/recovery_history.jsonl"), "");
    const insightsHistoryText = await fetchText(bridgePath("/api/artifacts/insights_history.jsonl"), "");
    state.data = {
      connection: api.connection || {},
      sync: api.sync || {},
      insights: api.insights || {},
      summary: await fetchJson(bridgePath("/api/artifacts/latest_recovery_summary.json"), {}),
      fitness: await fetchJson(bridgePath("/api/artifacts/latest_fitness_preview.json"), {}),
      capabilities: await fetchJson(bridgePath("/api/artifacts/latest_capabilities.json"), {}),
      sequence: await fetchJson(bridgePath("/api/artifacts/latest_sleep_sequence_preview.json"), {}),
      trusleep: await fetchJson(bridgePath("/api/artifacts/latest_trusleep_preview.json"), {}),
      stress: await fetchJson(bridgePath("/api/artifacts/latest_stress_preview.json"), {}),
      stressSettings: await fetchJson(bridgePath("/api/artifacts/latest_stress_settings.json"), {}),
      liveHrv: await fetchJson(bridgePath("/api/artifacts/latest_live_hrv.json"), {}),
      watchfaces: await fetchJson(bridgePath("/api/artifacts/latest_watchfaces.json"), {}),
      watchfaceOperation: await fetchJson(bridgePath("/api/artifacts/latest_watchface_operation.json"), {}),
      analysis: await fetchJson(bridgePath("/api/artifacts/latest_analysis.json"), {}),
      recoveryHistory: parseJsonl(historyText),
      insightsHistory: parseJsonl(insightsHistoryText),
      bridge: api.bridge || {},
      bridgeInfo,
      lastCommands: api.last_commands || []
    };
    return;
  }

  const entries = await Promise.all([
    fetchJson(artifactPath("connection"), {}),
    fetchJson(artifactPath("sync"), {}),
    fetchJson(artifactPath("insights"), {}),
    fetchJson(artifactPath("summary"), {}),
    fetchJson(artifactPath("fitness"), {}),
    fetchJson(artifactPath("capabilities"), {}),
    fetchJson(artifactPath("sequence"), {}),
    fetchJson(artifactPath("trusleep"), {}),
    fetchJson(artifactPath("stress"), {}),
    fetchJson(artifactPath("stressSettings"), {}),
    fetchJson(artifactPath("liveHrv"), {}),
    fetchJson(artifactPath("watchfaces"), {}),
    fetchJson(artifactPath("watchfaceOperation"), {}),
    fetchJson(artifactPath("analysis"), {}),
    fetchText(artifactPath("recoveryHistory"), ""),
    fetchText(artifactPath("insightsHistory"), "")
  ]);
  state.data = {
    connection: entries[0],
    sync: entries[1],
    insights: entries[2],
    summary: entries[3],
    fitness: entries[4],
    capabilities: entries[5],
    sequence: entries[6],
    trusleep: entries[7],
    stress: entries[8],
    stressSettings: entries[9],
    liveHrv: entries[10],
    watchfaces: entries[11],
    watchfaceOperation: entries[12],
    analysis: entries[13],
    recoveryHistory: parseJsonl(entries[14]),
    insightsHistory: parseJsonl(entries[15]),
    bridge: {},
    bridgeInfo: {},
    lastCommands: []
  };
}

function localTime(ts) {
  if (!ts) return "n/a";
  return new Date(ts * 1000).toLocaleString([], {
    month: "short",
    day: "numeric",
    hour: "2-digit",
    minute: "2-digit"
  });
}

function scoreColor(value, max = 100) {
  const pct = max ? value / max : 0;
  if (pct >= 0.67) return "var(--teal)";
  if (pct >= 0.34) return "var(--yellow)";
  return "var(--orange)";
}

function ringSvg({ value, max = 100, size = 78, stroke = 7, color = "var(--teal)", label = "", sub = "", decimals = 0 }) {
  const radius = (size - stroke) / 2;
  const circumference = 2 * Math.PI * radius;
  const pct = clamp(value / max, 0, 1);
  const offset = circumference * (1 - pct);
  const shown = Number.isFinite(value) ? value.toFixed(decimals) : "--";
  return `
    <svg width="${size}" height="${size}" viewBox="0 0 ${size} ${size}" aria-hidden="true">
      <circle class="progress-track" cx="${size / 2}" cy="${size / 2}" r="${radius}" fill="none" stroke-width="${stroke}"></circle>
      <circle class="progress-value" cx="${size / 2}" cy="${size / 2}" r="${radius}" fill="none" stroke="${color}" stroke-width="${stroke}"
        stroke-dasharray="${circumference.toFixed(2)}" stroke-dashoffset="${offset.toFixed(2)}"></circle>
      <text x="50%" y="45%" text-anchor="middle" dominant-baseline="middle" fill="var(--text)" font-size="${size * 0.23}" font-weight="900">${shown}</text>
      <text x="50%" y="62%" text-anchor="middle" dominant-baseline="middle" fill="var(--muted)" font-size="${size * 0.095}" font-weight="800">${label}</text>
    </svg>
    ${sub ? `<div class="ring-sub">${sub}</div>` : ""}
  `;
}

function ringCard(label, value, max, color, sub, decimals = 0, target = "") {
  return `<article class="ring-card" ${target ? `data-goto="${target}"` : ""}>
    ${ringSvg({ value, max, color, label, sub, decimals })}
  </article>`;
}

function miniCard(glyph, label, value, sub = "") {
  return `<article class="mini-card">
    <div class="glyph">${glyph}</div>
    <div><strong>${value}</strong><span>${label}${sub ? ` · ${sub}` : ""}</span></div>
  </article>`;
}

function detailRow(glyph, label, value, sub = "") {
  return `<div class="detail-row">
    <div class="glyph">${glyph}</div>
    <div><strong>${label}</strong><span>${sub}</span></div>
    <strong>${value}</strong>
  </div>`;
}

function meter(label, value, max, color = "linear-gradient(90deg, var(--orange), var(--teal))") {
  const pct = clamp(value / max, 0, 1) * 100;
  return `<div class="zone-row">
    <div><span>${label}</span><strong>${fmt.format(value)}</strong></div>
    <div class="meter"><i style="width:${pct.toFixed(1)}%;background:${color}"></i></div>
  </div>`;
}

function current() {
  const insights = state.data.insights || {};
  const sleep = insights.sleep || {};
  const strain = insights.strain || {};
  return {
    recovery: number(insights.recovery_score, 0),
    recoveryLabel: insights.recovery_label || "yellow",
    sleepScore: number(sleep.score, 0),
    sleepMinutes: number(sleep.minutes, 0),
    strain: number(strain.strain, 0),
    stress: number(insights.stress?.gauge_0_3, NaN),
    hrv: number(insights.hrv?.avg_hrv_ms ?? insights.hrv_rmssd_ms, NaN),
    rhr: number(insights.resting_hr, NaN),
    battery: number(state.data.connection?.battery ?? state.data.sync?.battery, NaN)
  };
}

function renderHeader() {
  const data = state.data;
  const connectionState = data.connection?.state || "offline";
  const connected = connectionState === "connected";
  const stateNode = $("#connection-state");
  stateNode.textContent = connected ? "Connected" : connectionState.replaceAll("_", " ");
  stateNode.dataset.state = connectionState;
  const battery = current().battery;
  $("#battery-label").textContent = Number.isFinite(battery) ? `${battery}%` : "--%";
  $("#sync-label").textContent = data.connection?.timestamp_local || data.sync?.ended_at_local || "No sync yet";
}

function renderToday() {
  const data = state.data;
  const values = current();
  const insights = data.insights || {};
  const sleep = insights.sleep || {};
  const strain = insights.strain || {};
  const stress = insights.stress || {};
  const summary = data.summary || {};
  const steps = summary.step_total || data.fitness?.summary?.step_total || 0;
  const hrvText = Number.isFinite(values.hrv) ? `${Math.round(values.hrv)} ms` : "Collecting";
  $("#ring-row").innerHTML = [
    ringCard("Sleep", values.sleepScore, 100, "var(--orange)", `${Math.round(values.sleepMinutes / 60)}h`, 0, "sleep"),
    ringCard("Recovery", values.recovery, 100, "var(--teal)", values.recoveryLabel, 0, "recovery"),
    ringCard("Strain", values.strain, 21, "var(--blue)", `${fmt.format(strain.trimp || 0)} load`, 1, "strain")
  ].join("");
  $("#daily-cards").innerHTML = [
    miniCard("S", "Steps", fmt.format(steps), fmt.format(summary.step_window_samples || 0)),
    miniCard("H", "Heart rate", Number.isFinite(values.rhr) ? Math.round(values.rhr) : "--", "resting"),
    miniCard("V", "HRV", hrvText, insights.hrv?.source || "sleep"),
    miniCard("O", "SpO2", sleep.avg_spo2 ? `${sleep.avg_spo2}%` : "--", "overnight")
  ].join("");
  $("#review-summary").textContent = `Recovery ${values.recovery || "--"} · Strain ${fmt.format(values.strain)}`;
  const zones = stress.zone_minutes || {};
  const activities = [
    ["Sleep", values.sleepScore, `${Math.floor(values.sleepMinutes / 60)}:${String(Math.round(values.sleepMinutes % 60)).padStart(2, "0")}`],
    ["Low Stress", zones.low || 0, "low minutes"],
    ["Medium", zones.medium || 0, "stress minutes"]
  ];
  $("#activity-count").textContent = `${activities.length} rows`;
  $("#activity-list").innerHTML = activities.map(([name, score, meta]) => `<div class="activity">
    <div class="score-pill">${score}</div>
    <div class="activity-main"><strong>${name}</strong><span>${meta}</span></div>
    <span>›</span>
  </div>`).join("");
}

function historyRows() {
  const rows = state.data.insightsHistory?.length ? state.data.insightsHistory : state.data.recoveryHistory || [];
  return rows.slice(-14);
}

function renderTrends() {
  const rows = historyRows().slice(-7);
  const fallback = Array.from({ length: 7 }, (_, i) => ({ recovery_score: i === 6 ? current().recovery : 0 }));
  const shown = rows.length ? rows : fallback;
  $("#recovery-bars").innerHTML = shown.map((row) => {
    const score = number(row.recovery_score ?? row.recovery_proxy_no_hrv, 0);
    const day = row.generated_at ? new Date(row.generated_at * 1000).toLocaleDateString([], { weekday: "short" }) : "";
    return `<div class="bar-day ${score >= 67 ? "ok" : ""}">
      <strong>${Math.round(score)}%</strong>
      <i style="height:${clamp(score, 7, 100)}%"></i>
      <small>${day}</small>
    </div>`;
  }).join("");
  drawLine($("#hrv-line"), shown.map((row) => number(row.hrv_rmssd_ms ?? row.hrv?.avg_hrv_ms, NaN)).filter(Number.isFinite), {
    min: 0,
    maxPadding: 10,
    color: "var(--teal)"
  });
}

function renderSignalCharts() {
  const quality = state.data.insights?.data_quality || {};
  const fitnessRows = state.data.fitness?.steps || [];
  const hrValues = fitnessRows.map((row) => row.heart_rate).filter((value) => number(value, 0) > 0);
  const spo2Values = fitnessRows.map((row) => row.spo2).filter((value) => number(value, 0) > 0);
  const stressZones = state.data.insights?.stress?.zone_minutes || {};
  const strainZones = state.data.insights?.strain?.zone_minutes || {};
  const session = latestSleepSession();
  const sleepSummary = session.summary || {};
  const sleepStages = session.details?.stages || [];
  $("#quality-label").textContent = quality.hrv_source ? `HRV · ${quality.hrv_source}` : "sample";
  $("#signal-grid").innerHTML = [
    signalCard("Heart rate", hrValues.length ? `${Math.round(hrValues.at(-1))} bpm` : "--", `${hrValues.length} samples`, sparkSvg(hrValues, "var(--blue)")),
    signalCard("SpO2", spo2Values.length ? `${Math.round(Math.min(...spo2Values))}-${Math.round(Math.max(...spo2Values))}%` : "--", `${spo2Values.length} samples`, sparkSvg(spo2Values, "var(--teal)")),
    signalCard("Stress split", state.data.insights?.stress?.label || "--", `${Math.round(number(stressZones.medium))}m medium`, stackedBar([
      { label: "Low", value: stressZones.low || 0, color: "var(--blue)" },
      { label: "Medium", value: stressZones.medium || 0, color: "var(--teal)" },
      { label: "High", value: stressZones.high || 0, color: "var(--orange)" }
    ])),
    signalCard("Sleep stages", sleepSummary.avgHrv ? `${sleepSummary.avgHrv} ms HRV` : `${sleepStages.length}m`, sleepSummary.sleepScore ? `${sleepSummary.sleepScore}% device` : "latest session", sleepStageTimeline(sleepStages, true)),
    signalCard("Strain zones", current().strain ? current().strain.toFixed(1) : "--", `${fmt.format(state.data.insights?.strain?.trimp || 0)} TRIMP`, stackedBar([
      { label: "Easy", value: strainZones.easy || 0, color: "var(--blue)" },
      { label: "Moderate", value: strainZones.moderate || 0, color: "var(--teal)" },
      { label: "Hard", value: strainZones.hard || 0, color: "var(--yellow)" },
      { label: "Max", value: strainZones.max || 0, color: "var(--orange)" }
    ])),
    signalCard("Training balance", state.data.insights?.training_balance?.load_ratio ?? "--", state.data.insights?.training_balance?.label || "waiting", meter("acute / chronic", number(state.data.insights?.training_balance?.load_ratio, 0), 2, "linear-gradient(90deg,var(--blue),var(--teal),var(--orange))"))
  ].join("");
}

function signalCard(label, value, sub, chart) {
  return `<article class="signal-card">
    <div class="signal-head"><span>${label}</span><strong>${value}</strong></div>
    <div class="signal-chart">${chart}</div>
    <p>${sub}</p>
  </article>`;
}

function renderAnalysis() {
  const analysis = state.data.analysis || {};
  const actions = analysis.actions || [];
  if (!analysis.dataset_hash) {
    $("#analysis-panel").innerHTML = [
      detailRow("A", "Analysis", "ready", "manual, cached, no background model calls"),
      detailRow("M", "Model", "deterministic", "LLM disabled until explicitly wired")
    ].join("");
    return;
  }
  $("#analysis-panel").innerHTML = [
    detailRow("S", "Summary", analysis.confidence || "ready", analysis.summary || ""),
    detailRow("M", "Model", analysis.model || "deterministic", analysis.llm_used ? `${analysis.usage?.tokens || 0} tokens` : "0 calls"),
    detailRow("H", "Dataset Hash", analysis.dataset_hash.slice(0, 10), analysis.cache_hit ? "cached" : analysis.generated_at_local || ""),
    actions.length ? `<div class="analysis-actions">${actions.map((item) => `<p>${esc(item)}</p>`).join("")}</div>` : ""
  ].join("");
}

function drawLine(container, values, opts = {}) {
  if (!values.length) {
    container.innerHTML = `<div class="empty">Collecting trend</div>`;
    return;
  }
  const width = 320;
  const height = 120;
  const pad = 12;
  const min = opts.min ?? Math.min(...values);
  const max = Math.max(...values, min + 1) + (opts.maxPadding || 0);
  const points = values.map((value, index) => {
    const x = pad + (index / Math.max(1, values.length - 1)) * (width - pad * 2);
    const y = height - pad - ((value - min) / Math.max(1, max - min)) * (height - pad * 2);
    return [x, y, value];
  });
  const path = points.map(([x, y], i) => `${i ? "L" : "M"}${x.toFixed(1)},${y.toFixed(1)}`).join(" ");
  const area = `${path} L${points.at(-1)[0].toFixed(1)},${height - pad} L${points[0][0].toFixed(1)},${height - pad} Z`;
  container.innerHTML = `<svg viewBox="0 0 ${width} ${height}">
    <path class="spark-area" d="${area}"></path>
    <path class="spark-line" d="${path}" style="stroke:${opts.color || "var(--teal)"}"></path>
    ${points.map(([x, y]) => `<circle class="spark-dot" cx="${x}" cy="${y}" r="3"></circle>`).join("")}
  </svg>`;
}

function sparkSvg(values, color = "var(--teal)") {
  const clean = values.map((value) => number(value, NaN)).filter(Number.isFinite).slice(-96);
  if (clean.length < 2) return `<div class="empty mini-empty">Collecting</div>`;
  const width = 180;
  const height = 52;
  const min = Math.min(...clean);
  const max = Math.max(...clean, min + 1);
  const points = clean.map((value, index) => {
    const x = (index / Math.max(1, clean.length - 1)) * width;
    const y = height - ((value - min) / Math.max(1, max - min)) * (height - 6) - 3;
    return [x, y];
  });
  const path = points.map(([x, y], index) => `${index ? "L" : "M"}${x.toFixed(1)},${y.toFixed(1)}`).join(" ");
  return `<svg class="mini-spark" viewBox="0 0 ${width} ${height}">
    <path d="${path}" style="stroke:${color}"></path>
  </svg>`;
}

function stageMeta(stage) {
  const meta = {
    1: ["Light", "var(--blue)"],
    2: ["REM", "var(--teal)"],
    3: ["Deep", "var(--purple)"],
    4: ["Awake", "var(--orange)"],
    5: ["Nap", "var(--yellow)"]
  };
  return meta[stage] || [`Stage ${stage}`, "var(--muted-dark)"];
}

function latestSleepSession() {
  const sessions = state.data.sequence?.sessions || [];
  const scored = sessions.filter((session) => number(session.summary?.sleepScore, 0) > 0);
  const candidates = scored.length ? scored : sessions;
  return candidates.sort((a, b) => number(b.end_ts, 0) - number(a.end_ts, 0))[0] || {};
}

function sleepStageTimeline(stages, compact = false) {
  if (!stages?.length) return `<div class="empty">No stage timeline yet</div>`;
  const runs = [];
  for (const point of stages) {
    const last = runs.at(-1);
    if (last && last.stage === point.stage) last.count += 1;
    else runs.push({ stage: point.stage, count: 1 });
  }
  const total = runs.reduce((sum, run) => sum + run.count, 0) || 1;
  return `<div class="stage-timeline ${compact ? "compact" : ""}">
    ${runs.map((run) => {
      const [label, color] = stageMeta(run.stage);
      return `<i title="${label} ${run.count}m" style="width:${(run.count / total * 100).toFixed(2)}%;background:${color}"></i>`;
    }).join("")}
  </div>`;
}

function stackedBar(parts) {
  const total = parts.reduce((sum, part) => sum + Math.max(0, number(part.value)), 0) || 1;
  return `<div class="stacked-bar">
    ${parts.map((part) => `<i title="${esc(part.label)} ${fmt.format(part.value)}" style="width:${(number(part.value) / total * 100).toFixed(2)}%;background:${part.color}"></i>`).join("")}
  </div>`;
}

function renderRecovery() {
  const insights = state.data.insights || {};
  const values = current();
  $("#recovery-hero").innerHTML = ringSvg({
    value: values.recovery,
    max: 100,
    size: 190,
    stroke: 12,
    color: scoreColor(values.recovery),
    label: "Recovery",
    sub: insights.recovery_label || ""
  });
  const hrv = insights.hrv || {};
  const components = insights.components || {};
  const spo2 = insights.spo2 || {};
  const spo2Subtitle = spo2.status === "ok"
    ? `${spo2.minutes_below_95 || 0} min <95%, ${spo2.minutes_below_92 || 0} min <92%`
    : "overnight";
  $("#recovery-details").innerHTML = [
    detailRow("V", "Heart Rate Variability", Number.isFinite(values.hrv) ? `${Math.round(values.hrv)} ms` : "--", hrv.source || "sleep sequence"),
    detailRow("R", "Resting Heart Rate", Number.isFinite(values.rhr) ? `${Math.round(values.rhr)} bpm` : "--", `${insights.resting_hr_baseline || "--"} baseline`),
    detailRow("O", "Oxygen Saturation", insights.sleep?.avg_spo2 ? `${insights.sleep.avg_spo2}%` : (spo2.avg_pct ? `${spo2.avg_pct}%` : "--"), spo2Subtitle),
    `<div class="zone-bars">
      ${Object.entries(components).map(([name, value]) => meter(name.toUpperCase(), number(value), 100)).join("")}
    </div>`
  ].join("");
}

function renderSleep() {
  const sleep = state.data.insights?.sleep || {};
  const values = current();
  const session = latestSleepSession();
  const stagesTimeline = session.details?.stages || [];
  $("#sleep-hero").innerHTML = ringSvg({
    value: values.sleepScore,
    max: 100,
    size: 190,
    stroke: 12,
    color: "var(--orange)",
    label: "Sleep",
    sub: `${Math.floor(values.sleepMinutes / 60)}h ${Math.round(values.sleepMinutes % 60)}m`
  });
  const stages = sleep.stage_counts || {};
  const total = Object.values(stages).reduce((sum, value) => sum + number(value), 0) || 1;
  $("#sleep-details").innerHTML = [
    detailRow("P", "Sleep Performance", `${sleep.performance_score ?? "--"}%`, `${sleep.need_minutes || 480} min need`),
    detailRow("E", "Efficiency", sleep.sleep_efficiency ? `${sleep.sleep_efficiency}%` : "--", `${sleep.sleep_latency_min ?? "--"} min latency`),
    detailRow("B", "Breath Rate", sleep.avg_breath_rate ?? "--", "overnight average"),
    `<div class="zone-bars">
      ${Object.entries(stages).map(([stage, value]) => {
        const names = { 1: "Light", 2: "REM", 3: "Deep", 4: "Awake", 5: "Nap" };
        return meter(names[stage] || `Stage ${stage}`, number(value), total, "var(--teal)");
      }).join("") || `<div class="empty">No stages yet</div>`}
    </div>`
  ].join("");
  $("#sleep-stage-chart").innerHTML = [
    sleepStageTimeline(stagesTimeline),
    `<div class="stage-legend">
      ${[4, 1, 2, 3, 5].map((stage) => {
        const [label, color] = stageMeta(stage);
        return `<span><i style="background:${color}"></i>${label}</span>`;
      }).join("")}
    </div>`,
    session.start_local ? `<p class="chart-note">${session.start_local} to ${session.end_local || "now"} · ${stagesTimeline.length} one-minute samples</p>` : ""
  ].join("");
}

function renderStrain() {
  const strain = state.data.insights?.strain || {};
  const stress = state.data.insights?.stress || {};
  const stressSettings = state.data.stressSettings || {};
  const stressZones = stress.zone_minutes || {};
  const strainZones = strain.zone_minutes || {};
  const maxStressZone = Math.max(...Object.values(stressZones).map(number), 1);
  const maxStrainZone = Math.max(...Object.values(strainZones).map(number), 1);
  const stressValue = Number.isFinite(current().stress) ? current().stress : 0;
  $("#stress-hero").innerHTML = ringSvg({
    value: stressValue,
    max: 3,
    size: 190,
    stroke: 12,
    color: "var(--teal)",
    label: "Stress",
    sub: stress.label || "collecting"
  });
  $("#stress-breakdown").innerHTML = `<div class="stress-copy">
    ${stressSentence(stress)}
    ${stressSettings.generated_at_local ? `<br>Auto stress ${stressSettings.enabled ? "enabled" : "updated"} ${stressSettings.generated_at_local}.` : ""}
  </div>`;
  $("#strain-details").innerHTML = `<div class="zone-bars">
    ${Object.entries(stressZones).map(([name, value]) => meter(`${name} stress`, number(value), maxStressZone, zoneColor(name))).join("") || `<div class="empty">No stress samples yet</div>`}
    ${detailRow("S", "Strain", current().strain ? current().strain.toFixed(1) : "--", `${fmt.format(strain.trimp || 0)} TRIMP load`)}
    ${detailRow("A", "Active Minutes", strain.active_minutes ?? "--", `${strain.step_total || 0} detected steps`)}
    ${detailRow("P", "Activity Load", strain.activity_load ?? "--", `${strain.vigorous_minutes || 0} vigorous minutes`)}
    ${Object.entries(strainZones).map(([name, value]) => meter(`${name} strain`, number(value), maxStrainZone, zoneColor(name))).join("")}
    ${detailRow("L", "Load Ratio", state.data.insights?.training_balance?.load_ratio ?? "--", state.data.insights?.training_balance?.recommendation || "")}
  </div>`;
  $("#strain-load-chart").innerHTML = `<div class="load-grid">
    ${signalCard("Cardio load", current().strain ? current().strain.toFixed(1) : "--", `${fmt.format(strain.trimp || 0)} TRIMP`, stackedBar([
      { label: "Easy", value: strainZones.easy || 0, color: "var(--blue)" },
      { label: "Moderate", value: strainZones.moderate || 0, color: "var(--teal)" },
      { label: "Hard", value: strainZones.hard || 0, color: "var(--yellow)" },
      { label: "Max", value: strainZones.max || 0, color: "var(--orange)" }
    ]))}
    ${signalCard("Stress time", stress.label || "--", `${Math.round(number(stressZones.medium))}m medium`, stackedBar([
      { label: "Low", value: stressZones.low || 0, color: "var(--blue)" },
      { label: "Medium", value: stressZones.medium || 0, color: "var(--teal)" },
      { label: "High", value: stressZones.high || 0, color: "var(--orange)" }
    ]))}
  </div>`;
}

function zoneColor(name) {
  if (name.includes("hard") || name.includes("max") || name.includes("high")) return "var(--orange)";
  if (name.includes("moderate") || name.includes("medium")) return "var(--teal)";
  return "var(--blue)";
}

function stressSentence(stress) {
  const zones = stress.zone_minutes || {};
  const total = number(zones.low) + number(zones.medium) + number(zones.high);
  if (!total) return stress.message || "Stress zones will populate after the next synced RRI/stress window.";
  return `${stress.low_pct ?? "--"}% of tracked stress time was low. Medium stress lasted ${Math.round(number(zones.medium))} minutes; high stress lasted ${Math.round(number(zones.high))} minutes.`;
}

function renderRoutes() {
  const flags = state.data.capabilities?.capability_flags || {};
  const quality = state.data.insights?.data_quality || {};
  const watchfaces = state.data.watchfaces || {};
  const watchfaceOperation = state.data.watchfaceOperation || {};
  const installed = watchfaces.installed || [];
  const rows = [
    ["Stored reconnect", "ready", state.data.connection?.state || "unknown"],
    ["Sleep sequence HRV", quality.hrv_source || "pending", `${quality.sleep_sequence_sessions || 0} sessions`],
    ["Weather push", "queued", "service 0x0f"],
    ["Watchfaces", watchfaces.supported ? `${installed.length} installed` : (flags.watchface ? "supported" : "audit"), "service 0x27"],
    ["Live RRI", quality.live_hrv_transport?.state || "diagnostic", `${quality.live_hrv_transport?.sample_count || 0} samples`],
    ["ECG", flags.ecg || flags.ecg_open ? "advertised" : "unsupported", flags.ecg_open ? "service 0x23" : "no Band 10 route"]
  ];
  $("#route-status").innerHTML = rows.map(([name, value, sub]) => detailRow("•", name, value, sub)).join("");
  const current = installed.find((face) => face.current);
  const faceRows = installed.slice(0, 8).map((face) => {
    const label = face.display_name || face.file_name || "Watchface";
    const version = face.version || "";
    const disabled = face.current ? "disabled" : "";
    return `<div class="watchface-row">
      <div>
        <strong>${esc(label)}</strong>
        <span>${esc(face.file_name || "")}${version ? ` / ${esc(version)}` : ""}</span>
      </div>
      <button class="pill-button secondary compact watchface-activate" type="button"
        data-file-name="${esc(face.file_name || "")}" data-version="${esc(version)}" ${disabled}>
        ${face.current ? "Current" : "Activate"}
      </button>
    </div>`;
  }).join("");
  $("#watchface-status").innerHTML = [
    detailRow("W", "Read-only inventory", watchfaces.supported ? "ready" : "queued", watchfaces.generated_at_local || "params, list, names"),
    detailRow("C", "Current Watchface", current?.display_name || current?.file_name || "--", current?.version || ""),
    detailRow("N", "Installed Faces", installed.length || "--", watchfaces.params ? `${watchfaces.params.width || "--"}x${watchfaces.params.height || "--"}` : "waiting for scan"),
    detailRow("A", "Last Activation", watchfaceOperation.file_name || "--", watchfaceOperation.generated_at_local || "existing installed faces only"),
    detailRow("U", "Upload Route", "gated", "validate package before writing"),
    faceRows ? `<div class="watchface-list">${faceRows}</div>` : ""
  ].join("");
  $$(".watchface-activate").forEach((button) => {
    button.addEventListener("click", () => queueWatchfaceActivate(button.dataset.fileName, button.dataset.version));
  });
}

function renderBridgeNetwork() {
  const info = state.data.bridgeInfo || {};
  const lanUrl = info.lan_urls?.[0] || "";
  const lanApi = info.lan_api_urls?.[0] || "";
  const rows = [
    detailRow("H", "Local App", info.local_url || "same origin", info.local_api || ""),
    detailRow("L", "LAN App", lanUrl || "start with 0.0.0.0", lanApi || "phone/tablet bridge URL"),
    detailRow("C", "Cloud PWA", "huawhoop.kuber.studio", state.bridgeBase || lanApi || "set Bridge URL"),
    detailRow("S", "Bridge Safety", info.token_required ? "token required" : "local trust", info.lan_enabled ? "LAN enabled" : "loopback only")
  ];
  $("#bridge-network").innerHTML = rows.join("");
}

function renderWeather() {
  const weather = state.weather;
  if (weather) {
    $("#weather-temp").textContent = `${Math.round(weather.current_temp_c)}°`;
    $("#weather-location").textContent = weather.location || "Local Weather";
    $("#forecast-strip").innerHTML = (weather.daily || []).slice(0, 4).map((day) => `<div class="forecast-day">
      <span>${day.label}</span>
      <strong>${Math.round(day.high_temp_c)}°/${Math.round(day.low_temp_c)}°</strong>
    </div>`).join("");
  } else {
    $("#forecast-strip").innerHTML = `<div class="empty">Fetch weather before pushing to the band</div>`;
  }
  const lastWeather = (state.data.lastCommands || []).filter((cmd) => cmd.type === "weather").at(-1);
  $("#weather-status").innerHTML = [
    detailRow("B", "Bridge", state.bridgeBase || "same origin", "weather command target"),
    detailRow("Q", "Last Weather Command", lastWeather?.state || "none", lastWeather?.timestamp_local || "")
  ].join("");
}

function renderAll() {
  renderHeader();
  renderToday();
  renderTrends();
  renderSignalCharts();
  renderAnalysis();
  renderRecovery();
  renderSleep();
  renderStrain();
  renderRoutes();
  renderBridgeNetwork();
  renderWeather();
}

async function command(path, payload = {}) {
  if (!hasBridge()) throw new Error("No live bridge - configure Bridge URL in Settings");
  const headers = { "Content-Type": "application/json" };
  if (state.bridgeToken) headers["X-Huawhoop-Token"] = state.bridgeToken;
  const response = await fetch(bridgePath(path), {
    method: "POST",
    headers,
    body: JSON.stringify(payload)
  });
  if (!response.ok) throw new Error(`HTTP ${response.status}`);
  return response.json();
}

function toast(text) {
  const existing = $(".toast");
  if (existing) existing.remove();
  const node = document.createElement("div");
  node.className = "toast";
  node.textContent = text;
  document.body.append(node);
  setTimeout(() => node.remove(), 2800);
}

async function queueSync(full = false) {
  try {
    await command("/api/commands/sync", { full, live_hrv: false });
    toast(full ? "Full sync queued" : "Sync queued");
    await refresh();
  } catch (error) {
    toast(`Sync failed: ${error.message}`);
  }
}

function setupNavigation() {
  document.addEventListener("click", (event) => {
    const target = event.target.closest("[data-goto]");
    if (!target) return;
    showView(target.dataset.goto);
  });
}

function showView(name) {
  $$(".view").forEach((view) => view.classList.toggle("active", view.dataset.view === name));
  $$(".bottom-nav button").forEach((button) => button.classList.toggle("active", button.dataset.goto === name));
  window.scrollTo({ top: 0, behavior: "smooth" });
}

function wmoToOwm(code) {
  if (code === 0) return 800;
  if ([1, 2].includes(code)) return 801;
  if (code === 3) return 804;
  if ([45, 48].includes(code)) return 741;
  if ([51, 53, 55, 56, 57].includes(code)) return 300;
  if ([61, 63, 65, 66, 67, 80, 81, 82].includes(code)) return 500;
  if ([71, 73, 75, 77, 85, 86].includes(code)) return 600;
  if ([95, 96, 99].includes(code)) return 200;
  return 800;
}

async function fetchWeather() {
  const lat = Number($("#weather-lat").value);
  const lon = Number($("#weather-lon").value);
  if (!Number.isFinite(lat) || !Number.isFinite(lon)) {
    toast("Set latitude and longitude first");
    return null;
  }
  const params = new URLSearchParams({
    latitude: String(lat),
    longitude: String(lon),
    current: "temperature_2m,relative_humidity_2m,apparent_temperature,weather_code,wind_speed_10m,wind_direction_10m",
    hourly: "temperature_2m,precipitation_probability,uv_index,weather_code",
    daily: "weather_code,temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max",
    forecast_days: "8",
    timezone: "auto"
  });
  const response = await fetch(`https://api.open-meteo.com/v1/forecast?${params}`);
  if (!response.ok) throw new Error(`weather HTTP ${response.status}`);
  const data = await response.json();
  const currentWeather = data.current || {};
  const daily = (data.daily?.time || []).map((date, index) => ({
    label: new Date(date).toLocaleDateString([], { weekday: "short" }),
    timestamp: Math.floor(new Date(date).getTime() / 1000),
    condition_code: wmoToOwm(data.daily.weather_code?.[index] ?? currentWeather.weather_code),
    high_temp_c: data.daily.temperature_2m_max?.[index],
    low_temp_c: data.daily.temperature_2m_min?.[index],
    sunrise: Math.floor(new Date(data.daily.sunrise?.[index] || date).getTime() / 1000),
    sunset: Math.floor(new Date(data.daily.sunset?.[index] || date).getTime() / 1000),
    uv_index: data.daily.uv_index_max?.[index] ?? 0
  }));
  state.weather = {
    location: $("#weather-name").value || "Local Weather",
    latitude: lat,
    longitude: lon,
    timestamp: Math.floor(Date.now() / 1000),
    source: "Open-Meteo",
    current_temp_c: currentWeather.temperature_2m,
    feels_like_c: currentWeather.apparent_temperature,
    humidity: currentWeather.relative_humidity_2m,
    condition_code: wmoToOwm(currentWeather.weather_code),
    wind_speed_kmh: currentWeather.wind_speed_10m,
    wind_direction: currentWeather.wind_direction_10m,
    low_temp_c: daily[0]?.low_temp_c ?? currentWeather.temperature_2m,
    high_temp_c: daily[0]?.high_temp_c ?? currentWeather.temperature_2m,
    uv_index: daily[0]?.uv_index ?? 0,
    hourly: (data.hourly?.time || []).slice(0, 72).map((time, index) => ({
      timestamp: Math.floor(new Date(time).getTime() / 1000),
      condition_code: wmoToOwm(data.hourly.weather_code?.[index] ?? currentWeather.weather_code),
      temp_c: data.hourly.temperature_2m?.[index],
      precipitation: data.hourly.precipitation_probability?.[index] ?? 0,
      uv_index: data.hourly.uv_index?.[index] ?? 0
    })),
    daily
  };
  state.weatherConfig = {
    name: state.weather.location,
    lat: String(lat),
    lon: String(lon)
  };
  localStorage.setItem("huawhoop.weatherConfig", JSON.stringify(state.weatherConfig));
  renderWeather();
  toast("Weather fetched");
  return state.weather;
}

async function pushWeather() {
  try {
    const weather = state.weather || await fetchWeather();
    if (!weather) return;
    await command("/api/commands/weather", weather);
    toast("Weather push queued");
  } catch (error) {
    toast(`Weather failed: ${error.message}`);
  }
}

async function queueWatchfaceScan() {
  try {
    await command("/api/commands/watchfaces", {});
    toast("Watchface scan queued");
    await refresh();
  } catch (error) {
    toast(`Watchface scan failed: ${error.message}`);
  }
}

async function queueWatchfaceActivate(fileName, version) {
  if (!fileName) return;
  try {
    await command("/api/commands/watchface_activate", { file_name: fileName, version });
    toast("Watchface activation queued");
    await refresh();
  } catch (error) {
    toast(`Watchface activation failed: ${error.message}`);
  }
}

async function queueStress(calibrate = false) {
  try {
    await command("/api/commands/stress", calibrate ? { calibrate: true, duration: 62 } : { enabled: true });
    toast(calibrate ? "Stress calibration queued" : "Auto stress command queued");
    await refresh();
  } catch (error) {
    toast(`Stress command failed: ${error.message}`);
  }
}

async function runAnalysis() {
  try {
    const response = await command("/api/analysis", {});
    state.data.analysis = response;
    renderAnalysis();
    toast(response.cache_hit ? "Analysis loaded from cache" : "Analysis generated");
  } catch (error) {
    toast(`Analysis failed: ${error.message}`);
  }
}

function setupActions() {
  $("#weather-name").value = state.weatherConfig.name || $("#weather-name").value || "Local Weather";
  $("#weather-lat").value = state.weatherConfig.lat || "";
  $("#weather-lon").value = state.weatherConfig.lon || "";
  $("#refresh-button").addEventListener("click", refresh);
  $("#sync-button").addEventListener("click", () => queueSync(false));
  $("#light-sync-button").addEventListener("click", () => queueSync(false));
  $("#full-sync-button").addEventListener("click", () => queueSync(true));
  $("#weather-fetch-button").addEventListener("click", () => fetchWeather().catch((error) => toast(error.message)));
  $("#weather-send-button").addEventListener("click", pushWeather);
  $("#watchface-scan-button").addEventListener("click", queueWatchfaceScan);
  $("#stress-calibrate-button").addEventListener("click", () => queueStress(true));
  $("#stress-enable-button").addEventListener("click", () => queueStress(false));
  $("#analysis-button").addEventListener("click", runAnalysis);
  $("#geo-button").addEventListener("click", () => {
    if (!navigator.geolocation) {
      toast("Location unavailable");
      return;
    }
    navigator.geolocation.getCurrentPosition((pos) => {
      $("#weather-lat").value = pos.coords.latitude.toFixed(5);
      $("#weather-lon").value = pos.coords.longitude.toFixed(5);
      state.weatherConfig = {
        name: $("#weather-name").value || "Local Weather",
        lat: $("#weather-lat").value,
        lon: $("#weather-lon").value
      };
      localStorage.setItem("huawhoop.weatherConfig", JSON.stringify(state.weatherConfig));
      toast("Location set");
    }, () => toast("Location denied"));
  });
  $("#bridge-url").value = state.bridgeBase;
  $("#bridge-token").value = state.bridgeToken;
  $("#save-bridge-button").addEventListener("click", async () => {
    state.bridgeBase = $("#bridge-url").value.trim();
    state.bridgeToken = $("#bridge-token").value.trim();
    localStorage.setItem("huawhoop.bridgeBase", state.bridgeBase);
    if (state.bridgeToken) localStorage.setItem("huawhoop.bridgeToken", state.bridgeToken);
    else localStorage.removeItem("huawhoop.bridgeToken");
    await refresh();
    toast("Bridge saved");
  });
  $("#clear-bridge-button").addEventListener("click", async () => {
    state.bridgeBase = "";
    state.bridgeToken = "";
    $("#bridge-url").value = "";
    $("#bridge-token").value = "";
    localStorage.removeItem("huawhoop.bridgeBase");
    localStorage.removeItem("huawhoop.bridgeToken");
    await refresh();
  });
  $("#copy-lan-button").addEventListener("click", async () => {
    const info = state.data.bridgeInfo || {};
    const url = info.lan_api_urls?.[0] || info.local_api || state.bridgeBase || "";
    if (!url || !navigator.clipboard) {
      toast(url || "No bridge URL");
      return;
    }
    await navigator.clipboard.writeText(url);
    toast("Bridge URL copied");
  });
}

async function refresh() {
  await loadData();
  renderAll();
}

setupNavigation();
setupActions();
refresh().catch(console.error);
setInterval(refresh, 30000);
