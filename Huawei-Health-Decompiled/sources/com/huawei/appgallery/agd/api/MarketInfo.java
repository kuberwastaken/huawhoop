package com.huawei.appgallery.agd.api;

/* JADX INFO: loaded from: classes10.dex */
public class MarketInfo {
    public int versionCode;
    public String versionName;

    public String toString() {
        return "MarketInfo{, versionCode=" + this.versionCode + ", versionName='" + this.versionName + "'}";
    }

    public MarketInfo(String str, int i) {
        this.versionName = str;
        this.versionCode = i;
    }
}
