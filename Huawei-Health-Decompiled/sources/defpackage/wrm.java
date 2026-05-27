package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public class wrm {
    private static final boolean c = wqm.d;

    public static int a(String str, String str2) {
        if (!c) {
            return 0;
        }
        return Log.d("WearEngine_" + str, str2);
    }

    public static int d(String str, String str2) {
        return Log.i("WearEngine_" + str, str2);
    }

    public static int e(String str, String str2) {
        return Log.w("WearEngine_" + str, str2);
    }

    public static int b(String str, String str2) {
        return Log.e("WearEngine_" + str, str2);
    }
}
