package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class myo {
    private static final String c = "ResponseMultiSIMService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15940a;
    private String b;
    private int e;

    public String d() {
        return this.f15940a;
    }

    public String e() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public void e(String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.f15940a = jSONObject.optString("ManageUrl");
            this.b = jSONObject.optString("PostData");
            this.e = jSONObject.optInt("Timer2");
            if (mza.e.booleanValue()) {
                mza.e(c, "Parse ResponseInfo to jsonObj result:" + jSONObject.toString());
            }
        } catch (JSONException unused) {
            mza.e(c, "Parse ResponseInfo to jsonObj occured JSONException");
        }
    }
}
