package defpackage;

import android.text.TextUtils;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes6.dex */
public final class mls {
    private static boolean d(String str) {
        return new File(str).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static void d(String str, String str2, byte[] bArr) throws Throwable {
        Throwable th;
        ?? r5;
        Exception e;
        FileOutputStream fileOutputStream;
        File file;
        if (str == 0 || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || bArr == null) {
            mly.b("FileUtils", "parameter is null.", true);
            return;
        }
        try {
            try {
                file = new File((String) str);
            } catch (Throwable th2) {
                th = th2;
                r5 = str;
                c(r5, null, null);
                throw th;
            }
        } catch (FileNotFoundException unused) {
            fileOutputStream = null;
        } catch (IOException unused2) {
            fileOutputStream = null;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            r5 = 0;
            c(r5, null, null);
            throw th;
        }
        if (!file.exists() && !file.mkdirs()) {
            mly.b("FileUtils", "file is not existence.", true);
            c(null, null, null);
            return;
        }
        String str3 = ((String) str) + str2;
        if (g(str3)) {
            fileOutputStream = new FileOutputStream(new File(str3));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                str = fileOutputStream;
            } catch (FileNotFoundException unused3) {
                mly.b("FileUtils", "FileNotFoundException", true);
                str = fileOutputStream;
            } catch (IOException unused4) {
                mly.b("FileUtils", "IOException", true);
                str = fileOutputStream;
            } catch (Exception e3) {
                e = e3;
                mly.b("FileUtils", "Exception:" + e.getClass().getSimpleName(), true);
                str = fileOutputStream;
            }
            c(str, null, null);
        }
        mly.b("FileUtils", "file path is invalid.", true);
        str = 0;
        c(str, null, null);
    }

