package io.jsonwebtoken.security;

import java.security.Key;

/* JADX INFO: loaded from: classes11.dex */
public interface AsymmetricJwk<K extends Key> extends Jwk<K>, X509Accessor {
    String getPublicKeyUse();
}
