package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.appgallery.agd.api.AgdConstant;
import java.util.Locale;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public class EncodeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8979a = "EncodeUtil";
    private static final char[] b = {',', FilenameUtils.EXTENSION_SEPARATOR, '-', '_'};
    private static final String[] c = new String[256];

    static {
        for (char c2 = 0; c2 < 255; c2 = (char) (c2 + 1)) {
            if ((c2 < '0' || c2 > '9') && ((c2 < 'A' || c2 > 'Z') && (c2 < 'a' || c2 > 'z'))) {
                c[c2] = b(c2).intern();
            } else {
                c[c2] = null;
            }
        }
    }

    private static String a(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(a(cArr, Character.valueOf(str.charAt(i))));
        }
        return sb.toString();
    }

    private static String b(char c2) {
        return Integer.toHexString(c2);
    }

    private static Character c(a aVar, Character ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            Character chE = aVar.e();
            if (chE == null) {
                aVar.i();
                return null;
            }
            sb.append(chE);
        }
        try {
            int i2 = Integer.parseInt(sb.toString(), 16);
            return Character.isValidCodePoint(i2) ? Character.valueOf((char) i2) : ch;
        } catch (NumberFormatException unused) {
            aVar.i();
            return null;
        }
    }

    private static Character d(a aVar, Character ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            Character chE = aVar.e();
            if (chE == null) {
                aVar.i();
                return null;
            }
            sb.append(chE);
        }
        try {
            int i2 = Integer.parseInt(sb.toString(), 16);
            return Character.isValidCodePoint(i2) ? Character.valueOf((char) i2) : ch;
        } catch (NumberFormatException unused) {
            aVar.i();
            return null;
        }
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            a aVar = new a(str);
            while (aVar.a()) {
                Character chA = a(aVar);
                if (chA != null) {
                    sb.append(chA);
                } else {
                    sb.append(aVar.d());
                }
            }
            return sb.toString();
        } catch (Exception e) {
            Log.e(f8979a, "decode js: " + e.getMessage());
            return "";
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, b);
    }

    private static Character b(a aVar, Character ch) {
        StringBuilder sb = new StringBuilder();
        sb.append(ch);
        Character chD = aVar.d();
        if (a.b(chD)) {
            sb.append(chD);
            Character chD2 = aVar.d();
            if (a.b(chD2)) {
                sb.append(chD2);
            } else {
                aVar.c(chD2);
            }
        } else {
            aVar.c(chD);
        }
        try {
            int i = Integer.parseInt(sb.toString(), 8);
            return Character.isValidCodePoint(i) ? Character.valueOf((char) i) : ch;
        } catch (NumberFormatException unused) {
            aVar.i();
            return null;
        }
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(cArr, str);
        } catch (Exception e) {
            Log.e(f8979a, "encode js: " + e.getMessage());
            return "";
        }
    }

    private static String a(char[] cArr, Character ch) {
        if (a(ch.charValue(), cArr)) {
            return "" + ch;
        }
        if (a(ch.charValue()) == null) {
            return "" + ch;
        }
        String hexString = Integer.toHexString(ch.charValue());
        if (ch.charValue() < 256) {
            return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
        return "\\u" + AgdConstant.INSTALL_TYPE_DEFAULT.substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
    }

    private static boolean a(char c2, char[] cArr) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    private static String a(char c2) {
        if (c2 < 255) {
            return c[c2];
        }
        return b(c2);
    }

    private static Character a(a aVar) {
        aVar.c();
        Character chD = aVar.d();
        if (chD != null && chD.charValue() == '\\') {
            Character chD2 = aVar.d();
            if (chD2 == null) {
                aVar.i();
                return null;
            }
            return a(aVar, chD2);
        }
        aVar.i();
        return null;
    }

    private static Character a(a aVar, Character ch) {
        if (ch.charValue() == 'b') {
            return '\b';
        }
        if (ch.charValue() == 't') {
            return '\t';
        }
        if (ch.charValue() == 'n') {
            return '\n';
        }
        if (ch.charValue() == 'v') {
            return (char) 11;
        }
        if (ch.charValue() == 'f') {
            return '\f';
        }
        if (ch.charValue() == 'r') {
            return '\r';
        }
        if (ch.charValue() == '\"') {
            return '\"';
        }
        if (ch.charValue() == '\'') {
            return '\'';
        }
        if (ch.charValue() == '\\') {
            return Character.valueOf(IOUtils.DIR_SEPARATOR_WINDOWS);
        }
        if (Character.toLowerCase(ch.charValue()) == 'x') {
            return d(aVar, ch);
        }
        if (Character.toLowerCase(ch.charValue()) == 'u') {
            return c(aVar, ch);
        }
        return a.b(ch) ? b(aVar, ch) : ch;
    }
}
