package defpackage;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import com.huawei.operation.utils.Constants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public class vmf extends Drawable {
    private boolean c;
    private final Paint e;
    private final int[] f;
    private ValueAnimator g;
    private final int[] h;
    private final int[] i;
    private final ArgbEvaluator j;
    private int k;
    private final float[] l;
    private int m;
    private int n;
    private float o;
    private boolean s;
    private static final int[] b = {-1, -394759, -1315861, -1973269, -2038542};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f18659a = {-8741633, -11108097, -14855696, -16762657, -16435250};
    private static final float[] d = {0.0f, 0.3f, 0.6f, 0.8f, 1.0f};

    class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f18660a;
        final /* synthetic */ int[] c;

        e(int[] iArr, int[] iArr2) {
            this.c = iArr;
            this.f18660a = iArr2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.w("HwFloatingBubbleRadialDrawable", "onAnimationUpdate: animation is null");
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < vmf.this.h.length; i++) {
                vmf.this.h[i] = ((Integer) vmf.this.j.evaluate(fFloatValue, Integer.valueOf(this.c[i]), Integer.valueOf(this.f18660a[i]))).intValue();
            }
            vmf.this.invalidateSelf();
        }
    }

    public float a() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float fWidth = bounds.width() * 0.5f;
        float[] fArr = {(this.k * 0.5f) - (this.n + (bounds.width() * 0.5f)), 0.0f - (this.m + (bounds.height() * 0.5f))};
        float fSqrt = (float) Math.sqrt((r5 * r5) + (r6 * r6));
        float fMin = (Math.min(fSqrt / ((float) Math.sqrt((r4 * r4) + 0.0f)), 1.0f) * fWidth) / fSqrt;
        float[] fArr2 = {fArr[0] * fMin, fMin * fArr[1]};
        float fCenterX = bounds.centerX() + fArr2[0];
        float fCenterY = bounds.centerY() + fArr2[1];
        float f = fArr2[0];
        float fSqrt2 = ((float) Math.sqrt((f * f) + (r7 * r7))) + fWidth;
        this.e.setShader(new RadialGradient(fCenterX, fCenterY, fSqrt2, this.h, this.l, Shader.TileMode.CLAMP));
        if (Float.compare(this.o, 1.0f) == -1) {
            this.e.setAlpha((int) (this.o * 255.0f));
            if (this.s) {
                this.e.setMaskFilter(new BlurMaskFilter((1.0f - this.o) * 25.0f, BlurMaskFilter.Blur.INNER));
            }
        } else {
            this.e.setAlpha(255);
            if (this.s) {
                this.e.setMaskFilter(null);
            }
        }
        try {
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), fWidth, this.e);
        } catch (IllegalArgumentException unused) {
            Log.w("HwFloatingBubbleRadialDrawable", "draw: bounds=" + bounds.toString() + " mParentWidth=" + this.k + ", mLeft=" + this.n + ", mTop=" + this.m);
            Log.e("HwFloatingBubbleRadialDrawable", "draw failed: cx=" + bounds.centerX() + ", cy=" + bounds.centerY() + ", radius=" + fWidth + ", Shader(cx=" + fCenterX + ", cy=" + fCenterY + ", radius=" + fSqrt2 + ", colors=" + Arrays.toString(this.h) + ", stops=" + Arrays.toString(this.l) + Constants.RIGHT_BRACKET_ONLY);
        }
    }

    public void e(int i, int i2, int i3, float f) {
        float fMax = Float.compare(f, 1.2f) == -1 ? Math.max(((f - 1.2f) * 1.111111f) + 1.0f, 0.0f) : 1.0f;
        boolean z = Float.compare(fMax, this.o) == 0;
        if (this.k == i && this.n == i2 && this.m == i3 && z) {
            return;
        }
        this.k = i;
        this.n = i2;
        this.m = i3;
        this.o = fMax;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z;
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (iArr[i] == 16842913) {
                z = true;
                break;
            }
            i++;
        }
        if (z == this.c) {
            return false;
        }
        this.c = z;
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.g.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.g.setDuration(300L);
        this.g.addUpdateListener(new e(Arrays.copyOf(this.h, 5), this.c ? Arrays.copyOf(this.i, 5) : Arrays.copyOf(this.f, 5)));
        this.g.start();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
