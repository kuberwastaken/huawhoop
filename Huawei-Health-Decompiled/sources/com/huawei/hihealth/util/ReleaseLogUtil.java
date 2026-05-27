package com.huawei.hihealth.util;

import android.util.Log;
import com.huawei.hihealth.api.LogApi;

/* JADX INFO: loaded from: classes.dex */
public class ReleaseLogUtil {
    private static LogApi d;

    private ReleaseLogUtil() {
    }

    public static void b(LogApi logApi) {
        d = logApi;
    }

    public static void e(String str, Object... objArr) {
        LogApi logApi = d;
        if (logApi == null) {
            d(str, 2, objArr);
        } else {
            logApi.i(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        LogApi logApi = d;
        if (logApi == null) {
            d(str, 3, objArr);
        } else {
            logApi.w(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        LogApi logApi = d;
        if (logApi == null) {
            d(str, 4, objArr);
        } else {
            logApi.e(str, objArr);
        }
    }

    private static void d(String str, int i, Object... objArr) {
        StringBuilder sb = new StringBuilder(32);
        if (objArr != null) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        b(str, i, sb);
    }

    private static void b(String str, int i, StringBuilder sb) {
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
