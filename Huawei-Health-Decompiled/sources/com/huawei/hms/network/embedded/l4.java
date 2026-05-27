package com.huawei.hms.network.embedded;

import com.huawei.hms.network.inner.api.NetworkReceiver;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class l4 {
    public static final l4 b = new l4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<NetworkReceiver> f5545a = new CopyOnWriteArrayList();

    public void b(NetworkReceiver networkReceiver) {
        if (networkReceiver != null) {
            this.f5545a.remove(networkReceiver);
        }
    }

    public void a(NetworkReceiver networkReceiver) {
        if (networkReceiver != null) {
            this.f5545a.add(networkReceiver);
        }
    }

    public List<NetworkReceiver> a() {
        return this.f5545a;
    }

    public static l4 b() {
        return b;
    }
}
