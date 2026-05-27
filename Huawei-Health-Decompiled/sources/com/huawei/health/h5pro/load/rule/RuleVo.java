package com.huawei.health.h5pro.load.rule;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class RuleVo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("columns")
    public String[] f2489a;

    @SerializedName("rule")
    public String c;

    public void setRule(String str) {
        this.c = str;
    }

    public void setColumns(String[] strArr) {
        this.f2489a = strArr;
    }

    public String getRule() {
        return this.c;
    }

    public String[] getColumns() {
        return this.f2489a;
    }
}
