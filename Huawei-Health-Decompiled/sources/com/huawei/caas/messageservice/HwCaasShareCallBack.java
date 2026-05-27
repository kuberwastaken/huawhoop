package com.huawei.caas.messageservice;

import com.huawei.caas.messageservice.HwShareUtils;

/* JADX INFO: loaded from: classes10.dex */
public interface HwCaasShareCallBack {
    void initFail(int i);

    void initSuccess(HwCaasShareHandler hwCaasShareHandler);

    void releaseSuccess();

    void sendResult(HwShareUtils.SendResultEnum sendResultEnum);
}
