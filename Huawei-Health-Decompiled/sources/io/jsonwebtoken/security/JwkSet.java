package io.jsonwebtoken.security;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public interface JwkSet extends Map<String, Object>, Iterable<Jwk<?>> {
    Set<Jwk<?>> getKeys();
}
