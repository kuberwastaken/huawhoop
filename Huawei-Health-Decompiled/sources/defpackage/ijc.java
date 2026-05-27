package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class ijc {
    private double b = 0.0d;

    public double a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return this.b;
        }
        this.b = d;
        return d;
    }
}
