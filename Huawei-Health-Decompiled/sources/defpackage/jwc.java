package defpackage;

import android.util.LruCache;
import com.huawei.hihealth.HiAppInfo;

/* JADX INFO: loaded from: classes5.dex */
public class jwc {
    private static LruCache<String, HiAppInfo> d = new LruCache<>(500);
    private static LruCache<String, Integer> c = new LruCache<>(20);

    public static HiAppInfo e(String str) {
        if (str == null) {
            return null;
        }
        return d.get(str);
    }

    public static void c(String str, HiAppInfo hiAppInfo) {
        if (str == null || hiAppInfo == null) {
            return;
        }
        d.put(str, hiAppInfo);
    }

    public static void b() {
        d.evictAll();
    }

    public static LruCache<String, Integer> bHi_() {
        return c;
    }
}
