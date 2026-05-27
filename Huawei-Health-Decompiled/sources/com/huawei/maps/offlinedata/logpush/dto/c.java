package com.huawei.maps.offlinedata.logpush.dto;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f6679a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    public JSONObject f() {
        return this.f6679a;
    }

    public String g() {
        return this.b;
    }

    public void c(String str) {
        a("", str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            this.b = str2;
            return;
        }
        this.b = str + " : " + str2;
    }

    public String h() {
        return this.c;
    }

    public String i() {
        return this.d;
    }

    public String j() {
        return this.e;
    }

    public String k() {
        return this.f;
    }

    public String l() {
        return this.g;
    }

    public String m() {
        return this.h;
    }

    public String n() {
        return this.i;
    }

    public String o() {
        return this.j;
    }

    public String p() {
        return this.k;
    }
}
