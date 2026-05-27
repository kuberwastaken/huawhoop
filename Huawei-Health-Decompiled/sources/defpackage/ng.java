package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class ng {
    public static final Pattern e = Pattern.compile("([\t\r\n])+");

    public static boolean a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int e(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }
}
