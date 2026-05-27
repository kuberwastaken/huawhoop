package com.huawei.hmf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityDefine {
    String alias() default "";

    Class<?> protocol() default Void.class;

    Class<?> result() default Void.class;
}
