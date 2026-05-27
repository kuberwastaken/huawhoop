package io.jsonwebtoken.lang;

import io.jsonwebtoken.lang.CollectionMutator;
import java.util.Collection;

/* JADX INFO: loaded from: classes11.dex */
public interface CollectionMutator<E, M extends CollectionMutator<E, M>> {
    M add(E e);

    M add(Collection<? extends E> collection);

    M clear();

    M remove(E e);
}
