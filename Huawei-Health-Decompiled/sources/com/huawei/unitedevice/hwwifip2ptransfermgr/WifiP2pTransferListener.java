package com.huawei.unitedevice.hwwifip2ptransfermgr;

/* JADX INFO: loaded from: classes8.dex */
public interface WifiP2pTransferListener {
    void onFail(int i, String str, int i2);

    void onProcess(int i, int i2);

    void onSuccess(int i, String str, int i2);
}
