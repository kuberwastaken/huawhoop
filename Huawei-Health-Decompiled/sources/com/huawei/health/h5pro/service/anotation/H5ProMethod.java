package com.huawei.health.h5pro.service.anotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface H5ProMethod {
    String name() default "";

    String scope() default "";
}
