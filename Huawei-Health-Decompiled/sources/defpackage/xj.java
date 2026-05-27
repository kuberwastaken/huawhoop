package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes9.dex */
public final class xj extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f19024a;
    private byte[] b;
    private int c;
    private final xb d;
    private final int e;

    public xj(xb xbVar, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.d = xbVar;
        this.f19024a = inputStream;
        this.b = bArr;
        this.c = i;
        this.e = i2;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.b != null) {
            return this.e - this.c;
        }
        return this.f19024a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        d();
        this.f19024a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            if (this.b == null) {
                this.f19024a.mark(i);
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.b == null && this.f19024a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = this.b;
        if (bArr != null) {
            int i = this.c;
            int i2 = i + 1;
            this.c = i2;
            byte b = bArr[i];
            if (i2 >= this.e) {
                d();
            }
            return b & UnsignedBytes.MAX_VALUE;
        }
        return this.f19024a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = this.b;
        if (bArr2 != null) {
            int i3 = this.e;
            int i4 = this.c;
            int i5 = i3 - i4;
            if (i2 > i5) {
                i2 = i5;
            }
            System.arraycopy(bArr2, i4, bArr, i, i2);
            int i6 = this.c + i2;
            this.c = i6;
            if (i6 >= this.e) {
                d();
            }
            return i2;
        }
        return this.f19024a.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            if (this.b == null) {
                this.f19024a.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2;
        if (this.b != null) {
            int i = this.e;
            int i2 = this.c;
            j2 = i - i2;
            if (j2 > j) {
                this.c = i2 + ((int) j);
                return j;
            }
            d();
            j -= j2;
        } else {
            j2 = 0;
        }
        return j > 0 ? j2 + this.f19024a.skip(j) : j2;
    }

    private void d() {
        byte[] bArr = this.b;
        if (bArr != null) {
            this.b = null;
            xb xbVar = this.d;
            if (xbVar != null) {
                xbVar.b(bArr);
            }
        }
    }
}
