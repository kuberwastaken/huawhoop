package com.huawei.healthcloud.plugintrack.physicalfitness.h5;

import com.huawei.health.h5pro.service.anotation.H5ProCallback;

/* JADX INFO: loaded from: classes.dex */
@H5ProCallback
public interface PhysicalFitnessH5Callback<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
