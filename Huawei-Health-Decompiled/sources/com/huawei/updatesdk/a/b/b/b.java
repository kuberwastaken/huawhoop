package com.huawei.updatesdk.a.b.b;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f11318a;

    public boolean d() {
        return this.f11318a != null;
    }

    public Intent c() {
        return this.f11318a;
    }

    public Bundle b() {
        if (d()) {
            return this.f11318a.getExtras();
        }
        return null;
    }

    public long b(String str, int i) {
        if (d()) {
            try {
                return this.f11318a.getLongExtra(str, i);
            } catch (Throwable unused) {
                com.huawei.updatesdk.a.a.a.a("SecureIntent", "getIntExtra exception!");
            }
        }
        return i;
    }

    public boolean a(String str, boolean z) {
        if (d()) {
            try {
                return this.f11318a.getBooleanExtra(str, z);
            } catch (Throwable unused) {
                com.huawei.updatesdk.a.a.a.a("SecureIntent", "getBooleanExtra exception!");
            }
        }
        return z;
    }

    public String a(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.f11318a.getStringExtra(str);
        } catch (Throwable unused) {
            com.huawei.updatesdk.a.a.a.a("SecureIntent", "getStringExtra exception!");
            return "";
        }
    }

    public String a() {
        String action;
        return (!d() || (action = this.f11318a.getAction()) == null) ? "" : action;
    }

    public int a(String str, int i) {
        if (d()) {
            try {
                return this.f11318a.getIntExtra(str, i);
            } catch (Throwable unused) {
                com.huawei.updatesdk.a.a.a.a("SecureIntent", "getIntExtra exception!");
            }
        }
        return i;
    }

    public static b a(Intent intent) {
        return new b(intent);
    }

    private b(Intent intent) {
        this.f11318a = intent;
    }
}
