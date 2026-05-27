package com.huawei.pluginsocialshare.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class ClipImageMaskView extends View {
    private static final int d = Color.parseColor("#4D4D4D");
    private static final int e = Color.parseColor("#AA000000");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8832a;
    private Context b;
    private int c;
    private int f;
    private Paint g;
    private int h;

    public ClipImageMaskView(Context context) {
        this(context, null);
    }

    public ClipImageMaskView(c cVar) {
        this(cVar.e);
        this.b = cVar.e;
        this.h = cVar.f8833a;
        this.f8832a = cVar.b;
        this.f = cVar.d;
    }

    public ClipImageMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipImageMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 1;
        this.h = 1;
        this.f8832a = 1;
        this.c = (int) TypedValue.applyDimension(1, 1, getResources().getDisplayMetrics());
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int i = (height - (((width - (this.f * 2)) * this.f8832a) / this.h)) / 2;
        this.g.setColor(e);
        this.g.setStyle(Paint.Style.FILL);
        float f = height;
        canvas.drawRect(0.0f, 0.0f, this.f, f, this.g);
        canvas.drawRect(width - this.f, 0.0f, width, f, this.g);
        int i2 = this.f;
        float f2 = i2;
        float f3 = width - i2;
        float f4 = i;
        canvas.drawRect(f2, 0.0f, f3, f4, this.g);
        float f5 = height - i;
        canvas.drawRect(this.f, f5, width - r6, f, this.g);
        this.g.setColor(d);
        this.g.setStrokeWidth(this.c);
        this.g.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.f, f4, width - r3, f5, this.g);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8833a = 1;
        private int b = 1;
        private int d;
        private Context e;

        public c(Context context, int i) {
            this.d = i;
            this.e = context;
        }

        public c d(int i) {
            if (i < 0) {
                return this;
            }
            this.d = i;
            return this;
        }

        public c c(int i) {
            if (i < 0) {
                return this;
            }
            this.f8833a = i;
            return this;
        }

        public c b(int i) {
            if (i < 0) {
                return this;
            }
            this.b = i;
            return this;
        }

        public ClipImageMaskView b() {
            return new ClipImageMaskView(this);
        }
    }
}
