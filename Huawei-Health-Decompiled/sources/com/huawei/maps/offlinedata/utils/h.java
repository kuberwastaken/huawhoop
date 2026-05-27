package com.huawei.maps.offlinedata.utils;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6767a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    private static final boolean b = Log.isLoggable("OfflineDataMap", 2);
    private static final boolean c = Log.isLoggable("OfflineDataMap", 3);
    private static final boolean d = Log.isLoggable("OfflineDataMap", 4);
    private static final boolean e = Log.isLoggable("OfflineDataMap", 5);
    private static final boolean f = Log.isLoggable("OfflineDataMap", 6);
    private static final StringBuffer g = new StringBuffer();

    public static void a(String str, String str2) {
        if (c) {
            a(str, str2, null, false);
        }
    }

    public static void a(String str, String str2, Throwable th, boolean z) {
        if (c) {
            String strA = a(str);
            if (th == null) {
                i.a(strA, str2, z);
            } else {
                i.a(strA, str2, th, z);
            }
        }
    }

    public static void b(String str, String str2) {
        if (d) {
            b(str, str2, null, false);
        }
    }

    public static void b(String str, String str2, Throwable th, boolean z) {
        if (d) {
            String strA = a(str);
            if (th == null) {
                i.b(strA, str2, z);
            } else {
                i.b(strA, str2, th, z);
            }
        }
    }

    public static void c(String str, String str2) {
        if (e) {
            c(str, str2, null, false);
        }
    }

    public static void c(String str, String str2, Throwable th, boolean z) {
        if (e) {
            String strA = a(str);
            if (th == null) {
                i.c(strA, str2, z);
                e(str, a(str2, z));
                return;
            }
            i.c(strA, str2, th, z);
            e(str, a(str2, z) + System.lineSeparator() + Log.getStackTraceString(i.a(th)));
        }
    }

    public static void d(String str, String str2) {
        if (f) {
            d(str, str2, null, false);
        }
    }

    public static void d(String str, String str2, Throwable th, boolean z) {
        if (f) {
            String strA = a(str);
            if (th == null) {
                i.d(strA, str2, z);
                e(str, a(str2, z));
                return;
            }
            i.d(strA, str2, th, z);
            e(str, a(str2, z) + System.lineSeparator() + Log.getStackTraceString(i.a(th)));
        }
    }

    private static void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "OfflineDataMap";
        }
        StringBuffer stringBuffer = g;
        if (stringBuffer.length() == 0) {
            stringBuffer.append(a(System.currentTimeMillis())).append(" ").append(str).append(":").append(str2);
        } else {
            stringBuffer.append(System.lineSeparator()).append(a(System.currentTimeMillis())).append(" ").append(str).append(":").append(str2);
        }
        if (stringBuffer.length() > 3072) {
            stringBuffer.setLength(0);
        }
    }

    private static String a(String str) {
        if (str == null) {
            return "OfflineDataMap";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return "OfflineDataMap_" + str + "_" + (stackTrace.length > 5 ? stackTrace[5].getLineNumber() : 0);
    }

    private static String a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(i.a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static String a(long j) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS").format(new Date(j));
    }
}
