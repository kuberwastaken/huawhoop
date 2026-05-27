package com.huawei.hmf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface ModuleDefine {
    Scope scope() default Scope.PACKAGE;

    String value();

    /* JADX INFO: loaded from: classes10.dex */
    public enum Scope {
        PROJECT(1),
        PACKAGE(4);

        private final int value;

        Scope(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
