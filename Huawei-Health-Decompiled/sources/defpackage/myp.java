package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class myp {
    private static final String d = "ResponseeSIMProfileInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15941a;
    private String b;
    private String c;
    private String e;

    public void c(String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.e = jSONObject.optString("AC_Format");
            this.c = jSONObject.optString("SM-DP+Address");
            this.f15941a = jSONObject.optString("AC_Token");
            this.b = jSONObject.optString("SM-DP+OID");
            if (mza.e.booleanValue()) {
                mza.e(d, "Parse ResponseInfo to jsonObj result:" + jSONObject.toString());
            }
        } catch (JSONException unused) {
            mza.e(d, "ResponseeSIMProfileInfo-parseResponseInfo JSONException");
        }
    }
}
