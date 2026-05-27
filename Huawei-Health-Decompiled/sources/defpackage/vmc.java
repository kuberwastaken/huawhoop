package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public class vmc extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f18657a;
    private int b;
    private float c;
    private float d;
    private int e;
    private float f;
    private Paint g;
    private float h;
    private Handler i;
    private float j;
    private Runnable k;

    class e implements Runnable {
        float d = 0.0f;

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float f = this.d + 0.125f;
            this.d = f;
            if (f > 1.0f) {
                this.d = f - 1.0f;
            }
            vmc.this.a(this.d);
            vmc.this.i.postDelayed(this, vmc.this.e);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            Log.e("HwLowFrameLoadingDrawable", "draw error: canvas is null.");
            return;
        }
        this.g.setColor(this.b);
        evu_(canvas);
        if (this.c > 1.0f) {
            this.c = 0.0f;
        }
        canvas.save();
        for (int i = 0; i < 8; i++) {
            int i2 = (int) (this.c / 0.125f);
            int i3 = i2 + 3;
            if (i3 > 8) {
                if (i >= i2 || i < i2 - 5) {
                    this.g.setColor(-13421773);
                } else {
                    this.g.setColor(-7697782);
                }
            } else if (i < i2 || i >= i3) {
                this.g.setColor(-7697782);
            } else {
                this.g.setColor(-13421773);
            }
            canvas.drawCircle(this.j, this.f, this.f18657a, this.g);
            canvas.rotate(45.0f, this.d, this.h);
        }
        canvas.restore();
    }

    public vmc(Resources resources, int i, int i2) {
        super(resources, Bitmap.createBitmap(Math.min(i, 250), Math.min(i, 250), Bitmap.Config.ARGB_8888));
        this.c = 0.0f;
        this.i = new Handler();
        this.k = new e();
        this.e = i2;
        d();
    }

    private void evu_(Canvas canvas) {
        float fEvt_ = evt_(canvas);
        this.f18657a = 0.125f * fEvt_;
        this.j = this.d;
        this.f = this.h - (fEvt_ * 0.85f);
    }

    private void d() {
        Paint paint = new Paint();
        this.g = paint;
        this.d = 0.0f;
        this.h = 0.0f;
        this.b = -7697782;
        paint.setColor(-7697782);
        this.g.setAntiAlias(true);
        a(0.0f);
        this.i.postDelayed(this.k, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        this.c = f;
        invalidateSelf();
    }

    private float evt_(Canvas canvas) {
        this.d = canvas.getWidth() * 0.5f;
        float height = canvas.getHeight() * 0.5f;
        this.h = height;
        return Math.min(this.d, height);
    }
}
