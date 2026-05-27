package defpackage;

import com.huawei.up.model.UserInfomation;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class icy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int[] f14055a = {0, 0};
    private static int[] d = {0, 0};
    private static final float[] c = {1.0f, 1.0f};
    private static final float[] b = {0.0f, 0.0f};

    private static float d(int i) {
        float f;
        float f2;
        float f3;
        if (i == 0) {
            i = 170;
        }
        if (i < 149) {
            f2 = i;
            f3 = 0.48f;
        } else if (i < 166) {
            f2 = i;
            f3 = (0.0025f * f2) + 0.145f;
        } else {
            if (i >= 185) {
                f = 110.0f;
                return f / 100.0f;
            }
            f2 = i;
            f3 = 0.56f;
        }
        f = f2 * f3;
        return f / 100.0f;
    }

    private static float e(int i) {
        if (i <= 0 || i > 220) {
            return 1.0f;
        }
        if (i <= 96) {
            return 0.75f;
        }
        if (i <= 132) {
            return 0.85f;
        }
        return i >= 180 ? 1.1f : 1.0f;
    }

    private static float e(int i, UserInfomation userInfomation) {
        if (i <= 0) {
            return 0.0f;
        }
        return i * (((userInfomation == null ? 170 : userInfomation.getHeightOrDefaultValue()) * 0.42f) / 100.0f);
    }

    private static float c(int i, UserInfomation userInfomation, int i2, int i3, boolean z) {
        if (i2 <= 0 || i3 > 1) {
            return -1.0f;
        }
        if (i3 == 0) {
            return b(i, userInfomation, i2, z);
        }
        return e(i, userInfomation);
    }

    private static float b(int i, UserInfomation userInfomation, int i2, boolean z) {
        if (i2 <= 0) {
            return -1.0f;
        }
        int heightOrDefaultValue = userInfomation == null ? 170 : userInfomation.getHeightOrDefaultValue();
        int iD = d(i, i2);
        float fD = d(heightOrDefaultValue);
        if (z) {
            fD *= e(iD);
        }
        return i * fD;
    }

    private static int d(int i, int i2) {
        if (i2 != 0) {
            return (i * 60) / i2;
        }
        return 0;
    }

    public static float e(int i, UserInfomation userInfomation, int i2, int i3) {
        if (i2 <= 0) {
            return -1.0f;
        }
        if (i3 > 1 || i3 < 0) {
            return -1.0f;
        }
        int iD = d(i, i2);
        float fC = c(iD, i3);
        if (fC < 0.4f || fC > 1.6f) {
            fC = 1.0f;
        }
        return fC * (idk.b(0.025f, 0.2f, 185.0f, iD) + 1.0f) * c(i, userInfomation, i2, i3, fC != 1.0f);
    }

    private static float c(int i, int i2) {
        float f;
        float f2;
        float f3 = i;
        if (f3 < f14055a[i2] * 0.95f || f3 > d[i2] * 1.05f) {
            return 1.0f;
        }
        float[] fArr = c;
        if (i2 > fArr.length) {
            return 1.0f;
        }
        if (i < 80) {
            f = fArr[i2];
            f2 = b[i2];
            f3 = 80.0f;
        } else if (i > 220) {
            f = fArr[i2];
            f2 = b[i2];
            f3 = 220.0f;
        } else {
            f = fArr[i2];
            f2 = b[i2];
        }
        return f + (f2 * f3);
    }

    public static int b(UserInfomation userInfomation, int[] iArr, int[] iArr2, float[] fArr, int i) {
        int length;
        if (iArr == null || iArr2 == null || fArr == null || (length = iArr.length) == 0 || iArr2.length != length || fArr.length != length || i > 1) {
            return -1;
        }
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return -2;
            }
            fArr2[i2] = (iArr2[i2] * 60.0f) / i3;
        }
        float[] fArr3 = new float[length];
        for (int i4 = 0; i4 < length; i4++) {
            float fC = c(iArr2[i4], userInfomation, iArr[i4], i, true);
            if (fC == 0.0f) {
                return -3;
            }
            fArr3[i4] = fArr[i4] / fC;
        }
        float[] fArr4 = b;
        float fC2 = ide.c(fArr2, fArr3);
        fArr4[i] = fC2;
        c[i] = ide.a(fArr2, fArr3, fC2);
        a(fArr2, i);
        return 0;
    }

    private static void a(float[] fArr, int i) {
        Arrays.sort(fArr);
        f14055a[i] = (int) fArr[0];
        d[i] = (int) fArr[fArr.length - 1];
    }
}
