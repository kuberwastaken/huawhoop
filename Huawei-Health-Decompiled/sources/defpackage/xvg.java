package defpackage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lib.android.paypal.com.magnessdk.network.base.c;

/* JADX INFO: loaded from: classes11.dex */
public final class xvg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f19157a = new Object();
    private static xvg d;
    private ThreadPoolExecutor b;

    public void d(c cVar) {
        this.b.execute(cVar);
    }

    public static xvg a() {
        xvg xvgVar;
        synchronized (f19157a) {
            if (d == null) {
                d = new xvg();
            }
            xvgVar = d;
        }
        return xvgVar;
    }

    private xvg() {
        try {
            this.b = new ThreadPoolExecutor(10, 10, 60000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(256), new ThreadPoolExecutor.DiscardPolicy());
        } catch (Exception unused) {
        }
    }
}
