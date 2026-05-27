package health.compact.a;

import com.huawei.haf.common.log.LogBuilder;
import com.huawei.haf.common.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class LogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Logger f13765a;
    private static final LogImpl d;

    static {
        LogImpl logImpl = new LogImpl();
        d = logImpl;
        f13765a = logImpl;
        LogConfig.c(true, 2, false, true);
    }

    private LogUtil() {
    }

    public static void b(Logger logger, boolean z, int i, boolean z2, boolean z3) {
        if (logger != null) {
            f13765a = logger;
            LogBuilder.e();
        } else {
            f13765a = d;
        }
        LogConfig.c(z, i, z2, z3);
    }

    public static void e(String str, Object... objArr) {
        f13765a.v(str, LogConfig.b(0, str), objArr);
    }

    public static void c(String str, Object... objArr) {
        f13765a.d(str, LogConfig.b(1, str), objArr);
    }

    public static void a(String str, Object... objArr) {
        f13765a.i(str, LogConfig.b(2, str), objArr);
    }

    public static void b(String str, Object... objArr) {
        f13765a.w(str, LogConfig.b(3, str), objArr);
    }

    public static void d(String str, Object... objArr) {
        f13765a.e(str, LogConfig.b(4, str), objArr);
    }

    public static String c(Throwable th) {
        return f13765a.toString(th);
    }

    public static boolean d() {
        return f13765a.isReleaseVersion();
    }

    public static boolean a() {
        return f13765a.isBetaVersion();
    }

    public static boolean b() {
        return f13765a.isDebugVersion();
    }
}
