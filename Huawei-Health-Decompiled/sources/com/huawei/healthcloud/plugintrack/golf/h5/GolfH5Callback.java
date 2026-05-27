package com.huawei.healthcloud.plugintrack.golf.h5;

import com.huawei.health.h5pro.service.anotation.H5ProCallback;

/* JADX INFO: loaded from: classes.dex */
@H5ProCallback
public interface GolfH5Callback<T> {
    void onFailure(int i, String str);

    void onProgress(T t);

    void onSuccess(T t);
}
