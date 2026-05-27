package com.huawei.openalliance.ad;

import com.huawei.openalliance.ad.inter.listeners.IPPSWebEventCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class nn implements IPPSWebEventCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, IPPSWebEventCallback> f7578a;

    @Override // com.huawei.openalliance.ad.inter.listeners.IPPSWebEventCallback
    public void onWebloadFinish() {
        for (IPPSWebEventCallback iPPSWebEventCallback : this.f7578a.values()) {
            if (iPPSWebEventCallback != null) {
                iPPSWebEventCallback.onWebloadFinish();
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IPPSWebEventCallback
    public void onWebOpen() {
        for (IPPSWebEventCallback iPPSWebEventCallback : this.f7578a.values()) {
            if (iPPSWebEventCallback != null) {
                iPPSWebEventCallback.onWebOpen();
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IPPSWebEventCallback
    public void onWebClose(int i) {
        for (IPPSWebEventCallback iPPSWebEventCallback : this.f7578a.values()) {
            if (iPPSWebEventCallback != null) {
                iPPSWebEventCallback.onWebClose(i);
            }
        }
    }

    public void b(IPPSWebEventCallback iPPSWebEventCallback) {
        if (iPPSWebEventCallback == null) {
            this.f7578a.remove("jsb_listener_key");
        } else {
            this.f7578a.put("jsb_listener_key", iPPSWebEventCallback);
        }
    }

    public void a(IPPSWebEventCallback iPPSWebEventCallback) {
        if (iPPSWebEventCallback == null) {
            this.f7578a.remove("outer_listener_key");
        } else {
            this.f7578a.put("outer_listener_key", iPPSWebEventCallback);
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final nn f7579a = new nn();
    }

    public static nn a() {
        return a.f7579a;
    }

    private nn() {
        this.f7578a = new ConcurrentHashMap();
    }
}
