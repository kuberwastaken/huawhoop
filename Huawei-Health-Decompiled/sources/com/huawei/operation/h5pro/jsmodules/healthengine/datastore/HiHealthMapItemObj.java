package com.huawei.operation.h5pro.jsmodules.healthengine.datastore;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
class HiHealthMapItemObj {

    @SerializedName("type")
    private int type = 0;

    @SerializedName("value")
    private Object value = 0L;

    HiHealthMapItemObj() {
    }

    public int getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }
}
