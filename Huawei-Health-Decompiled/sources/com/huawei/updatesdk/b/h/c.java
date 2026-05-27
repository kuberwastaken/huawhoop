package com.huawei.updatesdk.b.h;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11351a;
    private static Resources b;

    public static int c(Context context, String str) {
        return a(context, str, "string");
    }

    public static int b(Context context, String str) {
        return a(context, str, "layout");
    }

    private static String a(Context context) {
        if (f11351a == null) {
            f11351a = context.getPackageName();
        }
        return f11351a;
    }

    private static int a(Context context, String str, String str2) {
        if (b == null) {
            b = context.getResources();
        }
        return b.getIdentifier(str, str2, a(context));
    }

    public static int a(Context context, String str) {
        return a(context, str, "id");
    }
}
