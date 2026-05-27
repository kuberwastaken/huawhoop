package defpackage;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes11.dex */
public class vnx extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18685a;
    private int[] c;
    private int d;
    private Bitmap f;
    private Paint e = new Paint();
    private float[] b = {0.0f, 1.0f};

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.e);
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY() - this.f18685a, (getBounds().width() >> 1) - this.f18685a, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (rect == null) {
            return;
        }
        super.onBoundsChange(rect);
        Rect rect2 = new Rect(rect);
        int i = 25 - this.d;
        rect2.inset(i, i);
        Bitmap bitmap = this.f;
        if (bitmap == null || bitmap.getWidth() != rect.width() || this.f.getHeight() != rect.height()) {
            this.f = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        }
        Paint paint = this.e;
        float f = rect.left;
        float f2 = rect.top;
        paint.setShader(new LinearGradient(f, f2, rect.right, f2, this.c, this.b, Shader.TileMode.CLAMP));
        this.e.setMaskFilter(new BlurMaskFilter(25.0f, BlurMaskFilter.Blur.NORMAL));
        new Canvas(this.f).drawCircle(rect2.centerX(), rect2.centerY(), rect2.width() >> 1, this.e);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public vnx(int[] iArr, int i, int i2) {
        this.c = iArr;
        this.d = i;
        this.f18685a = i2;
    }
}
