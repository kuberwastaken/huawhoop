package io.jsonwebtoken.security;

import io.jsonwebtoken.Identifiable;

/* JADX INFO: loaded from: classes11.dex */
public interface KeyOperation extends Identifiable {
    String getDescription();

    boolean isRelated(KeyOperation keyOperation);
}
