package com.huawei.health.h5pro.jsbridge.system.option;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class LightAppStartObj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mapJson")
    public String f2458a;

    @SerializedName("url")
    public String d;

    @SerializedName("launchOption")
    public String e;

    public void setUrl(String str) {
        this.d = str;
    }

    public void setMapJson(String str) {
        this.f2458a = str;
    }

    public void setLaunchOption(String str) {
        this.e = str;
    }

    public String getUrl() {
        return this.d;
    }

    public String getMapJson() {
        return this.f2458a;
    }

    public String getLaunchOption() {
        return this.e;
    }
}
