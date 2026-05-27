package com.huawei.hianalytics.core.common;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class EnvUtils {
    public static Context appContext;

    public static void setAppContext(Context context) {
        appContext = context;
    }

    public static Context getAppContext() {
        return appContext;
    }
}
