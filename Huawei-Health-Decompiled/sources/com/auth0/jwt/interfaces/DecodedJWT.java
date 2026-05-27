package com.auth0.jwt.interfaces;

/* JADX INFO: loaded from: classes9.dex */
public interface DecodedJWT extends Payload, Header {
    String getHeader();

    String getPayload();

    String getSignature();

    String getToken();
}
