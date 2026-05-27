package com.huawei.health.h5pro.jsbridge.system.share;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class ShareImageObj extends ShareObj {

    @SerializedName("uri")
    public String e = "";

    @SerializedName("isReport")
    public boolean c = false;
    public String d = "";

    public void setUri(String str) {
        this.e = str;
    }

    public void setIsReport(boolean z) {
        this.c = z;
    }

    public void setFilePath(String str) {
        this.d = str;
    }

    public boolean isReport() {
        return this.c;
    }

    public String getUri() {
        return this.e;
    }

    public String getFilePath() {
        return this.d;
    }
}
