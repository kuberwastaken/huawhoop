package com.airbnb.lottie.animation.keyframe;

import defpackage.cv;
import defpackage.jf;
import defpackage.ji;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    private final KeyframesWrapper<K> keyframesWrapper;
    protected ji<A> valueCallback;
    protected final List<AnimationListener> listeners = new ArrayList(1);
    private boolean isDiscrete = false;
    protected float progress = 0.0f;
    private A cachedGetValue = null;
    private float cachedStartDelayProgress = -1.0f;
    private float cachedEndProgress = -1.0f;

    public interface AnimationListener {
        void onValueChanged();
    }

    interface KeyframesWrapper<T> {
        jf<T> getCurrentKeyframe();

        float getEndProgress();

        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f);

        boolean isEmpty();

        boolean isValueChanged(float f);
    }

    protected abstract A getValue(jf<K> jfVar, float f);

    public BaseKeyframeAnimation(List<? extends jf<K>> list) {
        this.keyframesWrapper = wrap(list);
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    public void setProgress(float f) {
        if (cv.a()) {
            cv.c("BaseKeyframeAnimation#setProgress");
        }
        if (this.keyframesWrapper.isEmpty()) {
            if (cv.a()) {
                cv.e("BaseKeyframeAnimation#setProgress");
                return;
            }
            return;
        }
        if (f < getStartDelayProgress()) {
            f = getStartDelayProgress();
        } else if (f > getEndProgress()) {
            f = getEndProgress();
        }
        if (f == this.progress) {
            if (cv.a()) {
                cv.e("BaseKeyframeAnimation#setProgress");
            }
        } else {
            this.progress = f;
            if (this.keyframesWrapper.isValueChanged(f)) {
                notifyListeners();
            }
            if (cv.a()) {
                cv.e("BaseKeyframeAnimation#setProgress");
            }
        }
    }

    public void notifyListeners() {
        if (cv.a()) {
            cv.c("BaseKeyframeAnimation#notifyListeners");
        }
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
        if (cv.a()) {
            cv.e("BaseKeyframeAnimation#notifyListeners");
        }
    }

    public jf<K> getCurrentKeyframe() {
        if (cv.a()) {
            cv.c("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        jf<K> currentKeyframe = this.keyframesWrapper.getCurrentKeyframe();
        if (cv.a()) {
            cv.e("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        return currentKeyframe;
    }

    protected float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        jf<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.i()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.j()) / (currentKeyframe.c() - currentKeyframe.j());
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        jf<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe == null || currentKeyframe.i() || currentKeyframe.b == null) {
            return 0.0f;
        }
        return currentKeyframe.b.getInterpolation(getLinearCurrentKeyframeProgress());
    }

    private float getStartDelayProgress() {
        if (this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
        }
        return this.cachedStartDelayProgress;
    }

    protected float getEndProgress() {
        if (this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    public A getValue() {
        A value;
        float linearCurrentKeyframeProgress = getLinearCurrentKeyframeProgress();
        if (this.valueCallback == null && this.keyframesWrapper.isCachedValueEnabled(linearCurrentKeyframeProgress)) {
            return this.cachedGetValue;
        }
        jf<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.f != null && currentKeyframe.i != null) {
            value = getValue(currentKeyframe, linearCurrentKeyframeProgress, currentKeyframe.f.getInterpolation(linearCurrentKeyframeProgress), currentKeyframe.i.getInterpolation(linearCurrentKeyframeProgress));
        } else {
            value = getValue(currentKeyframe, getInterpolatedCurrentKeyframeProgress());
        }
        this.cachedGetValue = value;
        return value;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setValueCallback(ji<A> jiVar) {
        ji<A> jiVar2 = this.valueCallback;
        if (jiVar2 != null) {
            jiVar2.setAnimation(null);
        }
        this.valueCallback = jiVar;
        if (jiVar != null) {
            jiVar.setAnimation(this);
        }
    }

    public boolean hasValueCallback() {
        return this.valueCallback != null;
    }

    protected A getValue(jf<K> jfVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> KeyframesWrapper<T> wrap(List<? extends jf<T>> list) {
        if (list.isEmpty()) {
            return new d();
        }
        if (list.size() == 1) {
            return new b(list);
        }
        return new a(list);
    }

    static final class d<T> implements KeyframesWrapper<T> {
        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            return false;
        }

        private d() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public jf<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    static final class b<T> implements KeyframesWrapper<T> {
        private final jf<T> c;
        private float d = -1.0f;

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        b(List<? extends jf<T>> list) {
            this.c = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            return !this.c.i();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public jf<T> getCurrentKeyframe() {
            return this.c;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.c.j();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return this.c.c();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            if (this.d == f) {
                return true;
            }
            this.d = f;
            return false;
        }
    }

    static final class a<T> implements KeyframesWrapper<T> {
        private final List<? extends jf<T>> b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private jf<T> f722a = null;
        private float c = -1.0f;
        private jf<T> d = b(0.0f);

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        a(List<? extends jf<T>> list) {
            this.b = list;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            if (this.d.a(f)) {
                return !this.d.i();
            }
            this.d = b(f);
            return true;
        }

        private jf<T> b(float f) {
            List<? extends jf<T>> list = this.b;
            jf<T> jfVar = list.get(list.size() - 1);
            if (f >= jfVar.j()) {
                return jfVar;
            }
            for (int size = this.b.size() - 2; size >= 1; size--) {
                jf<T> jfVar2 = this.b.get(size);
                if (this.d != jfVar2 && jfVar2.a(f)) {
                    return jfVar2;
                }
            }
            return this.b.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public jf<T> getCurrentKeyframe() {
            return this.d;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.b.get(0).j();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return this.b.get(r0.size() - 1).c();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            jf<T> jfVar = this.f722a;
            jf<T> jfVar2 = this.d;
            if (jfVar == jfVar2 && this.c == f) {
                return true;
            }
            this.f722a = jfVar2;
            this.c = f;
            return false;
        }
    }
}
