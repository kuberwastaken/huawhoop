package com.huawei.ads.fund.util;

import android.os.Looper;
import com.huawei.openplatform.abl.log.HiAdLog;
import defpackage.aqo;
import defpackage.aqv;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AsyncExec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IThreadType, ExecutorService> f1722a = new HashMap();
    private static c b = new c();

    public enum a implements IThreadType {
        IO,
        NETWORK,
        CALCULATION,
        SEQUENCE,
        SYNC_CALL,
        SEQUENCE_IO
    }

    public static void submitSeqIO(Runnable runnable) {
        submit(runnable, a.SEQUENCE_IO);
    }

    public static void submitSeq(Runnable runnable) {
        submit(runnable, a.SEQUENCE);
    }

    public static void submitNet(Runnable runnable) {
        submit(runnable, a.NETWORK);
    }

    public static void submitIO(Runnable runnable) {
        submit(runnable, a.IO);
    }

    public static void submitCalc(Runnable runnable) {
        submit(runnable, a.CALCULATION);
    }

    public static void submit(Runnable runnable, IThreadType iThreadType, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !a()) {
            new aqv(runnable).run();
            return;
        }
        ExecutorService executor = getExecutor(iThreadType);
        if (executor != null) {
            executor.execute(new aqv(runnable));
        } else {
            HiAdLog.w("AsyncExec", "no executor for type: %s", iThreadType);
        }
    }

    public static void submit(Runnable runnable, IThreadType iThreadType) {
        submit(runnable, iThreadType, false);
    }

    public static void setExecutorFactory(c cVar) {
        b = cVar;
    }

    public static ExecutorService getExecutor(IThreadType iThreadType) {
        ExecutorService executorService = f1722a.get(iThreadType);
        if (executorService != null) {
            return executorService;
        }
        c cVar = b;
        if (cVar == null) {
            HiAdLog.w("AsyncExec", "no executor factory found");
            return null;
        }
        ExecutorService executorServiceC = cVar.c(iThreadType);
        a(iThreadType, executorServiceC);
        return executorServiceC;
    }

    public static void clearExecutor(IThreadType iThreadType) {
        if (iThreadType != null) {
            f1722a.remove(iThreadType);
        }
    }

    public static void clearAllExecutors() {
        f1722a.clear();
    }

    private static boolean a() {
        Looper mainLooper = Looper.getMainLooper();
        return mainLooper != null && Thread.currentThread() == mainLooper.getThread();
    }

    public static class c {
        public ExecutorService d(IThreadType iThreadType) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ExecutorService c(IThreadType iThreadType) {
            ThreadPoolExecutor threadPoolExecutor;
            HiAdLog.i("ExecutorFactory", "createExecutorService for type %s", iThreadType);
            if (iThreadType == a.IO) {
                threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aqo("IO"));
            } else if (iThreadType == a.NETWORK) {
                threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aqo("Net"));
            } else {
                if (iThreadType != a.CALCULATION) {
                    return iThreadType == a.SEQUENCE ? new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aqo("Seq")) : iThreadType == a.SYNC_CALL ? new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aqo("SyncCall", 10)) : iThreadType == a.SEQUENCE_IO ? new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aqo("SeqIO")) : d(iThreadType);
                }
                threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aqo("Cal"));
            }
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }
    }

    private static void a(IThreadType iThreadType, ExecutorService executorService) {
        if (iThreadType == null || executorService == null) {
            return;
        }
        f1722a.put(iThreadType, executorService);
    }

    static <V> Future<V> a(Callable<V> callable, IThreadType iThreadType) {
        ExecutorService executor = getExecutor(iThreadType);
        if (executor != null) {
            return executor.submit(callable);
        }
        HiAdLog.w("AsyncExec", "no executor for type: %s", iThreadType);
        return null;
    }
}
