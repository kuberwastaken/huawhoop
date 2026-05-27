package defpackage;

import com.huawei.hihealth.util.HiJsonUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class kgn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Double> f14665a;

    public kgn() {
        this.f14665a = new HashMap();
    }

    public void e(String str, double d) {
        Map<String, Double> map = this.f14665a;
        if (map == null) {
            return;
        }
        map.put(str, Double.valueOf(d));
    }

    public String a() {
        Map<String, Double> map = this.f14665a;
        if (map == null) {
            return null;
        }
        return HiJsonUtil.d(map, Map.class);
    }

    public kgn(String str) {
        this.f14665a = (Map) HiJsonUtil.c(str, Map.class);
    }

    public Map<String, Double> b() {
        return this.f14665a;
    }
}
