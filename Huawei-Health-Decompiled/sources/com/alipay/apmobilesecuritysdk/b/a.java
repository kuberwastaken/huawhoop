package com.alipay.apmobilesecuritysdk.b;

import defpackage.kn;
import defpackage.md;

/* JADX INFO: loaded from: classes9.dex */
public class a {
    private static a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f758a = 0;

    public String c() {
        String str;
        String strB = md.b();
        if (kn.b(strB)) {
            return strB;
        }
        int i = this.f758a;
        if (i == 1) {
            str = "://mobilegw.stable.alipay.net/mgw.htm";
        } else {
            if (i == 2) {
                return "https://mobilegwpre.alipay.com/mgw.htm";
            }
            if (i == 3) {
                str = "://mobilegw-1-64.test.alipay.net/mgw.htm";
            } else {
                if (i != 4) {
                    return "https://mobilegw.alipay.com/mgw.htm";
                }
                str = "://mobilegw.aaa.alipay.net/mgw.htm";
            }
        }
        return a("http", str);
    }

    public int b() {
        return this.f758a;
    }

    public void a(int i) {
        this.f758a = i;
    }

    private String a(String str, String str2) {
        return str + str2;
    }

    public static a a() {
        return b;
    }
}
