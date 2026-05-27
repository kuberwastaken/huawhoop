package com.huawei.watchface;

import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.primitives.UnsignedBytes;
import com.huawei.secure.android.common.util.SafeString;
import com.huawei.watchface.utils.HwLog;
import java.io.FileInputStream;
import java.io.IOException;
import okio.Utf8;

/* JADX INFO: loaded from: classes8.dex */
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f11400a = new char[64];
    private static final byte[] b = new byte[128];

    private static boolean a(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private static boolean b(char c) {
        return c == '=';
    }

    static {
        int i = 0;
        for (int i2 = 0; i2 < 128; i2++) {
            b[i2] = -1;
        }
        for (int i3 = 90; i3 >= 65; i3--) {
            b[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 122; i4 >= 97; i4--) {
            b[i4] = (byte) (i4 - 71);
        }
        for (int i5 = 57; i5 >= 48; i5--) {
            b[i5] = (byte) (i5 + 4);
        }
        byte[] bArr = b;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i6 = 0; i6 <= 25; i6++) {
            f11400a[i6] = (char) (i6 + 65);
        }
        int i7 = 26;
        int i8 = 0;
        while (i7 <= 51) {
            f11400a[i7] = (char) (i8 + 97);
            i7++;
            i8++;
        }
        int i9 = 52;
        while (i9 <= 61) {
            f11400a[i9] = (char) (i + 48);
            i9++;
            i++;
        }
        char[] cArr = f11400a;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    private static boolean c(char c) {
        return c < 128 && b[c] != -1;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        char[] cArr = new char[(i != 0 ? i2 + 1 : i2) * 4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            byte b2 = bArr[i4];
            byte b3 = bArr[i4 + 1];
            byte b4 = bArr[i4 + 2];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i6 = b2 >> 2;
            if ((b2 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                i6 ^= PsExtractor.AUDIO_STREAM;
            }
            byte b7 = (byte) i6;
            int i7 = b3 >> 4;
            if ((b3 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                i7 ^= 240;
            }
            byte b8 = (byte) i7;
            int i8 = (b4 & UnsignedBytes.MAX_POWER_OF_TWO) == 0 ? b4 >> 6 : (b4 >> 6) ^ 252;
            char[] cArr2 = f11400a;
            cArr[i5] = cArr2[b7];
            cArr[i5 + 1] = cArr2[b8 | (b6 << 4)];
            cArr[i5 + 2] = cArr2[(b5 << 2) | ((byte) i8)];
            cArr[i5 + 3] = cArr2[b4 & Utf8.REPLACEMENT_BYTE];
            i3++;
            i5 += 4;
            i4 += 3;
        }
        if (i == 8) {
            byte b9 = bArr[i4];
            byte b10 = (byte) (b9 & 3);
            int i9 = b9 >> 2;
            if ((b9 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                i9 ^= PsExtractor.AUDIO_STREAM;
            }
            char[] cArr3 = f11400a;
            cArr[i5] = cArr3[(byte) i9];
            cArr[i5 + 1] = cArr3[b10 << 4];
            cArr[i5 + 2] = '=';
            cArr[i5 + 3] = '=';
        } else if (i == 16) {
            byte b11 = bArr[i4];
            byte b12 = bArr[i4 + 1];
            byte b13 = (byte) (b12 & 15);
            byte b14 = (byte) (b11 & 3);
            int i10 = b11 >> 2;
            if ((b11 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                i10 ^= PsExtractor.AUDIO_STREAM;
            }
            byte b15 = (byte) i10;
            int i11 = b12 >> 4;
            if ((b12 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                i11 ^= 240;
            }
            char[] cArr4 = f11400a;
            cArr[i5] = cArr4[b15];
            cArr[i5 + 1] = cArr4[((byte) i11) | (b14 << 4)];
            cArr[i5 + 2] = cArr4[b13 << 2];
            cArr[i5 + 3] = '=';
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        char c;
        if (str == null) {
            return new byte[0];
        }
        char[] charArray = str.toCharArray();
        int iA = a(charArray);
        if (iA % 4 != 0) {
            return new byte[0];
        }
        int i = iA / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i * 3];
        int i2 = 0;
        char c2 = 0;
        char c3 = 0;
        char c4 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 < i - 1) {
                int i5 = i2 + 1;
                char c5 = charArray[i2];
                if (c(c5)) {
                    int i6 = i2 + 2;
                    char c6 = charArray[i5];
                    if (c(c6)) {
                        int i7 = i2 + 3;
                        char c7 = charArray[i6];
                        if (c(c7)) {
                            i2 += 4;
                            c3 = charArray[i7];
                            if (c(c3)) {
                                z = false;
                                c2 = c7;
                                c4 = c6;
                            } else {
                                c2 = c7;
                                c4 = c6;
                                i5 = i2;
                                i2 = i5;
                            }
                        } else {
                            c = c6;
                            i5 = i7;
                            c2 = c7;
                        }
                    } else {
                        c = c6;
                        i5 = i6;
                    }
                    c4 = c;
                    i2 = i5;
                } else {
                    i2 = i5;
                }
                if (z) {
                    return new byte[0];
                }
                byte[] bArr2 = b;
                byte b2 = bArr2[c5];
                byte b3 = bArr2[c4];
                byte b4 = bArr2[c2];
                byte b5 = bArr2[c3];
                bArr[i4] = (byte) ((b2 << 2) | (b3 >> 4));
                int i8 = i4 + 2;
                bArr[i4 + 1] = (byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15));
                i4 += 3;
                bArr[i8] = (byte) (b5 | (b4 << 6));
                i3++;
            } else {
                int i9 = i2 + 1;
                char c8 = charArray[i2];
                if (c(c8)) {
                    int i10 = i2 + 2;
                    char c9 = charArray[i9];
                    if (c(c9)) {
                        byte[] bArr3 = b;
                        byte b6 = bArr3[c8];
                        byte b7 = bArr3[c9];
                        char c10 = charArray[i10];
                        char c11 = charArray[i2 + 3];
                        if (!c(c10) || !c(c11)) {
                            return a(bArr, b6, b7, c10, c11, i3, i4);
                        }
                        byte b8 = bArr3[c10];
                        byte b9 = bArr3[c11];
                        bArr[i4] = (byte) ((b6 << 2) | (b7 >> 4));
                        bArr[i4 + 1] = (byte) (((b7 & 15) << 4) | ((b8 >> 2) & 15));
                        bArr[i4 + 2] = (byte) (b9 | (b8 << 6));
                        return bArr;
                    }
                }
                return new byte[0];
            }
        }
    }

    private static byte[] a(byte[] bArr, byte b2, byte b3, char c, char c2, int i, int i2) {
        if (b(c) && b(c2)) {
            if ((b3 & 15) != 0) {
                return new byte[0];
            }
            int i3 = i * 3;
            byte[] bArr2 = new byte[i3 + 1];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            bArr2[i2] = (byte) ((b2 << 2) | (b3 >> 4));
            return bArr2;
        }
        if (b(c) || !b(c2)) {
            return new byte[0];
        }
        byte b4 = b[c];
        if ((b4 & 3) != 0) {
            return new byte[0];
        }
        int i4 = i * 3;
        byte[] bArr3 = new byte[i4 + 2];
        System.arraycopy(bArr, 0, bArr3, 0, i4);
        bArr3[i2] = (byte) ((b2 << 2) | (b3 >> 4));
        bArr3[i2 + 1] = (byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15));
        return bArr3;
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!a(cArr[i2])) {
                cArr[i] = cArr[i2];
                i++;
            }
        }
        return i;
    }

    public static String b(byte[] bArr) {
        String strA = a(bArr);
        return (strA == null || !strA.endsWith("\n")) ? strA : SafeString.substring(strA, 0, strA.length() - 1);
    }

    public static String b(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
        } catch (IOException e) {
            e = e;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String strB = b(bArr);
            de.a(fileInputStream);
            return strB;
        } catch (IOException e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            HwLog.e("Base64", "imageFileToBase64 IOException:" + HwLog.printException((Exception) e));
            de.a(fileInputStream2);
            return "";
        } catch (Exception e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            HwLog.e("Base64", "imageFileToBase64 Exception:" + HwLog.printException(e));
            de.a(fileInputStream2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            de.a(fileInputStream);
            throw th;
        }
    }
}
