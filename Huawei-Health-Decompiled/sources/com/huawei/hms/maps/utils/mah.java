package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes10.dex */
public class mah extends maa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5230a;
    private Bitmap b;

    @Override // com.huawei.hms.maps.utils.maa
    public Bitmap a(Context context) {
        Bitmap bitmapA = a(context, context.getResources().getDrawable(this.f5230a));
        this.b = bitmapA;
        return bitmapA;
    }

    public static Bitmap a(Context context, Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return mad.f5225a.b(context);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public mah(int i) {
        this.f5230a = i;
    }
}
