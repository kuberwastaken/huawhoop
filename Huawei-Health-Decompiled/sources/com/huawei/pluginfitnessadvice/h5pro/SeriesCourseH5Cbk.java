package com.huawei.pluginfitnessadvice.h5pro;

import com.huawei.health.h5pro.service.anotation.H5ProCallback;

/* JADX INFO: loaded from: classes.dex */
@H5ProCallback
public interface SeriesCourseH5Cbk<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
