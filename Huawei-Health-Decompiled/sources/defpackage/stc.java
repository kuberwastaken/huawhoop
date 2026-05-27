package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class stc implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17836a;
    public long d;
    public long f;
    public long h;
    public long l;
    public int o = -1;
    public int e = -1;
    public int g = -1;
    public int j = -1;
    public int i = -1;
    public int c = -1;
    public int b = -1;

    public long c() {
        return ((Long) veg.a(Long.valueOf(this.l))).longValue();
    }

    public void e(long j) {
        this.l = ((Long) veg.a(Long.valueOf(j))).longValue();
    }

    public long e() {
        return ((Long) veg.a(Long.valueOf(this.h))).longValue();
    }

    public void c(long j) {
        this.h = ((Long) veg.a(Long.valueOf(j))).longValue();
    }

    public void e(int i) {
        this.o = ((Integer) veg.a(Integer.valueOf(i))).intValue();
    }

    public int b() {
        return ((Integer) veg.a(Integer.valueOf(this.o))).intValue();
    }

    public void b(int i) {
        this.e = ((Integer) veg.a(Integer.valueOf(i))).intValue();
    }

    public int d() {
        return ((Integer) veg.a(Integer.valueOf(this.e))).intValue();
    }

    public void d(int i) {
        this.g = ((Integer) veg.a(Integer.valueOf(i))).intValue();
    }

    public int a() {
        return ((Integer) veg.a(Integer.valueOf(this.g))).intValue();
    }

    public void d(long j) {
        this.f = ((Long) veg.a(Long.valueOf(j))).longValue();
    }

    public void a(long j) {
        this.d = ((Long) veg.a(Long.valueOf(j))).longValue();
    }

    public void b(long j) {
        this.f17836a = ((Long) veg.a(Long.valueOf(j))).longValue();
    }

    public String toString() {
        return " FitnessHistogramData mHistogramHeight = " + this.g + "  mStartPoint = " + this.o + "  mEndPoint = " + this.e;
    }
}
