package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import defpackage.yl;
import defpackage.yu;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ClassIntrospector {

    public interface MixInResolver {
        MixInResolver copy();

        Class<?> findMixInClassFor(Class<?> cls);
    }

    public abstract ClassIntrospector copy();

    public abstract BeanDescription forClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription forCreation(yl ylVar, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription forDeserialization(yl ylVar, JavaType javaType, MixInResolver mixInResolver);

    @Deprecated
    public abstract BeanDescription forDeserializationWithBuilder(yl ylVar, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription forDeserializationWithBuilder(yl ylVar, JavaType javaType, MixInResolver mixInResolver, BeanDescription beanDescription);

    public abstract BeanDescription forDirectClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription forSerialization(yu yuVar, JavaType javaType, MixInResolver mixInResolver);
}
