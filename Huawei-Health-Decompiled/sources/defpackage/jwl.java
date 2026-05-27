package defpackage;

import android.util.LruCache;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class jwl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LruCache<String, List<Integer>> f14472a = new LruCache<>(10);

    public List<Integer> a(String str) {
        if (str == null) {
            return null;
        }
        return this.f14472a.get(str);
    }

    public void e(String str, List<Integer> list) {
        if (str == null || list == null) {
            return;
        }
        this.f14472a.put(str, list);
    }

    public void c() {
        this.f14472a.evictAll();
    }
}
