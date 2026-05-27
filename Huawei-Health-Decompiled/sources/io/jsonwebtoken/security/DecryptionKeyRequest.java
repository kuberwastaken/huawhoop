package io.jsonwebtoken.security;

import java.security.Key;

/* JADX INFO: loaded from: classes11.dex */
public interface DecryptionKeyRequest<K extends Key> extends SecureRequest<byte[], K>, KeyRequest<byte[]> {
}
