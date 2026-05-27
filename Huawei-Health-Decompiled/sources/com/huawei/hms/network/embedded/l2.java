package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class l2 implements Executor {
    public static final String i = "MessageLoop";
    public static final long j = -1;
    public static final /* synthetic */ boolean k = true;
    public boolean b;
    public boolean c;
    public InterruptedIOException d;
    public RuntimeException e;
    public long f = -1;
    public boolean g = false;
    public long h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue<Runnable> f5544a = new LinkedBlockingQueue();

    public void updateLoopTimer(long j2) {
        this.g = true;
        long jCurrentTimeMillis = j2 + System.currentTimeMillis();
        this.h = jCurrentTimeMillis;
        Logger.d(i, "updateWriteTimer : %d", Long.valueOf(jCurrentTimeMillis));
    }

    public void quit() {
        if (!k && !a()) {
            throw new AssertionError();
        }
        this.b = false;
    }

    public void loop(int i2) throws IOException {
        Runnable runnableA;
        if (!k && !a()) {
            throw new AssertionError();
        }
        long jNanoTime = System.nanoTime();
        long jConvert = TimeUnit.NANOSECONDS.convert(i2, TimeUnit.MILLISECONDS);
        if (this.c) {
            InterruptedIOException interruptedIOException = this.d;
            if (interruptedIOException == null) {
                throw this.e;
            }
            throw interruptedIOException;
        }
        if (this.b) {
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        this.b = true;
        while (this.b) {
            if (i2 == 0) {
                try {
                    runnableA = a(false, 0L);
                } catch (InterruptedIOException e) {
                    Logger.d(i, e.getMessage());
                    if (this.g) {
                        long jConvert2 = TimeUnit.NANOSECONDS.convert(this.h - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
                        Logger.d(i, "loop updateWriteTimer : %d", Long.valueOf(jConvert2));
                        if (jConvert2 > 0) {
                            jNanoTime = System.nanoTime();
                            this.g = false;
                            jConvert = jConvert2;
                        }
                    }
                    this.b = false;
                    this.c = true;
                    this.d = e;
                    throw e;
                } catch (RuntimeException e2) {
                    this.b = false;
                    this.c = true;
                    this.e = e2;
                    throw e2;
                }
            } else {
                runnableA = a(true, (jConvert - System.nanoTime()) + jNanoTime);
            }
            runnableA.run();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        if (runnable == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f5544a.put(runnable);
        } catch (InterruptedException e) {
            throw new RejectedExecutionException(e);
        }
    }

    private boolean a() {
        long j2 = this.f;
        if (j2 != -1) {
            return j2 == Thread.currentThread().getId();
        }
        this.f = Thread.currentThread().getId();
        return true;
    }

    private Runnable a(boolean z, long j2) throws InterruptedIOException {
        try {
            Runnable runnableTake = !z ? this.f5544a.take() : this.f5544a.poll(j2, TimeUnit.NANOSECONDS);
            if (runnableTake != null) {
                return runnableTake;
            }
            throw new SocketTimeoutException("loop timeout");
        } catch (InterruptedException e) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e);
            throw interruptedIOException;
        }
    }
}
