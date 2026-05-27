package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class irs implements Serializable {
    private static final long serialVersionUID = -1029604556087330774L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14231a;
    private float b;
    private long c;
    private float d;
    private float e;
    private float f;
    private double g;
    private double h;
    private boolean i;
    private boolean j;
    private String n;

    public irs() {
        this.f = 0.0f;
        this.j = false;
        this.i = false;
    }

    public irs(double d, double d2, float f, float f2, float f3, float f4, long j, String str) {
        this.f = 0.0f;
        this.j = false;
        this.i = false;
        this.g = d2;
        this.h = d;
        this.f14231a = f;
        this.e = f2;
        this.b = f3;
        this.d = f4;
        this.c = j;
        this.n = str;
    }

    public irs(irs irsVar) {
        this.f = 0.0f;
        this.j = false;
        this.i = false;
        if (irsVar != null) {
            this.g = irsVar.i();
            this.h = irsVar.j();
            this.f14231a = irsVar.e();
            this.e = irsVar.d();
            this.b = irsVar.a();
            this.d = irsVar.c();
            this.c = irsVar.h();
            this.n = irsVar.f();
            this.f = irsVar.b();
        }
    }

    public long h() {
        return this.c;
    }

    public float e() {
        return this.f14231a;
    }

    public void c(double d) {
        this.h = d;
    }

    public void e(double d) {
        this.g = d;
    }

    public double j() {
        return this.h;
    }

    public double i() {
        return this.g;
    }

    public float d() {
        return this.e;
    }

    public float a() {
        return this.b;
    }

    public float c() {
        return this.d;
    }

    public String f() {
        return this.n;
    }

    public boolean g() {
        return this.j;
    }

    public void d(boolean z) {
        this.j = z;
    }

    public float b() {
        return this.f;
    }

    public void d(float f) {
        this.f = f;
    }
}
