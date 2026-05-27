package com.huawei.agconnect.common.network;

/* JADX INFO: loaded from: classes.dex */
public abstract class AccessNetworkManager {
    private static final AccessNetworkManager INSTANCE = new AccessNetworkManagerImpl();

    public interface AccessNetworkCallback {
        void onNetWorkReady();
    }

    public abstract void addCallback(AccessNetworkCallback accessNetworkCallback);

    public abstract boolean canAccessNetwork();

    public abstract void setAccessNetwork(boolean z);

    public static AccessNetworkManager getInstance() {
        return INSTANCE;
    }
}
