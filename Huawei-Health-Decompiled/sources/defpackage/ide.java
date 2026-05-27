package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class ide {
    public static float c(float[] fArr, float[] fArr2) {
        int length;
        if (fArr == null || (length = fArr.length) == 1) {
            return 0.0f;
        }
        float f = length;
        float fA = (float) (((double) (idk.a(fArr) * f)) - Math.pow(idk.d(fArr), 2.0d));
        if (fA == 0.0f) {
            return 0.0f;
        }
        return ((f * idk.c(fArr, fArr2)) - (idk.d(fArr) * idk.d(fArr2))) / fA;
    }

    public static float a(float[] fArr, float[] fArr2, float f) {
        int length;
        if (fArr == null || (length = fArr.length) == 1 || length == 0) {
            return 1.0f;
        }
        float f2 = length;
        return (idk.d(fArr2) / f2) - ((f * idk.d(fArr)) / f2);
    }
}
