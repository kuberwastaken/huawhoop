import asyncio
import json
import logging
import os
import time

from bleak import BleakClient

import analytics as band_analytics
from connect import (
    DATA_DIR,
    GATT_READ,
    Band,
    append_jsonl_artifact,
    load_or_create_config,
    local_time_label,
    save_json_artifact,
)


LOG_LEVEL = getattr(logging, os.getenv("BAND10_LOG", "INFO").upper(), logging.INFO)
logging.basicConfig(level=LOG_LEVEL, format="%(asctime)s [%(levelname)s] %(name)s: %(message)s")
logger = logging.getLogger("band10.daemon")


def _status_payload(state: str, **extra) -> dict:
    now = int(time.time())
    payload = {
        "state": state,
        "timestamp": now,
        "timestamp_local": local_time_label(now),
        **extra,
    }
    save_json_artifact("connection_status.json", payload)
    append_jsonl_artifact("connection_history.jsonl", payload)
    return payload


async def _safe(label: str, coro, default=None):
    try:
        result = await coro
        logger.info("%s OK", label)
        return result
    except Exception as e:
        logger.warning("%s failed: %r", label, e)
        return default


async def sync_core(band: Band, full: bool = False, live_hrv: bool = False) -> dict:
    started = int(time.time())
    status = {
        "started_at": started,
        "started_at_local": local_time_label(started),
        "full": full,
        "live_hrv": live_hrv,
        "steps": [],
    }

    battery = await _safe("battery", band.get_battery(), default=None)
    status["battery"] = battery

    preview = await _safe("fitness preview", band.get_recent_fitness_preview(hours=24), default=None)
    if preview is not None:
        summary = band.summarize_fitness_preview(preview)
        summary["generated_at"] = int(time.time())
        summary["generated_at_local"] = local_time_label(summary["generated_at"])
        if summary.get("downloaded_step_minutes") or summary.get("downloaded_sleep_segments"):
            save_json_artifact("latest_fitness_preview.json", preview)
            save_json_artifact("latest_recovery_summary.json", summary)
            append_jsonl_artifact("recovery_history.jsonl", summary)
            status["steps"].append("fitness")
        else:
            status["fitness_empty"] = True

    if full:
        stress_hours = int(os.getenv("BAND10_STRESS_HOURS", "168"))
        stress = await _safe("stress/RRI file", band.get_recent_stress_preview(hours=stress_hours), default=None)
        if stress is not None:
            status["steps"].append("stress_file")

        trusleep_hours = int(os.getenv("BAND10_TRUSLEEP_HOURS", "168"))
        trusleep = await _safe("trusleep file", band.get_recent_trusleep_preview(hours=trusleep_hours), default=None)
        if trusleep is not None:
            status["steps"].append("trusleep")

    if live_hrv:
        duration = float(os.getenv("BAND10_LIVE_HRV_SECONDS", "62"))
        live = await _safe("live HRV", band.measure_live_hrv(duration=duration), default=None)
        if live is not None:
            status["steps"].append("live_hrv")

    insights = await _safe("insights", asyncio.to_thread(band_analytics.build_insights, DATA_DIR), default=None)
    if insights is not None:
        status["steps"].append("insights")
        status["insights"] = {
            "recovery_score": insights.get("recovery_score"),
            "strain": (insights.get("strain") or {}).get("strain"),
            "hrv_source": (insights.get("data_quality") or {}).get("hrv_source"),
        }

    ended = int(time.time())
    status["ended_at"] = ended
    status["ended_at_local"] = local_time_label(ended)
    status["duration_sec"] = ended - started
    save_json_artifact("latest_sync_status.json", status)
    return status


async def run_connected_session(cfg: dict):
    async with BleakClient(cfg["device_mac"]) as client:
        band = Band(client=client, cfg=cfg)
        await band.connect()
        await band.handshake()
        await band.post_auth_initialize()
        if os.getenv("BAND10_ENABLE_PASSIVE_SETTINGS", "1") != "0":
            await band.enable_passive_health_settings()

        _status_payload("connected", device_mac=cfg["device_mac"])

        full_every = max(1, int(os.getenv("BAND10_FULL_SYNC_EVERY", "6")))
        sync_interval = max(60, int(os.getenv("BAND10_SYNC_INTERVAL_SECONDS", "300")))
        keepalive_interval = max(15, int(os.getenv("BAND10_KEEPALIVE_SECONDS", "60")))
        live_hrv_every = max(0, int(os.getenv("BAND10_LIVE_HRV_EVERY", "0")))
        initial_full_sync = os.getenv("BAND10_INITIAL_FULL_SYNC", "1") != "0"
        max_seconds = int(os.getenv("BAND10_DAEMON_MAX_SECONDS", "0"))
        stop_at = time.time() + max_seconds if max_seconds > 0 else None
        cycle = 0
        next_sync = 0.0
        next_keepalive = 0.0

        try:
            while client.is_connected:
                if stop_at is not None and time.time() >= stop_at:
                    _status_payload("soak_complete", device_mac=cfg["device_mac"], reason="bounded verification window ended")
                    return
                now = time.time()
                if now >= next_sync:
                    cycle += 1
                    full = (initial_full_sync and cycle == 1) or cycle % full_every == 0
                    live_hrv = live_hrv_every > 0 and (cycle == 1 or cycle % live_hrv_every == 0)
                    sync_status = await sync_core(band, full=full, live_hrv=live_hrv)
                    _status_payload(
                        "connected",
                        device_mac=cfg["device_mac"],
                        last_sync=sync_status,
                    )
                    next_sync = time.time() + sync_interval

                if now >= next_keepalive:
                    connect_status = await _safe("connect keepalive", band.get_connect_status(), default=None)
                    _status_payload(
                        "connected",
                        device_mac=cfg["device_mac"],
                        keepalive_ok=connect_status is not None,
                        keepalive_tlvs={hex(k): v.hex() for k, v in connect_status.items()} if connect_status else None,
                    )
                    next_keepalive = time.time() + keepalive_interval

                await band._drain_unsolicited_for(5.0)
        finally:
            try:
                await band.client.stop_notify(GATT_READ)
            except Exception:
                pass


async def main():
    cfg = load_or_create_config()
    backoff = 5
    while True:
        try:
            _status_payload("connecting", device_mac=cfg["device_mac"])
            await run_connected_session(cfg)
            if int(os.getenv("BAND10_DAEMON_MAX_SECONDS", "0")) > 0:
                return
            _status_payload("disconnected", device_mac=cfg["device_mac"], reason="client session ended")
            backoff = 5
        except asyncio.CancelledError:
            _status_payload("stopped", device_mac=cfg["device_mac"])
            raise
        except Exception as e:
            logger.exception("Daemon session failed")
            _status_payload("reconnecting", device_mac=cfg["device_mac"], error=repr(e), retry_in_sec=backoff)
            await asyncio.sleep(backoff)
            backoff = min(120, backoff * 2)


if __name__ == "__main__":
    asyncio.run(main())
