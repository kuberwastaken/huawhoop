package com.huawei.hianalytics;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h1 f4016a;
    public static final byte[] b = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f38a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f39a = new byte[0];

    public final Context a(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    public h1(Context context) {
        this.f38a = a(context);
    }
}
