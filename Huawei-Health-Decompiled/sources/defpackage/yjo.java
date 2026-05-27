package defpackage;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes8.dex */
public class yjo extends ThreadLocalCrypto<Mac> {
    public yjo(final String str) {
        super(new ThreadLocalCrypto.Factory<Mac>() { // from class: yjo.3
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Mac getInstance() throws GeneralSecurityException {
                return Mac.getInstance(str);
            }
        });
    }
}
