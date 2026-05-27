package com.huawei.networkclient;

/* JADX INFO: loaded from: classes6.dex */
public interface ResultCallback<T> {
    void onFailure(Throwable th);

    void onSuccess(T t);
}
