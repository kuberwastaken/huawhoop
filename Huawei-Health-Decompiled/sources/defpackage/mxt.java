package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class mxt {
    private static final String c = "MultiSimUtils";

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02X ", Integer.valueOf(b & UnsignedBytes.MAX_VALUE)));
        }
        return sb.toString();
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(bArr2, "HmacSHA1"));
            byte[] bArrDoFinal = mac.doFinal(bArr);
            mza.e(c, "byteHMAC.length = " + bArrDoFinal.length);
            return bArrDoFinal;
        } catch (InvalidKeyException unused) {
            mza.e(c, "InvalidKeyException");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            mza.e(c, "NoSuchAlgorithmException");
            return null;
        }
    }
}
