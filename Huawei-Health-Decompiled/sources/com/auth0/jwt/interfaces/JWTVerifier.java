package com.auth0.jwt.interfaces;

import defpackage.rh;

/* JADX INFO: loaded from: classes9.dex */
public interface JWTVerifier {
    DecodedJWT verify(DecodedJWT decodedJWT) throws rh;

    DecodedJWT verify(String str) throws rh;
}
