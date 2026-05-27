package com.huawei.openalliance.ad.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.huawei.openalliance.ad.utils.dh;

/* JADX INFO: loaded from: classes6.dex */
public abstract class p extends ClipDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f8421a;
    private Paint b;
    private Bitmap c;
    private Bitmap d;
    private Canvas e;
    private PorterDuffXfermode f;
    private boolean g;

    protected abstract Path a(int i);

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f8421a.setBounds(i, i2, i3, i4);
        if (this.c != null) {
            b();
        }
        if (this.d != null) {
            c();
            Path pathA = a(getLevel());
            if (pathA != null) {
                this.e.drawPath(pathA, this.b);
            } else {
                Log.e("HwEclipseClipDrawable", "getClipPath fail.");
            }
        }
    }

    @Override // android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        a();
        d();
        if (this.c == null || this.d == null) {
            return;
        }
        Rect bounds = getBounds();
        if (this.g) {
            canvas.scale(-1.0f, 1.0f, bounds.width() / 2.0f, bounds.height() / 2.0f);
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, bounds.width(), bounds.height(), null);
        canvas.drawBitmap(this.d, 0.0f, 0.0f, this.b);
        this.b.setXfermode(this.f);
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.b);
        this.b.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void a(PorterDuff.Mode mode) {
        this.f = new PorterDuffXfermode(mode);
    }

    private void d() {
        Canvas canvas;
        c();
        Path pathA = a(getLevel());
        if (pathA == null || (canvas = this.e) == null) {
            Log.e("HwEclipseClipDrawable", "getClipPath fail.");
        } else {
            canvas.drawPath(pathA, this.b);
        }
    }

    private void c() {
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.d;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.d = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
        this.e = new Canvas(this.d);
    }

    private void b() {
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.c = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.c);
        this.f8421a.setBounds(bounds);
        int level = this.f8421a.getLevel();
        this.f8421a.setLevel(10000);
        this.f8421a.draw(canvas);
        this.f8421a.setLevel(level);
    }

    private void a(Drawable drawable) {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(-16711936);
        this.f8421a = drawable;
        a(PorterDuff.Mode.SRC_IN);
        this.g = dh.h();
    }

    private void a() {
        if (this.c != null) {
            return;
        }
        b();
    }

    public p(Drawable drawable, int i, int i2) {
        super(drawable, i, i2);
        a(drawable);
    }
}
