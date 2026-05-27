package com.huawei.wearengine.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import defpackage.wro;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes9.dex */
public class SecureX509TrustManager implements X509TrustManager {
    protected List<X509TrustManager> d = new ArrayList();

    public SecureX509TrustManager(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        KeyStore keyStore = KeyStore.getInstance(g.e);
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
            if (inputStreamOpen != null) {
                inputStreamOpen.reset();
                keyStore.load(inputStreamOpen, "".toCharArray());
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init(keyStore);
                c(trustManagerFactory.getTrustManagers());
                if (this.d.isEmpty()) {
                    throw new CertificateException("X509TrustManager is empty");
                }
            }
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused) {
                    wro.d("SecureX509TrustManager", "inputStream close error ");
                }
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused2) {
                    wro.d("SecureX509TrustManager", "inputStream close error ");
                }
            }
            throw th;
        }
    }

    private void c(TrustManager[] trustManagerArr) {
        if (trustManagerArr == null) {
            return;
        }
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                this.d.add((X509TrustManager) trustManager);
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.d.isEmpty()) {
            this.d.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.d.isEmpty()) {
            this.d.get(0).checkServerTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager x509TrustManager : this.d) {
                if (x509TrustManager instanceof X509TrustManager) {
                    arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
                }
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception unused) {
            wro.d("SecureX509TrustManager", "getAcceptedIssuers exception ");
            return new X509Certificate[0];
        }
    }
}
