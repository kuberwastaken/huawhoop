import json
import math
import statistics
import time
from pathlib import Path


DATA_DIR = Path("data")

STRESS_NORMALIZATION = [
    (19.381044, 9.474176),
    (5.5441837, 1.9308523),
    (184.17795, 54.48858),
    (33.487267, 25.893078),
    (32.97501, 16.267557),
    (677.911, 130.61485),
    (0.43178082, 0.1747625),
    (147.99915, 170.24158),
    (208.32425, 245.64342),
    (37.63596, 19.478745),
]
STRESS_INIT = 3.835272
STRESS_COEFFICIENTS = [
    0.16605523,
    0.24399279,
    0.0,
    0.0,
    -0.07095941,
    -0.20609115,
    0.0,
    -0.14579488,
    -0.09786916,
    0.0,
]


def _read_json(path: Path, fallback):
    try:
        return json.loads(path.read_text(encoding="utf-8"))
    except Exception:
        return fallback


def _read_jsonl(path: Path) -> list[dict]:
    rows = []
    try:
        for line in path.read_text(encoding="utf-8").splitlines():
            if line.strip():
                rows.append(json.loads(line))
    except Exception:
        pass
    return rows


def _valid_summary_row(row: dict) -> bool:
    return bool(
        row.get("downloaded_step_minutes")
        or row.get("downloaded_sleep_segments")
        or row.get("heart_rate_samples")
        or row.get("spo2_samples")
        or row.get("sleep_minutes")
    )


def _write_json(path: Path, payload: dict):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(payload, indent=2, sort_keys=True) + "\n", encoding="utf-8")


def _append_jsonl(path: Path, payload: dict):
    path.parent.mkdir(parents=True, exist_ok=True)
    with path.open("a", encoding="utf-8") as fh:
        fh.write(json.dumps(payload, sort_keys=True) + "\n")


def _mean(values: list[float], default=None):
    return sum(values) / len(values) if values else default


def _clamp(value: float, lo: float, hi: float) -> float:
    return max(lo, min(hi, value))


def _score_label(value: float) -> str:
    if value >= 67:
        return "green"
    if value >= 34:
        return "yellow"
    return "red"


def _score_sigmoid(x: float, k: float, base: float, midpoint: float, anchor: float) -> float:
    max_exp = 709.0
    numerator = 1 + math.exp(min(max_exp, k * (anchor - midpoint)))
    denominator = 1 + math.exp(min(max_exp, k * (x - midpoint)))
    return base * numerator / denominator


def _numeric(value):
    return value if isinstance(value, (int, float)) and math.isfinite(value) else None


def _ewma(values: list[float], tau_days: float) -> float | None:
    alpha = 1.0 - math.exp(-1.0 / max(1.0, tau_days))
    acc = None
    for value in values:
        value = _numeric(value)
        if value is None:
            continue
        acc = value if acc is None else acc + alpha * (value - acc)
    return acc


def _trend_delta(values: list[float], short: int, long: int) -> float | None:
    clean = [_numeric(v) for v in values]
    clean = [v for v in clean if v is not None]
    if len(clean) < 2:
        return None
    recent = _mean(clean[-short:], clean[-1])
    baseline = _mean(clean[-long:], recent)
    if recent is None or baseline is None:
        return None
    return recent - baseline


def _hours_past_noon(ts: int | float | None) -> float | None:
    if not ts:
        return None
    local = time.localtime(ts)
    hours = local.tm_hour + local.tm_min / 60.0 + local.tm_sec / 3600.0
    if hours < 12.0:
        hours += 24.0
    return hours - 12.0


def _sleep_duration_score(minutes: float) -> int:
    hours = max(0.0, minutes / 60.0)
    if 7.0 <= hours <= 9.0:
        return 100
    if hours < 7.0:
        raw = _score_sigmoid(hours, k=-1.5, base=100, midpoint=5.0, anchor=7.0)
        return round(_clamp(raw, 0, 100))
    raw = _score_sigmoid(hours, k=0.8, base=100, midpoint=11.0, anchor=9.0)
    return round(_clamp(max(50, raw), 0, 100))


def _sleep_consistency_score(history: list[dict], sleep_segments: list[dict]) -> int | None:
    starts = [
        _hours_past_noon(row.get("sleep_window_start_ts"))
        for row in history
        if row.get("sleep_window_start_ts")
    ]
    starts = [v for v in starts if v is not None]
    distinct_starts = []
    for start in starts:
        if not any(abs(start - seen) < (5 / 60.0) for seen in distinct_starts):
            distinct_starts.append(start)
    current_start = min((row.get("start") for row in sleep_segments if row.get("start")), default=None)
    current = _hours_past_noon(current_start)
    if current is None or len(distinct_starts) < 3:
        return None
    baseline = statistics.median(distinct_starts[-14:])
    diff_minutes = (current - baseline) * 60
    if diff_minutes > 15:
        penalty = ((diff_minutes - 15) / 105) * 100
    elif diff_minutes < -15:
        penalty = min(20, ((abs(diff_minutes) - 15) / 105) * 100)
    else:
        penalty = 0
    return round(_clamp(100 - penalty, 0, 100))


def _sleep_fragmentation_score(sleep_segments: list[dict], sleep_minutes: float) -> int:
    if sleep_minutes <= 0:
        return 0
    starts = sorted(
        (row.get("start"), row.get("end"))
        for row in sleep_segments
        if row.get("start") and row.get("end") and row.get("end") > row.get("start")
    )
    if len(starts) <= 1:
        return 100
    significant_gaps = 0
    gap_minutes = 0.0
    for (_prev_start, prev_end), (start, _end) in zip(starts, starts[1:]):
        gap = max(0, start - prev_end) / 60.0
        if gap >= 5:
            significant_gaps += 1
            gap_minutes += gap
    gap_penalty = min(80, max(0, gap_minutes - 20) / 70 * 80)
    frequency_penalty = min(20, max(0, significant_gaps - 1) * 5)
    return round(_clamp(100 - gap_penalty - frequency_penalty, 0, 100))


