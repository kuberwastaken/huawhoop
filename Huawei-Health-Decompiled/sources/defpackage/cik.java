package defpackage;

import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.huawei.haf.common.exception.ExceptionUtils;
import health.compact.a.LogUtil;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public class cik {
    public cie e(byte[] bArr) throws cid {
        return c(bArr, 0, 0);
    }

    public cie d(byte[] bArr, int i) throws cid {
        return c(bArr, i, 0);
    }

    private cie c(byte[] bArr, int i, int i2) throws cid {
        cie cieVar = new cie();
        if (bArr == null || bArr.length == 0) {
            Log.w("TlvByteUtils", "hexString is null");
            return cieVar;
        }
        if (i >= bArr.length) {
            LogUtil.b("TlvByteUtils", "input position or data is wrong, please check input.");
            return cieVar;
        }
        if (i2 > 50) {
            throw new cid();
        }
        while (i != bArr.length) {
            try {
                byte b = bArr[i];
                if (b == 0) {
                    throw new cid();
                }
                int i3 = i + 1;
                byte[] bArrB = b(bArr, i3);
                int length = i3 + bArrB.length;
                int iD = d(bArrB);
                byte[] bArrArray = ByteBuffer.allocate(iD).put(bArr, length, iD).array();
                i = length + iD;
                if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                    cieVar.c().add(c(bArrArray, 0, i2 + 1));
                } else {
                    cieVar.a().add(new cij(b, iD, bArrArray));
                }
            } catch (IndexOutOfBoundsException e) {
                Log.e("TlvByteUtils", "parseTlv occur exception " + ExceptionUtils.a(e));
                throw new cid();
            }
        }
        return cieVar;
    }

    public cie c(byte[] bArr, TreeSet<Byte> treeSet) throws cid {
        cie cieVar = new cie();
        if (bArr == null || bArr.length == 0 || treeSet == null || treeSet.size() == 0) {
            Log.w("TlvByteUtils", "hexString is null");
            return cieVar;
        }
        int size = treeSet.size();
        int i = 0;
        int i2 = 0;
        while (i != bArr.length) {
            try {
                byte b = bArr[i];
                boolean zContains = treeSet.contains(Byte.valueOf(b));
                int i3 = i + 1;
                byte[] bArrB = b(bArr, i3);
                int length = i3 + bArrB.length;
                int iD = d(bArrB);
                if (zContains) {
                    byte[] bArrArray = ByteBuffer.allocate(iD).put(bArr, length, iD).array();
                    i = length + iD;
                    if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                        Log.w("TlvByteUtils", "(tag & BIT_HIGHEST) == BIT_HIGHEST");
                    } else {
                        cieVar.a().add(new cij(b, iD, bArrArray));
                        i2++;
                        if (i2 == size) {
                            return cieVar;
                        }
                    }
                } else {
                    i = length + iD;
                }
            } catch (IndexOutOfBoundsException unused) {
                throw new cid();
            }
        }
        return cieVar;
    }

    public cie e(byte[] bArr, TreeSet<Byte> treeSet) throws cid {
        cie cieVar = new cie();
        if (bArr == null || bArr.length == 0 || treeSet == null || treeSet.size() == 0) {
            Log.w("TlvByteUtils", "hexString is null");
            return cieVar;
        }
        int size = treeSet.size();
        int i = 0;
        int i2 = 0;
        do {
            try {
                if (i == bArr.length) {
                    return cieVar;
                }
                byte b = bArr[i];
                if (!treeSet.contains(Byte.valueOf(b))) {
                    throw new cid();
                }
                int i3 = i + 1;
                byte[] bArrB = b(bArr, i3);
                int length = i3 + bArrB.length;
                int iD = d(bArrB);
                byte[] bArrArray = ByteBuffer.allocate(iD).put(bArr, length, iD).array();
                i = length + iD;
                if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                    throw new cid();
                }
                cieVar.a().add(new cij(b, iD, bArrArray));
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                throw new cid();
            }
        } while (i2 != size);
        if (i >= bArr.length) {
            return cieVar;
        }
        throw new cid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i) throws cid {
        int i2 = 0;
        int i3 = i;
        while ((bArr[i3] & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
            i3++;
            i2++;
            if (i2 == 3) {
                throw new cid();
            }
        }
        int i4 = i2 + 1;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i4);
        byteBufferAllocate.put(bArr, i, i4);
        return byteBufferAllocate.array();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(byte[] bArr) throws cid {
        byte b;
        int i;
        int length = bArr.length;
        if (length == 1) {
            byte b2 = bArr[0];
            if ((b2 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                return b2;
            }
            throw new cid();
        }
        if (length == 2) {
            byte b3 = bArr[0];
            if ((b3 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                throw new cid();
            }
            b = bArr[1];
            if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                throw new cid();
            }
            i = (b3 & Ascii.DEL) << 7;
        } else if (length == 3) {
            byte b4 = bArr[0];
            if ((b4 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                throw new cid();
            }
            byte b5 = bArr[1];
            if ((b5 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                throw new cid();
            }
            b = bArr[2];
            if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                throw new cid();
            }
            i = ((b4 & Ascii.DEL) << 14) | ((b5 & Ascii.DEL) << 7);
        } else {
            throw new cid();
        }
        return (b & Ascii.DEL) | i;
    }

    public static class a {
        private Map<Byte, byte[]> d = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        public void d(byte b, byte[] bArr) {
            this.d.put(Byte.valueOf(b), bArr);
        }

        public int e(byte b, int i) {
            return chj.e(this.d.get(Byte.valueOf(b)), i);
        }

        public long a(byte b, long j) {
            return chj.b(this.d.get(Byte.valueOf(b)), j);
        }

        public String d(byte b, String str) {
            byte[] bArr = this.d.get(Byte.valueOf(b));
            if (bArr == null || bArr.length == 0) {
                LogUtil.b("TlvByteUtils", "tlv response target type: ", Byte.valueOf(b), ", but no value");
                return str;
            }
            return new String(bArr, StandardCharsets.UTF_8);
        }

        public byte[] c(byte b, byte[] bArr) {
            return this.d.containsKey(Byte.valueOf(b)) ? this.d.get(Byte.valueOf(b)) : bArr;
        }

        public List<a> c(byte b) throws cid {
            if (!this.d.containsKey(Byte.valueOf(b))) {
                return null;
            }
            byte[] bArr = this.d.get(Byte.valueOf(b));
            if (bArr == null || bArr.length == 0) {
                LogUtil.b("TlvByteUtils", "tlv response target type: ", Byte.valueOf(b), ", but no value");
                return null;
            }
            LinkedList linkedList = new LinkedList();
            int i = 0;
            while (i != bArr.length) {
                try {
                    int i2 = i + 1;
                    byte[] bArrB = cik.b(bArr, i2);
                    int length = i2 + bArrB.length;
                    int iD = cik.d(bArrB);
                    byte[] bArrArray = ByteBuffer.allocate(iD).put(bArr, length, iD).array();
                    i = length + iD;
                    linkedList.add(new cik().e(bArrArray, 0));
                } catch (IndexOutOfBoundsException unused) {
                    throw new cid();
                }
            }
            return linkedList;
        }
    }

    public a e(byte[] bArr, int i) throws cid {
        a aVar = new a();
        if (bArr == null || bArr.length == 0) {
            Log.w("TlvByteUtils", "hexString is null");
            return aVar;
        }
        if (i >= bArr.length) {
            LogUtil.b("TlvByteUtils", "input position or data is wrong, please check input.");
            return aVar;
        }
        while (i != bArr.length) {
            try {
                byte b = bArr[i];
                if (b == 0) {
                    throw new cid();
                }
                int i2 = i + 1;
                byte[] bArrB = b(bArr, i2);
                int length = i2 + bArrB.length;
                int iD = d(bArrB);
                byte[] bArrArray = ByteBuffer.allocate(iD).put(bArr, length, iD).array();
                i = length + iD;
                if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                    aVar.d((byte) (b & Ascii.DEL), bArrArray);
                } else {
                    aVar.d(b, bArrArray);
                }
            } catch (IndexOutOfBoundsException unused) {
                throw new cid();
            }
        }
        return aVar;
    }
}
