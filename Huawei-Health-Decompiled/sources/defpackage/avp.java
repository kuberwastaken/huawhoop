package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class avp {
    private static boolean d = true;

    public static void d(String str, String str2) {
        if (d) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        Log.e(str, str2);
    }
}
