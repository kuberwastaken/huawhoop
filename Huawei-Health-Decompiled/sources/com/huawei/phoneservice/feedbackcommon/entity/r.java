package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;

/* JADX INFO: loaded from: classes6.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("orderType")
    private int f8618a;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private int b;

    @SerializedName("problemId")
    private String c;

    @SerializedName("accessToken")
    private String d;

    @SerializedName("problemSourceCode")
    private String e;

    public void e(int i) {
        this.b = i;
    }

    public void b(int i) {
        this.f8618a = i;
    }

    public r(String str, String str2, String str3) {
        this.d = str;
        this.e = str2;
        this.c = str3;
    }
}
