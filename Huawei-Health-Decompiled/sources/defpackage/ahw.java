package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes9.dex */
public class ahw extends InputStream {
    protected final ByteBuffer e;

    public ahw(ByteBuffer byteBuffer) {
        this.e = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.e.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.e.hasRemaining()) {
            return this.e.get() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.e.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i2, this.e.remaining());
        this.e.get(bArr, i, iMin);
        return iMin;
    }
}
