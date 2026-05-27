package defpackage;

import com.huawei.haf.threadpool.ThreadPoolManager;

/* JADX INFO: loaded from: classes.dex */
public class bml {
    private static volatile bml d;

    private bml() {
    }

    public static bml a() {
        if (d == null) {
            synchronized (bml.class) {
                if (d == null) {
                    d = new bml();
                }
            }
        }
        return d;
    }

    public void d(Runnable runnable) {
        ThreadPoolManager.b().execute(runnable);
    }
}
