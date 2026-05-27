package defpackage;

import java.security.GeneralSecurityException;
import javax.crypto.KeyAgreement;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes8.dex */
public class yjh extends ThreadLocalCrypto<KeyAgreement> {
    public yjh(final String str) {
        super(new ThreadLocalCrypto.Factory<KeyAgreement>() { // from class: yjh.5
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public KeyAgreement getInstance() throws GeneralSecurityException {
                return KeyAgreement.getInstance(str);
            }
        });
    }
}
