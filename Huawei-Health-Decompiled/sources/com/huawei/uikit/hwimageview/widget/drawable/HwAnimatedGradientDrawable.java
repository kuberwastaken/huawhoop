package com.huawei.uikit.hwimageview.widget.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes11.dex */
public class HwAnimatedGradientDrawable extends GradientDrawable {
    private static final TimeInterpolator e = new PathInterpolator(0.2f, 0.0f, 0.4f, 1.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f11168a;
    private float b;
    private Animator c;
    private boolean d;
    private float f;
    private boolean g;
    private float h;
    private float i;
    private float j;

    public HwAnimatedGradientDrawable() {
        this(201326592, 1.0f, 12.0f);
    }

    private void c() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rectAlpha", this.b);
        objectAnimatorOfFloat.setDuration(100L);
        TimeInterpolator timeInterpolator = e;
        objectAnimatorOfFloat.setInterpolator(timeInterpolator);
        if (getCornerRadius() > 0.0f || this.g) {
            ObjectAnimator objectAnimatorOfFloat2 = a() < 1.0E-7f ? ObjectAnimator.ofFloat(this, "rectScale", this.j, this.h) : ObjectAnimator.ofFloat(this, "rectScale", this.h);
            objectAnimatorOfFloat2.setDuration(100L);
            objectAnimatorOfFloat2.setInterpolator(timeInterpolator);
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } else {
            e(1.0f);
            animatorSet.play(objectAnimatorOfFloat);
        }
        this.f11168a = animatorSet;
        animatorSet.start();
    }

    private void e() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rectAlpha", 0.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(e);
        animatorSet.playTogether(objectAnimatorOfFloat);
        this.c = animatorSet;
        animatorSet.start();
    }

    private void e(int i, float f, float f2) {
        setShape(0);
        setColor(i);
        setCornerRadius(f2);
        this.d = false;
        this.b = f;
        this.i = 0.0f;
        this.h = 1.0f;
        this.j = 0.9f;
        this.g = false;
    }

    public float a() {
        return this.i;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f = this.i;
        if (f < 1.0E-7f) {
            return;
        }
        setAlpha((int) (f * 255.0f));
        canvas.save();
        float f2 = this.f;
        canvas.scale(f2, f2, canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f);
        super.draw(canvas);
        canvas.restore();
    }

    public void e(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.f = f;
            invalidateSelf();
        } else {
            Log.w("HwAnimatedGradientDraw", "illegal params: rectScale = " + f);
        }
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
                Log.w("HwAnimatedGradientDraw", "onStateChange: wrong state");
            }
        }
        if (z2 && z3) {
            z = true;
        }
        d(z);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            d();
        } else if (!visible) {
            Log.w("HwAnimatedGradientDraw", "setVisible: unexpected visibility state");
        } else if (this.d) {
            this.i = this.b;
            this.f = this.h;
        } else {
            this.i = 0.0f;
        }
        return visible;
    }

    public HwAnimatedGradientDrawable(int i, float f, float f2) {
        e(i, f, f2);
    }

    public HwAnimatedGradientDrawable(Context context) {
        this(201326592, 1.0f, context);
    }

    public HwAnimatedGradientDrawable(int i, float f, Context context) {
        this(i, f, 4.0f, context);
    }

    public HwAnimatedGradientDrawable(int i, float f, float f2, Context context) {
        if (context != null) {
            e(i, f, f2 * context.getResources().getDisplayMetrics().density);
        } else {
            e(i, f, 12.0f);
        }
    }

    private void d(boolean z) {
        if (this.d != z) {
            this.d = z;
            if (z) {
                Animator animator = this.f11168a;
                if (animator == null || !animator.isRunning()) {
                    Animator animator2 = this.c;
                    if (animator2 != null && animator2.isRunning()) {
                        this.c.cancel();
                    }
                    c();
                    return;
                }
                return;
            }
            Animator animator3 = this.c;
            if (animator3 == null || !animator3.isRunning()) {
                Animator animator4 = this.f11168a;
                if (animator4 != null && animator4.isRunning()) {
                    this.f11168a.cancel();
                }
                e();
            }
        }
    }

    private void d() {
        Animator animator = this.f11168a;
        if (animator != null && animator.isRunning()) {
            this.f11168a.end();
        }
        Animator animator2 = this.c;
        if (animator2 != null && animator2.isRunning()) {
            this.c.end();
        }
        this.f11168a = null;
        this.c = null;
        this.d = false;
        this.i = 0.0f;
        invalidateSelf();
    }
}
