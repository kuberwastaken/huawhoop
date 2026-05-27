package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes10.dex */
public class b1 implements Interpolator {
    private static final BigDecimal e;
    private static final BigDecimal f;
    private static final float g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5928a;
    private float b;
    private float c;
    private float d;

    static {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(1.0f));
        e = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(Long.toString(4000L));
        f = bigDecimal2;
        g = bigDecimal.divide(bigDecimal2, 20, 4).floatValue();
    }

    public b1(float f2, float f3, float f4, float f5) {
        this.f5928a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        return c(g * a(f2));
    }

    private float b(float f2) {
        float f3 = 1.0f - f2;
        float f4 = 3.0f * f3;
        return (f3 * f4 * f2 * this.f5928a) + (f4 * f2 * f2 * this.c) + (f2 * f2 * f2);
    }

    private float c(float f2) {
        float f3 = 1.0f - f2;
        float f4 = 3.0f * f3;
        return (f3 * f4 * f2 * this.b) + (f4 * f2 * f2 * this.d) + (f2 * f2 * f2);
    }

    private long a(float f2) {
        long j = 0;
        long j2 = 4000;
        while (j <= j2) {
            long j3 = (j + j2) >>> 1;
            float fB = b(g * j3);
            if (fB < f2) {
                j = j3 + 1;
            } else {
                if (fB <= f2) {
                    return j3;
                }
                j2 = j3 - 1;
            }
        }
        return j;
    }

    private String a() {
        return "CubicBezierInterpolator  mControlPoint1x = " + this.f5928a + ", mControlPoint1y = " + this.b + ", mControlPoint2x = " + this.c + ", mControlPoint2y = " + this.d;
    }

    public String toString() {
        return a();
    }
}
