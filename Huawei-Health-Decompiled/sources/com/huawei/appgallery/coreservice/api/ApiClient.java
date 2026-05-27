package com.huawei.appgallery.coreservice.api;

import android.content.Context;
import android.text.TextUtils;
import defpackage.ayz;
import defpackage.baa;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface ApiClient {

    public interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed(IConnectionResult iConnectionResult);

        void onConnectionSuspended(int i);
    }

    void connect();

    void disconnect();

    Context getContext();

    ApiClient getDelegate();

    boolean isConnected();

    boolean isConnecting();

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1898a;
        private ConnectConfig b;
        private final Set<ConnectionCallback> c = new HashSet();
        private String d;
        private final Context e;

        public Builder setVendorConnectInfo(ConnectConfig connectConfig) {
            if (connectConfig != null && !TextUtils.isEmpty(connectConfig.getConnectServiceAction()) && !TextUtils.isEmpty(connectConfig.getConnectAppPkg()) && !TextUtils.isEmpty(connectConfig.getInstallAppName()) && !TextUtils.isEmpty(connectConfig.getAppSignCertchain()) && !TextUtils.isEmpty(connectConfig.getAppFingerprintSignature())) {
                this.b = connectConfig.m382clone();
            }
            return this;
        }

        public Builder setHomeCountry(String str) {
            this.f1898a = str;
            return this;
        }

        @Deprecated
        public Builder setGrsAppName(String str) {
            this.d = str;
            return this;
        }

        public ApiClient build() {
            if (!TextUtils.isEmpty(this.d)) {
                baa.a().b(this.e, this.d);
            }
            if (!TextUtils.isEmpty(this.f1898a)) {
                baa.a().d(this.e, this.f1898a);
            }
            return new ayz(this.e, this.c, this.b);
        }

        public Builder addConnectionCallbacks(ConnectionCallback connectionCallback) {
            this.c.add(connectionCallback);
            return this;
        }

        public Builder(Context context) {
            this.e = context.getApplicationContext();
        }
    }
}
