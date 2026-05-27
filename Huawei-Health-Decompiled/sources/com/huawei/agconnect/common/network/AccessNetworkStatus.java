package com.huawei.agconnect.common.network;

import com.huawei.agconnect.datastore.annotation.SharedPreference;

/* JADX INFO: loaded from: classes10.dex */
public class AccessNetworkStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AccessNetworkStatus f1748a = new AccessNetworkStatus();

    @SharedPreference(fileName = "AGConnectAccessNetwork", key = "enableAccessNetwork")
    boolean enableAccessNetwork = false;

    public boolean a() {
        AccessNetworkStatusPreference.b().a(f1748a);
        return this.enableAccessNetwork;
    }

    public void a(boolean z) {
        this.enableAccessNetwork = z;
        AccessNetworkStatusPreference.b().d(f1748a);
    }

    public static AccessNetworkStatus b() {
        return f1748a;
    }

    private AccessNetworkStatus() {
    }
}
