package defpackage;

import android.net.Uri;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class tf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17964a;
    private final Uri b;
    private final tj e;

    static tf c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new tf(jSONObject.getInt("status"), tj.b(jSONObject.getString("browserSwitchRequest")), Uri.parse(jSONObject.getString("deepLinkUrl")));
    }

    tf(int i, tj tjVar) {
        this(i, tjVar, null);
    }

    tf(int i, tj tjVar, Uri uri) {
        this.f17964a = i;
        this.e = tjVar;
        this.b = uri;
    }

    public int e() {
        return this.f17964a;
    }

    public JSONObject a() {
        return this.e.d();
    }

    public int d() {
        return this.e.b();
    }

    public Uri bV_() {
        return this.b;
    }

    public String c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", this.f17964a);
        jSONObject.put("deepLinkUrl", this.b.toString());
        jSONObject.put("browserSwitchRequest", this.e.c());
        return jSONObject.toString();
    }
}
