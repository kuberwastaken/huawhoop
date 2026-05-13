import asyncio
import json
import os
import threading
import time
import webbrowser
from functools import partial
from http.server import SimpleHTTPRequestHandler, ThreadingHTTPServer
from pathlib import Path
from urllib.parse import unquote, urlparse

import band_daemon


ROOT = Path(__file__).resolve().parent
DATA_DIR = ROOT / "data"
COMMAND_QUEUE = DATA_DIR / "bridge_commands.jsonl"
COMMAND_LOCK = threading.Lock()

ARTIFACT_ALLOWLIST = {
    "connection_status.json",
    "latest_sync_status.json",
    "latest_insights.json",
    "latest_recovery_summary.json",
    "latest_recovery_report.md",
    "latest_capabilities.json",
    "latest_fitness_preview.json",
    "latest_stress_preview.json",
    "latest_stress_settings.json",
    "latest_sleep_sequence_preview.json",
    "latest_trusleep_preview.json",
    "latest_live_hrv.json",
    "latest_passive_health_settings.json",
    "latest_weather_push.json",
    "latest_watchfaces.json",
    "latest_watchface_operation.json",
    "recovery_history.jsonl",
    "insights_history.jsonl",
    "live_hrv_history.jsonl",
    "bridge_command_results.jsonl",
}


def read_json_artifact(filename: str, fallback=None):
    path = DATA_DIR / filename
    try:
        return json.loads(path.read_text(encoding="utf-8"))
    except Exception:
        return fallback


def read_jsonl_tail(filename: str, limit: int = 20) -> list[dict]:
    path = DATA_DIR / filename
    rows = []
    try:
        for line in path.read_text(encoding="utf-8").splitlines()[-limit:]:
            if line.strip():
                rows.append(json.loads(line))
    except Exception:
        pass
    return rows


def append_bridge_command(command_type: str, payload: dict) -> dict:
    DATA_DIR.mkdir(exist_ok=True)
    now_ms = int(time.time() * 1000)
    command = {
        "id": f"{now_ms}-{threading.get_ident()}",
        "type": command_type,
        "queued_at": int(time.time()),
        "queued_at_local": time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),
        "source": "dashboard",
        "payload": payload or {},
    }
    with COMMAND_LOCK:
        with COMMAND_QUEUE.open("a", encoding="utf-8") as fh:
            fh.write(json.dumps(command, separators=(",", ":")) + "\n")
    return command


def save_weather_payload(payload: dict):
    if not payload:
        return
    DATA_DIR.mkdir(exist_ok=True)
    saved = dict(payload)
    saved["saved_at"] = int(time.time())
    saved["saved_at_local"] = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
    (DATA_DIR / "weather_payload.json").write_text(json.dumps(saved, indent=2), encoding="utf-8")


