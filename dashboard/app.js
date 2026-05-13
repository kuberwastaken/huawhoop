const files = {
  insights: "../data/latest_insights.json",
  connection: "../data/connection_status.json",
  summary: "../data/latest_recovery_summary.json",
  fitness: "../data/latest_fitness_preview.json",
  capabilities: "../data/latest_capabilities.json",
  dictionary: "../data/latest_dictionary_probe.json",
  trusleep: "../data/latest_trusleep_preview.json",
  stress: "../data/latest_stress_preview.json",
  sequence: "../data/latest_sleep_sequence_preview.json",
  liveHrv: "../data/latest_live_hrv.json",
  history: "../data/recovery_history.jsonl"
};

const fmt = new Intl.NumberFormat(undefined, { maximumFractionDigits: 1 });

async function loadJson(path, fallback = null) {
  try {
    const response = await fetch(path, { cache: "no-store" });
    if (!response.ok) return fallback;
    return await response.json();
  } catch {
    return fallback;
  }
}

async function loadText(path, fallback = "") {
  try {
    const response = await fetch(path, { cache: "no-store" });
    if (!response.ok) return fallback;
    return await response.text();
  } catch {
    return fallback;
  }
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

function metric(label, value, sub) {
  return `<article class="metric">
    <div class="label">${label}</div>
    <div class="value">${value}</div>
    <div class="sub">${sub || ""}</div>
  </article>`;
}

function pill(text, cls = "") {
  return `<span class="pill ${cls}">${text}</span>`;
}

function compactStatus(status) {
  if (status === null || status === undefined) return "n/a";
  if (typeof status === "string") return status;
  return `0x${Number(status).toString(16).padStart(8, "0")}`;
}

function liveHrvTransport(insights, liveHrv) {
  return insights?.data_quality?.live_hrv_transport || {
    state: liveHrv?.sample_count ? "streaming" : "not_run",
    sample_count: liveHrv?.sample_count || 0,
    realtime_hr_sample_count: liveHrv?.realtime_hr_sample_count || 0,
    request: liveHrv?.request || {},
    event_count: (liveHrv?.transport_events || []).length
  };
}

function pathFromPoints(points) {
  return points.map((p, i) => `${i === 0 ? "M" : "L"}${p[0].toFixed(1)},${p[1].toFixed(1)}`).join(" ");
}

function lineChart(container, series, options = {}) {
  const width = 760;
  const height = options.height || 260;
  const pad = { left: 38, right: 16, top: 18, bottom: 28 };
  const all = series.flatMap(s => s.values.map(v => v.y)).filter(Number.isFinite);
  if (!all.length) {
    container.innerHTML = `<div class="empty">No samples in the current artifact.</div>`;
    return;
  }
  const minY = options.minY ?? Math.min(...all);
  const maxY = options.maxY ?? Math.max(...all);
  const ySpan = Math.max(1, maxY - minY);
  const maxLen = Math.max(...series.map(s => s.values.length), 1);
  const plotW = width - pad.left - pad.right;
  const plotH = height - pad.top - pad.bottom;

  const lines = series.map(s => {
    const pts = s.values.map((v, idx) => {
      const x = pad.left + (idx / Math.max(1, maxLen - 1)) * plotW;
      const y = pad.top + (1 - ((v.y - minY) / ySpan)) * plotH;
      return [x, y];
    });
    return `<path class="${s.className}" d="${pathFromPoints(pts)}"></path>`;
  }).join("");

  const grid = [0, 0.25, 0.5, 0.75, 1].map(t => {
    const y = pad.top + t * plotH;
    const label = Math.round(maxY - t * ySpan);
    return `<line class="grid-line" x1="${pad.left}" y1="${y}" x2="${width - pad.right}" y2="${y}"></line>
      <text class="chart-label" x="4" y="${y + 4}">${label}</text>`;
  }).join("");

  const labels = series.map((s, i) => {
    const x = pad.left + i * 96;
    return `<text class="chart-label" x="${x}" y="${height - 6}">${s.label}</text>`;
  }).join("");

  container.innerHTML = `<svg viewBox="0 0 ${width} ${height}" role="img">
    ${grid}
    <line class="axis" x1="${pad.left}" y1="${height - pad.bottom}" x2="${width - pad.right}" y2="${height - pad.bottom}"></line>
    ${lines}
    ${labels}
  </svg>`;
}

function barChart(container, values) {
  const width = 420;
  const height = 190;
  const pad = 18;
  const max = Math.max(...values, 1);
  const shown = values.slice(-96);
  const barW = (width - pad * 2) / Math.max(shown.length, 1);
  const bars = shown.map((v, i) => {
    const h = (v / max) * (height - pad * 2);
    const x = pad + i * barW;
    const y = height - pad - h;
    return `<rect class="bar" x="${x.toFixed(1)}" y="${y.toFixed(1)}" width="${Math.max(1, barW - 1).toFixed(1)}" height="${h.toFixed(1)}"></rect>`;
  }).join("");
  container.innerHTML = `<svg viewBox="0 0 ${width} ${height}" role="img">
    <line class="axis" x1="${pad}" y1="${height - pad}" x2="${width - pad}" y2="${height - pad}"></line>
    ${bars}
  </svg>`;
}

function renderMetrics(summary, insights) {
  const grid = document.getElementById("metric-grid");
  const hrv = insights.hrv || {};
  const hrvValue = hrv.rmssd_ms ?? hrv.avg_hrv_ms ?? "n/a";
  grid.innerHTML = [
    metric("Recovery", `${insights.recovery_score ?? summary.recovery_proxy_no_hrv ?? "n/a"}`, `${insights.recovery_label || "proxy"} readiness`),
    metric("Strain", `${insights.strain?.strain ?? summary.strain_score ?? "n/a"}`, `${insights.strain?.trimp ?? "n/a"} TRIMP`),
    metric("HRV", `${hrvValue}`, hrv.source ? `${hrv.source}` : "not available"),
    metric("Sleep", `${insights.sleep?.score ?? summary.sleep_score ?? "n/a"}`, `${insights.sleep?.minutes ?? summary.sleep_minutes ?? 0} / ${insights.sleep?.need_minutes ?? 480} min`),
    metric("Steps", fmt.format(summary.step_total ?? 0), summary.step_window_end || ""),
    metric("Resting HR", `${insights.resting_hr ?? summary.resting_hr_avg ?? "n/a"}`, `${insights.resting_hr_baseline ?? "n/a"} baseline`)
  ].join("");
}

function renderStatus(summary, capabilities, dictionary, connection, insights, liveHrv) {
  const strip = document.getElementById("status-strip");
  const p2pOk = dictionary && Object.keys(dictionary).length > 0;
  const connected = connection?.state === "connected";
  const hrvSource = insights?.data_quality?.hrv_source || "unavailable";
  const transport = liveHrvTransport(insights, liveHrv);
  strip.innerHTML = [
    pill(connected ? "Connected" : connection?.state || "No daemon", connected ? "ok" : "warn"),
    pill("Reconnect auth", "ok"),
    pill("Fitness history", "ok"),
    pill(capabilities?.capability_flags?.dict_sleep_sync ? "Sleep dict bit" : "Sleep dict off", capabilities?.capability_flags?.dict_sleep_sync ? "ok" : "warn"),
    pill(p2pOk ? "P2P probed" : "P2P missing", p2pOk ? "ok" : "warn"),
    pill(hrvSource === "unavailable" ? `HRV ${transport.state || "pending"}` : `HRV ${hrvSource}`, hrvSource === "unavailable" ? "warn" : "ok")
  ].join("");
  const label = connection?.timestamp_local || summary.generated_at_local || localTime(summary.generated_at);
  document.getElementById("sync-label").textContent = `Last seen: ${label}`;
}

function renderCharts(fitness, historyRows) {
  const steps = fitness.steps || [];
  const hr = steps.filter(x => Number.isFinite(x.heart_rate)).map(x => ({ y: x.heart_rate }));
  const spo2 = steps.filter(x => Number.isFinite(x.spo2)).map(x => ({ y: x.spo2 }));
  document.getElementById("sample-count-pill").textContent = `${hr.length} HR / ${spo2.length} SpO2`;
  lineChart(document.getElementById("hr-chart"), [
    { label: "Heart rate", values: hr, className: "hr-line" },
    { label: "SpO2", values: spo2, className: "spo2-line" }
  ], { minY: 50, maxY: 170, height: 280 });

  const loadChart = document.getElementById("load-chart");
  if (loadChart) barChart(loadChart, steps.map(x => x.calories || 0));

  const history = historyRows.slice(-30).map(row => ({ y: row.recovery_proxy_no_hrv || 0 }));
  lineChart(document.getElementById("history-chart"), [
    { label: "Recovery proxy", values: history, className: "history-line" }
  ], { minY: 0, maxY: 100, height: 190 });
}

function renderRecovery(insights, liveHrv) {
  const panel = document.getElementById("recovery-panel");
  const components = insights.components || {};
  const rows = Object.entries(components).map(([name, value]) => `
    <div class="component-row">
      <span>${name.toUpperCase()}</span>
      <div class="component-bar"><i style="width:${Math.max(0, Math.min(100, value))}%"></i></div>
      <strong>${Math.round(value)}</strong>
    </div>
  `).join("");
  const hrv = insights.hrv || {};
  const transport = liveHrvTransport(insights, liveHrv);
  const request = transport.request || {};
  panel.innerHTML = `
    <div class="recovery-score ${insights.recovery_label || "yellow"}">${insights.recovery_score ?? "n/a"}</div>
    <div class="component-list">${rows || `<div class="empty">No recovery components yet.</div>`}</div>
    <div class="sleep-row"><span>HRV source</span><strong>${hrv.source || "unavailable"}</strong></div>
    <div class="sleep-row"><span>HRV detail</span><strong>${hrv.rmssd_ms ?? hrv.avg_hrv_ms ?? hrv.reason ?? "n/a"}</strong></div>
    <div class="sleep-row"><span>Live stream</span><strong>${transport.state || "not_run"} · ${transport.sample_count ?? 0} RRI · ${transport.realtime_hr_sample_count ?? 0} HR</strong></div>
    <div class="sleep-row"><span>Live request</span><strong>type ${request.open_type ?? "n/a"} vol ${request.vol_status ?? "off"}</strong></div>
    <div class="sleep-row"><span>Last HRV status</span><strong>${transport.latest_status_hex || compactStatus(transport.latest_status)}</strong></div>
  `;
}

function renderStrain(insights) {
  const panel = document.getElementById("strain-panel");
  const strain = insights.strain || {};
  const zones = strain.zone_minutes || {};
  const max = Math.max(...Object.values(zones), 1);
  panel.innerHTML = Object.entries(zones).map(([name, value]) => `
    <div class="component-row">
      <span>${name}</span>
      <div class="component-bar"><i style="width:${(value / max) * 100}%"></i></div>
      <strong>${value}m</strong>
    </div>
  `).join("") + `
    <div class="sleep-row"><span>Acute 7d</span><strong>${insights.training_balance?.acute_7d ?? "n/a"}</strong></div>
    <div class="sleep-row"><span>Chronic 42d</span><strong>${insights.training_balance?.chronic_42d ?? "n/a"}</strong></div>
    <div class="sleep-row"><span>Load ratio</span><strong>${insights.training_balance?.load_ratio ?? "n/a"} · ${insights.training_balance?.label ?? "collecting"}</strong></div>
    <div class="sleep-row"><span>Balance</span><strong>${insights.training_balance?.balance ?? "n/a"}</strong></div>
    <div class="sleep-row"><span>Guidance</span><strong>${insights.training_balance?.recommendation ?? "Collecting baseline."}</strong></div>
  `;
}

function renderSleep(summary, trusleep, sequence, insights) {
  const panel = document.getElementById("sleep-panel");
  const sequenceCount = sequence?.sequence_count ?? trusleep?.sequence?.sequence_count ?? 0;
  const sequenceErrors = sequence?.errors || trusleep?.sequence?.errors || [];
  const sleep = insights?.sleep || {};
  const components = sleep.components || {};
  panel.innerHTML = [
    ["Sleep minutes", `${summary.sleep_minutes ?? 0}`],
    ["Sleep score", `${sleep.score ?? summary.sleep_score ?? "n/a"}`],
    ["Performance", `${sleep.performance_score ?? "n/a"}`],
    ["Fragmentation", `${components.fragmentation ?? "n/a"}`],
    ["Consistency", `${components.consistency ?? "collecting"}`],
    ["Window start", summary.sleep_window_start || "n/a"],
    ["Window end", summary.sleep_window_end || "n/a"],
    ["Sequence sessions", `${sequenceCount}`],
    ["Sequence status", sequenceErrors.length ? sequenceErrors.join(", ") : "ready"]
  ].map(([a, b]) => `<div class="sleep-row"><span>${a}</span><strong>${b}</strong></div>`).join("");
}

function renderRoutes(dictionary, stress, sequence, insights, liveHrv) {
  const hrvSource = insights?.data_quality?.hrv_source || "unavailable";
  const transport = liveHrvTransport(insights, liveHrv);
  const liveDetail = hrvSource === "live_rri"
    ? "RMSSD computed from streamed RRI/SQI."
    : `${transport.state || "not_run"}; status ${transport.latest_status_hex || compactStatus(transport.latest_status)}; ${transport.event_count || 0} events.`;
  const rows = [
    ["Fitness minute history", "ok", "Steps, HR, SpO2, sleep segments are available."],
    ["Live RRI HRV", hrvSource === "live_rri" ? "ok" : "warn", liveDetail],
    ["Stress/RRI file", stress?.stress_count > 0 ? "ok" : "warn", stress?.stress_count > 0 ? `${stress.stress_count} stress samples` : "No file payload in latest artifact."],
    ["Sleep sequence file", sequence?.file_size > 0 ? "ok" : "warn", sequence?.file_size > 0 ? `${sequence.sequence_count} sessions` : (sequence?.errors || ["No metadata returned"]).join(", ")],
    ["P2P skin temperature", dictionary?.skin_temperature?.status === "ack_no_data" ? "warn" : "bad", dictionary?.skin_temperature?.status || "not probed"],
    ["P2P HRV dictionary", dictionary?.hrv?.status === "error_tlv" ? "bad" : "warn", dictionary?.hrv?.error_tlvs?.["0x7f"] || dictionary?.hrv?.status || "not probed"]
  ];
  document.getElementById("route-table").innerHTML = rows.map(([name, state, detail]) => `
    <div class="route-row">
      <span class="route-name">${name}</span>
      <span class="route-detail">${pill(state, state)} ${detail}</span>
    </div>`).join("");
}

function renderCapabilities(capabilities) {
  const flags = capabilities?.capability_flags || {};
  const important = [
    "multi_device",
    "dict_sleep_sync",
    "bed_time",
    "device_command_dict_data",
    "track_p2p",
    "sleep_apnea",
    "emotion",
    "hrv",
    "notification_picture",
    "contacts_sync"
  ];
  document.getElementById("capabilities").innerHTML = important.map(key => {
    const value = Boolean(flags[key]);
    return `<div class="cap-row">
      <span class="cap-name">${key.replaceAll("_", " ")}</span>
      <span class="cap-detail">${pill(value ? "true" : "false", value ? "ok" : "warn")}</span>
    </div>`;
  }).join("");
}

function parseHistory(text) {
  return text.split(/\r?\n/)
    .filter(Boolean)
    .map(line => {
      try { return JSON.parse(line); } catch { return null; }
    })
    .filter(Boolean);
}

async function boot() {
  const [insights, connection, summary, fitness, capabilities, dictionary, trusleep, stress, sequence, liveHrv, historyText] = await Promise.all([
    loadJson(files.insights, {}),
    loadJson(files.connection, {}),
    loadJson(files.summary, {}),
    loadJson(files.fitness, {}),
    loadJson(files.capabilities, {}),
    loadJson(files.dictionary, {}),
    loadJson(files.trusleep, {}),
    loadJson(files.stress, {}),
    loadJson(files.sequence, {}),
    loadJson(files.liveHrv, {}),
    loadText(files.history, "")
  ]);
  const historyRows = parseHistory(historyText);
  renderMetrics(summary, insights);
  renderStatus(summary, capabilities, dictionary, connection, insights, liveHrv);
  renderCharts(fitness, historyRows);
  renderRecovery(insights, liveHrv);
  renderStrain(insights);
  renderSleep(summary, trusleep, sequence, insights);
  renderRoutes(dictionary, stress, sequence, insights, liveHrv);
  renderCapabilities(capabilities);
}

boot();
