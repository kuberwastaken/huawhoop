package com.huawei.phoneservice.feedbackcommon.utils;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(2:79|3)|(7:101|4|98|5|6|96|7)|(5:8|(1:10)(1:103)|92|56|60)|11|80|12|88|16|92|56|60|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0076, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0077, code lost:
    
        com.huawei.phoneservice.faq.base.util.h.e("BitmapUtils", r7.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0083, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0084, code lost:
    
        com.huawei.phoneservice.faq.base.util.h.e("BitmapUtils", r7.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00db, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:
    
        com.huawei.phoneservice.faq.base.util.h.e("BitmapUtils", r6.getMessage());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00d7 A[EXC_TOP_SPLITTER, PHI: r6
      0x00d7: PHI (r6v13 android.os.ParcelFileDescriptor) = 
      (r6v12 android.os.ParcelFileDescriptor)
      (r6v17 android.os.ParcelFileDescriptor)
      (r6v17 android.os.ParcelFileDescriptor)
     binds: [B:55:0x00d5, B:19:0x0084, B:16:0x007e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v9, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.BufferedOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File clS_(android.content.Context r6, android.net.Uri r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.c.clS_(android.content.Context, android.net.Uri, java.lang.String):java.io.File");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(3:66|3|(3:68|4|5))|(2:70|6)|(5:7|(1:9)(1:72)|58|35|39)|10|62|11|58|35|39|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        com.huawei.phoneservice.faq.base.util.h.e("BitmapUtils", r6.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        com.huawei.phoneservice.faq.base.util.h.e("BitmapUtils", r6.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File clR_(android.graphics.Bitmap r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "BitmapUtils"
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
            r3 = 50
            r5.compress(r2, r3, r1)
            java.io.File r5 = new java.io.File
            r5.<init>(r6)
            r6 = 0
            r5.createNewFile()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L59
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L59
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L59
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L59
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L59
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            byte[] r1 = r1.toByteArray()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r6 = 102400(0x19000, float:1.43493E-40)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4e
        L2f:
            int r1 = r3.read(r6)     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4e
            r4 = -1
            if (r1 == r4) goto L3b
            r4 = 0
            r2.write(r6, r4, r1)     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4e
            goto L2f
        L3b:
            r2.flush()     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4e
            r2.close()     // Catch: java.io.IOException -> L42
            goto L73
        L42:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r6)
            goto L73
        L4b:
            r5 = move-exception
            r6 = r3
            goto L85
        L4e:
            r6 = move-exception
            r1 = r6
            r6 = r3
            goto L5b
        L52:
            r5 = move-exception
            goto L85
        L54:
            r1 = move-exception
            goto L5b
        L56:
            r5 = move-exception
            r1 = r6
            goto L83
        L59:
            r1 = move-exception
            r2 = r6
        L5b:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L80
            com.huawei.phoneservice.faq.base.util.h.e(r0, r1)     // Catch: java.lang.Throwable -> L80
            if (r2 == 0) goto L70
            r2.close()     // Catch: java.io.IOException -> L68
            goto L70
        L68:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r1)
        L70:
            if (r6 == 0) goto L7f
            r3 = r6
        L73:
            r3.close()     // Catch: java.io.IOException -> L77
            goto L7f
        L77:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r6)
        L7f:
            return r5
        L80:
            r5 = move-exception
            r1 = r6
            r6 = r2
        L83:
            r2 = r6
            r6 = r1
        L85:
            if (r2 == 0) goto L93
            r2.close()     // Catch: java.io.IOException -> L8b
            goto L93
        L8b:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r1)
        L93:
            if (r6 == 0) goto La1
            r6.close()     // Catch: java.io.IOException -> L99
            goto La1
        L99:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r6)
        La1:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.c.clR_(android.graphics.Bitmap, java.lang.String):java.io.File");
    }
}
