package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonPOJOBuilder {
    public static final String DEFAULT_BUILD_METHOD = "build";
    public static final String DEFAULT_WITH_PREFIX = "with";

    String buildMethodName() default "build";

    String withPrefix() default "with";

    /* JADX INFO: loaded from: classes9.dex */
    public static class a {
        public final String b;
        public final String c;

        public a(JsonPOJOBuilder jsonPOJOBuilder) {
            this(jsonPOJOBuilder.buildMethodName(), jsonPOJOBuilder.withPrefix());
        }

        public a(String str, String str2) {
            this.b = str;
            this.c = str2;
        }
    }
}
