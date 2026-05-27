package com.huawei.hms.hihealth.result;

import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: classes10.dex */
public class aab<T extends Result> {
    private T mResult;

    public void setResult(T t) {
        this.mResult = t;
    }

    protected T getResult() {
        return this.mResult;
    }
}
