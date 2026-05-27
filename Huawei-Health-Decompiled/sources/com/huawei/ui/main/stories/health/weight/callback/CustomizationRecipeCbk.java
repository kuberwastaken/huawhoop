package com.huawei.ui.main.stories.health.weight.callback;

import com.huawei.health.h5pro.service.anotation.H5ProCallback;

/* JADX INFO: loaded from: classes.dex */
@H5ProCallback
public interface CustomizationRecipeCbk<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
