package defpackage;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes6.dex */
public class lla {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15274a = true;
    private static Timer b = null;
    private static TimerTask c = null;
    private static boolean d = false;
    private static final Object e = new Object();
    private static TimerTask g;
    private static int i;
    private static Timer j;

    public static void a(int i2) {
        i = i2;
    }

    public static int i() {
        return i;
    }

    public static void d() {
        i++;
    }

    public static Timer b() {
        return j;
    }

    public static void d(Timer timer) {
        j = timer;
    }

    public static TimerTask e() {
        return g;
    }

    public static void b(TimerTask timerTask) {
        g = timerTask;
    }

    public static void c(boolean z) {
        f15274a = z;
    }

    public static boolean f() {
        return f15274a;
    }

    public static void a(boolean z) {
        d = z;
    }

    public static boolean g() {
        return d;
    }

    public static Timer a() {
        return b;
    }

    public static void e(Timer timer) {
        b = timer;
    }

    public static TimerTask c() {
        return c;
    }

    public static void c(TimerTask timerTask) {
        c = timerTask;
    }

    public static void c(final Timer timer, final TimerTask timerTask) {
        c(new Runnable() { // from class: lkw
            @Override // java.lang.Runnable
            public final void run() {
                lla.b(timer, timerTask);
            }
        });
    }

    static /* synthetic */ void b(Timer timer, TimerTask timerTask) {
        if (timer != null) {
            timer.cancel();
        }
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    public static void c(Runnable runnable) {
        synchronized (e) {
            runnable.run();
        }
    }
}
