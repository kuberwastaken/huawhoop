package ohos.ace.adapter.capability.bridge;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes8.dex */
public class BridgeSerializer {
    private static final int ALMOST = 254;
    private static final boolean IS_LITTLE_ENDIAN;
    private static final String LOG_TAG = "BridgeSerializer";
    private static final int SIZE_ERROR = -1;
    private static final byte T_COMPOSITE_LIST = 14;
    private static final byte T_DOUBLE = 5;
    private static final byte T_FALSE = 2;
    private static final byte T_INT32 = 3;
    private static final byte T_INT64 = 4;
    private static final byte T_LIST_BOOL = 8;
    private static final byte T_LIST_DOUBLE = 11;
    private static final byte T_LIST_INT32 = 9;
    private static final byte T_LIST_INT64 = 10;
    private static final byte T_LIST_STRING = 12;
    private static final byte T_LIST_UINT8 = 7;
    private static final byte T_MAP = 13;
    private static final byte T_NULL = 0;
    private static final byte T_STRING = 6;
    private static final byte T_TRUE = 1;
    private static final String UTF8 = "UTF8";

    static {
        IS_LITTLE_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
    }

    private static int readSize(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            ALog.e("BridgeBinaryCodec", "No buffer left");
            return -1;
        }
        int i = byteBuffer.get() & UnsignedBytes.MAX_VALUE;
        if (i < 254) {
            return i;
        }
        if (i == 254) {
            return byteBuffer.getChar();
        }
        return byteBuffer.getInt();
    }

    private static byte[] readBytes(ByteBuffer byteBuffer) {
        int size = readSize(byteBuffer);
        if (size == -1) {
            return null;
        }
        byte[] bArr = new byte[size];
        byteBuffer.get(bArr);
        return bArr;
    }

    private static void writeInt(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (IS_LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(i >>> 8);
            byteArrayOutputStream.write(i >>> 16);
            byteArrayOutputStream.write(i >>> 24);
            return;
        }
        byteArrayOutputStream.write(i >>> 24);
        byteArrayOutputStream.write(i >>> 16);
        byteArrayOutputStream.write(i >>> 8);
        byteArrayOutputStream.write(i);
    }

    private static void writeLong(ByteArrayOutputStream byteArrayOutputStream, long j) {
        if (IS_LITTLE_ENDIAN) {
            byteArrayOutputStream.write((byte) j);
            byteArrayOutputStream.write((byte) (j >>> 8));
            byteArrayOutputStream.write((byte) (j >>> 16));
            byteArrayOutputStream.write((byte) (j >>> 24));
            byteArrayOutputStream.write((byte) (j >>> 32));
            byteArrayOutputStream.write((byte) (j >>> 40));
            byteArrayOutputStream.write((byte) (j >>> 48));
            byteArrayOutputStream.write((byte) (j >>> 56));
            return;
        }
        byteArrayOutputStream.write((byte) (j >>> 56));
        byteArrayOutputStream.write((byte) (j >>> 48));
        byteArrayOutputStream.write((byte) (j >>> 40));
        byteArrayOutputStream.write((byte) (j >>> 32));
        byteArrayOutputStream.write((byte) (j >>> 24));
        byteArrayOutputStream.write((byte) (j >>> 16));
        byteArrayOutputStream.write((byte) (j >>> 8));
        byteArrayOutputStream.write((byte) j);
    }

    private static void writeAlignment(ByteArrayOutputStream byteArrayOutputStream, int i) {
        int size = byteArrayOutputStream.size() % i;
        if (size != 0) {
            for (int i2 = 0; i2 < i - size; i2++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    private static void writeDouble(ByteArrayOutputStream byteArrayOutputStream, double d) {
        writeLong(byteArrayOutputStream, Double.doubleToLongBits(d));
    }

    private static void writeString(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        try {
            writeBytes(byteArrayOutputStream, obj.toString().getBytes(UTF8));
        } catch (UnsupportedEncodingException unused) {
            ALog.e(LOG_TAG, "writeString failed, UnsupportedEncodingException.");
        }
    }

    private static void writeChar(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (IS_LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(i >>> 8);
        } else {
            byteArrayOutputStream.write(i >>> 8);
            byteArrayOutputStream.write(i);
        }
    }

    private static void writeSize(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (i < 254) {
            byteArrayOutputStream.write(i);
        } else if (i <= 65535) {
            byteArrayOutputStream.write(254);
            writeChar(byteArrayOutputStream, i);
        } else {
            byteArrayOutputStream.write(255);
            writeInt(byteArrayOutputStream, i);
        }
    }

    private static void writeBytes(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        writeSize(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    private static void writeByteBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteBuffer byteBuffer) {
        byteArrayOutputStream.write(7);
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        writeBytes(byteArrayOutputStream, bArr);
    }

    private static void writeBoolArray(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        byteArrayOutputStream.write(8);
        ArrayList arrayList = new ArrayList();
        for (boolean z : (boolean[]) obj) {
            arrayList.add(Boolean.valueOf(z));
        }
        writeSize(byteArrayOutputStream, arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            writeData(byteArrayOutputStream, Boolean.valueOf(((Boolean) it.next()).booleanValue()));
        }
    }

    private static void writeIntArray(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        byteArrayOutputStream.write(9);
        int[] iArr = (int[]) obj;
        writeSize(byteArrayOutputStream, iArr.length);
        writeAlignment(byteArrayOutputStream, 4);
        for (int i : iArr) {
            writeInt(byteArrayOutputStream, i);
        }
    }

    private static void writeLongArray(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        byteArrayOutputStream.write(10);
        long[] jArr = (long[]) obj;
        writeSize(byteArrayOutputStream, jArr.length);
        writeAlignment(byteArrayOutputStream, 8);
        for (long j : jArr) {
            writeLong(byteArrayOutputStream, j);
        }
    }

    private static void writeDoubleArray(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        byteArrayOutputStream.write(11);
        double[] dArr = (double[]) obj;
        writeSize(byteArrayOutputStream, dArr.length);
        writeAlignment(byteArrayOutputStream, 8);
        for (double d : dArr) {
            writeDouble(byteArrayOutputStream, d);
        }
    }

    private static void writeStringArray(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        byteArrayOutputStream.write(12);
        List listAsList = Arrays.asList((String[]) obj);
        writeSize(byteArrayOutputStream, listAsList.size());
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            writeString(byteArrayOutputStream, (String) it.next());
        }
    }

    private static void writeMap(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        byteArrayOutputStream.write(13);
        Map map = (Map) obj;
        writeSize(byteArrayOutputStream, map.size());
        for (Map.Entry entry : map.entrySet()) {
            writeData(byteArrayOutputStream, entry.getKey());
            writeData(byteArrayOutputStream, entry.getValue());
        }
    }

    private static void writeList(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        byteArrayOutputStream.write(14);
        List list = (List) obj;
        writeSize(byteArrayOutputStream, list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            writeData(byteArrayOutputStream, it.next());
        }
    }

    private static void writeObjectArray(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        byteArrayOutputStream.write(14);
        List listAsList = Arrays.asList((Object[]) obj);
        writeSize(byteArrayOutputStream, listAsList.size());
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            writeData(byteArrayOutputStream, it.next());
        }
    }

    public static void writeData(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        if (obj == null) {
            byteArrayOutputStream.write(0);
            return;
        }
        if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
            return;
        }
        if ((obj instanceof Short) || (obj instanceof Integer)) {
            byteArrayOutputStream.write(3);
            writeInt(byteArrayOutputStream, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            byteArrayOutputStream.write(4);
            writeLong(byteArrayOutputStream, ((Long) obj).longValue());
            return;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            byteArrayOutputStream.write(5);
            writeAlignment(byteArrayOutputStream, 8);
            writeDouble(byteArrayOutputStream, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof String) {
            byteArrayOutputStream.write(6);
            writeString(byteArrayOutputStream, obj);
            return;
        }
        if (obj instanceof ByteBuffer) {
            writeByteBuffer(byteArrayOutputStream, (ByteBuffer) obj);
            return;
        }
        if (obj instanceof byte[]) {
            byteArrayOutputStream.write(7);
            writeBytes(byteArrayOutputStream, (byte[]) obj);
            return;
        }
        if (obj instanceof boolean[]) {
            writeBoolArray(byteArrayOutputStream, obj);
            return;
        }
        if (obj instanceof int[]) {
            writeIntArray(byteArrayOutputStream, obj);
            return;
        }
        if (obj instanceof long[]) {
            writeLongArray(byteArrayOutputStream, obj);
            return;
        }
        if (obj instanceof double[]) {
            writeDoubleArray(byteArrayOutputStream, obj);
            return;
        }
        if (obj instanceof String[]) {
            writeStringArray(byteArrayOutputStream, obj);
            return;
        }
        if (obj instanceof Map) {
            writeMap(byteArrayOutputStream, obj);
        } else if (obj instanceof List) {
            writeList(byteArrayOutputStream, obj);
        } else if (obj instanceof Object[]) {
            writeObjectArray(byteArrayOutputStream, obj);
        }
    }

    private static void readAlignment(ByteBuffer byteBuffer, int i) {
        int iPosition = byteBuffer.position() % i;
        if (iPosition != 0) {
            byteBuffer.position((byteBuffer.position() + i) - iPosition);
        }
    }

    private static Object readString(ByteBuffer byteBuffer) {
        byte[] bytes = readBytes(byteBuffer);
        if (bytes == null) {
            return null;
        }
        try {
            return new String(bytes, UTF8);
        } catch (UnsupportedEncodingException unused) {
            ALog.e(LOG_TAG, "readString failed, UnsupportedEncodingException.");
            return null;
        }
    }

    private static ByteBuffer readByteBuffer(ByteBuffer byteBuffer) {
        byte[] bytes = readBytes(byteBuffer);
        if (bytes == null) {
            return null;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bytes.length);
        byteBufferAllocateDirect.put(bytes);
        return byteBufferAllocateDirect;
    }

    private static Object readBoolArray(ByteBuffer byteBuffer) {
        int size = readSize(byteBuffer);
        if (size == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(readData(byteBuffer));
        }
        boolean[] zArr = new boolean[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zArr[i] = ((Boolean) it.next()).booleanValue();
            i++;
        }
        return zArr;
    }

    private static Object readIntArray(ByteBuffer byteBuffer) {
        int size = readSize(byteBuffer);
        if (size == -1) {
            return null;
        }
        int[] iArr = new int[size];
        readAlignment(byteBuffer, 4);
        byteBuffer.asIntBuffer().get(iArr);
        byteBuffer.position(byteBuffer.position() + (size * 4));
        return iArr;
    }

    private static Object readLongArray(ByteBuffer byteBuffer) {
        int size = readSize(byteBuffer);
        if (size == -1) {
            return null;
        }
        long[] jArr = new long[size];
        readAlignment(byteBuffer, 8);
        byteBuffer.asLongBuffer().get(jArr);
        byteBuffer.position(byteBuffer.position() + (size * 8));
        return jArr;
    }

    private static Object readDoubleArray(ByteBuffer byteBuffer) {
        int size = readSize(byteBuffer);
        if (size == -1) {
            return null;
        }
        double[] dArr = new double[size];
        readAlignment(byteBuffer, 8);
        byteBuffer.asDoubleBuffer().get(dArr);
        byteBuffer.position(byteBuffer.position() + (size * 8));
        return dArr;
    }

    private static Object readStringArray(ByteBuffer byteBuffer) {
        int size = readSize(byteBuffer);
        if (size == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(readString(byteBuffer));
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    private static Object readMap(ByteBuffer byteBuffer) {
        int size = readSize(byteBuffer);
        if (size == -1) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < size; i++) {
            map.put(readData(byteBuffer), readData(byteBuffer));
        }
        return map;
    }

    private static Object readList(ByteBuffer byteBuffer) {
        int size = readSize(byteBuffer);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(readData(byteBuffer));
        }
        return arrayList;
    }

    public static Object readData(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        if (b == 0) {
            return null;
        }
        if (b == 1) {
            return true;
        }
        if (b == 2) {
            return false;
        }
        if (b == 3) {
            return Integer.valueOf(byteBuffer.getInt());
        }
        if (b == 4) {
            return Long.valueOf(byteBuffer.getLong());
        }
        if (b == 5) {
            readAlignment(byteBuffer, 8);
            return Double.valueOf(byteBuffer.getDouble());
        }
        if (b == 6) {
            return readString(byteBuffer);
        }
        if (b == 7) {
            return readByteBuffer(byteBuffer);
        }
        if (b == 8) {
            return readBoolArray(byteBuffer);
        }
        if (b == 9) {
            return readIntArray(byteBuffer);
        }
        if (b == 10) {
            return readLongArray(byteBuffer);
        }
        if (b == 11) {
            return readDoubleArray(byteBuffer);
        }
        if (b == 12) {
            return readStringArray(byteBuffer);
        }
        if (b == 13) {
            return readMap(byteBuffer);
        }
        if (b == 14) {
            return readList(byteBuffer);
        }
        return null;
    }
}
