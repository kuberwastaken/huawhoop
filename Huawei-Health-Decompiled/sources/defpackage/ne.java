package defpackage;

import com.alipay.sdk.m.o0.b;
import com.google.common.base.Ascii;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public class ne {
    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(c()));
        return cipher.doFinal(bArr2);
    }

    public static String b(String str) {
        byte[] bArrE;
        try {
            bArrE = e(d(), str.getBytes());
        } catch (Exception unused) {
            bArrE = null;
        }
        if (bArrE != null) {
            return d(bArrE);
        }
        return null;
    }

    public static String c(String str) {
        try {
            return new String(a(d(), e(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] e(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] c() {
        try {
            byte[] bArrA = b.a("IUQSvE6r1TfFPdPEjfklLw==".getBytes("UTF-8"), 2);
            if (bArrA != null) {
                return ni.d(bArrA);
            }
        } catch (Exception unused) {
        }
        return new byte[16];
    }

    public static byte[] d() throws Exception {
        return ni.d(new byte[]{PublicSuffixDatabase.i, 83, -50, -89, -84, -114, 80, 99, 10, Utf8.REPLACEMENT_BYTE, Ascii.SYN, -65, -11, Ascii.RS, 101, -118});
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(c()));
        return cipher.doFinal(bArr2);
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            e(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    public static void e(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }
}
