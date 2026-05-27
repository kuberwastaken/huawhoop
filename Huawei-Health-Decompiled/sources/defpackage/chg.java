package defpackage;

import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes3.dex */
public class chg {
    public static int d(String str, int i) {
        if (str == null) {
            LogUtil.d("parseIntCheck", "parseIntCheck value is null");
            return -1;
        }
        try {
            return Integer.parseInt(str, i);
        } catch (NumberFormatException unused) {
            LogUtil.d("parseIntCheck", "parseIntCheck value is invalid :", str);
            return -1;
        }
    }
}
