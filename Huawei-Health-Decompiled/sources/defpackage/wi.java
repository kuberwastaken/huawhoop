package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class wi {
    public static boolean d = false;

    public static void b(String str, String str2) {
        if (d) {
            Log.i("ChipseaLib_", str + ": " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (d) {
            Log.e("ChipseaLib_", str + ": " + str2);
        }
    }
}
