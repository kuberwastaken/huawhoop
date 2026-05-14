const CACHE_NAME = "huawhoop-v3";
const ASSETS = [
  "./",
  "./index.html",
  "./styles.css",
  "./app.js",
  "./manifest.webmanifest",
  "./icon.svg",
  "./sample-data/connection_status.json",
  "./sample-data/latest_sync_status.json",
  "./sample-data/latest_insights.json",
  "./sample-data/latest_recovery_summary.json",
  "./sample-data/latest_fitness_preview.json",
  "./sample-data/latest_capabilities.json",
  "./sample-data/latest_sleep_sequence_preview.json",
  "./sample-data/latest_trusleep_preview.json",
  "./sample-data/latest_stress_preview.json",
  "./sample-data/latest_stress_settings.json",
  "./sample-data/latest_live_hrv.json",
  "./sample-data/latest_watchfaces.json",
  "./sample-data/latest_watchface_operation.json",
  "./sample-data/latest_analysis.json",
  "./sample-data/recovery_history.jsonl",
  "./sample-data/insights_history.jsonl"
];

self.addEventListener("install", (event) => {
  event.waitUntil(caches.open(CACHE_NAME).then((cache) => cache.addAll(ASSETS)));
  self.skipWaiting();
});

self.addEventListener("activate", (event) => {
  event.waitUntil(
    caches.keys().then((keys) => Promise.all(keys.filter((key) => key !== CACHE_NAME).map((key) => caches.delete(key))))
  );
  self.clients.claim();
});

self.addEventListener("fetch", (event) => {
  const url = new URL(event.request.url);
  if (url.pathname.includes("/api/") || event.request.method !== "GET") {
    return;
  }
  event.respondWith(
    caches.match(event.request).then((cached) => cached || fetch(event.request))
  );
});
