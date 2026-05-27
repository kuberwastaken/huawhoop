package defpackage;

import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes7.dex */
public class sbe {
    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("@")) {
            return b(str);
        }
        if (d(str)) {
            return d(str, 0.5d, 2, 5);
        }
        return d(str, 0.5d, 2, 5);
    }

    private static String b(String str) {
        String strD;
        String[] strArrSplit = str.split("@");
        if (strArrSplit.length == 2) {
            if (strArrSplit[0].length() > 0 && strArrSplit[1].length() > 0) {
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (str2.length() > 6 && a(str2)) {
                    if (str2.length() >= 8) {
                        strD = d(str2, 0.6d, 4, 3);
                    } else {
                        strD = d(str2, 0.5d, 3, 3);
                    }
                } else if (str2.length() > 8) {
                    strD = d(str2, 0.6d, 0, 3);
                } else {
                    strD = d(str2, 0.5d, 0, 3);
                }
                int iIntValue = new BigDecimal(((double) (str3.length() + 1)) * 0.3d).setScale(0, 4).intValue();
                StringBuilder sb = new StringBuilder(16);
                sb.append(strD);
                sb.append("@");
                for (int i = 0; i < str3.length(); i++) {
                    if (i < iIntValue) {
                        sb.append("*");
                    } else {
                        sb.append(str3.charAt(i));
                    }
                }
                return sb.toString();
            }
        }
        return d(str, 0.5d, 2, 3);
    }

    private static String d(String str, double d, int i, int i2) {
        if (str.length() < i2) {
            return "*****".substring(0, str.length());
        }
        int iIntValue = new BigDecimal(((double) str.length()) * d).setScale(0, 4).intValue();
        if (iIntValue > str.length() - i) {
            iIntValue = str.length() - i;
        }
        return str.substring(0, (str.length() - i) - iIntValue) + c(iIntValue) + str.substring(str.length() - i);
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty("^([0-9]|(\\+))\\d+$") || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("^([0-9]|(\\+))\\d+$").matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    private static String c(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("*");
        }
        return sb.toString();
    }

    private static boolean a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
