package com.huawei.agconnect.common.api;

import com.huawei.agconnect.common.log.DefaultLogger;

/* JADX INFO: loaded from: classes3.dex */
public class Logger {
    private static final DefaultLogger SINGLETON = new DefaultLogger();

    public static void w(String str, String str2) {
        SINGLETON.d(str, str2);
    }

    public static void v(String str, String str2) {
        SINGLETON.c(str, str2);
    }

    public static void i(String str, String str2) {
        SINGLETON.b(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        SINGLETON.a(str, str2, th);
    }

    public static void e(String str, String str2) {
        SINGLETON.a(str, str2, null);
    }

    public static void d(String str, String str2) {
        SINGLETON.a(str, str2);
    }
}
