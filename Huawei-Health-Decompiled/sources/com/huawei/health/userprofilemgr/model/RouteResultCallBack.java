package com.huawei.health.userprofilemgr.model;

/* JADX INFO: loaded from: classes5.dex */
public interface RouteResultCallBack<T> {
    void onFailure(Throwable th);

    void onSuccess(T t);
}
