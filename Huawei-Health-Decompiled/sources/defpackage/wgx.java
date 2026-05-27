package defpackage;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class wgx {
    private static long c;
    private static long d;
    private static SparseArray<Long> b = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Long> f18849a = new HashMap();

    public static boolean e(int i, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (b.indexOfKey(i) < 0) {
            a(i, jCurrentTimeMillis);
            return false;
        }
        if (jCurrentTimeMillis - b.get(i).longValue() <= j) {
            return true;
        }
        a(i, jCurrentTimeMillis);
        return false;
    }

    public static boolean e(int i) {
        return e(i, 500L);
    }

    private static void a(int i, long j) {
        if ((j - c > 10000 && j - d > 500) || b.size() > 50) {
            c = j;
            b.clear();
        }
        d = j;
        b.put(i, Long.valueOf(j));
    }
}
