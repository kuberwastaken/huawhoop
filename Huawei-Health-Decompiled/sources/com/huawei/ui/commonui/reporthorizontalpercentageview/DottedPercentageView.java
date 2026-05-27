package com.huawei.ui.commonui.reporthorizontalpercentageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.ui.commonui.R$styleable;

/* JADX INFO: loaded from: classes9.dex */
public class DottedPercentageView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9297a;
    private int b;
    private float c;
    private float d;
    private Paint e;
    private float h;
    private float j;

    public DottedPercentageView(Context context) {
        super(context);
        this.b = Color.parseColor("#F5F6FA");
        this.f9297a = Color.parseColor("#B0B7DB");
        cQa_(context, null);
    }

    public DottedPercentageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = Color.parseColor("#F5F6FA");
        this.f9297a = Color.parseColor("#B0B7DB");
        cQa_(context, attributeSet);
    }

    public DottedPercentageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = Color.parseColor("#F5F6FA");
        this.f9297a = Color.parseColor("#B0B7DB");
        cQa_(context, attributeSet);
    }

    private void cQa_(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.dotted_percentage_view, 0, 0);
        this.f9297a = typedArrayObtainStyledAttributes.getColor(R$styleable.dotted_percentage_view_schedule_color, this.f9297a);
        this.b = typedArrayObtainStyledAttributes.getColor(R$styleable.dotted_percentage_view_default_color, this.b);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(this.b);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.j = i;
        this.d = i2;
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.e.setColor(this.b);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.j, this.d), 15.0f, 15.0f, this.e);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, 15.0f, this.d), 0.0f, 0.0f, this.e);
        if (this.h > 0.0f) {
            this.e.setColor(this.f9297a);
            float f = (this.h * this.j) / this.c;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, this.d), 15.0f, 15.0f, this.e);
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, f / 2.0f, this.d), 0.0f, 15.0f, this.e);
        }
    }

    public void setData(int i, int i2) {
        this.h = i;
        this.c = i2;
        invalidate();
    }
}
