package io.jsonwebtoken.security;

import defpackage.xfu;
import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.VerifyDigestRequest;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public interface DigestAlgorithm<R extends Request<InputStream>, V extends VerifyDigestRequest> extends Identifiable {
    byte[] digest(R r) throws xfu;

    boolean verify(V v) throws xfu;
}
