package defpackage;

import android.util.ArrayMap;
import com.huawei.hihealthservice.auth.WhiteListApp;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class jwo {
    private Map<String, WhiteListApp> d;

    private jwo() {
        this.d = new ArrayMap(16);
    }

    static class c {
        private static final jwo b = new jwo();
    }

    public static jwo a() {
        return c.b;
    }

    public WhiteListApp d(String str) {
        return this.d.get(str);
    }

    public void c(Map<String, WhiteListApp> map) {
        this.d.clear();
        this.d = map;
    }
}
