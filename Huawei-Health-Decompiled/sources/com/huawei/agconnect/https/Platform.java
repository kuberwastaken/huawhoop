package com.huawei.agconnect.https;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public interface Platform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1829a;
    public static final int b;
    public static final int c;
    public static final Platform d;

    Executor a();

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f1829a = iAvailableProcessors;
        b = (iAvailableProcessors * 2) + 1;
        c = iAvailableProcessors + 1;
        d = new Platform() { // from class: com.huawei.agconnect.https.Platform.1
            public final Executor e = new ThreadPoolExecutor(Platform.c, Platform.b, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.huawei.agconnect.https.Platform.1.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "AGC-Https-Thread");
                }
            });

            @Override // com.huawei.agconnect.https.Platform
            public Executor a() {
                return this.e;
            }
        };
    }
}
