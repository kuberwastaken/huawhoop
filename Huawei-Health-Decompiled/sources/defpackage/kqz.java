package defpackage;

import com.huawei.haf.threadpool.ThreadPoolManager;

/* JADX INFO: loaded from: classes.dex */
public class kqz {
    public static int d(Runnable runnable) {
        ThreadPoolManager.b().execute(runnable);
        return 0;
    }
}
