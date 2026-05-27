package com.huawei.ui.commonui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$color;

/* JADX INFO: loaded from: classes7.dex */
public class GradientCircle extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f9196a;
    private Paint b;
    private RectF c;
    private Paint d;
    private float e;

    public GradientCircle(Context context) {
        super(context);
        a();
    }

    public GradientCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GradientCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        setLayerType(2, null);
        final float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen._2131363233_res_0x7f0a05a1);
        post(new Runnable() { // from class: com.huawei.ui.commonui.indicator.GradientCircle.3
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = GradientCircle.this.getMeasuredWidth();
                float f = dimensionPixelSize / 2.0f;
                float f2 = measuredWidth;
                float f3 = f2 - f;
                GradientCircle.this.c = new RectF(f, f, f3, f3);
                GradientCircle.this.b = new Paint();
                float f4 = f2 / 2.0f;
                SweepGradient sweepGradient = new SweepGradient(f4, f4, new int[]{ContextCompat.getColor(GradientCircle.this.getContext(), R$color.gradient_circle_low_color), ContextCompat.getColor(GradientCircle.this.getContext(), R$color.gradient_circle_medium_color), ContextCompat.getColor(GradientCircle.this.getContext(), R$color.gradient_circle_high_color), ContextCompat.getColor(GradientCircle.this.getContext(), R$color.gradient_circle_low_color)}, new float[]{0.0f, 0.40833333f, 0.81666666f, 0.95f});
                Matrix matrix = new Matrix();
                matrix.setRotate(123.0f, f4, f4);
                sweepGradient.setLocalMatrix(matrix);
                GradientCircle.this.b.setShader(sweepGradient);
                GradientCircle.this.b.setAntiAlias(true);
                GradientCircle.this.b.setStrokeCap(Paint.Cap.ROUND);
                GradientCircle.this.b.setStyle(Paint.Style.STROKE);
                GradientCircle.this.b.setStrokeWidth(dimensionPixelSize);
                GradientCircle.this.invalidate();
            }
        });
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(ContextCompat.getColor(getContext(), R$color.gradient_circle_bg));
        this.d.setAntiAlias(true);
        this.d.setStrokeCap(Paint.Cap.ROUND);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(dimensionPixelSize);
    }

    public void d(float f, float f2) {
        this.f9196a = f;
        this.e = f2;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c == null) {
            return;
        }
        canvas.save();
        canvas.drawArc(this.c, 123.0f, 294.0f, false, this.d);
        canvas.drawArc(this.c, 123.0f, Math.min(this.f9196a / this.e, 1.0f) * 294.0f, false, this.b);
        canvas.restore();
    }
}
