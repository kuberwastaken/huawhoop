package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.hq;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f7996a = new ConcurrentHashMap();

    public static boolean a(String str, int i) {
        if (str == null) {
            return true;
        }
        Map<String, Long> map = f7996a;
        Long l = map.get(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (l != null) {
            z = jCurrentTimeMillis - l.longValue() > ((long) i);
            if (!z) {
                if (hq.a()) {
                    hq.a("TimeIntervalControl", "tag: %s isExpired %s", str, Boolean.valueOf(z));
                }
                return z;
            }
        }
        if (hq.a()) {
            hq.a("TimeIntervalControl", "tag: %s isExpired %s", str, Boolean.valueOf(z));
        }
        map.put(str, Long.valueOf(jCurrentTimeMillis));
        return z;
    }

    public static boolean a(String str) {
        return a(str, 60000);
    }
}
