package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes10.dex */
public class gbd {
    private static SharedPreferences b;

    public static SharedPreferences awP_(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (gbd.class) {
            if (b == null) {
                b = context.createDeviceProtectedStorageContext().getSharedPreferences("WearLbsAuth", 0);
            }
            sharedPreferences = b;
        }
        return sharedPreferences;
    }

    public static void e(String str, long j, Context context) {
        awP_(context).edit().putLong(str, j).apply();
    }

    public static long c(String str, long j, Context context) {
        return awP_(context).getLong(str, j);
    }

    public static void a(String str, String str2, Context context) {
        awP_(context).edit().putString(str, str2).apply();
    }

    public static String e(String str, String str2, Context context) {
        return awP_(context).getString(str, str2);
    }
}
