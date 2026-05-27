package defpackage;

import com.google.common.base.Ascii;
import com.huawei.devicesdk.util.rsa.BaseCodec;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public class cis extends BaseCodec {
    private final byte[] f;
    private final int g;
    private final byte[] h;
    private final byte[] i;
    private final int j;
    static final byte[] b = {13, 10};
    private static final char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f659a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.i, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public cis() {
        this(0);
    }

    public cis(boolean z) {
        this(76, b, z);
    }

    public cis(int i) {
        this(i, b);
    }

    public cis(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public cis(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.f = e;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                throw new IllegalArgumentException("myLineSeparator must not contain base64 characters: [" + chu.a(bArr) + "]");
            }
            if (i > 0) {
                this.g = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.h = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.g = 4;
                this.h = null;
            }
        } else {
            this.g = 4;
            this.h = null;
        }
        this.j = this.g - 1;
        this.i = z ? f659a : c;
    }

    public static String b(byte[] bArr) {
        return chu.a(a(bArr, false));
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return e(bArr, z, false);
    }

    public static byte[] e(byte[] bArr, boolean z, boolean z2) {
        return d(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] d(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        cis cisVar = z ? new cis(z2) : new cis(0, b, z2);
        long encodedLength = cisVar.getEncodedLength(bArr);
        if (encodedLength > i) {
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
        }
        return cisVar.encode(bArr);
    }

    public static byte[] c(String str) {
        return new cis().decode(str);
    }

    @Override // com.huawei.devicesdk.util.rsa.BaseCodec
    public void encode(byte[] bArr, int i, int i2, BaseCodec.e eVar) {
        if (eVar == null || eVar.e) {
            return;
        }
        if (i2 < 0) {
            e(eVar);
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            byte[] bArrEnsureBufferSize = ensureBufferSize(this.g, eVar);
            eVar.c = (eVar.c + 1) % 3;
            int i4 = bArr[i];
            if (i4 < 0) {
                i4 += 256;
            }
            eVar.f1992a = (eVar.f1992a << 8) + i4;
            if (eVar.c == 0) {
                int i5 = eVar.i;
                eVar.i = i5 + 1;
                bArrEnsureBufferSize[i5] = this.i[(eVar.f1992a >> 18) & 63];
                int i6 = eVar.i;
                eVar.i = i6 + 1;
                bArrEnsureBufferSize[i6] = this.i[(eVar.f1992a >> 12) & 63];
                int i7 = eVar.i;
                eVar.i = i7 + 1;
                bArrEnsureBufferSize[i7] = this.i[(eVar.f1992a >> 6) & 63];
                int i8 = eVar.i;
                eVar.i = i8 + 1;
                bArrEnsureBufferSize[i8] = this.i[eVar.f1992a & 63];
                eVar.b += 4;
                if (this.lineLength > 0 && this.lineLength <= eVar.b) {
                    System.arraycopy(this.h, 0, bArrEnsureBufferSize, eVar.i, this.h.length);
                    eVar.i += this.h.length;
                    eVar.b = 0;
                }
            }
            i3++;
            i++;
        }
    }

    private void e(BaseCodec.e eVar) {
        eVar.e = true;
        if (eVar.c == 0 && this.lineLength == 0) {
            return;
        }
        int i = eVar.i;
        byte[] bArrEnsureBufferSize = ensureBufferSize(this.g, eVar);
        int i2 = eVar.c;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = eVar.i;
                eVar.i = i3 + 1;
                bArrEnsureBufferSize[i3] = this.i[(eVar.f1992a >> 2) & 63];
                int i4 = eVar.i;
                eVar.i = i4 + 1;
                bArrEnsureBufferSize[i4] = this.i[(eVar.f1992a << 4) & 63];
                if (this.i == c) {
                    int i5 = eVar.i;
                    eVar.i = i5 + 1;
                    bArrEnsureBufferSize[i5] = 61;
                    int i6 = eVar.i;
                    eVar.i = i6 + 1;
                    bArrEnsureBufferSize[i6] = 61;
                }
            } else if (i2 == 2) {
                int i7 = eVar.i;
                eVar.i = i7 + 1;
                bArrEnsureBufferSize[i7] = this.i[(eVar.f1992a >> 10) & 63];
                int i8 = eVar.i;
                eVar.i = i8 + 1;
                bArrEnsureBufferSize[i8] = this.i[(eVar.f1992a >> 4) & 63];
                int i9 = eVar.i;
                eVar.i = i9 + 1;
                bArrEnsureBufferSize[i9] = this.i[(eVar.f1992a << 2) & 63];
                if (this.i == c) {
                    int i10 = eVar.i;
                    eVar.i = i10 + 1;
                    bArrEnsureBufferSize[i10] = 61;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + eVar.c);
            }
        }
        eVar.b += eVar.i - i;
        if (this.lineLength <= 0 || eVar.b <= 0) {
            return;
        }
        System.arraycopy(this.h, 0, bArrEnsureBufferSize, eVar.i, this.h.length);
        eVar.i += this.h.length;
    }

    @Override // com.huawei.devicesdk.util.rsa.BaseCodec
    public void decode(byte[] bArr, int i, int i2, BaseCodec.e eVar) {
        byte b2;
        if (eVar.e) {
            return;
        }
        if (i2 < 0) {
            eVar.e = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte b3 = bArr[i];
            if (b3 == 61) {
                eVar.e = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = e;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    eVar.c = (eVar.c + 1) % 4;
                    eVar.f1992a = (eVar.f1992a << 6) + b2;
                    if (eVar.c == 0) {
                        byte[] bArrEnsureBufferSize = ensureBufferSize(this.j, eVar);
                        int i4 = eVar.i;
                        eVar.i = i4 + 1;
                        bArrEnsureBufferSize[i4] = (byte) ((eVar.f1992a >> 16) & 255);
                        int i5 = eVar.i;
                        eVar.i = i5 + 1;
                        bArrEnsureBufferSize[i5] = (byte) ((eVar.f1992a >> 8) & 255);
                        int i6 = eVar.i;
                        eVar.i = i6 + 1;
                        bArrEnsureBufferSize[i6] = (byte) (eVar.f1992a & 255);
                    }
                }
            }
            i3++;
            i++;
        }
        b(eVar);
    }

    private void b(BaseCodec.e eVar) {
        if (!eVar.e || eVar.c == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize = ensureBufferSize(this.j, eVar);
        int i = eVar.c;
        if (i != 1) {
            if (i == 2) {
                eVar.f1992a >>= 4;
                int i2 = eVar.i;
                eVar.i = i2 + 1;
                bArrEnsureBufferSize[i2] = (byte) (eVar.f1992a & 255);
                return;
            }
            if (i == 3) {
                eVar.f1992a >>= 2;
                int i3 = eVar.i;
                eVar.i = i3 + 1;
                bArrEnsureBufferSize[i3] = (byte) ((eVar.f1992a >> 8) & 255);
                int i4 = eVar.i;
                eVar.i = i4 + 1;
                bArrEnsureBufferSize[i4] = (byte) (eVar.f1992a & 255);
                return;
            }
            throw new IllegalStateException("Impossible modulus " + eVar.c);
        }
    }

    @Override // com.huawei.devicesdk.util.rsa.BaseCodec
    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.f;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }
}
