package io.jsonwebtoken.security;

import java.security.PrivateKey;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes11.dex */
public interface SignatureAlgorithm extends SecureDigestAlgorithm<PrivateKey, PublicKey>, KeyPairBuilderSupplier {
}
