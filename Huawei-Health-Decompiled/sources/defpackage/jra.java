package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class jra {
    private static String d = "com.huawei.health";

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("CheckAppUtil", "Health application does not exist");
            return false;
        }
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfoBCP_ = bCP_(context, str);
        if (packageInfoBCP_ != null) {
            return packageInfoBCP_.versionCode;
        }
        return 0;
    }

    private static PackageInfo bCP_(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("CheckAppUtil", "Health application does not exist");
            return null;
        }
    }

    public static String b() {
        return TextUtils.isEmpty(d) ? "com.huawei.health" : d;
    }

    public static void b(String str) {
        d = str;
    }
}
