package io.jsonwebtoken.security;

import javax.crypto.SecretKey;
import javax.security.auth.Destroyable;

/* JADX INFO: loaded from: classes11.dex */
public interface Password extends SecretKey, Destroyable {
    char[] toCharArray();
}
