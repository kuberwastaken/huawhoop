package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4824a;

    public af() {
    }

    public af(String str) {
        this.f4824a = str;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", this.f4824a);
            return jSONObject.toString();
        } catch (JSONException unused) {
            as.d("ReadSmsInputBean", "toJson failed", true);
            return null;
        }
    }
}
