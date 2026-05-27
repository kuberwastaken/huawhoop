package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class ZipUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8994a = "ZipUtil";
    private static final int b = 104857600;
    private static final int c = 100;
    private static final int d = 6000;
    private static final int e = 4096;
    private static final String[] f = {"\\..", "/..", "..\\", FeedbackWebConstants.INVALID_FILE_NAME_PRE, "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    private static void a(boolean z, File file) {
        if (z && file.exists() && file.isFile()) {
            f(file);
        }
    }

    private static ZipFile b(boolean z, File file) throws IOException {
        if (!z) {
            return new ZipFile(file);
        }
        LogsUtil.i(f8994a, "not a utf8 zip file, use gbk open zip file : " + file);
        return new ZipFile(file, Charset.forName("GBK"));
    }

    private static boolean c(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!b(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(f8994a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(str);
    }

    private static String e(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(iLastIndexOf + 1);
    }

    private static String f(String str) {
        return str.replaceAll("\\\\", "/");
    }

    private static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f8994a, "isContainInvalidStr: name is null");
            return false;
        }
        for (String str2 : f) {
            if (str.toUpperCase(Locale.ROOT).contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static String h(String str) {
        String str2 = File.separator;
        return (!str.endsWith(str2) || str.length() <= str2.length()) ? str : str.substring(0, str.length() - str2.length());
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE, 100, z);
    }

    public static List<File> unZipWithFilter(String str, String str2, boolean z, FilenameFilter filenameFilter) throws SecurityCommonException {
        return unZipWithFilter(str, str2, Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE, 100, z, filenameFilter, 6000);
    }

    private static void d(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(f8994a, "delete file error");
    }

    private static void f(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            d(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                d(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                f(file2);
            }
            d(file);
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, long j, int i, boolean z) throws Throwable {
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        boolean z2 = false;
        if (!a(str, str2, j, i, (FilenameFilter) null, i)) {
            return false;
        }
        String strH = h(str2);
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        ZipInputStream zipInputStream2 = null;
        ZipInputStream zipInputStream3 = null;
        fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                ZipInputStream zipInputStream4 = new ZipInputStream(new BufferedInputStream(fileInputStream));
                long jA = 0;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream4.getNextEntry();
                        if (nextEntry == null) {
                            z2 = true;
                            break;
                        }
                        String strReplaceAll = nextEntry.getName().replaceAll("\\\\", "/");
                        if (!a(strReplaceAll)) {
                            break;
                        }
                        File file = new File(strH, strReplaceAll);
                        if (z || !file.exists() || !file.isFile()) {
                            a(z, file);
                            if (!a(nextEntry, file, arrayList)) {
                                a(file);
                                jA = a(file, zipInputStream4, jA, j, arrayList);
                                zipInputStream4.closeEntry();
                                if (jA < 0) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        zipInputStream2 = zipInputStream4;
                        zipInputStream = zipInputStream2;
                        fileInputStream2 = fileInputStream;
                        try {
                            LogsUtil.e(f8994a, "Unzip IOException : " + e.getMessage());
                            a(fileInputStream2, zipInputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            zipInputStream3 = zipInputStream;
                            a(fileInputStream, zipInputStream3);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zipInputStream3 = zipInputStream4;
                        a(fileInputStream, zipInputStream3);
                        throw th;
                    }
                }
                a(fileInputStream, zipInputStream4);
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e4) {
            e = e4;
            zipInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipInputStream = null;
            fileInputStream = fileInputStream2;
            zipInputStream3 = zipInputStream;
            a(fileInputStream, zipInputStream3);
            throw th;
        }
        if (!z2) {
            a(arrayList);
        }
        return z2;
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        return unZipWithFilter(str, str2, j, i, z, null, i);
    }

    public static List<File> unZipWithFilter(String str, String str2, long j, int i, boolean z, FilenameFilter filenameFilter, int i2) throws SecurityCommonException {
        if (!a(str, str2, j, i, filenameFilter, i2)) {
            return null;
        }
        String str3 = File.separator;
        if (str2.endsWith(str3) && str2.length() > str3.length()) {
            str2 = str2.substring(0, str2.length() - str3.length());
        }
        File fileD = d(str);
        File fileD2 = d(str2);
        if (fileD == null || fileD2 == null) {
            return null;
        }
        return a(fileD, fileD2, j, z, false, filenameFilter);
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return;
        }
        e(parentFile);
    }

    private static void b(String str) {
        if (TextUtils.isEmpty(str) || !g(str)) {
            return;
        }
        Log.e(f8994a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static boolean a(ZipEntry zipEntry, File file, List<File> list) {
        if (!zipEntry.isDirectory()) {
            return false;
        }
        e(file);
        list.add(file);
        return true;
    }

    private static void e(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(f8994a, "mkdirs error , files exists or IOException.");
    }

    private static boolean a(String str) {
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKC);
        if (!g(strNormalize)) {
            return true;
        }
        Log.e(f8994a, "zipPath is a invalid path: " + e(strNormalize));
        return false;
    }

    private static boolean b(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static File c(String str) {
        b(str);
        return new File(str);
    }

    private static long a(File file, ZipInputStream zipInputStream, long j, long j2, List<File> list) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        List<File> list2;
        byte[] bArr = new byte[4096];
        long j3 = -1;
        FileOutputStream fileOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        BufferedOutputStream bufferedOutputStream4 = null;
        fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                long j4 = j;
                while (true) {
                    try {
                        int i = zipInputStream.read(bArr, 0, 4096);
                        if (i == -1) {
                            list2 = list;
                            break;
                        }
                        j4 += (long) i;
                        if (j4 > j2) {
                            Log.e(f8994a, "unzip  over than top size");
                            list2 = list;
                            j4 = -1;
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, i);
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream3 = bufferedOutputStream2;
                        bufferedOutputStream = bufferedOutputStream3;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            LogsUtil.e(f8994a, "Unzip IOException : " + e.getMessage());
                            bufferedOutputStream2 = bufferedOutputStream;
                            fileOutputStream = fileOutputStream2;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            bufferedOutputStream4 = bufferedOutputStream;
                            IOUtil.closeSecure((OutputStream) bufferedOutputStream4);
                            IOUtil.closeSecure((OutputStream) fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream4 = bufferedOutputStream2;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream4);
                        IOUtil.closeSecure((OutputStream) fileOutputStream);
                        throw th;
                    }
                }
                list2.add(file);
                bufferedOutputStream2.flush();
                j3 = j4;
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            fileOutputStream = fileOutputStream2;
            bufferedOutputStream4 = bufferedOutputStream;
            IOUtil.closeSecure((OutputStream) bufferedOutputStream4);
            IOUtil.closeSecure((OutputStream) fileOutputStream);
            throw th;
        }
        IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
        return j3;
    }

    private static String a(ZipEntry zipEntry) {
        return Normalizer.normalize(zipEntry.getName(), Normalizer.Form.NFKC);
    }

    private static int a(ZipEntry zipEntry, List<File> list, File file, boolean z, FilenameFilter filenameFilter) {
        if (TextUtils.isEmpty(zipEntry.getName())) {
            return 1;
        }
        String strA = a(zipEntry);
        if (g(strA)) {
            Log.e(f8994a, "zipPath is a invalid path: " + e(strA));
            return -1;
        }
        String strF = f(strA);
        if (filenameFilter != null && !filenameFilter.accept(file, strF)) {
            return 1;
        }
        File file2 = new File(file, strF);
        if (!z && file2.exists() && file2.isFile()) {
            return 1;
        }
        if (z && file2.exists() && file2.isFile()) {
            f(file2);
        }
        list.add(file2);
        return 0;
    }

    private static long a(ZipEntry zipEntry, File file, long j, long j2, ZipFile zipFile) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        File file2 = new File(file, f(a(zipEntry)));
        if (zipEntry.isDirectory()) {
            if (!b(file2)) {
                return 1L;
            }
        } else {
            if (!c(file2)) {
                return 1L;
            }
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = bufferedInputStream2.read(bArr);
                                if (i == -1) {
                                    IOUtil.closeSecure((InputStream) bufferedInputStream2);
                                    IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                    IOUtil.closeSecure((OutputStream) fileOutputStream);
                                    break;
                                }
                                j += (long) i;
                                if (j > j2) {
                                    Log.e(f8994a, "unzipFileNew: over than top size");
                                    IOUtil.closeSecure((InputStream) bufferedInputStream2);
                                    IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                    IOUtil.closeSecure((OutputStream) fileOutputStream);
                                    return -1L;
                                }
                                bufferedOutputStream.write(bArr, 0, i);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream = bufferedInputStream2;
                            IOUtil.closeSecure((InputStream) bufferedInputStream);
                            IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                            IOUtil.closeSecure((OutputStream) fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                bufferedOutputStream = null;
            }
        }
        return j;
    }

    private static void a(boolean z, List<File> list) {
        if (z) {
            return;
        }
        a(list);
        list.clear();
    }

    private static List<File> a(File file, File file2, long j, boolean z, boolean z2, FilenameFilter filenameFilter) throws Throwable {
        ZipFile zipFileB;
        ArrayList arrayList = new ArrayList();
        boolean z3 = true;
        ZipFile zipFile = null;
        try {
            zipFileB = b(z2, file);
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFileB.entries();
            long jA = 0;
            while (enumerationEntries.hasMoreElements()) {
                try {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    int iA = a(zipEntryNextElement, arrayList, file2, z, filenameFilter);
                    if (iA != -1) {
                        if (iA != 1) {
                            jA = a(zipEntryNextElement, file2, jA, j, zipFileB);
                            if (jA == 1) {
                                IOUtil.closeSecure(zipFileB);
                                a(false, (List<File>) arrayList);
                                return null;
                            }
                            if (jA == -1) {
                            }
                        }
                    }
                    z3 = false;
                    break;
                } catch (IllegalArgumentException e3) {
                    LogsUtil.i(f8994a, "not a utf8 zip file, IllegalArgumentException : " + e3.getMessage());
                    List<File> listA = a(file, file2, j, z, true, filenameFilter);
                    IOUtil.closeSecure(zipFileB);
                    a(true, (List<File>) arrayList);
                    return listA;
                }
            }
            IOUtil.closeSecure(zipFileB);
            a(z3, arrayList);
        } catch (IOException e4) {
            e = e4;
            zipFile = zipFileB;
            try {
                Log.e(f8994a, "unzip new IOException : " + e.getMessage());
                IOUtil.closeSecure(zipFile);
                a(false, (List<File>) arrayList);
            } catch (Throwable th2) {
                th = th2;
                z3 = false;
                IOUtil.closeSecure(zipFile);
                a(z3, arrayList);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = zipFileB;
            IOUtil.closeSecure(zipFile);
            a(z3, arrayList);
            throw th;
        }
        return arrayList;
    }

    private static boolean a(String str, File file, long j, int i, boolean z, FilenameFilter filenameFilter, int i2) throws Throwable {
        ZipFile zipFile;
        boolean zA;
        ZipFile zipFile2;
        ZipFile zipFile3 = null;
        try {
            try {
                if (!z) {
                    zipFile2 = new ZipFile(str);
                } else {
                    LogsUtil.i(f8994a, "not a utf8 zip file, use gbk open zip file : " + str);
                    zipFile2 = new ZipFile(str, Charset.forName("GBK"));
                }
                zipFile = zipFile2;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
            zipFile = zipFile3;
        }
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            long j2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (enumerationEntries.hasMoreElements()) {
                try {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    long size = zipEntryNextElement.getSize();
                    String name = zipEntryNextElement.getName();
                    if (filenameFilter == null || filenameFilter.accept(file, name)) {
                        j2 += size;
                        i3++;
                    }
                    i4++;
                    if (!g(name) && i4 < i2 && i3 < i && j2 <= j && zipEntryNextElement.getSize() != -1) {
                    }
                    LogsUtil.e(f8994a, "File name is invalid or too many files or too big");
                    zA = false;
                    break;
                } catch (IllegalArgumentException e3) {
                    LogsUtil.i(f8994a, "not a utf8 zip file, IllegalArgumentException : " + e3.getMessage());
                    zA = a(str, file, j, i, true, filenameFilter, i2);
                }
            }
            zA = true;
            try {
                zipFile.close();
                return zA;
            } catch (IOException unused) {
                LogsUtil.e(f8994a, "close zipFile IOException ");
                return zA;
            }
        } catch (IOException e4) {
            e = e4;
            zipFile3 = zipFile;
            LogsUtil.e(f8994a, "not a valid zip file, IOException : " + e.getMessage());
            if (zipFile3 != null) {
                try {
                    zipFile3.close();
                } catch (IOException unused2) {
                    zA = false;
                    LogsUtil.e(f8994a, "close zipFile IOException ");
                    return zA;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException unused3) {
                    LogsUtil.e(f8994a, "close zipFile IOException ");
                }
            }
            throw th;
        }
    }

    private static boolean a(String str, String str2, long j, int i, FilenameFilter filenameFilter, int i2) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !g(str)) {
            if (!TextUtils.isEmpty(str2) && !g(str2)) {
                if (a(str, new File(str2), j, i, false, filenameFilter, i2)) {
                    return true;
                }
                LogsUtil.e(f8994a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(f8994a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(f8994a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(f8994a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, ZipInputStream zipInputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
    }
}
