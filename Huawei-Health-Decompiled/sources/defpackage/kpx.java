package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class kpx {
    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "setMetricUnit".equalsIgnoreCase(str);
    }
}
