package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;

/* JADX INFO: loaded from: classes5.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4104a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f110a = false;
    public static boolean b = false;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(boolean r4) {
        /*
            if (r4 != 0) goto L7
            boolean r4 = a()
            return r4
        L7:
            android.content.Context r4 = com.huawei.hianalytics.core.common.EnvUtils.getAppContext()
            java.lang.String r0 = "HmsBaseExist"
            r1 = 0
            if (r4 != 0) goto L11
            goto L31
        L11:
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> L2c
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r4 = r2.getApplicationInfo(r4, r3)     // Catch: java.lang.Throwable -> L2c
            android.os.Bundle r2 = r4.metaData     // Catch: java.lang.Throwable -> L2c
            if (r2 == 0) goto L31
            android.os.Bundle r4 = r4.metaData     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = "com.huawei.hms.client.appid"
            boolean r4 = r4.containsKey(r2)     // Catch: java.lang.Throwable -> L2c
            goto L32
        L2c:
            java.lang.String r4 = "applicationInfo not found"
            com.huawei.hianalytics.core.log.HiLog.w(r0, r4)
        L31:
            r4 = r1
        L32:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "contains appId: "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.huawei.hianalytics.core.log.HiLog.i(r0, r2)
            boolean r0 = a()
            if (r0 == 0) goto L4c
            if (r4 == 0) goto L4c
            r1 = 1
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.x0.a(boolean):boolean");
    }

    public static boolean a() {
        if (!f110a) {
            synchronized (f4104a) {
                try {
                    Class.forName("com.huawei.hms.common.HuaweiApi");
                    b = true;
                } catch (ClassNotFoundException unused) {
                    b = false;
                }
                f110a = true;
            }
        }
        boolean z = b;
        HiLog.i("HmsBaseExist", "hms base exist: " + z);
        return z;
    }
}
