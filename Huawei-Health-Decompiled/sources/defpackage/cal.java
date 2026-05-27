package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class cal {
    public static void d(String str, String str2) {
        if (bzq.b()) {
            Log.i("CodeValuePlatform_" + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (bzq.b()) {
            Log.d("CodeValuePlatform_" + str, str2);
        }
    }

    public static void c(String str, String str2) {
        Log.e("CodeValuePlatform_" + str, str2);
    }

    public static void a(String str, String str2) {
        Log.w("CodeValuePlatform_" + str, str2);
    }
}
