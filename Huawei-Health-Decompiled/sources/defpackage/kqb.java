package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class kqb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kpw f14832a;
    private int b;
    private int e = -1;

    public kpw b() {
        return (kpw) kqt.e(this.f14832a);
    }

    public void d(kpw kpwVar) {
        this.f14832a = (kpw) kqt.e(kpwVar);
    }

    public int d() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }

    public void b(int i) {
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int a() {
        return ((Integer) kqt.e(Integer.valueOf(this.e))).intValue();
    }

    public void d(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
