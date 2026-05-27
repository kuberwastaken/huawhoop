package defpackage;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes9.dex */
public class nm {
    public static String d = "DESede/CBC/PKCS5Padding";

    public static byte[] a(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(d);
            cipher.init(2, secretKeySpec, new IvParameterSpec(nn.b(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] e(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(d);
            cipher.init(1, secretKeySpec, new IvParameterSpec(nn.b(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(String str, String str2, String str3) {
        try {
            return np.b(e(str, str2.getBytes(), str3));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(String str, String str2, String str3) {
        try {
            return new String(a(str, np.b(str2), str3));
        } catch (Exception unused) {
            return null;
        }
    }
}
