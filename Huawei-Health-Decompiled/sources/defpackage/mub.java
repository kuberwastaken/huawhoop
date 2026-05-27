package defpackage;

import com.google.common.primitives.UnsignedBytes;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes6.dex */
public class mub {
    private int a(int i) {
        return i & 15;
    }

    private int d(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    private int e(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        return (i & i3) != 0 ? (i3 - (i & (i3 - 1))) * (-1) : i;
    }

    private int a(byte b, byte b2) {
        return d(b) + (d(b2) << 8);
    }

    private int a(byte b, byte b2, byte b3) {
        return d(b) + (d(b2) << 8) + (d(b3) << 16);
    }

    private int e(byte b, byte b2, byte b3, byte b4) {
        return d(b) + (d(b2) << 8) + (d(b3) << 16) + (d(b4) << 24);
    }

    protected int e(byte[] bArr, int i, int i2) {
        if (bArr == null || a(i) + i2 > bArr.length) {
            return -1;
        }
        if (i == 17) {
            return d(bArr[i2]);
        }
        if (i == 18) {
            return a(bArr[i2], bArr[i2 + 1]);
        }
        if (i == 20) {
            return e(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]);
        }
        if (i == 36) {
            return e(e(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]), 32);
        }
        if (i == 33) {
            return e(d(bArr[i2]), 8);
        }
        if (i == 34) {
            return e(a(bArr[i2], bArr[i2 + 1]), 16);
        }
        LogUtil.d("GattParser", "no formatType");
        return -1;
    }

    protected int c(byte[] bArr, int i) {
        if (bArr == null || i + 3 > bArr.length) {
            return -1;
        }
        return a(bArr[i], bArr[i + 1], bArr[i + 2]);
    }
}
