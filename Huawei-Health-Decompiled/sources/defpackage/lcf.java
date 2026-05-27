package defpackage;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class lcf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f15069a;
    private static final Map<String, Integer> c;

    static {
        int i = 16;
        c = new LinkedHashMap(i) { // from class: lcf.5
            private static final long serialVersionUID = -8254872593092335747L;

            {
                put("isSupportMultiLink", 25);
                put("isSupportPreemptLink", 26);
                put("isSupportSingleLink", 51);
            }
        };
        f15069a = new HashMap(i) { // from class: lcf.4
            private static final long serialVersionUID = -1234088914796797210L;

            {
                put(2, 1);
                put(3, 0);
            }
        };
    }

    public static HashMap<Integer, Integer> e() {
        return f15069a;
    }

    public static Map<String, Integer> d() {
        return c;
    }
}
