package defpackage;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes8.dex */
public final class ycb {
    private final boolean c;
    private final int d;
    private final int e;

    public static int d(int i) {
        if (i <= 0) {
            return 16;
        }
        if (i >= 6) {
            return 1024;
        }
        return 1 << (i + 4);
    }

    public ycb(int i, boolean z, int i2) {
        if (i < 0 || 7 < i) {
            throw new IllegalArgumentException("Block option's szx " + i + " must be between 0 and 7 inclusive");
        }
        if (i2 < 0 || 1048575 < i2) {
            throw new IllegalArgumentException("Block option's num " + i2 + " must be between 0 and 524288 inclusive");
        }
        this.e = i;
        this.c = z;
        this.d = i2;
    }

    public ycb(byte[] bArr) {
        bArr.getClass();
        if (bArr.length > 3) {
            throw new IllegalArgumentException("Block option's length " + bArr.length + " must be at most 3 bytes inclusive");
        }
        if (bArr.length == 0) {
            this.e = 0;
            this.c = false;
            this.d = 0;
            return;
        }
        byte b = bArr[bArr.length - 1];
        this.e = b & 7;
        this.c = ((b >> 3) & 1) == 1;
        int i = (b & UnsignedBytes.MAX_VALUE) >> 4;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            i += (bArr[(bArr.length - i2) - 1] & UnsignedBytes.MAX_VALUE) << ((i2 * 8) - 4);
        }
        this.d = i;
    }

    public boolean j() {
        return this.e == 7;
    }

    public void e(int i) {
        int iA;
        if (this.e >= 7 || i <= 0 || i <= (iA = a())) {
            return;
        }
        throw new IllegalStateException("Message with " + i + " bytes payload exceeds the blocksize of " + iA + " bytes!");
    }

    public int e() {
        return this.e;
    }

    public int a() {
        return d(this.e);
    }

    public boolean i() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public byte[] b() {
        int i = this.e;
        boolean z = this.c;
        int i2 = (z ? 8 : 0) | i;
        int i3 = this.d;
        if (i3 == 0 && !z && i == 0) {
            return ygc.d;
        }
        return i3 < 16 ? new byte[]{(byte) ((i3 << 4) | i2)} : i3 < 4096 ? new byte[]{(byte) (i3 >> 4), (byte) (i2 | (i3 << 4))} : new byte[]{(byte) (i3 >> 12), (byte) (i3 >> 4), (byte) (i2 | (i3 << 4))};
    }

    public int d() {
        return this.d * d(this.e);
    }

    public String toString() {
        return String.format("(szx=%d/%d, m=%b, num=%d)", Integer.valueOf(this.e), Integer.valueOf(d(this.e)), Boolean.valueOf(this.c), Integer.valueOf(this.d));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ycb)) {
            return false;
        }
        ycb ycbVar = (ycb) obj;
        return this.e == ycbVar.e && this.d == ycbVar.d && this.c == ycbVar.c;
    }

    public int hashCode() {
        return (((this.e * 31) + (this.c ? 1 : 0)) * 31) + this.d;
    }

    public static int a(int i) {
        if (i >= 1024) {
            return 6;
        }
        if (i <= 16) {
            return 0;
        }
        return Integer.numberOfTrailingZeros(Integer.highestOneBit(i)) - 4;
    }
}
