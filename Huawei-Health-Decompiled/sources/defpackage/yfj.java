package defpackage;

import java.io.ByteArrayInputStream;
import java.security.cert.CertPath;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.eclipse.californium.elements.auth.AbstractExtensiblePrincipal;

/* JADX INFO: loaded from: classes8.dex */
public class yfj extends AbstractExtensiblePrincipal<yfj> {
    private final CertPath b;
    private final X509Certificate e;

    public yfj(CertPath certPath) {
        this(certPath, null);
    }

    private yfj(CertPath certPath, yfd yfdVar) {
        super(yfdVar);
        if (!"X.509".equals(certPath.getType())) {
            throw new IllegalArgumentException("Cert path must contain X.509 certificates only");
        }
        if (certPath.getCertificates().isEmpty()) {
            throw new IllegalArgumentException("Cert path must not be empty");
        }
        this.b = certPath;
        this.e = (X509Certificate) certPath.getCertificates().get(0);
    }

    @Override // org.eclipse.californium.elements.auth.ExtensiblePrincipal
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yfj amend(yfd yfdVar) {
        return new yfj(this.b, yfdVar);
    }

    public static yfj a(byte[] bArr) {
        try {
            return new yfj(CertificateFactory.getInstance("X.509").generateCertPath(new ByteArrayInputStream(bArr), "PkiPath"));
        } catch (CertificateException unused) {
            throw new IllegalArgumentException("byte array does not contain X.509 certificate path");
        }
    }

    public byte[] d() {
        try {
            return this.b.getEncoded("PkiPath");
        } catch (CertificateEncodingException unused) {
            return ygc.d;
        }
    }

    @Override // java.security.Principal
    public String getName() {
        return this.e.getSubjectX500Principal().getName();
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.e.equals(((yfj) obj).e);
        }
        return false;
    }

    @Override // java.security.Principal
    public int hashCode() {
        return this.e.hashCode();
    }

    @Override // java.security.Principal
    public String toString() {
        return "x509 [" + getName() + "]";
    }
}
