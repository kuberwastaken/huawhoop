package com.huawei.pluginachievement.manager.model;

/* JADX INFO: loaded from: classes7.dex */
public class MultiLanguageRes {
    private String url;
    private String version;

    public MultiLanguageRes(String str, String str2) {
        this.version = str;
        this.url = str2;
    }

    public String getVersion() {
        return this.version;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "MultiLanguageRes{version=" + this.version + ", url=" + this.url + '}';
    }
}
