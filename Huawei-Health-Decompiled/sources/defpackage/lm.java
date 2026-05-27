package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class lm {
    public static void c(String str, String str2) {
        try {
            lo.d(str, str2);
        } catch (Throwable unused) {
        }
        if (li.d()) {
            li.b(".SystemConfig" + File.separator + str, str2);
        }
    }

    public static String c(String str) {
        String strC;
        try {
            strC = lo.c(str);
        } catch (Throwable unused) {
            strC = "";
        }
        if (!kn.a(strC)) {
            return strC;
        }
        return li.c(".SystemConfig" + File.separator + str);
    }
}
