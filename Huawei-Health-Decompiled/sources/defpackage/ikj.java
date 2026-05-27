package defpackage;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ikj {
    public static boolean e(Object obj, Class cls) {
        return mgx.e(obj, cls);
    }

    public static boolean b(Object obj, Class cls, Class cls2) {
        if (cls != null && cls2 != null && obj != null && (obj instanceof Pair)) {
            Pair pair = (Pair) obj;
            if (cls.isInstance(pair.first) && cls2.isInstance(pair.second)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Object obj, Class cls, Class cls2) {
        if (cls != null && cls2 != null && obj != null && (obj instanceof HashMap)) {
            for (Map.Entry entry : ((HashMap) obj).entrySet()) {
                if (!cls.isInstance(entry.getKey()) || !mgx.e(entry.getValue(), cls2)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean b(Object obj, Class cls, Class cls2, Class cls3, Class cls4) {
        if (cls == null || cls2 == null || cls3 == null || cls4 == null || obj == null || !(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return (pair.first instanceof Pair) && (pair.second instanceof Pair) && b(pair.first, cls, cls2) && b(pair.second, cls3, cls4);
    }

    public static boolean b(Object obj, Class cls) {
        if (cls != null && obj != null && (obj instanceof ArrayList)) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                if (cls.isInstance(it.next())) {
                }
            }
            return true;
        }
        return false;
    }
}
