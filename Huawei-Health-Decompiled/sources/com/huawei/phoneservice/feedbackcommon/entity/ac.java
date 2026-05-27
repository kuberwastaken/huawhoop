package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ac implements Serializable {
    private static final long serialVersionUID = -8045680007893341280L;

    @SerializedName("fileMd5")
    private String b = "";

    @SerializedName("fileSize")
    private long c;

    @SerializedName("fileSha256")
    private String d;

    public void b(String str) {
        this.d = str;
    }

    public void a(long j) {
        this.c = j;
    }
}
