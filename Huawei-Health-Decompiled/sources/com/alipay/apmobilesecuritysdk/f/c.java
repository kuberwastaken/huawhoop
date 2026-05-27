package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

/* JADX INFO: loaded from: classes9.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f766a;

    @Override // java.lang.Runnable
    public void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.f766a.c.isEmpty()) {
                Runnable runnable = (Runnable) this.f766a.c.get(0);
                this.f766a.c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f766a.b = null;
            throw th;
        }
        this.f766a.b = null;
    }

    public c(b bVar) {
        this.f766a = bVar;
    }
}
