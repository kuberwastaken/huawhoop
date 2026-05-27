package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class iz {
    private static float d(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float e(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int b(float f, int i, int i2) {
        if (i == i2 || f <= 0.0f) {
            return i;
        }
        if (f >= 1.0f) {
            return i2;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float fE = e(((i >> 16) & 255) / 255.0f);
        float fE2 = e(((i >> 8) & 255) / 255.0f);
        float fE3 = e((i & 255) / 255.0f);
        float fE4 = e(((i2 >> 16) & 255) / 255.0f);
        float fE5 = e(((i2 >> 8) & 255) / 255.0f);
        float fE6 = e((i2 & 255) / 255.0f);
        return (Math.round((f2 + ((f3 - f2) * f)) * 255.0f) << 24) | (Math.round(d(fE + ((fE4 - fE) * f)) * 255.0f) << 16) | (Math.round(d(fE2 + ((fE5 - fE2) * f)) * 255.0f) << 8) | Math.round(d(fE3 + ((fE6 - fE3) * f)) * 255.0f);
    }
}
