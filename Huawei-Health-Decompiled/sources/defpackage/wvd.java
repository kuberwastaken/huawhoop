package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class wvd {
    public static String a(wsu wsuVar) {
        if (wsuVar == null) {
            wrm.b("P2pJsonUtil", "buildMessageExJson message is null");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message_enable_encrypt", wsuVar.d());
        } catch (JSONException unused) {
            wrm.b("P2pJsonUtil", "buildMessageExJson JSONException");
        }
        return jSONObject.toString();
    }
}