    private static boolean g(String str) throws IllegalArgumentException, UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            mly.b("FileUtils", "filePath is empty.", true);
            return false;
        }
        String strDecode = URLDecoder.decode(str, "utf-8");
        return (strDecode.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || strDecode.contains("./") || strDecode.contains("%00") || strDecode.contains("..")) ? false : true;
    }

    private static void c(FileOutputStream fileOutputStream, FileInputStream fileInputStream, InputStream inputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                mly.b("FileUtils", "fileOutputStream IOException" + e.getClass().getSimpleName(), true);
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                mly.b("FileUtils", "fileInputStream IOException" + e2.getClass().getSimpleName(), true);
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                mly.b("FileUtils", "inputStream IOException" + e3.getClass().getSimpleName(), true);
            }
        }
    }

    public static void b(String str) {
        b(new File(str));
    }

    private static void b(File file) {
        if (!file.exists()) {
            mly.b("FileUtils", "files is not existence.", true);
            return;
        }
        if (!file.isDirectory()) {
            mly.b("FileUtils", "files is not directory.", true);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            mly.b("FileUtils", "fileList is null.", true);
            return;
        }
        for (File file2 : fileArrListFiles) {
            boolean zDelete = file2.delete();
            mly.b("FileUtils", "result is " + zDelete, true);
            if (!zDelete) {
                return;
            }
        }
    }

    public static InputStream e(String str) throws Throwable {
        FileInputStream fileInputStream;
        if (!d(str)) {
            return null;
        }
        File file = new File(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        try {
            try {
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            c(null, fileInputStream, byteArrayInputStream);
                            return byteArrayInputStream;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (FileNotFoundException unused) {
                        mly.b("FileUtils", "FileNotFoundException", true);
                        c(null, fileInputStream, null);
                        return null;
                    } catch (IOException unused2) {
                        mly.b("FileUtils", "IOException", true);
                        c(null, fileInputStream, null);
                        return null;
                    } catch (IndexOutOfBoundsException unused3) {
                        mly.b("FileUtils", "IndexOutOfBoundsException", true);
                        c(null, fileInputStream, null);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                c(null, null, null);
                throw th;
            }
        } catch (FileNotFoundException unused4) {
            fileInputStream = null;
        } catch (IOException unused5) {
            fileInputStream = null;
        } catch (IndexOutOfBoundsException unused6) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            c(null, null, null);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.FileOutputStream] */
    public void e(String str, String str2, String str3) throws Throwable {
        FileOutputStream fileOutputStream;
        File file;
        if (str == null || TextUtils.isEmpty(str) || str2 == 0 || TextUtils.isEmpty(str2) || str3 == 0 || TextUtils.isEmpty(str3)) {
            mly.b("FileUtils", "parameter is null.", true);
            return;
        }
        try {
            try {
                file = new File((String) str2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException unused) {
            str2 = 0;
            fileOutputStream = null;
        } catch (IOException unused2) {
            str2 = 0;
            fileOutputStream = null;
        } catch (IndexOutOfBoundsException unused3) {
            str2 = 0;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            str2 = 0;
            str3 = 0;
        }
        if (!file.exists() && !file.mkdirs()) {
            mly.b("FileUtils", "new file is not existence.", true);
            c(null, null, null);
            return;
        }
        File file2 = new File(str);
        if (!file2.exists() && !file2.mkdirs()) {
            mly.b("FileUtils", "old file is not existence.", true);
            c(null, null, null);
            return;
        }
        File file3 = new File(str + ((String) str3));
        File file4 = new File(((String) str2) + ((String) str3));
        str2 = new FileInputStream(file3);
        try {
            fileOutputStream = new FileOutputStream(file4);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = str2.read(bArr);
                    if (-1 == i) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
            } catch (FileNotFoundException unused4) {
                mly.b("FileUtils", "FileNotFoundException", true);
            } catch (IOException unused5) {
                mly.b("FileUtils", "IOException", true);
            } catch (IndexOutOfBoundsException unused6) {
                mly.b("FileUtils", "IndexOutOfBoundsException", true);
            }
        } catch (FileNotFoundException unused7) {
            fileOutputStream = null;
        } catch (IOException unused8) {
            fileOutputStream = null;
        } catch (IndexOutOfBoundsException unused9) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            str3 = 0;
            c(str3, null, str2);
            throw th;
        }
        c(fileOutputStream, null, str2);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            mly.a("FileUtils", "file not exist", true);
            return false;
        }
    }

    public static String a(String str) throws Throwable {
        FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    int iAvailable = fileInputStream.available();
                    byte[] bArr = new byte[iAvailable];
                    if (iAvailable != fileInputStream.read(bArr)) {
                        mly.b("FileUtils", "readFile length is error.", true);
                    }
                    String str2 = new String(bArr, "UTF-8");
                    e(fileInputStream, null);
                    return str2;
                } catch (FileNotFoundException e) {
                    e = e;
                    mly.b("FileUtils", "FileNotFoundException " + e.getClass().getSimpleName(), true);
                    e(fileInputStream, null);
                    return "";
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    mly.b("FileUtils", "UnsupportedEncodingException " + e.getClass().getSimpleName(), true);
                    e(fileInputStream, null);
                    return "";
                } catch (IOException e3) {
                    e = e3;
                    mly.b("FileUtils", "IOException " + e.getClass().getSimpleName(), true);
                    e(fileInputStream, null);
                    return "";
                } catch (Exception e4) {
                    e = e4;
                    mly.b("FileUtils", "Exception " + e.getClass().getSimpleName(), true);
                    e(fileInputStream, null);
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                e(null, null);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileInputStream = null;
        } catch (UnsupportedEncodingException e6) {
            e = e6;
            fileInputStream = null;
        } catch (IOException e7) {
            e = e7;
            fileInputStream = null;
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            e(null, null);
            throw th;
        }
    }

    public static void e(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                mly.b("FileUtils", "close InputStream error!" + e.getClass().getSimpleName(), true);
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                mly.b("FileUtils", "close OutputStream error!" + e2.getClass().getSimpleName(), true);
            }
        }
    }
}
