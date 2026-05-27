package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lvf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15495a;
    private long c;
    private int d;
    private int e;

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.f15495a))).intValue();
    }

    public void e(int i) {
        this.f15495a = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.e))).intValue();
    }

    public void c(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long e() {
        return ((Long) kqt.e(Long.valueOf(this.c))).longValue();
    }

    public void c(long j) {
        this.c = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int a() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public void b(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "[RelaxRecord: relaxScore = " + this.e + ", relaxLength = " + this.f15495a + ", relaxTime = " + this.c + ", relaxType = " + this.d + "]";
    }
}
