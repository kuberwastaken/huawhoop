package com.huawei.haf.dynamic;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ClassNotFoundInterceptor {
    public abstract Class<?> findClass(String str);

    protected final Class<?> findClassInPlugins(String str) {
        return DynamicApplicationLoaders.e(str, (List<String>) null);
    }
}
