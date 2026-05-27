package com.huawei.hms.support.api.entity.account;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class GetAssistTokenRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6144a;
    private String b;
    private String c;

    public GetAssistTokenRequest(String str) {
        this.f6144a = str;
    }

    public String getUserIdentify() {
        return this.b;
    }

    public void setUserIdentify(String str) {
        this.b = str;
    }

    public String getSessionId() {
        return this.c;
    }

    public void setSessionId(String str) {
        this.c = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f6144a)) {
            jSONObject.putOpt("accessToken", this.f6144a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            jSONObject.putOpt(CommonConstant.KEY_USER_IDENTIFY, this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.putOpt("sessionId", this.c);
        }
        return jSONObject.toString();
    }
}
