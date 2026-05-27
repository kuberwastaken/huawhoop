package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class chu {
    private static byte[] b(String str, Charset charset) {
        return str == null ? new byte[0] : str.getBytes(charset);
    }

    public static byte[] b(String str) {
        return b(str, cir.e);
    }

    private static String b(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String a(byte[] bArr) {
        return b(bArr, cir.e);
    }

    public static String d(Object obj) {
        return obj == null ? "" : obj.toString().trim();
    }
}
