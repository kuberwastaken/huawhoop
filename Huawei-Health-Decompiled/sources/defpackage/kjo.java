package defpackage;

import com.huawei.hwappdfxmgr.threads.ThreadsCallBack;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public final class kjo {
    private static ThreadsCallBack d;

    public static void d(String str, long j) {
        ThreadsCallBack threadsCallBack = d;
        if (threadsCallBack != null) {
            threadsCallBack.dumpThreadsMessage(str, j);
        } else {
            LogUtil.b(str, "the mCallback is null");
        }
    }

    public static void b(ThreadsCallBack threadsCallBack) {
        d = threadsCallBack;
    }

    public static void e() {
        d = null;
    }
}