class DashboardHandler(SimpleHTTPRequestHandler):
    def log_message(self, fmt, *args):
        return

    def end_headers(self):
        origin = self.headers.get("Origin")
        self.send_header("Access-Control-Allow-Origin", origin or "*")
        self.send_header("Vary", "Origin")
        self.send_header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
        self.send_header("Access-Control-Allow-Headers", "Content-Type")
        self.send_header("Cache-Control", "no-store")
        super().end_headers()

    def do_OPTIONS(self):
        self.send_response(204)
        self.end_headers()

    def _read_request_json(self) -> dict:
        length = int(self.headers.get("Content-Length", "0") or "0")
        if length <= 0:
            return {}
        body = self.rfile.read(length)
        try:
            return json.loads(body.decode("utf-8"))
        except Exception:
            return {}

    def _send_json(self, payload: dict, status: int = 200):
        body = json.dumps(payload, indent=2, sort_keys=True).encode("utf-8")
        self.send_response(status)
        self.send_header("Content-Type", "application/json; charset=utf-8")
        self.send_header("Content-Length", str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def _send_text(self, text: str, status: int = 200, content_type: str = "text/plain; charset=utf-8"):
        body = text.encode("utf-8")
        self.send_response(status)
        self.send_header("Content-Type", content_type)
        self.send_header("Content-Length", str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def _status_payload(self) -> dict:
        return {
            "bridge": {
                "state": "serving",
                "host": self.server.server_address[0],
                "port": self.server.server_address[1],
                "timestamp": int(time.time()),
                "timestamp_local": time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),
            },
            "connection": read_json_artifact("connection_status.json", {}),
            "sync": read_json_artifact("latest_sync_status.json", {}),
            "insights": read_json_artifact("latest_insights.json", {}),
            "last_commands": read_jsonl_tail("bridge_command_results.jsonl", limit=12),
        }

    def do_GET(self):
        parsed = urlparse(self.path)
        path = parsed.path
        if path == "/api/status":
            self._send_json(self._status_payload())
            return
        if path == "/api/insights":
            self._send_json(read_json_artifact("latest_insights.json", {}))
            return
        if path == "/api/export":
            self._send_json({
                "status": self._status_payload(),
                "recovery": read_json_artifact("latest_recovery_summary.json", {}),
                "sleep_sequence": read_json_artifact("latest_sleep_sequence_preview.json", {}),
                "fitness": read_json_artifact("latest_fitness_preview.json", {}),
            })
            return
        if path.startswith("/api/artifacts/"):
            filename = unquote(path.removeprefix("/api/artifacts/"))
            if filename not in ARTIFACT_ALLOWLIST:
                self._send_json({"error": "artifact_not_allowed", "filename": filename}, status=404)
                return
            artifact_path = DATA_DIR / filename
            if not artifact_path.exists():
                self._send_json({"error": "artifact_missing", "filename": filename}, status=404)
                return
            if filename.endswith(".json"):
                self._send_json(read_json_artifact(filename, {}))
            else:
                self._send_text(artifact_path.read_text(encoding="utf-8"))
            return
        super().do_GET()

    def do_POST(self):
        parsed = urlparse(self.path)
        path = parsed.path
        payload = self._read_request_json()
        if path in ("/api/commands/sync", "/api/sync"):
            command = append_bridge_command("sync", {
                "full": bool(payload.get("full", True)),
                "live_hrv": bool(payload.get("live_hrv", False)),
            })
            self._send_json({"queued": True, "command": command}, status=202)
            return
        if path in ("/api/commands/weather", "/api/weather"):
            save_weather_payload(payload)
            command = append_bridge_command("weather", payload)
            self._send_json({"queued": True, "command": command}, status=202)
            return
        if path in ("/api/commands/watchfaces", "/api/watchfaces"):
            command = append_bridge_command("watchfaces", payload)
            self._send_json({"queued": True, "command": command}, status=202)
            return
        if path in ("/api/commands/watchface_activate", "/api/watchface_activate"):
            command = append_bridge_command("watchface_activate", payload)
            self._send_json({"queued": True, "command": command}, status=202)
            return
        if path in ("/api/commands/stress", "/api/stress"):
            command = append_bridge_command("stress", payload)
            self._send_json({"queued": True, "command": command}, status=202)
            return
        self._send_json({"error": "unknown_endpoint", "path": path}, status=404)


def start_dashboard_server(host: str, port: int):
    handler = partial(DashboardHandler, directory=str(ROOT))
    server = ThreadingHTTPServer((host, port), handler)
    thread = threading.Thread(target=server.serve_forever, name="dashboard-http", daemon=True)
    thread.start()
    return server


async def main():
    host = os.getenv("BAND10_DASHBOARD_HOST", "127.0.0.1")
    port = int(os.getenv("BAND10_DASHBOARD_PORT", "8765"))
    url = f"http://{host}:{port}/dashboard/"
    start_dashboard_server(host, port)
    print(f"Dashboard: {url}", flush=True)
    print("Keeping one authenticated BLE session open. Use Ctrl+C to stop.", flush=True)
    print("Live HRV probes are opt-in: set BAND10_LIVE_HRV_EVERY to a cycle interval.", flush=True)
    if os.getenv("BAND10_OPEN_BROWSER", "1") != "0":
        webbrowser.open(url)
    await band_daemon.main()


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        pass
