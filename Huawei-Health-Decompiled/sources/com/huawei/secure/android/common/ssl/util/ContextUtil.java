package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public class ContextUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f8972a;

    public static Context getInstance() {
        return f8972a;
    }

    public static void setContext(Context context) {
        if (context == null || f8972a != null) {
            return;
        }
        f8972a = context.getApplicationContext();
    }
}
