package defpackage;

import java.io.IOException;
import java.util.zip.Deflater;
import net.lingala.zip4j.io.outputstream.CipherOutputStream;
import net.lingala.zip4j.io.outputstream.CompressedOutputStream;
import net.lingala.zip4j.model.enums.CompressionLevel;

/* JADX INFO: loaded from: classes8.dex */
class xwq extends CompressedOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f19178a;
    protected Deflater b;

    public xwq(CipherOutputStream<?> cipherOutputStream, CompressionLevel compressionLevel, int i) {
        super(cipherOutputStream);
        this.b = new Deflater(compressionLevel.getLevel(), true);
        this.f19178a = new byte[i];
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.b.setInput(bArr, i, i2);
        while (!this.b.needsInput()) {
            d();
        }
    }

    private void d() throws IOException {
        Deflater deflater = this.b;
        byte[] bArr = this.f19178a;
        int iDeflate = deflater.deflate(bArr, 0, bArr.length);
        if (iDeflate > 0) {
            super.write(this.f19178a, 0, iDeflate);
        }
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream
    public void closeEntry() throws IOException {
        if (!this.b.finished()) {
            this.b.finish();
            while (!this.b.finished()) {
                d();
            }
        }
        this.b.end();
        super.closeEntry();
    }
}
