package com.huawei.haf.common.dfx.block;

import com.huawei.haf.common.dfx.DfxMonitorTask;
import health.compact.a.DfxMonitorCenter;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadMonitorTask implements DfxMonitorTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f2127a;
    private final long b;
    private volatile boolean c = false;
    private final MonitorCallback d;

    public ThreadMonitorTask(Thread thread, MonitorCallback monitorCallback) {
        this.f2127a = thread;
        this.d = monitorCallback;
        this.b = a(monitorCallback.monitorTimeInterval());
    }

    public void c(String str) {
        e(null, 0L);
        this.d.begin(this.f2127a, str, System.currentTimeMillis());
        DfxMonitorCenter.e(this);
        this.c = true;
    }

    public long c() {
        return this.d.getBeginTime();
    }

    public void b() {
        e(null, 0L);
    }

    public void e(Throwable th, long j) {
        if (this.c) {
            DfxMonitorCenter.d(this);
            this.c = false;
            if (j <= this.d.getBeginTime()) {
                j = System.currentTimeMillis();
            }
            this.d.end(this.f2127a, th, j, this.b);
        }
    }

    private long a(long j) {
        return Math.max((j / 1000) * 1000, 1000L);
    }

    @Override // com.huawei.haf.common.dfx.DfxMonitorTask
    public long monitorDelayTime() {
        return this.b;
    }

    @Override // com.huawei.haf.common.dfx.DfxMonitorTask
    public void onMonitor() {
        if (this.c) {
            if (!this.f2127a.isAlive()) {
                this.c = false;
            } else if (this.d.check(this.f2127a, System.currentTimeMillis(), this.b)) {
                DfxMonitorCenter.e(this);
            }
        }
    }
}
