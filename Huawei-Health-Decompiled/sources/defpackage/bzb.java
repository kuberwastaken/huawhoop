package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class bzb<K, V> {
    private final LinkedHashMap<K, V> c;
    private final int d;

    public bzb(int i) {
        this.d = i;
        this.c = new LinkedHashMap<K, V>(i, 0.75f, true) { // from class: bzb.4
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                return size() > bzb.this.d;
            }
        };
    }

    public V e(String str) {
        return this.c.get(str);
    }

    public void d(K k, V v) {
        this.c.put(k, v);
    }
}
