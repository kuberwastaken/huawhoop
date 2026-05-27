package defpackage;

import androidx.core.view.ViewCompat;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes8.dex */
public final class ygf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19294a;
    private byte[] b;
    private int d;
    private final boolean g;
    private byte i;
    public static final AtomicLong e = new AtomicLong();
    public static final AtomicLong c = new AtomicLong();

    public ygf() {
        this(32, false);
    }

    public ygf(int i) {
        this(i, false);
    }

    public ygf(int i, boolean z) {
        this.g = z;
        this.b = new byte[i];
        h();
    }

    public void d(long j, int i) {
        if (i < 0 || i > 64) {
            throw new IllegalArgumentException(String.format("Number of bits must be 1 to 64, not %d", Integer.valueOf(i)));
        }
        if (i < 64 && (j >> i) != 0) {
            throw new IllegalArgumentException(String.format("Truncating value %d to %d-bit integer", Long.valueOf(j), Integer.valueOf(i)));
        }
        int i2 = (i + 7) / 8;
        if ((i & 7) == 0 && !d()) {
            c(i2);
            while (true) {
                i -= 8;
                if (i < 0) {
                    return;
                } else {
                    d((byte) (j >> i));
                }
            }
        } else {
            c(i2 + 1);
            while (true) {
                i--;
                if (i < 0) {
                    return;
                }
                if (((j >> i) & 1) != 0) {
                    this.i = (byte) (this.i | (1 << this.d));
                }
                int i3 = this.d - 1;
                this.d = i3;
                if (i3 < 0) {
                    i();
                }
            }
        }
    }

    public void e(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException(String.format("Number of bits must be 1 to 32, not %d", Integer.valueOf(i2)));
        }
        if (i2 < 32 && (i >> i2) != 0) {
            throw new IllegalArgumentException(String.format("Truncating value %d to %d-bit integer", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = (i2 + 7) / 8;
        if ((i2 & 7) == 0 && !d()) {
            c(i3);
            while (true) {
                i2 -= 8;
                if (i2 < 0) {
                    return;
                } else {
                    d((byte) (i >> i2));
                }
            }
        } else {
            c(i3 + 1);
            while (true) {
                i2--;
                if (i2 < 0) {
                    return;
                }
                if (((i >> i2) & 1) != 0) {
                    this.i = (byte) (this.i | (1 << this.d));
                }
                int i4 = this.d - 1;
                this.d = i4;
                if (i4 < 0) {
                    i();
                }
            }
        }
    }

    public void c(int i, int i2, int i3) {
        int i4 = ((i3 + 7) / 8) + i;
        int i5 = this.f19294a;
        if (i4 > i5) {
            c(i4 - i5);
        }
        int i6 = this.f19294a;
        int i7 = this.d;
        byte b = this.i;
        h();
        this.f19294a = i;
        e(i2, i3);
        if (this.f19294a < i6) {
            this.f19294a = i6;
            this.i = b;
            this.d = i7;
        }
    }

    public void d(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        e(bArr, 0, bArr.length);
    }

    public void e(byte[] bArr, int i, int i2) {
        if (bArr == null || i2 == 0) {
            return;
        }
        if (!d()) {
            d(bArr, i, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            e(bArr[i3 + i] & UnsignedBytes.MAX_VALUE, 8);
        }
    }

    public void b(byte b) {
        if (d()) {
            e(b & UnsignedBytes.MAX_VALUE, 8);
        } else {
            c(1);
            d(b);
        }
    }

    public void c(byte[] bArr, int i) {
        int iD = d(i);
        int iE = e(iD);
        if (bArr == null) {
            e(iE, iD);
            return;
        }
        if (iE == bArr.length) {
            throw new IllegalArgumentException(bArr.length + " bytes is too large for " + i + "!");
        }
        if (i < iD && (bArr.length >> i) != 0) {
            throw new IllegalArgumentException(String.format("Truncating value %d to %d-bit integer", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        }
        e(bArr.length, iD);
        d(bArr);
    }

    public void c(ygc ygcVar, int i) {
        c(ygcVar == null ? null : ygcVar.c(), i);
    }

    public int a(int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("Number of bits must be multiple of 8, not " + i + "!");
        }
        if (d()) {
            throw new IllegalStateException("bits are pending!");
        }
        int i2 = this.f19294a;
        int i3 = i / 8;
        c(i3);
        this.f19294a += i3;
        return i2;
    }

    public byte[] a() {
        i();
        byte[] bArrCopyOf = this.b;
        int length = bArrCopyOf.length;
        int i = this.f19294a;
        if (length == i) {
            this.b = ygc.d;
            c.incrementAndGet();
        } else {
            bArrCopyOf = Arrays.copyOf(bArrCopyOf, i);
            if (this.g) {
                Arrays.fill(this.b, 0, this.f19294a, (byte) 0);
            }
            e.incrementAndGet();
        }
        this.f19294a = 0;
        return bArrCopyOf;
    }

    public void c(ygf ygfVar) {
        ygfVar.i();
        d(ygfVar.b, 0, ygfVar.f19294a);
    }

    public void a(OutputStream outputStream) throws IOException {
        i();
        outputStream.write(this.b, 0, this.f19294a);
        this.f19294a = 0;
    }

    public void b(int i, int i2) {
        if (i2 % 8 != 0) {
            throw new IllegalArgumentException("Number of bits must be multiple of 8, not " + i2 + "!");
        }
        c(i, (this.f19294a - i) - (i2 / 8), i2);
    }

    public int e() {
        return this.f19294a;
    }

    public void b() {
        if (this.g) {
            Arrays.fill(this.b, 0, this.f19294a, (byte) 0);
        }
        this.f19294a = 0;
    }

    public void c() {
        b();
        this.b = ygc.d;
    }

    public void i() {
        if (d()) {
            c(1);
            d(this.i);
            h();
        }
    }

    public final boolean d() {
        return this.d < 7;
    }

    private final void h() {
        this.i = (byte) 0;
        this.d = 7;
    }

    private final void d(byte[] bArr, int i, int i2) {
        if (bArr == null || i2 <= 0) {
            return;
        }
        c(i2);
        System.arraycopy(bArr, i, this.b, this.f19294a, i2);
        this.f19294a += i2;
    }

    private final void d(byte b) {
        byte[] bArr = this.b;
        int i = this.f19294a;
        this.f19294a = i + 1;
        bArr[i] = b;
    }

    private final void c(int i) {
        int i2 = this.f19294a + i;
        if (i2 > this.b.length) {
            j(b(i2));
        }
    }

    private final void j(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.b, 0, bArr, 0, this.f19294a);
        if (this.g) {
            Arrays.fill(this.b, 0, this.f19294a, (byte) 0);
        }
        this.b = bArr;
    }

    private final int b(int i) {
        int length = this.b.length;
        if (length == 0) {
            length = 32;
        }
        if (length < i) {
            return i;
        }
        if (length > 1073741823) {
            return 1073741823;
        }
        return length;
    }

    public static int d(int i) {
        return i % 8 != 0 ? (i & (-8)) + 8 : i;
    }

    public static int e(int i) {
        if (i == 8) {
            return 255;
        }
        if (i == 16) {
            return 65535;
        }
        if (i == 24) {
            return ViewCompat.MEASURED_SIZE_MASK;
        }
        if (i == 32) {
            return -1;
        }
        throw new IllegalArgumentException("Var length Bits must be a multiple of 8, not " + i + "!");
    }

    public String toString() {
        byte[] bArrCopyOf = Arrays.copyOf(this.b, this.f19294a);
        if (bArrCopyOf == null || bArrCopyOf.length == 0) {
            return "--";
        }
        StringBuilder sb = new StringBuilder(bArrCopyOf.length * 3);
        for (int i = 0; i < bArrCopyOf.length; i++) {
            sb.append(String.format("%02X", Integer.valueOf(bArrCopyOf[i] & UnsignedBytes.MAX_VALUE)));
            if (i < bArrCopyOf.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
