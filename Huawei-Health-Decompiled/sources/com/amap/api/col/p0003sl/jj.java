package com.amap.api.col.p0003sl;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public class jj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1144a = true;
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.i, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.i, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.i, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private jj() {
    }

    public static String a(byte[] bArr) {
        String strA;
        try {
            strA = a(bArr, bArr.length);
        } catch (IOException e2) {
            if (!f1144a) {
                throw new AssertionError(e2.getMessage());
            }
            strA = null;
        }
        if (f1144a || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    private static byte[] b(byte[] bArr, int i) throws IOException {
        int i2;
        int i3;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }
        if (i == 0) {
            return new byte[0];
        }
        if (i < 4) {
            throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i)));
        }
        byte[] bArr2 = c;
        int i4 = (i * 3) / 4;
        byte[] bArr3 = new byte[i4];
        byte[] bArr4 = new byte[4];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i; i7++) {
            byte b2 = bArr[i7];
            byte b3 = bArr2[b2 & UnsignedBytes.MAX_VALUE];
            if (b3 < -5) {
                throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(b2 & UnsignedBytes.MAX_VALUE), Integer.valueOf(i7)));
            }
            if (b3 >= -1) {
                int i8 = i6 + 1;
                bArr4[i6] = b2;
                if (i8 <= 3) {
                    i6 = i8;
                } else {
                    if (i5 < 0 || (i2 = i5 + 2) >= i4) {
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(i4), Integer.valueOf(i5)));
                    }
                    byte[] bArr5 = c;
                    byte b4 = bArr4[2];
                    if (b4 == 61) {
                        bArr3[i5] = (byte) ((((bArr5[bArr4[0]] & UnsignedBytes.MAX_VALUE) << 18) | ((bArr5[bArr4[1]] & UnsignedBytes.MAX_VALUE) << 12)) >>> 16);
                        i3 = 1;
                    } else {
                        byte b5 = bArr4[3];
                        if (b5 == 61) {
                            int i9 = ((bArr5[bArr4[0]] & UnsignedBytes.MAX_VALUE) << 18) | ((bArr5[bArr4[1]] & UnsignedBytes.MAX_VALUE) << 12) | ((bArr5[b4] & UnsignedBytes.MAX_VALUE) << 6);
                            bArr3[i5] = (byte) (i9 >>> 16);
                            bArr3[i5 + 1] = (byte) (i9 >>> 8);
                            i3 = 2;
                        } else {
                            int i10 = ((bArr5[bArr4[0]] & UnsignedBytes.MAX_VALUE) << 18) | ((bArr5[bArr4[1]] & UnsignedBytes.MAX_VALUE) << 12) | ((bArr5[b4] & UnsignedBytes.MAX_VALUE) << 6) | (bArr5[b5] & UnsignedBytes.MAX_VALUE);
                            bArr3[i5] = (byte) (i10 >> 16);
                            bArr3[i5 + 1] = (byte) (i10 >> 8);
                            bArr3[i2] = (byte) i10;
                            i3 = 3;
                        }
                    }
                    i5 += i3;
                    if (bArr[i7] == 61) {
                        break;
                    }
                    i6 = 0;
                }
            }
        }
        byte[] bArr6 = new byte[i5];
        System.arraycopy(bArr3, 0, bArr6, 0, i5);
        return bArr6;
    }

    public static byte[] a(String str) throws IOException {
        return b(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:10|(3:81|11|(4:85|12|79|13))|(3:(7:83|14|(1:16)(1:87)|67|41|75|42)|75|42)|17|61|18|67|41) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] b(java.lang.String r6) throws java.lang.Throwable {
        /*
            if (r6 == 0) goto L85
            java.lang.String r0 = "US-ASCII"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L9
            goto Ld
        L9:
            byte[] r6 = r6.getBytes()
        Ld:
            int r0 = r6.length
            byte[] r6 = b(r6, r0)
            int r0 = r6.length
            r1 = 4
            if (r0 < r1) goto L84
            r0 = 0
            r1 = r6[r0]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 1
            r2 = r6[r2]
            int r2 = r2 << 8
            r3 = 65280(0xff00, float:9.1477E-41)
            r2 = r2 & r3
            r1 = r1 | r2
            r2 = 35615(0x8b1f, float:4.9907E-41)
            if (r2 != r1) goto L84
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r3.<init>()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5f
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5f
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
        L3e:
            int r2 = r5.read(r1)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            if (r2 < 0) goto L48
            r3.write(r1, r0, r2)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            goto L3e
        L48:
            byte[] r6 = r3.toByteArray()     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            r3.close()     // Catch: java.lang.Exception -> L70
            goto L70
        L50:
            r6 = move-exception
            r2 = r5
            goto L5d
        L53:
            r0 = move-exception
            goto L59
        L55:
            r6 = move-exception
            goto L5d
        L57:
            r0 = move-exception
            r5 = r2
        L59:
            r2 = r4
            goto L69
        L5b:
            r6 = move-exception
            r4 = r2
        L5d:
            r5 = r2
            goto L79
        L5f:
            r0 = move-exception
            r5 = r2
            goto L69
        L62:
            r6 = move-exception
            r4 = r2
            r5 = r4
            goto L7a
        L66:
            r0 = move-exception
            r3 = r2
            r5 = r3
        L69:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L77
            r3.close()     // Catch: java.lang.Exception -> L6f
        L6f:
            r4 = r2
        L70:
            r5.close()     // Catch: java.lang.Exception -> L73
        L73:
            r4.close()     // Catch: java.lang.Exception -> L84
            goto L84
        L77:
            r6 = move-exception
            r4 = r2
        L79:
            r2 = r3
        L7a:
            r2.close()     // Catch: java.lang.Exception -> L7d
        L7d:
            r5.close()     // Catch: java.lang.Exception -> L80
        L80:
            r4.close()     // Catch: java.lang.Exception -> L83
        L83:
            throw r6
        L84:
            return r6
        L85:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "Input string was null."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.jj.b(java.lang.String):byte[]");
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = b;
        int i4 = (i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 == 2) {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 != 3) {
            return bArr2;
        }
        bArr2[i3] = bArr3[i4 >>> 18];
        bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
        bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
        bArr2[i3 + 3] = bArr3[i4 & 63];
        return bArr2;
    }

    private static String a(byte[] bArr, int i) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i)));
        }
        if (i > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i), Integer.valueOf(bArr.length)));
        }
        int i2 = ((i / 3) * 4) + (i % 3 > 0 ? 4 : 0);
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i - 2) {
            a(bArr, i3, 3, bArr2, i4);
            i3 += 3;
            i4 += 4;
        }
        if (i3 < i) {
            a(bArr, i3, i - i3, bArr2, i4);
            i4 += 4;
        }
        if (i4 <= i2 - 1) {
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            bArr2 = bArr3;
        }
        try {
            return new String(bArr2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr2);
        }
    }
}
