package com.huawei.watchface.utils.callback;

/* JADX INFO: loaded from: classes8.dex */
public interface IFileTransferStateCallback {
    void onFileRespond(int i);

    void onFileTransferState(int i);

    void onUpgradeFailed(int i, String str);
}
