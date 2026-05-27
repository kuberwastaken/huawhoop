package defpackage;

import java.util.Collection;

/* JADX INFO: loaded from: classes8.dex */
public class wum {
    public static boolean c(Collection<?> collection, int i) {
        return e(collection) || i < 0 || i >= collection.size();
    }

    public static boolean e(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
