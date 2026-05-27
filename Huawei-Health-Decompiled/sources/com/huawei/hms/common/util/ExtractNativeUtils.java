package com.huawei.hms.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.ModuleCopy;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public class ExtractNativeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4655a = "ExtractNativeUtils";
    public static final int b = 0;
    private static final int c = -1;
    private static final int d = 50;
    private static final int e = 52428800;
    private static final Pattern f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4656a;
        private ZipEntry b;
        private String c;

        private b(ZipEntry zipEntry, String str, String str2) {
            this.b = zipEntry;
            this.f4656a = str;
            this.c = str2;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                Logger.i(f4655a, "The extract-native-flag has set, need to extract.");
                return true;
            }
            Logger.i(f4655a, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            Logger.w(f4655a, "Get package name failed: name not found.");
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:81|3)|(2:83|4)|(2:5|(5:7|(1:86)(1:10)|79|47|51)(2:85|12))|77|13|79|47|51|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        com.huawei.hms.common.util.Logger.e(com.huawei.hms.common.util.ExtractNativeUtils.f4655a, "IOException", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
    
        com.huawei.hms.common.util.Logger.e(com.huawei.hms.common.util.ExtractNativeUtils.f4655a, "IOException", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        com.huawei.hms.common.util.Logger.e(com.huawei.hms.common.util.ExtractNativeUtils.f4655a, "so file too big , " + r10.c + " , " + r10.f4656a);
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.util.zip.ZipFile r9, com.huawei.hms.common.util.ExtractNativeUtils.b r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "IOException"
            java.lang.String r1 = "ExtractNativeUtils"
            r2 = 4096(0x1000, float:5.74E-42)
            r3 = -1
            r4 = 0
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70 java.io.FileNotFoundException -> L85
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70 java.io.FileNotFoundException -> L85
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70 java.io.FileNotFoundException -> L85
            java.lang.String r7 = com.huawei.hms.common.util.ExtractNativeUtils.b.a(r10)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70 java.io.FileNotFoundException -> L85
            r6.<init>(r11, r7)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70 java.io.FileNotFoundException -> L85
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70 java.io.FileNotFoundException -> L85
            java.util.zip.ZipEntry r11 = com.huawei.hms.common.util.ExtractNativeUtils.b.c(r10)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            java.io.InputStream r4 = r9.getInputStream(r11)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            r9 = 0
            r11 = r9
        L22:
            int r6 = r4.read(r2)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            if (r6 <= 0) goto L56
            int r11 = r11 + r6
            r7 = 52428800(0x3200000, float:4.7019774E-37)
            if (r11 <= r7) goto L52
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            r9.<init>()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            java.lang.String r11 = "so file too big , "
            r9.append(r11)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            java.lang.String r11 = com.huawei.hms.common.util.ExtractNativeUtils.b.b(r10)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            r9.append(r11)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            java.lang.String r11 = " , "
            r9.append(r11)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            java.lang.String r10 = com.huawei.hms.common.util.ExtractNativeUtils.b.a(r10)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            r9.append(r10)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            com.huawei.hms.common.util.Logger.e(r1, r9)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            goto L57
        L52:
            r5.write(r2, r9, r6)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.io.FileNotFoundException -> L6a
            goto L22
        L56:
            r3 = r9
        L57:
            r5.close()     // Catch: java.io.IOException -> L5b
            goto L98
        L5b:
            r9 = move-exception
            com.huawei.hms.common.util.Logger.e(r1, r0, r9)
            goto L98
        L60:
            r9 = move-exception
            goto L64
        L62:
            r9 = move-exception
            goto L67
        L64:
            r10 = r4
            r4 = r5
            goto La5
        L67:
            r10 = r4
            r4 = r5
            goto L72
        L6a:
            r9 = r4
            r4 = r5
            goto L86
        L6d:
            r9 = move-exception
            r10 = r4
            goto La5
        L70:
            r9 = move-exception
            r10 = r4
        L72:
            com.huawei.hms.common.util.Logger.e(r1, r0, r9)     // Catch: java.lang.Throwable -> L83
            if (r4 == 0) goto L7f
            r4.close()     // Catch: java.io.IOException -> L7b
            goto L7f
        L7b:
            r9 = move-exception
            com.huawei.hms.common.util.Logger.e(r1, r0, r9)
        L7f:
            if (r10 == 0) goto La0
            r4 = r10
            goto L98
        L83:
            r9 = move-exception
            goto La5
        L85:
            r9 = r4
        L86:
            java.lang.String r10 = "FileNotFoundException"
            com.huawei.hms.common.util.Logger.e(r1, r10)     // Catch: java.lang.Throwable -> La1
            if (r4 == 0) goto L95
            r4.close()     // Catch: java.io.IOException -> L91
            goto L95
        L91:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e(r1, r0, r10)
        L95:
            if (r9 == 0) goto La0
            r4 = r9
        L98:
            r4.close()     // Catch: java.io.IOException -> L9c
            goto La0
        L9c:
            r9 = move-exception
            com.huawei.hms.common.util.Logger.e(r1, r0, r9)
        La0:
            return r3
        La1:
            r10 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
        La5:
            if (r4 == 0) goto Laf
            r4.close()     // Catch: java.io.IOException -> Lab
            goto Laf
        Lab:
            r11 = move-exception
            com.huawei.hms.common.util.Logger.e(r1, r0, r11)
        Laf:
            if (r10 == 0) goto Lb9
            r10.close()     // Catch: java.io.IOException -> Lb5
            goto Lb9
        Lb5:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e(r1, r0, r10)
        Lb9:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.ExtractNativeUtils.a(java.util.zip.ZipFile, com.huawei.hms.common.util.ExtractNativeUtils$b, java.lang.String):int");
    }

    private static int a(Enumeration enumeration, HashMap<String, HashSet<b>> map, int i) {
        while (enumeration.hasMoreElements()) {
            Object objNextElement = enumeration.nextElement();
            if (objNextElement != null && (objNextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) objNextElement;
                String name = zipEntry.getName();
                if (name.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
                    Logger.e(f4655a, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = f.matcher(name);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    HashSet<b> hashSet = map.get(strGroup);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(strGroup, hashSet);
                    }
                    hashSet.add(new b(zipEntry, strGroup2, strGroup));
                    i++;
                }
            }
        }
        return i;
    }

    public static int a(File file, String str) throws Throwable {
        ZipFile zipFile;
        Logger.i(f4655a, "begin extractNativeLibrary");
        if (ModuleCopy.isPathInvalid(str)) {
            return -1;
        }
        ZipFile zipFile2 = null;
        int i = 0;
        try {
            try {
                zipFile = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                        HashMap map = new HashMap();
                        int iA = a(enumerationEntries, (HashMap<String, HashSet<b>>) map, 0);
                        if (iA == -1) {
                            Logger.e(f4655a, "Unsafe zip name!");
                            try {
                                zipFile.close();
                            } catch (IOException e2) {
                                Logger.e(f4655a, "IOException:", e2);
                            }
                            return -1;
                        }
                        if (iA > 50) {
                            Logger.e(f4655a, "the total number is larger than the max");
                            try {
                                zipFile.close();
                            } catch (IOException e3) {
                                Logger.e(f4655a, "IOException:", e3);
                            }
                            return -1;
                        }
                        Iterator it = map.keySet().iterator();
                        int iA2 = 0;
                        while (it.hasNext()) {
                            try {
                                Set<b> set = (Set) map.get((String) it.next());
                                if (set == null) {
                                    Logger.e(f4655a, "Get nativeZipEntries failed.");
                                    try {
                                        zipFile.close();
                                    } catch (IOException e4) {
                                        Logger.e(f4655a, "IOException:", e4);
                                    }
                                    return -1;
                                }
                                for (b bVar : set) {
                                    if (!TextUtils.isEmpty(bVar.f4656a)) {
                                        String str2 = str + File.separator + bVar.c;
                                        FileUtils.b(str2);
                                        new File(str2).setExecutable(true, false);
                                        iA2 = a(zipFile, bVar, str2);
                                        if (iA2 != 0) {
                                            try {
                                                zipFile.close();
                                            } catch (IOException e5) {
                                                Logger.e(f4655a, "IOException:", e5);
                                            }
                                            return iA2;
                                        }
                                        new File(str2, bVar.f4656a).setReadOnly();
                                    }
                                }
                            } catch (IOException e6) {
                                e = e6;
                                i = iA2;
                                zipFile2 = zipFile;
                                Logger.e(f4655a, "catch IOException ", e);
                                if (zipFile2 != null) {
                                    try {
                                        zipFile2.close();
                                    } catch (IOException e7) {
                                        e = e7;
                                        iA2 = i;
                                    }
                                }
                                return i;
                            }
                            Logger.e(f4655a, "IOException:", e);
                            return iA2;
                        }
                        try {
                            zipFile.close();
                            return iA2;
                        } catch (IOException e8) {
                            e = e8;
                        }
                    } catch (IOException e9) {
                        e = e9;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e10) {
                            Logger.e(f4655a, "IOException:", e10);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
            }
        } catch (IOException e11) {
            e = e11;
        }
    }
}
