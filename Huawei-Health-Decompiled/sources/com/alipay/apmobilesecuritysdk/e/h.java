package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import defpackage.kn;
import defpackage.ks;
import defpackage.lk;
import defpackage.ll;
import java.util.UUID;

/* JADX INFO: loaded from: classes9.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f763a = "";

    private static String i(Context context, String str) {
        return ll.a(context, "vkeyid_settings", str);
    }

    public static long h(Context context, String str) {
        try {
            String strA = ll.a(context, "vkeyid_settings", "vkey_valid" + str);
            if (kn.a(strA)) {
                return 0L;
            }
            return Long.parseLong(strA);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void g(Context context, String str) {
        a(context, "apse_degrade", str);
    }

    public static void f(Context context, String str) {
        a(context, "webrtc_url", str);
    }

    public static String f(Context context) {
        String str;
        synchronized (h.class) {
            if (kn.a(f763a)) {
                String strC = lk.c(context, "alipay_vkey_random", "random", "");
                f763a = strC;
                if (kn.a(strC)) {
                    String strA = ks.a(UUID.randomUUID().toString());
                    f763a = strA;
                    lk.d(context, "alipay_vkey_random", "random", strA);
                }
            }
            str = f763a;
        }
        return str;
    }

    public static void e(Context context, String str) {
        a(context, "dynamic_key", str);
    }

    public static String e(Context context) {
        return i(context, "apse_degrade");
    }

    public static void d(Context context, String str) {
        a(context, "agent_switch", str);
    }

    public static String d(Context context) {
        return i(context, "dynamic_key");
    }

    public static boolean c(Context context) {
        String strI = i(context, "log_switch");
        return strI != null && "1".equals(strI);
    }

    public static void c(Context context, String str) {
        a(context, "last_apdid_env", str);
    }

    public static void b(Context context, String str) {
        a(context, "last_machine_boot_time", str);
    }

    public static String b(Context context) {
        return i(context, "last_apdid_env");
    }

    public static void a(Context context, boolean z) {
        a(context, "log_switch", z ? "1" : "0");
    }

    private static void a(Context context, String str, String str2) {
        ll.b(context, "vkeyid_settings", str, str2);
    }

    public static void a(Context context, String str, long j) {
        ll.b(context, "vkeyid_settings", "vkey_valid" + str, j + "");
    }

    public static void a(Context context, String str) {
        a(context, "update_time_interval", str);
    }

    public static long a(Context context) {
        String strI = i(context, "update_time_interval");
        if (kn.b(strI)) {
            try {
                return Long.parseLong(strI);
            } catch (Exception unused) {
            }
        }
        return 86400000L;
    }
}
