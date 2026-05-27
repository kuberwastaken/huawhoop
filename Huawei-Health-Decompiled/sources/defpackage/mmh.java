package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mmh {
    private double c;
    private double d;
    private double e;

    public mmh(double d, double d2, double d3) {
        this.e = d2;
        this.d = d;
        this.c = d3;
    }

    public double a() {
        return this.e;
    }

    public double e() {
        return this.d;
    }

    public double d() {
        return this.c;
    }

    public String toString() {
        return "SimpleLocation{mLatitude=" + this.e + ", mLongitude=" + this.d + ", mAltitude=" + this.c + '}';
    }
}
