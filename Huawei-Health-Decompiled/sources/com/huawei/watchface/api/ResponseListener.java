package com.huawei.watchface.api;

/* JADX INFO: loaded from: classes8.dex */
public interface ResponseListener<T> {
    void onError();

    void onResponse(T t);
}
