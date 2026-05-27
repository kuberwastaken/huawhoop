package defpackage;

import health.compact.a.UnitUtil;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ghd implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f13458a;
    protected int b;
    protected long c;
    protected long d;
    protected long e;
    protected String f = "";
    protected int h;
    protected int i;
    protected long j;

    public boolean s() {
        int i = this.i;
        return i < 180 && i > 0;
    }

    public int g() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public int o() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public int j() {
        return this.i;
    }

    public void e(int i) {
        this.i = i;
    }

    public long f() {
        return this.d;
    }

    public void e(long j) {
        this.d = j;
    }

    public long c() {
        return this.e;
    }

    public int a() {
        long j = this.e;
        if (j > 0) {
            long j2 = this.d;
            if (j2 > 0) {
                return gfw.c(j, gfw.b(j2, this.f, -1));
            }
        }
        return -1;
    }

    public void c(long j) {
        this.e = j;
    }

    public long k() {
        return this.j;
    }

    public int m() {
        long j = this.j;
        if (j > 0) {
            long j2 = this.d;
            if (j2 > 0) {
                return gfw.c(j, gfw.b(j2, this.f, -1));
            }
        }
        return -1;
    }

    public void d(long j) {
        this.j = j;
    }

    public long d() {
        return this.f13458a;
    }

    public int i() {
        long j = this.f13458a;
        if (j > 0) {
            long j2 = this.d;
            if (j2 > 0) {
                return gfw.c(j, gfw.b(j2, this.f, -1));
            }
        }
        return -1;
    }

    public void a(long j) {
        this.f13458a = j;
    }

    public long b() {
        return this.c;
    }

    public int e() {
        long j = this.c;
        if (j > 0) {
            long j2 = this.d;
            if (j2 > 0) {
                return gfw.c(j, gfw.b(j2, this.f, -1));
            }
        }
        return -1;
    }

    public void b(long j) {
        this.c = j;
    }

    public String n() {
        return this.f;
    }

    public void a(String str) {
        this.f = str;
    }

    public boolean l() {
        return this.i > 0;
    }

    public int h() {
        int i;
        if (this.i < 0 || (i = this.h) <= 0) {
            return -1;
        }
        return (int) UnitUtil.c((r0 / i) * 100.0f, 0);
    }

    public String toString() {
        return "BaseSleepData{mSleepTime=" + this.i + ", mFallAsSleepTime=" + this.e + ", mWakeupTime=" + this.j + ", mRisingTime=" + this.f13458a + ", mGoBedTime=" + this.c + ", mTimeZone='" + this.f + "', mSleepDayTime=" + this.d + ", mStayInBedTime=" + this.h + ", mSleepLatencyTime=" + this.b + ", getFallAsSleepTimeOffset=" + a() + ", getGoBedTimeOffset=" + e() + ", getRisingTimeOffset=" + i() + ", getWakeupTimeOffset=" + m() + ", getSleepEfficiency=" + h() + '}';
    }
}
