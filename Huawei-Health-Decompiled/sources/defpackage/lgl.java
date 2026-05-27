package defpackage;

import com.huawei.haf.threadpool.ThreadPoolManager;

/* JADX INFO: loaded from: classes6.dex */
public class lgl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolManager f15146a = ThreadPoolManager.b(2, 4);

    public static void a(String str, Runnable runnable) {
        f15146a.e(str, runnable);
    }
}
