package com.amap.api.col.p0003sl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class he {
    private static volatile he c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BlockingQueue<Runnable> f1019a = new LinkedBlockingQueue();
    private ExecutorService b;

    public static he a() {
        if (c == null) {
            synchronized (he.class) {
                if (c == null) {
                    c = new he();
                }
            }
        }
        return c;
    }

    public static void b() {
        if (c != null) {
            synchronized (he.class) {
                if (c != null) {
                    c.b.shutdownNow();
                    c.b = null;
                    c = null;
                }
            }
        }
    }

    private he() {
        this.b = null;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.b = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors * 2, 1L, TimeUnit.SECONDS, this.f1019a, new ThreadPoolExecutor.AbortPolicy());
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService = this.b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
