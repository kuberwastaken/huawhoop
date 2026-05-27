package com.huawei.ads.adsrec;

import android.text.TextUtils;
import defpackage.aps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f1716a = new byte[0];
    private static Map<String, Map<Integer, List<String>>> b = new HashMap();

    public static void a(String str, int i, List<String> list) {
        synchronized (f1716a) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Map<Integer, List<String>> map = b.get(str);
            if (map != null) {
                map.put(Integer.valueOf(i), list);
            } else {
                HashMap map2 = new HashMap();
                map2.put(Integer.valueOf(i), list);
                b.put(str, map2);
            }
        }
    }

    public static List<String> a(String str, int i) {
        Map<Integer, List<String>> map;
        synchronized (f1716a) {
            if (!TextUtils.isEmpty(str) && !aps.e(b)) {
                if (!b.containsKey(str) || (map = b.get(str)) == null || map.size() == 0) {
                    return null;
                }
                return map.get(Integer.valueOf(i));
            }
            return null;
        }
    }
}
