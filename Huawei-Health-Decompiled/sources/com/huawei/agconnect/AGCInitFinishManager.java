package com.huawei.agconnect;

import com.huawei.agconnect.core.impl.AGCInitFinishManagerImpl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AGCInitFinishManager {
    private static final AGCInitFinishManager INSTANCE = new AGCInitFinishManagerImpl();

    public interface AGCInitFinishCallback {
        void onFinish();
    }

    public abstract void addAGCInitFinishCallback(AGCInitFinishCallback aGCInitFinishCallback);

    public static AGCInitFinishManager getInstance() {
        return INSTANCE;
    }
}
