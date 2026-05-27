package defpackage;

import android.text.TextUtils;
import com.huawei.android.hicloud.sync.util.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public class gbi {
    /* JADX WARN: Can't wrap try/catch for region: R(8:10|(5:57|11|50|12|13)|(2:59|14)|(3:15|(1:17)(1:61)|38)|18|52|19|38) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        defpackage.gbo.c(com.huawei.android.hicloud.sync.util.FileUtil.TAG, "getByteArray, close stream Exception");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] e(java.lang.String r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "getByteArray, close stream Exception"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getByteArray filePath: "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r2 = "FileUtil"
            defpackage.gbo.a(r2, r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r9)
            r9 = 0
            byte[] r3 = new byte[r9]
            boolean r4 = r1.exists()
            if (r4 != 0) goto L31
            java.lang.String r9 = "getByteArray, file is not exists"
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            defpackage.gbo.e(r2, r9)
            return r3
        L31:
            long r4 = r1.length()
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L45
            java.lang.String r9 = "getByteArray, file is empty"
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            defpackage.gbo.e(r2, r9)
            return r3
        L45:
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L83
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L83
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L84
            long r7 = r1.length()     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L84
            int r1 = (int) r7     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L84
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L84
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7a
        L59:
            int r4 = r5.read(r1)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7a
            r7 = -1
            if (r4 == r7) goto L64
            r6.write(r1, r9, r4)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7a
            goto L59
        L64:
            byte[] r3 = r6.toByteArray()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7a
            r6.close()     // Catch: java.io.IOException -> L6f
            r5.close()     // Catch: java.io.IOException -> L6f
            goto La0
        L6f:
            java.lang.Object[] r9 = new java.lang.Object[]{r0}
            defpackage.gbo.c(r2, r9)
            goto La0
        L77:
            r9 = move-exception
            r4 = r6
            goto La3
        L7a:
            r4 = r6
            goto L84
        L7c:
            r9 = move-exception
            r1 = r4
            r4 = r5
            goto La1
        L80:
            r9 = move-exception
            r5 = r4
            goto La3
        L83:
            r5 = r4
        L84:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = "getByteArray, read data Exception"
            r1[r9] = r6     // Catch: java.lang.Throwable -> L7c
            defpackage.gbo.c(r2, r1)     // Catch: java.lang.Throwable -> L7c
            if (r4 == 0) goto L93
            r4.close()     // Catch: java.io.IOException -> L99
        L93:
            if (r5 == 0) goto La0
            r5.close()     // Catch: java.io.IOException -> L99
            goto La0
        L99:
            java.lang.Object[] r9 = new java.lang.Object[]{r0}
            defpackage.gbo.c(r2, r9)
        La0:
            return r3
        La1:
            r5 = r4
            r4 = r1
        La3:
            if (r4 == 0) goto La8
            r4.close()     // Catch: java.io.IOException -> Lae
        La8:
            if (r5 == 0) goto Lb5
            r5.close()     // Catch: java.io.IOException -> Lae
            goto Lb5
        Lae:
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            defpackage.gbo.c(r2, r0)
        Lb5:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gbi.e(java.lang.String):byte[]");
    }

    public static boolean c(String str, byte[] bArr, int i) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (FileNotFoundException unused) {
        } catch (IOException unused2) {
        }
        try {
            fileOutputStream.write(bArr, 0, i);
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException unused3) {
                gbo.c(FileUtil.TAG, "write, close fos IOException");
                return true;
            }
        } catch (FileNotFoundException unused4) {
            fileOutputStream2 = fileOutputStream;
            gbo.c(FileUtil.TAG, "write, FileNotFoundException: " + str);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused5) {
                    gbo.c(FileUtil.TAG, "write, close fos IOException");
                }
            }
            return false;
        } catch (IOException unused6) {
            fileOutputStream2 = fileOutputStream;
            gbo.c(FileUtil.TAG, "write, IOException");
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused7) {
                    gbo.c(FileUtil.TAG, "write, close fos IOException");
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused8) {
                    gbo.c(FileUtil.TAG, "write, close fos IOException");
                }
            }
            throw th;
        }
    }

    public static String d(String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            gbo.c(FileUtil.TAG, "filterFilePath, legalPath is empty");
            return null;
        }
        try {
            return new File(strA).getCanonicalPath();
        } catch (IOException unused) {
            gbo.c(FileUtil.TAG, "filterFilePath IOException");
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            gbo.c(FileUtil.TAG, "filterFullFilePath sourcePath is empty");
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-=[];\\',./ ~!@#$%^&*()_+\"{}|:<>?".contains(String.valueOf(str.charAt(i)))) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
