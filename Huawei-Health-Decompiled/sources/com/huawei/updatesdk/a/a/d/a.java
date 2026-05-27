package com.huawei.updatesdk.a.a.d;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f11306a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};

    public static String a(byte[] bArr, int i) {
        boolean z;
        char[] cArr = new char[((i + 2) / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = (bArr[i2] & UnsignedBytes.MAX_VALUE) << 8;
            int i5 = i2 + 1;
            boolean z2 = true;
            if (i5 < i) {
                i4 |= bArr[i5] & UnsignedBytes.MAX_VALUE;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i2 + 2;
            if (i7 < i) {
                i6 |= bArr[i7] & UnsignedBytes.MAX_VALUE;
            } else {
                z2 = false;
            }
            char[] cArr2 = f11306a;
            int i8 = 64;
            cArr[i3 + 3] = cArr2[z2 ? i6 & 63 : 64];
            int i9 = i6 >> 6;
            if (z) {
                i8 = i9 & 63;
            }
            cArr[i3 + 2] = cArr2[i8];
            cArr[i3 + 1] = cArr2[(i6 >> 12) & 63];
            cArr[i3] = cArr2[(i6 >> 18) & 63];
            i2 += 3;
            i3 += 4;
        }
        return String.valueOf(cArr);
    }

    public static String a(byte[] bArr) {
        return a(bArr, bArr.length);
    }
}
