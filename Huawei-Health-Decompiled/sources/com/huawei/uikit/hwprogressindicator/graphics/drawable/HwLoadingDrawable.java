package com.huawei.uikit.hwprogressindicator.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.animation.CycleInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import defpackage.vmk;

/* JADX INFO: loaded from: classes8.dex */
public class HwLoadingDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f11176a;
    private Interpolator c;
    private ValueAnimator d;
    private CycleInterpolator e;
    private volatile boolean b = false;
    private float j = 0.0f;
    private float f = 0.0f;
    private float h = 0.0f;
    private OnLoadingListener g = null;

    public interface OnLoadingListener {
        void onLoadingFinish();

        void onLoadingStart();
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e("HwLoadingDrawable", "onAnimationUpdate: animation is null.");
                return;
            }
            HwLoadingDrawable.this.h = valueAnimator.getAnimatedFraction();
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            HwLoadingDrawable hwLoadingDrawable = HwLoadingDrawable.this;
            hwLoadingDrawable.e(fFloatValue, hwLoadingDrawable.h);
            HwLoadingDrawable.this.f11176a.a(HwLoadingDrawable.this.j, HwLoadingDrawable.this.f);
            HwLoadingDrawable.this.invalidateSelf();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (HwLoadingDrawable.this.e()) {
                if (HwLoadingDrawable.this.g != null) {
                    HwLoadingDrawable.this.g.onLoadingFinish();
                }
                HwLoadingDrawable.this.d.end();
                HwLoadingDrawable.this.b = false;
                HwLoadingDrawable.this.h = 0.0f;
            }
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11177a;
        private int b;
        private float c;
        private final C0291d[] g;
        private RectF i;
        private final e j;
        private final FloatEvaluator d = new FloatEvaluator();
        private final ArgbEvaluator e = new ArgbEvaluator();
        private final Paint h = new Paint(1);
        private float f = 0.0f;

        /* JADX INFO: renamed from: com.huawei.uikit.hwprogressindicator.graphics.drawable.HwLoadingDrawable$d$d, reason: collision with other inner class name */
        static class C0291d {
            private PointF b;
            private int c;
            private int d;

            C0291d(PointF pointF) {
                this.b = pointF;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void eBW_(Canvas canvas, Paint paint, float f) {
                if (this.d == 0) {
                    return;
                }
                paint.setColor(this.c);
                paint.setAlpha(this.d);
                PointF pointF = this.b;
                canvas.drawCircle(pointF.x, pointF.y, f, paint);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void e(int i, int i2) {
                this.c = i;
                this.d = i2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void eBX_(PointF pointF) {
                this.b = pointF;
            }
        }

        static class e {
            private final Paint c = new Paint(1);
            private PointF d;

            e(PointF pointF, int i) {
                this.d = pointF;
                e(i);
            }

            private void e(int i) {
                this.c.setStyle(Paint.Style.FILL);
                this.c.setColor(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void eCa_(PointF pointF) {
                this.d = pointF;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(Canvas canvas, float f) {
                PointF pointF = this.d;
                canvas.drawCircle(pointF.x, pointF.y, f, this.c);
            }
        }

        d(RectF rectF, int i, int i2, float f) {
            this.c = f;
            this.b = i;
            this.f11177a = i2;
            this.i = rectF;
            PointF pointF = new PointF(rectF.right, rectF.centerY());
            this.j = new e(pointF, this.f11177a);
            this.g = new C0291d[50];
            int i3 = 0;
            while (true) {
                C0291d[] c0291dArr = this.g;
                if (i3 >= c0291dArr.length) {
                    d(i);
                    return;
                } else {
                    c0291dArr[i3] = new C0291d(pointF);
                    i3++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f, float f2) {
            this.f = Math.min(f2, 90.0f);
            this.j.eCa_(eBU_(0.0f, f));
            int i = 0;
            while (i < 50) {
                int i2 = i + 1;
                float f3 = i2 / 50.0f;
                int iC = c(f3);
                int iB = b(f3);
                PointF pointFEBU_ = eBU_(f3, f);
                C0291d c0291d = this.g[i];
                c0291d.e(iC, iB);
                c0291d.eBX_(pointFEBU_);
                i = i2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(float f) {
            this.c = f;
        }

        private void d(int i) {
            this.h.setColor(i);
            this.h.setStyle(Paint.Style.FILL);
        }

        private int b(float f) {
            if (Float.compare(f, 1.0f) >= 0) {
                return 0;
            }
            return (int) ((1.0f - f) * 255.0f);
        }

        private PointF eBU_(float f, float f2) {
            double dA = a(f, f2, f2 - this.f);
            double dSin = Math.sin(Math.toRadians(dA));
            double dCos = Math.cos(Math.toRadians(dA));
            double dWidth = this.i.width() / 2.0f;
            return new PointF((float) (((double) this.i.centerX()) + (dCos * dWidth)), (float) (((double) this.i.centerY()) + (dWidth * dSin)));
        }

        private float a(float f, float f2, float f3) {
            return Float.compare(f, 1.0f) >= 0 ? f3 : this.d.evaluate(f, (Number) Float.valueOf(f2), (Number) Float.valueOf(f3)).floatValue();
        }

        private int c(float f) {
            if (Float.compare(f, 1.0f) >= 0) {
                return this.b;
            }
            return ((Integer) this.e.evaluate(f, Integer.valueOf(this.f11177a), Integer.valueOf(this.b))).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Canvas canvas) {
            for (int i = 49; i >= 0; i--) {
                this.g[i].eBW_(canvas, this.h, this.c);
            }
            this.j.a(canvas, this.c);
        }
    }

    public HwLoadingDrawable(RectF rectF, int i, int i2, float f) {
        this.f11176a = new d(rectF, i, i2, f);
        a();
    }

    public void b() {
        if (d()) {
            this.b = false;
            return;
        }
        OnLoadingListener onLoadingListener = this.g;
        if (onLoadingListener != null) {
            onLoadingListener.onLoadingStart();
        }
        this.d.start();
        this.d.setRepeatCount(-1);
    }

    public void b(OnLoadingListener onLoadingListener) {
        this.g = onLoadingListener;
    }

    public void c() {
        if (d()) {
            this.b = true;
        }
    }

    public boolean d() {
        return this.d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f11176a.a(canvas);
    }

    public void e(float f) {
        d dVar = this.f11176a;
        if (dVar != null) {
            dVar.d(f);
            this.f11176a.a(this.j, this.f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return d() && this.b;
    }

    private void a() {
        this.e = new CycleInterpolator(0.5f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(2000L);
        this.d.setInterpolator(new LinearInterpolator());
        this.c = vmk.evz_();
        this.d.addUpdateListener(new a());
        this.d.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(float f, float f2) {
        double interpolation = this.e.getInterpolation(f);
        double dSqrt = Math.sqrt(1.0d - (interpolation * interpolation));
        if (Float.compare(f2, 0.5f) > 0) {
            dSqrt = -dSqrt;
        }
        this.j = (((1.0f - ((float) dSqrt)) + (f * 3.1415927f)) * 360.0f) / 5.141593f;
        this.f = Math.min(this.j, this.c.getInterpolation(Float.compare(f2, 0.5f) < 0 ? f2 * 2.0f : (1.0f - f2) * 2.0f) * 90.0f);
    }
}
