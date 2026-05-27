package com.huawei.maps.offlinedata.utils;

import com.huawei.maps.offlinedata.health.log.ILogHealth;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ILogHealth f6766a;

    public static void a(ILogHealth iLogHealth) {
        if (f6766a == null) {
            f6766a = iLogHealth;
        }
    }

    public static void a(String str, String str2) {
        ILogHealth iLogHealth = f6766a;
        if (iLogHealth != null) {
            iLogHealth.i(str, str2);
        } else {
            h.b(str, str2);
        }
    }

    public static void b(String str, String str2) {
        ILogHealth iLogHealth = f6766a;
        if (iLogHealth != null) {
            iLogHealth.d(str, str2);
        } else {
            h.a(str, str2);
        }
    }

    public static void c(String str, String str2) {
        ILogHealth iLogHealth = f6766a;
        if (iLogHealth != null) {
            iLogHealth.w(str, str2);
        } else {
            h.c(str, str2);
        }
    }

    public static void d(String str, String str2) {
        ILogHealth iLogHealth = f6766a;
        if (iLogHealth != null) {
            iLogHealth.e(str, str2);
        } else {
            h.d(str, str2);
        }
    }
}
