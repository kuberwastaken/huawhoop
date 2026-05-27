package com.unicom.online.account.kernel;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes8.dex */
public final class u {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
