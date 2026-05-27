package defpackage;

import java.text.NumberFormat;

/* JADX INFO: loaded from: classes.dex */
public class kqx {
    public static int a(int i) {
        return (int) (((double) i) * 2.54d);
    }

    public static double c(int i) {
        return ((double) i) / 1000.0d;
    }

    public static int b(int i) {
        return (int) Math.round(((double) i) / 2.54d);
    }

    public static double d(int i) {
        return c(i) * 0.62137119223733d;
    }

    public static String d(double d, int i, int i2) {
        if (i == 1) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(i2);
            numberFormat.setMinimumFractionDigits(i2);
            return numberFormat.format(d);
        }
        if (i != 2) {
            return "";
        }
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMaximumFractionDigits(i2);
        percentInstance.setMinimumFractionDigits(i2);
        return percentInstance.format(d / 100.0d);
    }
}
