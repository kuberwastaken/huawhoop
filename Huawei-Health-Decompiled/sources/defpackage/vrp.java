package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class vrp {
    private static Map<Integer, Integer> e = new HashMap(16);
    private static List<Integer> d = new ArrayList(16);
    private static List<Integer> b = new ArrayList(16);
    private static Map<Integer, Integer> c = new HashMap(16);

    static {
        a();
        g();
        j();
        e();
    }

    public static Map<Integer, Integer> b() {
        return e;
    }

    public static List<Integer> d() {
        return d;
    }

    public static List<Integer> c() {
        return b;
    }

    private static void a() {
        e.put(1, 35);
        e.put(2, 35);
    }

    private static void g() {
        d.add(1005);
        d.add(1006);
        d.add(1007);
        d.add(1008);
        d.add(1009);
        d.add(1010);
        d.add(1011);
        d.add(1012);
        d.add(1013);
        d.add(1016);
        d.add(1020);
        d.add(1023);
        d.add(1024);
        d.add(1025);
        d.add(1021);
        d.add(1020);
        d.add(1029);
    }

    private static void j() {
        b.add(1005);
        b.add(1006);
        b.add(1008);
        b.add(1009);
        b.add(1010);
        b.add(1011);
        b.add(1012);
        b.add(1013);
        b.add(1025);
        b.add(1021);
        b.add(1020);
        b.add(1029);
    }

    private static void e() {
        c.put(1018, 1);
    }
}
