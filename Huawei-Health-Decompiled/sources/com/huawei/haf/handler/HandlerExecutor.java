package com.huawei.haf.handler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerExecutor implements Executor {
    private static final Handler c = new Handler(Looper.getMainLooper());
    private final Handler e;

    public HandlerExecutor() {
        this(c);
    }

    public HandlerExecutor(Handler handler) {
        this.e = handler == null ? c : handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.e.post(runnable)) {
            return;
        }
        throw new RejectedExecutionException(this.e + " is shutting down");
    }

    public static Handler Ak_() {
        return c;
    }

    public static void e(Runnable runnable) {
        if (e()) {
            runnable.run();
        } else {
            d(runnable, 0L);
        }
    }

    public static void b(Runnable runnable) {
        d(runnable, 0L);
    }

    public static void c(Runnable runnable) {
        c.postAtFrontOfQueue(runnable);
    }

    public static void d(Runnable runnable, long j) {
        c.postDelayed(runnable, j);
    }

    public static boolean e() {
        return a();
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static <T> T a(Callable<T> callable) throws Exception {
        if (e()) {
            return callable.call();
        }
        FutureTask futureTask = new FutureTask(callable);
        b(futureTask);
        return (T) futureTask.get();
    }
}
