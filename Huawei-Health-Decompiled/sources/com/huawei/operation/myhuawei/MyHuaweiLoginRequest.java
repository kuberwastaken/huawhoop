package com.huawei.operation.myhuawei;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class MyHuaweiLoginRequest {

    @SerializedName("accessToken")
    private String mAccessToken;

    @SerializedName("timeZone")
    private String mTimeZone;

    public void setTimeZone(String str) {
        this.mTimeZone = str;
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }
}
