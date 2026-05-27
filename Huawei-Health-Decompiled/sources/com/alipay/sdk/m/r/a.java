package com.alipay.sdk.m.r;

import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: com.alipay.sdk.m.r.a$a, reason: collision with other inner class name */
    public interface InterfaceC0017a {
        void a(File file);

        void a(Throwable th);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.lang.String r4, java.lang.String r5, com.alipay.sdk.m.r.a.InterfaceC0017a r6) {
        /*
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L7c
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L7c
            java.net.URLConnection r4 = r0.openConnection()     // Catch: java.lang.Throwable -> L7c
            java.net.URLConnection r4 = com.huawei.agconnect.apms.instrument.URLConnectionInstrumentation.openConnection(r4)     // Catch: java.lang.Throwable -> L7c
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L7c
            r4.connect()     // Catch: java.lang.Throwable -> L7c
            int r0 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L7c
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L64
            r4.getContentLength()     // Catch: java.lang.Throwable -> L7c
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L7c
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L7c
            boolean r5 = r0.exists()     // Catch: java.lang.Throwable -> L7c
            if (r5 == 0) goto L2b
            r0.delete()     // Catch: java.lang.Throwable -> L7c
        L2b:
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L7c
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L58
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L58
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L4e
        L38:
            int r2 = r4.read(r1)     // Catch: java.lang.Throwable -> L4e
            r3 = -1
            if (r2 == r3) goto L44
            r3 = 0
            r5.write(r1, r3, r2)     // Catch: java.lang.Throwable -> L4e
            goto L38
        L44:
            r6.a(r0)     // Catch: java.lang.Throwable -> L4e
            r5.close()     // Catch: java.lang.Throwable -> L58
            r4.close()     // Catch: java.lang.Throwable -> L7c
            goto L80
        L4e:
            r0 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L53
            goto L57
        L53:
            r5 = move-exception
            r0.addSuppressed(r5)     // Catch: java.lang.Throwable -> L58
        L57:
            throw r0     // Catch: java.lang.Throwable -> L58
        L58:
            r5 = move-exception
            if (r4 == 0) goto L63
            r4.close()     // Catch: java.lang.Throwable -> L5f
            goto L63
        L5f:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch: java.lang.Throwable -> L7c
        L63:
            throw r5     // Catch: java.lang.Throwable -> L7c
        L64:
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = "Server returned HTTP "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L7c
            int r4 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L7c
            r0.append(r4)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L7c
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L7c
            throw r5     // Catch: java.lang.Throwable -> L7c
        L7c:
            r4 = move-exception
            r6.a(r4)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.r.a.b(java.lang.String, java.lang.String, com.alipay.sdk.m.r.a$a):void");
    }
}
