package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f765a = new b();
    private Thread b = null;
    private LinkedList<Runnable> c = new LinkedList<>();

    public void a(Runnable runnable) {
        synchronized (this) {
            this.c.add(runnable);
            if (this.b == null) {
                Thread thread = new Thread(new c(this));
                this.b = thread;
                thread.start();
            }
        }
    }

    public static b a() {
        return f765a;
    }
}
