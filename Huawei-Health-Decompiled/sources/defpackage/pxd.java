package defpackage;

import android.view.ViewConfiguration;
import com.huawei.hwcommonmodel.application.BaseApplication;

/* JADX INFO: loaded from: classes11.dex */
public class pxd {
    private static float d = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static float e = ViewConfiguration.getScrollFriction();
    private static float b = ((BaseApplication.getContext().getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;

    private static double d(int i) {
        return Math.log((Math.abs(i) * 0.35f) / (e * b));
    }

    private static double b(double d2) {
        return ((((double) d) - 1.0d) * Math.log(d2 / ((double) (e * b)))) / ((double) d);
    }

    public static double c(int i) {
        double d2 = d(i);
        double d3 = d;
        return Math.exp(d2 * (d3 / (d3 - 1.0d))) * ((double) (e * b));
    }

    public static int c(double d2) {
        return Math.abs((int) (((Math.exp(b(d2)) * ((double) e)) * ((double) b)) / 0.3499999940395355d));
    }
}
