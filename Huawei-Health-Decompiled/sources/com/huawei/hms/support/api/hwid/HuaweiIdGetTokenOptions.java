package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class HuaweiIdGetTokenOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6149a;
    private boolean b;

    public HuaweiIdGetTokenOptions(String str, boolean z) {
        this.f6149a = str;
        this.b = z;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f6149a)) {
            jSONObject.put("accountName", this.f6149a);
        }
        jSONObject.put("fromGetToken", this.b);
        return jSONObject;
    }

    public static HuaweiIdGetTokenOptions fromJsonObject(JSONObject jSONObject) throws JSONException {
        return new HuaweiIdGetTokenOptions(jSONObject.optString("accountName"), jSONObject.optBoolean("fromGetToken", false));
    }

    public void setAccountName(String str) {
        this.f6149a = str;
    }

    public String getAccountName() {
        return this.f6149a;
    }

    public void setFromGetToken(boolean z) {
        this.b = z;
    }

    public boolean isFromGetToken() {
        return this.b;
    }
}
