package defpackage;

import com.huawei.secure.android.common.util.SafeString;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class bbl {
    private static String b(String str, String str2) {
        if (str2.length() == 0) {
            return str;
        }
        if (str.length() == 0) {
            return str2;
        }
        char cCharAt = str2.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            if (str2.length() > 1 && Character.isUpperCase(str2.charAt(1))) {
                return String.format(Locale.ENGLISH, "%s%s", str, str2);
            }
            boolean z = str2.length() > 2 && (Character.isTitleCase(str2.charAt(1)) || Character.isUpperCase(str2.charAt(1)));
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[2];
            objArr[0] = Character.valueOf(z ? Character.toUpperCase(cCharAt) : Character.toTitleCase(cCharAt));
            objArr[1] = str2.subSequence(1, str2.length());
            str2 = String.format(locale, "%s%s", objArr);
        }
        return String.format(Locale.ENGLISH, "%s%s", str, str2);
    }

    private static String e(CharSequence charSequence, boolean z, String str, String str2) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = charSequence.toString();
        if (!z || !string.startsWith("is") || charSequence.length() <= 2 || Character.isLowerCase(charSequence.charAt(2))) {
            if (!z) {
                str = str2;
            }
            return b(str, string);
        }
        return str + SafeString.substring(string, 2);
    }

    public static String c(CharSequence charSequence, boolean z) {
        return e(charSequence, z, "is", "get");
    }
}
