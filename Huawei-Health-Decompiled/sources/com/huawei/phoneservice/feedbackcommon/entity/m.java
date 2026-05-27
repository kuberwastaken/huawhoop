package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class m implements Serializable {
    private static final long serialVersionUID = -8764490769713094093L;

    @SerializedName("responseCode")
    private String b;

    @SerializedName("responseData")
    private h c;

    @SerializedName("responseDesc")
    private String d;

    public h b() {
        return this.c;
    }

    public String e() {
        return this.b;
    }
}
