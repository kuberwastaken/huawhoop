package defpackage;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ua {
    ua() {
    }

    public static String e(JSONObject jSONObject, String str, String str2) {
        return (jSONObject == null || jSONObject.isNull(str)) ? str2 : jSONObject.optString(str, str2);
    }

    static Boolean c(JSONObject jSONObject, String str, Boolean bool) {
        return (jSONObject == null || jSONObject.isNull(str)) ? bool : Boolean.valueOf(jSONObject.optBoolean(str, bool.booleanValue()));
    }
}
