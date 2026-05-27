package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class vxj extends vxc {
    private static final String d = "GetPassTypeIdInfoRequest";
    private String c;

    public String d() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public JSONObject d(JSONObject jSONObject) {
        if (jSONObject == null) {
            vwc.a(d, "GetPassTypeIdInfoRequest createRequestData params error.", false);
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            if (!vyr.b(d(), true)) {
                jSONObject2.put("passTypeId", d());
            }
            return jSONObject2;
        } catch (JSONException unused) {
            vwc.b(d, "GetPassTypeIdInfoRequest createRequestData, JSONException");
            return null;
        }
    }
}
