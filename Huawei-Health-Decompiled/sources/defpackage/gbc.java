package defpackage;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes10.dex */
public class gbc {
    private static PowerManager.WakeLock b;
    private static final Object c = new Object();

    public static void d() {
        if (b != null) {
            gbo.e("WakelockUtil", "wakelock already init");
            return;
        }
        Context contextB = gav.b();
        if (contextB != null) {
            gbo.a("WakelockUtil", "init wakelock start");
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) contextB.getSystemService("power")).newWakeLock(1, "aar:lbs");
            b = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(true);
            return;
        }
        gbo.c("WakelockUtil", "init wakelock is null");
    }

    public static void b(int i) {
        if (b == null) {
            gbo.c("WakelockUtil", "acquire wakelock is null");
            return;
        }
        synchronized (c) {
            b.acquire(i);
            gbo.a("WakelockUtil", "acquire wakelock succeed");
        }
    }

    public static void c() {
        if (b == null) {
            gbo.c("WakelockUtil", "release wakelock is null");
            return;
        }
        synchronized (c) {
            if (b.isHeld()) {
                b.release();
                gbo.a("WakelockUtil", "release wakelock succeed");
            } else {
                gbo.c("WakelockUtil", "WakeLock expired before release");
            }
        }
    }
}
