package defpackage;

import com.huawei.hihealth.ResultUtils;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class fcg implements Serializable {
    public long d;
    public long e;
    public long i;
    private long k;
    private long n;
    public int f = -1;
    public int b = -1;
    public int g = -1;
    public int h = -1;
    public int j = -1;
    public int c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12895a = -1;

    public void b(int i) {
        this.f = ((Integer) ResultUtils.d(Integer.valueOf(i))).intValue();
    }

    public int b() {
        return ((Integer) ResultUtils.d(Integer.valueOf(this.f))).intValue();
    }

    public void e(int i) {
        this.b = ((Integer) ResultUtils.d(Integer.valueOf(i))).intValue();
    }

    public int a() {
        return ((Integer) ResultUtils.d(Integer.valueOf(this.b))).intValue();
    }

    public void d(int i) {
        this.g = ((Integer) ResultUtils.d(Integer.valueOf(i))).intValue();
    }

    public int e() {
        return ((Integer) ResultUtils.d(Integer.valueOf(this.g))).intValue();
    }

    public long c() {
        return ((Long) ResultUtils.d(Long.valueOf(this.n))).longValue();
    }

    public void a(long j) {
        this.n = ((Long) ResultUtils.d(Long.valueOf(j))).longValue();
    }

    public long d() {
        return ((Long) ResultUtils.d(Long.valueOf(this.k))).longValue();
    }

    public void e(long j) {
        this.k = ((Long) ResultUtils.d(Long.valueOf(j))).longValue();
    }

    public String toString() {
        return " FitnessHistogramData mHistogramHeight = " + this.g + "  mStartPoint = " + this.f + "  mEndPoint = " + this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fcg fcgVar = (fcg) obj;
        return this.f == fcgVar.f && this.b == fcgVar.b && this.g == fcgVar.g && this.h == fcgVar.h && this.j == fcgVar.j && this.c == fcgVar.c && this.f12895a == fcgVar.f12895a && this.i == fcgVar.i && this.d == fcgVar.d && this.e == fcgVar.e;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f), Integer.valueOf(this.b), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.j), Integer.valueOf(this.c), Integer.valueOf(this.f12895a), Long.valueOf(this.i), Long.valueOf(this.d), Long.valueOf(this.e));
    }
}
