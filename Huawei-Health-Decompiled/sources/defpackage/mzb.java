package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.primitives.UnsignedBytes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes6.dex */
public class mzb {
    private static String e;

    public static String b(Context context) {
        if (e == null) {
            String strB = b(context, "encodehwmultisim");
            if (TextUtils.isEmpty(strB)) {
                byte[] bArrD = mzf.d();
                if (bArrD.length == 0) {
                    return null;
                }
                String strB2 = mzf.b(bArrD);
                b(context, strB2, "encodehwmultisim");
                e = strB2;
            } else {
                e = strB;
            }
        }
        return e;
    }

    public static void b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        int[] iArrC = c(str, str2);
        b(context, iArrC, str2);
        c(context, c(str, iArrC), str2);
    }

    public static String b(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer("");
        int[] iArrC = c(context, str);
        if (iArrC.length <= 0) {
            return stringBuffer.toString();
        }
        int length = iArrC.length;
        for (int i = 0; i < length; i++) {
            String strD = d(a(context, e(str + i)));
            if (TextUtils.isEmpty(strD)) {
                return "";
            }
            if (i == length / 2) {
                stringBuffer.append(String.copyValueOf(d(strD.toCharArray(), false)));
            } else {
                stringBuffer.append(strD);
            }
        }
        return stringBuffer.toString();
    }

    private static String[] c(String str, int[] iArr) {
        String[] strArr = new String[iArr.length];
        if (!TextUtils.isEmpty(str) && iArr.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                try {
                    if (i2 == iArr.length / 2) {
                        strArr[i2] = String.copyValueOf(d(str.substring(i, iArr[i2] + i).toCharArray(), true));
                    } else {
                        strArr[i2] = str.substring(i, iArr[i2] + i);
                    }
                    i += iArr[i2];
                } catch (IndexOutOfBoundsException unused) {
                }
            }
        }
        return strArr;
    }

    private static char[] d(char[] cArr, boolean z) {
        char[] cArr2 = new char[cArr.length];
        int i = 0;
        if (z) {
            int length = cArr.length;
            int i2 = 0;
            while (i < length) {
                cArr2[i2] = (char) (cArr[i] + 2);
                i2++;
                i++;
            }
        } else {
            int length2 = cArr.length;
            int i3 = 0;
            while (i < length2) {
                cArr2[i3] = (char) (cArr[i] - 2);
                i3++;
                i++;
            }
        }
        return cArr2;
    }

    private static void b(Context context, int[] iArr, String str) {
        if (iArr == null || iArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i : iArr) {
            stringBuffer.append(i);
            stringBuffer.append("/");
        }
        try {
            a(a(context, e(str)), stringBuffer.substring(0, stringBuffer.length() - 1));
        } catch (IOException e2) {
            mza.c("EncryptFileUtils", "saveIndexFile->saveStrs " + e2.toString());
        }
    }

    private static int[] c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] strArrSplit = d(a(context, e(str))).split("/");
        if (strArrSplit.length <= 0) {
            return new int[0];
        }
        int[] iArr = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            } catch (NumberFormatException unused) {
                return new int[0];
            }
        }
        return iArr;
    }

    private static String d(String str) {
        return (TextUtils.isEmpty(str) || !new File(str).exists()) ? "" : a(new File(str)).toString();
    }

    private static void c(Context context, String[] strArr, String str) {
        if (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            try {
                a(a(context, e(str + i)), strArr[i]);
            } catch (IOException e2) {
                mza.c("EncryptFileUtils", "saveStrsToFile->saveStrs " + e2.toString());
            }
        }
    }

    private static String a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return "";
        }
        return context.getFilesDir() + File.separator + str;
    }

    public static int[] c(String str, String str2) {
        return (TextUtils.isEmpty(str) || str.length() < 16 || TextUtils.isEmpty(str2)) ? new int[0] : new int[]{3, 4, 4, 3, str.length() - 14};
    }

    private static String e(String str) {
        return d(str, "SHA-256");
    }

    public static String d(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes("UTF-8"));
            return b(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        } catch (Exception unused2) {
            return "";
        }
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void a(String str, String str2) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str, true), "UTF-8");
        try {
            try {
                outputStreamWriter.write(str2);
            } catch (IOException unused) {
                mza.e("EncryptFileUtils", "IOException when write");
            }
            try {
                outputStreamWriter.close();
            } catch (IOException unused2) {
                mza.e("EncryptFileUtils", "IOException when close");
            }
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (IOException unused3) {
                mza.e("EncryptFileUtils", "IOException when close");
            }
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(7:115|3|111|4|113|5|6)|(6:117|7|(3:8|9|(1:99)(2:17|18))|11|93|14)|103|65|68|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a8, code lost:
    
        defpackage.mza.c("EncryptFileUtils", "IOException in finally br");
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.StringBuffer a(java.io.File r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mzb.a(java.io.File):java.lang.StringBuffer");
    }
}
