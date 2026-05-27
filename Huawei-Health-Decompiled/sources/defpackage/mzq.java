package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class mzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15968a = "MultiSimEncode";
    private static int b = 1732584193;
    private static int c = -1732584194;
    private static int d = 271733878;
    private static int e = -271733879;
    private static int j = -1009589776;

    private static int a(int i, int i2, int i3) {
        return (i & (i2 ^ i3)) ^ i3;
    }

    private static int c(int i, int i2) {
        return (i2 << i) | (i2 >>> (32 - i));
    }

    private static int c(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private static int e(int i, int i2, int i3) {
        return ((i | i2) & i3) | (i & i2);
    }

    private static void d() {
        b = 1732584193;
        e = -271733879;
        c = -1732584194;
        d = 271733878;
        j = -1009589776;
    }

    private static int[] e(int[] iArr) {
        int i;
        d();
        int[] iArr2 = new int[81];
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            if (i2 < iArr.length) {
                iArr2[i2] = iArr[i2];
            } else {
                iArr2[i2] = 0;
            }
            i2++;
        }
        for (i = 16; i < 80; i++) {
            iArr2[i] = c(1, ((iArr2[i - 3] ^ iArr2[i - 8]) ^ iArr2[i - 14]) ^ iArr2[i - 16]);
        }
        return e(iArr2, 1518500249, 1859775393, -1894007588, -899497514);
    }

    private static int[] e(int[] iArr, int i, int i2, int i3, int i4) {
        int iC = b;
        int iC2 = e;
        int i5 = c;
        int i6 = d;
        int i7 = j;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            int iA = i7 + ((iC << 5) | (iC >>> 27)) + a(iC2, i5, i6) + iArr[i9] + i;
            int i10 = (iC2 << 30) | (iC2 >>> 2);
            int iA2 = i6 + ((iA << 5) | (iA >>> 27)) + a(iC, i10, i5) + iArr[i9 + 1] + i;
            int i11 = (iC << 30) | (iC >>> 2);
            int iA3 = i5 + ((iA2 << 5) | (iA2 >>> 27)) + a(iA, i11, i10) + iArr[i9 + 2] + i;
            i7 = (iA << 30) | (iA >>> 2);
            iC2 = i10 + ((iA3 << 5) | (iA3 >>> 27)) + a(iA2, i7, i11) + iArr[i9 + 3] + i;
            i6 = (iA2 << 30) | (iA2 >>> 2);
            iC = i11 + ((iC2 << 5) | (iC2 >>> 27)) + a(iA3, i6, i7) + iArr[i9 + 4] + i;
            i5 = (iA3 << 30) | (iA3 >>> 2);
            i8++;
            i9 += 5;
        }
        int i12 = 0;
        while (i12 < 4) {
            int iC3 = i7 + ((iC << 5) | (iC >>> 27)) + c(iC2, i5, i6) + iArr[i9] + i2;
            int i13 = (iC2 << 30) | (iC2 >>> 2);
            int iC4 = i6 + ((iC3 << 5) | (iC3 >>> 27)) + c(iC, i13, i5) + iArr[i9 + 1] + i2;
            int i14 = (iC << 30) | (iC >>> 2);
            int iC5 = i5 + ((iC4 << 5) | (iC4 >>> 27)) + c(iC3, i14, i13) + iArr[i9 + 2] + i2;
            i7 = (iC3 << 30) | (iC3 >>> 2);
            iC2 = i13 + ((iC5 << 5) | (iC5 >>> 27)) + c(iC4, i7, i14) + iArr[i9 + 3] + i2;
            i6 = (iC4 << 30) | (iC4 >>> 2);
            iC = i14 + ((iC2 << 5) | (iC2 >>> 27)) + c(iC5, i6, i7) + iArr[i9 + 4] + i2;
            i5 = (iC5 << 30) | (iC5 >>> 2);
            i12++;
            i9 += 5;
        }
        int i15 = 0;
        while (i15 < 4) {
            int iE = i7 + ((iC << 5) | (iC >>> 27)) + e(iC2, i5, i6) + iArr[i9] + i3;
            int i16 = (iC2 >>> 2) | (iC2 << 30);
            int iE2 = i6 + ((iE << 5) | (iE >>> 27)) + e(iC, i16, i5) + iArr[i9 + 1] + i3;
            int i17 = (iC << 30) | (iC >>> 2);
            int iE3 = i5 + ((iE2 << 5) | (iE2 >>> 27)) + e(iE, i17, i16) + iArr[i9 + 2] + i3;
            i7 = (iE << 30) | (iE >>> 2);
            iC2 = i16 + ((iE3 << 5) | (iE3 >>> 27)) + e(iE2, i7, i17) + iArr[i9 + 3] + i3;
            i6 = (iE2 << 30) | (iE2 >>> 2);
            iC = i17 + ((iC2 << 5) | (iC2 >>> 27)) + e(iE3, i6, i7) + iArr[i9 + 4] + i3;
            i5 = (iE3 << 30) | (iE3 >>> 2);
            i15++;
            i9 += 5;
        }
        for (int i18 = 0; i18 <= 3; i18++) {
            int iC6 = i7 + ((iC << 5) | (iC >>> 27)) + c(iC2, i5, i6) + iArr[i9] + i4;
            int i19 = (iC2 >>> 2) | (iC2 << 30);
            int iC7 = i6 + ((iC6 << 5) | (iC6 >>> 27)) + c(iC, i19, i5) + iArr[i9 + 1] + i4;
            int i20 = (iC >>> 2) | (iC << 30);
            int iC8 = i5 + ((iC7 << 5) | (iC7 >>> 27)) + c(iC6, i20, i19) + iArr[i9 + 2] + i4;
            i7 = (iC6 << 30) | (iC6 >>> 2);
            int i21 = i9 + 4;
            iC2 = i19 + ((iC8 << 5) | (iC8 >>> 27)) + c(iC7, i7, i20) + iArr[i9 + 3] + i4;
            i6 = (iC7 >>> 2) | (iC7 << 30);
            i9 += 5;
            iC = i20 + ((iC2 << 5) | (iC2 >>> 27)) + c(iC8, i6, i7) + iArr[i21] + i4;
            i5 = (iC8 >>> 2) | (iC8 << 30);
        }
        return new int[]{b + iC, e + iC2, c + i5, d + i6, j + i7};
    }

    public static byte[] b(int[] iArr, int i) {
        int i2 = i / 40;
        byte[] bArr = new byte[64];
        byte[] bArrA = a(iArr);
        System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
        byte[] bArrB = null;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < 2; i4++) {
                byte[] bArrA2 = a(e(a(bArr)));
                bArrB = b(bArrB, bArrA2);
                int i5 = 1;
                for (int i6 = 19; i6 >= 0; i6--) {
                    int i7 = i5 + (bArr[i6] & UnsignedBytes.MAX_VALUE) + (bArrA2[i6] & UnsignedBytes.MAX_VALUE);
                    bArr[i6] = (byte) (i7 & 255);
                    i5 = i7 >>> 8;
                }
            }
        }
        return bArrB;
    }

    private static byte[] a(int[] iArr) {
        byte[] bArrB = null;
        for (int i : iArr) {
            bArrB = b(bArrB, b(i));
        }
        return bArrB;
    }

    public static int[] a(byte[] bArr) {
        int[] iArr = new int[bArr.length / 4];
        for (int i = 0; i < bArr.length / 4; i++) {
            int i2 = i * 4;
            iArr[i] = a(Arrays.copyOfRange(bArr, i2, i2 + 4), 0);
        }
        return iArr;
    }

    private static int a(byte[] bArr, int i) {
        return (bArr[i + 3] & UnsignedBytes.MAX_VALUE) | ((bArr[i] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        if (bArr != null && bArr2 != null) {
            length = bArr.length + bArr2.length;
        } else if (bArr != null) {
            length = bArr.length;
        } else {
            if (bArr2 == null) {
                return new byte[0];
            }
            length = bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        if (bArr == null || bArr.length == 0) {
            i = 0;
        } else {
            i = 0;
            for (byte b2 : bArr) {
                bArr3[i] = b2;
                i++;
            }
        }
        if (bArr2 != null && bArr2.length != 0) {
            for (byte b3 : bArr2) {
                bArr3[i] = b3;
                i++;
            }
        }
        return bArr3;
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = {0};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            mza.c(f15968a, "encodeBySha1 no such algorithm error");
            return bArr2;
        }
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }
}
