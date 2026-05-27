package com.huawei.hms.hmsscankit;

import android.util.Log;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;

/* JADX INFO: loaded from: classes5.dex */
class c extends IOnErrorCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnErrorCallback f4819a;

    c(OnErrorCallback onErrorCallback) {
        this.f4819a = onErrorCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnErrorCallback
    public void onError(int i) {
        if (this.f4819a != null) {
            Log.i("OnErrorCallbackDelegate", "onError: ErrorCode：" + i);
            this.f4819a.onError(i);
        }
    }
}
