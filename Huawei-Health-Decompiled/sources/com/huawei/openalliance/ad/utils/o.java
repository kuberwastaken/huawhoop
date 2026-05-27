package com.huawei.openalliance.ad.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class o implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadGroup f8011a;
    private final AtomicInteger b;
    private final String c;
    private final int d;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f8011a, runnable, this.c + this.b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i = this.d;
        if (priority != i) {
            thread.setPriority(i);
        }
        return thread;
    }

    public o(String str, int i) {
        this.b = new AtomicInteger(1);
        this.d = i;
        this.f8011a = Thread.currentThread().getThreadGroup();
        this.c = "PPS-" + str + "-pool-thread-";
    }

    public o(String str) {
        this(str, 5);
    }
}
