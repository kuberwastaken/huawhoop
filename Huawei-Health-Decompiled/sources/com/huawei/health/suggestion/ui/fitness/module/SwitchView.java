package com.huawei.health.suggestion.ui.fitness.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes4.dex */
public class SwitchView extends View {
    private int aa;
    private Property<SwitchView, Float> ab;
    private OnSwitchStateChangeListener ac;
    private ObjectAnimator ad;
    private int ae;
    private RectF af;
    private Paint ag;
    private boolean ah;
    private int ai;
    private int ak;
    private int al;
    private int an;
    private int c;
    private Property<SwitchView, Float> d;
    private int e;
    private int f;
    private float g;
    private int h;
    private GestureDetector.SimpleOnGestureListener i;
    private GestureDetector j;
    private RectF k;
    private float l;
    private float m;
    private ObjectAnimator n;
    private float o;
    private float p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private RectF u;
    private Property<SwitchView, Float> v;
    private ObjectAnimator w;
    private float x;
    private float y;
    private float z;
    private static final int b = Color.parseColor("#95AAB3");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3284a = Color.parseColor("#FFFFFF");

    public interface OnSwitchStateChangeListener {
        void onSwitchStateChange(View view, boolean z);
    }

    private int c(float f, int i, int i2) {
        return ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r0) * f))) << 16) | (-16777216) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r1) * f))) << 8) | ((i & 255) + ((int) (((i2 & 255) - r5) * f)));
    }

    public SwitchView(Context context) {
        this(context, null);
    }

    public SwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Property<SwitchView, Float>(Float.class, "innerBound") { // from class: com.huawei.health.suggestion.ui.fitness.module.SwitchView.5
            @Override // android.util.Property
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void set(SwitchView switchView, Float f) {
                if (switchView == null) {
                    return;
                }
                switchView.setInnerContentRate(f.floatValue());
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Float get(SwitchView switchView) {
                if (switchView == null) {
                    return null;
                }
                return Float.valueOf(switchView.getInnerContentRate());
            }
        };
        this.v = new Property<SwitchView, Float>(Float.class, "knobExpand") { // from class: com.huawei.health.suggestion.ui.fitness.module.SwitchView.1
            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(SwitchView switchView, Float f) {
                if (switchView == null) {
                    return;
                }
                switchView.setKnobExpandRate(f.floatValue());
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Float get(SwitchView switchView) {
                if (switchView == null) {
                    return Float.valueOf(0.0f);
                }
                return Float.valueOf(switchView.getKnobExpandRate());
            }
        };
        this.ab = new Property<SwitchView, Float>(Float.class, "knobMove") { // from class: com.huawei.health.suggestion.ui.fitness.module.SwitchView.3
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(SwitchView switchView, Float f) {
                switchView.setKnobMoveRate(f.floatValue());
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(SwitchView switchView) {
                return Float.valueOf(switchView.getKnobMoveRate());
            }
        };
        this.i = new GestureDetector.SimpleOnGestureListener() { // from class: com.huawei.health.suggestion.ui.fitness.module.SwitchView.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SwitchView.this.isEnabled()) {
                    return false;
                }
                SwitchView switchView = SwitchView.this;
                switchView.ah = switchView.t;
                SwitchView.this.n.setFloatValues(SwitchView.this.o, 0.0f);
                SwitchView.this.n.start();
                SwitchView.this.w.setFloatValues(SwitchView.this.x, 1.0f);
                SwitchView.this.w.start();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (motionEvent == null) {
                    return false;
                }
                super.onSingleTapUp(motionEvent);
                SwitchView switchView = SwitchView.this;
                switchView.t = switchView.r;
                if (SwitchView.this.ah == SwitchView.this.t) {
                    SwitchView.this.t = !r5.t;
                    SwitchView.this.r = !r5.r;
                }
                SwitchView switchView2 = SwitchView.this;
                switchView2.d(switchView2.r);
                SwitchView.this.w.setFloatValues(SwitchView.this.x, 0.0f);
                SwitchView.this.w.start();
                if (SwitchView.this.ac != null && SwitchView.this.t != SwitchView.this.ah) {
                    OnSwitchStateChangeListener onSwitchStateChangeListener = SwitchView.this.ac;
                    SwitchView switchView3 = SwitchView.this;
                    onSwitchStateChangeListener.onSwitchStateChange(switchView3, switchView3.t);
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent2 == null || motionEvent2.getX() <= SwitchView.this.e) {
                    if (SwitchView.this.r) {
                        SwitchView.this.r = false;
                        SwitchView.this.ad.setFloatValues(SwitchView.this.z, 0.0f);
                        SwitchView.this.ad.start();
                    }
                } else if (!SwitchView.this.r) {
                    SwitchView.this.r = true;
                    SwitchView.this.ad.setFloatValues(SwitchView.this.z, 1.0f);
                    SwitchView.this.ad.start();
                    SwitchView.this.n.setFloatValues(SwitchView.this.o, 0.0f);
                    SwitchView.this.n.start();
                }
                return true;
            }
        };
        this.o = 1.0f;
        int color = Color.parseColor("#00CCFF");
        this.al = color;
        this.f = b;
        this.q = true;
        this.s = false;
        this.ae = 4;
        this.ak = color;
        this.ai = 0;
        this.u = new RectF();
        this.k = new RectF();
        this.af = new RectF();
        this.ag = new Paint(1);
        GestureDetector gestureDetector = new GestureDetector(context, this.i);
        this.j = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        setLayerType(1, null);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.d, this.o, 1.0f);
        this.n = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.n.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, this.v, this.x, 1.0f);
        this.w = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setDuration(300L);
        this.w.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, this.ab, this.z, 1.0f);
        this.ad = objectAnimatorOfFloat3;
        objectAnimatorOfFloat3.setDuration(300L);
        this.ad.setInterpolator(new DecelerateInterpolator());
    }

    public void setOnSwitchStateChangeListener(OnSwitchStateChangeListener onSwitchStateChangeListener) {
        this.ac = onSwitchStateChangeListener;
    }

    void setInnerContentRate(float f) {
        this.o = f;
        invalidate();
    }

    float getInnerContentRate() {
        return this.o;
    }

    void setKnobExpandRate(float f) {
        this.x = f;
        invalidate();
    }

    float getKnobExpandRate() {
        return this.x;
    }

    void setKnobMoveRate(float f) {
        this.z = f;
        invalidate();
    }

    float getKnobMoveRate() {
        return this.z;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        this.s = true;
        if (this.q) {
            boolean z2 = this.t;
            this.r = z2;
            d(z2);
            this.w.setFloatValues(this.x, 0.0f);
            this.w.start();
            OnSwitchStateChangeListener onSwitchStateChangeListener = this.ac;
            if (onSwitchStateChangeListener != null && (z = this.t) != this.ah) {
                onSwitchStateChangeListener.onSwitchStateChange(this, z);
            }
            this.q = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z) {
            this.ad.setFloatValues(this.z, 1.0f);
            this.ad.start();
            this.n.setFloatValues(this.o, 0.0f);
            this.n.start();
            return;
        }
        this.ad.setFloatValues(this.z, 0.0f);
        this.ad.start();
        this.n.setFloatValues(this.o, 1.0f);
        this.n.start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.an = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.h = size;
        int i3 = this.an;
        float f = i3;
        if (size / f < 0.33333f) {
            this.h = (int) (f * 0.33333f);
            super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i3, View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(this.h, View.MeasureSpec.getMode(i2)));
        }
        this.e = this.an / 2;
        this.c = this.h / 2;
        int i4 = this.ai;
        this.g = r5 - i4;
        this.k.left = this.aa + i4;
        this.k.top = this.aa + this.ai;
        this.k.right = (this.an - this.aa) - this.ai;
        this.k.bottom = (this.h - this.aa) - this.ai;
        this.l = this.k.width();
        this.m = this.k.height();
        this.u.left = this.ae + this.ai;
        this.u.top = this.ae + this.ai;
        this.u.right = (this.h - this.ae) - this.ai;
        this.u.bottom = (this.h - this.ae) - this.ai;
        this.p = this.u.height();
        float f2 = this.an * 0.7f;
        this.y = f2;
        if (f2 > this.u.width() * 1.25f) {
            this.y = this.u.width() * 1.25f;
        }
    }

    public SwitchView e(boolean z) {
        c(z, false);
        return this;
    }

    private void c(boolean z, boolean z2) {
        boolean z3;
        if (this.t == z) {
            return;
        }
        if (!this.s && z2) {
            this.q = true;
            this.t = z;
            return;
        }
        this.t = z;
        this.r = z;
        if (!z2) {
            if (z) {
                setKnobMoveRate(1.0f);
                setInnerContentRate(0.0f);
            } else {
                setKnobMoveRate(0.0f);
                setInnerContentRate(1.0f);
            }
            setKnobExpandRate(0.0f);
        } else {
            d(z);
            this.w.setFloatValues(this.x, 0.0f);
            this.w.start();
        }
        OnSwitchStateChangeListener onSwitchStateChangeListener = this.ac;
        if (onSwitchStateChangeListener == null || (z3 = this.t) == this.ah) {
            return;
        }
        onSwitchStateChangeListener.onSwitchStateChange(this, z3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            if (!this.r) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.d, this.o, 1.0f);
                this.n = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(300L);
                this.n.setInterpolator(new DecelerateInterpolator());
                this.n.start();
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, this.v, this.x, 0.0f);
            this.w = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(300L);
            this.w.setInterpolator(new DecelerateInterpolator());
            this.w.start();
            boolean z = this.r;
            this.t = z;
            OnSwitchStateChangeListener onSwitchStateChangeListener = this.ac;
            if (onSwitchStateChangeListener != null && z != this.ah) {
                onSwitchStateChangeListener.onSwitchStateChange(this, z);
            }
        }
        return this.j.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.al = this.ak;
        } else {
            this.al = c(0.5f, this.ak, -1);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        float f = this.l / 2.0f;
        float f2 = this.o;
        float f3 = f * f2;
        float f4 = (this.m / 2.0f) * f2;
        this.k.left = this.e - f3;
        this.k.top = this.c - f4;
        this.k.right = this.e + f3;
        this.k.bottom = this.c + f4;
        float f5 = this.p;
        float f6 = f5 + ((this.y - f5) * this.x);
        if (this.u.left + (this.u.width() / 2.0f) > this.e) {
            RectF rectF = this.u;
            rectF.left = rectF.right - f6;
        } else {
            RectF rectF2 = this.u;
            rectF2.right = rectF2.left + f6;
        }
        float fWidth = this.u.width();
        float f7 = this.an;
        int i = this.ai + this.ae;
        float f8 = this.z;
        this.f = this.al;
        this.u.left = i + (((f7 - fWidth) - (i * 2)) * f8);
        RectF rectF3 = this.u;
        rectF3.right = rectF3.left + fWidth;
        this.ag.setColor(this.f);
        this.ag.setStyle(Paint.Style.FILL);
        float f9 = this.ai;
        aHE_(f9, f9, this.an - r0, this.h - r0, this.g, canvas, this.ag);
        this.ag.setColor(b);
        RectF rectF4 = this.k;
        canvas.drawRoundRect(rectF4, rectF4.height() / 2.0f, this.k.height() / 2.0f, this.ag);
        this.ag.setShadowLayer(2.0f, 0.0f, this.ai / 2.0f, isEnabled() ? 536870912 : 268435456);
        this.ag.setColor(f3284a);
        RectF rectF5 = this.u;
        float f10 = this.g - this.aa;
        canvas.drawRoundRect(rectF5, f10, f10, this.ag);
        this.ag.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
    }

    private void aHE_(float f, float f2, float f3, float f4, float f5, Canvas canvas, Paint paint) {
        this.af.left = f;
        this.af.top = f2;
        this.af.right = f3;
        this.af.bottom = f4;
        canvas.drawRoundRect(this.af, f5, f5, paint);
    }
}
