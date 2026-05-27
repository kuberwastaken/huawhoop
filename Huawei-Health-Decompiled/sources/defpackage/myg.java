package defpackage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class myg {
    private static final String e = "RequestAuthSecondInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15933a;
    private String b;
    private int g;
    private String h;
    private int j;
    private mxs d = null;
    private String i = null;
    private String c = null;

    public void b(int i) {
        this.j = i;
    }

    public void e(String str) {
        this.h = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.f15933a = str;
    }

    public JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(c());
        return jSONArray;
    }

    public JSONObject c() {
        try {
            String str = e;
            mza.e(str, "Build RequestAuthSecondInfo JsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReqSN", this.j);
            jSONObject.put("AuthType", this.b);
            jSONObject.put("ReqName", this.h);
            jSONObject.put("Payload", this.f15933a);
            mxs mxsVar = this.d;
            if (mxsVar != null) {
                jSONObject.put("DeviceID", mxsVar.e());
            }
            String str2 = this.i;
            if (str2 != null) {
                jSONObject.put("Sessionid", str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                jSONObject.put("MSISDN", str3);
            }
            jSONObject.put("Timer", this.g);
            if (mza.e.booleanValue()) {
                mza.e(str, "Build RequestAuthSecondInfo JsonObj result:" + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            mza.c(e, "Build RequestAuthSecondInfo JsonObj occured JSONException");
            return null;
        }
    }
}
