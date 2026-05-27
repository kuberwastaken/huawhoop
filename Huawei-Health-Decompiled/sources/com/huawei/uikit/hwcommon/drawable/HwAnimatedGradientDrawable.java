package com.huawei.uikit.hwcommon.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* JADX INFO: loaded from: classes11.dex */
public class HwAnimatedGradientDrawable extends GradientDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f11119a;
    private boolean b;
    private Animator c;
    private TimeInterpolator d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private boolean o;

    public HwAnimatedGradientDrawable(int i, float f, float f2) {
        this.d = new HwCubicBezierInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        e(i, f, f2);
    }

    private void d() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rectAlpha", this.e);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(this.d);
        if (this.f > 0.0f || this.o) {
            ObjectAnimator objectAnimatorOfFloat2 = a() < 1.0E-7f ? ObjectAnimator.ofFloat(this, "rectScale", this.g, this.h) : ObjectAnimator.ofFloat(this, "rectScale", this.h);
            objectAnimatorOfFloat2.setDuration(100L);
            objectAnimatorOfFloat2.setInterpolator(this.d);
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } else {
            b(1.0f);
            animatorSet.play(objectAnimatorOfFloat);
        }
        this.c = animatorSet;
        animatorSet.start();
    }

    private void e() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rectAlpha", 0.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(this.d);
        animatorSet.playTogether(objectAnimatorOfFloat);
        this.f11119a = animatorSet;
        animatorSet.start();
    }

    private void e(int i, float f, float f2) {
        setShape(0);
        setColor(i);
        setCornerRadius(f2);
        this.f = f2;
        this.b = false;
        this.e = f;
        this.i = 0.0f;
        this.h = 1.0f;
        this.g = 0.9f;
        this.o = false;
    }

    public float a() {
        return this.i;
    }

    public void b(float f) {
        if (f < 0.0f || f > 1.0f) {
            return;
        }
        this.j = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f = this.i;
        if (f < 1.0E-7f) {
            return;
        }
        float f2 = this.j;
        setAlpha((int) (f * 255.0f));
        canvas.save();
        canvas.scale(f2, f2, canvas.getWidth() * 0.5f, canvas.getHeight() * 0.5f);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRect(getBounds());
        outline.setAlpha(0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z2 = true;
            } else if (i == 16842919) {
                z3 = true;
            } else {
                Log.i("HwAnimatedGradientDrawable", "State = " + i);
            }
        }
        if (z2 && z3) {
            z = true;
        }
        e(z);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            c();
        } else if (!visible) {
            Log.i("HwAnimatedGradientDrawable", "isChanged = " + visible + ".");
        } else if (this.b) {
            this.i = this.e;
            this.j = this.h;
        } else {
            this.i = 0.0f;
        }
        return visible;
    }

    private void e(boolean z) {
        if (this.b != z) {
            this.b = z;
            if (z) {
                Animator animator = this.c;
                if (animator == null || !animator.isRunning()) {
                    Animator animator2 = this.f11119a;
                    if (animator2 != null && animator2.isRunning()) {
                        this.f11119a.cancel();
                    }
                    d();
                    return;
                }
                return;
            }
            Animator animator3 = this.f11119a;
            if (animator3 == null || !animator3.isRunning()) {
                Animator animator4 = this.c;
                if (animator4 != null && animator4.isRunning()) {
                    this.c.cancel();
                }
                e();
            }
        }
    }

    public HwAnimatedGradientDrawable() {
        this(201326592, 1.0f, 12.0f);
    }

    public HwAnimatedGradientDrawable(Context context) {
        this(201326592, 1.0f, context);
    }

    public HwAnimatedGradientDrawable(int i, float f, Context context) {
        this(i, f, 4.0f, context);
    }

    public HwAnimatedGradientDrawable(int i, float f, float f2, Context context) {
        this.d = new HwCubicBezierInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        if (context != null) {
            e(i, f, f2 * context.getResources().getDisplayMetrics().density);
        } else {
            e(i, f, 12.0f);
        }
    }

    private void c() {
        Animator animator = this.c;
        if (animator != null && animator.isRunning()) {
            this.c.end();
            Log.i("HwAnimatedGradientDrawable", "clearEffect: mEnterAnim is not null.");
        }
        Animator animator2 = this.f11119a;
        if (animator2 != null && animator2.isRunning()) {
            this.f11119a.end();
            Log.i("HwAnimatedGradientDrawable", "clearEffect: mExitAnim is not null.");
        }
        this.c = null;
        this.f11119a = null;
        this.b = false;
        this.i = 0.0f;
        invalidateSelf();
    }
}
