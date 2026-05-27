package com.huawei.health.h5pro.dfx.bi;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AnalyzerObj {

    @SerializedName(JsbMapKeyNames.H5_CUSTOM_DATA)
    public Map<String, String> d;

    @SerializedName("id")
    public String e;

    public void setId(String str) {
        this.e = str;
    }

    public void setCustomData(Map<String, String> map) {
        this.d = map;
    }

    public String getId() {
        return this.e;
    }

    public Map<String, String> getCustomData() {
        return this.d;
    }
}
