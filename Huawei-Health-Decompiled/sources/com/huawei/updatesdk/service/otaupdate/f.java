package com.huawei.updatesdk.service.otaupdate;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public class f {
    private static f d = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11381a;
    private String b;
    private String c;

    public boolean d() {
        String str = this.f11381a;
        if (str != null) {
            return str.equals(this.b);
        }
        return true;
    }

    public void c(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.f11381a = str;
    }

    public String b() {
        return this.f11381a;
    }

    public void a(String str) {
        this.b = str;
    }

    public String a() {
        return !TextUtils.isEmpty(this.f11381a) ? this.f11381a : this.b;
    }

    public static f e() {
        return d;
    }

    private f() {
    }
}
