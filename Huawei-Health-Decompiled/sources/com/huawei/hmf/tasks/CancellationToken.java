package com.huawei.hmf.tasks;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract CancellationToken register(Runnable runnable);
}
