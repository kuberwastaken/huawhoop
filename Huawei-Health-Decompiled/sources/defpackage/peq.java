package defpackage;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes7.dex */
public class peq {
    private pes d;

    peq(pes pesVar) {
        this.d = pesVar;
    }

    public float d() {
        return (this.d.b() - this.d.j()) - this.d.d();
    }

    public float e() {
        return (this.d.i() - this.d.c()) - this.d.e();
    }

    public RectF cKB_() {
        return new RectF(this.d.c(), this.d.j(), this.d.c() + e(), this.d.j() + d());
    }
}
