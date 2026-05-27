package com.huawei.watchface;

import android.text.TextUtils;
import com.huawei.watchface.utils.HwLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11492a = "df";

    private df() {
    }

    public static List<Integer> a(String str) {
        ArrayList arrayList = new ArrayList(10);
        if (TextUtils.isEmpty(str)) {
            HwLog.e(f11492a, "parseAck , bitmapHex is empty");
            return arrayList;
        }
        byte[] bArrA = Cdo.a(str);
        StringBuilder sb = new StringBuilder(16);
        for (byte b : bArrA) {
            sb.append(new StringBuffer(a(b)).reverse().toString());
        }
        String string = sb.toString();
        HwLog.i(f11492a, "parseAck, bufferStr = " + string);
        for (int i = 0; i < string.length(); i++) {
            if ("0".equalsIgnoreCase(string.charAt(i) + "")) {
                arrayList.add(0);
                HwLog.i(f11492a, "errorPackages, error package index = " + i);
            } else {
                arrayList.add(1);
            }
        }
        return arrayList;
    }

    private static String a(byte b) {
        return "" + ((int) ((byte) ((b >> 7) & 1))) + ((int) ((byte) ((b >> 6) & 1))) + ((int) ((byte) ((b >> 5) & 1))) + ((int) ((byte) ((b >> 4) & 1))) + ((int) ((byte) ((b >> 3) & 1))) + ((int) ((byte) ((b >> 2) & 1))) + ((int) ((byte) ((b >> 1) & 1))) + ((int) ((byte) (b & 1)));
    }
}
