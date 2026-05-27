package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mbl {
    private double b = 0.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f15595a = 0.0d;
    private long c = 0;

    public double c() {
        return this.b;
    }

    public void c(double d) {
        this.b = d;
    }

    public double b() {
        return this.f15595a;
    }

    public void d(double d) {
        this.f15595a = d;
    }

    public long d() {
        return this.c;
    }

    public void e(long j) {
        this.c = j;
    }

    public String toString() {
        return "LocationWeather{latitude=" + this.b + ", longitude=" + this.f15595a + ", time=" + this.c + '}';
    }
}
