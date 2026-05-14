import asyncio
import hashlib
import json
import os
import socket
import threading
import time
import webbrowser
from functools import partial
from http.server import SimpleHTTPRequestHandler, ThreadingHTTPServer
from pathlib import Path
from urllib.parse import parse_qs, unquote, urlparse

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
    "latest_analysis.json",
    "recovery_history.jsonl",
    "insights_history.jsonl",
    "live_hrv_history.jsonl",
    "bridge_command_results.jsonl",
}


def allowed_origins(port: int) -> set[str]:
    configured = {
        origin.strip().rstrip("/")
        for origin in os.getenv("BAND10_ALLOWED_ORIGINS", "").split(",")
        if origin.strip()
    }
    configured.update({
        f"http://127.0.0.1:{port}",
        f"http://localhost:{port}",
        "https://huawhoop.kuber.studio",
    })
    return configured


def is_local_origin(origin: str) -> bool:
    try:
        host = urlparse(origin).hostname or ""
    except Exception:
        return False
    return host in {"localhost", "127.0.0.1", "::1"} or host.startswith("192.168.") or host.startswith("10.")


def local_lan_addresses() -> list[str]:
    addresses: set[str] = set()
    try:
        with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as sock:
            sock.connect(("8.8.8.8", 80))
            addresses.add(sock.getsockname()[0])
    except Exception:
        pass
    try:
        for info in socket.getaddrinfo(socket.gethostname(), None, socket.AF_INET):
            address = info[4][0]
            if not address.startswith("127."):
                addresses.add(address)
    except Exception:
        pass
    return sorted(addresses)


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


def compact_analysis_dataset() -> dict:
    insights = read_json_artifact("latest_insights.json", {})
    summary = read_json_artifact("latest_recovery_summary.json", {})
    sync = read_json_artifact("latest_sync_status.json", {})
    return {
        "generated_from": {
            "insights_generated_at": insights.get("generated_at"),
            "sync_ended_at": sync.get("ended_at"),
        },
        "scores": {
            "recovery": insights.get("recovery_score"),
            "recovery_label": insights.get("recovery_label"),
            "strain": (insights.get("strain") or {}).get("strain"),
            "stress": (insights.get("stress") or {}).get("label"),
            "sleep_score": (insights.get("sleep") or {}).get("score"),
        },
        "signals": {
            "hrv": insights.get("hrv"),
            "resting_hr": insights.get("resting_hr"),
            "sleep": insights.get("sleep"),
            "spo2": insights.get("spo2"),
            "training_balance": insights.get("training_balance"),
            "data_quality": insights.get("data_quality"),
        },
        "daily_summary": {
            "steps": summary.get("step_total"),
            "heart_rate_min": summary.get("heart_rate_min"),
            "heart_rate_avg": summary.get("heart_rate_avg"),
            "heart_rate_max": summary.get("heart_rate_max"),
            "spo2_min": summary.get("spo2_min"),
            "spo2_avg": summary.get("spo2_avg"),
            "spo2_max": summary.get("spo2_max"),
        },
    }


def dataset_hash(dataset: dict) -> str:
    encoded = json.dumps(dataset, sort_keys=True, separators=(",", ":")).encode("utf-8")
    return hashlib.sha256(encoded).hexdigest()


def deterministic_analysis(dataset: dict) -> dict:
    scores = dataset.get("scores") or {}
    signals = dataset.get("signals") or {}
    sleep = signals.get("sleep") or {}
    strain = signals.get("training_balance") or {}
    spo2 = signals.get("spo2") or {}
    data_quality = signals.get("data_quality") or {}
    recovery = scores.get("recovery")
    advice = []
    if isinstance(recovery, (int, float)) and recovery >= 67:
        advice.append("Recovery is ready enough for normal training; keep intensity honest if stress rises.")
    elif isinstance(recovery, (int, float)) and recovery >= 34:
        advice.append("Recovery is moderate; bias toward technique, zone-2 work, or a shorter hard block.")
    else:
        advice.append("Recovery is low; prioritize sleep debt, hydration, and low strain.")
    if sleep.get("performance_score") is not None and sleep.get("performance_score") < 75:
        advice.append("Sleep performance is the clearest lever: extend the next sleep window before adding load.")
    if spo2.get("minutes_below_95", 0):
        advice.append(f"SpO2 dipped below 95% for {spo2.get('minutes_below_95')} tracked minutes; watch this trend before treating it as signal.")
    if strain.get("load_ratio") and strain.get("load_ratio") > 1.3:
        advice.append("Acute load is running above chronic load; keep the next hard session conditional on HRV/RHR.")
    if data_quality.get("hrv_source") == "live_rri":
        confidence = "good"
    elif data_quality.get("hrv_source") == "sleep_sequence":
        confidence = "steady"
    else:
        confidence = "limited"
    return {
        "summary": " ".join(advice[:2]),
        "actions": advice,
        "confidence": confidence,
        "model": "deterministic-rules-v1",
        "llm_used": False,
        "usage": {"calls": 0, "tokens": 0},
    }


