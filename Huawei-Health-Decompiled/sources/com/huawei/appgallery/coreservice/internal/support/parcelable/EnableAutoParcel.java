package com.huawei.appgallery.coreservice.internal.support.parcelable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableAutoParcel {
    boolean mayNull() default false;

    Class subClass() default EnableAutoParcel.class;

    boolean useClassLoader() default false;

    int value();
}
