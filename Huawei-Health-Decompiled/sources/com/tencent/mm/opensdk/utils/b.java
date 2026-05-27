package com.tencent.mm.opensdk.utils;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f11846a;
    public static ThreadPoolExecutor b = new ThreadPoolExecutor(5, 9, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    public static boolean a(int i) {
        return i == 36 || i == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return str.length() <= 0 ? i : Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f11846a != null && str.startsWith("content")) {
            try {
                return a(f11846a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.ContentResolver r5, android.net.Uri r6) {
        /*
            java.lang.String r0 = "getFileSize exception: "
            java.lang.String r1 = "getFileSize with content url"
            java.lang.String r2 = "MicroMsg.SDK.Util"
            com.tencent.mm.opensdk.utils.Log.i(r2, r1)
            r1 = 0
            if (r5 == 0) goto L9d
            if (r6 != 0) goto L10
            goto L9d
        L10:
            r3 = 0
            java.io.InputStream r3 = r5.openInputStream(r6)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r3 != 0) goto L32
            if (r3 == 0) goto L31
            r3.close()     // Catch: java.io.IOException -> L1d
            goto L31
        L1d:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r0)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.tencent.mm.opensdk.utils.Log.e(r2, r5)
        L31:
            return r1
        L32:
            int r5 = r3.available()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r3.close()     // Catch: java.io.IOException -> L3a
            goto L4e
        L3a:
            r6 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.tencent.mm.opensdk.utils.Log.e(r2, r6)
        L4e:
            return r5
        L4f:
            r5 = move-exception
            goto L82
        L51:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = "getFileSize fail, "
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L4f
            r6.append(r5)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L4f
            com.tencent.mm.opensdk.utils.Log.w(r2, r5)     // Catch: java.lang.Throwable -> L4f
            if (r3 == 0) goto L81
            r3.close()     // Catch: java.io.IOException -> L6d
            goto L81
        L6d:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r0)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.tencent.mm.opensdk.utils.Log.e(r2, r5)
        L81:
            return r1
        L82:
            if (r3 == 0) goto L9c
            r3.close()     // Catch: java.io.IOException -> L88
            goto L9c
        L88:
            r6 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.tencent.mm.opensdk.utils.Log.e(r2, r6)
        L9c:
            throw r5
        L9d:
            java.lang.String r5 = "getFileSize fail, resolver or uri is null"
            com.tencent.mm.opensdk.utils.Log.w(r2, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.utils.b.a(android.content.ContentResolver, android.net.Uri):int");
    }
}
