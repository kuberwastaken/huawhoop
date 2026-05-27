package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class myl {
    private static final String e = "RequestServiceProvisionInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15938a;
    private String d;
    private int g;
    private String i;
    private String b = "ServiceProvisionRequest";
    private myd c = null;
    private myj h = null;

    public void b(int i) {
        this.g = i;
    }

    public void a(String str) {
        this.f15938a = str;
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.i = str;
    }

    public void b(myd mydVar) {
        this.c = mydVar;
    }

    public JSONObject b() {
        try {
            String str = e;
            mza.e(str, "Build RequestServiceProvisionInfo JsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReqSN", this.g);
            jSONObject.put("ReqName", this.b);
            jSONObject.put("PrimaryIDType", this.f15938a);
            jSONObject.put("PrimaryID", this.d);
            jSONObject.put("Services", this.i);
            myd mydVar = this.c;
            if (mydVar != null) {
                jSONObject.put("MultiSIMServiceRequest", mydVar.e());
            }
            myj myjVar = this.h;
            if (myjVar != null) {
                jSONObject.put("eSIMProfileRequest", myjVar.c());
            }
            if (mza.e.booleanValue()) {
                mza.e(str, "Build RequestServiceProvisionInfo JsonObj result:" + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            mza.c(e, "Build RequestServiceProvisionInfo JsonObj occured JSONException");
            return null;
        }
    }
}
