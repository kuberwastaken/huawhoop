package io.jsonwebtoken.security;

import java.security.Provider;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes11.dex */
public interface Request<T> extends Message<T> {
    Provider getProvider();

    SecureRandom getSecureRandom();
}
