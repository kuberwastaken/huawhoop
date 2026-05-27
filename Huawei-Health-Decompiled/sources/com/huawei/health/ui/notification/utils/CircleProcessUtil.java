package com.huawei.health.ui.notification.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class CircleProcessUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3594a;
    private Paint b;
    private RectF c;
    private Context d;
    private int e;
    private Paint g;

    public CircleProcessUtil(Context context) {
        this.d = context;
    }

    private void b() {
        this.f3594a = c(this.d, 44.0f);
        int iC = c(this.d, 8.0f);
        this.e = iC;
        int i = iC / 2;
        float f = i;
        float f2 = this.f3594a - i;
        this.c = new RectF(f, f, f2, f2);
        int iArgb = Color.argb(40, 255, 255, 255);
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(iArgb);
        this.b.setStrokeWidth(this.e);
        this.b.setFilterBitmap(false);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setAntiAlias(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeJoin(Paint.Join.ROUND);
        this.g.setStrokeCap(Paint.Cap.ROUND);
        this.g.setColor(-1);
        this.g.setStrokeWidth(this.e);
    }

    public Bitmap aSE_(float f) {
        b();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        int i = this.f3594a;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i, config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawArc(this.c, 0.0f, 360.0f, false, this.b);
        canvas.drawArc(this.c, -90.0f, f * 360.0f, false, this.g);
        return bitmapCreateBitmap;
    }

    public static int c(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
