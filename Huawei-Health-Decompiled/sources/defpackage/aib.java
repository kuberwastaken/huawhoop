package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class aib {
    public static boolean b(Object obj, Collection<String> collection, Collection<String> collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        if (collection2 == null) {
            return collection.contains(obj);
        }
        if (collection == null) {
            return !collection2.contains(obj);
        }
        return !collection2.contains(obj) || collection.contains(obj);
    }

    public static a e(Set<String> set, Set<String> set2) {
        if (set2 == null && (set == null || set.isEmpty())) {
            return null;
        }
        return a.b(set, set2);
    }

    public static Set<String> a(Set<String> set, Set<String> set2) {
        if (set == null) {
            return set2;
        }
        if (set2 == null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        for (String str : set2) {
            if (set.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        private final Set<String> b;
        private final Set<String> c;

        private a(Set<String> set, Set<String> set2) {
            this.b = set == null ? Collections.emptySet() : set;
            this.c = set2;
        }

        public static a b(Set<String> set, Set<String> set2) {
            return new a(set, set2);
        }

        public boolean d(Object obj) {
            Set<String> set = this.c;
            return !(set == null || set.contains(obj)) || this.b.contains(obj);
        }
    }
}
