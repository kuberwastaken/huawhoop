package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class mxz {
    private static final String e = "PrimaryDevice";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15926a;
    private String b;
    private mxs c = null;
    private String d;

    public String e() {
        return this.f15926a;
    }

    public void e(String str) {
        JSONObject jSONObject;
        try {
            if (str == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.f15926a = jSONObject.optString("MSISDN");
            this.d = jSONObject.optString("IMSI");
            mxs mxsVar = new mxs();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("DeviceID");
            if (jSONObjectOptJSONObject != null) {
                mxsVar.b(jSONObjectOptJSONObject.toString());
            }
            this.c = mxsVar;
            this.b = jSONObject.optString("ServStatus");
            if (mza.e.booleanValue()) {
                mza.e(e, "PrimaryDevice to json string = " + jSONObject.toString());
            }
        } catch (JSONException unused) {
            mza.e(e, "Parse response information occured JSONException");
        }
    }
}
