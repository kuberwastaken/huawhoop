package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class lx {
    lx c;

    protected abstract boolean c();

    public lx() {
    }

    public lx(lx lxVar) {
        this.c = lxVar;
    }

    public void a_(boolean z) {
        lx lxVar = this.c;
        if (lxVar != null) {
            lxVar.a_(z);
        }
    }

    public int a() {
        lx lxVar = this.c;
        return Math.min(Integer.MAX_VALUE, lxVar != null ? lxVar.a() : Integer.MAX_VALUE);
    }

    public void a_(int i) {
        lx lxVar = this.c;
        if (lxVar != null) {
            lxVar.a_(i);
        }
    }

    public final boolean d() {
        lx lxVar = this.c;
        if (lxVar == null || lxVar.d()) {
            return c();
        }
        return false;
    }
}
