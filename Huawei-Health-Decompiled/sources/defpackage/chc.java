package defpackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class chc {
    private static final String[] b;
    private static final String[] c;
    private static final Map<String, String> e = new HashMap();

    static {
        String[] strArr = {"PLAT-760", "HUME", "KANT", "THAL", "SOKR-790A", "DESC-250", "DESC-260", "DESC-270", "DESC-250S", "DESC-260S", "LOK-360", "GOET"};
        c = strArr;
        String[] strArr2 = {"OSCA-550", "OSCA-550A", "OSCA-550X", "OSCA-550AX", "HEGE-550", "HEGE-560", "HEGE-550B", "HEGE-560B"};
        b = strArr2;
        Arrays.stream(strArr).forEach(new Consumer() { // from class: cha
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                chc.e.put("09C", (String) obj);
            }
        });
        Arrays.stream(strArr2).forEach(new Consumer() { // from class: chb
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                chc.e.put("02E", (String) obj);
            }
        });
    }

    public static String a(String str) {
        String str2 = e.get(str);
        return str2 == null ? "09C" : str2;
    }
}
