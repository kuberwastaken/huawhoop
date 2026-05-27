package defpackage;

/* JADX INFO: loaded from: classes11.dex */
public class pcv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16628a;
    public float c;
    public float d;

    public pcv() {
    }

    public pcv(float f) {
        this(f, f, f);
    }

    public pcv(float f, float f2, float f3) {
        this.c = f;
        this.f16628a = f2;
        this.d = f3;
    }

    public pcv d(pcv pcvVar) {
        pcv pcvVar2 = new pcv();
        pcvVar2.c = this.c + pcvVar.c;
        pcvVar2.f16628a = this.f16628a + pcvVar.f16628a;
        pcvVar2.d = this.d + pcvVar.d;
        return pcvVar2;
    }

    public pcv a(float f, float f2, float f3) {
        pcv pcvVar = new pcv();
        pcvVar.c += f;
        pcvVar.f16628a = pcvVar.f16628a + f2 + f2;
        return pcvVar;
    }

    public String toString() {
        return "Vec3{x=" + this.c + ", y=" + this.f16628a + ", z=" + this.d + '}';
    }
}
