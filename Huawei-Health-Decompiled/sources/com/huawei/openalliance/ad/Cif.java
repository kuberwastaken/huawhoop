package com.huawei.openalliance.ad;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: renamed from: com.huawei.openalliance.ad.if, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
public class Cif {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SSLSocketFactory f7190a;
    private static X509TrustManager b;

    public static X509TrustManager b() {
        return b;
    }

    public static SSLSocketFactory a() {
        return f7190a;
    }
}
