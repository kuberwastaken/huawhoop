package defpackage;

import com.careforeyou.library.enums.Weight_Digit;
import com.careforeyou.library.enums.Weight_Unit;
import com.google.common.primitives.UnsignedBytes;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes3.dex */
public class wh {
    public static int d(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        int i3;
        if (i2 <= 0 || bArr.length < (i3 = i + i2)) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i2];
        for (int i4 = i; i4 < i3; i4++) {
            bArr2[i4 - i] = bArr[i4];
        }
        return bArr2;
    }

    public static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append("0x" + hexString);
            sb.append(",");
        }
        return sb.toString();
    }

    public static int b(byte[] bArr) {
        try {
            return Integer.parseInt(d(bArr), 16);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static byte c(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        while (true) {
            i = (byte) (i + 1);
            if (i > i2) {
                return b;
            }
            b = (byte) (b ^ bArr[i]);
        }
    }

    public static void b(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) (i >> 16);
        bArr[i2 + 2] = (byte) (i >> 8);
        bArr[i2 + 3] = (byte) i;
    }

    public static void e(byte[] bArr, short s, int i) {
        bArr[i] = (byte) (s >> 8);
        bArr[i + 1] = (byte) s;
    }

    public static String b(byte b) {
        return "" + ((int) ((byte) ((b >> 7) & 1))) + ((int) ((byte) ((b >> 6) & 1))) + ((int) ((byte) ((b >> 5) & 1))) + ((int) ((byte) ((b >> 4) & 1))) + ((int) ((byte) ((b >> 3) & 1))) + ((int) ((byte) ((b >> 2) & 1))) + ((int) ((byte) ((b >> 1) & 1))) + ((int) ((byte) (b & 1)));
    }

    public static byte e(byte b) {
        return Byte.parseByte(b(b).substring(7, 8));
    }

    public static byte c(byte b) {
        return Byte.parseByte(b(b).substring(2, 3));
    }

    public static Weight_Unit i(byte b) {
        Weight_Unit weight_Unit = Weight_Unit.KG;
        String strB = b(b);
        if (strB.substring(3, 5).equalsIgnoreCase(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
            return Weight_Unit.JIN;
        }
        if (strB.substring(3, 5).equalsIgnoreCase("10")) {
            return Weight_Unit.LB;
        }
        if (strB.substring(3, 5).equalsIgnoreCase("11")) {
            return Weight_Unit.ST;
        }
        return Weight_Unit.KG;
    }

    public static Weight_Digit a(byte b) {
        Weight_Digit weight_Digit = Weight_Digit.TWO;
        String strB = b(b);
        if (strB.substring(5, 7).equalsIgnoreCase(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
            return Weight_Digit.ZERO;
        }
        if (strB.substring(5, 7).equalsIgnoreCase("10")) {
            return Weight_Digit.ONE;
        }
        return Weight_Digit.TWO;
    }

    public static Weight_Digit j(byte b) {
        Weight_Digit weight_Digit = Weight_Digit.ONE;
        String strB = b(b);
        if (strB.substring(5, 7).equalsIgnoreCase(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
            return Weight_Digit.ZERO;
        }
        if (strB.substring(5, 7).equalsIgnoreCase("10")) {
            return Weight_Digit.TWO;
        }
        return Weight_Digit.ONE;
    }

    public static byte f(byte b) {
        String strB = b(b);
        wi.b("BytesUtil", "getXiangshanCmdId:" + strB);
        return "1010".equalsIgnoreCase(strB.substring(0, 4)) ? (byte) 1 : (byte) 0;
    }

    public static Weight_Unit h(byte b) {
        Weight_Unit weight_Unit = Weight_Unit.KG;
        String strB = b(b);
        if (strB.substring(4, 8).equalsIgnoreCase("0001")) {
            return Weight_Unit.KG;
        }
        if (strB.substring(4, 8).equalsIgnoreCase("0002")) {
            return Weight_Unit.LB;
        }
        if (strB.substring(4, 8).equalsIgnoreCase("0003")) {
            return Weight_Unit.ST;
        }
        if (strB.substring(0, 4).equalsIgnoreCase("0004")) {
            return Weight_Unit.JIN;
        }
        return Weight_Unit.KG;
    }

    public static byte[] a(short s) {
        return new byte[]{(byte) (s >> 8), (byte) s};
    }
}
