package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class nnm extends ThreadPoolExecutor {
    public nnm(int i, int i2, long j, TimeUnit timeUnit) {
        super(i, i2, j, timeUnit, a());
    }

    protected static PriorityBlockingQueue<Runnable> a() {
        return new PriorityBlockingQueue<>();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new nnq(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new nnq(callable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        d(0, runnable);
    }

    public void d(int i, Runnable runnable) {
        if (runnable instanceof nnq) {
            super.execute(runnable);
        } else {
            super.execute(b(i, runnable));
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return e(0, runnable);
    }

    public Future<?> e(int i, Runnable runnable) {
        return super.submit(b(i, runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return d(0, runnable, t);
    }

    public <T> Future<T> d(int i, Runnable runnable, T t) {
        return super.submit(b(i, runnable), t);
    }

    private nno b(int i, Runnable runnable) {
        if (runnable instanceof nno) {
            return (nno) runnable;
        }
        return new nno(runnable, i);
    }
}
