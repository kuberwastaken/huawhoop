package health.compact.a.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class StringUtils {
    private StringUtils() {
    }

    public static boolean f(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean i(String str) {
        return !f(str);
    }

    private static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return Pattern.compile(str2).matcher(str).matches();
    }

    public static boolean b(String str) {
        if (f(str)) {
            return false;
        }
        return b(str, "[a-zA-Z]+");
    }

    public static boolean d(String str) {
        if (f(str)) {
            return false;
        }
        return b(str, "[^\\x00-\\xff]");
    }

    public static boolean e(String str) {
        if (f(str)) {
            return false;
        }
        return b(str, "[0-9]*");
    }

    public static String a(Object obj) {
        return obj == null ? "" : obj.toString().trim();
    }

    public static boolean a(String str) {
        return b(str, "^[0-9]+\\*+[0-9]+$");
    }

    public static boolean c(String str) {
        return b(str, "^[a-zA-Z0-9_-|*]+@[a-zA-Z0-9_-|*]+(\\.[a-zA-Z0-9_-|*]+)+$");
    }
}
