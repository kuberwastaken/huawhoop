package com.huawei.maps.offlinedata.service.device.tlvtools;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public class e {
    public static d a(byte[] bArr) throws g {
        return a(bArr, 0);
    }

    private static d a(byte[] bArr, int i) throws g {
        d dVar = new d();
        if (bArr == null || bArr.length == 0) {
            com.huawei.maps.offlinedata.utils.g.c("TlvByteUtils", "hexString is null");
            return dVar;
        }
        if (i > 50) {
            throw new g();
        }
        int i2 = 0;
        while (i2 != bArr.length) {
            try {
                byte b = bArr[i2];
                if (b == 0) {
                    throw new g();
                }
                int i3 = i2 + 1;
                byte[] bArrB = b(bArr, i3);
                int length = i3 + bArrB.length;
                int iB = b(bArrB);
                byte[] bArrArray = ByteBuffer.allocate(iB).put(bArr, length, iB).array();
                i2 = length + iB;
                if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                    dVar.b().add(a(bArrArray, i + 1));
                } else {
                    dVar.a().add(new f(b, iB, bArrArray));
                }
            } catch (IndexOutOfBoundsException e) {
                com.huawei.maps.offlinedata.utils.g.d("TlvByteUtils", "parseTlv occur exception " + e.getMessage());
                throw new g();
            }
        }
        return dVar;
    }

    private static byte[] b(byte[] bArr, int i) throws g {
        int i2 = 0;
        int i3 = i;
        while ((bArr[i3] & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
            i3++;
            i2++;
            if (i2 == 3) {
                throw new g();
            }
        }
        int i4 = i2 + 1;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i4);
        byteBufferAllocate.put(bArr, i, i4);
        return byteBufferAllocate.array();
    }

    private static int b(byte[] bArr) throws g {
        byte b;
        int i;
        int length = bArr.length;
        if (length == 1) {
            byte b2 = bArr[0];
            if ((b2 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                return b2;
            }
            throw new g();
        }
        if (length == 2) {
            byte b3 = bArr[0];
            if ((b3 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                throw new g();
            }
            b = bArr[1];
            if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                throw new g();
            }
            i = (b3 & Ascii.DEL) << 7;
        } else if (length == 3) {
            byte b4 = bArr[0];
            if ((b4 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                throw new g();
            }
            byte b5 = bArr[1];
            if ((b5 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                throw new g();
            }
            b = bArr[2];
            if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                throw new g();
            }
            i = ((b4 & Ascii.DEL) << 14) | ((b5 & Ascii.DEL) << 7);
        } else {
            throw new g();
        }
        return (b & Ascii.DEL) | i;
    }
}
