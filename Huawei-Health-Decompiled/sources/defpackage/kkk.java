package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class kkk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("CONTENT")
    private Map<String, Object> f14725a;

    @SerializedName("from")
    private Map<String, Object> b;

    @SerializedName("pageProperties")
    private List<Map<String, Object>> d;

    @SerializedName("scene")
    private Map<String, Object> e;

    public Map<String, Object> e() {
        return this.f14725a;
    }

    public void b(Map<String, Object> map) {
        this.f14725a = map;
    }

    public List<Map<String, Object>> a() {
        return this.d;
    }

    public void c(List<Map<String, Object>> list) {
        this.d = list;
    }

    public Map<String, Object> d() {
        return this.e;
    }

    public void d(Map<String, Object> map) {
        this.e = map;
    }

    public Map<String, Object> b() {
        return this.b;
    }

    public void e(Map<String, Object> map) {
        this.b = map;
    }

    public void a(Map<String, Object> map, String str) {
        map.put("sessionId", str);
    }

    public String toString() {
        return "HealthRootBiInfo{content=" + this.f14725a + ", pageProperties=" + this.d + ", scene=" + this.e + ", from=" + this.b + '}';
    }
}
