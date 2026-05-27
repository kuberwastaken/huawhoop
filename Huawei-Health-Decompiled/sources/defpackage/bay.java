package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes3.dex */
public class bay {
    public static String c(Context context) {
        String str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            str = "can not get client version NameNotFoundException.";
            bbf.c("PkgUtil", str);
        } catch (Exception unused2) {
            str = "can not get client version Exception.";
            bbf.c("PkgUtil", str);
        }
        return "";
    }
}
