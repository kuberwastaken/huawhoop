package com.huawei.health.h5pro.jsbridge.system.share;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes10.dex */
public class ShareLinkObj extends ShareObj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("iconUrl")
    public String f2466a;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String b;

    @SerializedName("title")
    public String c;

    @SerializedName("url")
    public String e;

    public void setUrl(String str) {
        this.e = str;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public void setIconUrl(String str) {
        this.f2466a = str;
    }

    public void setDesc(String str) {
        this.b = str;
    }

    public String getUrl() {
        return this.e;
    }

    public String getTitle() {
        return this.c;
    }

    public String getIconUrl() {
        return this.f2466a;
    }

    public String getDesc() {
        return this.b;
    }
}
