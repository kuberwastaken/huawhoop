package health.compact.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class HiCommonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f13755a = 0;
    public static boolean b = true;
    private static String d;

    public static <T> boolean a(T t) {
        return t == null;
    }

    public static double b(double d2, double d3, double d4, double d5) {
        return ((d2 - ((d3 / 100.0d) * d2)) - d4) - d5;
    }

    public static double e(double d2) {
        return d2 * 2.2046d;
    }

    private HiCommonUtil() {
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(d)) {
            d = b(context, Process.myPid());
        }
        return d;
    }

    public static boolean a(Context context) {
        return HuaweiHealth.d().equals(e(context));
    }

    private static String b(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str = "";
        if (context == null) {
            return "";
        }
        ActivityManager activityManager = context.getSystemService("activity") instanceof ActivityManager ? (ActivityManager) context.getSystemService("activity") : null;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean e(int[] iArr) {
        return iArr == null || iArr.length <= 0;
    }

    public static final boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName(context.getPackageName() + ".BuildConfig");
            if (cls.getField("BUILD_TYPE").get(null) instanceof String) {
                return "release".equals((String) cls.getField("BUILD_TYPE").get(null));
            }
            return false;
        } catch (ClassNotFoundException e) {
            health.compact.a.util.LogUtil.d("HiCommonUtil", "isRelease ClassNotFoundException e = ", e.getMessage());
            return false;
        } catch (IllegalAccessException e2) {
            health.compact.a.util.LogUtil.d("HiCommonUtil", "isRelease IllegalAccessException e = ", e2.getMessage());
            return false;
        } catch (NoSuchFieldException e3) {
            health.compact.a.util.LogUtil.d("HiCommonUtil", "isRelease NoSuchFieldException e = ", e3.getMessage());
            return false;
        }
    }

    public static int b(int i) {
        return (int) Math.round(((double) i) / 2.54d);
    }

    public static int a(int[] iArr, int i) {
        if (iArr == null || iArr.length == 0) {
            return -1;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^-?\\d+(\\.\\d+)?$").matcher(str).matches();
    }

    public static boolean e(String str, long j) {
        if (Thread.currentThread().getId() != j) {
            return false;
        }
        com.huawei.hihealth.util.ReleaseLogUtil.e(str, "can't use singleInsertThread to insert data again, may Causes deadlock.");
        health.compact.a.util.LogUtil.a(str, "the deadlock dubious stackTrace is:", b());
        return true;
    }

    public static boolean c() {
        if (b) {
            f13755a = SystemClock.elapsedRealtime();
            return false;
        }
        if (SystemClock.elapsedRealtime() - f13755a < 10000) {
            return true;
        }
        f13755a = SystemClock.elapsedRealtime();
        return false;
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            sb.append(" at ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String a(Double d2) {
        return new DecimalFormat("#.###").format(d2);
    }

    public static double e(double d2, double d3, int i) {
        return new BigDecimal(d2).divide(new BigDecimal(d3), i, 4).doubleValue();
    }
}
