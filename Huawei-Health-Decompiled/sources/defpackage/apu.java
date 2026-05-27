package defpackage;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.ads.adsrec.b0;
import com.huawei.openplatform.abl.log.HiAdLog;
import com.huawei.openplatform.abl.log.UrlAnonymizer;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class apu {
    private static boolean b() {
        return true;
    }

    private static String d(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !b()) {
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            byte[] bArr2 = new byte[12];
            byte[] bArrDecode = Base64.decode(str, 0);
            int length = bArrDecode.length - 12;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArrDecode, 0, bArr2, 0, 12);
            System.arraycopy(bArrDecode, 12, bArr3, 0, length);
            cipher.init(2, secretKeySpec, d(bArr2));
            return new String(cipher.doFinal(bArr3), "UTF-8");
        } catch (Throwable th) {
            th.getClass().getSimpleName();
            return "";
        }
    }

    private static AlgorithmParameterSpec d(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    public static String a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || str.length() < 32 || bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return b() ? d(str, bArr) : "";
        } catch (Throwable th) {
            HiAdLog.w("Aes128", "fail to decrypt: " + th.getClass().getSimpleName());
            UrlAnonymizer.anonymize(b0.a(bArr));
            HiAdLog.printSafeStackTrace(3, th);
            return "";
        }
    }
}
