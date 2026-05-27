package io.jsonwebtoken.lang;

import io.jsonwebtoken.lang.MapMutator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface MapMutator<K, V, T extends MapMutator<K, V, T>> {
    T add(K k, V v);

    T add(Map<? extends K, ? extends V> map);

    T delete(K k);

    T empty();
}
