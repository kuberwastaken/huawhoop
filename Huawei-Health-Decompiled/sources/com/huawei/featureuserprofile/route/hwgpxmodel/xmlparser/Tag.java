package com.huawei.featureuserprofile.route.hwgpxmodel.xmlparser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface Tag {
    int order() default 0;

    String value() default "";
}
