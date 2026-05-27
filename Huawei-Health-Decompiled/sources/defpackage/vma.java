package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes8.dex */
public class vma {
    public static ValueAnimator euQ_(int i, boolean z) {
        return euP_(i, z ? 0 : 255);
    }

    public static Animator euR_(View view, float f) {
        Interpolator interpolatorEvy_ = vmk.evy_();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", view.getScaleX(), f);
        objectAnimatorOfFloat.setInterpolator(interpolatorEvy_);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setAutoCancel(true);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", view.getScaleY(), f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorEvy_);
        objectAnimatorOfFloat2.setDuration(250L);
        objectAnimatorOfFloat2.setAutoCancel(true);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    public static ValueAnimator euP_(int i, int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setInterpolator(vmk.evy_());
        valueAnimatorOfInt.setDuration(250L);
        return valueAnimatorOfInt;
    }
}
