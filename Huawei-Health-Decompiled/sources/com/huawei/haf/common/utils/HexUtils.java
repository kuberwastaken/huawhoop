package com.huawei.haf.common.utils;

import com.google.common.primitives.UnsignedBytes;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class HexUtils {
    private HexUtils() {
    }

    public static String c(byte[] bArr) {
        return b(bArr, true);
    }

    public static String b(byte[] bArr, boolean z) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length + bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
                sb.append(hexString);
            } else {
                sb.append(hexString);
            }
        }
        String string = sb.toString();
        return z ? string.toUpperCase(Locale.ENGLISH) : string;
    }
}
