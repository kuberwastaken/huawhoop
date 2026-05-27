package com.huawei.hihealth.dictionary.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hihealth.dictionary.utils.DictUtils;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class HiHealthDictStat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("statPolicy")
    private String f4292a;

    @SerializedName("mergePolicy")
    private String b;

    @SerializedName("format")
    private String c;

    @SerializedName("statFieldName")
    private String d;

    @SerializedName("associateValue")
    private Double e;

    @SerializedName("statType")
    private int f;

    public void a(int i) {
        if (this.f == 0) {
            this.f = DictUtils.a(i, this.d);
        }
    }

    public boolean f() {
        if (!DictUtils.e(this.d)) {
            LogUtil.d("HiH_HiHealthDictStat", "statFieldName is illegal: ", this.d);
            return false;
        }
        if (HealthDataStatPolicy.validate(this.f4292a)) {
            return true;
        }
        LogUtil.d("HiH_HiHealthDictStat", "statPolicy is illegal: ", this.f4292a);
        return false;
    }

    public int c() {
        return this.f;
    }

    public String e() {
        return this.d;
    }

    public String d() {
        return this.c;
    }

    public String a() {
        return this.f4292a;
    }

    public Double b() {
        return this.e;
    }
}
