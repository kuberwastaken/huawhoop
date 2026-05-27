package com.huawei.openalliance.ad;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public abstract class hq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static hr f7166a = new hr();

    private static String e() {
        return "HiAd-3.4.78.301";
    }

    public static boolean d() {
        return f7166a.a(6);
    }

    public static void d(String str, String str2, Object... objArr) {
        if (!d() || str2 == null) {
            return;
        }
        d(str, a(str2, objArr));
    }

    public static void d(String str, String str2) {
        f7166a.b(6, str, str2);
    }

    public static boolean c() {
        return f7166a.a(5);
    }

    public static void c(String str, String str2, Object... objArr) {
        if (!c() || str2 == null) {
            return;
        }
        c(str, a(str2, objArr));
    }

    public static void c(String str, String str2) {
        f7166a.b(5, str, str2);
    }

    public static boolean b() {
        return f7166a.a(4);
    }

    public static void b(String str, String str2, Object... objArr) {
        if (!b() || str2 == null) {
            return;
        }
        b(str, a(str2, objArr));
    }

    public static void b(String str, String str2) {
        f7166a.b(4, str, str2);
    }

    public static boolean a() {
        return f7166a.a(3);
    }

    public static void a(String str, String str2, Object... objArr) {
        if (!a() || str2 == null) {
            return;
        }
        a(str, a(str2, objArr));
    }

    public static void a(String str, String str2) {
        f7166a.b(3, str, str2);
    }

    public static void a(Integer num) {
        f7166a.a(num);
    }

    public static void a(int i, Throwable th) {
        f7166a.a(i, "", th);
    }

    public static void a(int i, String str, Throwable th) {
        f7166a.a(i, str, th);
    }

    public static void a(int i, String str, String str2, Throwable th) {
        f7166a.a(i, str, str2, th);
    }

    public static void a(int i, String str, String str2) {
        f7166a.a(i, str, str2);
        f7166a.a(str2, "\n============================================================================\n====== " + e() + "\n====== Brand: " + Build.BRAND + " Model: " + Build.MODEL + " Release: " + Build.VERSION.RELEASE + " API: " + Build.VERSION.SDK_INT + "\n============================================================================");
    }

    private static String a(String str, Object[] objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Throwable unused) {
            return str;
        }
    }
}
