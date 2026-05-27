package com.amap.api.col.p0003sl;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class nk extends ni implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public nk() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    public nk(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003sl.ni
    /* JADX INFO: renamed from: a */
    public final ni clone() {
        nk nkVar = new nk(this.h, this.i);
        nkVar.a(this);
        nkVar.j = this.j;
        nkVar.k = this.k;
        nkVar.l = this.l;
        nkVar.m = this.m;
        nkVar.n = this.n;
        nkVar.o = this.o;
        return nkVar;
    }

    @Override // com.amap.api.col.p0003sl.ni
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + ", mcc='" + this.f1299a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
