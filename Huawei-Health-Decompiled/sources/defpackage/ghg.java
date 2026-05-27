package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ghg extends ggz {
    private int k;
    private int n;
    private int q;

    public int u() {
        return this.q;
    }

    public int x() {
        return this.k;
    }

    public int w() {
        return this.n;
    }

    public boolean z() {
        return this.n > 0 && this.k == 0;
    }

    public void e(ggz ggzVar) {
        if (ggzVar.j() > 0 && !ggzVar.s()) {
            this.i += ggzVar.j();
            this.q += ggzVar.j();
            this.k++;
            if (ggzVar.q() > 0) {
                this.g += ggzVar.q();
            }
            if (ggzVar.r() > 0) {
                this.o += ggzVar.r();
            }
            if (ggzVar.y() > 0) {
                this.m += ggzVar.y();
            }
            if (ggzVar.t() > 0) {
                this.l += ggzVar.t();
                return;
            }
            return;
        }
        if (ggzVar.s()) {
            this.n++;
        }
    }

    public void v() {
        if (this.k <= 0) {
            return;
        }
        this.g = Math.round(this.g / this.k);
        this.o = Math.round(this.o / this.k);
        this.i = Math.round(this.i / this.k);
        this.m = Math.round(this.m / this.k);
        this.l = Math.round(this.l / this.k);
    }

    @Override // defpackage.ggz, defpackage.ghd
    public String toString() {
        return "CommonSleepStatData{mSleepDayCount=" + this.k + ", mOnlyNoonCount=" + this.n + ", mSleepTotalTime=" + this.q + '}' + super.toString();
    }
}
