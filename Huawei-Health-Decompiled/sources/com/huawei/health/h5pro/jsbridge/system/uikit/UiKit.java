package com.huawei.health.h5pro.jsbridge.system.uikit;

/* JADX INFO: loaded from: classes4.dex */
public interface UiKit {
    void pickData(String[] strArr, DataCallback dataCallback);

    void pickDate(DateCallback dateCallback);

    void pickTime(TimeCallback timeCallback);
}
