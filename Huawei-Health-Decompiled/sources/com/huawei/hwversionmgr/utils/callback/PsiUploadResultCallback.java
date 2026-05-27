package com.huawei.hwversionmgr.utils.callback;

import com.huawei.hwversionmgr.info.PsiUploadResponseInfo;

/* JADX INFO: loaded from: classes6.dex */
public interface PsiUploadResultCallback {
    void onFailure(Throwable th);

    void onSuccess(PsiUploadResponseInfo psiUploadResponseInfo);
}
