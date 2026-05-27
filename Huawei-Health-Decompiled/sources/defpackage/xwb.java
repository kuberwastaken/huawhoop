package defpackage;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes8.dex */
public class xwb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f19170a = new int[256];
    private final int[] d = new int[3];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i2 & 1;
                i2 >>>= 1;
                if (i4 == 1) {
                    i2 ^= -306674912;
                }
            }
            f19170a[i] = i2;
        }
    }

    public void d(char[] cArr, boolean z) {
        int[] iArr = this.d;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (byte b : xxw.e(cArr, z)) {
            c((byte) (b & UnsignedBytes.MAX_VALUE));
        }
    }

    public void c(byte b) {
        int[] iArr = this.d;
        iArr[0] = c(iArr[0], b);
        int[] iArr2 = this.d;
        int i = iArr2[1] + (iArr2[0] & 255);
        iArr2[1] = i;
        int i2 = (i * 134775813) + 1;
        iArr2[1] = i2;
        iArr2[2] = c(iArr2[2], (byte) (i2 >> 24));
    }

    private int c(int i, byte b) {
        return (i >>> 8) ^ f19170a[(b ^ i) & 255];
    }

    public byte c() {
        int i = this.d[2] | 2;
        return (byte) ((i * (i ^ 1)) >>> 8);
    }
}
