package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class irt implements Cloneable, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DecimalFormat f14232a = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.ENGLISH));
    private static final long serialVersionUID = 1;

    @SerializedName(JsbMapKeyNames.H5_LOC_LON)
    public final double c;

    @SerializedName(JsbMapKeyNames.H5_LOC_LAT)
    public final double d;

    public irt(double d, double d2) {
        if (d2 >= -180.0d && d2 < 180.0d) {
            this.c = b(d2);
        } else {
            this.c = b(((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        }
        this.d = b(Math.max(-90.0d, Math.min(90.0d, d)));
    }

    private static double b(double d) {
        try {
            return Double.parseDouble(f14232a.format(d));
        } catch (NumberFormatException e) {
            LogUtil.a("Track_LatLng", e.getMessage());
            return 0.0d;
        }
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public irt clone() {
        return new irt(this.d, this.c);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.d);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.c);
        return ((i + 31) * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public boolean equals(Object obj) {
        return (obj instanceof irt) && hashCode() == ((irt) obj).hashCode();
    }

    public String toString() {
        return "lat/lng";
    }
}
