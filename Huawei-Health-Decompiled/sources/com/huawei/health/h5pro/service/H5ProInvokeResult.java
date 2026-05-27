package com.huawei.health.h5pro.service;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class H5ProInvokeResult {

    @SerializedName("result")
    public Object e;

    public Object getResult() {
        return this.e;
    }

    public H5ProInvokeResult(Object obj) {
        this.e = obj;
    }
}
