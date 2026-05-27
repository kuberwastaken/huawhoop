package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ndj {
    private String b;
    private final Object d = new Object();
    private Map<String, byte[]> c = new HashMap();

    int e() {
        int size;
        synchronized (this.d) {
            size = this.c.size();
        }
        return size;
    }

    String b() {
        String str = this.b;
        return str == null ? "" : str;
    }

    Map<String, byte[]> d() {
        Map<String, byte[]> map;
        synchronized (this.d) {
            map = this.c;
        }
        return map;
    }

    public ndj(String str) {
        this.b = str;
    }

    public ndj() {
    }
}
