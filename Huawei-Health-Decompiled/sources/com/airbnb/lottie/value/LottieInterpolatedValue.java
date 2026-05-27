package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import defpackage.jg;
import defpackage.ji;

/* JADX INFO: loaded from: classes9.dex */
abstract class LottieInterpolatedValue<T> extends ji<T> {
    private final T endValue;
    private final Interpolator interpolator;
    private final T startValue;

    abstract T interpolateValue(T t, T t2, float f);

    LottieInterpolatedValue(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    LottieInterpolatedValue(T t, T t2, Interpolator interpolator) {
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator;
    }

    @Override // defpackage.ji
    public T getValue(jg<T> jgVar) {
        return interpolateValue(this.startValue, this.endValue, this.interpolator.getInterpolation(jgVar.c()));
    }
}
