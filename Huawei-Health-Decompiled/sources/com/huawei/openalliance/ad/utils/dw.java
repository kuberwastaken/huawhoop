package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.openalliance.ad.hq;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes6.dex */
public class dw {
    private static void c(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        hq.d("ZipUtil", "mkdirs error , files exists or IOException.");
    }

    private static boolean b(String str) {
        return str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || str.contains("..\\") || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
    }

    private static void b(File file) {
        if (file == null || file.delete()) {
            return;
        }
        hq.d("ZipUtil", "delete file error");
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return true;
        } catch (Exception e) {
            hq.d("ZipUtil", "unzip fail delete file failed" + e.getClass().getSimpleName());
            return false;
        }
    }

    public static boolean a(String str, String str2, boolean z) {
        return a(str, str2, 524288000, 100, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0127  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.io.Closeable, java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r15, java.lang.String r16, int r17, int r18, boolean r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.dw.a(java.lang.String, java.lang.String, int, int, boolean):boolean");
    }

    private static boolean a(String str, String str2, int i, int i2) throws com.huawei.openalliance.ad.exception.a {
        String str3;
        if (TextUtils.isEmpty(str) || b(str)) {
            str3 = "zip file is not valid";
        } else {
            if (!TextUtils.isEmpty(str2) && !b(str2)) {
                if (a(str, i, i2)) {
                    return true;
                }
                hq.d("ZipUtil", "zip file contains valid chars or too many files");
                throw new com.huawei.openalliance.ad.exception.a("unsecure zipfile!");
            }
            str3 = "target directory is not valid";
        }
        hq.d("ZipUtil", str3);
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x007d
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static boolean a(java.lang.String r12, int r13, int r14) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "ZipUtil"
            r2 = 0
            r3 = 0
            java.lang.String r4 = a(r12)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r5.<init>(r12, r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.util.Enumeration r12 = r5.entries()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r6 = 0
            r2 = r3
        L1a:
            boolean r4 = r12.hasMoreElements()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r8 = 1
            if (r4 == 0) goto L4e
            java.lang.Object r4 = r12.nextElement()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.util.zip.ZipEntry r4 = (java.util.zip.ZipEntry) r4     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            long r9 = r4.getSize()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            long r6 = r6 + r9
            int r2 = r2 + r8
            java.lang.String r8 = r4.getName()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            boolean r8 = b(r8)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r8 != 0) goto L48
            if (r2 >= r14) goto L48
            long r8 = (long) r13     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 > 0) goto L48
            long r8 = r4.getSize()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r10 = -1
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 != 0) goto L1a
        L48:
            java.lang.String r12 = "File name is invalid or too many files or too big"
            com.huawei.openalliance.ad.hq.d(r1, r12)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            goto L4f
        L4e:
            r3 = r8
        L4f:
            r5.close()     // Catch: java.io.IOException -> L7d
            goto L80
        L53:
            r12 = move-exception
            goto L82
        L55:
            r12 = move-exception
            r2 = r5
            goto L5b
        L58:
            r12 = move-exception
            goto L81
        L5a:
            r12 = move-exception
        L5b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58
            r13.<init>()     // Catch: java.lang.Throwable -> L58
            java.lang.String r14 = "not a valid zip file, IOException : "
            r13.append(r14)     // Catch: java.lang.Throwable -> L58
            java.lang.Class r12 = r12.getClass()     // Catch: java.lang.Throwable -> L58
            java.lang.String r12 = r12.getSimpleName()     // Catch: java.lang.Throwable -> L58
            r13.append(r12)     // Catch: java.lang.Throwable -> L58
            java.lang.String r12 = r13.toString()     // Catch: java.lang.Throwable -> L58
            com.huawei.openalliance.ad.hq.d(r1, r12)     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.io.IOException -> L7d
            goto L80
        L7d:
            com.huawei.openalliance.ad.hq.d(r1, r0)
        L80:
            return r3
        L81:
            r5 = r2
        L82:
            if (r5 == 0) goto L8b
            r5.close()     // Catch: java.io.IOException -> L88
            goto L8b
        L88:
            com.huawei.openalliance.ad.hq.d(r1, r0)
        L8b:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.dw.a(java.lang.String, int, int):boolean");
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        dc.a((Closeable) fileInputStream);
        dc.a(bufferedOutputStream);
        dc.a((Closeable) zipInputStream);
        dc.a(fileOutputStream);
    }

    private static void a(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            b(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    a(file2);
                }
            }
            b(file);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.zip.ZipFile] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:22:0x0039
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static java.lang.String a(java.lang.String r5) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "ZipUtil"
            java.lang.String r2 = "UTF-8"
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            java.util.Enumeration r5 = r4.entries()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
        L10:
            boolean r3 = r5.hasMoreElements()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            if (r3 == 0) goto L23
            r5.nextElement()     // Catch: java.lang.Exception -> L1a java.lang.Throwable -> L27 java.io.IOException -> L29
            goto L10
        L1a:
            java.lang.String r5 = "zipFile format exception"
            com.huawei.openalliance.ad.hq.c(r1, r5)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            java.lang.String r5 = "GBK"
            r2 = r5
        L23:
            r4.close()     // Catch: java.io.IOException -> L39
            goto L3c
        L27:
            r5 = move-exception
            goto L3e
        L29:
            r3 = r4
            goto L2d
        L2b:
            r5 = move-exception
            goto L3d
        L2d:
            java.lang.String r5 = "zipFile create exception"
            com.huawei.openalliance.ad.hq.c(r1, r5)     // Catch: java.lang.Throwable -> L2b
            if (r3 == 0) goto L3c
            r3.close()     // Catch: java.io.IOException -> L39
            goto L3c
        L39:
            com.huawei.openalliance.ad.hq.d(r1, r0)
        L3c:
            return r2
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L47
            r4.close()     // Catch: java.io.IOException -> L44
            goto L47
        L44:
            com.huawei.openalliance.ad.hq.d(r1, r0)
        L47:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.dw.a(java.lang.String):java.lang.String");
    }
}
