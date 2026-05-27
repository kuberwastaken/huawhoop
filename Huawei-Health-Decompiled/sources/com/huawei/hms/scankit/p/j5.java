package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes10.dex */
public class j5 implements f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5996a;
    private final int b;
    private final long c;
    private final long d;
    private final float e;
    private final Interpolator f;

    public j5(int i, int i2, long j, long j2, Interpolator interpolator) {
        this.f5996a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j2 - j;
        this.f = interpolator;
    }

    private int b(w5 w5Var) {
        int i = this.f5996a;
        return i == -1 ? w5Var.a() : i;
    }

    private int a(w5 w5Var) {
        int i = this.b;
        return i == -1 ? w5Var.e() : i;
    }

    private int c(w5 w5Var) {
        return a(w5Var) - b(w5Var);
    }

    @Override // com.huawei.hms.scankit.p.f4
    public void a(w5 w5Var, long j) {
        if (j < this.c || j > this.d || Float.compare(this.e, 0.0f) == 0) {
            return;
        }
        w5Var.a((int) (b(w5Var) + (c(w5Var) * this.f.getInterpolation((j - this.c) / this.e))));
    }
}
