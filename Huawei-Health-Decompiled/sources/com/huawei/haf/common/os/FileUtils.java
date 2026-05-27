package com.huawei.haf.common.os;

import android.os.Build;
import com.huawei.haf.common.exception.ExceptionUtils;
import health.compact.a.LogUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/* JADX INFO: loaded from: classes.dex */
public final class FileUtils {
    private FileUtils() {
    }

    public static long e(File file, File file2) throws IOException {
        h(file);
        b(file2, true);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                long jD = d(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
                return jD;
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long e(InputStream inputStream, File file) throws IOException {
        b(file, true);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            long jD = d(inputStream, fileOutputStream);
            fileOutputStream.close();
            return jD;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long d(InputStream inputStream, OutputStream outputStream) throws IOException {
        long jCopy;
        if (Build.VERSION.SDK_INT >= 29) {
            jCopy = android.os.FileUtils.copy(inputStream, outputStream);
        } else {
            byte[] bArr = new byte[8192];
            long j = 0;
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                outputStream.write(bArr, 0, i);
                j += (long) i;
            }
            jCopy = j;
        }
        outputStream.flush();
        if (outputStream instanceof FileOutputStream) {
            ((FileOutputStream) outputStream).getFD().sync();
        }
        return jCopy;
    }

    public static void e(File[] fileArr, File file) throws IOException {
        b(file, true);
        FileInputStream fileInputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                for (File file2 : fileArr) {
                    if (file2 == null) {
                        LogUtil.b("HAF_FileUtils", "mergeFiles, file is null");
                    } else {
                        h(file2);
                        FileInputStream fileInputStream2 = new FileInputStream(file2);
                        while (true) {
                            try {
                                int i = fileInputStream2.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                        a(fileInputStream2);
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
            }
        } finally {
            a(fileInputStream);
        }
    }

    public static void d(File file, File file2, boolean z) throws IOException {
        h(file);
        b(file2, z);
        if (file.renameTo(file2)) {
            return;
        }
        e(file, file2);
        if (e(file)) {
            return;
        }
        throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
    }

    private static void b(File file, boolean z) throws IOException {
        a(file, true, z);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.mkdirs() || parentFile.isDirectory()) {
            return;
        }
        throw new IOException("Destination '" + parentFile + "' directory cannot be created");
    }

    private static void h(File file) throws IOException {
        if (!file.exists()) {
            throw new IOException("Source file '" + file + "' is not exists");
        }
        if (file.isDirectory()) {
            throw new IOException("Source file '" + file + "' is directory");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.io.File r2, boolean r3, boolean r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "Destination file '"
            if (r4 != 0) goto L22
            boolean r4 = r2.exists()
            if (r4 != 0) goto Lb
            goto L22
        Lb:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r2)
            java.lang.String r2 = "' already exists"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L22:
            boolean r4 = r2.isDirectory()
            if (r4 == 0) goto L2d
            if (r3 == 0) goto L32
            java.lang.String r3 = "' is directory"
            goto L33
        L2d:
            if (r3 != 0) goto L32
            java.lang.String r3 = "' is file"
            goto L33
        L32:
            r3 = 0
        L33:
            if (r3 != 0) goto L36
            return
        L36:
            java.io.IOException r4 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = r1.toString()
            r4.<init>(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.haf.common.os.FileUtils.a(java.io.File, boolean, boolean):void");
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                LogUtil.d("HAF_FileUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static void c(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception unused) {
                LogUtil.d("HAF_FileUtils", "An exception occurred while closing the 'AutoCloseable' object.");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        return r0.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r7, long r8) throws java.io.IOException {
        /*
            h(r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 2048(0x800, float:2.87E-42)
            r0.<init>(r1)
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
        Lf:
            r3 = 3
            if (r2 >= r3) goto L6a
            long r3 = r7.length()
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 > 0) goto L4e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.IOException -> L30
            r3.<init>(r7)     // Catch: java.io.IOException -> L30
            e(r3, r0, r1, r8)     // Catch: java.lang.Throwable -> L26
            r3.close()     // Catch: java.io.IOException -> L30
            goto L6a
        L26:
            r4 = move-exception
            r3.close()     // Catch: java.lang.Throwable -> L2b
            goto L2f
        L2b:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch: java.io.IOException -> L30
        L2f:
            throw r4     // Catch: java.io.IOException -> L30
        L30:
            r3 = move-exception
            r4 = 2
            if (r2 >= r4) goto L4d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.String r5 = ", ex="
            java.lang.String r3 = health.compact.a.LogUtil.c(r3)
            java.lang.String r6 = "readContentFromFile num="
            java.lang.Object[] r3 = new java.lang.Object[]{r6, r4, r5, r3}
            java.lang.String r4 = "HAF_FileUtils"
            health.compact.a.LogUtil.d(r4, r3)
            int r2 = r2 + 1
            goto Lf
        L4d:
            throw r3
        L4e:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "file too length, length="
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = ", maxLength="
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L6a:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.haf.common.os.FileUtils.a(java.io.File, long):java.lang.String");
    }

    public static String a(InputStream inputStream, long j) throws IOException {
        StringBuilder sb = new StringBuilder(2048);
        e(inputStream, sb, new byte[1024], j);
        return sb.toString();
    }

    private static void e(InputStream inputStream, StringBuilder sb, byte[] bArr, long j) throws IOException {
        sb.delete(0, sb.length());
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            }
            String str = new String(bArr, 0, i, StandardCharsets.UTF_8);
            int length = sb.length() + str.length();
            if (length > j) {
                throw new IOException("read data too length, length=" + length + ", maxLength=" + j);
            }
            sb.append(str);
        }
    }

    public static boolean d(File file, boolean z) {
        try {
            e(file, z);
        } catch (IOException e) {
            LogUtil.b("HAF_FileUtils", "createNewFile, ex=", LogUtil.c(e));
        }
        return file.exists();
    }

    public static void e(File file, boolean z) throws IOException {
        if (file == null || file.exists()) {
            if (z) {
                j(file);
                return;
            }
            return;
        }
        IOException e = null;
        int i = 0;
        boolean z2 = false;
        while (i < 3 && !z2) {
            i++;
            try {
                if (!file.createNewFile()) {
                    LogUtil.b("HAF_FileUtils", "File ", file.getPath(), " already exists");
                }
                if (z) {
                    j(file);
                }
                z2 = true;
            } catch (IOException e2) {
                e = e2;
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        throw new IOException("Failed to create file " + file.getPath(), e);
    }

    public static boolean e(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        int i = 0;
        boolean z = false;
        while (i < 3 && !z) {
            i++;
            if (file.delete()) {
                z = true;
            }
        }
        if (!z) {
            if (!file.exists()) {
                return true;
            }
            LogUtil.b("HAF_FileUtils", "Failed to delete file: ", file.getPath());
        }
        return z;
    }

    public static File c(File file) {
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            LogUtil.b("HAF_FileUtils", "mkdirs fail, dir=", file.getPath());
        }
        return file;
    }

    public static void b(File file) {
        c(file, true);
    }

    public static void c(File file, boolean z) {
        if (file != null && file.exists() && file.isDirectory()) {
            a(file, z);
        }
    }

    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        a(file, true);
    }

    public static void d(File file, FilenameFilter filenameFilter) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = filenameFilter != null ? file.listFiles(filenameFilter) : file.listFiles();
            if (fileArrListFiles == null) {
                LogUtil.b("HAF_FileUtils", "list files is null");
                return;
            }
            for (File file2 : fileArrListFiles) {
                a(file2, true);
            }
        }
    }

    private static void a(File file, boolean z) {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    a(file2, true);
                }
                if (z) {
                    g(file);
                    return;
                }
                return;
            }
            return;
        }
        g(file);
    }

    public static boolean g(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        boolean zDelete = file.delete();
        if (!zDelete && file.exists()) {
            LogUtil.b("HAF_FileUtils", "Failed to delete file, try to delete when exit. path: ", file.getPath());
            file.deleteOnExit();
        }
        return zDelete;
    }

    public static boolean d(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static boolean j(File file) {
        boolean z = false;
        if (file == null || !file.exists()) {
            return false;
        }
        try {
            boolean readOnly = file.setReadOnly();
            if (readOnly) {
                return readOnly;
            }
            try {
                LogUtil.b("HAF_FileUtils", "setReadOnly failed. path:", file.getPath());
                return readOnly;
            } catch (SecurityException e) {
                e = e;
                z = readOnly;
                LogUtil.d("HAF_FileUtils", "setReadOnly ex=", LogUtil.c(e));
                return z;
            }
        } catch (SecurityException e2) {
            e = e2;
        }
    }

    public static long i(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return k(file);
    }

    private static long k(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        try {
            return FileVisitUtils.e(file.toPath());
        } catch (IOException e) {
            LogUtil.b("HAF_FileUtils", "sizeOfDirectory ", file.getPath(), " fail, ex=", LogUtil.c(e));
            return m(file);
        }
    }

    private static long m(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        long jK = 0;
        for (File file2 : fileArrListFiles) {
            if (!f(file2)) {
                jK += k(file2);
                if (jK < 0) {
                    break;
                }
            }
        }
        return jK;
    }

    private static boolean f(File file) {
        return Files.isSymbolicLink(file.toPath());
    }

    public static File e(File file, String str) throws IOException {
        try {
            File canonicalFile = new File(file, str).getCanonicalFile();
            if (canonicalFile.getPath().startsWith(file.getCanonicalPath())) {
                return canonicalFile;
            }
            throw new IOException("Possible path traversa issues. path=" + str);
        } catch (IOException e) {
            LogUtil.d("HAF_FileUtils", "getSafeFile ex=", ExceptionUtils.a(e));
            throw e;
        }
    }

    public static boolean c(File file, String str) {
        File fileE;
        try {
            fileE = e(file, str);
        } catch (IOException unused) {
            fileE = null;
        }
        return fileE != null;
    }
}
