package io.jsonwebtoken.lang;

import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class Maps {

    public interface MapBuilder<K, V> extends Builder<Map<K, V>> {
        MapBuilder<K, V> and(K k, V v);

        @Override // io.jsonwebtoken.lang.Builder
        Map<K, V> build();
    }
}
