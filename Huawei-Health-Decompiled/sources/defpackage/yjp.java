package defpackage;

import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes8.dex */
public class yjp extends ThreadLocalCrypto<KeyPairGenerator> {
    public yjp(final String str) {
        super(new ThreadLocalCrypto.Factory<KeyPairGenerator>() { // from class: yjp.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public KeyPairGenerator getInstance() throws GeneralSecurityException {
                String str2 = str;
                return KeyPairGenerator.getInstance(ygn.b(str2, str2));
            }
        });
    }
}
