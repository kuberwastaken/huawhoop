package com.huawei.hihealthservice;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public interface InsertExecutor extends Executor {
    @Override // java.util.concurrent.Executor
    void execute(Runnable runnable);

    Future<?> submit(Runnable runnable);
}
