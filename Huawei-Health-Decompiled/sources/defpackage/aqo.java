package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class aqo implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f269a;
    private final ThreadGroup b;
    private final AtomicInteger c;
    private final int e;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.b, runnable, this.f269a + this.c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i = this.e;
        if (priority != i) {
            thread.setPriority(i);
        }
        return thread;
    }

    public aqo(String str, int i) {
        this.c = new AtomicInteger(1);
        this.e = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f269a = "PPS-" + str + "-threadpool-";
    }

    public aqo(String str) {
        this(str, 5);
    }
}
