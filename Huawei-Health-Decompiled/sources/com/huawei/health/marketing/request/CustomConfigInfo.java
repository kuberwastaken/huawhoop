package com.huawei.health.marketing.request;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class CustomConfigInfo {

    @SerializedName("MarketingFunctionMenu")
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
