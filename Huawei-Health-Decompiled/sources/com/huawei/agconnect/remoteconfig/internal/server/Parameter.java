package com.huawei.agconnect.remoteconfig.internal.server;

import com.huawei.agconnect.https.annotation.Result;

/* JADX INFO: loaded from: classes3.dex */
public class Parameter {

    @Result("name")
    private String key;

    @Result("value")
    private String value;

    public void setValue(String str) {
        this.value = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public String getKey() {
        return this.key;
    }
}
