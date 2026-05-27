package defpackage;

import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes11.dex */
public class piz {
    private static boolean b(int i, int i2) {
        return i2 + (-2) >= 0 && i2 + 3 <= i;
    }

    private static float c(int i) {
        int i2 = i - 4;
        float f = i2 > 0 ? 1.0f - (i2 * 0.2f) : 1.0f;
        if (f > 0.0f) {
            return f;
        }
        return 0.2f;
    }

    public static float b(float[] fArr, int i, float f) {
        int length = fArr.length;
        int length2 = String.valueOf(kqx.d(f, 1, 2)).length();
        if (length < 6 || length2 < 4) {
            return 0.0f;
        }
        if (a(fArr, i) != 4) {
            return Utils.convertDpToPixel(0.0f);
        }
        if (c(fArr, i, 4) > 0.6f) {
            return Utils.convertDpToPixel(22.0f);
        }
        return 0.0f;
    }

    public static float c(float[] fArr, int i, float f) {
        int iA;
        if (fArr.length >= 4 && (iA = a(fArr, i)) != 3 && iA != 4) {
            int length = String.valueOf(kqx.d(f, 1, 2)).length();
            if (c(fArr, i, iA) > c(length)) {
                if (iA == 1 || iA == 5) {
                    return Utils.convertDpToPixel(-(length + 4.0f));
                }
                if (iA == 6) {
                    return Utils.convertDpToPixel(length + 4.0f);
                }
                if (iA == 2) {
                    return Utils.convertDpToPixel(0.0f);
                }
            }
        }
        return 0.0f;
    }

    private static int a(float[] fArr, int i) {
        if (!b(fArr.length, i)) {
            return i - 2 >= 0 ? 2 : 1;
        }
        float f = fArr[i - 1];
        float f2 = fArr[i + 1];
        float f3 = fArr[i + 3] - f2;
        return f - f2 > 0.0f ? f3 > 0.0f ? 3 : 5 : f3 < 0.0f ? 4 : 6;
    }

    private static float c(float[] fArr, int i, int i2) {
        if (i2 == 1 || i2 == 5) {
            return (fArr[i + 1] - fArr[i + 3]) / (fArr[i + 2] - fArr[i]);
        }
        if (i2 == 2 || i2 == 6) {
            return (fArr[i + 1] - fArr[i - 1]) / (fArr[i] - fArr[i - 2]);
        }
        if (i2 != 4) {
            return 1.0f;
        }
        float f = fArr[i + 1];
        float f2 = fArr[i - 1];
        float f3 = fArr[i];
        return ((f - f2) / (f3 - fArr[i + (-2)]) > 0.6f || (f - fArr[i + 3]) / (fArr[i + 2] - f3) > 0.6f) ? 1.0f : 0.0f;
    }
}
