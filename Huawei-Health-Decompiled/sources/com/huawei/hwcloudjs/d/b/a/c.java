package com.huawei.hwcloudjs.d.b.a;

import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6409a;
    private int b = -1;

    public abstract void a(String str, Map<String, String> map);

    public int c() {
        return this.f6409a;
    }

    public void b(int i) {
        this.f6409a = i;
    }

    public int b() {
        return this.b;
    }

    public String[] a() {
        return new String[0];
    }

    public void a(int i) {
        this.b = i;
    }
}
