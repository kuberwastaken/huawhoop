package defpackage;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
class lxq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f15538a;
    private static final Map<String, Integer> e;

    static {
        int i = 16;
        e = new LinkedHashMap(i) { // from class: lxq.1
            {
                put("isSupportMultiLink", 25);
                put("isSupportPreemptLink", 26);
                put("isSupportSingleLink", 51);
            }
        };
        f15538a = new HashMap(i) { // from class: lxq.3
            {
                put(2, 1);
                put(3, 0);
            }
        };
    }

    public static HashMap<Integer, Integer> d() {
        return f15538a;
    }

    public static Map<String, Integer> e() {
        return e;
    }
}
