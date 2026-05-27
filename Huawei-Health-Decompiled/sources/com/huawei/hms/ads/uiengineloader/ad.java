package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4553a = "dl_FileUtil";

    public static String c(String str) {
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf <= 0 ? str : str.substring(0, iLastIndexOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.lang.String r10) {
        /*
            r0 = 1
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L4e
            r1.<init>(r10)     // Catch: java.lang.Throwable -> L4e
            java.lang.String[] r2 = r1.list()     // Catch: java.lang.Throwable -> L4e
            boolean r3 = r1.isDirectory()     // Catch: java.lang.Throwable -> L4e
            r4 = 0
            if (r3 == 0) goto L3f
            if (r2 == 0) goto L3f
            int r3 = r2.length     // Catch: java.lang.Throwable -> L4e
            if (r3 <= 0) goto L3f
            int r3 = r2.length     // Catch: java.lang.Throwable -> L4e
            r5 = r0
            r6 = r4
        L19:
            if (r6 >= r3) goto L40
            r7 = r2[r6]     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L3b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r8.<init>()     // Catch: java.lang.Throwable -> L49
            r8.append(r10)     // Catch: java.lang.Throwable -> L49
            java.lang.String r9 = java.io.File.separator     // Catch: java.lang.Throwable -> L49
            r8.append(r9)     // Catch: java.lang.Throwable -> L49
            r8.append(r7)     // Catch: java.lang.Throwable -> L49
            java.lang.String r7 = r8.toString()     // Catch: java.lang.Throwable -> L49
            boolean r5 = b(r7)     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L3b
            r5 = r0
            goto L3c
        L3b:
            r5 = r4
        L3c:
            int r6 = r6 + 1
            goto L19
        L3f:
            r5 = r0
        L40:
            if (r5 == 0) goto L4c
            boolean r10 = r1.delete()     // Catch: java.lang.Throwable -> L49
            if (r10 == 0) goto L4c
            goto L6a
        L49:
            r10 = move-exception
            r0 = r5
            goto L4f
        L4c:
            r0 = r4
            goto L6a
        L4e:
            r10 = move-exception
        L4f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " delete err: "
            r1.<init>(r2)
            java.lang.Class r10 = r10.getClass()
            java.lang.String r10 = r10.getSimpleName()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.String r1 = "dl_FileUtil"
            com.huawei.hms.ads.uiengineloader.af.b(r1, r10)
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.ad.b(java.lang.String):boolean");
    }

    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e) {
            af.d(f4553a, "makeDirectory Exception: " + e.getMessage());
            return false;
        }
    }

    public static String a(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            af.d(f4553a, "getFilePath Exception: " + e.getMessage());
            return null;
        }
    }

    public static String a(Context context) {
        return a(context.createDeviceProtectedStorageContext().getDataDir());
    }
}
