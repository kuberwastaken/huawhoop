package defpackage;

import com.huawei.wearengine.auth.AuthInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public class sce {
    private Map<String, AuthInfo> c = new ConcurrentHashMap(16);

    public void c(String str, AuthInfo authInfo) {
        if (str == null || authInfo == null) {
            return;
        }
        if (this.c == null) {
            this.c = new ConcurrentHashMap(16);
        }
        this.c.put(str, authInfo);
    }

    public AuthInfo c(String str) {
        if (str == null) {
            return null;
        }
        if (this.c == null) {
            this.c = new ConcurrentHashMap(6);
        }
        if (!this.c.containsKey(str)) {
            return null;
        }
        AuthInfo authInfo = this.c.get(str);
        this.c.remove(str);
        return authInfo;
    }

    public Map<String, AuthInfo> d() {
        return this.c;
    }
}
