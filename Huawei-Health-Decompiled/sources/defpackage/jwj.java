package defpackage;

import android.util.LruCache;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class jwj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LruCache<String, jwv> f14471a = new LruCache<>(20);
    private Set<String> d = new HashSet(16);

    public jwv c(String str) {
        if (str == null) {
            return null;
        }
        return this.f14471a.get(str);
    }

    public void a(String str, jwv jwvVar) {
        if (str == null || jwvVar == null) {
            return;
        }
        this.f14471a.put(str, jwvVar);
    }

    public void d(String str) {
        this.d.add(str);
    }

    public boolean a(String str) {
        return this.d.contains(str);
    }

    public void e() {
        this.f14471a.evictAll();
    }
}
