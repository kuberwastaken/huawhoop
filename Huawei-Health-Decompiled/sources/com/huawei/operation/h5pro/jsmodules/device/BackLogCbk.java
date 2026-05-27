package com.huawei.operation.h5pro.jsmodules.device;

import com.huawei.health.h5pro.service.anotation.H5ProCallback;

/* JADX INFO: loaded from: classes.dex */
@H5ProCallback
public interface BackLogCbk<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
