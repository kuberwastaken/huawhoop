package io.jsonwebtoken.lang;

import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface Registry<K, V> extends Map<K, V> {
    V forKey(K k) throws IllegalArgumentException;
}
