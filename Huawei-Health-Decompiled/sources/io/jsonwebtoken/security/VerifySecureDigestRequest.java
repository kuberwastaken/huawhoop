package io.jsonwebtoken.security;

import java.io.InputStream;
import java.security.Key;

/* JADX INFO: loaded from: classes11.dex */
public interface VerifySecureDigestRequest<K extends Key> extends SecureRequest<InputStream, K>, VerifyDigestRequest {
}
