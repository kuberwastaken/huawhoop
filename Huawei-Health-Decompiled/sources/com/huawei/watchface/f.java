package com.huawei.watchface;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f11528a = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();

    public void a(String str, String str2) {
        du.c(this.f11528a, str, str2);
        du.c(this.b, str2, str);
    }

    public void a() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.f11528a;
        if (concurrentHashMap == null || this.b == null) {
            return;
        }
        concurrentHashMap.clear();
        this.b.clear();
    }

    public void a(String str) {
        du.b(this.b, du.a((Map<String, String>) this.f11528a, str));
        du.b(this.f11528a, str);
    }

    public void a(String str, String str2, String str3) {
        du.c(this.f11528a, str, str2);
        du.c(this.b, str2, str3);
    }

    public boolean b(String str) {
        return du.a((Map<?, ?>) this.f11528a, (Object) str);
    }

    public boolean c(String str) {
        return du.a((Map<?, ?>) this.b, (Object) str);
    }

    public String d(String str) {
        return du.a((Map<String, String>) this.f11528a, str);
    }

    public String e(String str) {
        return du.a((Map<String, String>) this.b, str);
    }
}
