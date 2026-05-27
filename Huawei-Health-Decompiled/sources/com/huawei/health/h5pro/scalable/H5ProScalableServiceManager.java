package com.huawei.health.h5pro.scalable;

import com.huawei.health.h5pro.scalable.storage.IH5ProAppLoadStorageService;

/* JADX INFO: loaded from: classes4.dex */
public class H5ProScalableServiceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f2490a = new Object();
    public static volatile H5ProScalableServiceManager e;
    public IH5ProAppLoadStorageService c;

    public void registerService(Object obj) {
        if (obj instanceof IH5ProAppLoadStorageService) {
            this.c = (IH5ProAppLoadStorageService) obj;
        }
    }

    public IH5ProAppLoadStorageService getH5ProAppLoadStorageService() {
        return this.c;
    }

    public static H5ProScalableServiceManager getInstance() {
        if (e == null) {
            synchronized (f2490a) {
                if (e == null) {
                    e = new H5ProScalableServiceManager();
                }
            }
        }
        return e;
    }
}
