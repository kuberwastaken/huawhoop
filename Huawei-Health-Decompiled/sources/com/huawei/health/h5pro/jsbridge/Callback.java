package com.huawei.health.h5pro.jsbridge;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Callback {
    public abstract void onFailure(int i, String str);

    public abstract void onSuccess(Object obj);

    public void onFailure(String str) {
        onFailure(ErrorEnum.DEFAULT_ERROR.getCode(), str);
    }

    public void onFailure(ErrorEnum errorEnum) {
        onFailure(errorEnum.getCode(), errorEnum.getMsg());
    }
}
