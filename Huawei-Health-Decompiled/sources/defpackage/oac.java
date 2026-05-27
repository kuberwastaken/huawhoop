package defpackage;

import health.compact.a.CommonUtil;
import health.compact.a.UnitUtil;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class oac {
    public static float a(float f) {
        return f / 1000.0f;
    }

    public static int b(float f) {
        if (f <= 1.0E-6f) {
            return Integer.MAX_VALUE;
        }
        return (int) (1000.0f / f);
    }

    public static float c(float f) {
        return ((int) (f * 10.0f)) / 10.0f;
    }

    public static float c(int i) {
        return i / 1000.0f;
    }

    public static double d(int i) {
        return (((double) i) * 3.5d) / 65536.0d;
    }

    public static float e(float f) {
        return f * 3.6f;
    }

    public static int e(int i) {
        return i * 1000;
    }

    public static int i(float f) {
        return (int) (f * 1000.0f);
    }

    public static int j(float f) {
        return (int) (f * 1000.0f);
    }

    public static String e(double d) {
        return UnitUtil.e(d, 1, 2, false);
    }

    public static String b(double d) {
        return e(CommonUtil.a(UnitUtil.e(d, 1, 3, false)));
    }

    public static String g(double d) {
        return UnitUtil.e(d, 1, 2);
    }

    public static String d(float f) {
        return UnitUtil.e(Math.round(f / 1000.0f), 1, 0);
    }

    public static String h(float f) {
        return UnitUtil.e(f, 1, 0);
    }

    public static String f(float f) {
        return UnitUtil.e(f / 60000.0f, 1, 0);
    }

    public static String l(float f) {
        return UnitUtil.e(f / 60.0f, 1, 0);
    }

    public static String g(float f) {
        return UnitUtil.e(f / 1000.0f, 1, 0);
    }

    public static double c(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            d = 0.0d;
        }
        return new BigDecimal(d).setScale(3, 1).floatValue();
    }

    public static int a(int i) {
        return i / 60;
    }

    public static int b(int i) {
        return i % 60;
    }

    public static float a(double d) {
        return (int) Math.round(d);
    }

    public static float d(double d) {
        return new BigDecimal(d).setScale(1, 1).floatValue();
    }

    public static double i(double d) {
        return UnitUtil.j() ? UnitUtil.e(d, 3) : d;
    }
}
