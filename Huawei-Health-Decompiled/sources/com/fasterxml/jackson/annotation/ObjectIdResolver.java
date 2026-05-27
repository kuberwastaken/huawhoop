package com.fasterxml.jackson.annotation;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;

/* JADX INFO: loaded from: classes9.dex */
public interface ObjectIdResolver {
    void bindItem(ObjectIdGenerator.b bVar, Object obj);

    boolean canUseFor(ObjectIdResolver objectIdResolver);

    ObjectIdResolver newForDeserialization(Object obj);

    Object resolveId(ObjectIdGenerator.b bVar);
}
