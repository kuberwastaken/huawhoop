package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public class xwn extends InputStream {
    private InputStream c;
    private long e;
    private long d = 0;
    private byte[] b = new byte[1];

    public xwn(InputStream inputStream, long j) {
        this.c = inputStream;
        this.e = j;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.b) == -1) {
            return -1;
        }
        return this.b[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.e;
        if (j != -1) {
            long j2 = this.d;
            if (j2 >= j) {
                return -1;
            }
            long j3 = j - j2;
            if (i2 > j3) {
                i2 = (int) j3;
            }
        }
        int i3 = this.c.read(bArr, i, i2);
        if (i3 > 0) {
            this.d += (long) i3;
        }
        return i3;
    }

    public int c(byte[] bArr) throws IOException {
        int iA = this.c.read(bArr);
        if (iA == -1) {
            throw new IOException("Unexpected EOF reached when trying to read stream");
        }
        if (iA == bArr.length || (iA = a(bArr, iA)) == bArr.length) {
            return iA;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    private int a(byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int i2 = 0;
        for (int i3 = 0; i < bArr.length && i2 != -1 && i3 < 15; i3++) {
            i2 += this.c.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
        }
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public long a() {
        return this.d;
    }
}
