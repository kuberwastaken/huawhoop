package defpackage;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class ecj {
    private static final Set<String> e;

    static {
        HashSet hashSet = new HashSet(2);
        e = hashSet;
        hashSet.add("c015d85d-6e29-4ff6-92e2-83bcddd44e53");
        hashSet.add("44812f21-5712-4ef1-ac74-6e7920442a9a");
    }

    public static boolean d(String str) {
        return e.contains(str);
    }
}
