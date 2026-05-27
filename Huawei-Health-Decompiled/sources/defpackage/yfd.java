package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class yfd {
    private static final Map<String, Object> c = new HashMap(0);
    private final Map<String, Object> b;

    private yfd(Map<String, Object> map) {
        if (map == null) {
            this.b = c;
        } else {
            this.b = new HashMap(map);
        }
    }

    public static yfd a() {
        return new yfd(null);
    }
}
