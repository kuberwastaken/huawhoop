package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import net.lingala.zip4j.crypto.Encrypter;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: loaded from: classes8.dex */
public class xvz implements Encrypter {
    private final xwb b = new xwb();
    private byte[] d;

    public xvz(char[] cArr, long j, boolean z) throws ZipException {
        e(cArr, j, z);
    }

    private void e(char[] cArr, long j, boolean z) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.b.d(cArr, z);
        this.d = e();
        this.b.d(cArr, z);
        byte[] bArr = this.d;
        bArr[11] = (byte) (j >>> 24);
        bArr[10] = (byte) (j >>> 16);
        encryptData(bArr);
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr) throws ZipException {
        bArr.getClass();
        return encryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 < 0) {
            throw new ZipException("invalid length specified to decrpyt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            bArr[i3] = b(bArr[i3]);
        }
        return i2;
    }

    protected byte b(byte b) {
        byte bC = (byte) ((this.b.c() & UnsignedBytes.MAX_VALUE) ^ b);
        this.b.c(b);
        return bC;
    }

    protected byte[] e() {
        byte[] bArr = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 12; i++) {
            bArr[i] = b((byte) secureRandom.nextInt(256));
        }
        return bArr;
    }

    public byte[] d() {
        return this.d;
    }
}
