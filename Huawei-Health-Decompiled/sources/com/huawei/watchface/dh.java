package com.huawei.watchface;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.huawei.watchface.utils.ColorPickerUtil;
import com.huawei.watchface.utils.HwLog;

/* JADX INFO: loaded from: classes11.dex */
public class dh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11493a = "dh";

    public static int a(Bitmap bitmap, Rect rect) {
        if (bitmap == null || rect == null) {
            HwLog.w(f11493a, "obtainWidgetColor -- bitmap or rect is null!");
            return -1;
        }
        int iA = ColorPickerUtil.a(bitmap, rect);
        HwLog.i(f11493a, "pickedColor ===  " + iA);
        return iA;
    }
}
