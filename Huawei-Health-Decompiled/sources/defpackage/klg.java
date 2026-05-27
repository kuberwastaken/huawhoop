package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class klg {
    private static final Object e = new Object();

    public static byte[] c(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null || bArr3 == null) {
            return (byte[]) new byte[0].clone();
        }
        synchronized (e) {
            kko kkoVar = i != 1 ? null : new kko(1);
            if (kkoVar == null) {
                return null;
            }
            return kkoVar.encrypt(bArr, bArr2, bArr3);
        }
    }

    public static byte[] e(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null || bArr3 == null) {
            return (byte[]) new byte[0].clone();
        }
        synchronized (e) {
            kko kkoVar = i != 1 ? null : new kko(1);
            if (kkoVar == null) {
                return null;
            }
            return kkoVar.desEncrypt(bArr, bArr2, bArr3);
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return (byte[]) new byte[0].clone();
        }
        byte[] bArr2 = new byte[16];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            System.arraycopy(messageDigest.digest(), 0, bArr2, 0, 16);
            return bArr2;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        if (bArr == null || bArr2 == null) {
            return (byte[]) new byte[0].clone();
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HMACSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        return mac.doFinal(bArr2);
    }

    public static byte[] d(int i) throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(i * 8, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }
}
