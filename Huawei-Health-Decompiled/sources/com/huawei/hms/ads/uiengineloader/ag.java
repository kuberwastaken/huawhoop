package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4555a = "_multiKitLoadNative";
    private static final String b = "com.huawei.hms.runtimekit.container.kitsdk.KitContext";
    private static ThreadPoolExecutor c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(File file) {
        boolean z;
        if (c(file)) {
            z = true;
            for (File file2 : file.listFiles()) {
                z = z && d(file2);
            }
        } else {
            z = true;
        }
        return z ? z && file.delete() : z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file) {
        return file.exists() && file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0;
    }

    private static boolean b(Context context) {
        try {
            return context.getClassLoader().loadClass(b) != null;
        } catch (ClassNotFoundException unused) {
            af.b(f4555a, "The cp is not hms kit.");
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.StringBuilder] */
    private static String b(Context context, String str, String str2, PackageInfo packageInfo) throws Throwable {
        Throwable th;
        ?? r7;
        String strSubstring;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.createDeviceProtectedStorageContext().getFilesDir().getCanonicalPath() + File.separator + "modules");
                sb.append(File.separator);
                sb.append(packageInfo.packageName);
                context = sb.toString();
                try {
                    strSubstring = str2.substring(str2.lastIndexOf(File.separator) + 1);
                    zipFile = new ZipFile(str);
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile2;
                r7 = context;
            }
        } catch (Exception unused2) {
            context = 0;
        } catch (Throwable th3) {
            th = th3;
            r7 = 0;
        }
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            HashSet hashSet = new HashSet();
            ac.a(enumerationEntries, hashSet, strSubstring);
            if (hashSet.size() <= 0) {
                af.b(f4555a, "native is empty");
                a(zipFile, (String) context, packageInfo, true);
                return str2;
            }
            String str3 = context + File.separator + packageInfo.versionCode + File.separator + "lib" + File.separator + strSubstring;
            if (new File(str3).exists() || ac.a(zipFile, hashSet, str3) == 0) {
                a(zipFile, (String) context, packageInfo, true);
                return str3;
            }
            af.b(f4555a, "the apk decompress fail");
            a(zipFile, (String) context, packageInfo, false);
            return str2;
        } catch (Exception unused3) {
            zipFile2 = zipFile;
            af.c(f4555a, "catch IOException");
            a(zipFile2, (String) context, packageInfo, true);
            return str2;
        } catch (Throwable th4) {
            th = th4;
            zipFile2 = zipFile;
            r7 = context;
            a(zipFile2, (String) r7, packageInfo, true);
            throw th;
        }
    }

    private static void a(ZipFile zipFile, String str, PackageInfo packageInfo, boolean z) {
        aj.a(zipFile);
        try {
            if (TextUtils.isEmpty(str) || packageInfo.versionCode <= 0) {
                return;
            }
            a(str, packageInfo.versionCode, z);
        } catch (Exception unused) {
            af.c(f4555a, "IOException:");
        }
    }

    private static void a(final String str, final int i, final boolean z) {
        c.execute(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.ag.1
            @Override // java.lang.Runnable
            public final void run() {
                File file = new File(str);
                String string = Integer.toString(i);
                if (ag.c(file)) {
                    for (File file2 : file.listFiles()) {
                        if (!z || !file2.getPath().contains(string)) {
                            StringBuilder sb = ag.d(file2) ? new StringBuilder(" delete success : ") : new StringBuilder(" delete failed : ");
                            sb.append(file2.getName());
                            af.b(ag.f4555a, sb.toString());
                        }
                    }
                }
            }
        });
    }

    public static String a(Context context, String str, String str2, PackageInfo packageInfo) {
        af.b(f4555a, " generaNewNativePath");
        if (!b(context)) {
            return str2;
        }
        if (!TextUtils.isEmpty(str2) && str2.contains(File.separator)) {
            return b(context, str, str2, packageInfo);
        }
        af.b(f4555a, "nativePath is empty or error");
        return str2;
    }

    private static String a(Context context) throws IOException {
        return context.createDeviceProtectedStorageContext().getFilesDir().getCanonicalPath() + File.separator + "modules";
    }
}
