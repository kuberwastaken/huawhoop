package defpackage;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes5.dex */
public class itn implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f14276a;
    private final float c;
    private final float d;
    private final float e;

    private float b(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public itn(float f, float f2, float f3, float f4) {
        this.f14276a = f;
        this.e = f2;
        this.c = f3;
        this.d = f4;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return b(c(f));
    }

    private float d(float f) {
        return c(f, this.f14276a, this.c);
    }

    private float b(float f) {
        return c(f, this.e, this.d);
    }

    private float c(float f, float f2, float f3) {
        if (f == 0.0f || f == 1.0f) {
            return f;
        }
        float fB = b(0.0f, f2, f);
        float fB2 = b(f2, f3, f);
        return b(b(fB, fB2, f), b(fB2, b(f3, 1.0f, f), f), f);
    }

    private float c(float f) {
        float f2 = 0.0f;
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        float f3 = f;
        float f4 = 1.0f;
        float fD = 0.0f;
        for (int i = 0; i < 8; i++) {
            fD = d(f3);
            double d = (d(f3 + 1.0E-6f) - fD) / 1.0E-6f;
            float f5 = fD - f;
            if (Math.abs(f5) < 1.0E-6f) {
                return f3;
            }
            if (Math.abs(d) < 9.999999974752427E-7d) {
                break;
            }
            if (fD < f) {
                f2 = f3;
            } else {
                f4 = f3;
            }
            f3 = (float) (((double) f3) - (((double) f5) / d));
        }
        for (int i2 = 0; Math.abs(fD - f) > 1.0E-6f && i2 < 8; i2++) {
            if (fD < f) {
                float f6 = f3;
                f3 = (f3 + f4) / 2.0f;
                f2 = f6;
            } else {
                f4 = f3;
                f3 = (f3 + f2) / 2.0f;
            }
            fD = d(f3);
        }
        return f3;
    }
}
