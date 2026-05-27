package defpackage;

import com.huawei.health.device.util.EventBus;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class dmt {
    private static final Map<String, EventBus.b> e = new ConcurrentHashMap();

    public static void c(EventBus.b bVar) {
        if (bVar == null) {
            return;
        }
        e.put(bVar.e(), bVar);
        EventBus.e(bVar);
    }

    public static EventBus.b e(String str) {
        return e.get(str);
    }

    public static EventBus.b b(String str) {
        return e.remove(str);
    }

    public static void e(EventBus.ICallback iCallback, int i, String... strArr) {
        EventBus.d(iCallback, i, strArr);
    }

    public static void c(EventBus.ICallback iCallback, String... strArr) {
        EventBus.d(iCallback, strArr);
    }
}
