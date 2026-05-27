package com.huawei.hms.feature.dynamic.f;

import android.util.Base64;
import com.huawei.hms.common.util.Logger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4705a = "Base64";

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            if (bArrDecode != null) {
                return bArrDecode;
            }
        } catch (IllegalArgumentException e) {
            Logger.e(f4705a, "Decoding with Base64 IllegalArgumentException:", e);
        }
        return new byte[0];
    }

    public static String a(byte[] bArr) {
        String strEncodeToString;
        if (bArr == null) {
            return "";
        }
        try {
            strEncodeToString = Base64.encodeToString(bArr, 2);
        } catch (AssertionError e) {
            Logger.e(f4705a, "An exception occurred while encoding with Base64,AssertionError:", e);
        }
        return strEncodeToString != null ? strEncodeToString : "";
    }
}
