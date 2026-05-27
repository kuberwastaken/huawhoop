package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes6.dex */
public abstract class dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final an f7997a = new an(new Handler(Looper.getMainLooper()));

    public static void a(String str) {
        f7997a.a(str);
    }

    public static void a(Runnable runnable, String str, long j) {
        f7997a.a(runnable, str, j);
    }

    public static void a(Runnable runnable, long j) {
        f7997a.a(runnable, null, j);
    }

    public static void a(Runnable runnable) {
        f7997a.a(runnable);
    }
}
