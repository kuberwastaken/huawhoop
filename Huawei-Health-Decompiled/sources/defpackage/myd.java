package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class myd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15930a = "RequestMultiSIMServiceInfo";
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private String g = null;
    private String h = null;
    private String i = null;
    private mxs j = null;

    public void a(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.b = str;
    }

    public void i(String str) {
        this.g = str;
    }

    public void b(String str) {
        this.h = str;
    }

    public void c(String str) {
        this.i = str;
    }

    public void e(mxs mxsVar) {
        this.j = mxsVar;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void d(boolean z) {
        this.e = z;
    }

    public JSONObject e() {
        try {
            String str = f15930a;
            mza.e(str, "Build RequestMultiSIMServiceInfo JsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Request", this.f);
            jSONObject.put("PrimaryIDType", this.d);
            jSONObject.put("PrimaryID", this.b);
            jSONObject.put("EuiccPairing", this.e);
            jSONObject.put("LiveIdSupported", this.c);
            String str2 = this.g;
            if (str2 != null) {
                jSONObject.put("SecondaryIDType", str2);
            }
            String str3 = this.h;
            if (str3 != null) {
                jSONObject.put("SecondaryID", str3);
            }
            String str4 = this.i;
            if (str4 != null) {
                jSONObject.put("SecondaryDeviceName", str4);
            }
            mxs mxsVar = this.j;
            if (mxsVar != null) {
                jSONObject.put("DeviceID", mxsVar.e());
            }
            if (mza.e.booleanValue()) {
                mza.e(str, "Build RequestMultiSIMServiceInfo JsonObj result:" + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            mza.c(f15930a, "Build RequestMultiSIMServiceInfo JsonObj occured JSONException");
            return null;
        }
    }
}
