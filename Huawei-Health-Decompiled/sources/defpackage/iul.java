package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class iul extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f14300a;
    private final Paint b;
    private final int[] c;
    private float d;
    private float e;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public iul() {
        Paint paint = new Paint(1);
        this.b = paint;
        this.c = new int[]{1279446007, 1281395711, 1285847551, 1290834638, 1291830360, 1291811840};
        this.f14300a = new float[]{0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f};
        this.e = fee.b(20.0f);
        this.d = fee.b(1.0f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        float f = this.d / 2.0f;
        rectF.inset(f, f);
        Path path = new Path();
        float f2 = this.e;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        canvas.drawPath(path, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float f = this.d / 2.0f;
        this.b.setShader(new LinearGradient(rect.left + f, 0.0f, rect.right - f, 0.0f, this.c, this.f14300a, Shader.TileMode.CLAMP));
    }
}
