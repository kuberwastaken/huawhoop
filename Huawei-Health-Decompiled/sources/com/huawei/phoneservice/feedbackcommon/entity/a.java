package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("accessToken")
    private String f8605a;

    @SerializedName("problemIdList")
    private List<String> b;

    @SerializedName("appId")
    private String e;

    public void e(String str) {
        this.e = str;
    }

    public void d(List<String> list) {
        this.b = list;
    }

    public void d(String str) {
        this.f8605a = str;
    }
}
