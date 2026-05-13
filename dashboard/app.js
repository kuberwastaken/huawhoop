const artifactFiles = {
  connection: "../data/connection_status.json",
  sync: "../data/latest_sync_status.json",
  insights: "../data/latest_insights.json",
  summary: "../data/latest_recovery_summary.json",
  fitness: "../data/latest_fitness_preview.json",
  capabilities: "../data/latest_capabilities.json",
  sequence: "../data/latest_sleep_sequence_preview.json",
  trusleep: "../data/latest_trusleep_preview.json",
  stress: "../data/latest_stress_preview.json",
  stressSettings: "../data/latest_stress_settings.json",
  liveHrv: "../data/latest_live_hrv.json",
  watchfaces: "../data/latest_watchfaces.json",
  watchfaceOperation: "../data/latest_watchface_operation.json",
  recoveryHistory: "../data/recovery_history.jsonl",
  insightsHistory: "../data/insights_history.jsonl"
};

const state = {
  data: {},
  weather: null,
  bridgeBase: localStorage.getItem("huawhoop.bridgeBase") || ""
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
  const api = await fetchJson(bridgePath("/api/status"), null);
  if (api && (api.connection || api.insights || api.bridge)) {
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
      recoveryHistory: parseJsonl(historyText),
      insightsHistory: parseJsonl(insightsHistoryText),
      bridge: api.bridge || {},
      lastCommands: api.last_commands || []
    };
    return;
  }

  const entries = await Promise.all([
    fetchJson(artifactFiles.connection, {}),
    fetchJson(artifactFiles.sync, {}),
    fetchJson(artifactFiles.insights, {}),
    fetchJson(artifactFiles.summary, {}),
    fetchJson(artifactFiles.fitness, {}),
    fetchJson(artifactFiles.capabilities, {}),
    fetchJson(artifactFiles.sequence, {}),
    fetchJson(artifactFiles.trusleep, {}),
    fetchJson(artifactFiles.stress, {}),
    fetchJson(artifactFiles.stressSettings, {}),
    fetchJson(artifactFiles.liveHrv, {}),
    fetchJson(artifactFiles.watchfaces, {}),
    fetchJson(artifactFiles.watchfaceOperation, {}),
    fetchText(artifactFiles.recoveryHistory, ""),
    fetchText(artifactFiles.insightsHistory, "")
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
    recoveryHistory: parseJsonl(entries[13]),
    insightsHistory: parseJsonl(entries[14]),
    bridge: {},
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

function ringCard(label, value, max, color, sub, decimals = 0) {
  return `<article class="ring-card">
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
  const connected = data.connection?.state === "connected";
  $("#connection-state").textContent = connected ? "Connected" : (data.connection?.state || "Offline");
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
    ringCard("Sleep", values.sleepScore, 100, "var(--orange)", `${Math.round(values.sleepMinutes / 60)}h`, 0),
    ringCard("Recovery", values.recovery, 100, "var(--teal)", values.recoveryLabel, 0),
    ringCard("Strain", values.strain, 21, "var(--blue)", `${fmt.format(strain.trimp || 0)} load`, 1)
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
  $("#recovery-details").innerHTML = [
    detailRow("V", "Heart Rate Variability", Number.isFinite(values.hrv) ? `${Math.round(values.hrv)} ms` : "--", hrv.source || "sleep sequence"),
    detailRow("R", "Resting Heart Rate", Number.isFinite(values.rhr) ? `${Math.round(values.rhr)} bpm` : "--", `${insights.resting_hr_baseline || "--"} baseline`),
    detailRow("O", "Oxygen Saturation", insights.sleep?.avg_spo2 ? `${insights.sleep.avg_spo2}%` : "--", "overnight"),
    `<section class="panel zone-bars">
      ${Object.entries(components).map(([name, value]) => meter(name.toUpperCase(), number(value), 100)).join("")}
    </section>`
  ].join("");
}

function renderSleep() {
  const sleep = state.data.insights?.sleep || {};
  const values = current();
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
    `<section class="panel zone-bars">
      ${Object.entries(stages).map(([stage, value]) => {
        const names = { 1: "Light", 2: "REM", 3: "Deep", 4: "Awake", 5: "Nap" };
        return meter(names[stage] || `Stage ${stage}`, number(value), total, "var(--teal)");
      }).join("") || `<div class="empty">No stages yet</div>`}
    </section>`
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
    ${Object.entries(strainZones).map(([name, value]) => meter(`${name} strain`, number(value), maxStrainZone, zoneColor(name))).join("")}
    ${detailRow("L", "Load Ratio", state.data.insights?.training_balance?.load_ratio ?? "--", state.data.insights?.training_balance?.recommendation || "")}
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
    ["Live RRI", quality.live_hrv_transport?.state || "diagnostic", `${quality.live_hrv_transport?.sample_count || 0} samples`]
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
      <button class="secondary-button compact watchface-activate" type="button"
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

function renderWeather() {
  const weather = state.weather;
  if (weather) {
    $("#weather-temp").textContent = `${Math.round(weather.current_temp_c)}°`;
    $("#weather-location").textContent = weather.location || "Local Weather";
    $("#forecast-strip").innerHTML = (weather.daily || []).slice(0, 4).map((day) => `<div class="forecast-day">
      <span>${day.label}</span>
      <strong>${Math.round(day.high_temp_c)}°/${Math.round(day.low_temp_c)}°</strong>
    </div>`).join("");
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
  renderRecovery();
  renderSleep();
  renderStrain();
  renderRoutes();
  renderWeather();
}

async function command(path, payload = {}) {
  const response = await fetch(bridgePath(path), {
    method: "POST",
    headers: { "Content-Type": "application/json" },
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
    forecast_days: "4",
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
    hourly: (data.hourly?.time || []).slice(0, 24).map((time, index) => ({
      timestamp: Math.floor(new Date(time).getTime() / 1000),
      condition_code: wmoToOwm(data.hourly.weather_code?.[index] ?? currentWeather.weather_code),
      temp_c: data.hourly.temperature_2m?.[index],
      precipitation: data.hourly.precipitation_probability?.[index] ?? 0,
      uv_index: data.hourly.uv_index?.[index] ?? 0
    })),
    daily
  };
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

function setupActions() {
  $("#refresh-button").addEventListener("click", refresh);
  $("#sync-button").addEventListener("click", () => queueSync(false));
  $("#light-sync-button").addEventListener("click", () => queueSync(false));
  $("#full-sync-button").addEventListener("click", () => queueSync(true));
  $("#weather-fetch-button").addEventListener("click", () => fetchWeather().catch((error) => toast(error.message)));
  $("#weather-send-button").addEventListener("click", pushWeather);
  $("#watchface-scan-button").addEventListener("click", queueWatchfaceScan);
  $("#stress-calibrate-button").addEventListener("click", () => queueStress(true));
  $("#stress-enable-button").addEventListener("click", () => queueStress(false));
  $("#geo-button").addEventListener("click", () => {
    if (!navigator.geolocation) {
      toast("Location unavailable");
      return;
    }
    navigator.geolocation.getCurrentPosition((pos) => {
      $("#weather-lat").value = pos.coords.latitude.toFixed(5);
      $("#weather-lon").value = pos.coords.longitude.toFixed(5);
      toast("Location set");
    }, () => toast("Location denied"));
  });
  $("#bridge-url").value = state.bridgeBase;
  $("#save-bridge-button").addEventListener("click", async () => {
    state.bridgeBase = $("#bridge-url").value.trim();
    localStorage.setItem("huawhoop.bridgeBase", state.bridgeBase);
    await refresh();
    toast("Bridge saved");
  });
  $("#clear-bridge-button").addEventListener("click", async () => {
    state.bridgeBase = "";
    $("#bridge-url").value = "";
    localStorage.removeItem("huawhoop.bridgeBase");
    await refresh();
  });
}

async function refresh() {
  await loadData();
  renderAll();
}

setupNavigation();
setupActions();
await refresh();
setInterval(refresh, 30000);
