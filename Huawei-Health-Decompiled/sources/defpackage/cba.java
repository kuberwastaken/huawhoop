package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class cba {
    private long b;
    private long c;
    private int d;

    public void c(long j) {
        this.b = j;
    }

    public void b(long j) {
        this.c = j;
    }

    public long e() {
        return ((Long) kqt.e(Long.valueOf(this.c))).longValue();
    }

    public void a(int i) {
        this.d = i;
    }

    public int d() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public String toString() {
        return "SleepErrorFrame{startTime=" + this.b + ", endTime=" + this.c + ", errorCode=" + this.d + '}';
    }
}
