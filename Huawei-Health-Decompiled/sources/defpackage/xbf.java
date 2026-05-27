package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public class xbf {
    private static boolean b = true;

    public static void b(String str) {
        if (b) {
            Log.i("iReaderScheme", str);
        }
    }

    public static void c(String str) {
        if (b) {
            Log.e("iReaderScheme", str);
        }
    }
}
