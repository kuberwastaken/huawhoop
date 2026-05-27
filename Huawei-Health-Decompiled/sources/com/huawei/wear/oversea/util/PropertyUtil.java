package com.huawei.wear.oversea.util;

import defpackage.vwc;

/* JADX INFO: loaded from: classes8.dex */
public abstract class PropertyUtil {
    private static final String TAG = "PropertyUtil";

    public static String getProp(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (IllegalAccessException unused) {
            vwc.a(TAG, "IllegalAccessException can not get language and region:IllegalAccessException", false);
            return "";
        } catch (Exception unused2) {
            vwc.a(TAG, "can not get language and region Exception", false);
            return "";
        }
    }
}
