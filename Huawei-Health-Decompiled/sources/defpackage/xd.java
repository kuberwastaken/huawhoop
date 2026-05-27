package defpackage;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes9.dex */
public class xd extends OutputStream {
    protected final DataOutput d;

    public xd(DataOutput dataOutput) {
        this.d = dataOutput;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.d.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.d.write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.d.write(bArr, i, i2);
    }
}
