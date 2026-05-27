package health.compact.a.util;

import android.util.Log;
import com.huawei.hihealth.api.LogApi;

/* JADX INFO: loaded from: classes.dex */
public class LogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LogApi f13788a;

    private LogUtil() {
    }

    public static void b(LogApi logApi) {
        f13788a = logApi;
    }

    public static LogApi c() {
        return f13788a;
    }

    public static void b(String str, Object... objArr) {
        LogApi logApi = f13788a;
        if (logApi == null) {
            d(str, 1, objArr);
        } else {
            logApi.d(str, objArr);
        }
    }

    public static void a(String str, Object... objArr) {
        LogApi logApi = f13788a;
        if (logApi == null) {
            d(str, 2, objArr);
        } else {
            logApi.i(str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        LogApi logApi = f13788a;
        if (logApi == null) {
            d(str, 3, objArr);
        } else {
            logApi.w(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        LogApi logApi = f13788a;
        if (logApi == null) {
            d(str, 4, objArr);
        } else {
            logApi.e(str, objArr);
        }
    }

    public static boolean e() {
        LogApi logApi = f13788a;
        if (logApi == null) {
            return false;
        }
        return logApi.isBeta();
    }

    private static void d(String str, int i, Object... objArr) {
        StringBuilder sb = new StringBuilder(32);
        if (objArr != null) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        d(str, i, sb);
    }

    private static void d(String str, int i, StringBuilder sb) {
        if (i == 0) {
            Log.v(str, sb.toString());
            return;
        }
        if (i == 1) {
            Log.d(str, sb.toString());
            return;
        }
        if (i == 2) {
            Log.i(str, sb.toString());
        } else if (i == 3) {
            Log.w(str, sb.toString());
        } else {
            if (i != 4) {
                return;
            }
            Log.e(str, sb.toString());
        }
    }
}
