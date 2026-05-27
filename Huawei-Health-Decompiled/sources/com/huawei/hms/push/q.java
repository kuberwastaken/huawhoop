package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f5872a = new Object();
    private static ThreadPoolExecutor b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f5872a) {
            threadPoolExecutor = b;
        }
        return threadPoolExecutor;
    }
}
