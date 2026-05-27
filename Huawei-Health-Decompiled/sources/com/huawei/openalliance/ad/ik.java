package com.huawei.openalliance.ad;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ik extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Proxy> f7193a = Collections.singletonList(Proxy.NO_PROXY);
    private final ProxySelector b;
    private final String c;
    private final int d;

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.c.equals(uri.getHost()) && this.d == uri.getPort()) ? f7193a : this.b.select(uri);
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new ik(ProxySelector.getDefault(), str, i));
    }

    private ik(ProxySelector proxySelector, String str, int i) {
        if (proxySelector == null || str == null) {
            throw null;
        }
        this.b = proxySelector;
        this.c = str;
        this.d = i;
    }
}
