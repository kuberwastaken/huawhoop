package com.huawei.hms.scankit.p;

import java.util.Arrays;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class r implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f6050a;
    private int[] b;
    private int c;

    private int e(int i) {
        int i2 = 0;
        while (i > 0) {
            i &= i - 1;
            i2++;
        }
        return i2;
    }

    public String toString() {
        int i = this.c;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.c; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(b(i2) ? 'X' : FilenameUtils.EXTENSION_SEPARATOR);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public r m916clone() {
        return new r((int[]) this.f6050a.clone(), this.c);
    }

    public r() {
        this.c = 0;
        this.f6050a = new int[1];
    }

    public int e() {
        return (this.c + 7) / 8;
    }

    public void h() {
        for (int i = 0; i < this.c - 1; i++) {
            if (!b(i) && b(i + 1)) {
                g(i);
            }
        }
    }

    public r(int i) {
        this.c = i;
        this.f6050a = f(i);
    }

    public void b() {
        this.b = this.f6050a;
    }

    public void i() {
        for (int i = 0; i < this.c - 1; i++) {
            if (b(i) && !b(i + 1)) {
                h(i);
            }
        }
    }

    r(int[] iArr, int i) {
        this.f6050a = iArr;
        this.c = i;
    }

    public int d(int i) {
        int i2 = this.c;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        if (!w7.a(this.f6050a, i3)) {
            return -1;
        }
        int i4 = (-(1 << (i & 31))) & (~this.f6050a[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f6050a;
            if (i3 == iArr.length) {
                return this.c;
            }
            if (w7.a(iArr, i3)) {
                i4 = ~this.f6050a[i3];
            }
        }
        int iNumberOfTrailingZeros = (i3 * 32) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.c;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public boolean b(int i) {
        return ((1 << (i & 31)) & this.f6050a[i / 32]) != 0;
    }

    public void h(int i) {
        int[] iArr = this.f6050a;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] - (1 << (i & 31));
    }

    public int d() {
        return this.c;
    }

    public void a(boolean z) {
        a(this.c + 1);
        if (z) {
            int[] iArr = this.f6050a;
            int i = this.c;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.c++;
    }

    public int[] c() {
        return this.f6050a;
    }

    public void g() {
        int[] iArr = new int[this.f6050a.length];
        int i = (this.c - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = this.f6050a[i3];
            long j2 = ((j >> 1) & 1431655765) | ((j & 1431655765) << 1);
            long j3 = ((j2 >> 2) & 858993459) | ((j2 & 858993459) << 2);
            long j4 = ((j3 >> 4) & 252645135) | ((j3 & 252645135) << 4);
            long j5 = ((j4 >> 8) & 16711935) | ((j4 & 16711935) << 8);
            iArr[i - i3] = (int) (((j5 >> 16) & 65535) | ((j5 & 65535) << 16));
        }
        int i4 = this.c;
        int i5 = i2 * 32;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i] = i7;
        }
        this.f6050a = iArr;
    }

    public void b(int i, int i2) {
        this.f6050a[i / 32] = i2;
    }

    private static int[] f(int i) {
        return new int[(i + 31) / 32];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.c == rVar.c && Arrays.equals(this.f6050a, rVar.f6050a);
    }

    public int hashCode() {
        return (this.c * 31) + Arrays.hashCode(this.f6050a);
    }

    public void f() {
        this.f6050a = this.b;
    }

    public int c(int i) {
        int i2 = this.c;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        if (!w7.a(this.f6050a, i3)) {
            return -1;
        }
        int i4 = (-(1 << (i & 31))) & this.f6050a[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f6050a;
            if (i3 == iArr.length) {
                return this.c;
            }
            if (w7.a(iArr, i3)) {
                i4 = this.f6050a[i3];
            }
        }
        int iNumberOfTrailingZeros = (i3 * 32) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.c;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public void g(int i) {
        int[] iArr = this.f6050a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void a(r rVar) {
        int i = rVar.c;
        a(this.c + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(rVar.b(i2));
        }
    }

    public void b(r rVar) {
        if (this.c != rVar.c) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f6050a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ rVar.f6050a[i];
            i++;
        }
    }

    public void c(int i, int i2) {
        if (i2 < i || i < 0 || i2 > this.c) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return;
        }
        int i3 = i2 - 1;
        int i4 = i / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = 31;
            int i8 = i6 > i4 ? 0 : i & 31;
            if (i6 >= i5) {
                i7 = 31 & i3;
            }
            int[] iArr = this.f6050a;
            iArr[i6] = ((2 << i7) - (1 << i8)) | iArr[i6];
            i6++;
        }
    }

    public void a(int i, int i2) {
        if (i2 >= 0 && i2 <= 32) {
            a(this.c + i2);
            while (i2 > 0) {
                boolean z = true;
                if (((i >> (i2 - 1)) & 1) != 1) {
                    z = false;
                }
                a(z);
                i2--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void a() {
        int length = this.f6050a.length;
        for (int i = 0; i < length; i++) {
            this.f6050a[i] = 0;
        }
    }

    private void a(int i) {
        if (i > this.f6050a.length * 32) {
            int[] iArrF = f(i);
            int[] iArr = this.f6050a;
            System.arraycopy(iArr, 0, iArrF, 0, iArr.length);
            this.f6050a = iArrF;
        }
    }

    public boolean a(int i, int i2, boolean z, boolean z2) {
        if (i2 < i || i < 0 || i2 > this.c) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return true;
        }
        int i3 = i2 - 1;
        int i4 = i / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        int iE = 0;
        while (i6 <= i5) {
            int i7 = (2 << (i6 < i5 ? 31 : i3 & 31)) - (1 << (i6 > i4 ? 0 : i & 31));
            if (!z2 && (iE = iE + e(this.f6050a[i6] & i7)) > (i3 - i) / 10) {
                return false;
            }
            if (z2) {
                if ((this.f6050a[i6] & i7) != (z ? i7 : 0)) {
                    return false;
                }
            }
            i6++;
        }
        return true;
    }

    public void a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (b(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }
}
