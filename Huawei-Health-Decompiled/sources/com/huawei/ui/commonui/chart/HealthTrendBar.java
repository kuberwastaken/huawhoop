package com.huawei.ui.commonui.chart;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$styleable;
import health.compact.a.LanguageUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HealthTrendBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9139a;
    private boolean c;
    private int d;
    private Paint e;

    public HealthTrendBar(Context context) {
        super(context);
        this.c = true;
        e();
    }

    public HealthTrendBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = true;
        cHF_(context, attributeSet);
    }

    public HealthTrendBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = true;
        cHF_(context, attributeSet);
    }

    private void e() {
        setWillNotDraw(false);
        this.e = new Paint();
    }

    private void cHF_(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HealthTrendBar);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.HealthTrendBar_barColor, 0);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.HealthTrendBar_barStrokeWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.e = paint;
        paint.setColor(color);
        this.e.setStrokeWidth(this.d);
        this.e.setAntiAlias(true);
    }

    public void setLength(int i, boolean z) {
        if (Math.abs(i) > 1.0E-5d) {
            this.c = false;
            this.e.setStrokeCap(Paint.Cap.ROUND);
            if (z) {
                i = (int) (i - (this.d / 2.0f));
            }
            this.f9139a = i;
        } else {
            this.c = true;
            this.e.setStrokeCap(Paint.Cap.BUTT);
            this.f9139a = getContext().getResources().getDimensionPixelSize(R.dimen._2131363112_res_0x7f0a0528);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = getHeight() / 2.0f;
        boolean zAy = LanguageUtil.ay(getContext());
        if (zAy) {
            canvas.save();
            canvas.rotate(180.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        }
        canvas.drawLine(-100.0f, height, this.f9139a, height, this.e);
        if (zAy) {
            canvas.restore();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (int) (getPaddingLeft() + this.f9139a + getPaddingRight() + (this.d / 2.0f));
            int measuredWidth = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                measuredWidth += childAt.getMeasuredWidth() + layoutParams.getMarginStart() + layoutParams.getMarginEnd();
            }
            if (!this.c && measuredWidth > size) {
                this.f9139a = (int) (((measuredWidth - getPaddingLeft()) - getPaddingRight()) - (this.d / 2.0f));
                invalidate();
                size = measuredWidth;
            }
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingTop() + this.d + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }
}
