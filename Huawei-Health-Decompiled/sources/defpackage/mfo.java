package defpackage;

import com.huawei.hwlogsmodel.LogUtil;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes11.dex */
public final class mfo {
    public static byte[] b(byte[] bArr, byte[] bArr2, SecretKeySpec secretKeySpec) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher.doFinal(bArr);
    }

    public static SecretKeySpec d(byte[] bArr, int i) {
        if (bArr == null) {
            LogUtil.j("Aes", "createKey key null");
            return null;
        }
        if (i <= 0 || i > bArr.length) {
            i = bArr.length;
        }
        if (i > 16) {
            i = 16;
        }
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = bArr[i2];
        }
        return new SecretKeySpec(bArr2, 0, 16, "AES/CBC/PKCS5Padding");
    }
}
