package defpackage;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.californium.scandium.dtls.SignatureAndHashAlgorithm;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;

/* JADX INFO: loaded from: classes8.dex */
public class yjs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f19352a;
    private boolean g;
    private final List<PublicKey> e = new ArrayList();
    private final List<List<X509Certificate>> c = new ArrayList();
    private final List<X509Certificate> f = new ArrayList();
    private final List<SignatureAndHashAlgorithm> b = new ArrayList();
    private final List<XECDHECryptography.SupportedGroup> d = new ArrayList();

    public void b(X509Certificate[] x509CertificateArr) {
        if (x509CertificateArr != null) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                d(x509Certificate.getPublicKey());
                this.f.add(x509Certificate);
            }
        }
    }

    public void d(PublicKey publicKey) {
        if (publicKey != null) {
            SignatureAndHashAlgorithm.e(this.b, publicKey);
            if (yga.a(publicKey.getAlgorithm())) {
                XECDHECryptography.SupportedGroup supportedGroupFromPublicKey = XECDHECryptography.SupportedGroup.fromPublicKey(publicKey);
                if (supportedGroupFromPublicKey == null) {
                    throw new IllegalArgumentException("CA's public key ec-group must be supported!");
                }
                yjr.a(this.d, supportedGroupFromPublicKey);
            }
        }
    }

    public List<SignatureAndHashAlgorithm> a() {
        return this.b;
    }

    public List<XECDHECryptography.SupportedGroup> b() {
        return this.d;
    }

    public void c(List<SignatureAndHashAlgorithm> list) {
        for (PublicKey publicKey : this.e) {
            if (SignatureAndHashAlgorithm.a(list, publicKey) == null) {
                throw new IllegalStateException("supported signature and hash algorithms " + list + " doesn't match the public " + publicKey.getAlgorithm() + " key!");
            }
        }
        Iterator<List<X509Certificate>> it = this.c.iterator();
        while (it.hasNext()) {
            if (!SignatureAndHashAlgorithm.a(list, it.next())) {
                throw new IllegalStateException("supported signature and hash algorithms " + list + " doesn't match the certificate chain!");
            }
        }
        Iterator<X509Certificate> it2 = this.f.iterator();
        while (it2.hasNext()) {
            PublicKey publicKey2 = it2.next().getPublicKey();
            if (SignatureAndHashAlgorithm.a(list, publicKey2) == null) {
                throw new IllegalStateException("supported signature and hash algorithms " + list + " doesn't match the trust's public key " + publicKey2.getAlgorithm() + "!");
            }
        }
    }

    public void e(List<XECDHECryptography.SupportedGroup> list) {
        for (XECDHECryptography.SupportedGroup supportedGroup : this.d) {
            if (!supportedGroup.isUsable()) {
                throw new IllegalStateException("public key used with unsupported group (curve) " + supportedGroup.name() + "!");
            }
            if (!list.contains(supportedGroup)) {
                throw new IllegalStateException("public key used with not configured group (curve) " + supportedGroup.name() + "!");
            }
        }
    }

    public boolean a(boolean z) {
        return this.c.isEmpty() || (!z ? !this.g : !this.f19352a);
    }
}
