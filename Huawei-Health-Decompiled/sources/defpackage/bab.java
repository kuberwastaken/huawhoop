package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class bab {
    public static int b(String str, String str2) {
        return -1;
    }

    public static int e(String str, String str2) {
        return Log.w("CoreServiceSDK", str + ":" + str2);
    }

    public static int c(String str, String str2) {
        return Log.i("CoreServiceSDK", str + ":" + str2);
    }

    public static int d(String str, String str2) {
        return Log.e("CoreServiceSDK", str + ":" + str2);
    }

    public static int e(String str, String str2, Throwable th) {
        return Log.e("CoreServiceSDK", str + ":" + str2, th);
    }
}
