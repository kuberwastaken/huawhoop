package com.huawei.updatesdk.b.c;

import android.os.Build;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11334a;
    private String b;

    abstract String a();

    public abstract String b();

    abstract String c();

    public abstract List<String> f();

    public String e() {
        if (!TextUtils.isEmpty(this.f11334a)) {
            return this.f11334a;
        }
        String strA = a();
        this.f11334a = strA;
        if (TextUtils.isEmpty(strA) || TextUtils.equals(this.f11334a, "unknown")) {
            this.f11334a = Build.MODEL;
        }
        return this.f11334a;
    }

    public String d() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String strC = c();
        this.b = strC;
        if (TextUtils.isEmpty(strC)) {
            this.b = Build.MANUFACTURER;
        }
        return this.b;
    }
}
