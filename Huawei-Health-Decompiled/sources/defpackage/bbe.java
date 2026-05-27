package defpackage;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes3.dex */
public class bbe {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
                bbf.a("FileUtils", "close stream exception");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0073: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:48:0x0073 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    public static String d(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        Throwable e;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream2;
        String str3;
        MessageDigest messageDigest;
        byte[] bArr;
        long j;
        ?? r1 = 0;
        strA = null;
        strA = null;
        String strA = null;
        r1 = 0;
        try {
            try {
                messageDigest = MessageDigest.getInstance(str2);
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                fileInputStream = fileInputStream2;
                r1 = str;
                th = th;
            }
        } catch (FileNotFoundException unused) {
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (IOException e2) {
            e = e2;
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (IllegalArgumentException e3) {
            e = e3;
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                bArr = new byte[131072];
                j = 0;
            } catch (FileNotFoundException unused2) {
                bbf.c("FileUtils", "getFileHashData FileNotFoundException");
            } catch (IOException e6) {
                e = e6;
                str3 = "getFileHashData IOException";
                bbf.c("FileUtils", str3, e);
            } catch (IllegalArgumentException e7) {
                e = e7;
                str3 = "getFileHashData IllegalArgumentException";
                bbf.c("FileUtils", str3, e);
            } catch (IndexOutOfBoundsException e8) {
                e = e8;
                str3 = "getFileHashData IndexOutOfBoundsException";
                bbf.c("FileUtils", str3, e);
            } catch (NoSuchAlgorithmException e9) {
                e = e9;
                str3 = "getFileHashData NoSuchAlgorithmException";
                bbf.c("FileUtils", str3, e);
            }
        } catch (FileNotFoundException unused3) {
            bufferedInputStream = null;
        } catch (IOException e10) {
            e = e10;
            bufferedInputStream = null;
        } catch (IllegalArgumentException e11) {
            e = e11;
            bufferedInputStream = null;
        } catch (IndexOutOfBoundsException e12) {
            e = e12;
            bufferedInputStream = null;
        } catch (NoSuchAlgorithmException e13) {
            e = e13;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            a(r1);
            a(fileInputStream);
            throw th;
        }
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            messageDigest.update(bArr, 0, i);
            j += (long) i;
            a(bufferedInputStream);
            a(fileInputStream);
            return strA;
        }
        if (j > 0) {
            strA = baz.a(messageDigest.digest());
        }
        a(bufferedInputStream);
        a(fileInputStream);
        return strA;
    }

    public static String d(int i) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(0);
        if (i >= 100) {
            i = 100;
        }
        return percentInstance.format(((double) i) / 100.0d);
    }
}
