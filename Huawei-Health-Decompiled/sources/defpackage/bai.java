package defpackage;

import android.app.UiModeManager;
import android.content.Context;
import com.huawei.android.app.PackageManagerEx;

/* JADX INFO: loaded from: classes3.dex */
public class bai {
    private static int c = -1;

    private static boolean c(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    private static boolean d(Context context) {
        return ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4;
    }

    private static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("com.huawei.software.features.car");
    }

    private static boolean b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    private static boolean e(String str) {
        try {
            return PackageManagerEx.hasHwSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c() {
        return e("com.huawei.software.features.kidpad");
    }

    public static int e(Context context) {
        int i = c;
        if (i >= 0) {
            return i;
        }
        int i2 = d(context) ? 1 : c(context) ? 2 : b(context) ? 3 : c() ? 4 : a(context) ? 7 : 0;
        c = i2;
        return i2;
    }
}
