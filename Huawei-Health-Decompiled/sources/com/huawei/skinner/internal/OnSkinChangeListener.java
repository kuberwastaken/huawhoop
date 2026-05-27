package com.huawei.skinner.internal;

/* JADX INFO: loaded from: classes11.dex */
public interface OnSkinChangeListener extends ILoaderListener2 {
    void onCompleted(int i);

    void onFailed(Throwable th, int i);

    void onStart(int i);
}
