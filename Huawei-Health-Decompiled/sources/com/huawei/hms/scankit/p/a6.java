package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes10.dex */
public class a6 implements g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5923a;
    private final float b;

    public a6(float f, float f2) {
        this.b = f;
        this.f5923a = f2;
    }

    @Override // com.huawei.hms.scankit.p.g4
    public void a(w5 w5Var) {
        float fA = this.f5923a;
        float f = this.b;
        if (fA != f) {
            fA = n6.a(fA - f) + this.b;
        }
        w5Var.b(fA);
        w5Var.a(fA);
    }
}
