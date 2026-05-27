package com.huawei.haf.common.dfx;

import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class DfxMonitorCenter$DfxMonitorThread {
    private static final DfxMonitorCenter$DfxMonitorThread c = new DfxMonitorCenter$DfxMonitorThread();
    private final HandlerThread d;

    private DfxMonitorCenter$DfxMonitorThread() {
        HandlerThread handlerThread = new HandlerThread("DfxMonitorThread");
        this.d = handlerThread;
        handlerThread.start();
    }

    static Looper yO_() {
        return c.d.getLooper();
    }
}
