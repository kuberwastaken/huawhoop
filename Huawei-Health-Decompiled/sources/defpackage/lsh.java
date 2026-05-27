package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lsh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15432a;
    private double[] e;

    public long c() {
        return ((Long) kqt.e(Long.valueOf(this.f15432a))).longValue();
    }

    public void d(long j) {
        this.f15432a = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public double[] a() {
        double[] dArr = this.e;
        return dArr == null ? dArr : (double[]) kqt.e((double[]) dArr.clone());
    }

    public void c(double[] dArr) {
        if (dArr != null) {
            this.e = (double[]) kqt.e((double[]) dArr.clone());
        }
    }
}
