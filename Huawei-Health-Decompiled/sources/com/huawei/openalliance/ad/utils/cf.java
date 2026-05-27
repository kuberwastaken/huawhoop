package com.huawei.openalliance.ad.utils;

import android.util.LruCache;
import com.huawei.openalliance.ad.hq;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import java.lang.ref.SoftReference;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7940a = "cf";
    private static final byte[] b = new byte[0];
    private static cf c;
    private SoftReference<LruCache<String, List<PermissionEntity>>> d;

    public void a(String str, List<PermissionEntity> list) {
        try {
            b().put(str, list);
        } catch (Throwable th) {
            hq.c(f7940a, "put cache encounter: " + th.getClass().getSimpleName());
        }
    }

    public List<PermissionEntity> a(String str) {
        try {
            return b().get(str);
        } catch (Throwable th) {
            hq.c(f7940a, "get cache encounter: " + th.getClass().getSimpleName());
            return null;
        }
    }

    private LruCache<String, List<PermissionEntity>> b() {
        SoftReference<LruCache<String, List<PermissionEntity>>> softReference = this.d;
        LruCache<String, List<PermissionEntity>> lruCache = softReference != null ? softReference.get() : null;
        if (lruCache != null) {
            return lruCache;
        }
        LruCache<String, List<PermissionEntity>> lruCache2 = new LruCache<>(5);
        this.d = new SoftReference<>(lruCache2);
        return lruCache2;
    }

    public static cf a() {
        cf cfVar;
        synchronized (b) {
            if (c == null) {
                c = new cf();
            }
            cfVar = c;
        }
        return cfVar;
    }
}
