package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes8.dex */
public class vog extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18693a;
    private int b;
    private int c;
    private int d;
    private int e;
    private ColorStateList f;
    private Paint g;
    private RectF h;
    private float i;
    private Paint j;
    private ColorStateList m;

    public vog() {
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.g.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.j = paint2;
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.h = new RectF();
    }

    private boolean d() {
        boolean z;
        int colorForState;
        int colorForState2;
        int[] state = getState();
        ColorStateList colorStateList = this.f;
        boolean z2 = true;
        if (colorStateList == null || (colorForState2 = colorStateList.getColorForState(state, this.d)) == this.d) {
            z = false;
        } else {
            this.d = colorForState2;
            z = true;
        }
        ColorStateList colorStateList2 = this.m;
        if (colorStateList2 == null || (colorForState = colorStateList2.getColorForState(state, this.f18693a)) == this.f18693a) {
            z2 = z;
        } else {
            this.f18693a = colorForState;
        }
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public void a(int i) {
        this.m = ColorStateList.valueOf(i);
        d();
    }

    public void b(float f) {
        if (Float.floatToIntBits(f) != Float.floatToIntBits(this.i)) {
            this.i = f;
            invalidateSelf();
        }
    }

    public void b(int i) {
        if (i != this.b) {
            this.b = i;
            this.j.setStrokeWidth(i);
            invalidateSelf();
        }
    }

    public void c(int i) {
        if (i != this.c) {
            this.c = i;
            invalidateSelf();
        }
    }

    public void d(int i) {
        this.f = ColorStateList.valueOf(i);
        d();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.h == null) {
            return;
        }
        canvas.save();
        int i = this.c;
        if (i == 1) {
            Paint paint = this.g;
            if (paint != null) {
                float f = this.i * 360.0f;
                paint.setColor(this.f18693a);
                canvas.drawArc(this.h, f - 90.0f, 360.0f - f, false, this.g);
                this.g.setColor(this.d);
                canvas.drawArc(this.h, -90.0f, f, false, this.g);
            }
        } else if (i == 2 && this.j != null) {
            int iRound = Math.round(this.i * 120.0f);
            RectF rectF = this.h;
            float f2 = (rectF.left + rectF.right) * 0.5f;
            float f3 = rectF.top;
            float f4 = rectF.bottom;
            for (int i2 = 0; i2 < 120; i2++) {
                if (i2 < iRound) {
                    this.j.setColor(this.d);
                } else {
                    this.j.setColor(this.f18693a);
                }
                float f5 = this.b * 0.5f;
                canvas.drawLine(f2, this.e + f5, f2, f5, this.j);
                canvas.rotate(3.0f, f2, (f3 + f4) * 0.5f);
            }
        }
        canvas.restore();
    }

    public void e(int i) {
        if (i != this.e) {
            this.e = i;
            this.g.setStrokeWidth(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.h;
        float f = this.e * 0.5f;
        rectF.left = rect.left + f;
        rectF.top = rect.top + f;
        rectF.right = rect.right - f;
        rectF.bottom = rect.bottom - f;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return d();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
