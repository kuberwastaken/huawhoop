package com.huawei.health.deviceconnect.callback;

/* JADX INFO: loaded from: classes4.dex */
public interface SendCallback {
    void onFileTransferReport(String str);

    void onSendProgress(long j);

    void onSendResult(int i);
}
