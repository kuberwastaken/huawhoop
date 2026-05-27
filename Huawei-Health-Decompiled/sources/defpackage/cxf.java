package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class cxf {
    public static List<Integer> d(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ArrayList arrayList = new ArrayList(bytes.length);
        for (byte b : bytes) {
            arrayList.add(Integer.valueOf(b & UnsignedBytes.MAX_VALUE));
        }
        return arrayList;
    }
}
