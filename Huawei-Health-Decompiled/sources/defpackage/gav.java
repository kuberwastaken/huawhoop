package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public class gav {
    private static Context b;
    private static String d;

    public static void d(Context context) {
        gbo.a("LocationSdkUtil", "setContext start");
        b = context;
        gbc.d();
    }

    public static Context b() {
        return b;
    }

    public static void e(String str) {
        gbo.a("LocationSdkUtil", "setSerCountry start");
        d = str;
    }

    public static String a() {
        return d;
    }
}
