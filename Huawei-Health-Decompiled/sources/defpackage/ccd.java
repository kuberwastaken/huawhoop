package defpackage;

import health.compact.a.LogUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ccd {
    private static final Map<String, String> c;

    static {
        HashMap map = new HashMap(5);
        c = map;
        map.put(cej.i.toString(), cej.j.toString());
    }

    public static String c(String str) {
        Map<String, String> map = c;
        if (!map.containsKey(str)) {
            return str;
        }
        String str2 = map.get(str);
        LogUtil.a("CharacteristicConfig", "getCharacteristic ", str, " to ", str2);
        return str2;
    }
}
