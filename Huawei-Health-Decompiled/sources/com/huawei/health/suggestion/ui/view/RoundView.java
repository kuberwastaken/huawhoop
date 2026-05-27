package com.huawei.health.suggestion.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class RoundView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3546a;
    private float b;
    private List<Integer> c;
    private int d;
    private Paint e;
    private List<Integer> f;
    private Paint g;
    private Path h;
    private float i;
    private float j;

    public RoundView(Context context) {
        super(context);
        this.c = new ArrayList(16);
        this.f = new ArrayList(16);
        this.j = 50.0f;
        this.i = 0.0f;
        b();
    }

    public RoundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList(16);
        this.f = new ArrayList(16);
        this.j = 50.0f;
        this.i = 0.0f;
        b();
    }

    public RoundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ArrayList(16);
        this.f = new ArrayList(16);
        this.j = 50.0f;
        this.i = 0.0f;
        b();
    }

    private void b() {
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(this.j);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setStrokeWidth(0.0f);
        this.h = new Path();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.b = size / 2.0f;
        this.f3546a = size2 / 2.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        if (canvas == null) {
            return;
        }
        this.g.setStrokeWidth(this.j);
        float f2 = this.b;
        float f3 = this.f3546a;
        float f4 = this.j / 2.0f;
        float f5 = (f2 - f4) - 8.0f;
        float f6 = this.i;
        int i = 0;
        while (i < this.f.size()) {
            float fIntValue = f6 - ((this.f.get(i).intValue() * 360.0f) / this.d);
            int iIntValue = this.c.get(i).intValue();
            e(f2, f3, f5, fIntValue, f6);
            aQr_(canvas, iIntValue, this.g);
            double d = f5;
            double d2 = (((double) f6) * 3.141592653589793d) / 180.0d;
            int i2 = i;
            double d3 = f3;
            float f7 = f5;
            double d4 = f2;
            e((float) ((Math.cos(d2) * d) + d4), (float) ((Math.sin(d2) * d) + d3), f4, f6, f6 + 180.0f);
            aQr_(canvas, iIntValue, this.e);
            if (i2 == this.f.size() - 1) {
                int iIntValue2 = this.c.get(0).intValue();
                double d5 = (((double) fIntValue) * 3.141592653589793d) / 180.0d;
                f = fIntValue;
                e((float) (d4 + (Math.cos(d5) * d)), (float) (d3 + (Math.sin(d5) * d)), f4, f, fIntValue + 180.0f);
                aQr_(canvas, iIntValue2, this.e);
            } else {
                f = fIntValue;
            }
            i = i2 + 1;
            f6 = f;
            f5 = f7;
        }
    }

    public void setStrokeWidth(float f) {
        this.j = f;
    }

    private void e(float f, float f2, float f3, float f4, float f5) {
        RectF rectF = new RectF(f - f3, f2 - f3, f + f3, f3 + f2);
        this.h.reset();
        this.h.moveTo(this.b, f2);
        this.h.addArc(rectF, f4, f5 - f4);
    }

    private void aQr_(Canvas canvas, int i, Paint paint) {
        if (canvas == null) {
            return;
        }
        paint.setColor(i);
        canvas.drawPath(this.h, paint);
    }
}
