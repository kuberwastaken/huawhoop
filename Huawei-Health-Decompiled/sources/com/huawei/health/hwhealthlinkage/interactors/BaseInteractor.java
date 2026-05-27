package com.huawei.health.hwhealthlinkage.interactors;

import com.huawei.hwbasemgr.IHeartRateCallback;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseInteractor {
    protected IHeartRateCallback mStatusCallback;

    public abstract void registerStatusListener();

    public abstract void start();

    public abstract void stop();

    public void unRegisterStatusListener() {
        this.mStatusCallback = null;
    }
}
