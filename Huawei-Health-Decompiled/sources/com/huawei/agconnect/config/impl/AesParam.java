package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class AesParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1790a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private int g;

    public boolean h() {
        return (TextUtils.isEmpty(this.f1790a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d) || this.f1790a.length() != this.b.length() || this.b.length() != this.c.length() || this.c.length() != this.g * 2 || this.f < 0 || TextUtils.isEmpty(this.e)) ? false : true;
    }

    public String g() {
        return this.d;
    }

    public int f() {
        return this.g;
    }

    public String e() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public String c() {
        return this.f1790a;
    }

    public int b() {
        return this.f;
    }

    public String a() {
        return this.e;
    }

    public AesParam(String str, String str2, String str3, String str4, String str5, int i) {
        this.g = 0;
        this.f1790a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i;
        if (str != null) {
            this.g = str.length() / 2;
        }
    }
}
