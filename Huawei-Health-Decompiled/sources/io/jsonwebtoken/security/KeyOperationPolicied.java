package io.jsonwebtoken.security;

import io.jsonwebtoken.security.KeyOperationPolicied;

/* JADX INFO: loaded from: classes11.dex */
public interface KeyOperationPolicied<T extends KeyOperationPolicied<T>> {
    T operationPolicy(KeyOperationPolicy keyOperationPolicy) throws IllegalArgumentException;
}
