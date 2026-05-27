package org.eclipse.californium.core.network;

import defpackage.ycn;
import defpackage.yct;

/* JADX INFO: loaded from: classes8.dex */
public interface TokenGenerator {

    public enum Scope {
        LONG_TERM,
        SHORT_TERM,
        SHORT_TERM_CLIENT_LOCAL
    }

    ycn createToken(Scope scope);

    yct getKeyToken(ycn ycnVar, Object obj);

    Scope getScope(ycn ycnVar);
}
