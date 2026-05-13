import asyncio
import os
import threading
import webbrowser
from functools import partial
from http.server import SimpleHTTPRequestHandler, ThreadingHTTPServer
from pathlib import Path

import band_daemon


ROOT = Path(__file__).resolve().parent


class DashboardHandler(SimpleHTTPRequestHandler):
    def log_message(self, fmt, *args):
        return


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
