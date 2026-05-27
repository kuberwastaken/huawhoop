package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pxn {
    private boolean d = false;
    private boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16939a = 0;

    public boolean d() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public boolean b() {
        return this.c;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public int c() {
        return this.f16939a;
    }

    public void e(int i) {
        this.f16939a = i;
    }

    public String toString() {
        return "WalletSatcomCardInfo{mIsSupportSatcomCard=" + this.d + ", mHasOpenedSatcomCard=" + this.c + ", mActivityPeriod=" + this.f16939a + '}';
    }
}
