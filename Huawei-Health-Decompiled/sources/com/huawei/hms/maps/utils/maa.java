package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class maa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Bitmap f5222a;

    public abstract Bitmap a(Context context);

    public Bitmap b(Context context) {
        if (this.f5222a == null) {
            synchronized (this) {
                if (this.f5222a == null) {
                    this.f5222a = a(context);
                }
            }
        }
        return this.f5222a;
    }
}
