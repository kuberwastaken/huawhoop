package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f7870a;

    public void a(String str) {
        Handler handler = this.f7870a;
        if (handler == null || str == null) {
            return;
        }
        handler.removeCallbacksAndMessages(str);
    }

    public void a(Runnable runnable, String str, long j) {
        if (this.f7870a == null || runnable == null) {
            return;
        }
        if (j < 0) {
            j = 0;
        }
        dj djVar = new dj(runnable);
        if (j == 0 && a()) {
            djVar.run();
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + j;
        try {
            Message messageObtain = Message.obtain(this.f7870a, djVar);
            messageObtain.setAsynchronous(true);
            messageObtain.obj = str;
            this.f7870a.sendMessageAtTime(messageObtain, jUptimeMillis);
        } catch (Throwable unused) {
            this.f7870a.postAtTime(djVar, str, jUptimeMillis);
        }
    }

    public void a(Runnable runnable, String str) {
        if (this.f7870a == null || runnable == null) {
            return;
        }
        dj djVar = new dj(runnable);
        if (a()) {
            djVar.run();
            return;
        }
        try {
            Message messageObtain = Message.obtain(this.f7870a, djVar);
            messageObtain.setAsynchronous(true);
            messageObtain.obj = str;
            this.f7870a.sendMessageAtFrontOfQueue(messageObtain);
        } catch (Throwable unused) {
            this.f7870a.postAtFrontOfQueue(djVar);
        }
    }

    public void a(Runnable runnable) {
        a(runnable, null, 0L);
    }

    private boolean a() {
        Looper looper;
        Handler handler = this.f7870a;
        if (handler == null || (looper = handler.getLooper()) == null) {
            return false;
        }
        return Thread.currentThread() == looper.getThread();
    }

    public an(Handler handler) {
        this.f7870a = handler;
    }
}
