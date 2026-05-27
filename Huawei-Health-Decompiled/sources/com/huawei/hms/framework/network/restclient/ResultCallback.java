package com.huawei.hms.framework.network.restclient;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface ResultCallback<T> {
    void onFailure(Throwable th);

    void onResponse(Response<T> response);
}
