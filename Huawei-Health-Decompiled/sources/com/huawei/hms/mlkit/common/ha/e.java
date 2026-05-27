package com.huawei.hms.mlkit.common.ha;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes5.dex */
public class e extends TimerTask {
    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            c.f5235a.a();
        } catch (Exception unused) {
            b.a("HaLogOnReport", "Failed to report hianalytics data");
        }
    }
}
