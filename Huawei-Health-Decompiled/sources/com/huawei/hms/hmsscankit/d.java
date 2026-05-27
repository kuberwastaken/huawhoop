package com.huawei.hms.hmsscankit;

import com.huawei.hms.hmsscankit.api.IOnLightCallback;

/* JADX INFO: loaded from: classes10.dex */
class d extends IOnLightCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnLightVisibleCallBack f4820a;

    d(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.f4820a = onLightVisibleCallBack;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnLightCallback
    public void onVisibleChanged(boolean z) {
        this.f4820a.onVisibleChanged(z);
    }
}
