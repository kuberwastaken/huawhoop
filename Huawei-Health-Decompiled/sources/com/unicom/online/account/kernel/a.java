package com.unicom.online.account.kernel;

import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11925a = false;

    public static void b(String str) {
        Log.e("uniaccount", "6.3.0 ".concat(String.valueOf(str)));
    }

    public static void a(boolean z) {
        f11925a = z;
    }

    public static void a(String str) {
        if (f11925a) {
            Log.i("uniaccount", "6.3.0 ".concat(String.valueOf(str)));
        }
    }

    public static void a(Exception exc) {
        if (f11925a) {
            exc.printStackTrace();
        }
    }
}
