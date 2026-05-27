package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes10.dex */
abstract class m5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[][] f6018a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, n5.b.length, 8);

    static {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = n5.b;
            if (i2 >= iArr.length) {
                return;
            }
            int i3 = iArr[i2];
            int i4 = i3 & 1;
            int i5 = 0;
            while (i5 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i3 & 1;
                    if (i == i4) {
                        f += 1.0f;
                        i3 >>= 1;
                    }
                }
                f6018a[i2][7 - i5] = f / 17.0f;
                i5++;
                i4 = i;
            }
            i2++;
        }
    }

    static int d(int[] iArr) {
        int iC = c(e(iArr));
        return iC != -1 ? iC : b(iArr);
    }

    private static int[] e(int[] iArr) {
        float fA = s4.a(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            int i4 = iArr[i] + i2;
            if (i4 <= (fA / 34.0f) + ((i3 * fA) / 17.0f)) {
                i++;
                i2 = i4;
            }
            iArr2[i] = iArr2[i] + 1;
        }
        return iArr2;
    }

    private static int c(int[] iArr) {
        int iA = a(iArr);
        if (n5.a(iA) == -1) {
            return -1;
        }
        return iA;
    }

    private static int a(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                j = (j << 1) | ((long) (i % 2 == 0 ? 1 : 0));
            }
        }
        return (int) j;
    }

    private static int b(int[] iArr) {
        int iA = s4.a(iArr);
        float[] fArr = new float[8];
        if (iA > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = iArr[i] / iA;
            }
        }
        float f = Float.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            float[][] fArr2 = f6018a;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float[] fArr3 = fArr2[i3];
            float f2 = 0.0f;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = n5.b[i3];
                f = f2;
            }
            i3++;
        }
    }
}
