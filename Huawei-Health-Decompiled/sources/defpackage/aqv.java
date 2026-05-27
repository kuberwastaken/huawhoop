package defpackage;

import com.huawei.openplatform.abl.log.HiAdLog;

/* JADX INFO: loaded from: classes3.dex */
public class aqv implements Runnable {
    private final Runnable b;

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.b;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                HiAdLog.e("TaskWrapper", "exception in task run");
                HiAdLog.printSafeStackTrace(5, th);
            }
        }
    }

    public aqv(Runnable runnable) {
        this.b = runnable;
    }
}
