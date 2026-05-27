package com.huawei.updatesdk.a.a.d;

import android.text.TextUtils;
import com.huawei.android.hicloud.sync.util.FileUtil;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes8.dex */
public abstract class d {
    public static boolean d(String str) {
        return TextUtils.isEmpty(str) || b(str);
    }

    private static boolean c(String str) {
        return str.contains("%00") || str.contains(".\\.\\") || str.contains("./");
    }

    private static boolean b(String str) {
        return a(str) || c(str);
    }

    private static boolean a(String str) {
        return str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || str.contains("..");
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        return file.delete();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                com.huawei.updatesdk.a.a.c.a.a.a.a(FileUtil.TAG, "Closeable exception", e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    public static String a(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        String str3;
        MessageDigest messageDigest;
        byte[] bArr;
        long j;
        ?? D = d(str);
        ?? r2 = 0;
        strA = null;
        strA = null;
        String strA = null;
        try {
            if (D != 0) {
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance(str2);
                fileInputStream = new FileInputStream(str);
                try {
                    bArr = new byte[1024];
                    j = 0;
                } catch (FileNotFoundException unused) {
                    com.huawei.updatesdk.a.a.c.a.a.a.b(FileUtil.TAG, "getFileHashData FileNotFoundException");
                } catch (IOException e) {
                    e = e;
                    str3 = "getFileHashData IOException";
                    com.huawei.updatesdk.a.a.c.a.a.a.a(FileUtil.TAG, str3, e);
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    str3 = "getFileHashData IllegalArgumentException";
                    com.huawei.updatesdk.a.a.c.a.a.a.a(FileUtil.TAG, str3, e);
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    str3 = "getFileHashData IndexOutOfBoundsException";
                    com.huawei.updatesdk.a.a.c.a.a.a.a(FileUtil.TAG, str3, e);
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    str3 = "getFileHashData NoSuchAlgorithmException";
                    com.huawei.updatesdk.a.a.c.a.a.a.a(FileUtil.TAG, str3, e);
                }
            } catch (FileNotFoundException unused2) {
                fileInputStream = null;
            } catch (IOException e5) {
                e = e5;
                fileInputStream = null;
            } catch (IllegalArgumentException e6) {
                e = e6;
                fileInputStream = null;
            } catch (IndexOutOfBoundsException e7) {
                e = e7;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                a((Closeable) r2);
                throw th;
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
                j += (long) i;
                a(fileInputStream);
                return strA;
            }
            if (j > 0) {
                strA = b.a(messageDigest.digest());
            }
            a(fileInputStream);
            return strA;
        } catch (Throwable th2) {
            th = th2;
            r2 = D;
        }
    }
}
