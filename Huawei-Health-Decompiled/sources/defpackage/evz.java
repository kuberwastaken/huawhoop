package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class evz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12802a;
    private float b;
    private float c;
    private float d;
    private float e;
    private String f;
    private boolean g;
    private float h;
    private double i;
    private double j;

    public void c(boolean z) {
        this.g = z;
    }

    public void b(double d) {
        this.i = d;
    }

    public void d(double d) {
        this.j = d;
    }

    public boolean f() {
        return this.g;
    }

    public String h() {
        return this.f;
    }

    public long g() {
        return this.f12802a;
    }

    public double j() {
        return this.i;
    }

    public double i() {
        return this.j;
    }

    public float d() {
        return this.h;
    }

    public float b() {
        return this.d;
    }

    public float e() {
        return this.b;
    }

    public float a() {
        return this.e;
    }

    public float c() {
        return this.c;
    }

    public evz(evz evzVar) {
        this.h = 0.0f;
        this.g = false;
        if (evzVar != null) {
            this.i = evzVar.j();
            this.j = evzVar.i();
            this.c = evzVar.c();
            this.d = evzVar.b();
            this.e = evzVar.a();
            this.b = evzVar.e();
            this.f12802a = evzVar.g();
            this.f = evzVar.h();
            this.h = evzVar.d();
        }
    }

    public evz(double d, double d2, float f, float f2, float f3, float f4, long j, String str) {
        this.h = 0.0f;
        this.g = false;
        this.i = d2;
        this.j = d;
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.b = f4;
        this.f12802a = j;
        this.f = str;
    }

    public evz() {
        this.h = 0.0f;
        this.g = false;
    }
}
