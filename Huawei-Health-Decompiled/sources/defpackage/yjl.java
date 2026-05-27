package defpackage;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateFactory;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes8.dex */
public class yjl extends ThreadLocalCrypto<CertificateFactory> {
    public yjl(final String str) {
        super(new ThreadLocalCrypto.Factory<CertificateFactory>() { // from class: yjl.2
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public CertificateFactory getInstance() throws GeneralSecurityException {
                return CertificateFactory.getInstance(str);
            }
        });
    }
}
