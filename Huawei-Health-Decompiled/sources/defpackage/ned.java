package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class ned implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f16020a;
    private final ThreadGroup b;
    private final int d;
    private final String e;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.b, runnable, this.e + this.f16020a.getAndIncrement(), 0L);
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

    public ned(String str, int i) {
        this.f16020a = new AtomicInteger(1);
        this.d = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.e = "PPS-" + str + "-pool-thread-";
    }

    public ned(String str) {
        this(str, 5);
    }
}
