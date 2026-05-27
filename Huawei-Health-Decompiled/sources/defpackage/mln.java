package defpackage;

import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public class mln {
    public static Boolean c(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    public static Boolean a(Collection collection) {
        return Boolean.valueOf(!c(collection).booleanValue());
    }
}
