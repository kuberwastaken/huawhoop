package com.fasterxml.jackson.databind.introspect;

import defpackage.acv;
import defpackage.ahv;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.Collections;

/* JADX INFO: loaded from: classes9.dex */
public abstract class AnnotatedMember extends Annotated implements Serializable {
    private static final long serialVersionUID = 1;
    protected final transient acv _annotations;
    protected final transient TypeResolutionContext _typeContext;

    public abstract Class<?> getDeclaringClass();

    public abstract Member getMember();

    public abstract Object getValue(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    public abstract void setValue(Object obj, Object obj2) throws UnsupportedOperationException, IllegalArgumentException;

    public abstract Annotated withAnnotations(acv acvVar);

    public AnnotatedMember(TypeResolutionContext typeResolutionContext, acv acvVar) {
        this._typeContext = typeResolutionContext;
        this._annotations = acvVar;
    }

    protected AnnotatedMember(AnnotatedMember annotatedMember) {
        this._typeContext = annotatedMember._typeContext;
        this._annotations = annotatedMember._annotations;
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName();
    }

    @Deprecated
    public TypeResolutionContext getTypeContext() {
        return this._typeContext;
    }

    @Override // com.fasterxml.jackson.databind.introspect.Annotated
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        acv acvVar = this._annotations;
        if (acvVar == null) {
            return null;
        }
        return (A) acvVar.get(cls);
    }

    @Override // com.fasterxml.jackson.databind.introspect.Annotated
    public final boolean hasAnnotation(Class<?> cls) {
        acv acvVar = this._annotations;
        if (acvVar == null) {
            return false;
        }
        return acvVar.has(cls);
    }

    @Override // com.fasterxml.jackson.databind.introspect.Annotated
    public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
        acv acvVar = this._annotations;
        if (acvVar == null) {
            return false;
        }
        return acvVar.hasOneOf(clsArr);
    }

    @Override // com.fasterxml.jackson.databind.introspect.Annotated
    @Deprecated
    public Iterable<Annotation> annotations() {
        acv acvVar = this._annotations;
        if (acvVar == null) {
            return Collections.emptyList();
        }
        return acvVar.b();
    }

    public acv getAllAnnotations() {
        return this._annotations;
    }

    public final void fixAccess(boolean z) {
        Member member = getMember();
        if (member != null) {
            ahv.a(member, z);
        }
    }
}
