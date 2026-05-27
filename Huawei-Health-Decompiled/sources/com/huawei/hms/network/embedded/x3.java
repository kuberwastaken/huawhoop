package com.huawei.hms.network.embedded;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5754a;
    public long b;
    public long c;

    public long timeoutNanos() {
        return this.c;
    }

    public x3 timeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.c = timeUnit.toNanos(j);
        return this;
    }

    public boolean hasDeadline() {
        return this.f5754a;
    }

    public x3 deadlineNanoTime(long j) {
        this.f5754a = true;
        this.b = j;
        return this;
    }

    public long deadlineNanoTime() {
        if (this.f5754a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public final x3 deadline(long j, TimeUnit timeUnit) {
        if (j > 0) {
            if (timeUnit != null) {
                return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("duration <= 0: " + j);
    }

    public x3 clearTimeout() {
        this.c = 0L;
        return this;
    }

    public x3 clearDeadline() {
        this.f5754a = false;
        return this;
    }
}
