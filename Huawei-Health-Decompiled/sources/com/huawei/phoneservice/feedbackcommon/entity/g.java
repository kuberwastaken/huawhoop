package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("patchVer")
    private String f8612a;

    @SerializedName("patchNum")
    private String c;

    @SerializedName("patchSize")
    private String d;

    public String toString() {
        return "UploadPatchPolicyList{patchVer='" + this.f8612a + "', patchNum='" + this.c + "', patchSize='" + this.d + "'}";
    }

    public String d() {
        return this.c;
    }
}
