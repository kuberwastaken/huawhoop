package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable;

/* JADX INFO: loaded from: classes8.dex */
public class vmd extends HwGravitationalLoadingDrawable {
    private ValueAnimator b;
    private ValueAnimator d;
    private ValueAnimator e;
    private boolean f;
    private boolean i;

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e("HwSeekableLoadingAnim", "onAnimationUpdate:null animator");
            } else {
                vmd.this.f11069a.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                vmd.this.invalidateSelf();
            }
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            vmd.this.d.start();
            vmd.super.c(false);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e("HwSeekableLoadingAnim", "onAnimationUpdate: null animator");
            } else {
                vmd.this.f11069a.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
                vmd.this.invalidateSelf();
            }
        }
    }

    vmd(HwGravitationalLoadingDrawable.g gVar, HwGravitationalLoadingDrawable.h hVar, int i, float f) {
        super(gVar, hVar, i, f);
        this.i = true;
        this.f = false;
        c();
        this.f11069a.a(0.0f);
    }

    private void a() {
        this.b = b.evx_(-8.0f, 15.0f);
    }

    private void c() {
        a();
        i();
        g();
    }

    public static vmd evw_(int i, HwGravitationalLoadingDrawable.d dVar, DisplayMetrics displayMetrics, int i2) {
        if (i2 <= 0) {
            i2 = 1200;
        }
        int iA = HwGravitationalLoadingDrawable.a(i);
        return new vmd(HwGravitationalLoadingDrawable.c(iA, dVar), HwGravitationalLoadingDrawable.a(iA, dVar), i2, displayMetrics.density);
    }

    private void g() {
        ValueAnimator valueAnimatorA = b.a(60.0f, 480L);
        this.d = valueAnimatorA;
        valueAnimatorA.addUpdateListener(new c());
    }

    private void i() {
        ValueAnimator valueAnimatorB = b.b(15.0f, 35.0f);
        this.e = valueAnimatorB;
        valueAnimatorB.addUpdateListener(new e());
        this.e.addListener(new d());
    }

    public void b() {
        this.i = true;
        setLevel(10000);
        start();
    }

    public void e() {
        stop();
        this.i = false;
    }

    @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable, android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (isRunning()) {
            return false;
        }
        c(i / 10000.0f);
        return true;
    }

    @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable, android.graphics.drawable.Animatable
    public void start() {
        if (!isRunning() && this.i) {
            this.e.start();
            this.f = true;
        }
    }

    @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable, android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.e.cancel();
            this.d.cancel();
            this.f11069a.a(0.0f);
            this.f = false;
            super.stop();
        }
    }

    private void c(float f) {
        this.b.setCurrentPlayTime((long) (f * r0.getDuration()));
        this.c.c(((Float) this.b.getAnimatedValue("scale")).floatValue());
        this.f11069a.d(((Float) this.b.getAnimatedValue("degrees")).floatValue());
        invalidateSelf();
    }

    static class b {
        b() {
        }

        static ValueAnimator b(float f, float f2) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
            valueAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.6f, 0.2f, 1.0f, 1.0f));
            valueAnimatorOfFloat.setDuration(100L);
            return valueAnimatorOfFloat;
        }

        static ValueAnimator evx_(float f, float f2) {
            return ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scale", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("degrees", f, f2));
        }

        static ValueAnimator a(float f, long j) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f);
            valueAnimatorOfFloat.setDuration(j);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            return valueAnimatorOfFloat;
        }
    }
}
