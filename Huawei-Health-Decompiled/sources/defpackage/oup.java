package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes7.dex */
public class oup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f16566a;
    private static String c;

    public static boolean c(Context context) {
        PackageInfo packageInfoCDe_ = cDe_(context);
        if (packageInfoCDe_ == null) {
            return true;
        }
        String str = packageInfoCDe_.versionName;
        int i = packageInfoCDe_.versionCode;
        String strA = ouw.a(context, "hw_skinner", "LAST_VERSION_NAME", (String) null);
        int iD = ouw.d(context, "hw_skinner", "LAST_VERSION_CODE", -1);
        if (str.equals(strA) && i == iD) {
            return false;
        }
        c = str;
        f16566a = i;
        return true;
    }

    public static void e(Context context) {
        if (TextUtils.isEmpty(c) || f16566a == 0) {
            return;
        }
        ouw.e(context, "hw_skinner", "LAST_VERSION_NAME", c);
        ouw.a(context, "hw_skinner", "LAST_VERSION_CODE", f16566a);
    }

    private static PackageInfo cDe_(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            ouq.c("Get package info error.");
            return null;
        }
    }
}
