package com.huawei.agconnect.abtest.internal;

import com.huawei.agconnect.abtest.ABTestException;
import com.huawei.agconnect.common.api.Logger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ABTestExperimentInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1726a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("experimentId", this.f1726a);
            jSONObject.put("variantId", this.b);
            jSONObject.put("startTime", this.c);
            jSONObject.put("triggerEventId", this.d);
            jSONObject.put("isTriggerEventReport", this.e);
        } catch (JSONException e) {
            Logger.e("ABTest", "json error", e);
        }
        return jSONObject;
    }

    public boolean d() {
        return this.e;
    }

    String c() {
        return this.b;
    }

    String b() {
        return this.d;
    }

    public void a(boolean z) {
        this.e = z;
    }

    String a() {
        return this.f1726a;
    }

    static ABTestExperimentInfo a(JSONObject jSONObject) {
        String str;
        if (jSONObject.opt("experimentId") == null) {
            str = "not exist experimentId";
        } else if (jSONObject.opt("variantId") == null) {
            str = "not exist variantId";
        } else {
            if (jSONObject.opt("startTime") != null) {
                String strOptString = jSONObject.optString("experimentId");
                String strOptString2 = jSONObject.optString("variantId");
                String strOptString3 = jSONObject.optString("startTime");
                String strOptString4 = jSONObject.optString("triggerEventId");
                boolean zOptBoolean = jSONObject.optBoolean("isTriggerEventReport");
                ABTestExperimentInfo aBTestExperimentInfo = new ABTestExperimentInfo();
                aBTestExperimentInfo.f1726a = strOptString;
                aBTestExperimentInfo.b = strOptString2;
                aBTestExperimentInfo.c = strOptString3;
                aBTestExperimentInfo.d = strOptString4;
                aBTestExperimentInfo.e = zOptBoolean;
                return aBTestExperimentInfo;
            }
            str = "not exist startTime key or format error";
        }
        Logger.e("ABTest", str);
        return null;
    }

    static ABTestExperimentInfo a(Map<String, String> map) throws ABTestException {
        String str = map.get("experimentId");
        if (str == null) {
            throw new ABTestException("not exist experimentId key", 2);
        }
        String str2 = map.get("variantId");
        if (str2 == null) {
            throw new ABTestException("not exist variantId key", 2);
        }
        String str3 = map.get("startTime");
        String str4 = map.get("triggerEventId");
        ABTestExperimentInfo aBTestExperimentInfo = new ABTestExperimentInfo();
        aBTestExperimentInfo.f1726a = str;
        aBTestExperimentInfo.b = str2;
        aBTestExperimentInfo.c = str3;
        aBTestExperimentInfo.d = str4;
        aBTestExperimentInfo.e = false;
        return aBTestExperimentInfo;
    }
}
