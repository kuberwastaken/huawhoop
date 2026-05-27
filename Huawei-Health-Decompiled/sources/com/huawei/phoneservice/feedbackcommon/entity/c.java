package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("uploadUrl")
    private String f8608a;

    @SerializedName("method")
    private String b;

    @SerializedName("objectId")
    private String c;

    @SerializedName("headers")
    private Map<String, String> e;

    public String toString() {
        return "UploadInfoList{uploadUrl='" + this.f8608a + "', method='" + this.b + "', headers=" + this.e + ", objectId='" + this.c + "'}";
    }

    public String d() {
        return this.f8608a;
    }

    public String c() {
        return this.b;
    }

    public Map<String, String> a() {
        return this.e;
    }
}
