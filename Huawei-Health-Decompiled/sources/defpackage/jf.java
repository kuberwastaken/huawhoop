package defpackage;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes3.dex */
public class jf<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f14389a;
    public final Interpolator b;
    public PointF c;
    public PointF d;
    public Float e;
    public final Interpolator f;
    public final float g;
    public final T h;
    public final Interpolator i;
    private final cx j;
    private int k;
    private float l;
    private float m;
    private float n;
    private float o;
    private int p;

    public jf(cx cxVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.n = -3987645.8f;
        this.l = -3987645.8f;
        this.p = 784923401;
        this.k = 784923401;
        this.o = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.d = null;
        this.c = null;
        this.j = cxVar;
        this.h = t;
        this.f14389a = t2;
        this.b = interpolator;
        this.f = null;
        this.i = null;
        this.g = f;
        this.e = f2;
    }

    public jf(cx cxVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.n = -3987645.8f;
        this.l = -3987645.8f;
        this.p = 784923401;
        this.k = 784923401;
        this.o = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.d = null;
        this.c = null;
        this.j = cxVar;
        this.h = t;
        this.f14389a = t2;
        this.b = null;
        this.f = interpolator;
        this.i = interpolator2;
        this.g = f;
        this.e = f2;
    }

    protected jf(cx cxVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.n = -3987645.8f;
        this.l = -3987645.8f;
        this.p = 784923401;
        this.k = 784923401;
        this.o = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.d = null;
        this.c = null;
        this.j = cxVar;
        this.h = t;
        this.f14389a = t2;
        this.b = interpolator;
        this.f = interpolator2;
        this.i = interpolator3;
        this.g = f;
        this.e = f2;
    }

    public jf(T t) {
        this.n = -3987645.8f;
        this.l = -3987645.8f;
        this.p = 784923401;
        this.k = 784923401;
        this.o = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.d = null;
        this.c = null;
        this.j = null;
        this.h = t;
        this.f14389a = t;
        this.b = null;
        this.f = null;
        this.i = null;
        this.g = Float.MIN_VALUE;
        this.e = Float.valueOf(Float.MAX_VALUE);
    }

    private jf(T t, T t2) {
        this.n = -3987645.8f;
        this.l = -3987645.8f;
        this.p = 784923401;
        this.k = 784923401;
        this.o = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.d = null;
        this.c = null;
        this.j = null;
        this.h = t;
        this.f14389a = t2;
        this.b = null;
        this.f = null;
        this.i = null;
        this.g = Float.MIN_VALUE;
        this.e = Float.valueOf(Float.MAX_VALUE);
    }

    public jf<T> a(T t, T t2) {
        return new jf<>(t, t2);
    }

    public float j() {
        cx cxVar = this.j;
        if (cxVar == null) {
            return 0.0f;
        }
        if (this.o == Float.MIN_VALUE) {
            this.o = (this.g - cxVar.k()) / this.j.a();
        }
        return this.o;
    }

    public float c() {
        if (this.j == null) {
            return 1.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            if (this.e == null) {
                this.m = 1.0f;
            } else {
                this.m = j() + ((this.e.floatValue() - this.g) / this.j.a());
            }
        }
        return this.m;
    }

    public boolean i() {
        return this.b == null && this.f == null && this.i == null;
    }

    public boolean a(float f) {
        return f >= j() && f < c();
    }

    public float g() {
        if (this.n == -3987645.8f) {
            this.n = ((Float) this.h).floatValue();
        }
        return this.n;
    }

    public float a() {
        if (this.l == -3987645.8f) {
            this.l = ((Float) this.f14389a).floatValue();
        }
        return this.l;
    }

    public int h() {
        if (this.p == 784923401) {
            this.p = ((Integer) this.h).intValue();
        }
        return this.p;
    }

    public int b() {
        if (this.k == 784923401) {
            this.k = ((Integer) this.f14389a).intValue();
        }
        return this.k;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.h + ", endValue=" + this.f14389a + ", startFrame=" + this.g + ", endFrame=" + this.e + ", interpolator=" + this.b + '}';
    }
}
