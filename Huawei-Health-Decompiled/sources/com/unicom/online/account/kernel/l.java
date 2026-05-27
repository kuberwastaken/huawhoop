package com.unicom.online.account.kernel;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11953a = "l";
    private static int b;
    private static int c;

    private static String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(f11953a);
        sb.append((b + c) - 1);
        return sb.toString();
    }

    public static boolean a(Context context, String str) {
        boolean zA = false;
        if (c >= 20) {
            if (b > 2147483627) {
                m.d(context, "OAlog");
                b = 0;
                c = 0;
            } else {
                a(context, 0);
                b++;
            }
        }
        int i = c;
        if (i >= 0) {
            c = i + 1;
        } else {
            c = 0;
        }
        String strB = b();
        if (an.b(str).booleanValue()) {
            String strA = a(strB, strB);
            if (an.b(strA).booleanValue() && !(zA = m.a(context, strA, str))) {
                a();
            }
        }
        return zA;
    }

    public static void a(Context context, int i) {
        String strB = b();
        if (i == 0) {
            strB = f11953a + b;
        }
        m.c(context, a(strB, strB));
        a();
    }

    private static void a() {
        int i = c;
        c = i > 0 ? i - 1 : 0;
    }

    private static String a(String str, String str2) {
        return "OAlog" + str + str2;
    }

    public static String a(Context context) {
        if (c <= 0) {
            return null;
        }
        String strB = b();
        try {
            return m.a(context, a(strB, strB));
        } catch (Exception unused) {
            c = 0;
            return null;
        }
    }
}
