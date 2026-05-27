package com.amap.api.col.p0003sl;

import com.autonavi.amap.mapcore.DPoint;

/* JADX INFO: loaded from: classes9.dex */
public final class dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f903a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public dk(double d, double d2, double d3, double d4) {
        this.f903a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public final boolean a(double d, double d2) {
        return this.f903a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public final boolean a(DPoint dPoint) {
        return a(dPoint.x, dPoint.y);
    }

    private boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.f903a < d2 && d3 < this.d && this.b < d4;
    }

    public final boolean a(dk dkVar) {
        return a(dkVar.f903a, dkVar.c, dkVar.b, dkVar.d);
    }

    public final boolean b(dk dkVar) {
        return dkVar.f903a >= this.f903a && dkVar.c <= this.c && dkVar.b >= this.b && dkVar.d <= this.d;
    }
}
