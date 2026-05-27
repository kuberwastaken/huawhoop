package defpackage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class naz {
    private static final Gson d = new GsonBuilder().create();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15982a;
    private final Map<String, List<String>> b;
    private final byte[] e;

    public naz() {
        this.b = null;
        this.e = null;
        this.f15982a = 0;
    }

    public naz(Map<String, List<String>> map, byte[] bArr) {
        this.b = map;
        this.e = bArr;
    }

    public naz(Map<String, List<String>> map, byte[] bArr, int i) {
        this.b = map;
        this.e = bArr;
        this.f15982a = i;
    }

    public int e() {
        return this.f15982a;
    }

    public byte[] b() {
        return this.e;
    }

    public String d() {
        return new String(this.e, StandardCharsets.UTF_8);
    }

    public String a() {
        Map<String, List<String>> map = this.b;
        if (map == null || map.isEmpty()) {
            return "{}";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : this.b.entrySet()) {
            List<String> value = entry.getValue();
            if (value != null && !value.isEmpty()) {
                if (value.size() == 1) {
                    linkedHashMap.put(entry.getKey(), value.get(0));
                } else {
                    linkedHashMap.put(entry.getKey(), value);
                }
            }
        }
        return d.toJson(linkedHashMap);
    }

    public String toString() {
        return "ApiResponse{headers=" + this.b + ", body=" + this.e + '}';
    }
}
