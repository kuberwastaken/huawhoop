package com.huawei.ui.commonui.barlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$color;

/* JADX INFO: loaded from: classes7.dex */
public class BarView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9116a;
    private int b;
    private int c;
    private Paint d;
    private int e;

    public BarView(Context context) {
        super(context);
        this.d = new Paint();
        this.f9116a = 0;
        this.b = 0;
        c();
    }

    public BarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Paint();
        this.f9116a = 0;
        this.b = 0;
        c();
    }

    public BarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Paint();
        this.f9116a = 0;
        this.b = 0;
        c();
    }

    private void c() {
        this.d.setStrokeCap(Paint.Cap.ROUND);
        this.d.setAntiAlias(true);
        this.d.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen._2131362888_res_0x7f0a0448));
        this.b = ContextCompat.getColor(getContext(), R$color.health_bar_bg_color);
    }

    public void setData(int i, int i2, int i3) {
        this.e = i;
        this.c = i2;
        this.f9116a = i3;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        float strokeWidth = this.d.getStrokeWidth();
        canvas.rotate(180.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        float width = getWidth() / 2.0f;
        float height = getHeight();
        float f = strokeWidth / 2.0f;
        this.d.setColor(this.b);
        canvas.drawLine(width, 0.0f, width, height - f, this.d);
        float height2 = this.e != 0 ? ((getHeight() * this.e) / this.c) - f : 0.0f;
        if (height2 > 0.0f) {
            this.d.setColor(this.f9116a);
            canvas.drawLine(width, 0.0f, width, height2, this.d);
        }
        canvas.restore();
    }
}
