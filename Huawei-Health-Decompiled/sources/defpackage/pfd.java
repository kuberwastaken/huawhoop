package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes7.dex */
public class pfd extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16669a;
    int b;
    private int c;
    private Paint d;
    private int e;
    private Paint f;
    private int g;
    private int h;
    private int i;
    private float j;
    private int n;

    private pfd(d dVar) {
        this.f16669a = dVar.b;
        this.j = dVar.f;
        this.h = dVar.c;
        this.c = dVar.f16670a;
        this.g = dVar.e;
        this.n = dVar.i;
        this.i = dVar.g;
        this.e = dVar.d;
        c();
        b();
    }

    private void b() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(this.f16669a);
        this.d.setAntiAlias(true);
        this.d.setStrokeWidth(this.j);
        this.d.setStyle(Paint.Style.STROKE);
    }

    private void c() {
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setColor(this.i);
        this.f.setTextSize(this.n);
        this.f.setAntiAlias(true);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return a(charSequence, i, i2);
    }

    private int e(CharSequence charSequence, int i, int i2) {
        if (charSequence.length() <= 0) {
            return 0;
        }
        Rect rect = new Rect();
        this.f.getTextBounds(charSequence.toString(), i, i2, rect);
        int iWidth = rect.width() + (this.c * 2);
        this.b = iWidth;
        return iWidth;
    }

    public int a(CharSequence charSequence, int i, int i2) {
        return e(charSequence, i, i2) + this.e;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (i4 + fontMetrics.descent) - ((fontMetrics.descent - fontMetrics.ascent) / 2.0f);
        Paint.FontMetrics fontMetrics2 = this.f.getFontMetrics();
        float f3 = fontMetrics2.descent - fontMetrics2.ascent;
        float f4 = f3 / 2.0f;
        float f5 = (f2 - f4) - this.g;
        float f6 = (this.j / 2.0f) + f;
        RectF rectF = new RectF(f6, f5, this.b + f6, f3 + f5 + (r1 * 2));
        float f7 = this.h;
        canvas.drawRoundRect(rectF, f7, f7, this.d);
        canvas.drawText(charSequence.subSequence(i, i2).toString(), f + this.c, f2 + (f4 - fontMetrics2.descent), this.f);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16670a;
        private int b;
        private int c;
        private int d;
        private int e;
        private float f;
        private int g;
        private int i;

        public d d(int i) {
            this.b = i;
            return this;
        }

        public d f(int i) {
            this.g = i;
            return this;
        }

        public d j(int i) {
            this.i = i;
            return this;
        }

        public d c(float f) {
            this.f = f;
            return this;
        }

        public d b(int i) {
            this.c = i;
            return this;
        }

        public d c(int i) {
            this.e = i;
            return this;
        }

        public d e(int i) {
            this.f16670a = i;
            return this;
        }

        public d a(int i) {
            this.d = i;
            return this;
        }

        public pfd c() {
            return new pfd(this);
        }
    }
}
