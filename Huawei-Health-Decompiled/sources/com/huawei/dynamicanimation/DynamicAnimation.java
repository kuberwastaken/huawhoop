package com.huawei.dynamicanimation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.huawei.dynamicanimation.AnimationHandler;
import com.huawei.dynamicanimation.DynamicAnimation;
import defpackage.ciw;
import java.math.BigDecimal;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final int ANDROID_LOLLIPOP = 21;
    private static final int FRAME_REFRESH_INTERVAL = 16;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float UNSET = Float.MAX_VALUE;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mFrameRefreshInterval;
    private boolean mIsRunning;
    private boolean mIsStartImmediate;
    protected boolean mIsStartValueIsSet;
    private long mLastFrameTime;
    protected float mMaxValue;
    protected float mMinValue;
    private float mMinVisibleChange;
    protected FloatPropertyCompat mProperty;
    private final ArrayList<OnAnimationStartListener> mStartListeners;
    protected Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    protected float mValue;
    protected float mVelocity;
    public static final ViewProperty TRANSLATION_X = new ViewProperty("translationX") { // from class: com.huawei.dynamicanimation.DynamicAnimation.5
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uF_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setTranslationX(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uE_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getTranslationX();
        }
    };
    public static final ViewProperty TRANSLATION_Y = new ViewProperty("translationY") { // from class: com.huawei.dynamicanimation.DynamicAnimation.9
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uR_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setTranslationY(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uQ_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getTranslationY();
        }
    };
    public static final ViewProperty TRANSLATION_Z = new ViewProperty("translationZ") { // from class: com.huawei.dynamicanimation.DynamicAnimation.6
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uT_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view != null) {
                view.setTranslationZ(f);
            }
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uS_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view != null) {
                return view.getTranslationZ();
            }
            return 0.0f;
        }
    };
    public static final ViewProperty SCALE_X = new ViewProperty("scaleX") { // from class: com.huawei.dynamicanimation.DynamicAnimation.10
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uV_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setScaleX(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uU_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScaleX();
        }
    };
    public static final ViewProperty SCALE_Y = new ViewProperty("scaleY") { // from class: com.huawei.dynamicanimation.DynamicAnimation.14
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uX_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setScaleY(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uW_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScaleY();
        }
    };
    public static final ViewProperty ROTATION = new ViewProperty(Key.ROTATION) { // from class: com.huawei.dynamicanimation.DynamicAnimation.11
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uZ_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setRotation(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uY_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotation();
        }
    };
    public static final ViewProperty ROTATION_X = new ViewProperty("rotationX") { // from class: com.huawei.dynamicanimation.DynamicAnimation.13
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: vb_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setRotationX(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: va_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotationX();
        }
    };
    public static final ViewProperty ROTATION_Y = new ViewProperty("rotationY") { // from class: com.huawei.dynamicanimation.DynamicAnimation.15
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: vd_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setRotationY(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: vc_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotationY();
        }
    };
    public static final ViewProperty AXIS_X = new ViewProperty("x") { // from class: com.huawei.dynamicanimation.DynamicAnimation.12
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: vf_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setX(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: ve_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getX();
        }
    };
    public static final ViewProperty AXIS_Y = new ViewProperty("y") { // from class: com.huawei.dynamicanimation.DynamicAnimation.3
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uH_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setY(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uG_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getY();
        }
    };
    public static final ViewProperty AXIS_Z = new ViewProperty("z") { // from class: com.huawei.dynamicanimation.DynamicAnimation.2
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uJ_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view != null) {
                view.setZ(f);
            }
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uI_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view != null) {
                return view.getZ();
            }
            return 0.0f;
        }
    };
    public static final ViewProperty ALPHA = new ViewProperty("alpha") { // from class: com.huawei.dynamicanimation.DynamicAnimation.4
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uL_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setAlpha(f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uK_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getAlpha();
        }
    };
    public static final ViewProperty SCROLL_X = new ViewProperty("scrollX") { // from class: com.huawei.dynamicanimation.DynamicAnimation.1
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uN_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setScrollX((int) f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uM_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScrollX();
        }
    };
    public static final ViewProperty SCROLL_Y = new ViewProperty("scrollY") { // from class: com.huawei.dynamicanimation.DynamicAnimation.8
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uP_, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f) {
            if (view == null) {
                return;
            }
            view.setScrollY((int) f);
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        /* JADX INFO: renamed from: uO_, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScrollY();
        }
    };
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = new BigDecimal(1.0d).divide(new BigDecimal("10")).floatValue();
    public static final float MIN_VISIBLE_CHANGE_ALPHA = new BigDecimal(1.0d).divide(new BigDecimal("256")).floatValue();
    public static final float MIN_VISIBLE_CHANGE_SCALE = new BigDecimal(1.0d).divide(new BigDecimal("500")).floatValue();

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2);
    }

    public interface OnAnimationStartListener {
        void onAnimationStart(DynamicAnimation dynamicAnimation, float f, float f2);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2005a;
        public float e;
    }

    protected abstract float getAcceleration(float f, float f2);

    protected abstract boolean isAtEquilibrium(float f, float f2);

    protected abstract void setValueThreshold(float f);

    protected abstract boolean updateValueAndVelocity(long j);

    DynamicAnimation(final ciw ciwVar) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mIsStartValueIsSet = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -3.4028235E38f;
        this.mIsStartImmediate = false;
        this.mIsRunning = false;
        this.mLastFrameTime = 0L;
        this.mFrameRefreshInterval = 16L;
        this.mStartListeners = new ArrayList<>();
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new FloatPropertyCompat("FloatValueHolder") { // from class: com.huawei.dynamicanimation.DynamicAnimation.7
            @Override // com.huawei.dynamicanimation.FloatPropertyCompat
            public float getValue(Object obj) {
                return ciwVar.getValue();
            }

            @Override // com.huawei.dynamicanimation.FloatPropertyCompat
            public void setValue(Object obj, float f) {
                ciwVar.setValue(f);
            }
        };
        this.mMinVisibleChange = 1.0f;
    }

    public <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mIsStartValueIsSet = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -3.4028235E38f;
        this.mIsStartImmediate = false;
        this.mIsRunning = false;
        this.mLastFrameTime = 0L;
        this.mFrameRefreshInterval = 16L;
        this.mStartListeners = new ArrayList<>();
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        initAnimObjAndProperty(k, floatPropertyCompat);
    }

    public <K> T setObj(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        initAnimObjAndProperty(k, floatPropertyCompat);
        return this;
    }

    public T setStartValue(float f) {
        this.mValue = f;
        this.mIsStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f) {
        this.mVelocity = f;
        return this;
    }

    public T setMaxValue(float f) {
        this.mMaxValue = f;
        return this;
    }

    public T setMinValue(float f) {
        this.mMinValue = f;
        return this;
    }

    public T addStartListener(OnAnimationStartListener onAnimationStartListener) {
        if (!this.mStartListeners.contains(onAnimationStartListener)) {
            this.mStartListeners.add(onAnimationStartListener);
        }
        return this;
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public void removeStartListener(OnAnimationStartListener onAnimationStartListener) {
        removeEntry(this.mStartListeners, onAnimationStartListener);
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (isRunning()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
            this.mUpdateListeners.add(onAnimationUpdateListener);
        }
        return this;
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T clearListeners() {
        this.mStartListeners.clear();
        this.mUpdateListeners.clear();
        this.mEndListeners.clear();
        return this;
    }

    public T setMinimumVisibleChange(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.mMinVisibleChange = f;
        setValueThreshold(f * 0.75f);
        return this;
    }

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    private static void removeNullEntries(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t) {
        int iIndexOf = arrayList.indexOf(t);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.mIsRunning) {
            return;
        }
        this.mIsStartImmediate = false;
        startAnimationInternal();
    }

    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.mIsRunning) {
            endAnimationInternal(true);
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    private void startAnimationInternal() {
        FloatPropertyCompat floatPropertyCompat;
        if (this.mIsRunning) {
            return;
        }
        this.mIsRunning = true;
        if (!this.mIsStartValueIsSet && (floatPropertyCompat = this.mProperty) != null) {
            this.mValue = floatPropertyCompat.getValue(this.mTarget);
        }
        float f = this.mValue;
        if (f > this.mMaxValue || f < this.mMinValue) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        AnimationHandler.d().d(this, 0L);
        for (int i = 0; i < this.mStartListeners.size(); i++) {
            if (this.mStartListeners.get(i) != null) {
                this.mStartListeners.get(i).onAnimationStart(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mStartListeners);
    }

    public void startImmediately() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.mIsRunning) {
            return;
        }
        this.mIsStartImmediate = true;
        startAnimationInternal();
    }

    public void startImmediately(long j) {
        if (j > 0 && j <= 100) {
            this.mFrameRefreshInterval = j;
        }
        startImmediately();
    }

    @Override // com.huawei.dynamicanimation.AnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long j) {
        long j2 = this.mLastFrameTime;
        if (j2 == 0) {
            this.mLastFrameTime = j;
            if (!this.mIsStartImmediate) {
                setPropertyValue(this.mValue);
                return false;
            }
            j2 = j - this.mFrameRefreshInterval;
        }
        this.mLastFrameTime = j;
        float fMin = Math.min(this.mValue, this.mMaxValue);
        this.mValue = fMin;
        this.mValue = Math.max(fMin, this.mMinValue);
        boolean zUpdateValueAndVelocity = updateValueAndVelocity(j - j2);
        setPropertyValue(this.mValue);
        if (zUpdateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return zUpdateValueAndVelocity;
    }

    private void endAnimationInternal(boolean z) {
        this.mIsRunning = false;
        AnimationHandler.d().e(this);
        this.mLastFrameTime = 0L;
        this.mIsStartValueIsSet = false;
        for (int i = 0; i < this.mEndListeners.size(); i++) {
            if (this.mEndListeners.get(i) != null) {
                this.mEndListeners.get(i).onAnimationEnd(this, z, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    public void setPropertyValue(float f) {
        this.mProperty.setValue(this.mTarget, f);
        for (int i = 0; i < this.mUpdateListeners.size(); i++) {
            if (this.mUpdateListeners.get(i) != null) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this, f, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    protected float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    private <K> void initAnimObjAndProperty(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mTarget = k;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat == ROTATION || floatPropertyCompat == ROTATION_X || floatPropertyCompat == ROTATION_Y) {
            this.mMinVisibleChange = MIN_VISIBLE_CHANGE_ROTATION_DEGREES;
            return;
        }
        if (floatPropertyCompat == ALPHA) {
            this.mMinVisibleChange = MIN_VISIBLE_CHANGE_ALPHA;
        } else if (floatPropertyCompat == SCALE_X || floatPropertyCompat == SCALE_Y) {
            this.mMinVisibleChange = MIN_VISIBLE_CHANGE_ALPHA;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }
}
