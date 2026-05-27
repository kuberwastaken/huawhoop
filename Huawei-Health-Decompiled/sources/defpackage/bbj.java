package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class bbj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f401a = "";
    private static final Object e = new Object();

    public static String b(Context context) {
        String str;
        String str2;
        String str3;
        synchronized (e) {
            if (TextUtils.isEmpty(f401a)) {
                String str4 = ("InstallSDK##11.5.1.300##" + e()) + "##" + bat.a();
                try {
                    String packageName = context.getPackageName();
                    str4 = str4 + "##" + packageName;
                    str3 = str4 + "##" + context.getPackageManager().getPackageInfo(packageName, 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    e = e2;
                    str2 = "get package error";
                    bbf.c("UserAgentUtils", str2, e);
                    str3 = str4;
                } catch (Exception e3) {
                    e = e3;
                    str2 = "get package Exception";
                    bbf.c("UserAgentUtils", str2, e);
                    str3 = str4;
                }
                f401a = str3;
            }
            str = f401a;
        }
        return str;
    }

    private static String e() {
        String strC = bat.c();
        return TextUtils.isEmpty(strC) ? "other" : strC;
    }
}
