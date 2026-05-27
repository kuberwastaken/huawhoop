package io.jsonwebtoken.security;

import java.security.PrivateKey;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes11.dex */
public interface PrivateKeyBuilder extends KeyBuilder<PrivateKey, PrivateKeyBuilder> {
    PrivateKeyBuilder publicKey(PublicKey publicKey);
}
