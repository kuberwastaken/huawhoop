package io.jsonwebtoken.security;

import io.jsonwebtoken.security.X509Builder;

/* JADX INFO: loaded from: classes11.dex */
public interface X509Builder<T extends X509Builder<T>> extends X509Mutator<T> {
    T x509Sha1Thumbprint(boolean z);

    T x509Sha256Thumbprint(boolean z);
}
