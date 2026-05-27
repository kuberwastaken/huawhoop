package com.huawei.hmf.orb.aidl.client.impl;

import com.huawei.hmf.orb.aidl.client.Result;

/* JADX INFO: loaded from: classes10.dex */
public class ResolveResult<T> extends Result {
    private T entity;

    public ResolveResult() {
        this.entity = null;
    }

    public ResolveResult(T t) {
        this.entity = t;
    }

    public T getValue() {
        return this.entity;
    }
}
