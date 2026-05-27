package defpackage;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public class wvc {
    private wvc() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.BufferedInputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static File fDU_(String str, ParcelFileDescriptor parcelFileDescriptor) {
        Closeable closeable;
        BufferedOutputStream bufferedOutputStream;
        synchronized (wvc.class) {
            wrm.a("WearEngineFileUtil", "begin createFileFromPfd, fileName: " + str);
            ?? r2 = 0;
            if (!fDV_(str, parcelFileDescriptor)) {
                return null;
            }
            String strB = b(str);
            ?? IsEmpty = TextUtils.isEmpty(strB);
            try {
                if (IsEmpty != 0) {
                    wrm.b("WearEngineFileUtil", "createFileFromPfd path is invalid");
                    return null;
                }
                try {
                    File fileD = d(strB);
                    if (fileD == null) {
                        wrm.b("WearEngineFileUtil", "createFileFromPfd dest file is null");
                        a(null);
                        a(null);
                        a(parcelFileDescriptor);
                        return null;
                    }
                    FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
                    if (fileDescriptor != null && fileDescriptor.valid()) {
                        IsEmpty = new BufferedInputStream(new FileInputStream(fileDescriptor));
                        try {
                            byte[] bArr = new byte[2048];
                            int i = IsEmpty.read(bArr);
                            if (i == -1) {
                                wrm.e("WearEngineFileUtil", "inputStream is empty, do not write file");
                                a(IsEmpty);
                                a(null);
                                a(parcelFileDescriptor);
                                return fileD;
                            }
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileD));
                            while (i != -1) {
                                try {
                                    bufferedOutputStream.write(bArr, 0, i);
                                    i = IsEmpty.read(bArr);
                                } catch (IOException unused) {
                                    wrm.b("WearEngineFileUtil", "createFileFromPfd IOException");
                                    a(IsEmpty);
                                    a(bufferedOutputStream);
                                    a(parcelFileDescriptor);
                                    return null;
                                } catch (Exception unused2) {
                                    wrm.b("WearEngineFileUtil", "createFileFromPfd Exception");
                                    a(IsEmpty);
                                    a(bufferedOutputStream);
                                    a(parcelFileDescriptor);
                                    return null;
                                }
                            }
                            bufferedOutputStream.flush();
                            a(IsEmpty);
                            a(bufferedOutputStream);
                            a(parcelFileDescriptor);
                            return fileD;
                        } catch (IOException unused3) {
                            bufferedOutputStream = null;
                        } catch (Exception unused4) {
                            bufferedOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            closeable = null;
                            r2 = IsEmpty;
                            a(r2);
                            a(closeable);
                            a(parcelFileDescriptor);
                            throw th;
                        }
                    }
                    wrm.e("WearEngineFileUtil", "fd is invalid");
                    a(null);
                    a(null);
                    a(parcelFileDescriptor);
                    return fileD;
                } catch (IOException unused5) {
                    IsEmpty = 0;
                    bufferedOutputStream = null;
                } catch (Exception unused6) {
                    IsEmpty = 0;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    a(r2);
                    a(closeable);
                    a(parcelFileDescriptor);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    private static File d(String str) throws IOException {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            wrm.b("WearEngineFileUtil", "createFileFromPfd parentFile is invalid");
            return null;
        }
        if (!parentFile.exists()) {
            wrm.a("WearEngineFileUtil", "createFileFromPfd isFileMkdir:" + parentFile.mkdirs());
        }
        if (!file.exists()) {
            wrm.a("WearEngineFileUtil", "createFileFromPfd isFileCreate:" + file.createNewFile());
        }
        return file;
    }

    private static boolean fDV_(String str, ParcelFileDescriptor parcelFileDescriptor) {
        if (TextUtils.isEmpty(str)) {
            wrm.b("WearEngineFileUtil", "createFileFromPfd fileName is invalid");
            return false;
        }
        if (parcelFileDescriptor != null) {
            return true;
        }
        wrm.b("WearEngineFileUtil", "createFileFromPfd fileDescriptor is null");
        return false;
    }

    private static String b(String str) {
        Context contextD = wut.d();
        if (contextD == null) {
            wrm.b("WearEngineFileUtil", "getCheckedFilePath context is null");
            return "";
        }
        try {
            String str2 = contextD.getFilesDir().getCanonicalPath() + File.separator + "WearEngine" + File.separator + str;
            if (TextUtils.isEmpty(str2)) {
                wrm.b("WearEngineFileUtil", "createFileFromPfd path is invalid");
                return "";
            }
            try {
                return new File(str2).getCanonicalPath();
            } catch (IOException unused) {
                wrm.b("WearEngineFileUtil", "getCheckedFilePath IOException");
                return null;
            }
        } catch (IOException unused2) {
            wrm.b("WearEngineFileUtil", "getCanonicalPath IOException");
            return "";
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                wrm.b("WearEngineFileUtil", "closeQuietly IOException");
            }
        }
    }
}