def _sleep_stage_score(deep_minutes: float, rem_minutes: float) -> int | None:
    if deep_minutes <= 0 and rem_minutes <= 0:
        return None
    deep_score = _clamp(100 * deep_minutes / 90.0, 0, 100)
    rem_score = _clamp(100 * rem_minutes / 90.0, 0, 100)
    return round(0.5 * deep_score + 0.5 * rem_score)


def _sleep_interruptions_score(awake_minutes: float, awakening_durations: list[float]) -> int:
    duration_score = 80.0
    if awake_minutes > 20:
        duration_score = max(0, 80.0 - ((awake_minutes - 20) / 70.0) * 80.0)
    significant = sum(1 for duration in awakening_durations if duration > 5)
    frequency_fractions = (1.0, 1.0, 0.75, 0.5, 0.0)
    frequency_score = 20.0 * frequency_fractions[min(significant, len(frequency_fractions) - 1)]
    return round(_clamp(duration_score + frequency_score, 0, 100))


def _sleep_stage_breakdown(details: dict) -> dict:
    # Gadgetbridge maps Huawei sequence stages as:
    # 1 light, 2 REM, 3 deep, 4 awake, 5 nap/light.
    counts = {int(k): int(v) for k, v in (details.get("stage_counts") or {}).items()}
    stages = sorted(details.get("stages") or [], key=lambda row: row.get("timestamp") or 0)
    if stages and not counts:
        counts = {}
        for row in stages:
            stage = int(row.get("stage", 0) or 0)
            counts[stage] = counts.get(stage, 0) + 1

    awakening_durations = []
    current_awake = 0
    for row in stages:
        stage = int(row.get("stage", 0) or 0)
        if stage == 4:
            current_awake += 1
        elif current_awake:
            awakening_durations.append(current_awake)
            current_awake = 0
    if current_awake:
        awakening_durations.append(current_awake)

    return {
        "light_minutes": counts.get(1, 0) + counts.get(5, 0),
        "rem_minutes": counts.get(2, 0),
        "deep_minutes": counts.get(3, 0),
        "awake_minutes": counts.get(4, 0),
        "nap_minutes": counts.get(5, 0),
        "awakening_durations": awakening_durations,
        "raw_counts": {str(k): v for k, v in sorted(counts.items())},
    }


def _sleep_quality_model(sleep_minutes: float, sleep_segments: list[dict], history: list[dict],
                         stage_breakdown: dict | None = None) -> dict:
    duration = _sleep_duration_score(sleep_minutes)
    fragmentation = _sleep_fragmentation_score(sleep_segments, sleep_minutes)
    consistency = _sleep_consistency_score(history, sleep_segments)
    stages = None
    interruptions = fragmentation
    if stage_breakdown:
        stages = _sleep_stage_score(stage_breakdown.get("deep_minutes", 0), stage_breakdown.get("rem_minutes", 0))
        interruptions = _sleep_interruptions_score(
            stage_breakdown.get("awake_minutes", 0),
            stage_breakdown.get("awakening_durations") or [],
        )

    weighted = [("duration", duration, 0.40), ("interruptions", interruptions, 0.20)]
    if stages is not None:
        weighted.append(("stages", stages, 0.20))
    else:
        weighted[0] = ("duration", duration, 0.55)
        weighted[1] = ("interruptions", interruptions, 0.25)
    if consistency is not None:
        weighted.append(("consistency", consistency, 0.20))
    else:
        weighted = [(name, value, weight / 0.80) for name, value, weight in weighted]
    overall = sum(value * weight for _name, value, weight in weighted) / sum(weight for _name, _value, weight in weighted)
    return {
        "score": round(_clamp(overall, 0, 100)),
        "duration": duration,
        "stages": stages,
        "consistency": consistency,
        "interruptions": interruptions,
        "fragmentation": fragmentation,
        "stage_breakdown": stage_breakdown or {},
        "method": "Open Wearables-inspired duration + deep/REM stages + consistency + awake interruptions",
    }


def _classify_training_load(acute: float | None, chronic: float | None) -> dict:
    if acute is None or chronic is None or chronic <= 0:
        return {
            "label": "collecting",
            "recommendation": "Collect more connected syncs before judging load balance.",
            "ratio": None,
            "balance": None,
        }

    ratio = acute / chronic
    balance = chronic - acute
    if ratio < 0.70:
        label = "underloaded"
        recommendation = "Load is below recent baseline; good window for easy volume if recovery allows."
    elif ratio <= 1.30:
        label = "productive"
        recommendation = "Acute load is close to chronic load; maintain or progress gradually."
    elif ratio <= 1.55:
        label = "strained"
        recommendation = "Acute load is elevated; bias toward sleep and lower intensity."
    else:
        label = "overreaching"
        recommendation = "Acute load is far above baseline; treat this as a recovery-priority day."
    return {
        "label": label,
        "recommendation": recommendation,
        "ratio": round(ratio, 2),
        "balance": round(balance, 1),
    }


