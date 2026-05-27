package defpackage;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class xuu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19149a;
    private JSONObject c;

    xuu a(String str) {
        this.f19149a = str;
        return this;
    }

    xuu e(JSONObject jSONObject) {
        this.c = jSONObject;
        return this;
    }

    public String c() {
        return this.f19149a;
    }

    public JSONObject e() {
        return this.c;
    }
}
