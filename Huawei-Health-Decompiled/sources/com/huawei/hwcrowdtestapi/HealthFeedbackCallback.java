package com.huawei.hwcrowdtestapi;

import defpackage.krm;

/* JADX INFO: loaded from: classes5.dex */
public interface HealthFeedbackCallback {
    krm collectLogs(int i, String str, String str2, boolean z);

    void onFailed(String str);
}
