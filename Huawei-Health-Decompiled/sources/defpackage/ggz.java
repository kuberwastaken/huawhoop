package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ggz extends ghd {
    protected int g;
    protected int l;
    protected int m;
    protected int o;

    public int y() {
        return this.m;
    }

    public void j(int i) {
        this.m = i;
    }

    public int t() {
        return this.l;
    }

    public void f(int i) {
        this.l = i;
    }

    public int q() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public int p() {
        if (this.g < 0 || this.i <= 0) {
            return -1;
        }
        return Math.round((this.g * 100.0f) / this.i);
    }

    public int r() {
        return this.o;
    }

    public void c(int i) {
        this.o = i;
    }

    @Override // defpackage.ghd
    public String toString() {
        return "CommonSleepData{mWakeupTimes=" + this.l + ", mDeepSleepTime=" + this.g + ", mShallowSleepTime=" + this.o + '}' + super.toString();
    }
}
