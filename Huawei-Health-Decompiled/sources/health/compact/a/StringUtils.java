package health.compact.a;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class StringUtils {
    private StringUtils() {
    }

    private static byte[] e(String str, Charset charset) {
        return str == null ? new byte[0] : str.getBytes(charset);
    }

    public static byte[] e(String str) {
        return e(str, Charsets.c);
    }

    private static String b(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String c(byte[] bArr) {
        return b(bArr, Charsets.c);
    }
}
