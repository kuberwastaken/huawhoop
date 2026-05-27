package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.lz;
import java.lang.Thread;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class ma extends mc {
    private static Thread.UncaughtExceptionHandler c = new Thread.UncaughtExceptionHandler() { // from class: com.amap.api.col.3sl.ma.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            jv.c(th, "TPool", "ThreadPool");
        }
    };
    private static ma d = new ma(new lz.a().a(c).a("amap-global-threadPool").b());

    public static ma a() {
        return d;
    }

    public static ma a(lz lzVar) {
        return new ma(lzVar);
    }

    private ma(lz lzVar) {
        try {
            this.f1282a = new ThreadPoolExecutor(lzVar.a(), lzVar.b(), lzVar.d(), TimeUnit.SECONDS, lzVar.c(), lzVar);
            this.f1282a.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            jv.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    @Deprecated
    public static ma b() {
        ma maVar;
        synchronized (ma.class) {
            if (d == null) {
                d = new ma(new lz.a().a(c).b());
            }
            maVar = d;
        }
        return maVar;
    }

    @Deprecated
    public static ma c() {
        return new ma(new lz.a().a(c).b());
    }
}
