package defpackage;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class lj {
    public static void c(Context context, String str, String str2, String str3) {
        synchronized (lj.class) {
            if (!kn.a(str)) {
                if (!kn.a(str2) && context != null) {
                    try {
                        String strB = ko.b(ko.e(), str3);
                        HashMap map = new HashMap();
                        map.put(str2, strB);
                        lk.d(context, str, map);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
