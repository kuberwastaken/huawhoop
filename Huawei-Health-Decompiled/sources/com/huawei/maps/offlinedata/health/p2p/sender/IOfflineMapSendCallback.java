package com.huawei.maps.offlinedata.health.p2p.sender;

/* JADX INFO: loaded from: classes6.dex */
public interface IOfflineMapSendCallback {
    void onFileTransferReport(String str);

    void onSendProgress(long j);

    void onSendResult(int i);
}
