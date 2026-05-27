package defpackage;

import com.google.common.primitives.UnsignedBytes;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: loaded from: classes11.dex */
public class xvv implements Decrypter {
    private xwb c = new xwb();

    public xvv(char[] cArr, long j, long j2, byte[] bArr, boolean z) throws ZipException {
        e(bArr, cArr, j2, j, z);
    }

    @Override // net.lingala.zip4j.crypto.Decrypter
    public int decryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i < 0 || i2 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrypt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b = bArr[i3];
            byte bC = this.c.c();
            xwb xwbVar = this.c;
            byte b2 = (byte) (((b & UnsignedBytes.MAX_VALUE) ^ bC) & 255);
            xwbVar.c(b2);
            bArr[i3] = b2;
        }
        return i2;
    }

    private void e(byte[] bArr, char[] cArr, long j, long j2, boolean z) throws ZipException {
        byte bC;
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("Wrong password!", ZipException.Type.WRONG_PASSWORD);
        }
        this.c.d(cArr, z);
        int i = 0;
        byte b = bArr[0];
        while (i < 12) {
            i++;
            if (i == 12 && (bC = (byte) (this.c.c() ^ b)) != ((byte) (j2 >> 24)) && bC != ((byte) (j >> 8))) {
                throw new ZipException("Wrong password!", ZipException.Type.WRONG_PASSWORD);
            }
            xwb xwbVar = this.c;
            xwbVar.c((byte) (xwbVar.c() ^ b));
            if (i != 12) {
                b = bArr[i];
            }
        }
    }
}
