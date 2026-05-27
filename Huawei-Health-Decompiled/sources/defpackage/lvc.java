package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lvc {
    private long b;
    private int d;
    private int e;

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public void b(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int e() {
        return ((Integer) kqt.e(Integer.valueOf(this.e))).intValue();
    }

    public void e(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long b() {
        return ((Long) kqt.e(Long.valueOf(this.b))).longValue();
    }

    public void c(long j) {
        this.b = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public String toString() {
        return "[StressRecord: stressScore = " + this.d + ", stressTime = " + this.b + ", stressTestType = " + this.e + "]";
    }
}
