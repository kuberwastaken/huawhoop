package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class k implements Serializable {
    private static final long serialVersionUID = -8764490769713094093L;

    @SerializedName("responseCode")
    private String b;

    @SerializedName("responseData")
    private w d;

    @SerializedName("responseDesc")
    private String e;

    public String a() {
        return this.e;
    }

    public w d() {
        return this.d;
    }

    public String c() {
        return this.b;
    }
}
