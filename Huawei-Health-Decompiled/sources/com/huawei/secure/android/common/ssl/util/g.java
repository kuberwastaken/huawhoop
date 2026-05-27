package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes7.dex */
public class g {
    private static final String b = "X509CertificateUtil";
    public static final String c = "hmsrootcas.bks";
    public static final String d = "";
    public static final String e = "bks";
    public static final String f = "052root";
    private static final String g = "hmsincas.bks";
    private static final String h = "huawei cbg application integration ca";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8978a;

    public g(Context context) {
        this.f8978a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public X509Certificate a(String str, String str2) throws Throwable {
        Exception e2;
        InputStream inputStreamOpen;
        ?? r0 = 0;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(e);
                inputStreamOpen = this.f8978a.getAssets().open(str);
                try {
                    inputStreamOpen.reset();
                    keyStore.load(inputStreamOpen, "".toCharArray());
                    x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                    str = inputStreamOpen;
                } catch (IOException e3) {
                    e2 = e3;
                    d.b(b, "loadBksCA: exception : " + e2.getMessage());
                    str = inputStreamOpen;
                } catch (KeyStoreException e4) {
                    e2 = e4;
                    d.b(b, "loadBksCA: exception : " + e2.getMessage());
                    str = inputStreamOpen;
                } catch (NoSuchAlgorithmException e5) {
                    e2 = e5;
                    d.b(b, "loadBksCA: exception : " + e2.getMessage());
                    str = inputStreamOpen;
                } catch (CertificateException e6) {
                    e2 = e6;
                    d.b(b, "loadBksCA: exception : " + e2.getMessage());
                    str = inputStreamOpen;
                }
            } catch (Throwable th) {
                r0 = str;
                th = th;
                c.a((InputStream) r0);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e2 = e;
            inputStreamOpen = null;
            d.b(b, "loadBksCA: exception : " + e2.getMessage());
            str = inputStreamOpen;
            c.a((InputStream) str);
            return x509Certificate;
        } catch (KeyStoreException e8) {
            e = e8;
            e2 = e;
            inputStreamOpen = null;
            d.b(b, "loadBksCA: exception : " + e2.getMessage());
            str = inputStreamOpen;
            c.a((InputStream) str);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            e2 = e;
            inputStreamOpen = null;
            d.b(b, "loadBksCA: exception : " + e2.getMessage());
            str = inputStreamOpen;
            c.a((InputStream) str);
            return x509Certificate;
        } catch (CertificateException e10) {
            e = e10;
            e2 = e;
            inputStreamOpen = null;
            d.b(b, "loadBksCA: exception : " + e2.getMessage());
            str = inputStreamOpen;
            c.a((InputStream) str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            c.a((InputStream) r0);
            throw th;
        }
        c.a((InputStream) str);
        return x509Certificate;
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f);
    }

    public X509Certificate a() {
        return a(g, h);
    }
}
