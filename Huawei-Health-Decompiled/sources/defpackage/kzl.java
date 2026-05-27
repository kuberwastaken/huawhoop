package defpackage;

import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class kzl {
    private String b = "";
    private int e = 0;

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackConstants$Opers.RESPONSE, this.b);
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
        return "NfcCommandResponse{response='" + this.b + "', errCode='" + this.e + '}';
    }

    public void e(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.e = i;
    }
}
