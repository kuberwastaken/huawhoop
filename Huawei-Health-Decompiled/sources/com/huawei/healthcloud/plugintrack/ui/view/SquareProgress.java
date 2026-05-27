package com.huawei.healthcloud.plugintrack.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.health.R;
import health.compact.a.LanguageUtil;

/* JADX INFO: loaded from: classes5.dex */
public class SquareProgress extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3938a;
    private int b;
    private Paint c;
    private boolean d;
    private int e;
    private int f;
    private PointF g;
    private int h;
    private float i;
    private Paint j;
    private Paint k;
    private float l;
    private int m;
    private float n;
    private int o;
    private int s;

    public SquareProgress(Context context) {
        this(context, null);
        c();
    }

    public SquareProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 100;
        this.b = 30;
        this.d = false;
        bpq_(context, attributeSet, i);
        c();
    }

    private void bpq_(Context context, AttributeSet attributeSet, int i) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100116_res_0x7f0601d4, R.attr._2131100117_res_0x7f0601d5, R.attr._2131100118_res_0x7f0601d6, R.attr._2131101174_res_0x7f0605f6, R.attr._2131101351_res_0x7f0606a7, R.attr._2131101354_res_0x7f0606aa, R.attr._2131101355_res_0x7f0606ab, R.attr._2131101360_res_0x7f0606b0}, i, R.style.DefaultHealthSquareProgress);
        try {
            this.m = typedArrayObtainStyledAttributes.getColor(5, 0);
            this.o = typedArrayObtainStyledAttributes.getColor(6, 0);
            this.e = typedArrayObtainStyledAttributes.getColor(0, 0);
            this.f3938a = typedArrayObtainStyledAttributes.getDimension(1, 10.0f);
            this.n = typedArrayObtainStyledAttributes.getDimension(7, 8.0f);
            this.d = typedArrayObtainStyledAttributes.getBoolean(2, false);
            this.h = typedArrayObtainStyledAttributes.getInt(3, 100);
            this.b = typedArrayObtainStyledAttributes.getInt(4, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void c() {
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(this.n);
        this.k.setColor(this.o);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setAntiAlias(true);
        this.c.setColor(this.m);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.n);
        Paint paint3 = new Paint();
        this.j = paint3;
        paint3.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setColor(this.e);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.s = b(i);
        int iC = c(i2);
        this.f = iC;
        setMeasuredDimension(this.s, iC);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean zAy = LanguageUtil.ay(getContext());
        this.l = ((this.s - getPaddingRight()) - getPaddingLeft()) - this.n;
        float paddingTop = (this.f - getPaddingTop()) - getPaddingBottom();
        float f = this.n;
        this.i = paddingTop - f;
        float f2 = f / 2.0f;
        float f3 = this.l;
        if (zAy) {
            f3 = -f3;
        }
        bpp_(canvas, zAy, f2, f3, zAy ? -f2 : f2);
        if (this.d) {
            canvas.drawCircle(this.g.x, this.g.y, this.f3938a * 0.5f, this.j);
        }
    }

    private void bpp_(Canvas canvas, boolean z, float f, float f2, float f3) {
        PointF pointF = new PointF(z ? this.s - getPaddingRight() : getPaddingLeft(), getPaddingTop() + f);
        PointF pointF2 = new PointF(pointF.x + f2, pointF.y);
        PointF pointF3 = new PointF(pointF2.x + f3, pointF2.y - f);
        PointF pointF4 = new PointF(pointF3.x, pointF3.y + this.i);
        PointF pointF5 = new PointF(pointF4.x + f3, pointF4.y + f);
        PointF pointF6 = new PointF(pointF5.x - f2, pointF5.y);
        PointF pointF7 = new PointF(pointF6.x - f3, pointF5.y - f);
        bpo_(canvas, new PointF[]{pointF, pointF2, pointF3, pointF4, pointF5, pointF6, pointF7, new PointF(pointF7.x, pointF7.y - this.i)});
        float f4 = (this.l + this.i) * 2.0f;
        Path path = new Path();
        float f5 = this.b;
        float f6 = this.h;
        float f7 = f5 / f6;
        if (f7 > 0.0f) {
            this.g = new PointF(pointF.x + (z ? ((-f4) * f5) / f6 : (f5 * f4) / f6), pointF.y);
            path.moveTo(pointF.x, pointF.y);
            float f8 = this.l;
            if (f7 > f8 / f4) {
                this.g = new PointF(pointF3.x, pointF3.y + (((this.b * f4) / this.h) - f8));
                path.lineTo(pointF2.x, pointF2.y);
                path.moveTo(pointF3.x, pointF3.y);
            }
            float f9 = this.i;
            float f10 = this.l;
            if (f7 > (f9 + f10) / f4) {
                float f11 = (((this.b * f4) / this.h) - f9) - f10;
                if (z) {
                    f11 = -f11;
                }
                this.g = new PointF(pointF5.x - f11, pointF5.y);
                path.lineTo(pointF4.x, pointF4.y);
                path.moveTo(pointF5.x, pointF5.y);
            }
            float f12 = this.l;
            float f13 = this.i;
            float f14 = f12 * 2.0f;
            if (f7 > (f14 + f13) / f4) {
                this.g = new PointF(pointF7.x, pointF7.y - Math.min((((f4 * this.b) / this.h) - f13) - f14, f13));
                path.lineTo(pointF6.x, pointF6.y);
                path.moveTo(pointF7.x, pointF7.y);
            }
            path.lineTo(this.g.x, this.g.y);
        }
        path.close();
        canvas.drawPath(path, this.k);
    }

    private void bpo_(Canvas canvas, PointF[] pointFArr) {
        Path path = new Path();
        for (int i = 0; i * 2 < pointFArr.length; i += 2) {
            path.moveTo(pointFArr[i].x, pointFArr[i].y);
            int i2 = i + 1;
            path.lineTo(pointFArr[i2].x, pointFArr[i2].y);
        }
        path.close();
        canvas.drawPath(path, this.c);
    }

    private int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (mode == 1073741824) {
            return size;
        }
        int suggestedMinimumWidth = getSuggestedMinimumWidth() + paddingLeft + paddingRight;
        return mode == Integer.MIN_VALUE ? Math.max(suggestedMinimumWidth, size) : suggestedMinimumWidth;
    }

    public void setProgress(int i) {
        this.b = i;
        invalidate();
    }

    private int c(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        if (mode == 1073741824) {
            return size;
        }
        int suggestedMinimumHeight = getSuggestedMinimumHeight() + paddingBottom + paddingTop;
        return mode == Integer.MIN_VALUE ? Math.max(suggestedMinimumHeight, size) : suggestedMinimumHeight;
    }
}
