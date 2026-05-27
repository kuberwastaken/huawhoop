package com.huawei.hwdevice.mainprocess.mgr.hwwatchfacemgr.touchtransfer.initese.tsm.operator;

/* JADX INFO: loaded from: classes6.dex */
public interface TsmOperatorResponse {
    void onOperatorFailure(int i, Error error);

    void onOperatorSuccess(String str);
}
