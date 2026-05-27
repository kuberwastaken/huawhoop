package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12127a;
    private int b;
    private int c;
    private long d;
    private int e;

    public dao(int i, long j, long j2, int i2, int i3) {
        this.c = i;
        this.f12127a = j;
        this.d = j2;
        this.b = i2;
        this.e = i3;
    }

    public long e() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String toString() {
        return "XiaomiStep{mId=" + this.c + ", mBeginTime=" + this.f12127a + ", mEndTime=" + this.d + ", mMode=" + this.b + ", mSteps=" + this.e + '}';
    }
}
