package com.auth0.jwt.interfaces;

/* JADX INFO: loaded from: classes9.dex */
public interface Header {
    String getAlgorithm();

    String getContentType();

    Claim getHeaderClaim(String str);

    String getKeyId();

    String getType();
}
