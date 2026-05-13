import asyncio
import json
import logging
import os
import time

from bleak import BleakClient
from bleak.exc import BleakDeviceNotFoundError

import analytics as band_analytics
from connect import (
    DATA_DIR,
    GATT_READ,
    Band,
    append_jsonl_artifact,
    bleak_client_options,
    discover_band_device,
    load_or_create_config,
    local_time_label,
    save_json_artifact,
)


LOG_LEVEL = getattr(logging, os.getenv("BAND10_LOG", "INFO").upper(), logging.INFO)
logging.basicConfig(level=LOG_LEVEL, format="%(asctime)s [%(levelname)s] %(name)s: %(message)s")
logger = logging.getLogger("band10.daemon")

COMMAND_QUEUE = DATA_DIR / "bridge_commands.jsonl"
COMMAND_STATE = DATA_DIR / "bridge_command_state.json"
LOCK_FILE = DATA_DIR / "bridge.lock"


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


def _pid_is_alive(pid: int) -> bool:
    if pid <= 0:
        return False
    try:
        os.kill(pid, 0)
        return True
    except OSError:
        return False


def _acquire_daemon_lock() -> bool:
    DATA_DIR.mkdir(exist_ok=True)
    payload = {
        "pid": os.getpid(),
        "started_at": int(time.time()),
        "started_at_local": local_time_label(int(time.time())),
    }
    while True:
        try:
            fd = os.open(str(LOCK_FILE), os.O_CREAT | os.O_EXCL | os.O_WRONLY)
            with os.fdopen(fd, "w", encoding="utf-8") as handle:
                json.dump(payload, handle)
            return True
        except FileExistsError:
            try:
                owner = json.loads(LOCK_FILE.read_text(encoding="utf-8"))
            except Exception:
                owner = {}
            owner_pid = int(owner.get("pid") or 0)
            if owner_pid and not _pid_is_alive(owner_pid):
                logger.info("Removing stale bridge lock from pid %s", owner_pid)
                try:
                    LOCK_FILE.unlink()
                except FileNotFoundError:
                    pass
                continue
            _status_payload(
                "blocked",
                device_mac=load_or_create_config()["device_mac"],
                reason="another bridge process already owns BLE",
                owner_pid=owner_pid or None,
            )
            logger.error("Another bridge process already owns BLE: %s", owner)
            return False


def _release_daemon_lock():
    try:
        owner = json.loads(LOCK_FILE.read_text(encoding="utf-8"))
    except Exception:
        owner = {}
    if int(owner.get("pid") or 0) == os.getpid():
        try:
            LOCK_FILE.unlink()
        except FileNotFoundError:
            pass


def _success_status_tlv(tlvs: dict | None) -> bool:
    if not tlvs:
        return False
    status = tlvs.get(0x7F)
    return status is None or int.from_bytes(status, "big") == 0x000186A0


def _load_command_state() -> dict:
    try:
        return json.loads(COMMAND_STATE.read_text(encoding="utf-8"))
    except Exception:
        return {"processed_lines": 0}


def _save_command_state(processed_lines: int):
    save_json_artifact("bridge_command_state.json", {"processed_lines": processed_lines})


def _pending_bridge_commands(limit: int = 5) -> tuple[list[tuple[int, dict]], int]:
    if not COMMAND_QUEUE.exists():
        return [], 0
    lines = COMMAND_QUEUE.read_text(encoding="utf-8").splitlines()
    processed = int(_load_command_state().get("processed_lines", 0) or 0)
    if processed > len(lines):
        processed = 0
    pending = []
    for index, line in enumerate(lines[processed:], start=processed + 1):
        if len(pending) >= limit:
            break
        if not line.strip():
            pending.append((index, {"type": "noop", "payload": {}}))
            continue
        try:
            pending.append((index, json.loads(line)))
        except Exception as e:
            pending.append((index, {"type": "invalid", "payload": {"line": line, "error": repr(e)}}))
    return pending, len(lines)


def _command_result(command: dict, state: str, **extra) -> dict:
    now = int(time.time())
    result = {
        "id": command.get("id"),
        "type": command.get("type"),
        "state": state,
        "timestamp": now,
        "timestamp_local": local_time_label(now),
        **extra,
    }
    append_jsonl_artifact("bridge_command_results.jsonl", result)
    return result


async def _safe(label: str, coro, default=None):
    try:
        result = await coro
        logger.info("%s OK", label)
        return result
    except Exception as e:
        logger.warning("%s failed: %r", label, e)
        return default


async def _optional_file_sync(label: str, coro):
    try:
        result = await coro
        logger.info("%s OK", label)
        return result, "ok"
    except RuntimeError as e:
        if "00023281" in str(e):
            logger.info("%s returned no new file; preserving previous artifact", label)
            return None, "preserved"
        logger.warning("%s failed: %r", label, e)
        return None, "failed"
    except Exception as e:
        logger.warning("%s failed: %r", label, e)
        return None, "failed"


