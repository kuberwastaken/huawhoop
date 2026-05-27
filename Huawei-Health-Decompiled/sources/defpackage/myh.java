package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class myh {
    private static final String c = "ResponseGetDevServInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15934a;
    private String e;
    private int f;
    private int g;
    private int h;
    private String j;
    private mxx b = null;
    private myp i = null;
    private String d = null;

    public String e() {
        return this.e;
    }

    public String d() {
        return this.f15934a;
    }

    public int c() {
        return this.g;
    }

    public mxx b() {
        return this.b;
    }

    public String a() {
        return this.d;
    }

    public void e(String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.f = jSONObject.optInt("RespSN");
            this.j = jSONObject.optString("ReqName");
            this.g = jSONObject.optInt("ResultCode");
            this.e = jSONObject.optString("ManageUrl");
            this.f15934a = jSONObject.optString("PostData");
            mxx mxxVar = new mxx();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("MultiSIMServiceInfo");
            if (jSONObjectOptJSONObject != null) {
                mxxVar.c(jSONObjectOptJSONObject.toString());
            }
            this.b = mxxVar;
            myp mypVar = new myp();
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("eSIMInfo");
            if (jSONObjectOptJSONObject2 != null) {
                mypVar.c(jSONObjectOptJSONObject2.toString());
            }
            this.b = mxxVar;
            this.d = jSONObject.optString("OldTimeStamp");
            this.h = jSONObject.optInt("Timer1");
            if (mza.e.booleanValue()) {
                mza.e(c, "Parse ResponseInfo to jsonObj result:" + jSONObject.toString());
            }
        } catch (JSONException unused) {
            mza.e(c, "ResponseGetDevServInfo-parseResponseInfo JSONException");
        }
    }
}
