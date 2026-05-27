package io.jsonwebtoken.security;

import java.net.URI;

/* JADX INFO: loaded from: classes11.dex */
public interface JwkThumbprint {
    HashAlgorithm getHashAlgorithm();

    byte[] toByteArray();

    String toString();

    URI toURI();
}
