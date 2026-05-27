package com.huawei.devicesdk.connect.retry;

/* JADX INFO: loaded from: classes3.dex */
public interface RetryCallbackInterface {
    void doFailureAction();

    void doRetryAction(int i);

    void doSuccessAction();
}
