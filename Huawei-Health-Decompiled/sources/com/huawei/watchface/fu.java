package com.huawei.watchface;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class fu extends ThreadPoolExecutor {
    public fu(int i, int i2, long j, TimeUnit timeUnit) {
        super(i, i2, j, timeUnit, a());
    }

    protected static PriorityBlockingQueue<Runnable> a() {
        return new PriorityBlockingQueue<>();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new fs(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new fs(callable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        a(0, runnable);
    }

    public void a(int i, Runnable runnable) {
        if (runnable instanceof fs) {
            super.execute(runnable);
        } else {
            super.execute(c(i, runnable));
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return b(0, runnable);
    }

    public Future<?> b(int i, Runnable runnable) {
        return super.submit(c(i, runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return a(0, runnable, t);
    }

    public <T> Future<T> a(int i, Runnable runnable, T t) {
        return super.submit(c(i, runnable), t);
    }

    private ft c(int i, Runnable runnable) {
        if (runnable instanceof ft) {
            return (ft) runnable;
        }
        return new ft(runnable, i);
    }
}
