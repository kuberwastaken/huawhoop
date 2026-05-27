package com.huawei.watchface;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public class dg {
    public static Context a(Context context) {
        return context.isDeviceProtectedStorage() ? context : context.createDeviceProtectedStorageContext();
    }
}
