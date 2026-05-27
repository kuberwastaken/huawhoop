package com.huawei.wisesecurity.kfs.validation.constrains;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD})
@KfsConstraint
@Retention(RetentionPolicy.RUNTIME)
public @interface KfsStringRange {
    int max();

    int min() default 0;
}
