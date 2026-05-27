package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class ad {

    @SerializedName("problemId")
    public String b;

    @SerializedName("accessToken")
    public String e;

    public ad(String str, String str2) {
        this.e = str;
        this.b = str2;
    }
}
