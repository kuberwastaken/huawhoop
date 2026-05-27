package defpackage;

import android.util.SparseArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class jud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f14450a;
    private static final Map<String, Integer> b;
    private static final SparseArray<Integer> c;
    private static final SparseArray<Integer> d;
    private static final Map<String, Integer> e;
    private static final Map<String, Integer> f;
    private static final Map<String, Integer> g;
    private static final Map<String, Integer> h;
    private static final Map<String, Integer> i;
    private static final Map<String, Integer> j;
    private static final Map<String, Integer> k;
    private static final Map<String, Integer> l;
    private static final Map<String, Integer> m;
    private static final SparseArray<Integer> n;
    private static final Map<String, Integer> o;
    private static final Map<String, Integer> p;
    private static final Map<String, Integer> r;
    private static final SparseArray<Integer> s;
    private static final Map<String, Integer> t;

    static {
        HashMap map = new HashMap();
        b = map;
        HashMap map2 = new HashMap();
        l = map2;
        HashMap map3 = new HashMap();
        k = map3;
        HashMap map4 = new HashMap();
        e = map4;
        HashMap map5 = new HashMap();
        o = map5;
        HashMap map6 = new HashMap();
        g = map6;
        HashMap map7 = new HashMap();
        f14450a = map7;
        HashMap map8 = new HashMap();
        r = map8;
        HashMap map9 = new HashMap();
        t = map9;
        HashMap map10 = new HashMap();
        p = map10;
        HashMap map11 = new HashMap();
        m = map11;
        HashMap map12 = new HashMap();
        f = map12;
        HashMap map13 = new HashMap();
        j = map13;
        HashMap map14 = new HashMap();
        i = map14;
        HashMap map15 = new HashMap();
        h = map15;
        SparseArray<Integer> sparseArray = new SparseArray<>();
        s = sparseArray;
        sparseArray.put(20006, 10);
        sparseArray.put(20002, 20);
        sparseArray.put(20008, 30);
        sparseArray.put(20003, 40);
        sparseArray.put(20005, 50);
        sparseArray.put(20004, 60);
        sparseArray.put(20007, 70);
        SparseArray<Integer> sparseArray2 = new SparseArray<>();
        n = sparseArray2;
        sparseArray2.put(22003, 10);
        sparseArray2.put(22002, 20);
        sparseArray2.put(22001, 30);
        SparseArray<Integer> sparseArray3 = new SparseArray<>();
        d = sparseArray3;
        sparseArray3.put(22106, 10);
        sparseArray3.put(22107, 20);
        sparseArray3.put(22104, 30);
        sparseArray3.put(22105, 40);
        sparseArray3.put(22101, 50);
        sparseArray3.put(22102, 60);
        sparseArray3.put(22103, 70);
        SparseArray<Integer> sparseArray4 = new SparseArray<>();
        c = sparseArray4;
        sparseArray4.put(32, 10);
        sparseArray4.put(30, 10);
        sparseArray4.put(23, 30);
        sparseArray4.put(1, 100);
        map.put("08F", 10);
        map.put("00E", 15);
        map.put("082", 20);
        map.put("06E", 30);
        map.put("06D", 40);
        map.put("025", 50);
        map.put("088", 60);
        map.put("02B", 70);
        map.put("14C", 80);
        map2.put("00E", 10);
        map2.put("A12", 15);
        map2.put("06E", 20);
        map2.put("06D", 30);
        map2.put("08F", 40);
        map3.put("08F", 10);
        map3.put("06E", 15);
        map3.put("06D", 20);
        map4.put("08F", 10);
        map4.put("06E", 15);
        map4.put("06D", 20);
        map5.put("06E", 10);
        map5.put("06D", 20);
        map5.put("A12", 30);
        map6.put("06E", 10);
        map6.put("06D", 20);
        map6.put("A12", 30);
        map7.put("06D", 20);
        map8.put("06D", 20);
        map9.put("06D", 20);
        map10.put("06D", 20);
        map11.put("06D", 20);
        map12.put("06D", 20);
        map13.put("06D", 20);
        map14.put("06D", 20);
        map15.put("06D", 20);
    }

    public static Map<String, Integer> f() {
        return Collections.unmodifiableMap(b);
    }

    public static Map<String, Integer> o() {
        return Collections.unmodifiableMap(l);
    }

    public static Map<String, Integer> i() {
        return Collections.unmodifiableMap(k);
    }

    public static Map<String, Integer> d() {
        return Collections.unmodifiableMap(e);
    }

    public static Map<String, Integer> h() {
        return Collections.unmodifiableMap(g);
    }

    public static Map<String, Integer> b() {
        return Collections.unmodifiableMap(f14450a);
    }

    public static Map<String, Integer> k() {
        return Collections.unmodifiableMap(r);
    }

    public static Map<String, Integer> m() {
        return Collections.unmodifiableMap(t);
    }

    public static Map<String, Integer> l() {
        return Collections.unmodifiableMap(p);
    }

    public static Map<String, Integer> j() {
        return Collections.unmodifiableMap(m);
    }

    public static Map<String, Integer> a() {
        return Collections.unmodifiableMap(f);
    }

    public static Map<String, Integer> c() {
        return Collections.unmodifiableMap(j);
    }

    public static Map<String, Integer> g() {
        return Collections.unmodifiableMap(i);
    }

    public static Map<String, Integer> e() {
        return Collections.unmodifiableMap(h);
    }

    public static Map<String, Integer> n() {
        return Collections.unmodifiableMap(o);
    }

    public static Integer a(int i2) {
        Integer num = c.get(i2);
        if (num == null) {
            return 50;
        }
        return num;
    }

    public static int b(int i2, int i3) {
        SparseArray<Integer> sparseArray = s;
        Integer num = sparseArray.get(i2);
        Integer num2 = sparseArray.get(i3);
        if (num == null || num2 == null) {
            return 0;
        }
        return num.compareTo(num2);
    }

    public static int d(int i2, int i3) {
        SparseArray<Integer> sparseArray = n;
        Integer num = sparseArray.get(i2);
        Integer num2 = sparseArray.get(i3);
        if (num == null || num2 == null) {
            return 0;
        }
        return num.compareTo(num2);
    }

    public static int c(int i2, int i3) {
        SparseArray<Integer> sparseArray = d;
        Integer num = sparseArray.get(i2);
        Integer num2 = sparseArray.get(i3);
        if (num == null || num2 == null) {
            return 0;
        }
        return num.compareTo(num2);
    }
}
