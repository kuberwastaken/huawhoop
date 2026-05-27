package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes11.dex */
public class nvm {
    private float b = 1.0f;

    public void cpQ_(final ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: nvm.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                nvm.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
                animatorUpdateListener.onAnimationUpdate(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(float f) {
        this.b = f;
    }

    public float c() {
        return this.b;
    }
}
