package com.huawei.watchface;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes8.dex */
public class fs<V> extends FutureTask<V> implements Comparable<Runnable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f11557a;

    public fs(Callable<V> callable) {
        super(callable);
    }

    public fs(Runnable runnable, V v) {
        super(runnable, v);
        this.f11557a = runnable;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Runnable runnable) {
        Runnable runnable2 = this.f11557a;
        ft ftVar = runnable2 instanceof ft ? (ft) runnable2 : null;
        if (ftVar != null) {
            return ftVar.compareTo(runnable);
        }
        return 0;
    }
}
