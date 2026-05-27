package com.auth0.jwt.interfaces;

import java.security.PrivateKey;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes9.dex */
public interface KeyProvider<U extends PublicKey, R extends PrivateKey> {
    R getPrivateKey();

    String getPrivateKeyId();

    U getPublicKeyById(String str);
}
