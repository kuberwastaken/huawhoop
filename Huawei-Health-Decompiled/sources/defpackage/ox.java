package defpackage;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ox {
    public static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject[] jSONObjectArr = {jSONObject, jSONObject2};
            for (int i = 0; i < 2; i++) {
                JSONObject jSONObject4 = jSONObjectArr[i];
                if (jSONObject4 != null) {
                    Iterator<String> itKeys = jSONObject4.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject3.put(next, jSONObject4.get(next));
                    }
                }
            }
        } catch (JSONException e) {
            ov.b(e);
        }
        return jSONObject3;
    }

    public static String e(String str) {
        try {
            return JSONObject.quote(str).replace("'", "\\'");
        } catch (Throwable th) {
            ov.d("mspl", "escapeJsonStringError");
            ov.b(th);
            return "";
        }
    }
}
