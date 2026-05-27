package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes10.dex */
public final class e1 {
    public static final String b = "RequestThreadPoolMgr";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f5412a;

    public static class b {
        public static final e1 INSTANCE = new e1();
    }

    public Future submit(Runnable runnable) {
        try {
            return this.f5412a.submit(runnable);
        } catch (RejectedExecutionException unused) {
            Logger.e(b, "the runnable task cannot be accepted for execution");
            return null;
        }
    }

    public void release() {
        Logger.i(b, "ThreadPool release!");
        ExecutorService executorService = this.f5412a;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.f5412a.shutdown();
    }

    public void execute(Runnable runnable) {
        try {
            this.f5412a.execute(runnable);
        } catch (RejectedExecutionException unused) {
            Logger.e(b, "the runnable task cannot be accepted for execution");
        }
    }

    public static e1 getInstance() {
        return b.INSTANCE;
    }

    public e1() {
        this.f5412a = null;
        Logger.i(b, "ThreadPool init!");
        this.f5412a = Executors.newCachedThreadPool(ExecutorsUtils.createThreadFactory("request"));
    }
}
