package com.huawei.uikit.animations.drawable;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import com.huawei.health.R;
import defpackage.vmk;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes11.dex */
public class HwHoverAndPressAnimatedDrawable extends GradientDrawable {
    private static final int DURATION_HOVER = 250;
    private static final int DURATION_PRESS = 100;
    private static final int INVALID_SIZE = -1;
    private ObjectAnimator mAlphaEnterAnim;
    private ObjectAnimator mAlphaExitAnim;
    private Interpolator mHoveredInterpolator;
    private boolean mIsHovered;
    private boolean mIsPressed;
    private Interpolator mPressedInterpolator;
    private c mState;

    static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11083a;
        int b;
        ColorStateList c;
        boolean d;
        int e;
        float f;
        int g;
        int h;
        int i;
        float[] j;

        private static int evs_(Resources resources, int i) {
            if (resources != null) {
                i = resources.getDisplayMetrics().densityDpi;
            }
            if (i == 0) {
                return 160;
            }
            return i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new HwHoverAndPressAnimatedDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new HwHoverAndPressAnimatedDrawable(evs_(resources, this.b) != this.b ? new c(this, resources) : this);
        }

        private c() {
            this.d = false;
            this.b = 160;
            this.g = 0;
            this.f = 0.0f;
            this.j = null;
            this.h = -1;
            this.i = -1;
        }

