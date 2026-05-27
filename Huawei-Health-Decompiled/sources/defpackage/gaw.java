package defpackage;

import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class gaw {
    private static final Pattern e = Pattern.compile("(.*([/\\\\]{1}[\\.\\.]{1,2}|[\\.\\.]{1,2}[/\\\\]{1}|\\.\\.).*|\\.)");

    public static boolean d(String str) {
        return !e.matcher(str).matches();
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 94) {
                    break;
                }
                if (str.charAt(i) == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-=[];\\',./ ~!@#$%^&*()_+\"{}|:<>?".charAt(i2)) {
                    stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-=[];\\',./ ~!@#$%^&*()_+\"{}|:<>?".charAt(i2));
                    break;
                }
                i2++;
            }
        }
        return stringBuffer.toString();
    }

    public static String e(String str) {
        if (d(str)) {
            return c(str);
        }
        throw new RuntimeException("Invalid file path");
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() || file.mkdirs();
    }
}
