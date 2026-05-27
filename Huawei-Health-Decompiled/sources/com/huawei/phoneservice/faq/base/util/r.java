package com.huawei.phoneservice.faq.base.util;

import android.util.LruCache;
import android.view.View;
import com.huawei.hms.framework.common.Logger;

/* JADX INFO: loaded from: classes6.dex */
public class r {
    private static final LruCache<Integer, Long> d = new LruCache<>(10);

    public static boolean cjR_(View view) {
        boolean z = true;
        if (view != null) {
            Integer numValueOf = Integer.valueOf(view.getId());
            LruCache<Integer, Long> lruCache = d;
            Long l = lruCache.get(numValueOf);
            long jNanoTime = System.nanoTime() / 1000000;
            Logger.d("NoDoubleClickUtil", "isDoubleClick view:%s, lastClickTime:%s,  currentTime:%s", numValueOf, l, Long.valueOf(jNanoTime));
            if (l != null) {
                long jLongValue = jNanoTime - l.longValue();
                if (jLongValue > 800) {
                    lruCache.put(numValueOf, Long.valueOf(jNanoTime));
                    z = false;
                }
                Logger.d("NoDoubleClickUtil", "isDoubleClick gap:%s, BREAK_TIME:%s", Long.valueOf(jLongValue), 800);
            } else {
                lruCache.put(numValueOf, Long.valueOf(jNanoTime));
                z = false;
            }
        }
        Logger.d("NoDoubleClickUtil", "isDoubleClick result:%s", Boolean.valueOf(z));
        return z;
    }
}
