package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes6.dex */
public class mlx {
    public static String d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager == null ? "" : packageManager.getApplicationLabel(context.getApplicationInfo()).toString();
    }
}
