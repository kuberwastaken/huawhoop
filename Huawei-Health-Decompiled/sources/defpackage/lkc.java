package defpackage;

import com.huawei.hwdevice.phoneprocess.mgr.common.DataSender;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class lkc {
    private final Map<String, DataSender> c;
    private final DataSender d;

    private lkc(DataSender dataSender, Map<String, DataSender> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.c = concurrentHashMap;
        this.d = (DataSender) Objects.requireNonNull(dataSender, "defaultSender is must be not null");
        if (map != null) {
            concurrentHashMap.putAll(map);
        }
    }

    public DataSender b(String str) {
        return this.c.getOrDefault(str, this.d);
    }

    public void c() {
        this.c.clear();
    }

    public static class c {
        private final Map<String, DataSender> b = new HashMap();
        private DataSender c;

        public c b(DataSender dataSender) {
            this.c = dataSender;
            return this;
        }

        public c e(String str, DataSender dataSender) {
            this.b.put(str, dataSender);
            return this;
        }

        public lkc b() {
            return new lkc(this.c, this.b);
        }
    }
}
