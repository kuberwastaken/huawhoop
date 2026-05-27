package com.huawei.hms.network.file.core.util;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5830a;
    private long b;
    private long c = 0;
    private long d = -1;

    public long a() {
        long jB;
        long j;
        long j2;
        long j3;
        synchronized (this) {
            jB = b();
            if (jB < this.d || jB < 1418357532000L) {
                FLogger.w("SnowFlakeGen", "time changed ,nextId may conflicted. currTimeStamp:" + jB + ", lastTimeStamp:" + this.d + ",START_TIMESTAMP:1418357532000", new Object[0]);
            }
            long j4 = (this.c + 1) & 4095;
            this.c = j4;
            if (j4 == 0 && this.d == jB) {
                FLogger.w("SnowFlakeGen", "nextId for nextMill, currTimeStamp :" + jB, new Object[0]);
                jB = c();
            }
            this.d = jB;
            FLogger.v("SnowFlakeGen", "nextId, processId:" + this.f5830a + ",randomId:" + this.b + ",sequence:" + this.c);
            j = this.f5830a;
            j2 = this.b;
            j3 = this.c;
        }
        return ((jB - 1418357532000L) << 22) | (j << 17) | (j2 << 12) | j3;
    }

    private long c() {
        long jB;
        do {
            jB = b();
        } while (jB <= this.d);
        return jB;
    }

    private long b() {
        return System.currentTimeMillis();
    }

    public g(long j, long j2) {
        this.f5830a = j & 31;
        this.b = j2 & 31;
    }
}
