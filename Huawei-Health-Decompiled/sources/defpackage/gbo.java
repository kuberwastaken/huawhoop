package defpackage;

import com.huawei.health.pluginlocation.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class gbo {
    private static Logger d;

    public static void d(Logger logger) {
        if (d == null) {
            d = logger;
        }
    }

    public static void d(String str, Object... objArr) {
        Logger logger = d;
        if (logger != null) {
            logger.d(str, objArr);
        }
    }

    public static void a(String str, Object... objArr) {
        Logger logger = d;
        if (logger != null) {
            logger.i(str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        Logger logger = d;
        if (logger != null) {
            logger.w(str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        Logger logger = d;
        if (logger != null) {
            logger.e(str, objArr);
        }
    }
}
