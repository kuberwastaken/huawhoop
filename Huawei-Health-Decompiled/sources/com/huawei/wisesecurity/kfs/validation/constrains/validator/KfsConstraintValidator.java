package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import defpackage.www;
import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes8.dex */
public interface KfsConstraintValidator<A extends Annotation, T> {
    String getMessage();

    void initialize(String str, A a2) throws www;

    boolean isValid(T t);
}
