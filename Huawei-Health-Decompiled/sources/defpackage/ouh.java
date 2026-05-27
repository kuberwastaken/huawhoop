package defpackage;

import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes7.dex */
public class ouh extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f16562a;
    private static final int c;
    private static ouh d;
    private static final int e;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        c = iAvailableProcessors;
        int i = iAvailableProcessors + 1;
        e = i;
        f16562a = i;
    }

    private ouh(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandler() { // from class: ouh.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                ouq.c("Task rejected, too many task!");
            }
        });
    }

    public static ouh a() {
        if (d == null) {
            synchronized (ouh.class) {
                if (d == null) {
                    d = new ouh(e, f16562a, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new d());
                }
            }
        }
        return d;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e2) {
                th = e2;
            } catch (ExecutionException e3) {
                th = e3.getCause();
            }
        }
        if (th != null) {
            ouq.c("Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th.getMessage() + "]\n" + th.getStackTrace());
        }
    }

    static class d implements ThreadFactory {
        private static final AtomicInteger d = new AtomicInteger(1);
        private final AtomicInteger b = new AtomicInteger(1);
        private final ThreadGroup c;
        private final String e;

        public d() {
            SecurityManager securityManager = System.getSecurityManager();
            this.c = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.e = "HwSkinner task pool No." + d.getAndIncrement() + ", thread No.";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str = this.e + this.b.getAndIncrement();
            ouq.e("Thread production, name is [" + str + "]");
            Thread thread = new Thread(this.c, runnable, str, 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: ouh.d.4
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    ouq.e("Running task appeared exception! Thread [" + thread2.getName() + "], because [" + th.getMessage() + "]");
                }
            });
            return thread;
        }
    }
}
