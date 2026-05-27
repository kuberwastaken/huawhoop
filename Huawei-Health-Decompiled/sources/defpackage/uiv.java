package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class uiv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f18324a;
    private boolean b;
    private boolean c;
    private boolean d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean l;
    private boolean m;
    private boolean n;

    public void d(String str) {
        this.e = str;
    }

    public boolean j() {
        return this.j;
    }

    public void f(boolean z) {
        this.j = z;
    }

    public boolean f() {
        return this.g;
    }

    public void h(boolean z) {
        this.g = z;
    }

    public boolean c() {
        return this.h;
    }

    public void d(boolean z) {
        this.h = z;
    }

    public boolean b() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public boolean h() {
        return this.f;
    }

    public void j(boolean z) {
        this.f = z;
    }

    public boolean m() {
        return this.l;
    }

    public void m(boolean z) {
        this.l = z;
    }

    public boolean g() {
        return this.i;
    }

    public void g(boolean z) {
        this.i = z;
    }

    public boolean i() {
        return this.m;
    }

    public void i(boolean z) {
        this.m = z;
    }

    public boolean a() {
        return this.d;
    }

    public void e(boolean z) {
        this.d = z;
    }

    public boolean d() {
        return this.b;
    }

    public void c(boolean z) {
        this.b = z;
    }

    public boolean e() {
        return this.f18324a;
    }

    public void a(boolean z) {
        this.f18324a = z;
    }

    public boolean k() {
        return this.n;
    }

    public void k(boolean z) {
        this.n = z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ShowDataBean{ deviceUniqueCode=");
        stringBuffer.append(this.e);
        stringBuffer.append(", isStep=").append(this.j);
        stringBuffer.append(", isDistance=").append(this.g);
        stringBuffer.append(", isClimbStair=").append(this.h);
        stringBuffer.append(", isCalorie=").append(this.c);
        stringBuffer.append(", isHeartRate=").append(this.f);
        stringBuffer.append(", isWeight=").append(this.l);
        stringBuffer.append(", isSleep=").append(this.i);
        stringBuffer.append(", isStress=").append(this.m);
        stringBuffer.append(", isBloodOxygen=").append(this.d);
        stringBuffer.append(", isBloodPressure=").append(this.b);
        stringBuffer.append(", isBloodSugar=").append(this.f18324a);
        stringBuffer.append(", isTemperature=").append(this.n);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
