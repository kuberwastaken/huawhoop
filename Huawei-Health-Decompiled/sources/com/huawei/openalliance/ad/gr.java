package com.huawei.openalliance.ad;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes6.dex */
public class gr implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f7136a;
    float b;
    float c;
    float d;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("CubicBezierInterpolator  mControlPoint1x = ");
        stringBuffer.append(this.f7136a);
        stringBuffer.append(", mControlPoint1y = ").append(this.b);
        stringBuffer.append(", mControlPoint2x = ").append(this.c);
        stringBuffer.append(", mControlPoint2y = ").append(this.d);
        return stringBuffer.toString();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return a(b(f) * 2.5E-4f);
    }

    long b(float f) {
        long j = 0;
        long j2 = 4000;
        while (j <= j2) {
            long j3 = (j + j2) >>> 1;
            float fC = c(j3 * 2.5E-4f);
            if (fC < f) {
                j = j3 + 1;
            } else {
                if (fC <= f) {
                    return j3;
                }
                j2 = j3 - 1;
            }
        }
        return j;
    }

    protected float a(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.b) + (f3 * f * f * this.d) + (f * f * f);
    }

    private float c(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.f7136a) + (f3 * f * f * this.c) + (f * f * f);
    }

    public gr(float f, float f2, float f3, float f4) {
        this.f7136a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        hq.a("CubicBezierInterpolator", toString());
    }
}
