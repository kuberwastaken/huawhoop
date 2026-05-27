package com.airbnb.lottie.model.animatable;

import defpackage.jf;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    protected final List<jf<V>> keyframes;

    BaseAnimatableValue(V v) {
        this(Collections.singletonList(new jf(v)));
    }

    public BaseAnimatableValue(List<jf<V>> list) {
        this.keyframes = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<jf<V>> getKeyframes() {
        return this.keyframes;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.keyframes.isEmpty()) {
            return true;
        }
        return this.keyframes.size() == 1 && this.keyframes.get(0).i();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.keyframes.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.keyframes.toArray()));
        }
        return sb.toString();
    }
}
