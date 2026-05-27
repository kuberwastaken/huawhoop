package defpackage;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* JADX INFO: loaded from: classes8.dex */
public class voj extends BitmapDrawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18696a;
    private float b;
    private Paint c;
    private float d;
    private ValueAnimator e;
    private float f;
    private float g;
    private float h;
    private float i;
    private Interpolator j;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            voj.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    private void c(int i) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.e = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.e.setRepeatCount(-1);
        this.e.setInterpolator(new LinearInterpolator());
        Paint paint = new Paint();
        this.c = paint;
        this.i = 0.0f;
        this.h = 0.0f;
        this.f18696a = i;
        paint.setColor(i);
        this.c.setAntiAlias(true);
        this.e.addUpdateListener(new a());
    }

    private static Bitmap eBB_(int i) {
        if (i > 250) {
            i = 250;
        } else if (i <= 0) {
            i = 1;
        }
        return Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    }

    public void b(float f) {
        this.b = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            Log.w("HwLoadingDrawableImpl", "draw: canvas is null");
            return;
        }
        this.c.setColor(this.f18696a);
        if (this.b * 60.0f >= 60.0f) {
            this.b = 0.0f;
        }
        canvas.save();
        for (int i = 0; i < 12; i++) {
            float f = (this.b * 60.0f) + (i * 5);
            this.c.setAlpha(((int) d(f, false)) + 127);
            canvas.drawCircle(this.g, this.f, this.d + (((float) d(f, true)) * this.d), this.c);
            canvas.rotate(-30.0f, this.i, this.h);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ValueAnimator valueAnimator = this.e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        e();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.e.end();
    }

    public voj(Resources resources, int i, int i2) {
        super(resources, eBB_(i));
        this.b = 0.0f;
        this.j = new HwCubicBezierInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        c(i2);
    }

    private float c() {
        Rect bounds = getBounds();
        float f = (bounds.left + bounds.right) / 2.0f;
        this.i = f;
        float f2 = (bounds.top + bounds.bottom) / 2.0f;
        this.h = f2;
        return f < f2 ? f : f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private double d(float r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1114636288(0x42700000, float:60.0)
            float r4 = r4 % r0
            r1 = 0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r2 = 1092616192(0x41200000, float:10.0)
            if (r1 < 0) goto L19
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 >= 0) goto L19
            android.view.animation.Interpolator r0 = r3.j
            r1 = 1036831949(0x3dcccccd, float:0.1)
            float r4 = r4 * r1
            float r4 = r0.getInterpolation(r4)
            goto L35
        L19:
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r2 = 1107578565(0x42044ec5, float:33.076923)
            if (r1 < 0) goto L37
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 >= 0) goto L37
            android.view.animation.Interpolator r0 = r3.j
            r1 = -1120829877(0xffffffffbd317e4b, float:-0.043333333)
            float r4 = r4 * r1
            r1 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 + r1
            r1 = 1054727646(0x3eddddde, float:0.43333334)
            float r4 = r4 + r1
            float r4 = r0.getInterpolation(r4)
        L35:
            double r0 = (double) r4
            goto L49
        L37:
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 < 0) goto L40
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 >= 0) goto L40
            goto L47
        L40:
            java.lang.String r4 = "HwLoadingDrawableImpl"
            java.lang.String r0 = "invalid tempFrame"
            android.util.Log.w(r4, r0)
        L47:
            r0 = 0
        L49:
            if (r5 == 0) goto L4c
            return r0
        L4c:
            r4 = 4638707616191610880(0x4060000000000000, double:128.0)
            double r0 = r0 * r4
            int r4 = (int) r0
            double r4 = (double) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.voj.d(float, boolean):double");
    }

    private void e() {
        float fC = c() * 0.6944444f;
        this.d = 0.1f * fC;
        this.g = this.i;
        this.f = this.h - fC;
    }
}
