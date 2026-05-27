package defpackage;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes9.dex */
class qy {
    qy() {
    }

    boolean d(String str, byte[] bArr, String str2, String str3, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        return a(str, bArr, str2.getBytes(StandardCharsets.UTF_8), str3.getBytes(StandardCharsets.UTF_8), bArr2);
    }

    boolean a(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws NoSuchAlgorithmException, InvalidKeyException {
        return MessageDigest.isEqual(b(str, bArr, bArr2, bArr3), bArr4);
    }

    boolean c(String str, PublicKey publicKey, String str2, String str3, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return b(str, publicKey, str2.getBytes(StandardCharsets.UTF_8), str3.getBytes(StandardCharsets.UTF_8), bArr);
    }

    boolean b(String str, PublicKey publicKey, byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(publicKey);
        signature.update(bArr);
        signature.update((byte) 46);
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    byte[] a(String str, PrivateKey privateKey, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(str);
        signature.initSign(privateKey);
        signature.update(bArr);
        signature.update((byte) 46);
        signature.update(bArr2);
        return signature.sign();
    }

    byte[] b(String str, byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(str);
        mac.init(new SecretKeySpec(bArr, str));
        mac.update(bArr2);
        mac.update((byte) 46);
        return mac.doFinal(bArr3);
    }

    byte[] d(String str, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(str);
        mac.init(new SecretKeySpec(bArr, str));
        return mac.doFinal(bArr2);
    }

    byte[] b(String str, PrivateKey privateKey, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(str);
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }
}
