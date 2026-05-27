package com.huawei.hms.maps.model;

import com.huawei.hms.feature.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes5.dex */
public final class BitmapDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IObjectWrapper f5166a;

    public IObjectWrapper getObject() {
        return this.f5166a;
    }

    public BitmapDescriptor(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            throw new NullPointerException("Object is null");
        }
        this.f5166a = iObjectWrapper;
    }
}
