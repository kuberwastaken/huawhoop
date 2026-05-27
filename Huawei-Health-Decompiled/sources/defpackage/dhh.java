package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dhh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12250a;
    private int c;
    private int d;
    private int e;

    public int a() {
        return this.d;
    }

    public void a(int i) {
        if (i == 65535) {
            this.d = -1;
        } else {
            this.d = i;
        }
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        if (i == 65535) {
            this.c = -1;
        } else {
            this.c = i;
        }
    }

    public int d() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int b() {
        return this.f12250a;
    }

    public void e(int i) {
        this.f12250a = i;
    }

    public String toString() {
        return "RopeSkippingTrick{mSingleTrickNum=" + this.f12250a + ", mDoubleTrickNum=" + this.e + ", mMultipleTrickNum=" + this.c + ", mReverseTrickNum=" + this.d + '}';
    }
}
