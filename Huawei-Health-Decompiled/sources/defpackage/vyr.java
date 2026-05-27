package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class vyr {
    public static boolean b(CharSequence charSequence, boolean z) {
        if (TextUtils.isEmpty(charSequence)) {
            return true;
        }
        return z && TextUtils.isEmpty(charSequence.toString().trim());
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return d(str, i);
        }
    }

    public static int d(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            if (d(str)) {
                if (str.startsWith("0X") || str.startsWith("0x")) {
                    str = str.substring(2, str.length());
                }
                i = Integer.parseInt(str, 16);
            } else {
                i = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        return i;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 2;
        if (str.length() <= 2 || str.charAt(0) != '0' || (str.charAt(1) != 'X' && str.charAt(1) != 'x')) {
            i = 0;
        }
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                if ((cCharAt < 'A' || cCharAt > 'F') && (cCharAt < 'a' || cCharAt > 'f')) {
                    return false;
                }
                i2++;
            }
            i++;
        }
        return i2 > 0;
    }
}
