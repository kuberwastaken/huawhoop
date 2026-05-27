package defpackage;

import android.net.Uri;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class tj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f18005a;
    private boolean b;
    private final int c;
    private Uri d;
    private final String e;
    private final Uri i;

    static tj b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        int i = jSONObject.getInt("requestCode");
        String string = jSONObject.getString("url");
        return new tj(i, Uri.parse(string), jSONObject.optJSONObject("metadata"), jSONObject.has("returnUrlScheme") ? jSONObject.getString("returnUrlScheme") : null, jSONObject.has("appLinkUri") ? Uri.parse(jSONObject.getString("appLinkUri")) : null, jSONObject.optBoolean("shouldNotify", true));
    }

    tj(int i, Uri uri, JSONObject jSONObject, String str, Uri uri2, boolean z) {
        this.i = uri;
        this.c = i;
        this.f18005a = jSONObject;
        this.e = str;
        this.d = uri2;
        this.b = z;
    }

    int b() {
        return this.c;
    }

    JSONObject d() {
        return this.f18005a;
    }

    boolean e() {
        return this.b;
    }

    void e(boolean z) {
        this.b = z;
    }

    String c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestCode", this.c);
        jSONObject.put("url", this.i.toString());
        jSONObject.put("returnUrlScheme", this.e);
        jSONObject.put("shouldNotify", this.b);
        JSONObject jSONObject2 = this.f18005a;
        if (jSONObject2 != null) {
            jSONObject.put("metadata", jSONObject2);
        }
        Uri uri = this.d;
        if (uri != null) {
            jSONObject.put("appLinkUri", uri.toString());
        }
        return jSONObject.toString();
    }

    boolean bU_(Uri uri) {
        return uri.getScheme() != null && uri.getScheme().equalsIgnoreCase(this.e);
    }

    boolean bT_(Uri uri) {
        return this.d != null && uri.getScheme().equals(this.d.getScheme()) && uri.getHost().equals(this.d.getHost());
    }
}
