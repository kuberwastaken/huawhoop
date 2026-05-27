package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes5.dex */
public final class ist {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PathInterpolator f14244a;
    private static PathInterpolator b;
    private static PathInterpolator e;

    public static AnimationSet bmW_() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(bmX_());
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    public static AnimationSet bnf_() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(bmZ_());
        scaleAnimation.setDuration(150L);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(2);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    public static AnimatorSet bnc_() {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("scaleX");
        objectAnimator.setFloatValues(0.0f, 1.73f);
        objectAnimator.setDuration(200L);
        ObjectAnimator objectAnimator2 = new ObjectAnimator();
        objectAnimator2.setPropertyName("scaleY");
        objectAnimator2.setFloatValues(0.0f, 1.73f);
        objectAnimator2.setDuration(200L);
        ObjectAnimator objectAnimator3 = new ObjectAnimator();
        objectAnimator3.setPropertyName("alpha");
        objectAnimator3.setFloatValues(0.0f, 1.0f);
        objectAnimator3.setDuration(100L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator, objectAnimator2, objectAnimator3);
        ObjectAnimator objectAnimator4 = new ObjectAnimator();
        objectAnimator4.setPropertyName("scaleX");
        objectAnimator4.setFloatValues(1.73f, 1.17f);
        objectAnimator4.setDuration(200L);
        ObjectAnimator objectAnimator5 = new ObjectAnimator();
        objectAnimator5.setPropertyName("scaleY");
        objectAnimator5.setFloatValues(1.73f, 1.17f);
        objectAnimator5.setDuration(200L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(objectAnimator4, objectAnimator5);
        ObjectAnimator objectAnimator6 = new ObjectAnimator();
        objectAnimator6.setPropertyName("scaleX");
        objectAnimator6.setFloatValues(1.17f, 1.25f);
        objectAnimator6.setDuration(150L);
        ObjectAnimator objectAnimator7 = new ObjectAnimator();
        objectAnimator7.setPropertyName("scaleY");
        objectAnimator7.setFloatValues(1.17f, 1.25f);
        objectAnimator7.setDuration(150L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(objectAnimator6, objectAnimator7);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.setInterpolator(bmY_());
        animatorSet4.playSequentially(animatorSet, animatorSet2, animatorSet3);
        return animatorSet4;
    }

    public static AnimatorSet bnd_() {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("scaleX");
        objectAnimator.setFloatValues(0.6f, 1.0f);
        objectAnimator.setDuration(400L);
        ObjectAnimator objectAnimator2 = new ObjectAnimator();
        objectAnimator2.setPropertyName("scaleY");
        objectAnimator2.setFloatValues(0.6f, 1.0f);
        objectAnimator2.setDuration(400L);
        ObjectAnimator objectAnimator3 = new ObjectAnimator();
        objectAnimator3.setPropertyName("alpha");
        objectAnimator3.setFloatValues(0.0f, 1.0f);
        objectAnimator3.setDuration(100L);
        ObjectAnimator objectAnimator4 = new ObjectAnimator();
        objectAnimator4.setPropertyName("alpha");
        objectAnimator4.setFloatValues(1.0f, 0.0f);
        objectAnimator4.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(bmY_());
        animatorSet.play(objectAnimator3).with(objectAnimator).with(objectAnimator2);
        animatorSet.play(objectAnimator4).after(objectAnimator3);
        return animatorSet;
    }

    public static AnimationSet bna_() {
        return bnb_(500L);
    }

    public static AnimationSet bnb_(long j) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.85f, 1.0f, 0.85f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(bmZ_());
        scaleAnimation.setDuration(j);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    public static AnimationSet bne_() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(bmY_());
        alphaAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    public static PathInterpolator bmZ_() {
        if (b == null) {
            b = new PathInterpolator(0.27f, 1.6f, 0.34f, 1.0f);
        }
        return b;
    }

    public static PathInterpolator bmX_() {
        if (e == null) {
            e = new PathInterpolator(0.2f, 0.0f, 0.2f, 1.0f);
        }
        return e;
    }

    public static PathInterpolator bmY_() {
        if (f14244a == null) {
            f14244a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        }
        return f14244a;
    }
}
