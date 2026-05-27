package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public class ouz extends Drawable implements Animatable, Drawable.Callback, Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16568a;
    private boolean b;
    private ObjectAnimator c;
    private Animator.AnimatorListener d;
    private Drawable e;
    private View f;
    private int g;
    private Drawable j;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    private void e() {
        setBounds(0, 0, this.g, this.f16568a);
        this.j.setBounds(0, 0, this.g, this.f16568a);
        this.e.setBounds(0, 0, this.g, this.f16568a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() {
        /*
            r4 = this;
            android.view.View r0 = r4.f
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L3a
            int r0 = r0.getWidth()
            if (r0 == 0) goto L1f
            android.view.View r0 = r4.f
            int r0 = r0.getWidth()
            int r3 = r4.g
            if (r0 == r3) goto L1f
            android.view.View r0 = r4.f
            int r0 = r0.getWidth()
            r4.g = r0
            r2 = r1
        L1f:
            android.view.View r0 = r4.f
            int r0 = r0.getHeight()
            if (r0 == 0) goto L3a
            android.view.View r0 = r4.f
            int r0 = r0.getHeight()
            int r3 = r4.f16568a
            if (r0 == r3) goto L3a
            android.view.View r0 = r4.f
            int r0 = r0.getHeight()
            r4.f16568a = r0
            r2 = r1
        L3a:
            android.graphics.drawable.Drawable r0 = r4.e
            if (r0 == 0) goto L58
            int r3 = r4.g
            if (r3 > 0) goto L49
            int r0 = r0.getIntrinsicWidth()
            r4.g = r0
            goto L4a
        L49:
            r1 = r2
        L4a:
            int r0 = r4.f16568a
            if (r0 > 0) goto L57
            android.graphics.drawable.Drawable r0 = r4.e
            int r0 = r0.getIntrinsicHeight()
            r4.f16568a = r0
            goto L5a
        L57:
            r2 = r1
        L58:
            if (r2 == 0) goto L5d
        L5a:
            r4.e()
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ouz.c():void");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        View view = this.f;
        if (view != null && !view.getGlobalVisibleRect(new Rect())) {
            this.b = true;
        } else {
            this.c.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.c.end();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ObjectAnimator objectAnimator = this.c;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.b) {
            this.j.draw(canvas);
        }
        this.e.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (255 <= i) {
            this.b = true;
        }
        if (this.b) {
            this.e.setAlpha(255);
        } else {
            this.e.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        c();
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        c();
        return this.f16568a;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        invalidateSelf();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Animator.AnimatorListener animatorListener = this.d;
        if (animatorListener != null) {
            animatorListener.onAnimationStart(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Animator.AnimatorListener animatorListener = this.d;
        if (animatorListener != null) {
            animatorListener.onAnimationEnd(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Animator.AnimatorListener animatorListener = this.d;
        if (animatorListener != null) {
            animatorListener.onAnimationCancel(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Animator.AnimatorListener animatorListener = this.d;
        if (animatorListener != null) {
            animatorListener.onAnimationRepeat(animator);
        }
    }
}
