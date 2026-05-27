package com.huawei.hwcrowdtestapi;

import android.content.Context;
import defpackage.krl;

/* JADX INFO: loaded from: classes5.dex */
public interface HealthCrowdTestApi {
    void checkLogUploadStatus(Context context);

    void gotoFeedback(Context context, krl krlVar, HealthFeedbackParams healthFeedbackParams, HealthFeedbackCallback healthFeedbackCallback);

    void init(Context context);

    void logout();

    void sendLog(Context context, HealthFeedbackParams healthFeedbackParams, String str, boolean z, boolean z2, HealthSendLogCallback healthSendLogCallback);

    void setProductType(int i);

    void uninit(Context context);
}
