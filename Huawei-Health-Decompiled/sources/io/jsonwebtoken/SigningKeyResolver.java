package io.jsonwebtoken;

import java.security.Key;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated
public interface SigningKeyResolver {
    Key resolveSigningKey(JwsHeader jwsHeader, Claims claims);

    Key resolveSigningKey(JwsHeader jwsHeader, byte[] bArr);
}
