package io.jsonwebtoken.security;

import java.security.Key;

/* JADX INFO: loaded from: classes11.dex */
public interface SecureRequest<T, K extends Key> extends Request<T>, KeySupplier<K> {
}
