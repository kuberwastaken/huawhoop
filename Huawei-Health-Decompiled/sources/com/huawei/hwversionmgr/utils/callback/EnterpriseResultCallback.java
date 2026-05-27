package com.huawei.hwversionmgr.utils.callback;

import com.huawei.hwversionmgr.info.EnterpriseResponseInfo;

/* JADX INFO: loaded from: classes6.dex */
public interface EnterpriseResultCallback {
    void onFailure(Throwable th);

    void onSuccess(EnterpriseResponseInfo enterpriseResponseInfo);
}
