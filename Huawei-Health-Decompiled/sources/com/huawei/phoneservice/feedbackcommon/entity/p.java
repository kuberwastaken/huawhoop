package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("fileUniqueFlag")
    private String f8617a;

    @SerializedName("currentTime")
    private String b;

    @SerializedName("resCode")
    private int c;

    @SerializedName("uploadInfoList")
    private List<c> d;

    @SerializedName("reason")
    private String e;

    @SerializedName("policy")
    private String h;

    @SerializedName("patchPolicyList")
    private g j;

    public String toString() {
        return "UploadInfoResponse{reason='" + this.e + "', resCode=" + this.c + ", fileUniqueFlag='" + this.f8617a + "', currentTime='" + this.b + "', uploadInfoList=" + this.d + ", policy='" + this.h + "', patchPolicyList=" + this.j + '}';
    }

    public List<c> e() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public String a() {
        return this.e;
    }

    public String d() {
        return this.f8617a;
    }
}
