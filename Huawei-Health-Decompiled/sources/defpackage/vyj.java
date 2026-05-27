package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes8.dex */
public class vyj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f18842a = new Object();
    private static volatile vyj c;
    private final Handler b;

    public static vyj d() {
        if (c == null) {
            synchronized (f18842a) {
                if (c == null) {
                    c = new vyj();
                }
            }
        }
        return c;
    }

    private vyj() {
        HandlerThread handlerThread = new HandlerThread("wear_wallet_handler_oversea");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
    }

    public Handler fwy_() {
        return fww_();
    }

    public Handler fwx_() {
        return fww_();
    }

    public Handler fww_() {
        return this.b;
    }
}
