package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes8.dex */
public class wze {
    private static SharedPreferences c;

    public static void d(String str, String str2, Context context) {
        fEd_(context).edit().putString(str, str2).apply();
    }

    public static void a(String str, long j, Context context) {
        fEd_(context).edit().putLong(str, j).apply();
    }

    public static void c(String str, int i, Context context) {
        fEd_(context).edit().putInt(str, i).apply();
    }

    public static String a(String str, String str2, Context context) {
        return fEd_(context).getString(str, str2);
    }

    public static long e(String str, long j, Context context) {
        return fEd_(context).getLong(str, j);
    }

    public static int e(String str, int i, Context context) {
        return fEd_(context).getInt(str, i);
    }

    public static SharedPreferences fEd_(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (wze.class) {
            if (c == null) {
                c = context.createDeviceProtectedStorageContext().getSharedPreferences("ucs.sdk", 0);
            }
            sharedPreferences = c;
        }
        return sharedPreferences;
    }
}
