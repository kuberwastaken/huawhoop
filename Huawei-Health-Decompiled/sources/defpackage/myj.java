package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class myj {
    private static final String e = "RequesteSIMProfileInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15936a;
    private String c;
    private String d;
    private String f;
    private String h;
    private String g = null;
    private mxs b = null;

    public JSONObject c() {
        try {
            String str = e;
            mza.e(str, "Build RequesteSIMProfileInfo JsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Request", this.f);
            jSONObject.put("Mainid", this.h);
            jSONObject.put("Idtype", this.c);
            String str2 = this.d;
            if (str2 != null) {
                jSONObject.put("EID", str2);
            }
            String str3 = this.f15936a;
            if (str3 != null) {
                jSONObject.put("ICCID", str3);
            }
            String str4 = this.g;
            if (str4 != null) {
                jSONObject.put("IMSI", str4);
            }
            mxs mxsVar = this.b;
            if (mxsVar != null) {
                jSONObject.put("DeviceID", mxsVar.e());
            }
            if (mza.e.booleanValue()) {
                mza.e(str, "Build RequesteSIMProfileInfo JsonObj result:" + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            mza.c(e, "Build RequesteSIMProfileInfo JsonObj occured JSONException");
            return null;
        }
    }
}