def _stress_zone_summary(stress_preview: dict, live_hrv: dict | None = None) -> dict:
    rows = stress_preview.get("stress") or []
    zone_minutes = {"low": 0.0, "medium": 0.0, "high": 0.0}
    high_windows = []
    scores = []
    latest = None

    for row in rows:
        score = _numeric(row.get("score"))
        if score is None or score <= 0:
            continue
        start_ms = _numeric(row.get("start_ms"))
        end_ms = _numeric(row.get("end_ms"))
        minutes = 1.0
        if start_ms and end_ms and end_ms > start_ms:
            minutes = _clamp((end_ms - start_ms) / 60000.0, 1.0, 60.0)

        if score <= 29:
            zone = "low"
        elif score <= 59:
            zone = "medium"
        else:
            zone = "high"
        zone_minutes[zone] += minutes
        scores.append(score)
        latest = row
        if zone == "high":
            high_windows.append({
                "start_local": row.get("start_local"),
                "end_local": row.get("end_local"),
                "minutes": round(minutes),
                "score": round(score),
                "level": row.get("level"),
            })

    live_stress = (live_hrv or {}).get("huawei_stress") or {}
    if not rows and live_stress.get("status") == "ok" and live_stress.get("stress_score"):
        score = _numeric(live_stress.get("stress_score"))
        if score:
            scores.append(score)
            zone = "low" if score <= 29 else "medium" if score <= 59 else "high"
            zone_minutes[zone] = 1.0
            latest = {
                "score": score,
                "level": live_stress.get("stress_level"),
                "source": "live_rri",
            }

    total = sum(zone_minutes.values())
    avg_score = _mean(scores)
    if avg_score is None:
        return {
            "source": "unavailable",
            "sample_count": 0,
            "zone_minutes": {name: 0 for name in zone_minutes},
            "message": "Stress zones need an RRI/stress sync or a live 60-second RRI measurement.",
            "method": "Huawei RRI/stress file parser with score buckets: low <=29, medium <=59, high >=60",
        }

    low_pct = round(100 * zone_minutes["low"] / total) if total else 0
    high_pct = round(100 * zone_minutes["high"] / total) if total else 0
    label = "low" if avg_score <= 29 else "medium" if avg_score <= 59 else "high"
    return {
        "source": "rri_stress_file" if rows else "live_rri",
        "sample_count": len(scores),
        "avg_score": round(avg_score, 1),
        "max_score": round(max(scores), 1),
        "latest_score": latest.get("score") if latest else None,
        "latest_level": latest.get("level") if latest else None,
        "label": label,
        "gauge_0_3": round(_clamp(avg_score / 30.0, 0, 3), 1),
        "zone_minutes": {name: round(value) for name, value in zone_minutes.items()},
        "low_pct": low_pct,
        "high_pct": high_pct,
        "high_windows": high_windows[-5:],
        "message": (
            f"{low_pct}% of tracked stress time was low stress; "
            f"high stress accounted for {high_pct}%."
        ),
        "method": "Huawei RRI/stress file parser with score buckets: low <=29, medium <=59, high >=60",
    }


def _summarize_live_hrv_transport(live_hrv: dict) -> dict:
    events = live_hrv.get("transport_events") or []
    status_events = [event for event in events if isinstance(event.get("status"), int)]
    latest = status_events[-1] if status_events else None
    open_ok = any(
        event.get("cmd") == 1 and event.get("status") == 100000
        for event in status_events
    )
    data_statuses = [
        event.get("status")
        for event in status_events
        if event.get("cmd") in (3, 5) and isinstance(event.get("status"), int)
    ]
    blocked = 126008 in data_statuses
    sample_count = live_hrv.get("sample_count", 0)
    realtime_hr_sample_count = live_hrv.get("realtime_hr_sample_count", 0)
    if sample_count:
        state = "streaming"
    elif realtime_hr_sample_count:
        state = "hr_only_stream"
    elif blocked:
        state = "opened_no_stream"
    elif open_ok:
        state = "opened_waiting"
    elif latest:
        state = "rejected"
    else:
        state = "not_run"
    return {
        "state": state,
        "sample_count": sample_count,
        "realtime_hr_sample_count": realtime_hr_sample_count,
        "request": live_hrv.get("request") or {},
        "latest_status": latest.get("status") if latest else None,
        "latest_status_hex": f"0x{latest.get('status'):08x}" if latest else None,
        "open_ok": open_ok,
        "data_blocked_status_hex": "0x0001ec38" if blocked else None,
        "event_count": len(events),
    }


def _clean_rri_values(rri_ms: list[int]) -> list[int]:
    values = [int(v) for v in rri_ms if 400 < int(v) < 1400]
    if len(values) < 2:
        return values

    avg = _mean(values, 0)
    values = [v for v in values if avg * 0.8 <= v <= avg * 1.2]
    if len(values) < 2:
        return values

    cleaned = [values[0]]
    previous = values[0]
    for value in values[1:]:
        if previous * 0.8 < value < previous * 1.2:
            cleaned.append(value)
            previous = value
    return cleaned


def hrv_time_domain(rri_ms: list[int]) -> dict:
    cleaned = _clean_rri_values(rri_ms)
    if len(cleaned) < 2:
        return {
            "status": "insufficient_rri",
            "input_count": len(rri_ms),
            "clean_count": len(cleaned),
        }

    diffs = [cleaned[i] - cleaned[i - 1] for i in range(1, len(cleaned))]
    abs_diffs = [abs(d) for d in diffs]
    rmssd = math.sqrt(sum(d * d for d in diffs) / len(diffs))
    sdnn = statistics.pstdev(cleaned) if len(cleaned) > 1 else 0.0
    pnn50 = 100.0 * sum(1 for d in abs_diffs if d > 50) / len(diffs)
    mean_nni = _mean(cleaned, 0.0)
    return {
        "status": "ok",
        "input_count": len(rri_ms),
        "clean_count": len(cleaned),
        "mean_nni_ms": round(mean_nni, 1),
        "median_nni_ms": round(statistics.median(cleaned), 1),
        "mean_hr_bpm": round(60000.0 / mean_nni, 1) if mean_nni else None,
        "rmssd_ms": round(rmssd, 1),
        "sdnn_ms": round(sdnn, 1),
        "pnn50_pct": round(pnn50, 1),
        "min_nni_ms": min(cleaned),
        "max_nni_ms": max(cleaned),
    }


