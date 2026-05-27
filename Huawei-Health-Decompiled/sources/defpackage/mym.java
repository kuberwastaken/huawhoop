package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class mym {
    private static final String b = "ResponseServiceProvisionInfo";
    private String c;
    private int d;
    private int e;
    private String j = null;
    private String g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private myo f15939a = null;

    public int b() {
        return this.d;
    }

    public String e() {
        return this.j;
    }

    public String a() {
        return this.g;
    }

    public myo d() {
        return this.f15939a;
    }

    public void c(String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.e = jSONObject.optInt("RespSN");
            this.c = jSONObject.optString("ReqName");
            this.d = jSONObject.optInt("ResultCode");
            this.j = jSONObject.optString("WSAddress");
            this.g = jSONObject.optString("WSUrlDataPart");
            myo myoVar = new myo();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("MultiSIMServiceRequestResponse");
            if (jSONObjectOptJSONObject != null) {
                myoVar.e(jSONObjectOptJSONObject.toString());
            }
            this.f15939a = myoVar;
            if (mza.e.booleanValue()) {
                mza.e(b, "Parse ResponseMultiSIMService to jsonObj result:" + jSONObject.toString());
            }
        } catch (JSONException unused) {
            mza.e(b, "Parse ResponseMultiSIMService to jsonObj occured JSONException");
        }
    }
}
