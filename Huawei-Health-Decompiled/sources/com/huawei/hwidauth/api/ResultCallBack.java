package com.huawei.hwidauth.api;

import com.huawei.hwidauth.api.Result;

/* JADX INFO: loaded from: classes.dex */
public interface ResultCallBack<R extends Result> {
    void onResult(R r);
}
