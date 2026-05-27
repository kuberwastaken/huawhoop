package defpackage;

import defpackage.mkw;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class mku extends ThreadPoolExecutor {
    private String b;
    private long d;
    private Map<String, Long> e;

    static class c implements ThreadFactory {
        private String d;
        final AtomicInteger e = new AtomicInteger(1);

        public c(String str) {
            this.d = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.d + this.e.getAndIncrement());
        }
    }

    public mku(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, String str) {
        super(i, i2, j, timeUnit, blockingQueue);
        this.b = str;
        setThreadFactory(new c(str));
        this.d = System.currentTimeMillis();
        this.e = new ConcurrentHashMap();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        this.e.put(String.valueOf(runnable.hashCode()), Long.valueOf(System.currentTimeMillis()));
        if (System.currentTimeMillis() - this.d >= 5000) {
            d();
            a();
            this.d = System.currentTimeMillis();
        }
        super.beforeExecute(thread, runnable);
    }

    private void d() {
        new mkw.c().d(getActiveCount()).e(getCompletedTaskCount()).c(getTaskCount()).b(getCorePoolSize()).e(getLargestPoolSize()).a(getMaximumPoolSize()).c(getQueue().size());
    }

    private void a() {
        StringBuilder sb = new StringBuilder("thread dump:");
        sb.append("poolName:" + this.b + " activeCount:" + getActiveCount() + " completedTaskCount:" + getCompletedTaskCount() + " taskCount:" + getTaskCount() + " corePoolSize:" + getCorePoolSize() + " largestPoolSize:" + getLargestPoolSize() + " maximumPoolSize:" + getMaximumPoolSize() + " queueSize:" + getQueue().size() + " ");
        mly.a("ThreadPool", sb.toString(), true);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        mly.a("ThreadPool", "shutdown", true);
        a();
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        mly.a("ThreadPool", "shutdownNow", true);
        a();
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        c(runnable);
        a();
        super.afterExecute(runnable, th);
    }

    private void c(Runnable runnable) {
        Long lRemove = this.e.remove(String.valueOf(runnable.hashCode()));
        long jLongValue = lRemove == null ? 0L : lRemove.longValue();
        mly.a("ThreadPool", "afterExecute, time costs:" + (System.currentTimeMillis() - jLongValue) + "ms", true);
    }
}
