package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes10.dex */
public final class g3 extends u6 {
    private final float e;
    private final int f;

    g3(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    public float e() {
        return this.e;
    }

    @Override // com.huawei.hms.scankit.p.u6
    public int a() {
        return this.f;
    }

    private g3(float f, float f2, float f3, int i) {
        super(f, f2);
        this.e = f3;
        this.f = i;
    }

    boolean b(float f, float f2, float f3) {
        if (Math.abs(f2 - c()) <= f && Math.abs(f3 - b()) <= f) {
            float fAbs = Math.abs(f - this.e);
            if (fAbs <= 1.0f || fAbs <= this.e) {
                return true;
            }
        }
        return false;
    }

    g3 c(float f, float f2, float f3) {
        int i = this.f;
        int i2 = i + 1;
        float f4 = i2;
        return new g3(((i * b()) + f2) / f4, ((this.f * c()) + f) / f4, ((this.f * this.e) + f3) / f4, i2);
    }
}
