package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class yec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f19272a;
    private final int b;
    private long d;
    private long c = 0;
    private long e = 0;

    public yec(int i, long j) {
        this.b = i;
        this.d = j;
    }

    public long e(long j) {
        long jRound;
        if (this.f19272a) {
            jRound = Math.round((this.e * 0.875d) + (Math.abs(this.c - j) * 0.125d));
            j = Math.round((this.c * 0.75d) + (j * 0.25d));
        } else {
            this.f19272a = true;
            jRound = j / 2;
        }
        this.c = j;
        this.e = jRound;
        long jMax = j + Math.max(100L, ((long) this.b) * jRound);
        this.d = jMax;
        return jMax;
    }
}
