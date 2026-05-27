package com.auth0.jwt.interfaces;

import defpackage.ri;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface Claim {
    <T> T as(Class<T> cls) throws ri;

    <T> T[] asArray(Class<T> cls) throws ri;

    Boolean asBoolean();

    Date asDate();

    Double asDouble();

    Integer asInt();

    <T> List<T> asList(Class<T> cls) throws ri;

    Long asLong();

    Map<String, Object> asMap() throws ri;

    String asString();

    boolean isMissing();

    boolean isNull();

    default Instant asInstant() {
        Date dateAsDate = asDate();
        if (dateAsDate != null) {
            return dateAsDate.toInstant();
        }
        return null;
    }
}
