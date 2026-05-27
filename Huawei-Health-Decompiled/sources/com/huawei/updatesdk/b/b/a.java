package com.huawei.updatesdk.b.b;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    private static final Object e = new Object();
    private static volatile a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f11331a;
    private String b;
    private String c;
    private boolean d = false;

    public void d(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void c() {
        if (this.d) {
            return;
        }
        b("updatesdk.sign.param");
        b("updatesdk.signkey");
        b("updatesdk.signtime");
        b("updatesdk.lastInitAccountTime" + this.c);
        b("updatesdk.lastAccountZone" + this.c);
        this.d = true;
    }

    public void b(String str) {
        this.f11331a.a(str);
    }

    public long b() {
        return this.f11331a.a("updatesdk.lastCheckDate", 0L);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11331a.b(str, str2);
    }

    public void a(long j) {
        this.f11331a.b("updatesdk.lastCheckDate", j);
    }

    public String a(String str) {
        return TextUtils.isEmpty(str) ? "" : this.f11331a.a(str, "");
    }

    public String a() {
        return this.b;
    }

    public static a d() {
        if (f == null) {
            synchronized (e) {
                if (f == null) {
                    f = new a(com.huawei.updatesdk.a.b.a.a.c().a());
                }
            }
        }
        return f;
    }

    private a(Context context) {
        this.f11331a = b.a("DeviceSessionUpdateSDK_V1", context);
    }
}
