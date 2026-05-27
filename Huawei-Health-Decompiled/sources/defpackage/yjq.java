package defpackage;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes8.dex */
public class yjq extends ThreadLocalCrypto<MessageDigest> {
    public yjq(final String str) {
        super(new ThreadLocalCrypto.Factory<MessageDigest>() { // from class: yjq.4
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MessageDigest getInstance() throws GeneralSecurityException {
                return MessageDigest.getInstance(str);
            }
        });
    }
}