def build_analysis() -> dict:
    DATA_DIR.mkdir(exist_ok=True)
    dataset = compact_analysis_dataset()
    digest = dataset_hash(dataset)
    cache = read_json_artifact("latest_analysis.json", {})
    if cache.get("dataset_hash") == digest:
        cached = dict(cache)
        cached["cache_hit"] = True
        return cached
    analysis = deterministic_analysis(dataset)
    result = {
        **analysis,
        "dataset_hash": digest,
        "cache_hit": False,
        "payload_preview": dataset,
        "generated_at": int(time.time()),
        "generated_at_local": time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),
    }
    (DATA_DIR / "latest_analysis.json").write_text(json.dumps(result, indent=2), encoding="utf-8")
    return result


class DashboardHandler(SimpleHTTPRequestHandler):
    def log_message(self, fmt, *args):
        return

    def end_headers(self):
        origin = self.headers.get("Origin")
        allowed = allowed_origins(self.server.server_address[1])
        if origin and (origin.rstrip("/") in allowed or "*" in allowed or is_local_origin(origin)):
            self.send_header("Access-Control-Allow-Origin", origin)
        elif not origin:
            self.send_header("Access-Control-Allow-Origin", "*")
        else:
            self.send_header("Access-Control-Allow-Origin", "null")
        self.send_header("Vary", "Origin")
        self.send_header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
        self.send_header("Access-Control-Allow-Headers", "Content-Type, X-Huawhoop-Token")
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

    def _authorized(self) -> bool:
        token = os.getenv("BAND10_BRIDGE_TOKEN", "")
        if not token:
            return True
        return self.headers.get("X-Huawhoop-Token", "") == token

    def _bridge_info_payload(self) -> dict:
        host, port = self.server.server_address
        bind_host = os.getenv("BAND10_DASHBOARD_HOST", host)
        lan_urls = [f"http://{address}:{port}/dashboard/" for address in local_lan_addresses()]
        api_urls = [url.replace("/dashboard/", "") for url in lan_urls]
        return {
            "bind_host": bind_host,
            "port": port,
            "same_origin": "/",
            "local_url": f"http://127.0.0.1:{port}/dashboard/",
            "local_api": f"http://127.0.0.1:{port}",
            "lan_urls": lan_urls,
            "lan_api_urls": api_urls,
            "lan_enabled": bind_host in {"0.0.0.0", "::"} or not bind_host.startswith("127."),
            "allowed_origins": sorted(allowed_origins(port)),
            "token_required": bool(os.getenv("BAND10_BRIDGE_TOKEN", "")),
            "timestamp": int(time.time()),
        }

    def _status_payload(self) -> dict:
        return {
            "bridge": {
                "state": "serving",
                "host": self.server.server_address[0],
                "port": self.server.server_address[1],
                "timestamp": int(time.time()),
                "timestamp_local": time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),
                "lan_enabled": self._bridge_info_payload()["lan_enabled"],
            },
            "connection": read_json_artifact("connection_status.json", {}),
            "sync": read_json_artifact("latest_sync_status.json", {}),
            "insights": read_json_artifact("latest_insights.json", {}),
            "last_commands": read_jsonl_tail("bridge_command_results.jsonl", limit=12),
        }

    def do_GET(self):
        parsed = urlparse(self.path)
        path = parsed.path
        query = parse_qs(parsed.query)
        if path == "/api/status":
            self._send_json(self._status_payload())
            return
        if path == "/api/bridge-info":
            self._send_json(self._bridge_info_payload())
            return
        if path == "/api/insights":
            self._send_json(read_json_artifact("latest_insights.json", {}))
            return
        if path == "/api/analysis":
            self._send_json(read_json_artifact("latest_analysis.json", {
                "status": "not_generated",
                "message": "Run POST /api/analysis to generate an on-demand local analysis.",
            }))
            return
        if path == "/api/export":
            include_private = query.get("private", ["0"])[0] == "1"
            if include_private and not self._authorized():
                self._send_json({"error": "unauthorized"}, status=401)
                return
            status = self._status_payload()
            if not include_private:
                status.get("connection", {}).pop("device_mac", None)
                status["last_commands"] = []
            self._send_json({
                "redacted": not include_private,
                "status": status,
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
        if not self._authorized():
            self._send_json({"error": "unauthorized"}, status=401)
            return
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
        if path == "/api/analysis":
            self._send_json(build_analysis(), status=200)
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
    shown_host = "127.0.0.1" if host in {"0.0.0.0", "::"} else host
    url = f"http://{shown_host}:{port}/dashboard/"
    start_dashboard_server(host, port)
    print(f"Dashboard: {url}", flush=True)
    if host in {"0.0.0.0", "::"}:
        for address in local_lan_addresses():
            print(f"LAN Dashboard: http://{address}:{port}/dashboard/", flush=True)
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
