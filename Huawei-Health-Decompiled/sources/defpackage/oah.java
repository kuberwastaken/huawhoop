package defpackage;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes7.dex */
public final class oah {
    public static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder(128);
        if (bArr != null) {
            for (byte b : bArr) {
                int i = b & UnsignedBytes.MAX_VALUE;
                if (i < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i));
            }
        }
        return sb.toString();
    }
}
