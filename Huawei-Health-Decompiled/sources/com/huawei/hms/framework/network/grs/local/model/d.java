package com.huawei.hms.framework.network.grs.local.model;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4745a;
    private Map<String, String> b;

    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("countryGroup", this.f4745a);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.b.keySet()) {
            jSONObject2.put(str, this.b.get(str));
        }
        jSONObject.put("addresses", jSONObject2);
        return jSONObject;
    }

    public String b() {
        return this.f4745a;
    }

    public void a(Map<String, String> map) {
        this.b = map;
    }

    public void a(String str) {
        this.f4745a = str;
    }

    public Map<String, String> a() {
        return this.b;
    }
}
