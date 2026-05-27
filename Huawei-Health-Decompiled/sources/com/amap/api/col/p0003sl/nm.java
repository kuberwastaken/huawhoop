package com.amap.api.col.p0003sl;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class nm extends ni implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;

    public nm() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    public nm(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003sl.ni
    /* JADX INFO: renamed from: a */
    public final ni clone() {
        nm nmVar = new nm(this.h, this.i);
        nmVar.a(this);
        nmVar.j = this.j;
        nmVar.k = this.k;
        nmVar.l = this.l;
        nmVar.m = this.m;
        return nmVar;
    }

    @Override // com.amap.api.col.p0003sl.ni
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + ", mcc='" + this.f1299a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
