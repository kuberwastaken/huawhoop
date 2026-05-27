package health.compact.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class ThreadManager {
    private static HandlerThread d;

    private ThreadManager() {
    }

    static {
        HandlerThread handlerThread = new HandlerThread("logfile_thread");
        d = handlerThread;
        handlerThread.start();
    }

    public static Looper bYo_() {
        return d.getLooper();
    }

    public static Handler bYn_() {
        return new Handler(bYo_());
    }
}
