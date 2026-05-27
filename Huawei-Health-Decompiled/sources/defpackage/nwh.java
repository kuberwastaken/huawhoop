package defpackage;

/* JADX INFO: loaded from: classes11.dex */
public class nwh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16207a;
    private int c;
    private double d;
    private int e;

    public int b() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public int d() {
        return this.f16207a;
    }

    public void a(int i) {
        this.f16207a = i;
    }

    public int a() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public double e() {
        return this.d;
    }

    public void b(double d) {
        this.d = d;
    }

    public String toString() {
        return "UserLevelInfo{currentLevel=" + this.c + ", nextGrowthValue=" + this.f16207a + ", beyondValue=" + this.e + ", peopleNumbers=" + this.d + '}';
    }
}
