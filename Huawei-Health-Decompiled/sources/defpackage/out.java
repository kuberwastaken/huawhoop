package defpackage;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes7.dex */
public class out {
    public static <V> boolean b(List<V> list) {
        return list == null || list.size() == 0;
    }

    public static <V> boolean d(Collection<V> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean c(ConcurrentMap concurrentMap) {
        return concurrentMap == null || concurrentMap.size() == 0;
    }
}
