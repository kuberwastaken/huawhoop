package defpackage;

import android.util.Base64;
import java.security.SecureRandom;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public class mj {
    public static final char[] b = "0123456789ABCDEF".toCharArray();
    public static volatile SecureRandom c;

    public static byte[] a() {
        byte[] bArr = new byte[4];
        e().nextBytes(bArr);
        return bArr;
    }

    public static byte[] b() {
        byte[] bArr = new byte[2];
        e().nextBytes(bArr);
        return bArr;
    }

    public static SecureRandom e() {
        if (c != null) {
            return c;
        }
        synchronized (mj.class) {
            if (c == null) {
                c = new SecureRandom();
            }
        }
        return c;
    }

    public static byte[] a(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArrCopyOf = null;
        int length2 = 0;
        for (byte[] bArr3 : bArr) {
            if (bArrCopyOf == null) {
                bArrCopyOf = Arrays.copyOf(bArr3, length);
                length2 = bArr3.length;
            } else {
                System.arraycopy(bArr3, 0, bArrCopyOf, length2, bArr3.length);
                length2 += bArr3.length;
            }
        }
        return bArrCopyOf;
    }

    public static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    public static byte[] e(short s) {
        return new byte[]{(byte) s, (byte) (s >> 8)};
    }

    public static byte[] b(long j) {
        return new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24), (byte) (j >> 32), (byte) (j >> 40), (byte) (j >> 48), (byte) (j >> 56)};
    }

    public static byte[] b(char c2, char c3) {
        return new byte[]{(byte) (c2 & 255), (byte) (c3 & 255)};
    }

    public static byte[] b(byte b2) {
        return new byte[]{b2};
    }
}
