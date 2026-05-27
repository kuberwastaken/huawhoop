package com.huawei.haf.common.dfx;

/* JADX INFO: loaded from: classes.dex */
public interface DfxMonitorTask {
    public static final long MIN_MONITOR_TIME_INTERVAL = 1000;

    long monitorDelayTime();

    void onMonitor();
}
