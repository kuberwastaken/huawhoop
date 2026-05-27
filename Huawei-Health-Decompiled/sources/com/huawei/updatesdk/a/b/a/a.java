package com.huawei.updatesdk.a.b.a;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static final Object b = new Object();
    private static volatile a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11317a;

    public String b() {
        Context context = this.f11317a;
        return (context == null || context.getFilesDir() == null) ? "" : this.f11317a.getFilesDir().getAbsolutePath();
    }

    public Context a() {
        return this.f11317a;
    }

    public static a c() {
        return c;
    }

    public static void a(Context context) {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
    }

    private a(Context context) {
        this.f11317a = context.getApplicationContext();
    }
}
