package com.huawei.hwcloudjs.b;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f6387a = null;
    private static boolean b = true;

    public static boolean b() {
        return b;
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void a(Context context) {
        f6387a = context.getApplicationContext();
    }

    public static Context a() {
        return f6387a;
    }
}
