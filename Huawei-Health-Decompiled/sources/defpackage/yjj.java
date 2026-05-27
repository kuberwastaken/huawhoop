package defpackage;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes8.dex */
public class yjj extends ThreadLocalCrypto<Cipher> {
    public yjj(final String str) {
        super(new ThreadLocalCrypto.Factory<Cipher>() { // from class: yjj.2
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Cipher getInstance() throws GeneralSecurityException {
                return Cipher.getInstance(str);
            }
        });
    }
}
