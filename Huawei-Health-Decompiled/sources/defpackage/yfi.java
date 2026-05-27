package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class yfi {
    public static <E extends Enum<?>> Class<E> d(E[] eArr) {
        if (eArr == null) {
            throw new NullPointerException("Enums must not be null!");
        }
        if (eArr.length == 0) {
            throw new IllegalArgumentException("Enums must not be empty!");
        }
        return (Class<E>) eArr[0].getClass();
    }

    public static String e(List<String> list, boolean z) {
        if (list == null) {
            throw new NullPointerException("List must not be null!");
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('[');
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        if (z) {
            sb.append(']');
        }
        return sb.toString();
    }

    public static <E extends Enum<?>> String b(List<E> list, boolean z) {
        if (list == null) {
            throw new NullPointerException("List must not be null!");
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('[');
        }
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().name());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        if (z) {
            sb.append(']');
        }
        return sb.toString();
    }

    public static <E extends Enum<?>> E e(String str, List<E> list) {
        if (str == null) {
            throw new NullPointerException("Text must not be null!");
        }
        if (list == null) {
            throw new NullPointerException("values must not be null!");
        }
        for (E e : list) {
            if (e.name().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
