package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class vxv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f18831a = new HashMap();
    private String b;
    private String d;

    public vxv(String str, String str2) {
        this.b = str;
        this.d = str2;
    }

    public String e() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public void c(String str, String str2) {
        this.f18831a.put(str, str2);
    }

    public boolean e(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return this.f18831a.isEmpty();
        }
        if (this.f18831a.isEmpty() || map.size() != this.f18831a.size()) {
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!this.f18831a.containsKey(entry.getKey()) || !this.f18831a.get(entry.getKey()).equalsIgnoreCase(entry.getValue())) {
                return false;
            }
            vwc.e("AddressName", "conditionMatch", false);
        }
        return true;
    }
}
