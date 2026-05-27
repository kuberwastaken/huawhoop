package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("currentTime")
    private String f8613a;

    @SerializedName("resCode")
    private int b;

    @SerializedName("uploadInfoList")
    private List<c> c;

    @SerializedName("reason")
    private String d;

    @SerializedName("fileUniqueFlag")
    private String e;

    @SerializedName("policy")
    private String i;

    @SerializedName("patchPolicyList")
    private g j;

    public String toString() {
        return "UploadInfoResponse{reason='" + this.d + "', resCode=" + this.b + ", fileUniqueFlag='" + this.e + "', currentTime='" + this.f8613a + "', uploadInfoList=" + this.c + ", policy='" + this.i + "', patchPolicyList=" + this.j + '}';
    }

    public List<c> c() {
        return this.c;
    }

    public int a() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public g d() {
        return this.j;
    }

    public String b() {
        return this.e;
    }
}
