package net.lingala.zip4j.io.inputstream;

import com.google.common.primitives.UnsignedBytes;
import defpackage.xwn;
import defpackage.xxg;
import defpackage.xxw;
import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.model.enums.CompressionMethod;

/* JADX INFO: loaded from: classes11.dex */
public abstract class CipherInputStream<T extends Decrypter> extends InputStream {
    private T decrypter;
    private byte[] lastReadRawDataCache;
    private xxg localFileHeader;
    private byte[] singleByteBuffer = new byte[1];
    private xwn zipEntryInputStream;

    protected void endOfEntryReached(InputStream inputStream, int i) throws IOException {
    }

    protected abstract T initializeDecrypter(xxg xxgVar, char[] cArr, boolean z) throws IOException;

    public CipherInputStream(xwn xwnVar, xxg xxgVar, char[] cArr, int i, boolean z) throws IOException {
        this.zipEntryInputStream = xwnVar;
        this.decrypter = (T) initializeDecrypter(xxgVar, cArr, z);
        this.localFileHeader = xxgVar;
        if (xxw.e(xxgVar).equals(CompressionMethod.DEFLATE)) {
            this.lastReadRawDataCache = new byte[i];
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0] & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iE = xxw.e(this.zipEntryInputStream, bArr, i, i2);
        if (iE > 0) {
            cacheRawData(bArr, iE);
            this.decrypter.decryptData(bArr, i, iE);
        }
        return iE;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zipEntryInputStream.close();
    }

    public byte[] getLastReadRawDataCache() {
        return this.lastReadRawDataCache;
    }

    protected int readRaw(byte[] bArr) throws IOException {
        return this.zipEntryInputStream.c(bArr);
    }

    private void cacheRawData(byte[] bArr, int i) {
        byte[] bArr2 = this.lastReadRawDataCache;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }
    }

    public T getDecrypter() {
        return this.decrypter;
    }

    protected long getNumberOfBytesReadForThisEntry() {
        return this.zipEntryInputStream.a();
    }

    public xxg getLocalFileHeader() {
        return this.localFileHeader;
    }
}
