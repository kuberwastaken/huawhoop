package defpackage;

import android.os.Build;
import com.huawei.android.os.SystemPropertiesEx;

/* JADX INFO: loaded from: classes3.dex */
public class cad {
    public static int b(String str, int i) {
        if (!e()) {
            try {
                return SystemPropertiesEx.getInt(str, i);
            } catch (Throwable unused) {
                return cag.b(str, i);
            }
        }
        return cag.b(str, i);
    }

    public static String a(String str, String str2) {
        if (!e()) {
            try {
                return SystemPropertiesEx.get(str, str2);
            } catch (Throwable unused) {
                return cag.b(str, str2);
            }
        }
        return cag.b(str, str2);
    }

    private static boolean e() {
        return Build.VERSION.SDK_INT < 28;
    }
}
