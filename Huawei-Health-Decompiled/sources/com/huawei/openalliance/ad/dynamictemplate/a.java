package com.huawei.openalliance.ad.dynamictemplate;

import android.util.LruCache;

/* JADX INFO: loaded from: classes11.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f7076a;
    private static final byte[] b = new byte[0];
    private IImageLoader c;
    private final LruCache<String, String> d = new LruCache<>(100);

    public void a(IImageLoader iImageLoader) {
        this.c = iImageLoader;
    }

    public static a a() {
        a aVar;
        synchronized (b) {
            if (f7076a == null) {
                f7076a = new a();
            }
            aVar = f7076a;
        }
        return aVar;
    }
}
