package com.huawei.health.device.callback;

/* JADX INFO: loaded from: classes4.dex */
public interface BackLogCallback<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
