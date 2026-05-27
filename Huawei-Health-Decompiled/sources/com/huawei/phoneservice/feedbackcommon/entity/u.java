package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class u implements Serializable {
    private static final long serialVersionUID = -4589818087876763047L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("emuiLanguageCode")
    private String f8621a;

    @SerializedName("countryCode")
    private String b;

    @SerializedName("languageCode")
    private String c;

    @SerializedName("problemSourceCode")
    private String d;

    public u(String str, String str2, String str3, String str4) {
        this.d = str;
        this.b = str2;
        this.c = str3;
        this.f8621a = str4;
    }
}
