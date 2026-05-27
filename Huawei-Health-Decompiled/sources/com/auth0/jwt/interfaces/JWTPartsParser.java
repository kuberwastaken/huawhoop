package com.auth0.jwt.interfaces;

import defpackage.ri;

/* JADX INFO: loaded from: classes9.dex */
public interface JWTPartsParser {
    Header parseHeader(String str) throws ri;

    Payload parsePayload(String str) throws ri;
}
