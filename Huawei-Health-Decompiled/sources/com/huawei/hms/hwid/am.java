package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f4826a;
    protected String b;
    protected long c;
    protected String d;

    public String a() {
        return this.f4826a;
    }

    public void b(String str) {
        this.f4826a = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public long b() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public String c() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String d() throws JSONException {
        return e().toString();
    }

    protected JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("appId", this.f4826a);
        jSONObject.putOpt("packageName", this.b);
        jSONObject.put("hmsSdkVersion", this.c);
        jSONObject.putOpt("subAppId", this.d);
        return jSONObject;
    }

    public String toString() {
        return "HuaweiIdCpClientInfo{appId='" + this.f4826a + "', packageName='" + this.b + "', hmsSdkVersion=" + this.c + "', subAppId=" + this.d + '}';
    }
}
