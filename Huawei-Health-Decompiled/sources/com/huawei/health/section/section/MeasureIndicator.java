package com.huawei.health.section.section;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$drawable;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureIndicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3050a;
    private float b;
    private Drawable c;
    private Paint d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private double j;
    private int l;
    private float m;
    private float o;

    public MeasureIndicator(Context context) {
        super(context);
        b(context);
    }

    public MeasureIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public MeasureIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
    }

    private void b(Context context) {
        this.c = ContextCompat.getDrawable(getContext(), R$drawable.health_indicator_triangle);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen._2131363172_res_0x7f0a0564);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen._2131363144_res_0x7f0a0548);
        this.h = dimensionPixelSize2;
        this.i = dimensionPixelSize;
        this.c.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize2);
        Paint paint = new Paint();
        this.d = paint;
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen._2131363144_res_0x7f0a0548));
        this.b = this.d.getStrokeWidth() / 2.0f;
        this.d.setStrokeCap(Paint.Cap.ROUND);
        this.f3050a = ContextCompat.getColor(context, R.color._2131296919_res_0x7f090297);
        this.g = ContextCompat.getColor(context, R.color._2131296918_res_0x7f090296);
        this.l = ContextCompat.getColor(context, R.color._2131296917_res_0x7f090295);
        this.f = context.getResources().getDimensionPixelSize(R.dimen._2131362993_res_0x7f0a04b1);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int strokeWidth = (int) (this.h + this.f + this.d.getStrokeWidth());
        if (mode != 1073741824) {
            size2 = strokeWidth;
        }
        float f = size;
        this.e = f / 3.0f;
        this.m = (2.0f * f) / 3.0f;
        this.o = f;
        setMeasuredDimension(size, size2);
    }

    public void setIndicatorLevel(double d) {
        this.j = d;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        float height = getHeight() / 2.0f;
        float strokeWidth = this.d.getStrokeWidth() / 2.0f;
        canvas.save();
        canvas.translate(0.0f, strokeWidth + height);
        this.d.setColor(this.f3050a);
        float f = this.b;
        canvas.drawLine(f, 0.0f, this.e - f, 0.0f, this.d);
        this.d.setColor(this.g);
        float f2 = this.e;
        float f3 = this.b;
        canvas.drawLine(f2 + f3, 0.0f, this.m - f3, 0.0f, this.d);
        this.d.setColor(this.l);
        float f4 = this.m;
        float f5 = this.b;
        canvas.drawLine(f4 + f5, 0.0f, this.o - f5, 0.0f, this.d);
        canvas.restore();
        canvas.save();
        canvas.rotate(180.0f, this.i / 2.0f, this.h / 2.0f);
        canvas.translate(-(a(getWidth()) - (this.i / 2.0f)), -((height - this.h) - this.f));
        this.c.draw(canvas);
        canvas.restore();
    }

    private float a(int i) {
        double d;
        double d2 = this.j;
        float f = i;
        double d3 = f / 3.0f;
        if (d2 < 8.0d) {
            if (d2 < 0.0d) {
                d2 = 0.0d;
            }
            d = (d3 * (d2 - 0.0d)) / 8.0d;
            d3 = 0.0d;
        } else if (d2 < 8.0d || d2 > 10.0d) {
            if (d2 > 15.0d) {
                d2 = 15.0d;
            }
            d = (d3 * (d2 - 10.0d)) / 5.0d;
            d3 = (f * 2.0f) / 3.0f;
        } else {
            d = ((d2 - 8.0d) * d3) / 2.0d;
        }
        float f2 = (float) (d3 + d);
        float f3 = this.i / 2.0f;
        if (f2 - f3 < 0.0f) {
            f2 = f3;
        }
        return f3 + f2 > f ? f - f3 : f2;
    }
}
