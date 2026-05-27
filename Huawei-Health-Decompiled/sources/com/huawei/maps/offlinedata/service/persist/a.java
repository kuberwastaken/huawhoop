package com.huawei.maps.offlinedata.service.persist;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f6745a;

    private a() {
        this.f6745a = new ThreadPoolExecutor(1, 50, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(400), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static a a() {
        return C0184a.f6746a;
    }

    public ThreadPoolExecutor b() {
        return this.f6745a;
    }

    /* JADX INFO: renamed from: com.huawei.maps.offlinedata.service.persist.a$a, reason: collision with other inner class name */
    static class C0184a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f6746a = new a();
    }
}
