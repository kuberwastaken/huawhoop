package com.huawei.healthcloud.plugintrack.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes10.dex */
public class LineProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3914a;
    private int b;
    private int c;
    private Paint d;
    private float e;
    private int f;
    private Paint g;
    private int i;
    private float j;

    public LineProgressBar(Context context) {
        this(context, null);
    }

    public LineProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = null;
        this.d = null;
        boa_(context, attributeSet);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        bnZ_(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a();
    }

    public void setMaxProgress(float f) {
        if (f < 0.0f) {
            this.j = 0.0f;
        } else {
            this.j = f;
        }
    }

    public void setProgress(float f) {
        if (f < 0.0f) {
            this.f3914a = 0.0f;
        } else {
            float f2 = this.j;
            if (f > f2) {
                this.f3914a = f2;
            } else {
                this.f3914a = f;
            }
        }
        this.e = this.f3914a / this.j;
        invalidate();
    }

    private void boa_(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131099762_res_0x7f060072, R.attr._2131100316_res_0x7f06029c, R.attr._2131101266_res_0x7f060652, R.attr._2131101800_res_0x7f060868});
        try {
            this.b = typedArrayObtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color._2131297958_res_0x7f0906a6));
            this.i = typedArrayObtainStyledAttributes.getColor(1, ContextCompat.getColor(context, R.color._2131297958_res_0x7f0906a6));
            this.j = typedArrayObtainStyledAttributes.getColor(3, 100);
            this.f3914a = typedArrayObtainStyledAttributes.getColor(2, 0);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.g = paint;
            paint.setAntiAlias(true);
            this.g.setStyle(Paint.Style.STROKE);
            this.g.setStrokeWidth(16.0f);
            this.g.setStrokeCap(Paint.Cap.ROUND);
            this.g.setStrokeJoin(Paint.Join.ROUND);
            Paint paint2 = new Paint();
            this.d = paint2;
            paint2.setAntiAlias(true);
            this.d.setStyle(Paint.Style.STROKE);
            this.d.setStrokeWidth(16.0f);
            this.d.setStrokeCap(Paint.Cap.ROUND);
            this.d.setStrokeJoin(Paint.Join.ROUND);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void a() {
        this.f = getWidth();
        this.c = getHeight();
    }

    private void bnZ_(Canvas canvas) {
        this.d.setColor(this.b);
        float f = this.c / 2.0f;
        canvas.drawLine(10.0f, f, this.f - 10, f, this.d);
        if (this.e != 0.0f) {
            this.g.setColor(this.i);
            float f2 = this.c / 2.0f;
            canvas.drawLine(10.0f, f2, ((this.f - 20) * this.e) + 10.0f, f2, this.g);
        }
    }
}
