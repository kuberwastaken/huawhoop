package com.amap.api.col.p0003sl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class ja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ja f1126a = null;
    private static boolean b = false;
    private static boolean c = false;
    private Context d;

    private ja(Context context) {
        this.d = context;
    }

    public static ja a(Context context) {
        if (f1126a == null) {
            synchronized (ja.class) {
                if (f1126a == null) {
                    f1126a = new ja(context);
                }
            }
        }
        return f1126a;
    }

    public static String a() {
        return "";
    }
}
