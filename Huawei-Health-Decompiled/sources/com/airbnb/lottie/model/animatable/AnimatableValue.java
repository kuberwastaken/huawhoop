package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import defpackage.jf;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> createAnimation();

    List<jf<K>> getKeyframes();

    boolean isStatic();
}
