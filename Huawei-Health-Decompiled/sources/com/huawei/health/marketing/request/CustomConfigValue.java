package com.huawei.health.marketing.request;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class CustomConfigValue {

    @SerializedName("favoriteTime")
    private long favoriteTime;

    @SerializedName("id")
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public long getFavoriteTime() {
        return this.favoriteTime;
    }

    public void setFavoriteTime(long j) {
        this.favoriteTime = j;
    }
}
