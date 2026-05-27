package defpackage;

import android.util.LruCache;

/* JADX INFO: loaded from: classes4.dex */
public class drj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f12381a = new Object();
    private static volatile drj b;
    private LruCache<String, String> e = new LruCache<>(4);

    private drj() {
    }

    public static drj b() {
        if (b == null) {
            synchronized (f12381a) {
                if (b == null) {
                    b = new drj();
                }
            }
        }
        return b;
    }

    public void c(String str, String str2) {
        this.e.put(str, str2);
    }

    public String d(String str) {
        return this.e.get(str);
    }

    public void d() {
        this.e.evictAll();
    }
}