async def process_bridge_commands(band: Band) -> list[dict]:
    pending, _total = _pending_bridge_commands()
    if not pending:
        return []
    results = []
    for line_number, command in pending:
        command_type = command.get("type")
        payload = command.get("payload") or {}
        try:
            logger.info("Processing bridge command %s (%s)", command.get("id"), command_type)
            if command_type == "noop":
                result = _command_result(command, "skipped")
            elif command_type == "invalid":
                result = _command_result(command, "failed", error=payload)
            elif command_type == "sync":
                sync_status = await sync_core(
                    band,
                    full=bool(payload.get("full", True)),
                    live_hrv=bool(payload.get("live_hrv", False)),
                )
                result = _command_result(command, "ok", sync=sync_status)
            elif command_type == "weather":
                if not hasattr(band, "send_weather_update"):
                    raise NotImplementedError("Weather push is not implemented in connect.py yet")
                weather_status = await band.send_weather_update(payload)
                result = _command_result(command, "ok", weather=weather_status)
            elif command_type == "watchfaces":
                watchfaces = await band.get_watchface_inventory()
                result = _command_result(command, "ok", watchfaces=watchfaces)
            elif command_type == "watchface_activate":
                watchface_status = await band.activate_watchface(
                    str(payload.get("file_name") or ""),
                    payload.get("version"),
                )
                result = _command_result(command, "ok", watchface=watchface_status)
            elif command_type == "stress":
                if payload.get("calibrate"):
                    duration = float(payload.get("duration", os.getenv("BAND10_LIVE_HRV_SECONDS", "62")))
                    stress_status = await band.calibrate_and_enable_stress(duration=duration)
                else:
                    stress_status = await band.set_automatic_stress(bool(payload.get("enabled", True)))
                result = _command_result(command, "ok", stress=stress_status)
            else:
                result = _command_result(command, "failed", error=f"unknown command type: {command_type}")
        except Exception as e:
            logger.warning("Bridge command %s failed: %r", command.get("id"), e)
            result = _command_result(command, "failed", error=repr(e))
        results.append(result)
        _save_command_state(line_number)
    return results


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
        watchfaces = await _safe("watchface inventory", band.get_watchface_inventory(), default=None)
        if watchfaces is not None:
            status["steps"].append("watchfaces")

        stress_hours = int(os.getenv("BAND10_STRESS_HOURS", "168"))
        stress, stress_state = await _optional_file_sync("stress/RRI file", band.get_recent_stress_preview(hours=stress_hours))
        if stress_state != "failed":
            status["steps"].append("stress_file" if stress_state == "ok" else "stress_file_preserved")

        trusleep_hours = int(os.getenv("BAND10_TRUSLEEP_HOURS", "168"))
        trusleep, trusleep_state = await _optional_file_sync("trusleep file", band.get_recent_trusleep_preview(hours=trusleep_hours))
        if trusleep_state != "failed":
            status["steps"].append("trusleep" if trusleep_state == "ok" else "trusleep_preserved")

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
    scan_timeout = float(os.getenv("BAND10_SCAN_TIMEOUT_SECONDS", "12"))
    _status_payload("scanning", device_mac=cfg["device_mac"], timeout_sec=scan_timeout)
    device = await discover_band_device(cfg, scan_timeout)
    if device is None:
        _status_payload("not_found", device_mac=cfg["device_mac"], timeout_sec=scan_timeout)
        raise BleakDeviceNotFoundError(cfg["device_mac"], "Band was not advertising or visible to Windows Bluetooth")

    async with BleakClient(device, **bleak_client_options()) as client:
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
        keepalive_mode = os.getenv("BAND10_KEEPALIVE_MODE", "battery").strip().lower()
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
                    if keepalive_mode == "connect_status":
                        connect_status = await _safe("connect keepalive", band.get_connect_status(), default=None)
                        keepalive_ok = _success_status_tlv(connect_status)
                        _status_payload(
                            "connected" if keepalive_ok else "degraded",
                            device_mac=cfg["device_mac"],
                            keepalive_mode=keepalive_mode,
                            keepalive_ok=keepalive_ok,
                            keepalive_tlvs={hex(k): v.hex() for k, v in connect_status.items()} if connect_status else None,
                        )
                    else:
                        battery = await _safe("battery keepalive", band.get_battery(), default=-1)
                        keepalive_ok = isinstance(battery, int) and battery >= 0
                        _status_payload(
                            "connected" if keepalive_ok else "degraded",
                            device_mac=cfg["device_mac"],
                            keepalive_mode="battery",
                            keepalive_ok=keepalive_ok,
                            battery=battery,
                        )
                    next_keepalive = time.time() + keepalive_interval

                await process_bridge_commands(band)
                await band._drain_unsolicited_for(5.0)
        finally:
            try:
                await band.client.stop_notify(GATT_READ)
            except Exception:
                pass


async def main():
    if not _acquire_daemon_lock():
        return
    cfg = load_or_create_config()
    backoff = 5
    max_seconds = int(os.getenv("BAND10_DAEMON_MAX_SECONDS", "0"))
    stop_at = time.time() + max_seconds if max_seconds > 0 else None
    try:
        while True:
            if stop_at is not None and time.time() >= stop_at:
                _status_payload(
                    "soak_complete",
                    device_mac=cfg["device_mac"],
                    reason="bounded verification window ended before a stable session",
                )
                return
            try:
                _status_payload("connecting", device_mac=cfg["device_mac"])
                await run_connected_session(cfg)
                if stop_at is not None:
                    return
                _status_payload("disconnected", device_mac=cfg["device_mac"], reason="client session ended")
                backoff = 5
            except asyncio.CancelledError:
                _status_payload("stopped", device_mac=cfg["device_mac"])
                raise
            except Exception as e:
                logger.exception("Daemon session failed")
                state = "not_found" if isinstance(e, BleakDeviceNotFoundError) else "reconnecting"
                _status_payload(state, device_mac=cfg["device_mac"], error=repr(e), retry_in_sec=backoff)
                sleep_for = backoff
                if stop_at is not None:
                    sleep_for = max(0.0, min(float(backoff), stop_at - time.time()))
                    if sleep_for <= 0:
                        continue
                await asyncio.sleep(sleep_for)
                backoff = min(120, backoff * 2)
    finally:
        _release_daemon_lock()


if __name__ == "__main__":
    asyncio.run(main())
