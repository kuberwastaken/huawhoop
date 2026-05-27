package com.huawei.hms.network.file.a;

import android.os.SystemClock;
import com.huawei.hms.network.file.core.util.FLogger;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5792a;
    long b;
    long c;
    long d;

    public int a(int i) {
        if (i < 0) {
            return 0;
        }
        if (this.c == 0) {
            this.c = SystemClock.elapsedRealtime();
        }
        long j = i;
        if (j > this.b) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = (int) (((jElapsedRealtime - this.c) / 1000.0d) * ((double) this.f5792a));
            if (j2 < 0) {
                j2 = this.d;
            }
            if (j2 > 0) {
                long j3 = this.b + j2;
                this.b = j3 < 0 ? this.d : Math.min(j3, this.d);
                this.c = jElapsedRealtime;
            }
            long j4 = this.b;
            if (j > j4) {
                long j5 = (j - j4) + 1;
                long j6 = (long) ((j5 * 1000.0d) / ((double) this.f5792a));
                if (j6 <= 0) {
                    j6 = 10;
                }
                try {
                    Thread.sleep(j6);
                    this.b += j5;
                    this.c = SystemClock.elapsedRealtime();
                } catch (InterruptedException unused) {
                    FLogger.e("TokenBucketSpeedLimiter", "acquireSync InterruptedException");
                    return 0;
                }
            }
        }
        this.b -= j;
        return i;
    }

    public i(int i) {
        this.f5792a = i;
        this.d = ((long) i) * 2;
    }
}
