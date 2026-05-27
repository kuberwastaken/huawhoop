package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class lo extends lr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f1221a;
    private boolean b;

    public lo() {
        this.f1221a = new StringBuilder();
        this.b = true;
    }

    public lo(lr lrVar) {
        super(lrVar);
        this.f1221a = new StringBuilder();
        this.b = true;
    }

    @Override // com.amap.api.col.p0003sl.lr
    protected final byte[] a(byte[] bArr) {
        byte[] bArrA = iy.a(this.f1221a.toString());
        this.d = bArrA;
        this.b = true;
        StringBuilder sb = this.f1221a;
        sb.delete(0, sb.length());
        return bArrA;
    }

    @Override // com.amap.api.col.p0003sl.lr
    public final void b(byte[] bArr) {
        String strA = iy.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.f1221a.append(",");
        }
        StringBuilder sb = this.f1221a;
        sb.append("{\"log\":\"");
        sb.append(strA);
        sb.append("\"}");
    }
}
