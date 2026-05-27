package com.auth0.jwt.impl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ClaimsHolder {
    private Map<String, Object> claims;

    protected ClaimsHolder(Map<String, Object> map) {
        this.claims = map == null ? new HashMap<>() : map;
    }

    Map<String, Object> getClaims() {
        return this.claims;
    }
}
