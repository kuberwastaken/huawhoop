package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes11.dex */
public class CornerImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f8082a;
    private float b;
    private Path c;

    public void setRectCornerRadius(float f) {
        this.b = f;
        a();
        postInvalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f8082a.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        a();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.b > 0.01f) {
            canvas.clipPath(this.c);
        }
        super.draw(canvas);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100323_res_0x7f0602a3})) != null) {
            try {
                this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.c = new Path();
    }

    private void a() {
        this.c.reset();
        Path path = this.c;
        RectF rectF = this.f8082a;
        float f = this.b;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    public CornerImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8082a = new RectF();
        this.b = 0.0f;
        a(context, attributeSet);
    }

    public CornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8082a = new RectF();
        this.b = 0.0f;
        a(context, attributeSet);
    }

    public CornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8082a = new RectF();
        this.b = 0.0f;
        a(context, attributeSet);
    }

    public CornerImageView(Context context) {
        super(context);
        this.f8082a = new RectF();
        this.b = 0.0f;
        a(context, null);
    }
}
