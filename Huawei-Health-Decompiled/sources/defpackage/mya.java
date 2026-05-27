package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class mya {
    private static final String b = "PairedDeviceList";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15927a;
    private String f;
    private String h;
    private String i;
    private String j;
    private int k;
    private String l;
    private String n;
    private mxs c = null;
    private String g = null;
    private String d = null;
    private String e = null;

    public String b() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public String a() {
        return this.n;
    }

    public String d() {
        return this.f15927a;
    }

    public void d(String str) {
        this.f15927a = str;
    }

    public void e(String str) {
        JSONObject jSONObject;
        try {
            if (str == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.j = jSONObject.optString("DevType");
            this.i = jSONObject.optString("ICCID");
            this.f = jSONObject.optString("IMSI");
            this.n = jSONObject.optString("MSISDN");
            this.h = jSONObject.optString("RSPServerAddress");
            this.l = jSONObject.optString("Status");
            this.f15927a = jSONObject.optString("DeviceName");
            this.d = jSONObject.optString("ActivationCode");
            this.e = jSONObject.optString("ConfirmationCode");
            this.k = jSONObject.optInt("MAXReTryTimes");
            this.g = jSONObject.optString("EID");
            mxs mxsVar = new mxs();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("DeviceID");
            if (jSONObjectOptJSONObject != null) {
                mxsVar.b(jSONObjectOptJSONObject.toString());
            }
            this.c = mxsVar;
            if (mza.e.booleanValue()) {
                mza.e(b, "PairedDeviceList to json string = " + jSONObject.toString());
            }
        } catch (JSONException unused) {
            mza.e(b, "Parse response information occured JSONException");
        }
    }

    public String c() {
        return this.g;
    }
}
