package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* JADX INFO: loaded from: classes10.dex */
public class mag extends maa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5229a;
    private Bitmap b;

    @Override // com.huawei.hms.maps.utils.maa
    public Bitmap a(Context context) {
        Bitmap bitmapA = a(this.f5229a);
        this.b = bitmapA;
        return bitmapA;
    }

    private Bitmap a(String str) {
        LogM.d("PathBitmapDescriptor", "getBitmapFromPath: ");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = 5;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            LogM.e("PathBitmapDescriptor", "generateBitmap OutOfMemoryError: ");
            return null;
        }
    }

    public mag(String str) {
        this.f5229a = str;
    }
}
