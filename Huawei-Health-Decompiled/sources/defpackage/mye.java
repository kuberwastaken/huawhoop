package defpackage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class mye {
    private static final String d = "RequestAuthInfo";
    private String b;
    private int h;
    private String i;
    private String j = null;
    private String e = null;
    private String c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private mxs f15931a = null;
    private String g = null;
    private String f = null;

    public void d(int i) {
        this.h = i;
    }

    public void d(String str) {
        this.i = str;
    }

    public void e(String str) {
        this.b = str;
    }

    public void a(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(d());
        if (mza.e.booleanValue()) {
            mza.e(d, "Build RequestAuthInfo JsonObjArray result:" + jSONArray.toString());
        }
        return jSONArray;
    }

    public JSONObject d() {
        try {
            String str = d;
            mza.e(str, "Build RequestAuthInfo JsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReqSN", this.h);
            jSONObject.put("ReqName", this.i);
            jSONObject.put("AuthType", this.b);
            String str2 = this.e;
            if (str2 != null) {
                jSONObject.put("Identity", str2);
            }
            String str3 = this.j;
            if (str3 != null) {
                jSONObject.put("MSISDN", str3);
            }
            String str4 = this.c;
            if (str4 != null) {
                jSONObject.put("AuthToken", str4);
            }
            mxs mxsVar = this.f15931a;
            if (mxsVar != null) {
                jSONObject.put("DeviceID", mxsVar.e());
            }
            String str5 = this.g;
            if (str5 != null) {
                jSONObject.put("TerminalType", str5);
            }
            String str6 = this.f;
            if (str6 != null) {
                jSONObject.put("TerminalVersion", str6);
            }
            if (mza.e.booleanValue()) {
                mza.e(str, "Build RequestAuthInfo JsonObj result:" + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            mza.c(d, "Build RequestAuthInfo JsonObj occured JSONException");
            return null;
        }
    }
}
