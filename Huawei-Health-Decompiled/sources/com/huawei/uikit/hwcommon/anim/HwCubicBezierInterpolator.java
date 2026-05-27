package com.huawei.uikit.hwcommon.anim;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Interpolator;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes8.dex */
public class HwCubicBezierInterpolator implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f11117a;
    float b;
    float d;
    float e;

    public HwCubicBezierInterpolator(float f, float f2, float f3, float f4) {
        this.f11117a = f;
        this.d = f2;
        this.b = f3;
        this.e = f4;
    }

    private float d(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.f11117a) + (f3 * f * f * this.b) + (f * f * f);
    }

    private float ezk_(TypedValue typedValue) {
        if (typedValue == null) {
            return 1.0f;
        }
        int i = typedValue.type;
        if (i == 6) {
            return TypedValue.complexToFloat(typedValue.data);
        }
        if (i == 4) {
            return typedValue.getFloat();
        }
        if (i < 16 || i > 31) {
            return 1.0f;
        }
        return typedValue.data;
    }

    protected float c(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.d) + (f3 * f * f * this.e) + (f * f * f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return c(e(f) * 2.5E-4f);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HwCubicBezierInterpolator  mControlPoint1x = ");
        stringBuffer.append(this.f11117a);
        stringBuffer.append(", mControlPoint1y = ").append(this.d);
        stringBuffer.append(", mControlPoint2x = ").append(this.b);
        stringBuffer.append(", mControlPoint2y = ").append(this.e);
        return stringBuffer.toString();
    }

    public HwCubicBezierInterpolator(Context context, AttributeSet attributeSet) {
        this(context.getResources(), context.getTheme(), attributeSet);
    }

    public HwCubicBezierInterpolator(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        this.f11117a = 0.0f;
        this.d = 0.0f;
        this.b = 0.0f;
        this.e = 0.0f;
        if (theme != null) {
            typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100533_res_0x7f060375, R.attr._2131100534_res_0x7f060376, R.attr._2131100798_res_0x7f06047e, R.attr._2131100799_res_0x7f06047f}, 0, 0);
        } else {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, new int[]{R.attr._2131100533_res_0x7f060375, R.attr._2131100534_res_0x7f060376, R.attr._2131100798_res_0x7f06047e, R.attr._2131100799_res_0x7f06047f});
        }
        this.f11117a = ezk_(typedArrayObtainAttributes.peekValue(0));
        this.d = ezk_(typedArrayObtainAttributes.peekValue(1));
        this.b = ezk_(typedArrayObtainAttributes.peekValue(2));
        this.e = ezk_(typedArrayObtainAttributes.peekValue(3));
        typedArrayObtainAttributes.recycle();
    }

    long e(float f) {
        long j = 0;
        long j2 = 4000;
        while (j <= j2) {
            long j3 = (j + j2) >>> 1;
            float fD = d(j3 * 2.5E-4f);
            if (fD < f) {
                j = j3 + 1;
            } else {
                if (fD <= f) {
                    return j3;
                }
                j2 = j3 - 1;
            }
        }
        return j;
    }
}
