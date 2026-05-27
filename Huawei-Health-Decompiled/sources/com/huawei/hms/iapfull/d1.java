package com.huawei.hms.iapfull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f4884a;

    public void a(Runnable runnable) {
        this.f4884a.execute(runnable);
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static d1 f4885a = new d1();
    }

    static class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4886a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Pay-Message-" + this.f4886a.getAndIncrement());
        }

        c() {
        }
    }

    public static d1 a() {
        return b.f4885a;
    }

    private d1() {
        y0.b("ThreadpoolManager", "threadpool init.");
        this.f4884a = Executors.newCachedThreadPool(new c());
    }
}
