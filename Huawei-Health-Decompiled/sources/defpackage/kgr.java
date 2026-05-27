package defpackage;

import health.compact.a.CommonUtil;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public final class kgr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f14668a;
    public final double c;

    public kgr(double d, double d2) {
        if (-180.0d <= d2 && d2 < 180.0d) {
            this.f14668a = d(d2);
        } else {
            this.f14668a = d(((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        }
        this.c = d(Math.max(-90.0d, Math.min(90.0d, d)));
    }

    private static double d(double d) {
        return CommonUtil.a(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d));
    }
}
