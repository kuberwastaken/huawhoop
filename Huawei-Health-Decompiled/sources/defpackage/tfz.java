package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.huawei.hwlogsmodel.LogUtil;

/* JADX INFO: loaded from: classes8.dex */
public class tfz extends ImageSpan {
    private final int b;
    private final int d;

    public tfz(Drawable drawable, int i, int i2) {
        super(drawable);
        this.b = i;
        this.d = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            LogUtil.j("CenterSpaceImageSpan", "draw drawable is null.");
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        float f2 = this.b;
        int i6 = (((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2;
        int i7 = drawable.getBounds().bottom / 2;
        canvas.save();
        canvas.translate(f2 + f, i6 - i7);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return this.b + super.getSize(paint, charSequence, i, i2, fontMetricsInt) + this.d;
    }
}
