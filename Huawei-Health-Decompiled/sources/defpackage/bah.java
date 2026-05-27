package defpackage;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class bah {
    private static final ScheduledExecutorService b;

    static class e implements ThreadFactory {
        private final AtomicInteger d;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Core thread #" + this.d.getAndIncrement());
        }

        private e() {
            this.d = new AtomicInteger();
        }
    }

    public static void b(Runnable runnable, long j) {
        b.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new e());
        scheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        b = scheduledThreadPoolExecutor;
    }
}
