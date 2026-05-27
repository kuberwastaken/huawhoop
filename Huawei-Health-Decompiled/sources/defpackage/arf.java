package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public final class arf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f279a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final String e;
    private static final char[] f;
    public static final boolean g;
    public static final boolean h;
    public static final String i;
    public static final String j;
    private static arb k;
    private static Properties l;
    private static final int o;

    static {
        boolean zB = are.b("ro.config.hw_emui_wfd_pc_mode", false);
        g = zB;
        b = zB;
        c = are.b("ro.config.hw_emui_welink_cast", false);
        String strB = are.b("ro.build.characteristics", "phone");
        e = strB;
        d = strB.equalsIgnoreCase("tablet");
        f279a = are.b("hw_sc.product.useBrandCust", false);
        String strB2 = are.b("debug.wfd_dump", "0");
        i = strB2;
        h = strB2.equalsIgnoreCase("1");
        j = are.b("ro.build.product", "");
        o = are.e("ro.logsystem.usertype", 0);
        f = "0123456789ABCDEF".toCharArray();
        l = null;
        k = arb.d();
    }

    public static boolean a() {
        int i2 = o;
        return i2 == 3 || i2 == 5;
    }

    public static boolean c(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    k.b("UtilMethod", "isPackageExist: PM service not found");
                    return false;
                }
                packageManager.getApplicationInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                k.b("UtilMethod", "isPackageExist: get app info fail for " + str);
            }
        }
        return false;
    }
}
