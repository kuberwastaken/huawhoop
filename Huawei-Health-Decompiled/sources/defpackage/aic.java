package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class aic implements Serializable {
    private static final aic e = new aic(1, 0, new Object[4]);
    private static final long serialVersionUID = 1;
    private final int b;
    private final int c;
    private final Object[] d;

    private static final int b(int i) {
        if (i <= 5) {
            return 8;
        }
        if (i <= 12) {
            return 16;
        }
        int i2 = 32;
        while (i2 < (i >> 2) + i) {
            i2 += i2;
        }
        return i2;
    }

    private aic(int i, int i2, Object[] objArr) {
        this.b = i;
        this.c = i2;
        this.d = objArr;
    }

    public static <T> aic d(Map<String, T> map) {
        if (map.isEmpty()) {
            return e;
        }
        int iB = b(map.size());
        int i = iB - 1;
        int i2 = (iB >> 1) + iB;
        Object[] objArrCopyOf = new Object[i2 * 2];
        int i3 = 0;
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                int iHashCode = key.hashCode() & i;
                int i4 = iHashCode + iHashCode;
                if (objArrCopyOf[i4] != null) {
                    i4 = ((iHashCode >> 1) + iB) << 1;
                    if (objArrCopyOf[i4] != null) {
                        i4 = (i2 << 1) + i3;
                        i3 += 2;
                        if (i4 >= objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length + 4);
                        }
                    }
                }
                objArrCopyOf[i4] = key;
                objArrCopyOf[i4 + 1] = entry.getValue();
            }
        }
        return new aic(i, i3, objArrCopyOf);
    }

    public Object b(String str) {
        int iHashCode = str.hashCode() & this.b;
        int i = iHashCode << 1;
        Object obj = this.d[i];
        if (obj == str || str.equals(obj)) {
            return this.d[i + 1];
        }
        return a(str, iHashCode, obj);
    }

    private final Object a(String str, int i, Object obj) {
        if (obj == null) {
            return null;
        }
        int i2 = this.b + 1;
        int i3 = ((i >> 1) + i2) << 1;
        Object obj2 = this.d[i3];
        if (str.equals(obj2)) {
            return this.d[i3 + 1];
        }
        if (obj2 != null) {
            int i4 = (i2 + (i2 >> 1)) << 1;
            int i5 = this.c;
            for (int i6 = i4; i6 < i5 + i4; i6 += 2) {
                Object obj3 = this.d[i6];
                if (obj3 == str || str.equals(obj3)) {
                    return this.d[i6 + 1];
                }
            }
        }
        return null;
    }

    public Object a(String str) {
        int length = this.d.length;
        for (int i = 0; i < length; i += 2) {
            Object obj = this.d[i];
            if (obj != null && ((String) obj).equalsIgnoreCase(str)) {
                return this.d[i + 1];
            }
        }
        return null;
    }

    public List<String> c() {
        int length = this.d.length;
        ArrayList arrayList = new ArrayList(length >> 2);
        for (int i = 0; i < length; i += 2) {
            Object obj = this.d[i];
            if (obj != null) {
                arrayList.add((String) obj);
            }
        }
        return arrayList;
    }
}
