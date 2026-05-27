package com.huawei.health.h5pro.jsbridge.system.prerequest;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.network.file.core.util.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class PreResult<T> {

    @SerializedName("data")
    public T b;

    @SerializedName(Utils.REQUEST_TIME)
    public long d;

    public void setRequestTime(long j) {
        this.d = j;
    }

    public void setData(T t) {
        this.b = t;
    }

    public long getRequestTime() {
        return this.d;
    }

    public T getData() {
        return this.b;
    }

    public PreResult(long j, T t) {
        this.d = j;
        this.b = t;
    }

    public PreResult() {
    }
}
