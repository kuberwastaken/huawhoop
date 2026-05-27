package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class wj {
    private static final ThreadPoolExecutor d = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    public static void d(Runnable runnable) {
        d.execute(runnable);
    }
}
