package com.huawei.uikit.hwdragdowntransition.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes11.dex */
public class HwDragDownTransition {
    private static final String e = "HwDragDownTransition";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11153a;
    private float aa;
    private float ab;
    private float ac;
    private float ad;
    private float ae;
    private float af;
    private float ag;
    private float ah;
    private float ai;
    private boolean an;
    private Rect b;
    private boolean c;
    private Matrix d;
    private bqmxo f;
    private Animator g;
    private PropertyValuesHolder h;
    private TimeInterpolator i;
    private Animator j;
    private View k;
    private float l;
    private float m;
    private HwDragDownAnimationListener n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwDragDownTransition.this.b(0.0f, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class bqmxo extends View {
        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (canvas != null) {
                canvas.drawColor(-16777216);
            }
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwDragDownTransition.this.f.setVisibility(8);
            HwDragDownTransition.this.k.setVisibility(8);
            HwDragDownTransition.this.i();
            HwDragDownTransition.this.b(0.0f, 0.0f);
            if (HwDragDownTransition.this.n != null) {
                HwDragDownTransition.this.n.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (HwDragDownTransition.this.n != null) {
                HwDragDownTransition.this.n.onAnimationStart();
            }
        }
    }

    private boolean b() {
        return (!this.c || this.k == null || this.b == null) ? false : true;
    }

    private void f() {
        if (Math.abs(this.s) > this.ai) {
            h();
        } else {
            l();
        }
    }

    private void g() {
        if (this.k == null) {
            return;
        }
        if (this.p == 0.0f) {
            a();
        }
        float fAbs = this.ae == 0.0f ? 0.0f : Math.abs(this.s) / this.ae;
        float f = this.w;
        float f2 = f - ((fAbs * f) * 0.39999998f);
        float f3 = this.r;
        float f4 = f3 - ((fAbs * f3) * 0.39999998f);
        this.k.setScaleX(f2);
        this.k.setScaleY(f4);
        this.d.reset();
        this.d.preScale(this.w, this.r, this.af, this.ag);
        this.d.postTranslate(this.y, this.x);
        this.d.postScale(f2 / this.w, f4 / this.r, this.o, this.l);
        this.d.postTranslate(this.q, this.s);
        float[] fArr = new float[9];
        this.d.getValues(fArr);
        float f5 = fArr[2];
        float f6 = fArr[5];
        float f7 = fArr[0];
        float f8 = fArr[4];
        this.k.setPivotX(0.0f);
        this.k.setPivotY(0.0f);
        this.k.setScaleX(f7);
        this.k.setScaleY(f8);
        this.k.setTranslationX(f5);
        this.k.setTranslationY(f6);
        float f9 = 1.0f - (fAbs * 0.39999998f);
        this.f.setAlpha(f9);
        HwDragDownAnimationListener hwDragDownAnimationListener = this.n;
        if (hwDragDownAnimationListener != null) {
            hwDragDownAnimationListener.onAlphaChanged(f9);
        }
        this.ad = f2;
        this.z = f9;
        this.aa = f5;
        this.ac = f6;
    }

    private void h() {
        if (e()) {
            return;
        }
        if (this.g == null) {
            PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("Progress", 0.0f, 1.0f);
            this.h = propertyValuesHolderOfFloat;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfFloat);
            this.g = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.addListener(new c());
            this.g.setDuration(200L);
            this.g.setInterpolator(this.i);
        }
        this.g.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ViewParent parent = this.k.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.removeView(this.k);
            viewGroup.removeView(this.f);
        }
    }

    private void j() {
        if ((Math.abs(this.q) > 8.0f || Math.abs(this.s) > 8.0f) && this.an) {
            this.an = false;
            float f = this.s;
            if (f <= 0.0f || Math.abs(f) <= Math.abs(this.q)) {
                return;
            }
            this.f11153a = true;
        }
    }

    private void l() {
        if (e()) {
            return;
        }
        if (this.j == null) {
            PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("ResetProgress", 0.0f, 1.0f);
            this.h = propertyValuesHolderOfFloat;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfFloat);
            this.j = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.addListener(new b());
            this.j.setDuration(200L);
            this.j.setInterpolator(this.i);
        }
        this.j.start();
    }

    public void c(HwDragDownAnimationListener hwDragDownAnimationListener) {
        this.n = hwDragDownAnimationListener;
    }

    public void d() {
        ViewParent parent = this.k.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int iIndexOfChild = viewGroup.indexOfChild(this.k);
        this.f.setAlpha(1.0f);
        viewGroup.addView(this.f, iIndexOfChild);
        this.f.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean eAQ_(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto Lb
            java.lang.String r8 = com.huawei.uikit.hwdragdowntransition.anim.HwDragDownTransition.e
            java.lang.String r1 = "onTouchEvent: motionEvent is null!"
            android.util.Log.w(r8, r1)
            return r0
        Lb:
            boolean r1 = r7.b()
            if (r1 != 0) goto L19
            java.lang.String r8 = com.huawei.uikit.hwdragdowntransition.anim.HwDragDownTransition.e
            java.lang.String r1 = "onTouchEvent: Not a valid Transition setting, do not handle!"
            android.util.Log.w(r8, r1)
            return r0
        L19:
            float r1 = r8.getRawX()
            float r2 = r8.getRawY()
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r8)
            r8.setLocation(r1, r2)
            int r3 = r8.getActionMasked()
            r4 = 1
            if (r3 == 0) goto L7a
            r5 = 0
            if (r3 == r4) goto L61
            r6 = 2
            if (r3 == r6) goto L39
            r1 = 6
            if (r3 == r1) goto L61
            goto L7d
        L39:
            int r0 = r8.getActionIndex()
            int r0 = r8.getPointerId(r0)
            if (r0 == 0) goto L44
            goto L7d
        L44:
            float r0 = r7.o
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L53
            float r0 = r7.l
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L53
            r7.b(r1, r2)
        L53:
            r7.c(r1, r2)
            r7.j()
            boolean r0 = r7.f11153a
            if (r0 == 0) goto L7d
            r7.g()
            goto L7d
        L61:
            int r1 = r8.getActionIndex()
            int r1 = r8.getPointerId(r1)
            if (r1 != 0) goto L7d
            boolean r1 = r7.f11153a
            if (r1 != 0) goto L76
            r7.b(r5, r5)
            r8.recycle()
            return r0
        L76:
            r7.f()
            goto L7d
        L7a:
            r7.b(r1, r2)
        L7d:
            r8.recycle()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwdragdowntransition.anim.HwDragDownTransition.eAQ_(android.view.MotionEvent):boolean");
    }

    public void eAR_(Rect rect) {
        this.b = rect;
    }

    private void c(float f, float f2) {
        this.s = f2 - this.l;
        this.q = f - this.o;
        this.m = f;
        this.t = f2;
    }

    private boolean e() {
        Animator animator;
        Animator animator2 = this.g;
        return (animator2 != null && animator2.isStarted()) || ((animator = this.j) != null && animator.isStarted());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f, float f2) {
        this.o = f;
        this.l = f2;
        this.m = f;
        this.t = f2;
        c();
        this.an = true;
        this.f11153a = false;
    }

    private void a() {
        float width;
        float height;
        int[] iArr = new int[2];
        this.k.getLocationOnScreen(iArr);
        int iWidth = this.b.width();
        int iHeight = this.b.height();
        View view = this.k;
        if (view instanceof ImageView) {
            RectF rectF = new RectF();
            Drawable drawable = ((ImageView) this.k).getDrawable();
            Matrix imageMatrix = ((ImageView) this.k).getImageMatrix();
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            imageMatrix.mapRect(rectF);
            width = rectF.right - rectF.left;
            height = rectF.bottom - rectF.top;
        } else {
            width = view.getWidth();
            height = this.k.getHeight();
        }
        float fWidth = this.b.width() / width;
        float fHeight = this.b.height() / height;
        this.p = fWidth > fHeight ? fWidth : fHeight;
        if (fWidth < fHeight) {
            this.ab = ((this.k.getWidth() * fHeight) - iWidth) * (-0.5f);
        } else {
            this.ah = ((this.k.getHeight() * fWidth) - iHeight) * (-0.5f);
        }
        float f = this.w;
        float width2 = this.k.getWidth();
        float f2 = iArr[0];
        float f3 = this.y;
        float f4 = this.r;
        float height2 = this.k.getHeight();
        float f5 = iArr[1];
        float f6 = this.x;
        Rect rect = this.b;
        this.u = ((rect.left + rect.right) * 0.5f) - ((((f * width2) * 0.5f) + f2) - f3);
        this.v = ((rect.top + rect.bottom) * 0.5f) - ((((f4 * height2) * 0.5f) + f5) - f6);
    }

    private void c() {
        this.y = this.k.getTranslationX();
        this.x = this.k.getTranslationY();
        this.r = this.k.getScaleY();
        this.w = this.k.getScaleX();
        this.af = this.k.getPivotX();
        this.ag = this.k.getPivotY();
        this.z = 1.0f;
        this.ad = this.w;
        this.aa = this.y;
        this.ac = this.x;
    }
}
