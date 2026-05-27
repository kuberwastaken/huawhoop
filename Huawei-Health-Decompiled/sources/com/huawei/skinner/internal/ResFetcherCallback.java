package com.huawei.skinner.internal;

/* JADX INFO: loaded from: classes11.dex */
public interface ResFetcherCallback<Q, T> {
    void onFailed(Q q, T t);

    void onStart(Q q);

    void onSuccess(T t);
}
