package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes7.dex */
public class phf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16697a = 1.0f;
    private float e = 1.0f;
    private float c = 1.0f;

    public void cNl_(final ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: phf.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                phf.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                animatorUpdateListener.onAnimationUpdate(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.start();
    }

    public void cNk_(final ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: phf.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                phf.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
                animatorUpdateListener.onAnimationUpdate(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.start();
    }

    public void cNj_(final ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: phf.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                phf.this.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
                animatorUpdateListener.onAnimationUpdate(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.start();
    }

    public void c(float f) {
        this.f16697a = f;
    }

    public float c() {
        return this.f16697a;
    }

    public void a(float f) {
        this.e = f;
    }

    public float b() {
        return this.e;
    }

    public void e(float f) {
        this.c = f;
    }

    public float a() {
        return this.c;
    }
}
