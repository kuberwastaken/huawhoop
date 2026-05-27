package com.huawei.wisecloud.drmclient.utils;

import android.text.TextUtils;
import com.huawei.wisecloud.drmclient.exception.HwDrmException;
import com.huawei.wisecloud.drmclient.license.HwDrmConstant;
import com.huawei.wisecloud.drmclient.log.HwDrmLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import ohos.ace.plugin.taskmanagerplugin.EventType;

/* JADX INFO: loaded from: classes8.dex */
public class FileUtil {
    private static final int LICENSE_SIZE_LIMIT = 100;
    private static final String TAG = "FileUtil";

    public static void saveStrToLicenseFile(String str, String str2, String str3) throws Throwable {
        saveStrToFile(str, str3 + File.separator + str2);
    }

    public static void saveStrToFile(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            try {
                File file = new File(str2);
                if (file.exists() && !file.delete()) {
                    HwDrmLog.e("FileUtil", "delete file " + getFileName(str2) + EventType.FAILED);
                }
                if (!file.createNewFile()) {
                    HwDrmLog.e("FileUtil", "createNewFile file " + getFileName(str2) + EventType.FAILED);
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(str.getBytes(HwDrmConstant.DRM_CHARSET));
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                    HwDrmLog.e("FileUtil", "IOException: fail to close FileOutputStream");
                }
            } catch (FileNotFoundException e) {
                e = e;
                String str3 = "fail to save string to file, FileNotFoundException: " + HwDrmLog.printException((Exception) e);
                HwDrmLog.e("FileUtil", str3);
                throw new HwDrmException(str3);
            } catch (IOException e2) {
                e = e2;
                String str4 = "fail to save string to file, IOException: " + HwDrmLog.printException((Exception) e);
                HwDrmLog.e("FileUtil", str4);
                throw new HwDrmException(str4);
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        HwDrmLog.e("FileUtil", "IOException: fail to close FileOutputStream");
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }

    public static String getStrFromLicenseFile(String str, String str2) throws HwDrmException {
        return getStrFromFile(str2 + File.separator + str, 100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r9v1 */
    public static String getStrFromFile(String str, int i) throws Throwable {
        Throwable th;
        ?? r10;
        InputStreamReader inputStreamReader;
        IOException e;
        FileNotFoundException e2;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fileInputStream2 = null;
        bufferedReader = null;
        bufferedReader = null;
         = 0;
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        ?? r2 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(new File(str));
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, HwDrmConstant.DRM_CHARSET);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (FileNotFoundException e3) {
                        e2 = e3;
                    } catch (IOException e4) {
                        e = e4;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (FileNotFoundException e5) {
                    e2 = e5;
                } catch (IOException e6) {
                    e = e6;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                }
            } catch (Throwable th4) {
                th = th4;
                r2 = str;
                fileInputStream = null;
            }
            try {
                char[] cArr = new char[1024];
                int i2 = 0;
                while (true) {
                    int i3 = bufferedReader.read(cArr);
                    if (i3 == -1 || i2 == i) {
                        break;
                    }
                    stringBuffer.append(cArr, 0, i3);
                    i2++;
                }
                String string = stringBuffer.toString();
                closeResource(fileInputStream);
                closeResource(inputStreamReader);
                closeResource(bufferedReader);
                return string;
            } catch (FileNotFoundException e7) {
                e2 = e7;
                bufferedReader2 = bufferedReader;
                String str2 = "fail to read file, FileNotFoundException: " + HwDrmLog.printException((Exception) e2);
                HwDrmLog.e("FileUtil", str2);
                throw new HwDrmException(str2);
            } catch (IOException e8) {
                e = e8;
                bufferedReader3 = bufferedReader;
                String str3 = "fail to read file, IOException: " + HwDrmLog.printException((Exception) e);
                HwDrmLog.e("FileUtil", str3);
                throw new HwDrmException(str3);
            } catch (Throwable th5) {
                th = th5;
                r2 = bufferedReader;
                ?? r9 = r2;
                fileInputStream2 = fileInputStream;
                r10 = r9;
                closeResource(fileInputStream2);
                closeResource(inputStreamReader);
                closeResource(r10);
                throw th;
            }
        } catch (FileNotFoundException e9) {
            e2 = e9;
        } catch (IOException e10) {
            e = e10;
        } catch (Throwable th6) {
            th = th6;
            r10 = 0;
            inputStreamReader = null;
            closeResource(fileInputStream2);
            closeResource(inputStreamReader);
            closeResource(r10);
            throw th;
        }
    }

    private static void closeResource(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                HwDrmLog.e("FileUtil", "getFileContent IOException " + HwDrmLog.printException((Exception) e));
            }
        }
    }

    public static void deleteLicenseFile(String str, String str2) throws HwDrmException {
        deleteFile(str2 + File.separator + str);
    }

    public static void deleteFile(String str) throws HwDrmException {
        File file = new File(str);
        if (!file.exists()) {
            String str2 = "file not exist: " + getFileName(str);
            HwDrmLog.e("FileUtil", str2);
            throw new HwDrmException(str2);
        }
        if (file.isFile()) {
            boolean zDelete = file.delete();
            HwDrmLog.i("FileUtil", "file is deleted.");
            if (zDelete) {
                return;
            }
            String str3 = "fail to delete file: " + getFileName(str);
            HwDrmLog.e("FileUtil", str3);
            throw new HwDrmException(str3);
        }
    }

    public static String getFileName(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : substring(str, iLastIndexOf + 1);
    }

    public static String substring(String str, int i) {
        if (str == null || str.length() < i || i < 0) {
            return "";
        }
        try {
            return str.substring(i);
        } catch (Exception e) {
            HwDrmLog.e("FileUtil", "substring exception: " + HwDrmLog.printException(e));
            return "";
        }
    }
}
