package com.huawei.hms.aaid.plugin;

/* JADX INFO: loaded from: classes5.dex */
public class ProxyCenter {
    private PushProxy proxy;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ProxyCenter f4433a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return a.f4433a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
