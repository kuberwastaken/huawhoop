package defpackage;

import com.huawei.hiai.awareness.client.AwarenessRequest;
import com.huawei.hwlogsmodel.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class lbf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15057a;
    private String b;
    private String c;
    private String d;
    private String e;

    public String b() {
        return this.f15057a;
    }

    public void a(String str) {
        this.f15057a = str;
    }

    public String e() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public String d() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public String c() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String a() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public static lbf e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        lbf lbfVar = new lbf();
        try {
            lbfVar.f15057a = lbw.d(jSONObject, "apduNo");
            lbfVar.c = lbw.d(jSONObject, "apduContent");
            lbfVar.e = lbw.d(jSONObject, "apduStatus");
            lbfVar.d = lbw.d(jSONObject, AwarenessRequest.Field.COMMAND);
            lbfVar.b = lbw.d(jSONObject, "checker");
            return lbfVar;
        } catch (JSONException e) {
            LogUtil.b("ServerAccessApdu", "buildFromJson,JSONException exception:", e.getMessage());
            return null;
        }
    }

    public String toString() {
        return "ServerAccessApdu{apduId='" + this.f15057a + "', apduContent='" + this.c + "', apduStatus='" + this.e + "', command='" + this.d + "', checker='" + this.b + "'}";
    }
}
