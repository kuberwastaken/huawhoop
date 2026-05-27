package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class kpv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14829a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;

    public kpv(boolean[] zArr) {
        if (zArr == null || zArr.length != 8) {
            return;
        }
        this.d = zArr[0];
        this.c = zArr[1];
        this.b = zArr[2];
        this.f14829a = zArr[3];
        this.e = zArr[4];
        this.f = zArr[5];
        this.g = zArr[6];
        this.h = zArr[7];
    }

    public boolean a() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.d))).booleanValue();
    }

    public boolean c() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.c))).booleanValue();
    }

    public boolean e() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.b))).booleanValue();
    }

    public boolean d() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.f14829a))).booleanValue();
    }

    public boolean b() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.e))).booleanValue();
    }

    public boolean f() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.f))).booleanValue();
    }

    public boolean i() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.g))).booleanValue();
    }

    public boolean g() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.h))).booleanValue();
    }
}
