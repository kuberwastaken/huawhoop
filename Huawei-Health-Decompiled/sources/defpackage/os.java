package defpackage;

import android.os.SystemClock;
import androidx.media3.common.C;

/* JADX INFO: loaded from: classes9.dex */
public class os {
    public static long c = -1;

    public static boolean d() {
        synchronized (os.class) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - c < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                return true;
            }
            c = jElapsedRealtime;
            return false;
        }
    }
}
