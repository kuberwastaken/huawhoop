package defpackage;

import android.text.TextUtils;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes3.dex */
public class chp {
    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            LogUtil.d("BTNumberConvertUtil", "stringToInt is error");
            return 0;
        }
    }
}
