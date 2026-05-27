package com.huawei.health.devicemgr.business.entity.downloadresouce;

/* JADX INFO: loaded from: classes4.dex */
public interface DownloadDeviceInfoCallBack {
    void netWorkError();

    void onDownload(int i);

    void onFailure(int i);

    void onSuccess();
}
