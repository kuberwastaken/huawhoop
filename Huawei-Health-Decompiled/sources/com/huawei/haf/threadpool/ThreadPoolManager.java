package com.huawei.haf.threadpool;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.haf.application.BaseApplication;
import com.huawei.haf.common.utils.CollectionUtils;
import com.huawei.openalliance.ad.constant.Constants;
import health.compact.a.LogUtil;
import health.compact.a.ProcessUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadPoolManager extends AbstractExecutorService {
    private static volatile ThreadPoolManager b;
    private static volatile ThreadPoolManager c;
    private static final ConcurrentHashMap<Thread, HealthThreadPoolExecutor.HealthRunnableInfo> e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2196a = 0;
    final HealthThreadPoolExecutor d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface TaskStatistics {
        void afterExecute(Runnable runnable, Throwable th);

        void beforeExecute(Thread thread, Runnable runnable);
    }

    private ThreadPoolManager(int i, int i2, String str) {
        this.d = new HealthThreadPoolExecutor(i, i2, str);
    }

    public static ThreadPoolManager b() {
        if (b == null) {
            synchronized (ThreadPoolManager.class) {
                if (b == null) {
                    boolean zE = ProcessUtil.e();
                    b = e(zE ? 10 : 5, zE ? 50 : 20, "haf-def");
                }
            }
        }
        return b;
    }

    public static ThreadPoolManager d() {
        if (c == null) {
            synchronized (ThreadPoolManager.class) {
                if (c == null) {
                    int iMax = Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 5));
                    c = e(iMax, iMax, "haf-cpu");
                }
            }
        }
        return c;
    }

    public static ThreadPoolManager b(int i, int i2) {
        return new ThreadPoolManager(i, i2, null);
    }

    public static ThreadPoolManager e(int i, int i2, String str) {
        return new ThreadPoolManager(i, i2, str);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c();
        if (runnable instanceof HealthRunnable) {
            this.d.execute(runnable);
        } else if (runnable != null) {
            this.d.execute(new HealthRunnable(runnable));
        }
    }

    private void c() {
        if (LogUtil.d()) {
            return;
        }
        ConcurrentHashMap<Thread, HealthThreadPoolExecutor.HealthRunnableInfo> concurrentHashMap = e;
        if (CollectionUtils.e(concurrentHashMap)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f2196a < 300000) {
            return;
        }
        this.f2196a = jCurrentTimeMillis;
        int poolSize = this.d.getPoolSize();
        int activeCount = this.d.getActiveCount();
        LogUtil.a("HAF_ThreadPoolManager", "dumpThreadPoolThreadInfo poolSize:", Integer.valueOf(poolSize), " activeCount:", Integer.valueOf(activeCount), " taskRunNum:", Integer.valueOf(this.d.c()), " waitRn:", Integer.valueOf(this.d.d()));
        if (activeCount == 0 || poolSize != activeCount) {
            return;
        }
        StringBuilder sb = new StringBuilder("Running Threads Information:\n");
        boolean z = false;
        for (Map.Entry<Thread, HealthThreadPoolExecutor.HealthRunnableInfo> entry : concurrentHashMap.entrySet()) {
            Thread key = entry.getKey();
            HealthThreadPoolExecutor.HealthRunnableInfo value = entry.getValue();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - value.b;
            if (jCurrentTimeMillis2 > 300000) {
                z = true;
            }
            sb.append("Thread Name: ");
            sb.append(key.getName());
            sb.append(", Simple Name: ");
            sb.append(value.d);
            sb.append(", Start Time: ");
            sb.append(value.b);
            sb.append(", Execution Time: ");
            sb.append(jCurrentTimeMillis2);
            sb.append(" ms\n");
        }
        LogUtil.b("HAF_ThreadPoolManager", "DumpThreadPoolThreadInfo ", sb.toString());
        if (z) {
            d("HAF_ThreadPoolManager", sb.toString());
            e.clear();
        }
    }

    private static void d(String str, String str2) {
        SharedPreferences.Editor editorEdit = BaseApplication.a().getSharedPreferences("error_monitor_upload_log_name", 0).edit();
        String str3 = System.currentTimeMillis() + ";" + str + ";" + str2 + ";" + BaseApplication.h();
        if (editorEdit != null) {
            editorEdit.putString("error_monitor_upload_log_key", str3);
            editorEdit.commit();
        }
    }

    public boolean b(Runnable runnable) {
        if (runnable instanceof HealthRunnable) {
            return this.d.remove(runnable);
        }
        if (runnable != null) {
            return this.d.remove(new HealthRunnable(runnable));
        }
        return false;
    }

    public void e(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("tag is null");
        }
        execute(new HealthTagRunnable(str, runnable));
    }

    public int c(String str, Runnable runnable) {
        if (str == null) {
            throw new IllegalArgumentException("tag is null");
        }
        if (runnable != null) {
            return this.d.remove(new HealthTagRunnable(str, runnable)) ? 1 : 0;
        }
        return this.d.e(str);
    }

    public void d(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("serialTag is null");
        }
        execute(new HealthSerialRunnable(str, runnable));
    }

    public int b(String str, Runnable runnable) {
        if (str == null) {
            throw new IllegalArgumentException("serialTag is null");
        }
        if (runnable != null) {
            return this.d.remove(new HealthSerialRunnable(str, runnable)) ? 1 : 0;
        }
        return this.d.b(str);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        if (a()) {
            LogUtil.b("HAF_ThreadPoolManager", "Unsupported shutdown default thread pool");
        } else {
            this.d.shutdown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (a()) {
            LogUtil.b("HAF_ThreadPoolManager", "Unsupported shutdownNow default thread pool");
            return Collections.EMPTY_LIST;
        }
        List<Runnable> listShutdownNow = this.d.shutdownNow();
        for (int i = 0; i < listShutdownNow.size(); i++) {
            Runnable runnable = listShutdownNow.get(i);
            if (runnable instanceof HealthRunnable) {
                listShutdownNow.set(i, ((HealthRunnable) runnable).a());
            }
        }
        return listShutdownNow;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.d.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.d.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.d.awaitTermination(j, timeUnit);
    }

    public void a(TaskStatistics taskStatistics) {
        this.d.e(taskStatistics);
    }

    public String toString() {
        return this.d.b();
    }

    private boolean a() {
        return this == b || this == c;
    }

    static class HealthRunnable implements Runnable {
        private final long b;
        private final Runnable c;
        private final String d;

        HealthRunnable(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("runnable == null");
            }
            this.c = runnable;
            this.b = System.currentTimeMillis();
            this.d = c(runnable.getClass().getName());
        }

        Runnable a() {
            return this.c;
        }

        String d() {
            return c(this.c.getClass().getName());
        }

        private String c(String str) {
            int iLastIndexOf;
            return (!this.c.getClass().isAnonymousClass() || (iLastIndexOf = str.lastIndexOf(".")) <= 0) ? str : str.substring(iLastIndexOf + 1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.run();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HealthRunnable) {
                return this.c.equals(((HealthRunnable) obj).c);
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode() + super.hashCode();
        }

        public String toString() {
            return c(this.c.toString());
        }
    }

    static class HealthTagRunnable extends HealthRunnable {
        private static final Runnable c = new Runnable() { // from class: com.huawei.haf.threadpool.ThreadPoolManager.HealthTagRunnable.1
            @Override // java.lang.Runnable
            public void run() {
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2199a;

        HealthTagRunnable(String str, Runnable runnable) {
            super(runnable);
            if (str == null) {
                throw new IllegalArgumentException("tag == null");
            }
            this.f2199a = str;
        }

        HealthTagRunnable(String str) {
            super(c);
            if (str == null) {
                throw new IllegalArgumentException("tag == null");
            }
            this.f2199a = str;
        }

        @Override // com.huawei.haf.threadpool.ThreadPoolManager.HealthRunnable
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HealthTagRunnable)) {
                return false;
            }
            HealthTagRunnable healthTagRunnable = (HealthTagRunnable) obj;
            if (!this.f2199a.equals(healthTagRunnable.f2199a)) {
                return false;
            }
            Runnable runnableA = a();
            Runnable runnable = c;
            if (runnableA == runnable || healthTagRunnable.a() == runnable) {
                return true;
            }
            return super.equals(obj);
        }

        @Override // com.huawei.haf.threadpool.ThreadPoolManager.HealthRunnable
        public int hashCode() {
            return this.f2199a.hashCode() + super.hashCode();
        }

        @Override // com.huawei.haf.threadpool.ThreadPoolManager.HealthRunnable
        public String toString() {
            return "tag=(" + this.f2199a + "), " + super.toString();
        }
    }

    static class HealthSerialRunnable extends HealthRunnable {
        private HealthSerialRunnable d;
        private final String e;

        HealthSerialRunnable(String str, Runnable runnable) {
            super(runnable);
            if (str == null) {
                throw new IllegalArgumentException("serialTag == null");
            }
            this.e = str;
        }

        @Override // com.huawei.haf.threadpool.ThreadPoolManager.HealthRunnable
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof HealthSerialRunnable) && this.e.equals(((HealthSerialRunnable) obj).e)) {
                return super.equals(obj);
            }
            return false;
        }

        @Override // com.huawei.haf.threadpool.ThreadPoolManager.HealthRunnable
        public int hashCode() {
            return this.e.hashCode() + super.hashCode();
        }

        @Override // com.huawei.haf.threadpool.ThreadPoolManager.HealthRunnable
        public String toString() {
            return "serialTag=(" + this.e + "), " + super.toString();
        }
    }

    public static final class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger c = new AtomicInteger(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadGroup f2197a;
        private final AtomicInteger b;
        private final String d;

        DefaultThreadFactory() {
            this("haf-def");
        }

        public DefaultThreadFactory(String str) {
            this.b = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            this.f2197a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.d = e(str) + Constants.LINK + c.getAndIncrement() + Constants.LINK;
        }

        private String e(String str) {
            if (TextUtils.isEmpty(str)) {
                return "haf-unk";
            }
            if (str.length() <= 5) {
                return "haf-" + str;
            }
            return str.substring(0, Math.min(9, str.length()));
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f2197a, runnable, this.d + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }

        public String toString() {
            return this.d + this.f2197a.getName();
        }
    }

    static class HealthWrapExecutionHandler implements RejectedExecutionHandler {
        private volatile boolean b;
        private final BlockingQueue<HealthRunnable> d;

        private HealthWrapExecutionHandler() {
            this.d = new LinkedBlockingQueue();
            this.b = true;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            this.b = true;
        }

        void b(Runnable runnable, HealthThreadPoolExecutor healthThreadPoolExecutor) {
            if ((runnable == null && this.d.isEmpty()) || healthThreadPoolExecutor.isShutdown()) {
                return;
            }
            if (runnable != null && !this.d.offer(e(runnable))) {
                LogUtil.b("HAF_ThreadPoolManager", "task rejected:", runnable.toString());
            }
            if (this.b) {
                e(healthThreadPoolExecutor);
            }
        }

        private void e(HealthThreadPoolExecutor healthThreadPoolExecutor) {
            synchronized (this) {
                try {
                    this.b = false;
                    HealthRunnable healthRunnablePeek = this.d.peek();
                    while (healthRunnablePeek != null) {
                        healthThreadPoolExecutor.a(healthRunnablePeek);
                        if (this.b) {
                            break;
                        }
                        this.d.poll();
                        healthRunnablePeek = this.d.peek();
                    }
                } finally {
                    this.b = true;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean c(java.lang.Runnable r1, com.huawei.haf.threadpool.ThreadPoolManager.HealthThreadPoolExecutor r2) {
            /*
                r0 = this;
                monitor-enter(r0)
                com.huawei.haf.threadpool.ThreadPoolManager$HealthRunnable r1 = r0.e(r1)     // Catch: java.lang.Throwable -> L19
                boolean r2 = r2.c(r1)     // Catch: java.lang.Throwable -> L19
                if (r2 != 0) goto L16
                java.util.concurrent.BlockingQueue<com.huawei.haf.threadpool.ThreadPoolManager$HealthRunnable> r2 = r0.d     // Catch: java.lang.Throwable -> L19
                boolean r1 = r2.remove(r1)     // Catch: java.lang.Throwable -> L19
                if (r1 == 0) goto L14
                goto L16
            L14:
                r1 = 0
                goto L17
            L16:
                r1 = 1
            L17:
                monitor-exit(r0)
                return r1
            L19:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.haf.threadpool.ThreadPoolManager.HealthWrapExecutionHandler.c(java.lang.Runnable, com.huawei.haf.threadpool.ThreadPoolManager$HealthThreadPoolExecutor):boolean");
        }

        int b(String str, HealthThreadPoolExecutor healthThreadPoolExecutor) {
            int i;
            synchronized (this) {
                HealthTagRunnable healthTagRunnable = new HealthTagRunnable(str);
                BlockingQueue<Runnable> queue = healthThreadPoolExecutor.getQueue();
                i = 0;
                while (queue.remove(healthTagRunnable)) {
                    i++;
                }
                while (this.d.remove(healthTagRunnable)) {
                    i++;
                }
            }
            return i;
        }

        int a(HealthThreadPoolExecutor healthThreadPoolExecutor) {
            int size;
            int size2;
            synchronized (this) {
                size = healthThreadPoolExecutor.getQueue().size();
                size2 = this.d.size();
            }
            return size + size2;
        }

        void b(HealthThreadPoolExecutor healthThreadPoolExecutor) {
            synchronized (this) {
                healthThreadPoolExecutor.j();
                this.d.clear();
            }
        }

        List<Runnable> d(HealthThreadPoolExecutor healthThreadPoolExecutor) {
            List<Runnable> listI;
            synchronized (this) {
                listI = healthThreadPoolExecutor.i();
                listI.addAll(this.d);
                this.d.clear();
            }
            return listI;
        }

        private HealthRunnable e(Runnable runnable) {
            if (runnable instanceof HealthRunnable) {
                return (HealthRunnable) runnable;
            }
            return new HealthRunnable(runnable);
        }
    }

    static final class HealthSerialExecutionHandler {
        private final HealthThreadPoolExecutor c;
        private final HashMap<String, HealthSerialRunnable> b = new HashMap<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f2198a = new AtomicInteger(0);
        private final ThreadLocal<Boolean> d = new ThreadLocal<>();

        HealthSerialExecutionHandler(HealthThreadPoolExecutor healthThreadPoolExecutor) {
            this.c = healthThreadPoolExecutor;
        }

        int d() {
            return this.f2198a.intValue();
        }

        boolean a(HealthSerialRunnable healthSerialRunnable) {
            synchronized (this.b) {
                HealthSerialRunnable healthSerialRunnable2 = this.b.get(healthSerialRunnable.e);
                if (healthSerialRunnable2 == null) {
                    this.b.put(healthSerialRunnable.e, healthSerialRunnable);
                    return false;
                }
                while (healthSerialRunnable2.d != null) {
                    healthSerialRunnable2 = healthSerialRunnable2.d;
                }
                healthSerialRunnable2.d = healthSerialRunnable;
                this.f2198a.getAndIncrement();
                return true;
            }
        }

        void a(Runnable runnable, Throwable th, HealthWrapExecutionHandler healthWrapExecutionHandler) {
            if (runnable instanceof HealthSerialRunnable) {
                if (th != null) {
                    HealthSerialRunnable healthSerialRunnableB = b(((HealthSerialRunnable) runnable).e);
                    if (healthSerialRunnableB != null) {
                        healthWrapExecutionHandler.b(healthSerialRunnableB, this.c);
                        return;
                    }
                    return;
                }
                Boolean bool = this.d.get();
                if (bool == null || !bool.booleanValue()) {
                    this.d.set(Boolean.TRUE);
                    try {
                        e((HealthSerialRunnable) runnable);
                    } finally {
                        this.d.set(Boolean.FALSE);
                    }
                }
            }
        }

        boolean d(HealthSerialRunnable healthSerialRunnable, HealthWrapExecutionHandler healthWrapExecutionHandler) {
            HealthSerialRunnable healthSerialRunnableA;
            synchronized (this.b) {
                boolean zC = healthWrapExecutionHandler.c(healthSerialRunnable, this.c);
                HealthSerialRunnable healthSerialRunnable2 = this.b.get(healthSerialRunnable.e);
                if (healthSerialRunnable2 == null) {
                    return zC;
                }
                if (!zC) {
                    while (healthSerialRunnable2.d != null) {
                        if (healthSerialRunnable2.d.equals(healthSerialRunnable)) {
                            healthSerialRunnable2.d = healthSerialRunnable2.d.d;
                            this.f2198a.getAndDecrement();
                            return true;
                        }
                        healthSerialRunnable2 = healthSerialRunnable2.d;
                    }
                    return false;
                }
                if (healthSerialRunnable2.equals(healthSerialRunnable) && (healthSerialRunnableA = a(healthSerialRunnable2.e)) != null) {
                    healthWrapExecutionHandler.b(healthSerialRunnableA, this.c);
                }
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        int a(String str, HealthWrapExecutionHandler healthWrapExecutionHandler) {
            synchronized (this.b) {
                HealthSerialRunnable healthSerialRunnable = this.b.get(str);
                if (healthSerialRunnable == null) {
                    return 0;
                }
                boolean zC = healthWrapExecutionHandler.c(healthSerialRunnable, this.c);
                HealthSerialRunnable healthSerialRunnableA = a(str);
                int i = zC;
                while (healthSerialRunnableA != null) {
                    healthSerialRunnableA = a(str);
                    i++;
                }
                return i;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(List<Runnable> list) {
            synchronized (this.b) {
                if (this.b.isEmpty()) {
                    return;
                }
                for (String str : (String[]) this.b.keySet().toArray(new String[this.b.size()])) {
                    HealthSerialRunnable healthSerialRunnableA = a(str);
                    while (healthSerialRunnableA != null) {
                        if (list != null) {
                            list.add(healthSerialRunnableA);
                        }
                        healthSerialRunnableA = a(str);
                    }
                }
            }
        }

        private HealthSerialRunnable a(String str) {
            HealthSerialRunnable healthSerialRunnableRemove = this.b.remove(str);
            if (healthSerialRunnableRemove == null) {
                return null;
            }
            HealthSerialRunnable healthSerialRunnable = healthSerialRunnableRemove.d;
            if (healthSerialRunnable == null) {
                return healthSerialRunnable;
            }
            this.b.put(healthSerialRunnable.e, healthSerialRunnable);
            this.f2198a.getAndDecrement();
            return healthSerialRunnable;
        }

        private HealthSerialRunnable b(String str) {
            HealthSerialRunnable healthSerialRunnableA;
            synchronized (this.b) {
                healthSerialRunnableA = a(str);
            }
            return healthSerialRunnableA;
        }

        private void e(HealthSerialRunnable healthSerialRunnable) {
            HealthSerialRunnable healthSerialRunnableB = b(healthSerialRunnable.e);
            while (healthSerialRunnableB != null) {
                a(Thread.currentThread(), healthSerialRunnableB);
                healthSerialRunnableB = b(healthSerialRunnableB.e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void a(Thread thread, Runnable runnable) {
            this.c.beforeExecute(thread, runnable);
            try {
                try {
                    try {
                        runnable.run();
                        this.c.afterExecute(runnable, null);
                    } catch (Throwable th) {
                        throw new Error(th);
                    }
                } catch (Error e) {
                    throw e;
                } catch (RuntimeException e2) {
                    throw e2;
                }
            } catch (Throwable th2) {
                this.c.afterExecute(runnable, thread);
                throw th2;
            }
        }
    }

    static final class HealthThreadPoolExecutor extends ThreadPoolExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DefaultThreadFactory f2200a = new DefaultThreadFactory();
        private final AtomicLong b;
        private String c;
        private final HealthWrapExecutionHandler d;
        private final HealthSerialExecutionHandler e;
        private TaskStatistics g;
        private TaskStatistics h;
        private final AtomicInteger j;

        private static int d(int i) {
            return (i >> 1) + 1;
        }

        HealthThreadPoolExecutor(int i, int i2, String str) {
            this(i, i2, 30L, str);
        }

        HealthThreadPoolExecutor(int i, int i2, long j, String str) {
            this(i, i2, d(i), j, str);
        }

        HealthThreadPoolExecutor(int i, int i2, int i3, long j, String str) {
            this(i, i2, i3, j, new HealthWrapExecutionHandler());
            setThreadFactory(new DefaultThreadFactory(str));
        }

        private HealthThreadPoolExecutor(int i, int i2, int i3, long j, HealthWrapExecutionHandler healthWrapExecutionHandler) {
            super(i, i2, j, TimeUnit.SECONDS, new ArrayBlockingQueue(Math.max(i3, 1)), f2200a, healthWrapExecutionHandler);
            this.b = new AtomicLong(0L);
            this.j = new AtomicInteger(0);
            this.d = healthWrapExecutionHandler;
            this.e = new HealthSerialExecutionHandler(this);
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
            throw new UnsupportedOperationException("Unsupported setRejectedExecutionHandler");
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public long getTaskCount() {
            return getCompletedTaskCount() + ((long) getActiveCount()) + ((long) d());
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public long getCompletedTaskCount() {
            return this.b.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if ((runnable instanceof HealthSerialRunnable) && !isShutdown() && this.e.a((HealthSerialRunnable) runnable)) {
                return;
            }
            this.d.b(runnable, this);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public boolean remove(Runnable runnable) {
            if (runnable instanceof HealthSerialRunnable) {
                return this.e.d((HealthSerialRunnable) runnable, this.d);
            }
            return this.d.c(runnable, this);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
        public void shutdown() {
            this.d.b(this);
            this.e.b((List<Runnable>) null);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            List<Runnable> listD = this.d.d(this);
            this.e.b(listD);
            return listD;
        }

        static class HealthRunnableInfo {
            final long b;
            final String d;

            HealthRunnableInfo(String str, long j) {
                this.d = str;
                this.b = j;
            }
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void beforeExecute(Thread thread, Runnable runnable) {
            if (runnable instanceof HealthRunnable) {
                HealthRunnable healthRunnable = (HealthRunnable) runnable;
                ThreadPoolManager.e.put(thread, new HealthRunnableInfo(healthRunnable.d, healthRunnable.b));
            }
            this.d.b((Runnable) null, this);
            this.j.getAndIncrement();
            TaskStatistics taskStatisticsG = g();
            if (taskStatisticsG != null) {
                taskStatisticsG.beforeExecute(thread, runnable);
            }
            super.beforeExecute(thread, runnable);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            ThreadPoolManager.e.remove(Thread.currentThread());
            this.j.getAndDecrement();
            this.b.getAndIncrement();
            TaskStatistics taskStatisticsH = h();
            if (taskStatisticsH != null) {
                taskStatisticsH.afterExecute(runnable, th);
            }
            this.e.a(runnable, th, this.d);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void terminated() {
            super.terminated();
            LogUtil.a("HAF_ThreadPoolManager", "health thread pool terminated, ", getThreadFactory().toString());
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append(b());
            sb.append(", state{[");
            sb.append(getMaximumPoolSize());
            sb.append(", ");
            sb.append(getCorePoolSize());
            sb.append(", ");
            sb.append(getLargestPoolSize());
            sb.append("], poolSize=");
            sb.append(getPoolSize());
            sb.append(", activeCount=");
            sb.append(getActiveCount());
            sb.append(", runNum=");
            sb.append(c());
            sb.append(", waitNum=(");
            sb.append(d());
            sb.append(", ");
            sb.append(a());
            sb.append(", ");
            sb.append(e());
            sb.append("), cmpNum=");
            sb.append(getCompletedTaskCount());
            return sb.toString();
        }

        int e(String str) {
            return this.d.b(str, this);
        }

        int b(String str) {
            return this.e.a(str, this.d);
        }

        void a(HealthRunnable healthRunnable) {
            super.execute(healthRunnable);
        }

        boolean c(HealthRunnable healthRunnable) {
            return super.remove(healthRunnable);
        }

        void j() {
            super.shutdown();
        }

        List<Runnable> i() {
            return super.shutdownNow();
        }

        int c() {
            return this.j.intValue();
        }

        int d() {
            return this.d.a(this) + this.e.d();
        }

        int a() {
            return getQueue().size();
        }

        int e() {
            return this.e.d();
        }

        String b() {
            if (TextUtils.isEmpty(this.c)) {
                this.c = getThreadFactory().toString();
            }
            return this.c;
        }

        String b(Runnable runnable) {
            if (runnable instanceof HealthRunnable) {
                return ((HealthRunnable) runnable).d();
            }
            return runnable == null ? "" : runnable.toString();
        }

        void e(TaskStatistics taskStatistics) {
            this.g = taskStatistics;
        }

        private TaskStatistics g() {
            TaskStatistics taskStatistics = this.h;
            TaskStatistics taskStatistics2 = this.g;
            if (taskStatistics != taskStatistics2) {
                this.h = taskStatistics2;
            }
            return this.h;
        }

        private TaskStatistics h() {
            return this.h;
        }
    }
}
