package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes9.dex */
public class nz {
    public static String a(String str) {
        String[] strArrSplit = str.split("=");
        if (strArrSplit.length <= 1) {
            return null;
        }
        String str2 = strArrSplit[1];
        return str2.contains("\"") ? str2.replaceAll("\"", "") : str2;
    }

    public static String b(String str) {
        if (str.contains("app_userid")) {
            return a(str);
        }
        return null;
    }

    public static String c(String str) {
        if (str.contains("biz_no")) {
            return a(str);
        }
        return null;
    }

    public static String d(String str) {
        if (str.contains("biz_type")) {
            return a(str);
        }
        return null;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("&");
        if (strArrSplit.length == 0) {
            return "";
        }
        String strD = null;
        String strC = null;
        String strJ = null;
        String strB = null;
        for (String str2 : strArrSplit) {
            if (TextUtils.isEmpty(strD)) {
                strD = d(str2);
            }
            if (TextUtils.isEmpty(strC)) {
                strC = c(str2);
            }
            if (TextUtils.isEmpty(strJ)) {
                strJ = j(str2);
            }
            if (TextUtils.isEmpty(strB)) {
                strB = b(str2);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(strD)) {
            sb.append("biz_type=" + strD + ";");
        }
        if (!TextUtils.isEmpty(strC)) {
            sb.append("biz_no=" + strC + ";");
        }
        if (!TextUtils.isEmpty(strJ)) {
            sb.append("trade_no=" + strJ + ";");
        }
        if (!TextUtils.isEmpty(strB)) {
            sb.append("app_userid=" + strB + ";");
        }
        String string = sb.toString();
        return string.endsWith(";") ? string.substring(0, string.length() - 1) : string;
    }

    public static String j(String str) {
        if (!str.contains("trade_no") || str.startsWith("out_trade_no")) {
            return null;
        }
        return a(str);
    }
}
