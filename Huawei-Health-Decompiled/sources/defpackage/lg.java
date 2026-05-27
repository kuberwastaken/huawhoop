package defpackage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public class lg {
    public static final Map<String, d> d = new ConcurrentHashMap();

    public static class d {
        public long b;
        public long d;
        public String e;
    }

    public static boolean a(long j, long j2) {
        return System.currentTimeMillis() - j < j2;
    }

    public static void e(String str, String str2, long j) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (j == 0) {
            j = 86400000;
        }
        Map<String, d> map = d;
        d dVar = map.get(str);
        if (dVar == null) {
            dVar = new d();
        }
        dVar.e = str2;
        dVar.d = j;
        dVar.b = System.currentTimeMillis();
        map.put(str, dVar);
    }

    public static void d(String str, String str2) {
        e(str, str2, 86400000L);
    }

    public static String e(String str) {
        Map<String, d> map;
        d dVar;
        String str2;
        if (str == null || (map = d) == null || (dVar = map.get(str)) == null) {
            return null;
        }
        if (a(dVar.b, dVar.d) && (str2 = dVar.e) != null) {
            return str2;
        }
        map.remove(str);
        return null;
    }
}
