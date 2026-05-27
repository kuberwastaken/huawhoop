package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes9.dex */
public class ahx extends OutputStream {
    protected final ByteBuffer b;

    public ahx(ByteBuffer byteBuffer) {
        this.b = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.b.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.b.put(bArr, i, i2);
    }
}
