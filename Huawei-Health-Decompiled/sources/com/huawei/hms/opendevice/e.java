package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5840a;

    /* JADX WARN: Can't wrap try/catch for region: R(7:44|4|(5:49|5|42|6|(5:8|9|10|11|12)(4:13|14|15|52))|23|40|24|28) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a() {
        /*
            java.lang.String r0 = "CommFun"
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L51 java.io.IOException -> L68
            java.lang.String r2 = "/proc/self/cmdline"
            r1.<init>(r2)     // Catch: java.lang.Exception -> L51 java.io.IOException -> L68
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L47
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L47
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L47
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L33
            if (r4 == 0) goto L29
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L33
            r3.close()     // Catch: java.lang.Throwable -> L3d
            r2.close()     // Catch: java.lang.Throwable -> L47
            r1.close()     // Catch: java.lang.Exception -> L51 java.io.IOException -> L68
            return r4
        L29:
            r3.close()     // Catch: java.lang.Throwable -> L3d
            r2.close()     // Catch: java.lang.Throwable -> L47
            r1.close()     // Catch: java.lang.Exception -> L51 java.io.IOException -> L68
            goto L6d
        L33:
            r4 = move-exception
            r3.close()     // Catch: java.lang.Throwable -> L38
            goto L3c
        L38:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch: java.lang.Throwable -> L3d
        L3c:
            throw r4     // Catch: java.lang.Throwable -> L3d
        L3d:
            r3 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> L42
            goto L46
        L42:
            r2 = move-exception
            r3.addSuppressed(r2)     // Catch: java.lang.Throwable -> L47
        L46:
            throw r3     // Catch: java.lang.Throwable -> L47
        L47:
            r2 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L4c
            goto L50
        L4c:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: java.lang.Exception -> L51 java.io.IOException -> L68
        L50:
            throw r2     // Catch: java.lang.Exception -> L51 java.io.IOException -> L68
        L51:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "get current app processes exception!"
            r2.<init>(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
            goto L6d
        L68:
            java.lang.String r1 = "get current app processes IOException!"
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
        L6d:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.e.a():java.lang.String");
    }

    public static boolean b() {
        int i = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.d("CommFun", "Emui Api Level:" + i);
        return i > 0;
    }

    public static long d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    public static boolean e(Context context) {
        return b() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && d(context) < 110001400;
    }

    public static String c(Context context) {
        String str = context.createDeviceProtectedStorageContext().getDataDir() + "";
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("CommFun", "get storage root path of the current user failed.");
        }
        return str;
    }

    private static String b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid && runningAppProcessInfo.processName != null) {
                    HMSLog.i("CommFun", "info.pid -> " + runningAppProcessInfo.pid + ", info.processName -> " + runningAppProcessInfo.processName);
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        HMSLog.w("CommFun", "get running app processes null!");
        return "";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f5840a)) {
            return f5840a;
        }
        String strB = b(context);
        f5840a = strB;
        if (!TextUtils.isEmpty(strB)) {
            return f5840a;
        }
        String strA = a();
        f5840a = strA;
        return strA;
    }
}
