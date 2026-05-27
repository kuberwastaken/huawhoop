package defpackage;

import health.compact.a.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class vqf {
    public static List<Integer> c(byte[] bArr) {
        ArrayList arrayList = new ArrayList(10);
        if (bArr == null || bArr.length == 0) {
            LogUtil.b("CommandUnpackageUtil", "parseAck, bitmapHex is empty");
            return arrayList;
        }
        StringBuilder sb = new StringBuilder(16);
        for (byte b : bArr) {
            sb.append(new StringBuffer(c(b)).reverse().toString());
        }
        String string = sb.toString();
        for (int i = 0; i < string.length(); i++) {
            if ("0".equalsIgnoreCase(string.charAt(i) + "")) {
                arrayList.add(0);
            } else {
                arrayList.add(1);
            }
        }
        return arrayList;
    }

    private static String c(byte b) {
        return "" + ((int) ((byte) ((b >> 7) & 1))) + ((int) ((byte) ((b >> 6) & 1))) + ((int) ((byte) ((b >> 5) & 1))) + ((int) ((byte) ((b >> 4) & 1))) + ((int) ((byte) ((b >> 3) & 1))) + ((int) ((byte) ((b >> 2) & 1))) + ((int) ((byte) ((b >> 1) & 1))) + ((int) ((byte) (b & 1)));
    }
}
