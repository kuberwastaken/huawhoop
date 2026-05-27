package com.huawei.maps.offlinedata.utils;

import android.content.Context;
import com.huawei.health.messagecenter.model.CommonUtil;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f6763a = null;
    private static String b = "";

    public static Context a() {
        return f6763a;
    }

    public static void a(Context context) {
        if (context == null) {
            g.c(CommonUtil.TAG, "context is null");
        }
        if (f6763a == null || context != null) {
            f6763a = context;
        }
    }

    public static String b() {
        return b;
    }

    public static void a(String str) {
        b = str;
    }
}
