package com.auth0.jwt.interfaces;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface Payload {
    List<String> getAudience();

    Claim getClaim(String str);

    Map<String, Claim> getClaims();

    Date getExpiresAt();

    String getId();

    Date getIssuedAt();

    String getIssuer();

    Date getNotBefore();

    String getSubject();

    default Instant getExpiresAtAsInstant() {
        if (getExpiresAt() != null) {
            return getExpiresAt().toInstant();
        }
        return null;
    }

    default Instant getNotBeforeAsInstant() {
        if (getNotBefore() != null) {
            return getNotBefore().toInstant();
        }
        return null;
    }

    default Instant getIssuedAtAsInstant() {
        if (getIssuedAt() != null) {
            return getIssuedAt().toInstant();
        }
        return null;
    }
}
