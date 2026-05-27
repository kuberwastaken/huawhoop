package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public class vwc {
    public static void b(String str, String str2, boolean z) {
        vwh.d(str, str2, z);
    }

    private static String e(String str, String str2, Throwable th, boolean z) {
        StringBuilder sb = new StringBuilder(256);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append("    ");
        }
        if (!TextUtils.isEmpty(str2)) {
            if (z) {
                sb.append(vwh.c(str2));
            } else {
                sb.append(str2);
            }
        }
        if (th != null) {
            sb.append("    ");
            sb.append(vwh.e(th));
        }
        return sb.toString();
    }

    public static void e(String str, String str2, boolean z) {
        vwh.a(e("OverSea", str2, null, z));
        vwh.e(str, str2, z);
    }

    public static void a(String str, String str2) {
        d(str, str2, false);
    }

    public static void d(String str, String str2, boolean z) {
        vwh.a(e("OverSea", str2, null, z));
        vwh.e(str, str2, null, z);
    }

    public static void a(String str, String str2, boolean z) {
        vwh.a(e("OverSea", str2, null, z));
        vwh.e(str, str2, null, z);
    }

    public static void c(String str, String str2, Throwable th, boolean z) {
        vwh.a(e("OverSea", str2, th, z));
        vwh.e(str, str2, th, z);
    }

    public static void e(String str, String str2) {
        b(str, str2, false);
    }

    public static void c(String str, String str2) {
        e(str, str2, false);
    }

    public static void b(String str, String str2) {
        a(str, str2, false);
    }
}
