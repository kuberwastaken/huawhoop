package com.huawei.hms.ads.dynamicloader;

import com.huawei.hms.ads.uiengineloader.af;

/* JADX INFO: loaded from: classes5.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4497a = "SafeRunnable";
    private Runnable b;

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.b;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                af.d(f4497a, "exception in task run: " + th.getClass().getSimpleName());
            }
        }
    }

    public k(Runnable runnable) {
        this.b = runnable;
    }
}
