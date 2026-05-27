package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f7871a = new byte[0];
    private final byte[] b = new byte[0];
    private final String c;
    private an d;
    private HandlerThread e;
    private int f;

    public void b() {
        synchronized (this.f7871a) {
            if (!d()) {
                hq.b("HandlerExecAgent", "release exec agent - not working");
                return;
            }
            int i = this.f - 1;
            this.f = i;
            if (i <= 0) {
                this.f = 0;
                c();
            }
            if (hq.a()) {
                hq.a("HandlerExecAgent", "release exec agent - ref count: %d", Integer.valueOf(this.f));
            }
        }
    }

    public void a(String str) {
        if (d()) {
            an anVarF = f();
            if (anVarF != null) {
                anVarF.a(str);
            } else {
                a(new a(2, null, str, 0L));
            }
        }
    }

    public void a(Runnable runnable, String str, long j) {
        if (d()) {
            an anVarF = f();
            if (anVarF != null) {
                anVarF.a(runnable, str, j);
            } else {
                a(new a(1, runnable, str, j));
            }
        }
    }

    public void a(Runnable runnable) {
        if (d()) {
            an anVarF = f();
            if (anVarF != null) {
                anVarF.a(runnable);
            } else {
                a(new a(1, runnable, null, 0L));
            }
        }
    }

    public void a() {
        synchronized (this.f7871a) {
            this.f++;
            an anVarF = f();
            if (anVarF != null) {
                anVarF.a("handler_exec_release_task");
            }
            if (hq.a()) {
                hq.a("HandlerExecAgent", "acquire exec agent. ref count: %d", Integer.valueOf(this.f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public an f() {
        an anVar;
        synchronized (this.f7871a) {
            anVar = this.d;
        }
        return anVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (d()) {
            synchronized (this.b) {
                if (this.e == null) {
                    hq.b("HandlerExecAgent", "init handler thread");
                    HandlerThread handlerThread = new HandlerThread(this.c);
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    if (looper != null) {
                        this.e = handlerThread;
                        a(new an(new Handler(looper)));
                    } else {
                        handlerThread.quit();
                    }
                }
            }
        }
    }

    private boolean d() {
        boolean z;
        synchronized (this.f7871a) {
            z = this.f > 0;
        }
        return z;
    }

    private void c() {
        an anVarF = f();
        if (anVarF != null) {
            hq.b("HandlerExecAgent", "delay quit thread");
            anVarF.a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ao.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ao.this.b) {
                        if (ao.this.e != null) {
                            ao.this.e.quitSafely();
                            ao.this.e = null;
                        }
                        ao.this.a((an) null);
                        hq.b("HandlerExecAgent", "quit thread and release");
                    }
                }
            }, "handler_exec_release_task", 60000L);
        }
    }

    private void a(final a aVar) {
        n.g(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ao.2
            @Override // java.lang.Runnable
            public void run() {
                ao.this.e();
                an anVarF = ao.this.f();
                if (anVarF != null) {
                    if (aVar.f7874a == 1) {
                        anVarF.a(aVar.b, aVar.c, aVar.d);
                    } else if (aVar.f7874a == 2) {
                        anVarF.a(aVar.c);
                    }
                }
            }
        });
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7874a;
        Runnable b;
        String c;
        long d;

        public String toString() {
            return "CacheTask{taskType=" + this.f7874a + ", id='" + this.c + "'}";
        }

        a(int i, Runnable runnable, String str, long j) {
            this.f7874a = i;
            this.b = runnable;
            this.c = str;
            this.d = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar) {
        synchronized (this.f7871a) {
            this.d = anVar;
        }
    }

    public ao(String str) {
        this.c = TextUtils.isEmpty(str) ? "handler_exec_thread" : str;
    }
}
