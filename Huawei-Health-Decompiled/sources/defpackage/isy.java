package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: loaded from: classes5.dex */
public class isy {
    public static AnimatorSet bnq_() {
        PathInterpolator pathInterpolatorBmY_ = ist.bmY_();
        ObjectAnimator objectAnimatorBnr_ = bnr_(0.0f, 1.0f, 200L);
        objectAnimatorBnr_.setInterpolator(pathInterpolatorBmY_);
        ObjectAnimator objectAnimatorBnr_2 = bnr_(1.0f, 0.5f, 1000L);
        objectAnimatorBnr_2.setInterpolator(pathInterpolatorBmY_);
        objectAnimatorBnr_2.setRepeatCount(-1);
        objectAnimatorBnr_2.setRepeatMode(2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorBnr_).before(objectAnimatorBnr_2);
        return animatorSet;
    }

    private static ObjectAnimator bnr_(float f, float f2, long j) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("alpha");
        objectAnimator.setFloatValues(f, f2);
        objectAnimator.setDuration(j);
        return objectAnimator;
    }

    public static AnimatorSet bns_(int i, boolean z) {
        PathInterpolator pathInterpolatorBmY_ = ist.bmY_();
        ObjectAnimator objectAnimatorBnr_ = bnr_(0.0f, 1.0f, 150L);
        objectAnimatorBnr_.setInterpolator(pathInterpolatorBmY_);
        ObjectAnimator objectAnimatorBnr_2 = bnr_(1.0f, 1.0f, 450L);
        objectAnimatorBnr_2.setInterpolator(pathInterpolatorBmY_);
        ObjectAnimator objectAnimatorBnr_3 = bnr_(1.0f, 0.0f, 400L);
        objectAnimatorBnr_3.setInterpolator(pathInterpolatorBmY_);
        objectAnimatorBnr_3.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorBnr_, objectAnimatorBnr_2, objectAnimatorBnr_3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(bnt_(i, z), animatorSet);
        return animatorSet2;
    }

    private static ObjectAnimator bnt_(int i, boolean z) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        if (z) {
            objectAnimator.setPropertyName("translationY");
            if (i == 1) {
                objectAnimator.setFloatValues(200.0f);
            } else {
                objectAnimator.setFloatValues(-200.0f);
            }
        } else {
            objectAnimator.setPropertyName("translationX");
            if (i == 1) {
                objectAnimator.setFloatValues(-200.0f);
            } else {
                objectAnimator.setFloatValues(200.0f);
            }
        }
        objectAnimator.setDuration(1000L);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
        return objectAnimator;
    }

    public static AlphaAnimation bnp_() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setInterpolator(new FastOutSlowInInterpolator());
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        return alphaAnimation;
    }

    public static AnimationSet bno_(int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 0, 0.0f, 0, i);
        translateAnimation.setDuration(2000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(2000L);
        alphaAnimation.setFillAfter(false);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }
}
