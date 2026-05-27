package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes8.dex */
public class ygk implements ThreadFactory {
    public static final ThreadGroup b;
    public static final ThreadGroup c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f19298a = new AtomicInteger(1);
    private final ThreadGroup d;
    private final String e;

    protected boolean b() {
        return false;
    }

    static {
        ThreadGroup threadGroup = new ThreadGroup("Californium");
        c = threadGroup;
        ThreadGroup threadGroup2 = new ThreadGroup("Scandium");
        b = threadGroup2;
        threadGroup.setDaemon(false);
        threadGroup2.setDaemon(false);
    }

    public ygk(String str, ThreadGroup threadGroup) {
        this.d = threadGroup == null ? c : threadGroup;
        this.e = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.d, runnable, this.e + this.f19298a.getAndIncrement(), 0L);
        thread.setDaemon(b());
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
