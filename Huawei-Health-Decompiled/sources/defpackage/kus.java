package defpackage;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes5.dex */
public class kus {
    public static int d(byte[] bArr) {
        int i = ((bArr[0] & UnsignedBytes.MAX_VALUE) << 24) + ((bArr[1] & UnsignedBytes.MAX_VALUE) << 16) + ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[3] & UnsignedBytes.MAX_VALUE);
        return i < 0 ? i + 256 : i;
    }
}
