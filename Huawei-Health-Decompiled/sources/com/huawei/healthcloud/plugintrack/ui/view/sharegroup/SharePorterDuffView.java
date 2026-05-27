package com.huawei.healthcloud.plugintrack.ui.view.sharegroup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public class SharePorterDuffView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Typeface f3952a;
    private final PorterDuff.Mode b;
    private Bitmap c;
    private Bitmap d;
    private Paint e;
    private int f;
    private int g;
    private PorterDuffXfermode h;
    private int i;
    private String j;

    public SharePorterDuffView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.b = mode;
        this.e = new Paint(1);
        this.h = new PorterDuffXfermode(mode);
    }

    private void a() {
        Drawable drawable = new Drawable() { // from class: com.huawei.healthcloud.plugintrack.ui.view.sharegroup.SharePorterDuffView.3
            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
            }

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
            }
        };
        this.c = Bitmap.createBitmap(this.i, this.g, Bitmap.Config.ALPHA_8);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(this.f);
        textPaint.setColor(-16777216);
        textPaint.setTypeface(this.f3952a);
        Canvas canvas = new Canvas(this.c);
        drawable.setBounds(0, 0, this.i, this.g);
        drawable.draw(canvas);
        canvas.drawBitmap(this.c, 0.0f, 0.0f, new Paint());
        canvas.drawText(this.j, this.c.getWidth() / 2.0f, ((this.c.getHeight() - textPaint.getFontMetrics().top) - textPaint.getFontMetrics().bottom) / 2.0f, textPaint);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.g = getHeight();
        this.i = getWidth();
        a();
        canvas.drawColor(-16777216);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, this.i, this.g, null, 31);
        canvas.drawBitmap(this.d, 0.0f, 0.0f, this.e);
        this.e.setXfermode(this.h);
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.e);
        this.e.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }
}
