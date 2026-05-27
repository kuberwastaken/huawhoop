package defpackage;

import android.content.Context;
import android.graphics.Rect;
import com.huawei.ui.commonui.linechart.anchor.Layout;

/* JADX INFO: loaded from: classes7.dex */
public class pfm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Layout f16676a;
    private Context b;

    public pfm(Context context, Layout layout) {
        this.b = context;
        this.f16676a = layout;
    }

    public float e() {
        float f;
        int i;
        if ((!this.f16676a.h && !pfy.d(this.b)) || (this.f16676a.h && pfy.d(this.b))) {
            f = this.f16676a.c + this.f16676a.b;
            i = this.f16676a.l;
        } else {
            f = this.f16676a.k + this.f16676a.m;
            i = this.f16676a.l;
        }
        return f + i;
    }

    public float i() {
        return this.f16676a.r + this.f16676a.n + this.f16676a.j + this.f16676a.e;
    }

    public float b() {
        float f;
        int i;
        if ((!this.f16676a.h && !pfy.d(this.b)) || (this.f16676a.h && pfy.d(this.b))) {
            f = this.f16676a.k + this.f16676a.m;
            i = this.f16676a.s;
        } else {
            f = this.f16676a.c + this.f16676a.b;
            i = this.f16676a.s;
        }
        return f + i;
    }

    public float d() {
        float f = this.f16676a.w + this.f16676a.u + this.f16676a.f + this.f16676a.x + this.f16676a.v + this.f16676a.q + this.f16676a.o;
        float f2 = this.f16676a.p + this.f16676a.t + this.f16676a.o;
        return f2 > f ? f2 : f;
    }

    public float f() {
        return this.f16676a.l + this.f16676a.g;
    }

    public float j() {
        return (h() - this.f16676a.i) - this.f16676a.s;
    }

    private float h() {
        return this.f16676a.l + this.f16676a.m + this.f16676a.k + this.f16676a.d + this.f16676a.b + this.f16676a.c + this.f16676a.s;
    }

    public Rect cMb_() {
        return new Rect(this.f16676a.l, (int) (this.f16676a.r + this.f16676a.n), (int) (this.f16676a.l + this.f16676a.c + this.f16676a.b + this.f16676a.d + this.f16676a.k + this.f16676a.m), (int) (this.f16676a.r + this.f16676a.n + this.f16676a.j));
    }

    public Rect cMa_() {
        return new Rect(this.f16676a.l, (int) (this.f16676a.r + this.f16676a.n + this.f16676a.j + this.f16676a.e + this.f16676a.f9208a + this.f16676a.p), (int) (this.f16676a.l + this.f16676a.c + this.f16676a.b + this.f16676a.d + this.f16676a.k + this.f16676a.m), (int) (this.f16676a.r + this.f16676a.n + this.f16676a.j + this.f16676a.e + this.f16676a.f9208a + this.f16676a.p + this.f16676a.t));
    }

    public float g() {
        return this.f16676a.f9208a;
    }
}
