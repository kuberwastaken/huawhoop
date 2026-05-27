package defpackage;

import android.text.TextUtils;
import com.huawei.hwlogsmodel.LogUtil;

/* JADX INFO: loaded from: classes4.dex */
public class dna {
    public static void b(boolean z, String str, Object... objArr) {
        if (z) {
            LogUtil.e("PDDebug_" + str, objArr);
        } else {
            LogUtil.e("PluginDevice_" + str, objArr);
        }
    }

    public static void a(boolean z, String str, Object... objArr) {
        if (z) {
            LogUtil.b("PDDebug_" + str, objArr);
        } else {
            LogUtil.b("PluginDevice_" + str, objArr);
        }
    }

    public static void d(boolean z, String str, Object... objArr) {
        if (z) {
            LogUtil.a("PDDebug_" + str, objArr);
        } else {
            LogUtil.a("PluginDevice_" + str, objArr);
        }
    }

    public static void c(boolean z, String str, Object... objArr) {
        if (z) {
            LogUtil.j("PDDebug_" + str, objArr);
        } else {
            LogUtil.j("PluginDevice_" + str, objArr);
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        if (length <= 2) {
            return "**";
        }
        if (length <= 8) {
            return b(str, 1, (length / 3) - 1);
        }
        return b(str, 3, 3);
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? str : b(str, 8, 8);
    }

    private static String b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        if (i < 0 || i2 < 0 || length <= i + i2) {
            return "***";
        }
        StringBuilder sb = new StringBuilder(str);
        StringBuilder sb2 = new StringBuilder(16);
        for (int i3 = 0; i3 < (length - i) - i2; i3++) {
            sb2.append("*");
        }
        sb.replace(i, length - i2, sb2.toString());
        return sb.toString();
    }
}
