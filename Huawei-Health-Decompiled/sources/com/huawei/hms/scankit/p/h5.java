package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h5 implements l8 {
    public int a() {
        return 10;
    }

    public abstract boolean[] a(String str);

    protected static int a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i >= 0 && i2 >= 0) {
            int iA = a();
            if (map != null) {
                u2 u2Var = u2.MARGIN;
                if (map.containsKey(u2Var)) {
                    try {
                        iA = Integer.parseInt(map.get(u2Var).toString());
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException("EncodeHintType MARGIN can not format integer");
                    }
                }
            }
            return a(a(str), i, i2, iA);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
    }

    private static s a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int iMax = Math.max(i, i4);
        int iMax2 = Math.max(1, i2);
        int i5 = iMax / i4;
        int i6 = (iMax - (length * i5)) / 2;
        s sVar = new s(iMax, iMax2);
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                sVar.a(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return sVar;
    }
}
