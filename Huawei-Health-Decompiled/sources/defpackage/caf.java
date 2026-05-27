package defpackage;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public class caf implements X509TrustManager {
    private X509TrustManager c;

    public caf() {
        this.c = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    cal.d("HuaweiTrustManagerImpl", "X509TrustManager");
                    this.c = (X509TrustManager) trustManager;
                    return;
                }
            }
        } catch (IOException unused) {
            cal.c("HuaweiTrustManagerImpl", "HuaweiTrustManagerImpl IOException");
        } catch (KeyStoreException e) {
            e = e;
            cal.c("HuaweiTrustManagerImpl", "HuaweiTrustManagerImpl detail exception " + e.getMessage());
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            cal.c("HuaweiTrustManagerImpl", "HuaweiTrustManagerImpl detail exception " + e.getMessage());
        } catch (CertificateException e3) {
            e = e3;
            cal.c("HuaweiTrustManagerImpl", "HuaweiTrustManagerImpl detail exception " + e.getMessage());
        } catch (Exception e4) {
            cal.c("HuaweiTrustManagerImpl", "HuaweiTrustManagerImpl exception " + e4.getMessage());
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.c.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.c.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
            for (Throwable cause = e; cause != null; cause = cause.getCause()) {
                if ((cause instanceof CertificateExpiredException) || (cause instanceof CertificateNotYetValidException)) {
                    cal.c("HuaweiTrustManagerImpl", "CertificateExpiredException or CertificateNotYetValidException");
                }
            }
            cal.c("HuaweiTrustManagerImpl", "checkServerTrusted exception throw");
            throw e;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.c.getAcceptedIssuers();
    }
}