        private c(c cVar, Resources resources) {
            this.d = false;
            this.b = 160;
            this.g = 0;
            this.f = 0.0f;
            this.j = null;
            this.h = -1;
            this.i = -1;
            this.g = cVar.g;
            this.f = cVar.f;
            float[] fArr = cVar.j;
            if (fArr != null) {
                this.j = (float[]) fArr.clone();
            }
            this.c = cVar.c;
            this.h = cVar.h;
            this.i = cVar.i;
            this.f11083a = cVar.f11083a;
            this.e = cVar.e;
            this.d = cVar.d;
            this.b = evs_(resources, cVar.b);
        }
    }

    private void clearEffect() {
        ObjectAnimator objectAnimator = this.mAlphaEnterAnim;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mAlphaEnterAnim.end();
        }
        ObjectAnimator objectAnimator2 = this.mAlphaExitAnim;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.mAlphaExitAnim.end();
        }
        this.mAlphaExitAnim = null;
        this.mAlphaEnterAnim = null;
        this.mIsHovered = false;
        this.mIsPressed = false;
        setAlpha(0);
        invalidateSelf();
    }

    private void preInflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, new int[]{R.attr._2131100548_res_0x7f060384, R.attr._2131100625_res_0x7f0603d1}) : theme.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100548_res_0x7f060384, R.attr._2131100625_res_0x7f0603d1}, 0, 0);
        int color = typedArrayObtainAttributes.getColor(0, 0);
        int color2 = typedArrayObtainAttributes.getColor(1, 0);
        if (color2 != 0) {
            this.mState.d = true;
        }
        int iAlpha = Color.alpha(color);
        int iAlpha2 = Color.alpha(color2);
        this.mState.c = ColorStateList.valueOf(this.mState.d ? Color.rgb(Color.red(color2), Color.green(color2), Color.blue(color2)) : Color.rgb(Color.red(color), Color.green(color), Color.blue(color)));
        c cVar = this.mState;
        cVar.f11083a = iAlpha;
        cVar.e = iAlpha2;
        typedArrayObtainAttributes.recycle();
    }

    private void setHoveredAnimation(boolean z) {
        if (this.mIsHovered != z) {
            this.mIsHovered = z;
            if (!z) {
                startExitAnim(0, 250, this.mHoveredInterpolator);
            } else {
                if (this.mIsPressed) {
                    return;
                }
                startEnterAnim(this.mState.f11083a, 250, this.mHoveredInterpolator);
            }
        }
    }

    private void setPressedAnimation(boolean z) {
        if (this.mIsPressed != z) {
            this.mIsPressed = z;
            if (z) {
                startEnterAnim(this.mState.e, 100, this.mPressedInterpolator);
            } else {
                startExitAnim(this.mIsHovered ? this.mState.f11083a : 0, 100, this.mPressedInterpolator);
            }
        }
    }

    private void startEnterAnim(int i, int i2, Interpolator interpolator) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alpha", i);
        this.mAlphaEnterAnim = objectAnimatorOfInt;
        objectAnimatorOfInt.setAutoCancel(true);
        this.mAlphaEnterAnim.setDuration(i2);
        this.mAlphaEnterAnim.setInterpolator(interpolator);
        this.mAlphaEnterAnim.start();
    }

    private void startExitAnim(int i, int i2, Interpolator interpolator) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alpha", i);
        this.mAlphaExitAnim = objectAnimatorOfInt;
        objectAnimatorOfInt.setAutoCancel(true);
        this.mAlphaExitAnim.setDuration(i2);
        this.mAlphaExitAnim.setInterpolator(interpolator);
        this.mAlphaExitAnim.start();
    }

    private void updateLocalStates() {
        this.mState.f = getCornerRadius();
        this.mState.g = getShape();
        this.mState.h = getIntrinsicWidth();
        this.mState.i = getIntrinsicHeight();
        try {
            this.mState.j = getCornerRadii();
        } catch (NullPointerException unused) {
            this.mState.j = null;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getColor() != null && this.mState.c != null && getColor().getDefaultColor() != this.mState.c.getDefaultColor()) {
            setColor(this.mState.c);
        }
        super.draw(canvas);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.mState;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        preInflate(resources, attributeSet, theme);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        setColor(this.mState.c);
        updateLocalStates();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (super.mutate() == this) {
            c cVar = new c(this.mState, null);
            this.mState = cVar;
            cVar.c = getColor();
            updateLocalStates();
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean onStateChange(int[] r9) {
        /*
            r8 = this;
            int r0 = r9.length
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
        L5:
            r5 = 1
            if (r1 >= r0) goto L27
            r6 = r9[r1]
            r7 = 16842910(0x101009e, float:2.3694E-38)
            if (r6 != r7) goto L10
            goto L23
        L10:
            r7 = 16842919(0x10100a7, float:2.3694026E-38)
            if (r6 != r7) goto L17
            r4 = r5
            goto L24
        L17:
            r7 = 16843623(0x1010367, float:2.3696E-38)
            if (r6 != r7) goto L1e
            r3 = r5
            goto L24
        L1e:
            r7 = 16842908(0x101009c, float:2.3693995E-38)
            if (r6 != r7) goto L24
        L23:
            r2 = r5
        L24:
            int r1 = r1 + 1
            goto L5
        L27:
            if (r2 != 0) goto L2d
            r8.clearEffect()
            return r5
        L2d:
            r8.setHoveredAnimation(r3)
            com.huawei.uikit.animations.drawable.HwHoverAndPressAnimatedDrawable$c r9 = r8.mState
            boolean r9 = r9.d
            if (r9 == 0) goto L39
            r8.setPressedAnimation(r4)
        L39:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.animations.drawable.HwHoverAndPressAnimatedDrawable.onStateChange(int[]):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            clearEffect();
        }
        return visible;
    }

    public HwHoverAndPressAnimatedDrawable() {
        this(new c());
    }

    private HwHoverAndPressAnimatedDrawable(c cVar) {
        this.mHoveredInterpolator = vmk.evy_();
        this.mPressedInterpolator = vmk.evz_();
        this.mIsHovered = false;
        this.mIsPressed = false;
        this.mState = cVar;
        setShape(cVar.g);
        setSize(cVar.h, cVar.i);
        setBounds(new Rect(0, 0, cVar.h, cVar.i));
        setColor(cVar.c);
        float[] fArr = cVar.j;
        if (this.mState.j == null) {
            setCornerRadius(cVar.f);
        } else {
            setCornerRadii(fArr);
        }
        setAlpha(0);
    }
}
