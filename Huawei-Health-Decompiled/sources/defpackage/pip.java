package defpackage;

import com.huawei.hwlogsmodel.LogUtil;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public final class pip implements Cloneable {
    private static final DecimalFormat d = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.ENGLISH));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f16716a;
    public final double b;

    public pip(double d2, double d3) {
        if (-180.0d <= d3 && d3 < 180.0d) {
            this.f16716a = e(d3);
        } else {
            this.f16716a = e(((((d3 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        }
        this.b = e(Math.max(-90.0d, Math.min(90.0d, d2)));
    }

    private static double e(double d2) {
        try {
            return Double.parseDouble(d.format(d2));
        } catch (NumberFormatException e) {
            LogUtil.a("Track_LatLng", e.getMessage());
            return 0.0d;
        }
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public pip clone() {
        return new pip(this.b, this.f16716a);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.b);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f16716a);
        return ((i + 31) * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public boolean equals(Object obj) {
        return (obj instanceof pip) && hashCode() == ((pip) obj).hashCode();
    }

    public String toString() {
        return "lat/lng";
    }
}
