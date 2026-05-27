package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class myc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15929a = "RequestGetDevServInfo";
    private String b;
    private String c;
    private String d;
    private String i;
    private int j;
    private String g = null;
    private String f = null;
    private String e = null;

    public void e(int i) {
        this.j = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void h(String str) {
        this.i = str;
    }

    public void j(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public JSONObject e() {
        try {
            String str = f15929a;
            mza.e(str, "Build RequestGetDevServInfo JsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReqSN", this.j);
            jSONObject.put("ReqName", this.c);
            jSONObject.put("PrimaryIDType", this.d);
            jSONObject.put("PrimaryID", this.b);
            jSONObject.put("Services", this.i);
            String str2 = this.g;
            if (str2 != null) {
                jSONObject.put("SecondaryIDType", str2);
            }
            String str3 = this.f;
            if (str3 != null) {
                jSONObject.put("SecondaryID", str3);
            }
            String str4 = this.e;
            if (str4 != null) {
                jSONObject.put("OldTimeStamp", str4);
            }
            if (mza.e.booleanValue()) {
                mza.e(str, "Build RequestGetDevServInfo JsonObj result:" + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            mza.c(f15929a, "Build RequestGetDevServInfo JsonObj occured JSONException");
            return null;
        }
    }
}
