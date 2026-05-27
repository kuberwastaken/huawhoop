package health.compact.a;

import com.google.common.base.Ascii;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import com.huawei.hwencryptmodel.rsa.BaseCodec;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class Base64 extends BaseCodec {
    private final int f;
    private final byte[] g;
    private final byte[] h;
    private final byte[] i;
    private final int j;
    static final byte[] d = {13, 10};
    private static final char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f13730a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.i, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public Base64() {
        this(0);
    }

    public Base64(boolean z) {
        this(76, d, z);
    }

    public Base64(int i) {
        this(i, d);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.g = e;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                throw new IllegalArgumentException("myLineSeparator must not contain base64 characters: [" + StringUtils.c(bArr) + "]");
            }
            if (i > 0) {
                this.f = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.i = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.f = 4;
                this.i = null;
            }
        } else {
            this.f = 4;
            this.i = null;
        }
        this.j = this.f - 1;
        this.h = z ? c : f13730a;
    }

    public static String e(byte[] bArr) {
        return StringUtils.c(a(bArr, false));
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return d(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] d(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, d, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength > i) {
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
        }
        return base64.encode(bArr);
    }

    public static byte[] e(String str) {
        return new Base64().decode(str);
    }

    private static void c(byte[] bArr, int i, int i2, char[] cArr, int i3) {
        byte b2 = bArr[i];
        char[] cArr2 = b;
        cArr[i3] = cArr2[(b2 >>> 2) & 63];
        if (i2 > 2) {
            byte b3 = bArr[i + 1];
            byte b4 = bArr[i + 2];
            cArr[i3 + 1] = cArr2[((b2 << 4) & 48) + ((b3 >>> 4) & 15)];
            cArr[i3 + 2] = cArr2[((b3 << 2) & 60) + ((b4 >>> 6) & 3)];
            cArr[i3 + 3] = cArr2[b4 & Utf8.REPLACEMENT_BYTE];
            return;
        }
        if (i2 > 1) {
            byte b5 = bArr[i + 1];
            cArr[i3 + 1] = cArr2[((b2 << 4) & 48) + ((b5 >>> 4) & 15)];
            cArr[i3 + 2] = cArr2[(b5 << 2) & 60];
            cArr[i3 + 3] = '=';
            return;
        }
        cArr[i3 + 1] = cArr2[(b2 << 4) & 48];
        cArr[i3 + 2] = '=';
        cArr[i3 + 3] = '=';
    }

    public static String b(byte[] bArr, int i, int i2) {
        int i3 = ((i2 + 2) / 3) * 4;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5 += 4) {
            c(bArr, i + i4, i2 - i4, cArr, i5);
            i4 += 3;
        }
        return new String(cArr);
    }

    @Override // com.huawei.hwencryptmodel.rsa.BaseCodec
    public void encode(byte[] bArr, int i, int i2, BaseCodec.e eVar) {
        if (eVar == null || eVar.c) {
            return;
        }
        if (i2 < 0) {
            d(eVar);
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            byte[] bArrEnsureBufferSize = ensureBufferSize(this.f, eVar);
            eVar.f6579a = (eVar.f6579a + 1) % 3;
            int i4 = bArr[i];
            if (i4 < 0) {
                i4 += 256;
            }
            eVar.d = (eVar.d << 8) + i4;
            if (eVar.f6579a == 0) {
                int i5 = eVar.j;
                eVar.j = i5 + 1;
                bArrEnsureBufferSize[i5] = this.h[(eVar.d >> 18) & 63];
                int i6 = eVar.j;
                eVar.j = i6 + 1;
                bArrEnsureBufferSize[i6] = this.h[(eVar.d >> 12) & 63];
                int i7 = eVar.j;
                eVar.j = i7 + 1;
                bArrEnsureBufferSize[i7] = this.h[(eVar.d >> 6) & 63];
                int i8 = eVar.j;
                eVar.j = i8 + 1;
                bArrEnsureBufferSize[i8] = this.h[eVar.d & 63];
                eVar.e += 4;
                if (this.lineLength > 0 && this.lineLength <= eVar.e) {
                    System.arraycopy(this.i, 0, bArrEnsureBufferSize, eVar.j, this.i.length);
                    eVar.j += this.i.length;
                    eVar.e = 0;
                }
            }
            i3++;
            i++;
        }
    }

    private void d(BaseCodec.e eVar) {
        eVar.c = true;
        if (eVar.f6579a == 0 && this.lineLength == 0) {
            return;
        }
        int i = eVar.j;
        byte[] bArrEnsureBufferSize = ensureBufferSize(this.f, eVar);
        int i2 = eVar.f6579a;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = eVar.j;
                eVar.j = i3 + 1;
                bArrEnsureBufferSize[i3] = this.h[(eVar.d >> 2) & 63];
                int i4 = eVar.j;
                eVar.j = i4 + 1;
                bArrEnsureBufferSize[i4] = this.h[(eVar.d << 4) & 63];
                if (this.h == f13730a) {
                    int i5 = eVar.j;
                    eVar.j = i5 + 1;
                    bArrEnsureBufferSize[i5] = 61;
                    int i6 = eVar.j;
                    eVar.j = i6 + 1;
                    bArrEnsureBufferSize[i6] = 61;
                }
            } else if (i2 == 2) {
                int i7 = eVar.j;
                eVar.j = i7 + 1;
                bArrEnsureBufferSize[i7] = this.h[(eVar.d >> 10) & 63];
                int i8 = eVar.j;
                eVar.j = i8 + 1;
                bArrEnsureBufferSize[i8] = this.h[(eVar.d >> 4) & 63];
                int i9 = eVar.j;
                eVar.j = i9 + 1;
                bArrEnsureBufferSize[i9] = this.h[(eVar.d << 2) & 63];
                if (this.h == f13730a) {
                    int i10 = eVar.j;
                    eVar.j = i10 + 1;
                    bArrEnsureBufferSize[i10] = 61;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + eVar.f6579a);
            }
        }
        eVar.e += eVar.j - i;
        if (this.lineLength <= 0 || eVar.e <= 0) {
            return;
        }
        System.arraycopy(this.i, 0, bArrEnsureBufferSize, eVar.j, this.i.length);
        eVar.j += this.i.length;
    }

    @Override // com.huawei.hwencryptmodel.rsa.BaseCodec
    public void decode(byte[] bArr, int i, int i2, BaseCodec.e eVar) {
        byte b2;
        if (eVar.c) {
            return;
        }
        if (i2 < 0) {
            eVar.c = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte b3 = bArr[i];
            if (b3 == 61) {
                eVar.c = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = e;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    eVar.f6579a = (eVar.f6579a + 1) % 4;
                    eVar.d = (eVar.d << 6) + b2;
                    if (eVar.f6579a == 0) {
                        byte[] bArrEnsureBufferSize = ensureBufferSize(this.j, eVar);
                        int i4 = eVar.j;
                        eVar.j = i4 + 1;
                        bArrEnsureBufferSize[i4] = (byte) ((eVar.d >> 16) & 255);
                        int i5 = eVar.j;
                        eVar.j = i5 + 1;
                        bArrEnsureBufferSize[i5] = (byte) ((eVar.d >> 8) & 255);
                        int i6 = eVar.j;
                        eVar.j = i6 + 1;
                        bArrEnsureBufferSize[i6] = (byte) (eVar.d & 255);
                    }
                }
            }
            i3++;
            i++;
        }
        b(eVar);
    }

    private void b(BaseCodec.e eVar) {
        if (!eVar.c || eVar.f6579a == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize = ensureBufferSize(this.j, eVar);
        int i = eVar.f6579a;
        if (i != 1) {
            if (i == 2) {
                eVar.d >>= 4;
                int i2 = eVar.j;
                eVar.j = i2 + 1;
                bArrEnsureBufferSize[i2] = (byte) (eVar.d & 255);
                return;
            }
            if (i == 3) {
                eVar.d >>= 2;
                int i3 = eVar.j;
                eVar.j = i3 + 1;
                bArrEnsureBufferSize[i3] = (byte) ((eVar.d >> 8) & 255);
                int i4 = eVar.j;
                eVar.j = i4 + 1;
                bArrEnsureBufferSize[i4] = (byte) (eVar.d & 255);
                return;
            }
            throw new IllegalStateException("Impossible modulus " + eVar.f6579a);
        }
    }

    @Override // com.huawei.hwencryptmodel.rsa.BaseCodec
    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.g;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }
}
