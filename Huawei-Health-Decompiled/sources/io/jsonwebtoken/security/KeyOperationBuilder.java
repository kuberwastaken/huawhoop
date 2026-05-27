package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.Builder;

/* JADX INFO: loaded from: classes11.dex */
public interface KeyOperationBuilder extends Builder<KeyOperation> {
    KeyOperationBuilder description(String str);

    KeyOperationBuilder id(String str);

    KeyOperationBuilder related(String str);
}
