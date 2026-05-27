package com.huawei.health.h5pro.core;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class H5ProConfigGuardian {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile OnConfigGuardianListener f2411a;
    public static final H5ProConfigGuardian e = new H5ProConfigGuardian();

    public interface OnConfigGuardianListener {
        void onConfigGuardian(Context context);
    }

    public void onConfigGuardian(Context context) {
        if (f2411a == null) {
            return;
        }
        f2411a.onConfigGuardian((Context) new WeakReference(context).get());
    }

    public void addOnConfigGuardianListener(OnConfigGuardianListener onConfigGuardianListener) {
        synchronized (this) {
            if (f2411a == null) {
                f2411a = onConfigGuardianListener;
            }
        }
    }
}
