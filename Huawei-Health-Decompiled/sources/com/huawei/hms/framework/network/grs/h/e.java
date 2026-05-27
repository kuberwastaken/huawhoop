package com.huawei.hms.framework.network.grs.h;

import com.huawei.hms.framework.common.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4740a = "e";

    public static boolean a(Long l, long j) {
        if (l == null) {
            Logger.v(f4740a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l.longValue() - (System.currentTimeMillis() + j) >= 0) {
                Logger.v(f4740a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.v(f4740a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }

    public static boolean a(Long l) {
        if (l == null) {
            Logger.v(f4740a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (NumberFormatException unused) {
            Logger.v(f4740a, "isSpExpire spValue NumberFormatException.");
        }
        if (l.longValue() - System.currentTimeMillis() >= 0) {
            Logger.i(f4740a, "isSpExpire false.");
            return false;
        }
        Logger.i(f4740a, "isSpExpire true.");
        return true;
    }
}
