package com.huawei.openalliance.ad;

import com.huawei.openalliance.ad.db.bean.ContentRecord;

/* JADX INFO: loaded from: classes6.dex */
public class uc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7807a;
    private String b;
    private String c;
    private Integer d;
    private String e;
    private ContentRecord f;

    public ContentRecord f() {
        return this.f;
    }

    public int e() {
        return this.d.intValue();
    }

    public String d() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String b() {
        return this.f7807a;
    }

    public void a(String str) {
        if (str == null) {
            str = "";
        }
        this.c = str;
    }

    public void a(ContentRecord contentRecord) {
        this.f = contentRecord;
    }

    public void a(int i) {
        this.d = Integer.valueOf(i);
    }

    public String a() {
        return this.c;
    }

    public uc(String str, String str2, String str3, String str4) {
        this.f7807a = str == null ? "" : str;
        this.b = str2 == null ? "" : str2;
        this.c = str3 == null ? "" : str3;
        this.e = str4 == null ? "" : str4;
    }

    public uc() {
    }
}
