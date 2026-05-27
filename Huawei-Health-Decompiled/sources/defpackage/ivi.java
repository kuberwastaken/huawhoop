package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class ivi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PointF f14315a;
    private SecureRandom b = new SecureRandom();
    private float c;
    private final float d;
    private ImageView e;
    private final float f;
    private float g;
    private float h;
    private PointF j;

    public ivi(ImageView imageView, PointF pointF) {
        imageView.setVisibility(4);
        this.e = imageView;
        this.f14315a = pointF;
        this.c = 0.0f;
        this.f = c(0.2f, 1.0f);
        float fC = c(0.4f, 1.6f);
        this.d = fC;
        this.h = fC * 0.4f;
        this.g = c(0.0f, 360.0f);
        int i = plt.i(imageView.getContext()) / 2;
        this.j = bqy_(c(i - 250, i + 250), pointF, c(0.1f, 6.27f));
        imageView.setAlpha(this.c);
        imageView.setRotation(this.g);
    }

    private PointF bqy_(double d, PointF pointF, double d2) {
        PointF pointF2 = new PointF();
        float fCos = (float) (((double) pointF.x) + (Math.cos(d2) * d));
        float fSin = (float) (((double) pointF.y) + (d * Math.sin(d2)));
        pointF2.x = fCos;
        pointF2.y = fSin;
        return pointF2;
    }

    private float c(float f, float f2) {
        return (this.b.nextFloat() * (f2 - f)) + f;
    }

    private int b() {
        return this.b.nextInt(400) + 2800;
    }

    public void a() {
        final long jB = b();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "alpha", this.c, this.f);
        objectAnimatorOfFloat.setDuration(jB / 4);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "alpha", this.f, this.c);
        objectAnimatorOfFloat2.setDuration((3 * jB) / 4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.e, "scaleX", this.d, this.h);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.e, "scaleY", this.d, this.h);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(jB);
        animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        AnimatorSet animatorSet3 = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.e, "x", this.f14315a.x, this.j.x);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.e, "y", this.f14315a.y, this.j.y);
        animatorSet3.setDuration(jB);
        animatorSet3.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.playTogether(animatorSet3, animatorSet2, animatorSet);
        animatorSet4.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
        animatorSet4.addListener(new AnimatorListenerAdapter() { // from class: ivi.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ivi.this.e.setVisibility(0);
                ivi.this.e.animate().rotationBy(180.0f).setDuration(jB).start();
            }
        });
        animatorSet4.start();
    }
}
