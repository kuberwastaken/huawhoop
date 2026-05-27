package io.jsonwebtoken.security;

import io.jsonwebtoken.JweHeader;

/* JADX INFO: loaded from: classes11.dex */
public interface KeyRequest<T> extends Request<T> {
    AeadAlgorithm getEncryptionAlgorithm();

    JweHeader getHeader();
}
