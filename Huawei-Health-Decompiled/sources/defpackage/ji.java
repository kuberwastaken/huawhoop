package defpackage;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* JADX INFO: loaded from: classes3.dex */
public class ji<T> {
    private BaseKeyframeAnimation<?, ?> animation;
    private final jg<T> frameInfo;
    protected T value;

    public ji() {
        this.frameInfo = new jg<>();
        this.value = null;
    }

    public ji(T t) {
        this.frameInfo = new jg<>();
        this.value = t;
    }

    public T getValue(jg<T> jgVar) {
        return this.value;
    }

    public final void setValue(T t) {
        this.value = t;
        BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = this.animation;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.notifyListeners();
        }
    }

    public final T getValueInternal(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return getValue(this.frameInfo.c(f, f2, t, t2, f3, f4, f5));
    }

    public final void setAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animation = baseKeyframeAnimation;
    }
}
