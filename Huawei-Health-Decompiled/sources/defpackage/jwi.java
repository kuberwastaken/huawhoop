package defpackage;

import android.util.LruCache;

/* JADX INFO: loaded from: classes5.dex */
public class jwi {
    private LruCache<Integer, Object> c = new LruCache<>(20);

    public Object e(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public void c(int i, Object obj) {
        if (obj == null) {
            return;
        }
        this.c.put(Integer.valueOf(i), obj);
    }

    public void d() {
        this.c.evictAll();
    }
}
