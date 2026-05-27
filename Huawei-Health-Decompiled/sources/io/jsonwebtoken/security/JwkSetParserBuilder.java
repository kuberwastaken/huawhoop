package io.jsonwebtoken.security;

import io.jsonwebtoken.io.ParserBuilder;

/* JADX INFO: loaded from: classes11.dex */
public interface JwkSetParserBuilder extends ParserBuilder<JwkSet, JwkSetParserBuilder>, KeyOperationPolicied<JwkSetParserBuilder> {
    JwkSetParserBuilder ignoreUnsupported(boolean z);
}