def _huawei_time_features(rri_ms: list[int]) -> dict | None:
    cleaned = _clean_rri_values(rri_ms)
    if len(cleaned) < 30:
        return None

    rri_min = min(cleaned)
    rri_max = max(cleaned)
    mean_hr = _mean([60000.0 / v for v in cleaned], 0.0)
    sd_hr = statistics.pstdev([60000.0 / v for v in cleaned]) if len(cleaned) > 1 else 0.0
    diffs = [cleaned[i] - cleaned[i - 1] for i in range(1, len(cleaned))]
    if not diffs:
        return None

    rmssd = math.sqrt(sum(d * d for d in diffs) / len(diffs))
    rri_50_count = sum(1 for d in diffs if abs(d) > 50)
    pnn50 = 100.0 * rri_50_count / len(diffs)
    sdnn = statistics.pstdev(cleaned) if len(cleaned) > 1 else 0.0
    diff_mean = _mean(diffs, 0.0)
    diff_sd = math.sqrt(sum((d - diff_mean) ** 2 for d in diffs) / len(diffs))
    var_sum = diff_sd / math.sqrt(2)
    var_diff = (sdnn * sdnn * 2) - (var_sum * var_sum)
    if var_diff <= 0:
        return None
    norm_var = var_sum / math.sqrt(var_diff)

    low_bin = (rri_min // 20) * 20
    high_bin = (rri_max // 20) * 20
    categories = {}
    for value in cleaned:
        bucket = ((value - low_bin) // 20) * 20 + low_bin
        categories[bucket] = categories.get(bucket, 0) + 1
    if not categories or len(categories) >= 50:
        return None
    max_count = max(categories.values())
    modal_bins = [bucket for bucket, count in categories.items() if count == max_count]
    median_nni = int(round(_mean(modal_bins, low_bin) / 20.0) * 20)

    return {
        "cleaned": cleaned,
        "median_nni_count": max_count,
        "sd_hr": sd_hr,
        "range_nni": high_bin - low_bin,
        "rmssd": rmssd,
        "median_nni": median_nni,
        "norm_var": norm_var,
        "mean_hr": mean_hr,
        "pnn50": pnn50,
        "sdnn": sdnn,
    }


def _resample_rri_2hz(rri_ms: list[int]) -> list[float]:
    if len(rri_ms) < 4:
        return []
    cumulative = []
    total = 0.0
    for value in rri_ms:
        total += value / 1000.0
        cumulative.append(total)
    if total < 8:
        return []

    samples = []
    target = 0.0
    idx = 0
    while target <= cumulative[-1] and len(samples) < 130:
        while idx < len(cumulative) - 1 and cumulative[idx] < target:
            idx += 1
        if idx == 0:
            samples.append(float(rri_ms[0]))
        else:
            prev_t = cumulative[idx - 1]
            curr_t = cumulative[idx]
            prev_v = float(rri_ms[idx - 1])
            curr_v = float(rri_ms[idx])
            frac = 0.0 if curr_t == prev_t else (target - prev_t) / (curr_t - prev_t)
            samples.append(prev_v + (curr_v - prev_v) * frac)
        target += 0.5
    return samples


def _frequency_features(rri_ms: list[int]) -> dict | None:
    samples = _resample_rri_2hz(rri_ms)
    n = len(samples)
    if n < 32:
        return None

    mean = _mean(samples, 0.0)
    detrended = [v - mean for v in samples]
    windowed = []
    for i, value in enumerate(detrended):
        win = 0.5 - 0.5 * math.cos((2 * math.pi * i) / max(1, n - 1))
        windowed.append(value * win)

    sample_rate = 2.0
    freq_step = sample_rate / n
    powers = []
    for k in range(n // 2 + 1):
        real = 0.0
        imag = 0.0
        for j, value in enumerate(windowed):
            angle = 2 * math.pi * k * j / n
            real += value * math.cos(angle)
            imag -= value * math.sin(angle)
        powers.append((real * real + imag * imag) / n)

    vlf = lf = hf = 0.0
    for k, power in enumerate(powers):
        freq = k * freq_step
        if 0 <= freq < 0.04:
            vlf += freq_step * power
        elif 0.04 <= freq < 0.15:
            lf += freq_step * power
        elif 0.15 <= freq <= 0.4:
            hf += freq_step * power
    total = vlf + lf + hf
    if total <= 0 or hf <= 0:
        return None
    return {
        "vlf_psd": vlf,
        "lf_psd": lf,
        "hf_psd": hf,
        "lf_hf_vlf_total_psd": total,
    }


def huawei_stress_features(rri_samples: list[dict], signal_time_sec: int | None = None) -> dict:
    if signal_time_sec is None and rri_samples:
        first = rri_samples[0].get("timestamp_ms")
        last = rri_samples[-1].get("timestamp_ms")
        if first and last and last > first:
            signal_time_sec = max(1, round((last - first) / 1000))
    signal_time_sec = signal_time_sec or 60

    if not (50 < signal_time_sec < 70):
        return {"status": "invalid_signal_time", "signal_time_sec": signal_time_sec}

    huawei_valid = [
        int(row["rri_ms"])
        for row in rri_samples
        if row.get("rri_ms") and int(row.get("sqi", 0)) == 100
    ]
    if len(huawei_valid) < 30:
        return {
            "status": "insufficient_sqi_100",
            "signal_time_sec": signal_time_sec,
            "sqi_100_count": len(huawei_valid),
        }
    if sum(huawei_valid) > 65000:
        return {"status": "window_too_long", "signal_time_sec": signal_time_sec}

    time_features = _huawei_time_features(huawei_valid)
    freq_features = _frequency_features(time_features["cleaned"] if time_features else [])
    if not time_features or not freq_features:
        return {"status": "feature_calc_failed", "sqi_100_count": len(huawei_valid)}

    p_vlf = 100.0 * freq_features["vlf_psd"] / freq_features["lf_hf_vlf_total_psd"]
    p_lf = 100.0 * freq_features["lf_psd"] / freq_features["lf_hf_vlf_total_psd"]
    features = [
        time_features["median_nni_count"],
        time_features["sd_hr"],
        time_features["range_nni"],
        p_vlf,
        time_features["rmssd"],
        time_features["median_nni"],
        time_features["norm_var"],
        freq_features["hf_psd"],
        freq_features["lf_psd"],
        p_lf,
    ]
    score_factor = huawei_stress_score_factor(features)
    score = huawei_stress_final_score(score_factor)
    return {
        "status": "ok",
        "signal_time_sec": signal_time_sec,
        "sqi_100_count": len(huawei_valid),
        "features": [round(v, 6) for v in features],
        "stress_score_factor": round(score_factor, 4),
        "stress_score": score,
        "stress_level": huawei_stress_level(score),
    }


def huawei_stress_score_factor(features: list[float]) -> float:
    score = STRESS_INIT
    for idx, coeff in enumerate(STRESS_COEFFICIENTS):
        mean, std = STRESS_NORMALIZATION[idx]
        normalized = (features[idx] - mean) / std
        score += normalized * coeff
    return _clamp(score, 0.0, 7.0)


def huawei_stress_final_score(score_factor: float) -> int:
    score = int((_clamp(score_factor, 0.0, 7.0) * 14.0) + 1.5)
    return int(_clamp(score, 15, 90))


def huawei_stress_level(score: int) -> int:
    if score <= 29:
        return 1
    if score <= 59:
        return 2
    if score <= 79:
        return 3
    return 4


def analyze_rri_samples(samples: list[dict], signal_time_sec: int | None = None) -> dict:
    rri_values = [int(row["rri_ms"]) for row in samples if row.get("rri_ms")]
    time_domain = hrv_time_domain(rri_values)
    stress = huawei_stress_features(samples, signal_time_sec=signal_time_sec)
    return {
        "source": "live_rri",
        "generated_at": int(time.time()),
        "sample_count": len(samples),
        "time_domain": time_domain,
        "huawei_stress": stress,
        "samples_preview": samples[:20],
    }


def _history_baseline(rows: list[dict], key: str, default=None):
    values = [row.get(key) for row in rows[-30:] if isinstance(row.get(key), (int, float))]
    return statistics.median(values) if values else default


def _minute_weight(prev_ts: int | None, ts: int | None) -> float:
    if not prev_ts or not ts or ts <= prev_ts:
        return 1.0
    return _clamp((ts - prev_ts) / 60.0, 0.5, 5.0)


def _strain_from_activity(samples: list[dict]) -> dict:
    heart_rates = [
        row.get("heart_rate")
        for row in samples
        if isinstance(row.get("heart_rate"), (int, float)) and row.get("heart_rate") > 0
    ]
    if not heart_rates:
        return {"strain": None, "trimp": 0.0, "zone_minutes": {}}
    sorted_hr = sorted(heart_rates)
    resting = max(45, min(80, sorted_hr[max(0, round(len(sorted_hr) * 0.10) - 1)]))
    max_hr = max(185, min(205, max(heart_rates) + 45))
    zones = {"easy": 0, "moderate": 0, "hard": 0, "max": 0}
    trimp = 0.0
    active_minutes = 0.0
    vigorous_minutes = 0.0
    step_total = 0
    prev_ts = None
    for row in samples:
        hr = row.get("heart_rate")
        ts = row.get("timestamp")
        minutes = _minute_weight(prev_ts, ts if isinstance(ts, int) else None)
        if isinstance(ts, int):
            prev_ts = ts
        steps = row.get("steps")
        if isinstance(steps, (int, float)) and steps > 0:
            step_total += int(steps)
        if not isinstance(hr, (int, float)) or hr <= 0:
            continue
        reserve = _clamp((hr - resting) / max(1, max_hr - resting), 0, 1)
        trimp += reserve * math.exp(1.92 * reserve) * minutes
        if reserve >= 0.35 or (isinstance(steps, (int, float)) and steps > 0):
            active_minutes += minutes
        if reserve >= 0.60:
            vigorous_minutes += minutes
        if reserve < 0.35:
            zones["easy"] += minutes
        elif reserve < 0.55:
            zones["moderate"] += minutes
        elif reserve < 0.75:
            zones["hard"] += minutes
        else:
            zones["max"] += minutes
    activity_load = min(45.0, active_minutes * 0.20 + vigorous_minutes * 0.85 + (step_total / 1000.0) * 3.5)
    combined_load = trimp + activity_load
    strain = 21.0 * (1.0 - math.exp(-combined_load / 190.0))
    return {
        "strain": round(_clamp(strain, 0, 21), 1),
        "trimp": round(trimp, 1),
        "activity_load": round(activity_load, 1),
        "combined_load": round(combined_load, 1),
        "active_minutes": round(active_minutes),
        "vigorous_minutes": round(vigorous_minutes),
        "step_total": step_total,
        "zone_minutes": {name: round(value) for name, value in zones.items()},
        "method": "Banister-style HRR/TRIMP plus conservative active-minute and step load on WHOOP-like 0-21 logarithmic scale",
    }


def _sleep_hrv_series(sequence: dict) -> list[dict]:
    sessions = sequence.get("sessions") or []
    values = []
    for session in sessions:
        summary = session.get("summary") or {}
        avg = summary.get("avgHrv")
        if isinstance(avg, (int, float)) and avg > 0:
            values.append({
                "avg_hrv_ms": avg,
                "hrv_day_to_baseline": summary.get("hrvDayToBaseline"),
                "min_baseline": summary.get("minHrvBaseline"),
                "max_baseline": summary.get("maxHrvBaseline"),
                "session_start": session.get("start_ts"),
                "session_end": session.get("end_ts"),
            })
    return values


def _extract_sleep_hrv(sequence: dict) -> dict | None:
    values = _sleep_hrv_series(sequence)
    if not values:
        return None
    latest = values[-1]
    latest["source"] = "sleep_sequence"
    latest["sample_count"] = len(values)
    return latest


def _sequence_metric(summary: dict, key: str, lo: float = 0, hi: float | None = None):
    value = _numeric(summary.get(key))
    if value is None or value == 0xFFFFFFFF or value < lo:
        return None
    if hi is not None and value > hi:
        return None
    return value


def _sequence_sleep_minutes(session: dict, summary: dict) -> int:
    start = _sequence_metric(summary, "fallAsleepTime", 1) or _numeric(session.get("start_ts"))
    end = _sequence_metric(summary, "wakeupTime", 1) or _numeric(session.get("end_ts"))
    if start and end and end > start:
        return round((end - start) / 60)
    return 0


def _sleep_sequence_sessions(sequence: dict) -> list[dict]:
    sessions = []
    for session in sequence.get("sessions") or []:
        summary = session.get("summary") or {}
        minutes = _sequence_sleep_minutes(session, summary)
        score = _sequence_metric(summary, "sleepScore", 1, 100)
        avg_hrv = _sequence_metric(summary, "avgHrv", 1, 300)
        valid_data = summary.get("validData")
        if minutes < 90 or (score is None and avg_hrv is None and valid_data is None):
            continue
        details = session.get("details") or {}
        stage_breakdown = _sleep_stage_breakdown(details)
        sessions.append({
            "start_ts": _sequence_metric(summary, "fallAsleepTime", 1) or session.get("start_ts"),
            "end_ts": _sequence_metric(summary, "wakeupTime", 1) or session.get("end_ts"),
            "start_local": session.get("start_local"),
            "end_local": session.get("end_local"),
            "sleep_minutes": minutes,
            "device_score": score,
            "avg_hrv_ms": avg_hrv,
            "avg_heart_rate": _sequence_metric(summary, "avgHeartRate", 30, 220),
            "avg_spo2": _sequence_metric(summary, "avgOxygenSaturation", 50, 100),
            "avg_breath_rate": _sequence_metric(summary, "avgBreathRate", 5, 40),
            "sleep_efficiency": _sequence_metric(summary, "sleepEfficiency", 1, 100),
            "sleep_latency_min": _sequence_metric(summary, "sleepLatency", 0, 240),
            "stage_counts": details.get("stage_counts") or {},
            "stage_breakdown": stage_breakdown,
            "stage_minutes": details.get("stage_minute_count"),
        })
    return sessions


def _extract_sleep_sequence_sleep(sequence: dict) -> dict | None:
    sessions = _sleep_sequence_sessions(sequence)
    if not sessions:
        return None
    latest = sessions[-1]
    latest["source"] = "sleep_sequence"
    latest["session_count"] = len(sessions)
    latest["recent_sleep_minutes"] = [row.get("sleep_minutes") for row in sessions[-14:] if row.get("sleep_minutes")]
    if latest["recent_sleep_minutes"]:
        latest["baseline_minutes"] = round(statistics.median(latest["recent_sleep_minutes"]))
    return latest


def _hrv_resilience_model(hrv_values: list[float]) -> dict:
    values = [_numeric(value) for value in hrv_values]
    values = [value for value in values if value and value > 0]
    if len(values) < 2:
        return {
            "status": "collecting",
            "score": None,
            "cv_pct": None,
            "sample_count": len(values),
            "method": "Open Wearables-style HRV coefficient of variation over recent sleep HRV",
        }
    recent = values[-7:]
    mean_hrv = _mean(recent, 0)
    cv_pct = 100.0 * (statistics.stdev(recent) / mean_hrv) if len(recent) >= 2 and mean_hrv else None
    score = None
    if cv_pct is not None:
        # Open Wearables resilience maps low HRV-CV to higher resilience:
        # 7% or lower is ideal; 40% or higher is poor.
        score = _clamp(100.0 * (40.0 - cv_pct) / (40.0 - 7.0), 0, 100)
    if len(recent) < 5:
        status = "provisional"
    elif score is not None and score >= 75:
        status = "stable"
    elif score is not None and score >= 45:
        status = "variable"
    else:
        status = "unstable"
    return {
        "status": status,
        "score": round(score) if score is not None else None,
        "cv_pct": round(cv_pct, 1) if cv_pct is not None else None,
        "mean_hrv_ms": round(mean_hrv, 1) if mean_hrv else None,
        "sample_count": len(recent),
        "method": "Open Wearables-style HRV coefficient of variation over recent sleep HRV",
    }


def _spo2_low_duration(values: list[float]) -> dict:
    clean = [float(value) for value in values if isinstance(value, (int, float)) and value > 0]
    if not clean:
        return {
            "status": "unavailable",
            "sample_count": 0,
            "method": "Minute-level SpO2 threshold summary from Huawei fitness history samples",
        }
    low_95 = sum(1 for value in clean if value < 95)
    low_92 = sum(1 for value in clean if value < 92)
    return {
        "status": "ok",
        "sample_count": len(clean),
        "avg_pct": round(_mean(clean, 0), 1),
        "min_pct": round(min(clean), 1),
        "minutes_below_95": low_95,
        "minutes_below_92": low_92,
        "percent_below_95": round(100 * low_95 / len(clean)),
        "percent_below_92": round(100 * low_92 / len(clean)),
        "method": "Minute-level SpO2 threshold summary from Huawei fitness history samples",
    }


def build_insights(data_dir: Path = DATA_DIR) -> dict:
    fitness = _read_json(data_dir / "latest_fitness_preview.json", {})
    summary = _read_json(data_dir / "latest_recovery_summary.json", {})
    sequence = _read_json(data_dir / "latest_sleep_sequence_preview.json", {})
    stress = _read_json(data_dir / "latest_stress_preview.json", {})
    live_hrv = _read_json(data_dir / "latest_live_hrv.json", {})
    history = [row for row in _read_jsonl(data_dir / "recovery_history.jsonl") if _valid_summary_row(row)]
    sequence_sleep = _extract_sleep_sequence_sleep(sequence)

    steps = fitness.get("steps") or []
    heart_rates = [row.get("heart_rate") for row in steps if isinstance(row.get("heart_rate"), (int, float)) and row.get("heart_rate") > 0]
    resting_hrs = [row.get("resting_heart_rate") for row in steps if isinstance(row.get("resting_heart_rate"), (int, float)) and row.get("resting_heart_rate") > 0]
    spo2 = [row.get("spo2") for row in steps if isinstance(row.get("spo2"), (int, float)) and row.get("spo2") > 0]
    if not spo2 and sequence_sleep and sequence_sleep.get("avg_spo2"):
        spo2 = [sequence_sleep["avg_spo2"]]
    sleep_minutes = (sequence_sleep or {}).get("sleep_minutes") or summary.get("sleep_minutes") or 0

    strain = _strain_from_activity(steps)
    stress_summary = _stress_zone_summary(stress, live_hrv)
    sequence_avg_hr = (sequence_sleep or {}).get("avg_heart_rate")
    rhr = _mean(resting_hrs, sequence_avg_hr or (min(heart_rates) if heart_rates else None))
    rhr_baseline = _history_baseline(history, "resting_hr_avg", rhr or 60)
    sleep_baseline = (sequence_sleep or {}).get("baseline_minutes") or _history_baseline(history, "sleep_minutes", 480)

    hrv = None
    live_td = live_hrv.get("time_domain") or {}
    if live_td.get("status") == "ok":
        hrv = {
            "source": "live_rri",
            "rmssd_ms": live_td.get("rmssd_ms"),
            "sdnn_ms": live_td.get("sdnn_ms"),
            "pnn50_pct": live_td.get("pnn50_pct"),
            "sample_count": live_hrv.get("sample_count", 0),
        }
    else:
        hrv = _extract_sleep_hrv(sequence)

    insights_history = _read_jsonl(data_dir / "insights_history.jsonl")
    hrv_baseline = _history_baseline(insights_history, "hrv_rmssd_ms", None)
    hrv_score = None
    hrv_value = None
    if hrv:
        hrv_value = hrv.get("rmssd_ms") or hrv.get("avg_hrv_ms")
        if hrv_value:
            if hrv_baseline:
                hrv_score = _clamp(50 + 65 * math.log(max(1, hrv_value) / max(1, hrv_baseline)), 0, 100)
            else:
                hrv_score = _clamp(1.35 * hrv_value, 0, 100)
    sleep_hrv_values = [row.get("avg_hrv_ms") for row in _sleep_hrv_series(sequence)]
    if not sleep_hrv_values and hrv_value:
        sleep_hrv_values = [row.get("hrv_rmssd_ms") for row in insights_history] + [hrv_value]
    resilience = _hrv_resilience_model(sleep_hrv_values)

    rhr_score = None
    if rhr is not None:
        rhr_score = _clamp(70 + ((rhr_baseline or rhr) - rhr) * 4.0, 0, 100)

    current_strain = _numeric(strain.get("strain")) or _numeric(summary.get("strain_score")) or 0
    strain_values = [
        row.get("strain_score")
        for row in history
        if isinstance(row.get("strain_score"), (int, float))
    ]
    if current_strain is not None:
        strain_values.append(current_strain)
    acute = _ewma(strain_values[-60:], 7)
    chronic = _ewma(strain_values[-120:], 42)
    load_model = _classify_training_load(acute, chronic)
    recent_strain = [_numeric(v) for v in strain_values[-7:]]
    recent_strain = [v for v in recent_strain if v is not None]
    monotony = None
    if len(recent_strain) >= 3:
        mean_recent = _mean(recent_strain, 0)
        sd_recent = statistics.pstdev(recent_strain) or 1
        monotony = mean_recent / sd_recent

    sleep_values = [
        row.get("sleep_minutes")
        for row in history
        if isinstance(row.get("sleep_minutes"), (int, float))
    ]
    if sleep_minutes:
        sleep_values.append(sleep_minutes)
    sleep_trend = _trend_delta(sleep_values, 3, 14)
    rhr_values = [
        row.get("resting_hr_avg")
        for row in history
        if isinstance(row.get("resting_hr_avg"), (int, float))
    ]
    if rhr is not None:
        rhr_values.append(rhr)
    rhr_trend = _trend_delta(rhr_values, 3, 14)

    load_ratio = load_model.get("ratio")
    load_sleep_add = max(0, (current_strain or 0) - 10) * 7
    if isinstance(load_ratio, (int, float)) and load_ratio > 1.25:
        load_sleep_add += (load_ratio - 1.25) * 45
    sleep_need = _clamp(480 + load_sleep_add, 420, 630)
    sleep_performance = _clamp(100 * sleep_minutes / sleep_need, 0, 100)
    sleep_segments = fitness.get("sleep") or []
    if not sleep_segments and sequence_sleep and sequence_sleep.get("start_ts") and sequence_sleep.get("end_ts"):
        sleep_segments = [{"start": sequence_sleep["start_ts"], "end": sequence_sleep["end_ts"]}]
    sleep_model = _sleep_quality_model(
        sleep_minutes,
        sleep_segments,
        history,
        (sequence_sleep or {}).get("stage_breakdown"),
    )
    device_sleep_score = (sequence_sleep or {}).get("device_score")
    if device_sleep_score is not None:
        device_weight = 0.35 if sleep_model.get("stages") is not None else 0.65
        sleep_score = round(_clamp(device_sleep_score * device_weight + sleep_model["score"] * (1 - device_weight), 0, 100))
    else:
        sleep_score = sleep_model["score"]
    spo2_score = None
    spo2_low = _spo2_low_duration(spo2)
    if spo2:
        spo2_score = _clamp(100 - max(0, 96 - _mean(spo2, 96)) * 8 - max(0, 92 - min(spo2)) * 5, 0, 100)

    live_transport = _summarize_live_hrv_transport(live_hrv)

    components = []
    if hrv_score is not None:
        components.append(("hrv", hrv_score, 0.45))
        components.append(("rhr", rhr_score if rhr_score is not None else 60, 0.25))
        components.append(("sleep", sleep_score, 0.20))
        components.append(("spo2", spo2_score if spo2_score is not None else 75, 0.10))
    else:
        components.append(("rhr", rhr_score if rhr_score is not None else 60, 0.35))
        components.append(("sleep", sleep_score, 0.45))
        components.append(("spo2", spo2_score if spo2_score is not None else 75, 0.15))
        load_component = 100 - min(45, current_strain * 2.3)
        if isinstance(load_ratio, (int, float)) and load_ratio > 1.3:
            load_component -= min(20, (load_ratio - 1.3) * 25)
        components.append(("load", _clamp(load_component, 0, 100), 0.05))

    recovery = sum(value * weight for _name, value, weight in components) / sum(weight for _name, _value, weight in components)
    if rhr_trend is not None and rhr_trend > 3:
        recovery -= min(8, rhr_trend * 1.2)
    if sleep_trend is not None and sleep_trend < -60:
        recovery -= min(8, abs(sleep_trend) / 18)
    if isinstance(load_ratio, (int, float)) and load_ratio > 1.55:
        recovery -= min(10, (load_ratio - 1.55) * 18)
    recovery = _clamp(recovery, 0, 100)

    generated_at = int(time.time())
    insight = {
        "generated_at": generated_at,
        "recovery_score": round(recovery),
        "recovery_label": _score_label(recovery),
        "components": {name: round(value, 1) for name, value, _weight in components},
        "hrv": hrv or {"source": "unavailable", "reason": "No live RRI or sleep-sequence HRV artifact yet."},
        "hrv_rmssd_ms": hrv_value,
        "resilience": resilience,
        "resting_hr": round(rhr, 1) if rhr is not None else None,
        "resting_hr_baseline": round(rhr_baseline, 1) if rhr_baseline is not None else None,
        "sleep": {
            "source": (sequence_sleep or {}).get("source") or ("fitness_history" if summary.get("sleep_minutes") else "unavailable"),
            "minutes": sleep_minutes,
            "need_minutes": round(sleep_need),
            "baseline_minutes": round(sleep_baseline) if sleep_baseline else None,
            "score": round(sleep_score),
            "device_score": round(device_sleep_score) if device_sleep_score is not None else None,
            "performance_score": round(sleep_performance),
            "session_start": (sequence_sleep or {}).get("start_ts"),
            "session_end": (sequence_sleep or {}).get("end_ts"),
            "sleep_efficiency": (sequence_sleep or {}).get("sleep_efficiency"),
            "sleep_latency_min": (sequence_sleep or {}).get("sleep_latency_min"),
            "avg_breath_rate": (sequence_sleep or {}).get("avg_breath_rate"),
            "avg_spo2": (sequence_sleep or {}).get("avg_spo2"),
            "stage_counts": (sequence_sleep or {}).get("stage_counts") or {},
            "stage_breakdown": sleep_model.get("stage_breakdown") or {},
            "stage_minutes": (sequence_sleep or {}).get("stage_minutes"),
            "components": {
                "duration": sleep_model["duration"],
                "stages": sleep_model["stages"],
                "consistency": sleep_model["consistency"],
                "interruptions": sleep_model["interruptions"],
                "fragmentation": sleep_model["fragmentation"],
            },
            "method": sleep_model["method"],
            "trend_3v14_minutes": round(sleep_trend, 1) if sleep_trend is not None else None,
        },
        "strain": strain,
        "stress": stress_summary,
        "spo2": spo2_low,
        "training_balance": {
            "acute_7d": round(acute, 1) if acute is not None else None,
            "chronic_42d": round(chronic, 1) if chronic is not None else None,
            "balance": load_model.get("balance"),
            "load_ratio": load_model.get("ratio"),
            "label": load_model.get("label"),
            "recommendation": load_model.get("recommendation"),
            "monotony": round(monotony, 2) if monotony is not None else None,
            "method": "EWMA acute 7d / chronic 42d from synced strain history",
        },
        "data_quality": {
            "hr_samples": len(heart_rates),
            "spo2_samples": len(spo2),
            "sleep_segments": len(fitness.get("sleep") or []),
            "stress_file_samples": stress.get("stress_count", 0),
            "sleep_sequence_sessions": sequence.get("sequence_count", 0),
            "sleep_source": (sequence_sleep or {}).get("source") or ("fitness_history" if summary.get("sleep_minutes") else "unavailable"),
            "hrv_source": (hrv or {}).get("source", "unavailable"),
            "live_hrv_transport": live_transport,
            "rhr_trend_3v14_bpm": round(rhr_trend, 1) if rhr_trend is not None else None,
        },
    }
    _write_json(data_dir / "latest_insights.json", insight)
    _append_jsonl(data_dir / "insights_history.jsonl", insight)
    return insight
