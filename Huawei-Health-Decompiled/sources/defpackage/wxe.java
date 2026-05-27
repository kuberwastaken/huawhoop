package defpackage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class wxe {
    private static final Map<Class<?>, wyx<?>> b = new ConcurrentHashMap();

    private static wyx<?> b(Class<?> cls) throws www {
        Map<Class<?>, wyx<?>> map = b;
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        wyx<?> wyxVar = new wyx<>(cls);
        map.put(cls, wyxVar);
        return wyxVar;
    }

    public static <T> void c(T t) throws www {
        if (t == null) {
            throw new www("validate bean is null");
        }
        wyx<?> wyxVarB = b(t.getClass());
        if (wyxVarB.e()) {
            wyxVarB.e(t);
        }
    }
}
