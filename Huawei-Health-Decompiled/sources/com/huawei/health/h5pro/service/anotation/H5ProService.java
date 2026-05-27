package com.huawei.health.h5pro.service.anotation;

import com.huawei.health.h5pro.service.H5ProServiceLiveTerm;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface H5ProService {
    H5ProServiceLiveTerm liveTerm() default H5ProServiceLiveTerm.WHOLE;

    String name() default "";

    String[] users() default {};
}
