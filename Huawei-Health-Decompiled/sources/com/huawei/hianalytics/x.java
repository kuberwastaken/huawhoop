package com.huawei.hianalytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<a> f106a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f107b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f108c;
    public String d;
    public String e;
    public String f;
    public String g;

    public int hashCode() {
        return Objects.hash(this.f107b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f107b, ((x) obj).f107b);
    }

    public void a(boolean z) {
        this.f106a.add(new a(z, System.currentTimeMillis()));
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_id", this.f107b);
        jSONObject.put("mc_title", this.f108c);
        jSONObject.put("mc_artist", this.d);
        jSONObject.put("mc_album", this.f);
        jSONObject.put("mc_duration", this.e);
        jSONObject.put("play_start_time", this.f104a);
        jSONObject.put("play_duration", this.b);
        jSONObject.put("favorite_state", this.f4102a);
        jSONObject.put("package_name", this.g);
        return jSONObject;
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f4103a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f109a;

        public a(boolean z, long j) {
            this.f109a = z;
            this.f4103a = j;
        }
    }

    public x(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f105a = jSONObject.optString("_id", "");
        this.f107b = jSONObject.optString("item_id", "");
        this.f108c = jSONObject.optString("mc_title", "");
        this.d = jSONObject.optString("mc_artist", "");
        this.f = jSONObject.optString("mc_album", "");
        this.e = jSONObject.optString("mc_duration", "");
        this.f104a = jSONObject.optLong("play_start_time", 0L);
        this.b = jSONObject.optLong("play_duration", 0L);
        this.f4102a = jSONObject.optInt("favorite_state", 0);
        this.g = jSONObject.optString("package_name", "");
        this.c = jSONObject.optLong("event_time", 0L);
        this.f106a = new ArrayList();
    }

    public x() {
        this.f105a = "";
        this.f107b = "";
        this.f108c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.f104a = 0L;
        this.b = 0L;
        this.f4102a = 0;
        this.g = "";
        this.c = 0L;
        this.f106a = new ArrayList();
    }
}
