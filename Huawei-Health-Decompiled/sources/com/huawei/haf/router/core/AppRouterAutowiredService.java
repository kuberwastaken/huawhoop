package com.huawei.haf.router.core;

import android.util.LruCache;
import com.huawei.haf.router.facade.template.SyringeHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class AppRouterAutowiredService {
    private final Set<String> e = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f2174a = new HashSet();
    private final LruCache<String, SyringeHandler> b = new LruCache<>(10);

    AppRouterAutowiredService() {
    }

    void c(String[] strArr) {
        if (strArr.length > 0) {
            this.e.addAll(Arrays.asList(strArr));
        }
    }
}
