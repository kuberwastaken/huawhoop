package com.unicom.online.account.kernel;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11952a = false;

    public static void b(Context context) {
        Long lB = m.b(context, "success_limit_count");
        m.a(context, "success_limit_count", Long.valueOf(lB == null ? 0L : lB.longValue() + 1));
    }

    public static boolean a(Context context) {
        if (f11952a) {
            return true;
        }
        Long lB = m.b(context, "success_limit_time");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (lB == null) {
            m.a(context, "success_limit_time", Long.valueOf(jCurrentTimeMillis));
            return true;
        }
        if (jCurrentTimeMillis - lB.longValue() > 600000) {
            m.a(context, "success_limit_time", Long.valueOf(jCurrentTimeMillis));
            m.a(context, "success_limit_count", (Long) 0L);
            return true;
        }
        Long lB2 = m.b(context, "success_limit_count");
        if (lB2 != null) {
            return lB2.longValue() < 50;
        }
        m.a(context, "success_limit_count", (Long) 0L);
        return true;
    }
}
