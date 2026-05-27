package defpackage;

import com.google.common.primitives.UnsignedBytes;
import com.huawei.hwlogsmodel.LogUtil;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class dte {
    public static String a(int i) {
        if (i < 0) {
            String hexString = Integer.toHexString(i);
            return hexString.substring(hexString.length() - 2, hexString.length());
        }
        if (i >= 16) {
            String hexString2 = Integer.toHexString(i);
            if (hexString2.length() % 2 == 0) {
                return hexString2;
            }
            return "0" + hexString2;
        }
        return "0" + Integer.toHexString(i);
    }

    public static String e(long j) {
        return a((int) ((j >> 56) & 255)) + a((int) ((j >> 48) & 255)) + a((int) ((j >> 40) & 255)) + a((int) ((j >> 32) & 255)) + a((int) ((j >> 24) & 255)) + a((int) ((j >> 16) & 255)) + a((int) ((j >> 8) & 255)) + a((int) (j & 255));
    }

    public static String c(long j) {
        return a((int) ((j >> 24) & 255)) + a((int) ((j >> 16) & 255)) + a((int) ((j >> 8) & 255)) + a((int) (j & 255));
    }

    public static String b(int i) {
        return a((i >> 8) & 255) + a(i & 255);
    }

    public static String h(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String strA = a((int) cCharAt);
            if (cCharAt > 255) {
                sb.append(strA);
            } else {
                sb.append("00" + strA);
            }
        }
        return sb.toString();
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace(" ", "");
        int length = strReplace.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) Integer.parseInt(strReplace.substring(i2, i2 + 2), 16);
            } catch (NumberFormatException unused) {
                LogUtil.a("HEXUtils", "hexToBytes NumberFormatException");
            }
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return c(bArr, bArr.length);
    }

    public static String c(byte[] bArr, int i) {
        if (bArr == null || bArr.length < i) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < i; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append("0");
                sb.append(hexString);
            } else {
                sb.append(hexString);
            }
        }
        return sb.toString().toUpperCase(Locale.US).trim();
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i2]) * 16) + "0123456789ABCDEF".indexOf(charArray[i2 + 1])) & 255);
        }
        try {
            return new String(bArr, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            LogUtil.a("HEXUtils", "hexToString UnsupportedEncodingException");
            return null;
        }
    }

    public static String b(String str) {
        if (str == null) {
            LogUtil.j("HEXUtils", "stringToHex string is null");
            return "";
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            LogUtil.a("HEXUtils", "stringToHex UnsupportedEncodingException");
        }
        for (int i = 0; i < bytes.length; i++) {
            sb.append(charArray[(bytes[i] & 240) >> 4]);
            sb.append(charArray[bytes[i] & 15]);
        }
        return sb.toString().trim();
    }

    public static int h(int i) {
        int i2;
        if (i < 100) {
            i2 = 0;
        } else {
            i2 = i / 100;
            i %= 100;
        }
        try {
            return Integer.parseInt(a(i2) + a(i), 16);
        } catch (NumberFormatException unused) {
            LogUtil.a("HEXUtils", "timeTransferIntToHexStr NumberFormatException");
            return 0;
        }
    }

    public static String c(int i) {
        return b(d(i));
    }

    public static byte[] d(int i) {
        byte[] bArr;
        if (i < 128 && i >= 0) {
            return new byte[]{(byte) (i & 127)};
        }
        if (i < 16384) {
            bArr = new byte[]{(byte) (((i >>> 7) & 127) | 128), (byte) (i & 127)};
        } else {
            if (i >= 2097152) {
                throw new RuntimeException("length overflow, input : " + i + " bigger than 2097152 or smaller than 0");
            }
            bArr = new byte[]{(byte) (((i >>> 14) & 127) | 128), (byte) (((i >>> 7) & 127) | 128), (byte) (i & 127)};
        }
        return bArr;
    }

    public static String a(double d) {
        return b(d(d));
    }

    public static byte[] d(double d) {
        byte[] bArr = new byte[8];
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        for (int i = 0; i < 8; i++) {
            bArr[i] = Long.valueOf(jDoubleToLongBits).byteValue();
            jDoubleToLongBits >>= 8;
        }
        return bArr;
    }

    public static int a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0 || bArr.length > 4) {
            return i;
        }
        int length = bArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 |= (bArr[i3] & UnsignedBytes.MAX_VALUE) << (((length - i3) - 1) * 8);
        }
        return i2;
    }

    public static String b(float f) {
        return c(Float.floatToIntBits(f));
    }

    public static float j(String str) {
        try {
            return Float.intBitsToFloat((int) Long.parseLong(str, 16));
        } catch (NumberFormatException unused) {
            LogUtil.a("HEXUtils", "unit32ToFloat NumberFormatException");
            return 0.0f;
        }
    }

    public static Double e(String str) {
        try {
            return Double.valueOf(Double.longBitsToDouble(new BigInteger(str, 16).longValue()));
        } catch (NumberFormatException unused) {
            LogUtil.a("HEXUtils", "float64ToDouble NumberFormatException");
            return Double.valueOf(0.0d);
        }
    }

    public static byte[] c(String str) {
        if (str == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[0];
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return bArr;
        }
    }

    public static byte[] b(long j) {
        return new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)};
    }

    public static byte[] f(int i) {
        return new byte[]{(byte) (i & 255)};
    }

    public static byte[] i(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] g(int i) {
        byte b = (byte) ((i >> 24) & 255);
        byte b2 = (byte) ((i >> 16) & 255);
        byte b3 = (byte) ((i >> 8) & 255);
        byte b4 = (byte) (i & 255);
        if (b != 0) {
            return new byte[]{b, b2, b3, b4};
        }
        return b2 != 0 ? new byte[]{b2, b3, b4} : b3 != 0 ? new byte[]{b3, b4} : new byte[]{b4};
    }

    public static byte[] e(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }
}
