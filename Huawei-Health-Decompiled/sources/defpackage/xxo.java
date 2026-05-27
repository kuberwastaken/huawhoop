package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: loaded from: classes8.dex */
public class xxo {
    private final byte[] e = new byte[2];
    private final byte[] b = new byte[4];
    private final byte[] c = new byte[8];

    public long a(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.c);
        return d(this.c, 0);
    }

    public long c(RandomAccessFile randomAccessFile, int i) throws IOException {
        d(this.c);
        randomAccessFile.readFully(this.c, 0, i);
        return d(this.c, 0);
    }

    public long e(InputStream inputStream) throws IOException {
        byte[] bArr = this.c;
        d(inputStream, bArr, bArr.length);
        return d(this.c, 0);
    }

    public long a(InputStream inputStream, int i) throws IOException {
        d(this.c);
        d(inputStream, this.c, i);
        return d(this.c, 0);
    }

    public long d(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            d(this.c);
        }
        System.arraycopy(bArr, i, this.c, 0, Math.min(bArr.length - i, 8));
        byte[] bArr2 = this.c;
        long j = bArr2[7] & UnsignedBytes.MAX_VALUE;
        long j2 = bArr2[6] & UnsignedBytes.MAX_VALUE;
        long j3 = bArr2[5] & UnsignedBytes.MAX_VALUE;
        long j4 = bArr2[4] & UnsignedBytes.MAX_VALUE;
        long j5 = bArr2[3] & UnsignedBytes.MAX_VALUE;
        return ((long) (bArr2[0] & UnsignedBytes.MAX_VALUE)) | (((((((((((((j << 8) | j2) << 8) | j3) << 8) | j4) << 8) | j5) << 8) | (bArr2[2] & UnsignedBytes.MAX_VALUE)) << 8) | ((long) (bArr2[1] & UnsignedBytes.MAX_VALUE))) << 8);
    }

    public int e(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.b);
        return e(this.b);
    }

    public int c(InputStream inputStream) throws IOException {
        d(inputStream, this.b, 4);
        return e(this.b);
    }

    public int e(byte[] bArr) {
        return b(bArr, 0);
    }

    public int b(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        return ((((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i + 2] & UnsignedBytes.MAX_VALUE)) << 16) | (b & UnsignedBytes.MAX_VALUE) | ((b2 & UnsignedBytes.MAX_VALUE) << 8);
    }

    public int d(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.e);
        return a(this.e, 0);
    }

    public int a(InputStream inputStream) throws IOException {
        byte[] bArr = this.e;
        d(inputStream, bArr, bArr.length);
        return a(this.e, 0);
    }

    public int a(byte[] bArr, int i) {
        return ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i] & UnsignedBytes.MAX_VALUE);
    }

    public void d(OutputStream outputStream, int i) throws IOException {
        c(this.e, 0, i);
        outputStream.write(this.e);
    }

    public void c(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i] = (byte) (i2 & 255);
    }

    public void b(OutputStream outputStream, int i) throws IOException {
        d(this.b, 0, i);
        outputStream.write(this.b);
    }

    public void d(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) (i2 >>> 24);
        bArr[i + 2] = (byte) (i2 >>> 16);
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i] = (byte) (i2 & 255);
    }

    public void e(OutputStream outputStream, long j) throws IOException {
        c(this.c, 0, j);
        outputStream.write(this.c);
    }

    public void c(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) (j >>> 56);
        bArr[i + 6] = (byte) (j >>> 48);
        bArr[i + 5] = (byte) (j >>> 40);
        bArr[i + 4] = (byte) (j >>> 32);
        bArr[i + 3] = (byte) (j >>> 24);
        bArr[i + 2] = (byte) (j >>> 16);
        bArr[i + 1] = (byte) (j >>> 8);
        bArr[i] = (byte) (j & 255);
    }

    private void d(InputStream inputStream, byte[] bArr, int i) throws IOException {
        if (xxw.e(inputStream, bArr, 0, i) != i) {
            throw new ZipException("Could not fill buffer");
        }
    }

    private void d(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }
}
