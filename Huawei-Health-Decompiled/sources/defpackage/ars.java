package defpackage;

import android.text.TextUtils;
import android.util.Log;
import health.compact.a.LogUtil;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public class ars {
    private final String e;

    public ars(String str) {
        this.e = str;
    }

    public void a(String str, Object... objArr) {
        b(4, str, objArr);
    }

    public void d(String str, Object... objArr) {
        b(3, str, objArr);
    }

    public void e(String str, Object... objArr) {
        b(5, str, objArr);
    }

    public void c(String str, Object... objArr) {
        b(6, str, objArr);
    }

    public void e(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("Bundle_Logger", 6)) {
            LogUtil.d("Bundle_Logger", a(this.e, str, objArr), ", ex=", LogUtil.c(th));
        }
    }

    private void b(int i, String str, Object[] objArr) {
        if (Log.isLoggable("Bundle_Logger", i)) {
            LogUtil.a("Bundle_Logger", a(this.e, str, objArr));
        }
    }

    private static String a(String str, String str2, Object... objArr) {
        String str3 = str + ":" + str2;
        if (objArr == null || objArr.length <= 0) {
            return str3;
        }
        try {
            return String.format(Locale.ENGLISH, str3, objArr);
        } catch (IllegalFormatException e) {
            LogUtil.d("Bundle_Logger", "Unable to format ", str3, ", ex=", LogUtil.c(e));
            return str3 + " [" + TextUtils.join(", ", objArr) + "]";
        }
    }
}
