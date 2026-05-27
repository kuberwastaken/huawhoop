package defpackage;

import java.io.OutputStream;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes9.dex */
public final class ye extends OutputStream {
    public static final byte[] b = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yd f19269a;
    private final LinkedList<byte[]> c;
    private int d;
    private byte[] e;
    private int h;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public ye() {
        this((yd) null);
    }

    public ye(yd ydVar) {
        this(ydVar, 500);
    }

    public ye(int i) {
        this(null, i);
    }

    public ye(yd ydVar, int i) {
        this.c = new LinkedList<>();
        this.f19269a = ydVar;
        this.e = ydVar == null ? new byte[i > 131072 ? 131072 : i] : ydVar.a(2);
    }

    private ye(yd ydVar, byte[] bArr, int i) {
        this.c = new LinkedList<>();
        this.f19269a = null;
        this.e = bArr;
        this.d = i;
    }

    public static ye b(byte[] bArr, int i) {
        return new ye(null, bArr, i);
    }

    public void b() {
        this.h = 0;
        this.d = 0;
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    public void a() {
        byte[] bArr;
        b();
        yd ydVar = this.f19269a;
        if (ydVar == null || (bArr = this.e) == null) {
            return;
        }
        ydVar.c(2, bArr);
        this.e = null;
    }

    public void e(int i) {
        if (this.d >= this.e.length) {
            j();
        }
        byte[] bArr = this.e;
        int i2 = this.d;
        this.d = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void d(int i) {
        int i2 = this.d;
        byte[] bArr = this.e;
        int i3 = i2 + 1;
        if (i3 < bArr.length) {
            bArr[i2] = (byte) (i >> 8);
            this.d = i2 + 2;
            bArr[i3] = (byte) i;
        } else {
            e(i >> 8);
            e(i);
        }
    }

    public void a(int i) {
        int i2 = this.d;
        byte[] bArr = this.e;
        if (i2 + 2 < bArr.length) {
            bArr[i2] = (byte) (i >> 16);
            bArr[i2 + 1] = (byte) (i >> 8);
            this.d = i2 + 3;
            bArr[i2 + 2] = (byte) i;
            return;
        }
        e(i >> 16);
        e(i >> 8);
        e(i);
    }

    public byte[] i() {
        int i = this.h + this.d;
        if (i == 0) {
            return b;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.c) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this.e, 0, bArr, i2, this.d);
        int i3 = i2 + this.d;
        if (i3 != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
        }
        if (!this.c.isEmpty()) {
            b();
        }
        return bArr;
    }

    public byte[] f() {
        b();
        return this.e;
    }

    public byte[] d() {
        j();
        return this.e;
    }

    public byte[] c(int i) {
        this.d = i;
        return i();
    }

    public byte[] c() {
        return this.e;
    }

    public void b(int i) {
        this.d = i;
    }

    public int e() {
        return this.d;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int iMin = Math.min(this.e.length - this.d, i2);
            if (iMin > 0) {
                System.arraycopy(bArr, i, this.e, this.d, iMin);
                i += iMin;
                this.d += iMin;
                i2 -= iMin;
            }
            if (i2 <= 0) {
                return;
            } else {
                j();
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        e(i);
    }

    private void j() {
        int length = this.h + this.e.length;
        if (length < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this.h = length;
        int iMax = Math.max(length >> 1, 1000);
        if (iMax > 131072) {
            iMax = 131072;
        }
        this.c.add(this.e);
        this.e = new byte[iMax];
        this.d = 0;
    }
}
