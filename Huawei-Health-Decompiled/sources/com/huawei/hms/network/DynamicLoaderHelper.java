package com.huawei.hms.network;

/* JADX INFO: loaded from: classes5.dex */
public class DynamicLoaderHelper {
    private static final DynamicLoaderHelper b = new DynamicLoaderHelper();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5293a = false;

    public void setDynamicStatus(boolean z) {
        synchronized (this) {
            this.f5293a = z;
        }
    }

    public boolean getDynamicStatus() {
        boolean z;
        synchronized (this) {
            z = this.f5293a;
        }
        return z;
    }

    public static DynamicLoaderHelper getInstance() {
        return b;
    }

    private DynamicLoaderHelper() {
    }
}
