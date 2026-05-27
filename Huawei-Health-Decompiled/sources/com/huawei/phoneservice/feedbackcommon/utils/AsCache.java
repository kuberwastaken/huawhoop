package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import android.os.Process;
import com.huawei.openalliance.ad.constant.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class AsCache {
    public static final String FEED_BACK_CACHE_FILE_NAME = "feedback";
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    private static final char SEPARATOR = ' ';
    private static final String TAG = "AsCache";
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static Map<String, AsCache> mInstanceMap = new HashMap();
    private a mCache;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8629a;
        private final AtomicLong b;
        private final Map<File, Long> c;
        private final AtomicInteger d;
        private final long e;
        private File f;
        private ThreadPoolExecutor i;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(String str) {
            return a(str).delete();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(File file) {
            int iAddAndGet = this.d.get();
            while (iAddAndGet + 1 > this.f8629a) {
                this.b.addAndGet(-a());
                iAddAndGet = this.d.addAndGet(-1);
            }
            this.d.addAndGet(1);
            long jC = c(file);
            long jAddAndGet = this.b.get();
            while (jAddAndGet + jC > this.e) {
                jAddAndGet = this.b.addAndGet(-a());
            }
            this.b.addAndGet(jC);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            this.c.put(file, lValueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File e(String str) {
            return new File(this.f, str.hashCode() + "");
        }

        private long a() {
            File key;
            if (this.c.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> setEntrySet = this.c.entrySet();
            synchronized (this.c) {
                key = null;
                Long value = null;
                for (Map.Entry<File, Long> entry : setEntrySet) {
                    if (key == null) {
                        key = entry.getKey();
                        value = entry.getValue();
                    } else {
                        Long value2 = entry.getValue();
                        if (value2.longValue() < value.longValue()) {
                            key = entry.getKey();
                            value = value2;
                        }
                    }
                }
            }
            long jC = c(key);
            if (key != null && key.delete()) {
                this.c.remove(key);
            }
            return jC;
        }

        private void c() {
            this.i.execute(new b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File a(String str) {
            File fileE = e(str);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            fileE.setLastModified(lValueOf.longValue());
            this.c.put(fileE, lValueOf);
            return fileE;
        }

        class b implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles = a.this.f.listFiles();
                if (fileArrListFiles != null) {
                    int iC = 0;
                    int i = 0;
                    for (File file : fileArrListFiles) {
                        iC = (int) (((long) iC) + a.this.c(file));
                        i++;
                        a.this.c.put(file, Long.valueOf(file.lastModified()));
                    }
                    a.this.b.set(iC);
                    a.this.d.set(i);
                }
            }

            b() {
            }
        }

        class c implements ThreadFactory {
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(AsCache.TAG);
            }

            c() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(File file) {
            if (file == null) {
                return 0L;
            }
            return file.length();
        }

        private a(File file, long j, int i) {
            this.c = Collections.synchronizedMap(new HashMap());
            this.f = file;
            this.e = j;
            this.f8629a = i;
            this.b = new AtomicLong();
            this.d = new AtomicInteger();
            this.i = new ThreadPoolExecutor(2, 4, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(2), new c());
            c();
        }
    }

    static class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean c(String str) {
            return b(a(str));
        }

        private static byte[] a(String str) {
            try {
                return str.getBytes("utf-8");
            } catch (UnsupportedEncodingException e) {
                com.huawei.phoneservice.faq.base.util.h.e(AsCache.TAG, "UnsupportedEncodingException " + e.getMessage());
                return new byte[0];
            }
        }

        private static boolean b(byte[] bArr) {
            String[] strArrD = d(bArr);
            if (strArrD == null || strArrD.length != 2) {
                return false;
            }
            String strSubstring = strArrD[0];
            while (strSubstring.startsWith("0")) {
                strSubstring = strSubstring.substring(1);
            }
            return System.currentTimeMillis() > Long.parseLong(strSubstring) + (Long.parseLong(strArrD[1]) * 1000);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String e(String str) {
            return (str == null || !c(a(str))) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        private static boolean c(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && a(bArr, AsCache.SEPARATOR) > 14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String e(int i, String str) {
            return a(i) + str;
        }

        private static String[] d(byte[] bArr) {
            return c(bArr) ? new String[]{new String(a(bArr, 0, 13)), new String(a(bArr, 14, a(bArr, AsCache.SEPARATOR)))} : new String[0];
        }

        private static byte[] a(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }

        private static String a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append("");
            while (true) {
                String string = sb.toString();
                if (string.length() >= 13) {
                    return string + Constants.LINK + i + AsCache.SEPARATOR;
                }
                StringBuilder sb2 = new StringBuilder("0");
                sb2.append(string);
                sb = sb2;
            }
        }

        private static int a(byte[] bArr, char c) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == c) {
                    return i;
                }
            }
            return -1;
        }
    }

    public boolean remove(String str) {
        return this.mCache.b(str);
    }

    public void put(String str, String str2, int i) throws Throwable {
        put(str, c.e(i, str2));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:64|3)|(2:66|4)|(4:68|5|60|6)|58|31|35|36|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
    
        com.huawei.phoneservice.faq.base.util.h.e(com.huawei.phoneservice.feedbackcommon.utils.AsCache.TAG, r7.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void put(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "AsCache"
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$a r1 = r5.mCache
            java.io.File r6 = com.huawei.phoneservice.feedbackcommon.utils.AsCache.a.c(r1, r6)
            r1 = 0
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L31
            r4 = 1024(0x400, float:1.435E-42)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L31
            r3.write(r7)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r3.flush()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r2.flush()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r3.close()     // Catch: java.io.IOException -> L22
            goto L60
        L22:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r7)
            goto L60
        L2b:
            r7 = move-exception
            goto L74
        L2d:
            r7 = move-exception
            goto L33
        L2f:
            r7 = move-exception
            goto L75
        L31:
            r7 = move-exception
            r3 = r1
        L33:
            r1 = r2
            goto L3a
        L35:
            r7 = move-exception
            r2 = r1
            goto L75
        L38:
            r7 = move-exception
            r3 = r1
        L3a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72
            java.lang.String r4 = "put failed "
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L72
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L72
            r2.append(r7)     // Catch: java.lang.Throwable -> L72
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L72
            com.huawei.phoneservice.faq.base.util.h.e(r0, r7)     // Catch: java.lang.Throwable -> L72
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.io.IOException -> L55
            goto L5d
        L55:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r7)
        L5d:
            if (r1 == 0) goto L6c
            r2 = r1
        L60:
            r2.close()     // Catch: java.io.IOException -> L64
            goto L6c
        L64:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r7)
        L6c:
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$a r7 = r5.mCache
            com.huawei.phoneservice.feedbackcommon.utils.AsCache.a.a(r7, r6)
            return
        L72:
            r7 = move-exception
            r2 = r1
        L74:
            r1 = r3
        L75:
            if (r1 == 0) goto L83
            r1.close()     // Catch: java.io.IOException -> L7b
            goto L83
        L7b:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r1)
        L83:
            if (r2 == 0) goto L91
            r2.close()     // Catch: java.io.IOException -> L89
            goto L91
        L89:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r1)
        L91:
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$a r0 = r5.mCache
            com.huawei.phoneservice.feedbackcommon.utils.AsCache.a.a(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.AsCache.put(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void put(android.content.Context r5, java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "AsCache"
            java.io.File r1 = new java.io.File
            java.io.File r5 = r5.getCacheDir()
            java.lang.String r2 = "feedback"
            r1.<init>(r5, r2)
            boolean r5 = r1.exists()
            if (r5 != 0) goto L16
            r1.mkdirs()
        L16:
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$a r5 = r4.mCache
            java.io.File r5 = com.huawei.phoneservice.feedbackcommon.utils.AsCache.a.c(r5, r6)
            r6 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4f
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4f
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r2.write(r7)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r2.flush()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r1.flush()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r2.close()     // Catch: java.io.IOException -> L36
            goto L77
        L36:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r6)
            goto L77
        L3f:
            r6 = move-exception
            goto L8c
        L41:
            r6 = move-exception
            r7 = r6
            goto L4a
        L44:
            r7 = move-exception
            r2 = r6
        L46:
            r6 = r7
            goto L8c
        L48:
            r7 = move-exception
            r2 = r6
        L4a:
            r6 = r1
            goto L51
        L4c:
            r7 = move-exception
            r1 = r6
            goto L8e
        L4f:
            r7 = move-exception
            r2 = r6
        L51:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89
            java.lang.String r3 = "put failed "
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L89
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L89
            r1.append(r7)     // Catch: java.lang.Throwable -> L89
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L89
            com.huawei.phoneservice.faq.base.util.h.e(r0, r7)     // Catch: java.lang.Throwable -> L89
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.io.IOException -> L6c
            goto L74
        L6c:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r7)
        L74:
            if (r6 == 0) goto L83
            r1 = r6
        L77:
            r1.close()     // Catch: java.io.IOException -> L7b
            goto L83
        L7b:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r6)
        L83:
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$a r6 = r4.mCache
            com.huawei.phoneservice.feedbackcommon.utils.AsCache.a.a(r6, r5)
            return
        L89:
            r7 = move-exception
            r1 = r6
            goto L46
        L8c:
            r7 = r6
            r6 = r2
        L8e:
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.io.IOException -> L94
            goto L9c
        L94:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r6)
        L9c:
            if (r1 == 0) goto Laa
            r1.close()     // Catch: java.io.IOException -> La2
            goto Laa
        La2:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.h.e(r0, r6)
        Laa:
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$a r6 = r4.mCache
            com.huawei.phoneservice.feedbackcommon.utils.AsCache.a.a(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.AsCache.put(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.BufferedReader] */
    public String getAsString(String str) throws Throwable {
        BufferedReader bufferedReader;
        File fileA = this.mCache.a(str);
        ?? Exists = fileA.exists();
        ?? r4 = 0;
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(fileA));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = sb.toString();
                    if (!c.c(string)) {
                        String strE = c.e(string);
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            com.huawei.phoneservice.faq.base.util.h.e(TAG, "getAsString failed " + e2.getMessage());
                        }
                        return strE;
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        com.huawei.phoneservice.faq.base.util.h.e(TAG, "getAsString failed " + e3.getMessage());
                    }
                    remove(str);
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    com.huawei.phoneservice.faq.base.util.h.e(TAG, "getAsString failed " + e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            com.huawei.phoneservice.faq.base.util.h.e(TAG, "getAsString failed " + e5.getMessage());
                        }
                    }
                    return null;
                }
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                if (r4 != 0) {
                    try {
                        r4.close();
                    } catch (IOException e7) {
                        com.huawei.phoneservice.faq.base.util.h.e(TAG, "getAsString failed " + e7.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r4 = Exists;
        }
    }

    private static String myPid() {
        return "_" + Process.myPid();
    }

    public static AsCache get(File file, long j, int i) throws IOException, RuntimeException {
        AsCache asCache = mInstanceMap.get(file.getAbsoluteFile() + myPid());
        if (asCache != null) {
            return asCache;
        }
        AsCache asCache2 = new AsCache(file, j, i);
        mInstanceMap.put(file.getCanonicalPath() + myPid(), asCache2);
        return asCache2;
    }

    public static AsCache get(Context context, String str) throws IOException, RuntimeException {
        return get(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    private AsCache(File file, long j, int i) throws IOException {
        if (file.exists() || file.mkdirs()) {
            this.mCache = new a(file, j, i);
        } else {
            throw new IOException("can't make dirs in " + file.getCanonicalPath());
        }
    }
}
