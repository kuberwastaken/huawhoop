package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class f implements Serializable {
    private static final long serialVersionUID = -8764490769713094093L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("responseDesc")
    private String f8611a;

    @SerializedName("responseData")
    private p b;

    @SerializedName("responseCode")
    private String e;

    public p c() {
        return this.b;
    }

    public String e() {
        return this.e;
    }
}
