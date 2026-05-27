package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes8.dex */
public final class vyh {
    private static final byte[] b = new byte[0];
    private static volatile vyh d;
    private final ExecutorService c;

    private vyh() {
        vwc.c("ThreadPoolManager", "ThreadPool init");
        this.c = Executors.newSingleThreadExecutor();
    }

    public static vyh d() {
        if (d == null) {
            synchronized (b) {
                if (d == null) {
                    d = new vyh();
                }
            }
        }
        return d;
    }

    public ExecutorService a() {
        return this.c;
    }

    public void e(Runnable runnable) {
        this.c.execute(runnable);
    }
}
