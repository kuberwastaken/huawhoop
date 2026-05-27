package io.jsonwebtoken.security;

import java.util.Collection;

/* JADX INFO: loaded from: classes11.dex */
public interface KeyOperationPolicy {
    Collection<KeyOperation> getOperations();

    void validate(Collection<? extends KeyOperation> collection) throws IllegalArgumentException;
}
