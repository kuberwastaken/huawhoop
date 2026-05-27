package com.huawei.openalliance.ad.utils;

import android.util.Log;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes11.dex */
public class t<V> implements Callable<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Callable<V> f8017a;

    @Override // java.util.concurrent.Callable
    public V call() {
        Callable<V> callable = this.f8017a;
        if (callable != null) {
            try {
                try {
                    return callable.call();
                } finally {
                    this.f8017a = null;
                }
            } catch (Throwable unused) {
                Log.e("SafeCallable", "Exception in CallableWrapper");
                return null;
            }
        }
        return null;
    }

    public t(Callable<V> callable) {
        this.f8017a = callable;
    }
}
