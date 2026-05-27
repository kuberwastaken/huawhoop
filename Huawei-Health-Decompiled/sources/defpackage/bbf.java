package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class bbf {
    public static int a(String str, String str2) {
        if (!bbc.b()) {
            return -1;
        }
        return Log.w("MarketInstallService", str + ":" + str2);
    }

    public static int b(String str, String str2) {
        if (!bbc.e()) {
            return -1;
        }
        return Log.i("MarketInstallService", str + ":" + str2);
    }

    public static int c(String str, String str2) {
        if (!bbc.b()) {
            return -1;
        }
        return Log.e("MarketInstallService", str + ":" + str2);
    }

    public static int c(String str, String str2, Throwable th) {
        if (!bbc.b()) {
            return -1;
        }
        return Log.e("MarketInstallService", str + ":" + str2, th);
    }

    public static int e(String str, String str2) {
        if (!bbc.d()) {
            return -1;
        }
        return Log.d("MarketInstallService", str + ":" + str2);
    }
}
