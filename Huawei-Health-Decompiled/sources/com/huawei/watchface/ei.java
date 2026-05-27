package com.huawei.watchface;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes8.dex */
public class ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f11515a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f11515a.post(runnable);
    }
}
