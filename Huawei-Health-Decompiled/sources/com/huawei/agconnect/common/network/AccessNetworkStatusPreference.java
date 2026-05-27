package com.huawei.agconnect.common.network;

import com.huawei.agconnect.datastore.annotation.DefaultCrypto;
import com.huawei.agconnect.datastore.core.CryptoUtil;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;

/* JADX INFO: loaded from: classes10.dex */
public class AccessNetworkStatusPreference {
    private static AccessNetworkStatusPreference c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPrefUtil f1749a = SharedPrefUtil.getInstance();
    private CryptoUtil b;

    public void d(AccessNetworkStatus accessNetworkStatus) {
        if (accessNetworkStatus != null) {
            this.f1749a.put("AGConnectAccessNetwork", "enableAccessNetwork", Boolean.class, Boolean.valueOf(accessNetworkStatus.enableAccessNetwork), DefaultCrypto.class);
        }
    }

    public void c(AccessNetworkStatus accessNetworkStatus) {
        d(accessNetworkStatus);
    }

    public void c() {
        this.f1749a.remove("AGConnectAccessNetwork", "enableAccessNetwork");
    }

    public void b(AccessNetworkStatus accessNetworkStatus) {
        a(accessNetworkStatus);
    }

    public void a(AccessNetworkStatus accessNetworkStatus) {
        if (accessNetworkStatus != null) {
            accessNetworkStatus.enableAccessNetwork = ((Boolean) this.f1749a.get("AGConnectAccessNetwork", "enableAccessNetwork", Boolean.class, Boolean.valueOf(accessNetworkStatus.enableAccessNetwork), DefaultCrypto.class)).booleanValue();
        }
    }

    public void a() {
        c();
    }

    public static AccessNetworkStatusPreference b() {
        AccessNetworkStatusPreference accessNetworkStatusPreference;
        synchronized (AccessNetworkStatusPreference.class) {
            if (c == null) {
                c = new AccessNetworkStatusPreference();
            }
            accessNetworkStatusPreference = c;
        }
        return accessNetworkStatusPreference;
    }

    private AccessNetworkStatusPreference() {
    }
}
