package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class cgl {
    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean c(Object obj, Class cls) {
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
}
