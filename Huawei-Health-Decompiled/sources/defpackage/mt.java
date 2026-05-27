package defpackage;

import com.alipay.sdk.m.l.c;

/* JADX INFO: loaded from: classes9.dex */
public class mt {
    public static String b = null;
    public static boolean d = false;

    public static String a() {
        return b;
    }

    public static void b(String str) {
        b = str;
    }

    public static String c() {
        c cVarA = c.a(c.PARAMS_ERROR.b());
        return e(cVarA.b(), cVarA.a(), "");
    }

    public static boolean d() {
        return d;
    }

    public static String e() {
        c cVarA = c.a(c.DOUBLE_REQUEST.b());
        return e(cVarA.b(), cVarA.a(), "");
    }

    public static void a(boolean z) {
        d = z;
    }

    public static String b() {
        c cVarA = c.a(c.CANCELED.b());
        return e(cVarA.b(), cVarA.a(), "");
    }

    public static String e(int i, String str, String str2) {
        return "resultStatus={" + i + "};memo={" + str + "};result={" + str2 + "}";
    }
}
