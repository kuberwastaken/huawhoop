package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class kzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15019a = "";
    private int e = 0;

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("blockData", this.f15019a);
            jSONObject.put("errCode", this.e);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "BlockData{blockData='" + this.f15019a + "', errCode='" + this.e + '}';
    }

    public void c(String str) {
        if (str == null) {
            return;
        }
        if (!"".equals(this.f15019a)) {
            this.f15019a += "@";
        }
        this.f15019a += str;
    }

    public void c(int i) {
        this.e = i;
    }
}
