package com.huawei.hihealth.dictionary.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class HiHealthDictMergeMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("sourceInternalMergePolicy")
    private String f4291a;

    @SerializedName("compareKey")
    private String b;

    @SerializedName("dataSourcePriority")
    private int[] c;

    @SerializedName("mergePolicy")
    private String d;

    @SerializedName("categoryPriority")
    private String[] e;

    public String a() {
        return this.d;
    }

    public int[] c() {
        return (int[]) this.c.clone();
    }

    public String[] d() {
        return (String[]) this.e.clone();
    }

    public String e() {
        return this.b;
    }

    public String b() {
        return this.f4291a;
    }
}
