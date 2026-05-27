package defpackage;

import com.huawei.hwidauth.b.c;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class mju {
    private static String b() {
        EncryptUtil.setBouncycastleFlag(true);
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(8);
        return c.a(strGenerateSecureRandomStr.getBytes(Charset.defaultCharset()), strGenerateSecureRandomStr.length());
    }

    private static SecretKeySpec d(byte[] bArr, int i) {
        if (i <= 0 || i > bArr.length) {
            i = bArr.length;
        }
        if (i > 16) {
            i = 16;
        }
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            bArr2[i2] = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = bArr[i3];
        }
        return new SecretKeySpec(bArr2, 0, 16, "AES/CBC/PKCS5Padding");
    }

    public static String e(byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String strB = b();
        return strB + ":" + c.a(mjt.c(bArr, c.a(strB), d(bArr2, 0)));
    }
}
