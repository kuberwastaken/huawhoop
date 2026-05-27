package com.huawei.health.h5pro.core;

import com.huawei.health.h5pro.vengine.H5ProVirtualEngine;
import com.huawei.health.h5pro.webkit.WebKitEngine;

/* JADX INFO: loaded from: classes4.dex */
public class H5ProEngineFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile H5ProVirtualEngine f2412a;
    public static final Object d = new Object();

    public static H5ProVirtualEngine getH5ProEngine() {
        if (f2412a == null) {
            synchronized (d) {
                if (f2412a == null) {
                    f2412a = new WebKitEngine();
                }
            }
        }
        return f2412a;
    }

    public static void destroy() {
        synchronized (H5ProEngineFactory.class) {
            if (f2412a != null) {
                f2412a = null;
            }
        }
    }
}
