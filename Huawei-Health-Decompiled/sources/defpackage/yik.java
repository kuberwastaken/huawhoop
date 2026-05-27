package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes8.dex */
public class yik extends ygc {
    public yik() {
        this(e());
    }

    public yik(byte[] bArr) {
        super(bArr);
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Random bytes array's length must be 32");
        }
    }

    public String e(int i) {
        StringBuilder sb = new StringBuilder();
        byte[] bArrC = c();
        Date date = new Date(((long) (((bArrC[0] & UnsignedBytes.MAX_VALUE) << 24) | ((bArrC[1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArrC[2] & UnsignedBytes.MAX_VALUE) << 8) | (bArrC[3] & UnsignedBytes.MAX_VALUE))) * 1000);
        String strA = ygp.a(i);
        sb.append(strA);
        sb.append("GMT Unix Time: ");
        sb.append(date);
        sb.append(ygp.b());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrC, 4, 32);
        sb.append(strA);
        sb.append("Random Bytes: ");
        sb.append(ygp.e(bArrCopyOfRange));
        sb.append(ygp.b());
        return sb.toString();
    }

    @Override // defpackage.ygc
    public String toString() {
        return e(0);
    }

    public static byte[] e() {
        byte[] bArrB = ygc.b(yji.a(), 32);
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        bArrB[0] = (byte) (iCurrentTimeMillis >> 24);
        bArrB[1] = (byte) (iCurrentTimeMillis >> 16);
        bArrB[2] = (byte) (iCurrentTimeMillis >> 8);
        bArrB[3] = (byte) iCurrentTimeMillis;
        return bArrB;
    }
}
