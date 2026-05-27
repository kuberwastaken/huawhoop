package defpackage;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class ll {
    public static void b(Context context, String str, String str2, String str3) {
        synchronized (ll.class) {
            if (kn.a(str) || kn.a(str2) || context == null) {
                return;
            }
            try {
                String strB = ko.b(ko.e(), str3);
                HashMap map = new HashMap();
                map.put(str2, strB);
                lk.d(context, str, map);
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(Context context, String str, String str2) {
        synchronized (ll.class) {
            String strD = null;
            if (context != null) {
                if (!kn.a(str) && !kn.a(str2)) {
                    try {
                        String strC = lk.c(context, str, str2, "");
                        if (kn.a(strC)) {
                            return null;
                        }
                        strD = ko.d(ko.e(), strC);
                    } catch (Throwable unused) {
                    }
                    return strD;
                }
            }
            return null;
        }
    }
}
