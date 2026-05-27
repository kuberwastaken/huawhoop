package defpackage;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes7.dex */
public class nta {
    private static boolean a(short s) {
        return s >= 60 && s < 80;
    }

    private static float b(short s) {
        float f;
        float f2;
        if (s == Short.MIN_VALUE) {
            return Float.MIN_VALUE;
        }
        if (s < 90) {
            return (s * 10.0f) / 90.0f;
        }
        if (s < 120) {
            return (((s - 90) * 10.0f) / 30.0f) + 10.0f;
        }
        if (s < 140) {
            return (((s - 120) * 10.0f) / 20.0f) + 20.0f;
        }
        if (s < 160) {
            return (((s - 140) * 10.0f) / 20.0f) + 30.0f;
        }
        if (s < 180) {
            f = ((s - 160) * 10.0f) / 20.0f;
            f2 = 40.0f;
        } else {
            if (s >= 200) {
                return 60.0f;
            }
            f = ((s - 180) * 10.0f) / 20.0f;
            f2 = 50.0f;
        }
        return f + f2;
    }

    private static boolean c(short s) {
        return s >= 90 && s < 120;
    }

    private static float d(short s) {
        float f;
        float f2;
        if (s == Short.MIN_VALUE) {
            return Float.MIN_VALUE;
        }
        if (s < 60) {
            return (s * 10.0f) / 60.0f;
        }
        if (s < 80) {
            return (((s - 60) * 10.0f) / 20.0f) + 10.0f;
        }
        if (s < 90) {
            return (((s - 80) * 10.0f) / 10.0f) + 20.0f;
        }
        if (s < 100) {
            f = ((s - 90) * 10.0f) / 10.0f;
            f2 = 30.0f;
        } else if (s < 110) {
            f = s - 100.0f;
            f2 = 40.0f;
        } else {
            if (s >= 120) {
                return 60.0f;
            }
            f = ((s - 110) * 10.0f) / 10.0f;
            f2 = 50.0f;
        }
        return f + f2;
    }

    public static int a(short s, short s2) {
        return c(c(s, s2));
    }

    public static int c(float f) {
        if (Math.abs(f - Float.MIN_VALUE) < 1.0E-6d) {
            return -32768;
        }
        int i = 0;
        if (f >= a(0)) {
            i = 1;
            if (f >= a(1)) {
                i = 2;
                if (f >= a(2)) {
                    i = 3;
                    if (f >= a(3)) {
                        i = 4;
                        if (f >= a(4)) {
                            return 5;
                        }
                    }
                }
            }
        }
        return i;
    }

    public static float a(int i) {
        float fFloatValue = new BigDecimal((i + 1) * 10.0f).setScale(2, 4).floatValue();
        if (i == -32768) {
            return Float.MIN_VALUE;
        }
        return fFloatValue;
    }

    public static float c(short s, short s2) {
        float fD;
        if (s == Short.MIN_VALUE || s2 == Short.MIN_VALUE) {
            return Float.MIN_VALUE;
        }
        if (a(s2)) {
            fD = b(s);
        } else if (c(s)) {
            fD = d(s2);
        } else if (s2 >= 80 && s >= 120) {
            fD = b(s) > d(s2) ? b(s) : d(s2);
        } else {
            fD = (s2 >= 60 || s >= 90 || b(s) >= d(s2)) ? d(s2) : b(s);
        }
        return new BigDecimal(fD).setScale(2, 4).floatValue();
    }
}
