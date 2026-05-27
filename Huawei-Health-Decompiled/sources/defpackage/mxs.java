package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class mxs {
    private static final String d = "DeviceID";
    private String c = null;
    private String b = null;
    private String e = null;

    public void d(String str) {
        this.c = str;
    }

    public JSONObject e() {
        try {
            String str = d;
            mza.e(str, "Build DeviceID json Object start");
            JSONObject jSONObject = new JSONObject();
            String str2 = this.c;
            if (str2 != null) {
                jSONObject.put("IMEI", str2);
            }
            String str3 = this.b;
            if (str3 != null) {
                jSONObject.put("MEID", str3);
            }
            String str4 = this.e;
            if (str4 != null) {
                jSONObject.put("SN", str4);
            }
            if (mza.e.booleanValue()) {
                mza.e(str, "Build DeviceID json Object end, json-string:" + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            mza.c(d, "Build DeviceID json occured JSONException.");
            return null;
        }
    }

    void b(String str) {
        JSONObject jSONObject;
        try {
            if (str == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.c = jSONObject.optString("IMEI");
            this.b = jSONObject.optString("MEID");
            this.e = jSONObject.optString("SN");
            if (mza.e.booleanValue()) {
                mza.e(d, "Parse response json info, jsonObj.toString() = " + jSONObject.toString());
            }
        } catch (JSONException unused) {
            mza.e(d, "Parse response json info occured JSONException");
        }
    }
}
