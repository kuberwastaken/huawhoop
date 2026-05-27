package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("resCode")
    private int f8619a;

    @SerializedName("reason")
    private String c;

    @SerializedName("serverDomain")
    private String d;

    @SerializedName("accessToken")
    private String e;

    public String d() {
        return this.d;
    }

    public int c() {
        return this.f8619a;
    }

    public String a() {
        return this.c;
    }

    public String e() {
        return this.e;
    }
}
