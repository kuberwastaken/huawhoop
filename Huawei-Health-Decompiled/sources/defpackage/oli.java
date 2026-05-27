package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class oli {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16429a;
    private float b;
    private boolean c;
    private float d;
    private float e;
    private boolean g;
    private boolean h;
    private float i;
    private float j;

    public void b(float f, float f2, boolean z, float f3, boolean z2, float f4, float f5, boolean z3, float f6) {
        this.j = f;
        this.i = f2;
        this.h = z;
        if (f3 == 0.0f) {
            f3 = 1.0f;
        }
        this.d = f3;
        this.g = z2;
        if (f4 == 0.0f) {
            f4 = 1.0f;
        }
        this.b = f4;
        if (f5 == 0.0f) {
            f5 = 1.0f;
        }
        this.e = f5;
        this.c = z3;
        this.f16429a = f6;
    }

    protected void c(float f, float f2, float f3, float f4, float f5, float f6) {
        this.j = f;
        this.i = f2;
        if (f3 == 0.0f) {
            f3 = 1.0f;
        }
        this.d = f3;
        if (f4 == 0.0f) {
            f4 = 1.0f;
        }
        this.b = f4;
        if (f5 == 0.0f) {
            f5 = 1.0f;
        }
        this.e = f5;
        this.f16429a = f6;
    }

    public float h() {
        return this.i;
    }

    public float e() {
        return this.j;
    }

    public float b() {
        if (this.g) {
            return this.b;
        }
        return 1.0f;
    }

    public float a() {
        if (this.h) {
            return this.d;
        }
        return 1.0f;
    }

    public float d() {
        if (this.c) {
            return this.f16429a;
        }
        return 0.0f;
    }

    public float c() {
        if (this.g) {
            return this.e;
        }
        return 1.0f;
    }

    public boolean f() {
        return this.h;
    }

    public boolean i() {
        return this.g;
    }

    public boolean g() {
        return this.c;
    }
}
