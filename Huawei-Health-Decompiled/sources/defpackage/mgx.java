package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class mgx {
    public static boolean d(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean a(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean e(Collection<?> collection) {
        return !d(collection);
    }

    public static boolean e(Collection<?> collection, int i) {
        return d(collection) || i < 0 || i >= collection.size();
    }

    public static boolean a(Collection<?> collection, int i) {
        return !e(collection, i);
    }

    public static boolean e(Object obj, Class cls) {
        if (cls != null && obj != null && (obj instanceof List)) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                if (cls.isInstance(it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    public static <T> boolean c(T[] tArr, int i) {
        return !e(tArr, i);
    }

    public static boolean d(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static <T> boolean e(T[] tArr, int i) {
        return tArr != null && tArr.length != 0 && i >= 0 && i < tArr.length;
    }

    public static <T, V> List<T> d(List<V> list, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (d(list)) {
            return arrayList;
        }
        for (V v : list) {
            if (cls.isInstance(v)) {
                arrayList.add(cls.cast(v));
            }
        }
        return arrayList;
    }

    public static <E> boolean c(List<E> list, List<E> list2, boolean z) {
        if (d(list) && d(list2)) {
            return true;
        }
        if (d(list) || d(list2)) {
            return false;
        }
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        ArrayList arrayList2 = new ArrayList(list2.size());
        arrayList2.addAll(list2);
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        if (z) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (!arrayList.get(i).equals(arrayList2.get(i))) {
                    return false;
                }
            }
        } else if (!arrayList.containsAll(arrayList2)) {
            return false;
        }
        return true;
    }

    public static <E> List<E> e(List<E> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty() && i > 0) {
            if (list.size() <= i) {
                arrayList.addAll(list);
                return arrayList;
            }
            int size = list.size() % i;
            int size2 = list.size() / i;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                arrayList.add(list.get((i3 * size2) + i2));
                if (size > 0) {
                    size--;
                    i2++;
                }
            }
        }
        return arrayList;
    }

    public static int a(Collection<?> collection) {
        if (collection == null) {
            return -1;
        }
        return collection.size();
    }
}
