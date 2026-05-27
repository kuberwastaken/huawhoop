package com.huawei.openalliance.ad.views.interfaces;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8390a;
    private boolean b;
    private String c;
    private Integer d;
    private Integer e;

    public Integer e() {
        return this.e;
    }

    public Integer d() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public boolean b() {
        return this.b;
    }

    public boolean a() {
        return this.f8390a;
    }

    public void a(Integer num) {
        this.e = num;
    }

    public b(boolean z, boolean z2, String str, int i) {
        this(z, z2, str);
        this.d = Integer.valueOf(i);
    }

    public b(boolean z, boolean z2, String str) {
        this.e = 0;
        this.f8390a = z;
        this.b = z2;
        this.c = str;
    }
}
