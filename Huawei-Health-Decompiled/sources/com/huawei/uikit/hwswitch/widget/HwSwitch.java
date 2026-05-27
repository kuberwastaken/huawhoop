package com.huawei.uikit.hwswitch.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.Switch;
import com.huawei.health.R;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import defpackage.vnl;
import defpackage.vpd;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class HwSwitch extends Switch {
    private static final Property<HwSwitch, Float> e = new d("thumbPos");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11262a;
    private ObjectAnimator b;
    public Drawable c;
    private Drawable d;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private float m;
    private int n;
    private int o;
    private int p;
    private VelocityTracker q;
    private float r;
    private final Rect s;
    private float t;
    private int u;

    class d extends FloatProperty<HwSwitch> {
        d(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float get(HwSwitch hwSwitch) {
            if (hwSwitch == null) {
                return null;
            }
            return Float.valueOf(hwSwitch.m);
        }

        @Override // android.util.FloatProperty
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void setValue(HwSwitch hwSwitch, float f) {
            if (hwSwitch == null) {
                Log.w("HwSwitch", "setValue: HwSwitch object is null!");
            } else {
                hwSwitch.setThumbPosition(f);
            }
        }
    }

    public HwSwitch(Context context) {
        this(context, null);
    }

    private void a() {
        if (this.d == null) {
            Object objA = vnl.a(this, "mThumbDrawable", Switch.class);
            if (objA instanceof Drawable) {
                this.d = (Drawable) objA;
            }
        }
        if (this.c == null) {
            Object objA2 = vnl.a(this, "mTrackDrawable", Switch.class);
            if (objA2 instanceof Drawable) {
                this.c = (Drawable) objA2;
            }
        }
        Object objA3 = vnl.a(this, "mThumbWidth", Switch.class);
        if (objA3 instanceof Integer) {
            this.g = ((Integer) objA3).intValue();
        }
    }

    private void b() {
        Object objA = vnl.a(this, "mSwitchWidth", Switch.class);
        if (objA instanceof Integer) {
            this.f11262a = ((Integer) objA).intValue();
        }
        Object objA2 = vnl.a(this, "mSwitchHeight", Switch.class);
        if (objA2 instanceof Integer) {
            this.p = ((Integer) objA2).intValue();
        }
    }

    private void c() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private float e(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private void e() {
        Drawable.Callback callback = this.d.getCallback();
        this.d.setCallback(null);
        this.d.setBounds(0, 0, 0, 0);
        this.d.setCallback(callback);
    }

    private boolean eFQ_(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int thumbScrollRange = getThumbScrollRange();
        float f = x - this.r;
        float f2 = thumbScrollRange != 0 ? f / thumbScrollRange : f > 0.0f ? 1.0f : -1.0f;
        if (j()) {
            f2 = -f2;
        }
        float fE = e(this.m + f2, 0.0f, 1.0f);
        if (fE == this.m) {
            return true;
        }
        this.r = x;
        setThumbPosition(fE);
        return true;
    }

    private boolean f() {
        String language = Locale.getDefault().getLanguage();
        return (language.contains("ar") || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(Constants.URDU_LANG) || j());
    }

    private int getThumbOffset() {
        return (int) (((!f() ? this.m : 1.0f - this.m) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Insets insets;
        Drawable drawable = this.c;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.s;
        drawable.getPadding(rect);
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            Object objB = vnl.b(drawable2, "getOpticalInsets", null, null, DrawableContainer.class);
            insets = objB instanceof Insets ? (Insets) objB : Insets.NONE;
        } else {
            insets = Insets.NONE;
        }
        Object objA = vnl.a(this, "mSwitchWidth", Switch.class);
        if (objA instanceof Integer) {
            this.f11262a = ((Integer) objA).intValue();
        }
        int i = this.f11262a;
        int i2 = this.g;
        int i3 = rect.left;
        int i4 = rect.right;
        int i5 = insets.left;
        int i6 = insets.right;
        int i7 = this.o;
        return (((((i - i2) - i3) - i4) - i5) - i6) - (i7 + i7);
    }

    private boolean i() {
        return this.m > 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f) {
        this.m = f;
        invalidate();
    }

    public int getFocusedPathColor() {
        return this.u;
    }

    @Override // android.widget.Switch, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        a();
        a(canvas);
        super.onDraw(canvas);
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    @Override // android.widget.Switch, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        /*
            r1 = this;
            super.onLayout(r2, r3, r4, r5, r6)
            r1.a()
            r1.b()
            android.graphics.drawable.Drawable r2 = r1.d
            r3 = 0
            if (r2 == 0) goto L40
            android.graphics.Rect r2 = r1.s
            android.graphics.drawable.Drawable r4 = r1.c
            if (r4 == 0) goto L18
            r4.getPadding(r2)
            goto L1b
        L18:
            r2.setEmpty()
        L1b:
            android.graphics.drawable.Drawable r4 = r1.d
            java.lang.String r5 = "getOpticalInsets"
            java.lang.Class<android.graphics.drawable.DrawableContainer> r6 = android.graphics.drawable.DrawableContainer.class
            r0 = 0
            java.lang.Object r4 = defpackage.vnl.b(r4, r5, r0, r0, r6)
            boolean r5 = r4 instanceof android.graphics.Insets
            if (r5 == 0) goto L40
            android.graphics.Insets r4 = (android.graphics.Insets) r4
            int r5 = r4.left
            int r6 = r2.left
            int r5 = r5 - r6
            if (r5 > 0) goto L34
            r5 = r3
        L34:
            int r4 = r4.right
            int r2 = r2.right
            int r4 = r4 - r2
            if (r4 > 0) goto L3c
            goto L3d
        L3c:
            r3 = r4
        L3d:
            r2 = r3
            r3 = r5
            goto L41
        L40:
            r2 = r3
        L41:
            r1.e(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwswitch.widget.HwSwitch.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    @Override // android.widget.Switch, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto Lb
            java.lang.String r6 = "HwSwitch"
            java.lang.String r1 = "onTouchEvent: MotionEvent motionEvent is null!"
            android.util.Log.w(r6, r1)
            return r0
        Lb:
            android.view.VelocityTracker r1 = r5.q
            r1.addMovement(r6)
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L3a
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L27
            if (r1 == r2) goto L20
            r4 = 3
            if (r1 == r4) goto L27
            goto L3d
        L20:
            boolean r0 = r5.eFN_(r6)
            if (r0 == 0) goto L3d
            return r3
        L27:
            int r1 = r5.l
            if (r1 != r2) goto L32
            r5.eFP_(r6)
            super.onTouchEvent(r6)
            return r3
        L32:
            r5.l = r0
            android.view.VelocityTracker r0 = r5.q
            r0.clear()
            goto L3d
        L3a:
            r5.a(r6)
        L3d:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwswitch.widget.HwSwitch.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.Switch, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (isAttachedToWindow() && isLaidOut()) {
            d(zIsChecked);
        } else {
            c();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    public void setFocusedPathColor(int i) {
        this.u = i;
    }

    protected void setSwitchWidth(int i) {
        this.f11262a = i;
    }

    public HwSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100778_res_0x7f06046a);
    }

    public HwSwitch(Context context, AttributeSet attributeSet, int i) {
        super(c(context, i), attributeSet, i);
        this.f11262a = 0;
        this.g = 0;
        this.f = 0;
        this.i = 0;
        this.j = 0;
        this.h = 0;
        this.o = 0;
        this.l = 0;
        this.n = 0;
        this.k = 0;
        this.q = VelocityTracker.obtain();
        this.s = new Rect();
        eFM_(getContext(), attributeSet, i);
    }

    private static Context c(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwSwitch);
    }

    private boolean eFN_(MotionEvent motionEvent) {
        int i = this.l;
        if (i == 1) {
            return e(motionEvent);
        }
        if (i != 2) {
            return false;
        }
        eFQ_(motionEvent);
        return true;
    }

    private void eFM_(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100413_res_0x7f0602fd, R.attr._2131100518_res_0x7f060366, R.attr._2131100519_res_0x7f060367, R.attr._2131100520_res_0x7f060368, R.attr._2131100526_res_0x7f06036e, R.attr._2131100585_res_0x7f0603a9, R.attr._2131100605_res_0x7f0603bd}, i, R.style.Widget_Emui_HwSwitch);
        this.o = (int) typedArrayObtainStyledAttributes.getDimension(5, (getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
        this.u = typedArrayObtainStyledAttributes.getColor(4, -14331913);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        if (viewConfiguration != null) {
            this.n = viewConfiguration.getScaledTouchSlop();
            this.k = viewConfiguration.getScaledMinimumFlingVelocity();
        }
    }

    private void eFO_(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private boolean e(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Object objA = vnl.a(this, "mTouchSlop", Switch.class);
        if (objA instanceof Integer) {
            this.n = ((Integer) objA).intValue();
        }
        if (Math.abs(x - this.r) <= this.n && Math.abs(y - this.t) <= this.n) {
            return false;
        }
        this.l = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.r = x;
        this.t = y;
        return true;
    }

    private void a(Canvas canvas) {
        Rect rect = this.s;
        int i = this.f;
        int i2 = this.i;
        int i3 = this.h;
        int thumbOffset = i + getThumbOffset() + this.o;
        d();
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.getPadding(rect);
            int i4 = thumbOffset - rect.left;
            int i5 = thumbOffset + this.g + rect.right;
            Drawable.Callback callback = this.d.getCallback();
            this.d.setCallback(null);
            this.d.setBounds(i4, i2, i5, i3);
            this.d.setCallback(callback);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i4, i2, i5, i3);
            }
        }
    }

    private void eFP_(MotionEvent motionEvent) {
        this.l = 0;
        boolean zI = true;
        boolean z = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z) {
            this.q.computeCurrentVelocity(1000);
            float xVelocity = this.q.getXVelocity();
            Object objA = vnl.a(this, "mMinFlingVelocity", Switch.class);
            if (objA instanceof Integer) {
                this.k = ((Integer) objA).intValue();
            }
            if (Math.abs(xVelocity) > this.k) {
                if (!f() ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    zI = false;
                }
            } else {
                zI = i();
            }
        } else {
            zI = zIsChecked;
        }
        if (zI != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(zI);
        eFO_(motionEvent);
    }

    private boolean j() {
        return getLayoutDirection() == 1;
    }

    private void d() {
        Insets insets;
        Rect rect = this.s;
        int i = this.f;
        int i2 = this.j;
        int i3 = this.i;
        int i4 = this.h;
        Drawable drawable = this.d;
        if (drawable != null) {
            Object objB = vnl.b(drawable, "getOpticalInsets", null, null, DrawableContainer.class);
            if (objB instanceof Insets) {
                insets = (Insets) objB;
            } else {
                insets = Insets.NONE;
            }
        } else {
            insets = Insets.NONE;
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            if (insets != Insets.NONE) {
                int i5 = insets.left;
                int i6 = rect.left;
                if (i5 > i6) {
                    i += i5 - i6;
                }
                int i7 = insets.top;
                int i8 = rect.top;
                if (i7 > i8) {
                    i3 += i7 - i8;
                }
                int i9 = insets.right;
                int i10 = rect.right;
                if (i9 > i10) {
                    i2 -= i9 - i10;
                }
                int i11 = insets.bottom;
                int i12 = rect.bottom;
                if (i11 > i12) {
                    i4 -= i11 - i12;
                }
            }
            this.c.setBounds(i, i3, i2, i4);
        }
    }

    private void e(int i, int i2) {
        if (j()) {
            int paddingLeft = getPaddingLeft() + i;
            this.f = paddingLeft;
            this.j = ((paddingLeft + this.f11262a) - i) - i2;
        } else {
            int width = (getWidth() - getPaddingRight()) - i2;
            this.j = width;
            this.f = (width - this.f11262a) + i + i2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            int i3 = this.p;
            int i4 = paddingTop - (i3 / 2);
            this.i = i4;
            this.h = i4 + i3;
            return;
        }
        if (gravity == 48) {
            int paddingTop2 = getPaddingTop();
            this.i = paddingTop2;
            this.h = paddingTop2 + this.p;
        } else if (gravity != 80) {
            this.i = 0;
            this.h = 0;
        } else {
            int height = getHeight() - getPaddingBottom();
            this.h = height;
            this.i = height - this.p;
        }
    }

    private void d(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, e, z ? 1.0f : 0.0f);
        this.b = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
        this.b.setInterpolator(new HwCubicBezierInterpolator(0.1f, 1.0f, 0.9f, 1.0f));
        this.b.setAutoCancel(true);
        this.b.start();
    }

    private boolean b(float f, float f2) {
        if (this.d == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.d.getPadding(this.s);
        Object objA = vnl.a(this, "mTouchSlop", Switch.class);
        if (objA instanceof Integer) {
            this.n = ((Integer) objA).intValue();
        }
        int i = this.i;
        int i2 = this.n;
        int i3 = (this.f + thumbOffset) - i2;
        int i4 = this.g;
        Rect rect = this.s;
        return f > ((float) i3) && f < ((float) ((((i4 + i3) + rect.left) + rect.right) + i2)) && f2 > ((float) (i - i2)) && f2 < ((float) (this.h + i2));
    }

    private void a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (isEnabled() && b(x, y)) {
            this.l = 1;
            this.r = x;
            this.t = y;
        }
    }
}
