package com.huawei.hwdevice.mainprocess.mgr.hwwatchfacemgr.touchtransfer.initese.oma;

/* JADX INFO: loaded from: classes6.dex */
public interface SmartCardCallback {
    void onOperatorFailure(int i, Error error);

    void onOperatorSuccess(int i, String str);
}
